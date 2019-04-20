package model.dao;

import model.entity.Account;
import model.entity.Request;

import java.sql.SQLException;
import java.util.List;

public interface RequestDao extends GenericDao<Request> {

    Request create(Request request, Account account, Account managerAccount);
    List<Request> find(String email);
    void update(Request req, Account account);
    List<Request> findAll();
    int findSize(String email, List<String> states);
    List<Request> findWithLimit(int offset, int limit,Account account, List<String> states);
}
