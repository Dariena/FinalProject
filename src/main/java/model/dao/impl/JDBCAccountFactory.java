package model.dao.impl;

import model.dao.AccountDao;
import model.dao.mapper.AccountMapper;
import model.dao.mapper.ReviewMapper;
import model.entity.Account;
import model.entity.Review;

import java.sql.*;
import java.util.*;

public class JDBCAccountFactory implements AccountDao {

    private Connection connection;
    private static final String SQL_INSERT = "INSERT INTO account (firstNameUk,surNameUk,firstNameUa,surNameUa,role,password, email, phone) values(?,?,?,?,?,?,?,?)";



    public JDBCAccountFactory(Connection connection) {

        this.connection = connection;
    }

    @Override
    public Account create(Account entity) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
            preparedStatement.setString(1, entity.getNameUk());
            preparedStatement.setString(2, entity.getSurnameUk());
            preparedStatement.setString(3, entity.getNameUa());
            preparedStatement.setString(4, entity.getSurnameUa());
            preparedStatement.setString(5, entity.getRole().toString());
            preparedStatement.setString(6, entity.getPassword());
            preparedStatement.setString(7, entity.getEmail());
            preparedStatement.setString(8, entity.getPhone());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    return entity;
    }

    @Override
    public Account findById(int id) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        Map<Integer, Account> accounts = new HashMap<>();

        final String query = "select * from account";

        try(Statement st = connection.createStatement()){

            ResultSet rs = st.executeQuery(query);

            AccountMapper accountMapper = new AccountMapper();

            while(rs.next()) {
                Account account = accountMapper.extractFromResultSet(rs);
                accountMapper.makeUnique(accounts, account);
            }

            return new ArrayList<>(accounts.values());

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    @Override
    public void update(Account user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Optional<Account> findByEmail(String email) {
        Optional<Account> result = Optional.empty();

        String query = "SELECT * FROM account WHERE email = ?";

        try(PreparedStatement ps = connection.prepareCall(query)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            AccountMapper userMapper = new AccountMapper();

            if (rs.next()) {
                result = Optional.of(userMapper.extractFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }



    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
