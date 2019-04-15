package model.dao.impl;

import model.dao.RequestDao;
import model.entity.Account;
import model.entity.Request;
import model.entity.Review;

import java.sql.*;
import java.util.List;

public class JDBCRequestFactory implements RequestDao {
    private static final String SQL_INSERT = "INSERT INTO request (content,date,comment,accepted) values(?,?,?,?)";
    private static final String SQL_INSERT_REQ = "INSERT INTO account_has_request (emailaccount,request_idrequest) values(?,?)";

    private Connection connection;

    public JDBCRequestFactory(Connection connection) {
        this.connection = connection;
    }



    @Override
    public Request create(Request entity, Account account) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getContent());
            preparedStatement.setDate(2, entity.getDate());
            preparedStatement.setString(3, entity.getComment());
            preparedStatement.setBoolean(4, entity.isAccepted());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            int requestId = 0;
            if (resultSet.next())
                requestId = resultSet.getInt(1);
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_REQ);
            statement.setString(1, account.getEmail());
            statement.setInt(2, requestId);
            statement.execute();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public Request create(Request entity) {
        return null;
    }

    @Override
    public Request findById(int id) {
        return null;
    }

    @Override
    public List<Request> findAll() {
        return null;
    }

    @Override
    public void update(Request request) {

    }


    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }

}
