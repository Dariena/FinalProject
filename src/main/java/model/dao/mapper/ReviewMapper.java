package model.dao.mapper;

import model.entity.Review;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ReviewMapper implements ObjectMapper<Review> {
    @Override
    public Review extractFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("idreview");
        String content = rs.getString("content");
        Date date = new Date(System.currentTimeMillis());
        String email = rs.getString("account_email");

        return new Review(id, date, content, email);

    }

    @Override
    public Review makeUnique(Map<Integer, Review> existing, Review entity) {
        existing.putIfAbsent(entity.getId(), entity);

        return existing.get(entity.getId());

    }
}
