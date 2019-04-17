package model.dao;

import model.entity.Account;
import model.entity.Request;
import model.entity.Review;
import model.entity.enums.Role;
import model.entity.enums.State;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public interface RequestDao extends GenericDao<Request> {

    Request create(Request request, Account account, Account managerAccount);
    //Optional<Account> findByEmail(String email);
    List<Request> find(String email);
    List<Request> findByState(String email, State state);
    void update(Request req, Account account);
    List<Request> findAll();
    int findSize();
    List<Request> findWithLimit(int offset, int limit);

}
