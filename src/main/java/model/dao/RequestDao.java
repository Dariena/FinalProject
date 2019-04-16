package model.dao;

import model.entity.Account;
import model.entity.Request;
import model.entity.Review;

import java.util.List;
import java.util.Optional;

public interface RequestDao extends GenericDao<Request> {

    Request create(Request request, Account account);
    //Optional<Account> findByEmail(String email);
    List<Request> find(String email);

}
