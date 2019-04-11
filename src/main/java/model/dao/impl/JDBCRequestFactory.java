package model.dao.impl;

import model.dao.RequestDao;
import model.entity.Request;
import model.entity.Review;

import java.sql.Connection;
import java.util.List;

public class JDBCRequestFactory implements RequestDao {

    private Connection connection;

    public JDBCRequestFactory(Connection connection) {
        this.connection = connection;
    }



    @Override
    public Review create(Review entity) {
        return null;
    }

    @Override
    public Review findById(int id) {
        return null;
    }

    @Override
    public List<Review> findAll() {
        return null;
    }

    @Override
    public void update(Review review) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
