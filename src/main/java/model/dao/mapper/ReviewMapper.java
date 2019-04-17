package model.dao.mapper;

import model.entity.Review;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class ReviewMapper implements ObjectMapper<Review>  {
    @Override
    public Review extractFromResultSet(ResultSet rs) throws SQLException {
        Review review = new Review();
        review.setId(rs.getInt("idreview"));
        review.setContent(rs.getString("content"));
        LocalDateTime localDateTime = rs.getTimestamp("date").toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        review.setDate(new Date(System.currentTimeMillis()));
        review.setEmail(rs.getString("account_email"));

        return review;
    }

    @Override
    public Review makeUnique (Map<Integer, Review> existing, Review entity) {
        existing.putIfAbsent(entity.getId(), entity);

        return existing.get(entity.getId());

    }
}
