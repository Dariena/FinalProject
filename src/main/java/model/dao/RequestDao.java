package model.dao;

import model.entity.Account;
import model.entity.Request;
import model.entity.enums.State;

import java.util.List;

public interface RequestDao extends GenericDao<Request> {

    Request create(Request request, Account account, Account managerAccount);
    List<Request> find(String email);
    List<Request> findByState(String email, State state);
    void update(Request req, Account account);
    List<Request> findAll();
    int findSize(String email, String state);
    List<Request> findWithLimit(int offset, int limit,Account account, String state);
}
