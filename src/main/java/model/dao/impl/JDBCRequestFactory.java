package model.dao.impl;

import model.dao.RequestDao;
import model.entity.Request;
import model.entity.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JDBCRequestFactory implements RequestDao {
    private static final String SQL_INSERT = "INSERT INTO request (content,date,comment,accepted) values(?,?,?,?)";

    private Connection connection;

    public JDBCRequestFactory(Connection connection) {
        this.connection = connection;
    }



    @Override
    public Request create(Request entity) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
            preparedStatement.setString(1, entity.getContent());
            preparedStatement.setDate(2, entity.getDate());
            preparedStatement.setString(3, entity.getComment());
            preparedStatement.setBoolean(4, entity.isAccepted());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
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
