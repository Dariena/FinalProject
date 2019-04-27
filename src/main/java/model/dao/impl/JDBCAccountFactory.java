package model.dao.impl;

import model.dao.AccountDao;
import model.dao.mapper.AccountMapper;
import model.entity.Account;
import model.entity.enums.Role;

import java.sql.*;
import java.util.*;

public class JDBCAccountFactory implements AccountDao {

    private Connection connection;
    private static final String SQL_INSERT = "INSERT INTO account (firstNameUk,surNameUk,firstNameUa,surNameUa,role,password, email, phone) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_ACC_WITH_MIN_REC = "SELECT *  FROM account_has_request RIGHT JOIN  account ON account.email = account_has_request.emailaccount WHERE role=? group by emailaccount ORDER BY count(emailaccount) asc";
    private static final String SQL_FIND_BY_EMAIL = "SELECT * FROM account WHERE email = ?";
    private static final String SQL_FIND_ALL = "select * from account";

    JDBCAccountFactory(Connection connection) {

        this.connection = connection;
    }

    @Override
    public Account create(Account entity) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
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
    public Optional<Account> findAccountWithMinRequests(Role role) {

        Optional<Account> result = Optional.empty();
        try (PreparedStatement ps = connection.prepareCall(SQL_ACC_WITH_MIN_REC)) {

            ps.setString(1, role.name());
            ResultSet rs = ps.executeQuery();

            AccountMapper userMapper = new AccountMapper();

            if (rs.next()) {
                result = Optional.ofNullable(userMapper.extractFromResultSet(rs));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }

    }

    @Override
    public Account findById(int id) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        Map<Integer, Account> accounts = new HashMap<>();

        try (Statement st = connection.createStatement()) {

            ResultSet rs = st.executeQuery(SQL_FIND_ALL);

            AccountMapper accountMapper = new AccountMapper();

            while (rs.next()) {
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
        try (PreparedStatement ps = connection.prepareCall(SQL_FIND_BY_EMAIL)) {
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
    public List<String> findByIdEmail(int id) {
        List<String> email = new ArrayList<>();
        try (PreparedStatement st = connection.prepareCall(SQL_FIND_BY_ID_EMAIL)) {
            st.setString(1, Role.MASTER.name());
           /* st.setString(2, Role.USER.name());*/
            st.setInt(2, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                email.add(rs.getString(1));
            }

            return email;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
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
