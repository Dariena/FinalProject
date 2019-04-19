package model.dao.impl;

import model.dao.RequestDao;
import model.dao.mapper.RequestMapper;
import model.entity.Account;
import model.entity.Request;
import model.entity.enums.State;

import java.sql.*;
import java.util.*;

public class JDBCRequestFactory implements RequestDao {
    private static final String SQL_INSERT = "INSERT INTO request (content,date,comment,accepted) values(?,?,?,?)";
    private static final String SQL_INSERT_REQ = "INSERT INTO account_has_request (emailaccount,request_idrequest) values(?,?),(?,?)";
    private static final String SQL_INSERT_MASTER = "INSERT INTO account_has_request (emailaccount,request_idrequest) values(?,?)";
    private static final String SQL_UPDATE = "UPDATE request SET comment = ?, accepted = ? WHERE idrequest = ?";
    private static final String SQL_UPDATE_STATE = "UPDATE request SET accepted = ? WHERE idrequest = ?";
    private static final String SQL_FIND_LIMIT_CONFERENCE =
            "SELECT * FROM account_has_request accreq " +
                    "LEFT JOIN request req ON accreq.request_idrequest = req.idrequest " +
                    "WHERE emailaccount = ? AND (accepted = ?) LIMIT ? OFFSET ?";

    private static final String SQL_GET_SIZE = "SELECT COUNT(*) FROM account_has_request accreq " +
            "LEFT JOIN request req ON accreq.request_idrequest = req.idrequest " +
            "WHERE emailaccount = ? AND (accepted = ? or accepted is not null)";
    private Connection connection;

    JDBCRequestFactory(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Request create(Request entity, Account account, Account managerAccount) {

        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
           // connection.setAutoCommit(false);
            preparedStatement.setString(1, entity.getContent());
            preparedStatement.setDate(2, entity.getDate());
            preparedStatement.setString(3, entity.getComment());
            preparedStatement.setString(4, entity.getAccepted().toString());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            int requestId = 0;
            if (resultSet.next())
                requestId = resultSet.getInt(1);
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_REQ);
            statement.setString(1, account.getEmail());
            statement.setInt(2, requestId);
            statement.setString(3, managerAccount.getEmail());
            statement.setInt(4, requestId);
            statement.execute();
            //connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public List<Request> find(String email) {
        List<Request> requests = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        String query = "SELECT request_idrequest FROM account_has_request WHERE emailaccount = ?";

        try (PreparedStatement ps = connection.prepareCall(query)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            for (Integer list1 : list) {
                requests.add(findById(list1));
            }
            return requests;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public Request create(Request entity) {
        return null;
    }

    @Override
    public Request findById(int id) {
        Request request = new Request();
        final String query = "select * from request where idrequest = ?";
        try (PreparedStatement st = connection.prepareCall(query)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            RequestMapper requestMapper = new RequestMapper();

            if (rs.next()) {
                request = requestMapper.extractFromResultSet(rs);
            }

            return request;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public List<Request> findAll() {
        Map<Integer, Request> requests = new HashMap<>();

        final String query = "select * from request";

        try (Statement st = connection.createStatement()) {

            ResultSet rs = st.executeQuery(query);


            RequestMapper requestMapper = new RequestMapper();

            while (rs.next()) {
                Request request = requestMapper.extractFromResultSet(rs);
                requestMapper.makeUnique(requests, request);
            }

            return new ArrayList<>(requests.values());

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int findSize(String email, String state) {
        int result = 0;
        try (PreparedStatement st = connection.prepareCall(SQL_GET_SIZE)) {
            st.setString(1, email);
            st.setString(2, state);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                result = rs.getInt(1);
            }

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public void update(Request request) {

    }


    @Override
    public void update(Request request, Account accountMaster) {

        String query = SQL_UPDATE;
        if (request.getComment() == null)
            query = SQL_UPDATE_STATE;
        try (PreparedStatement st = connection.prepareCall(query)) {
            //connection.setAutoCommit(false);
            if (query.equals(SQL_UPDATE)) {
                st.setString(1, request.getComment());
                st.setString(2, request.getAccepted().name());
                st.setInt(3, request.getId());
            } else {
                st.setString(1, request.getAccepted().name());
                st.setInt(2, request.getId());
            }
            st.executeUpdate();
            if (request.getAccepted().name().equals("ACCEPTED")) {

                PreparedStatement statement = connection.prepareCall(SQL_INSERT_MASTER);
                statement.setString(1, accountMaster.getEmail());
                statement.setInt(2, request.getId());

                statement.execute();
            }
            //connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Request> findWithLimit(int offset, int limit, Account account, String state) {
        List<Request> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_LIMIT_CONFERENCE)) {
            preparedStatement.setString(1, account.getEmail());
            preparedStatement.setString(2, state);
            preparedStatement.setInt(3, limit);
            preparedStatement.setInt(4, offset);
            ResultSet resultSet = preparedStatement.executeQuery();

            RequestMapper requestMapper = new RequestMapper();
            while (resultSet.next()) {
                result.add(requestMapper.extractFromResultSet(resultSet));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
