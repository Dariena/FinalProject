package model.dao.impl;

import model.dao.ReviewDao;
import model.dao.mapper.ReviewMapper;
import model.entity.Account;
import model.entity.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCReviewFactory implements ReviewDao {

    private Connection connection;
    private static final String SQL_INSERT = "INSERT INTO review (content,date, account_email) values(?,?,?)";
    private static final String SQL_FIND_ALL = "select * from review";

    public JDBCReviewFactory(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Review create(Review entity, Account account) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getContent());
            preparedStatement.setDate(2, entity.getDate());
            preparedStatement.setString(3, account.getEmail());

            preparedStatement.execute();

        }

        catch (SQLException e) {
            e.printStackTrace();
        }


        return entity;
    }

    @Override
    public List<Review> find(String email) {
        return null;
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

        Map<Integer, Review> reviews = new HashMap<>();

        try(Statement st = connection.createStatement()){

            return getReviewsByMapper(reviews, st.executeQuery(SQL_FIND_ALL));

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Review> getReviewsByMapper(Map<Integer, Review> reviews, ResultSet rs) throws SQLException {

        ReviewMapper reviewMapper = new ReviewMapper();

        while(rs.next()) {
            Review review = reviewMapper.extractFromResultSet(rs);
            reviewMapper.makeUnique(reviews, review);
        }

        return new ArrayList<>(reviews.values());
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
