package model.dao.mapper;

import model.entity.Review;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class ReviewMapper implements ObjectMapper<Review>  {
    @Override
    public Review extractFromResultSet(ResultSet rs) throws SQLException {
        Review review = new Review();
        review.setId(rs.getInt("id"));
        review.setContent(rs.getString("context"));
        LocalDateTime localDateTime = rs.getTimestamp("time").toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        review.setDate(localDateTime.format(formatter));

        return review;
    }

    @Override
    public Review makeUnique (Map<Integer, Review> existing, Review entity) {
        existing.putIfAbsent(entity.getId(), entity);

        return existing.get(entity.getId());

    }
}
