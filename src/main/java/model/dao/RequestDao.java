package model.dao;

import model.entity.Account;
import model.entity.Request;
import model.entity.Review;

import java.util.List;

public interface RequestDao extends GenericDao<Request> {

    Request create(Request request, Account account);

}
