package model.dao.impl;

import model.dao.ReviewDao;
import model.dao.mapper.ReviewMapper;
import model.entity.Review;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCReviewFactory implements ReviewDao {

    private Connection connection;

    public JDBCReviewFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Review create(Review entity) {
        return entity;
    }

    @Override
    public Review findById(int id) {
        return null;
    }

    @Override
    public List<Review> findAll() {
        Map<Integer, Review> reviews = new HashMap<>();

        final String query = "select * from review";

        try(Statement st = connection.createStatement()){

            ResultSet rs = st.executeQuery(query);

            ReviewMapper reviewMapper = new ReviewMapper();

            while(rs.next()) {
                Review review = reviewMapper.extractFromResultSet(rs);
                reviewMapper.makeUnique(reviews, review);
            }

            return new ArrayList<>(reviews.values());

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<Review> getLatestReview() {

        Map<Integer, Review> reviews = new HashMap<>();

        final String query = "select * from review order by date";

        try(Statement st = connection.createStatement()){

            ResultSet rs = st.executeQuery(query);

            ReviewMapper reviewMapper = new ReviewMapper();

            while (rs.next()){
                Review review = reviewMapper.extractFromResultSet(rs);
                reviewMapper.makeUnique(reviews, review);
            }

            return new ArrayList<>(reviews.values());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update(Review reviews) {

    }

    @Override
    public void delete(int id) {

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
