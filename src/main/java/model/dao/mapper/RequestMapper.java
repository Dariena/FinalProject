package model.dao.mapper;

import model.entity.Request;
import model.entity.enums.State;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class RequestMapper implements ObjectMapper<Request> {
    @Override
    public Request extractFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("idrequest");
        String content = rs.getString("content");
        State accepted = State.valueOf(rs.getString("accepted"));
        String comment = rs.getString("comment");
        Date date = new Date(System.currentTimeMillis());

        return new Request(id, content, date, accepted, comment);
    }

    @Override
    public Request makeUnique(Map<Integer, Request> existing, Request entity) {
        existing.putIfAbsent(entity.getId(), entity);

        return existing.get(entity.getId());
    }
}
