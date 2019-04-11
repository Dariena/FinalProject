package model.dao.mapper;

import model.entity.Request;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class RequestMapper implements ObjectMapper<Request> {
    @Override
    public Request extractFromResultSet(ResultSet rs) throws SQLException {
        Request request = new Request();
        request.setId(rs.getInt("idrequest"));
        request.setAccepted(rs.getBoolean("accepted"));
        request.setComment(rs.getString("comment"));
        LocalDateTime localDateTime = rs.getTimestamp("date").toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd-MM-yyyy");
        request.setDate(localDateTime.format(formatter));

        return request;
    }

    @Override
    public Request makeUnique(Map<Integer, Request> existing, Request entity) {
        existing.putIfAbsent(entity.getId(), entity);

        return existing.get(entity.getId());
    }
}
