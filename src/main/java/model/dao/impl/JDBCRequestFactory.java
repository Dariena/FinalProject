package model.dao.impl;

import model.dao.RequestDao;
import model.dao.mapper.RequestMapper;
import model.entity.Account;
import model.entity.Request;

import java.sql.*;
import java.util.*;

public class JDBCRequestFactory implements RequestDao {
    private static final String SQL_INSERT = "INSERT INTO request (content,date,comment,accepted) values(?,?,?,?)";
    private static final String SQL_INSERT_REQ = "INSERT INTO account_has_request (emailaccount,request_idrequest) values(?,?),(?,?)";
    private static final String SQL_UPDATE = "UPDATE request SET comment = ?, accepted = ? WHERE idrequest = ?";
    private Connection connection;

    public JDBCRequestFactory(Connection connection) {
        this.connection = connection;
    }



    @Override
    public Request create(Request entity, Account account) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getContent());
            preparedStatement.setDate(2, entity.getDate());
            preparedStatement.setString(3, entity.getComment());
            //entity.setAccepted(State.UNREAD);
            preparedStatement.setString(4, entity.getAccepted().toString());

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            int requestId = 0;
            if (resultSet.next())
                requestId = resultSet.getInt(1);
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_REQ);
            statement.setString(1, account.getEmail());
            statement.setInt(2, requestId);
            statement.setString(3, "demchuk.dasha@gmail.com");
            statement.setInt(4, requestId);
            statement.execute();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public List<Request> find(String email) {
        List<Request> requests = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        String query = "SELECT request_idrequest FROM account_has_request WHERE emailaccount = ?";

        try(PreparedStatement ps = connection.prepareCall(query)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                list.add(rs.getInt(1));
            }
            for(Integer list1: list){
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
        try(PreparedStatement st = connection.prepareCall(query)){
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();

            RequestMapper requestMapper = new RequestMapper();

            if(rs.next()) {
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

        try(Statement st = connection.createStatement()){

            ResultSet rs = st.executeQuery(query);

            RequestMapper requestMapper = new RequestMapper();

            while(rs.next()) {
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
    public void update(Request request) {

        try(PreparedStatement st = connection.prepareCall(SQL_UPDATE)){
            st.setString(1,request.getComment());
            st.setString(2,request.getAccepted().name());
            st.setInt(3,request.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }


    }


    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }

}
