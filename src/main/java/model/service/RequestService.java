package model.service;

import model.dao.AccountDao;
import model.dao.DaoFactory;
import model.dao.RequestDao;
import model.entity.Account;
import model.entity.Request;
import model.entity.enums.Role;
import model.entity.enums.State;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RequestService {
    private List<Request> requestList = new ArrayList<>();
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public Request create(Request request, Account account) {
        Request result;

        try (RequestDao requestDao = daoFactory.createRequestDao()) {
            result = requestDao.create(request, account, getManagerForRequest(Role.MANAGER).get());
        }

        return result;
    }


    public void update(Request request){

        try (RequestDao requestDao = daoFactory.createRequestDao()) {

            requestDao.update(request, getManagerForRequest(Role.MASTER).get());
        }
    }

    // TODO remove
    public List<Request> showByState(HttpServletRequest request, State state){
        List<Request> result;
        try (RequestDao requestDao = daoFactory.createRequestDao()) {
            result = requestDao.findByState(getCurrentAccount(request).getEmail(), state);
        }


        return result;
    }
    public List<Request> show(HttpServletRequest request){
        List<Request> result;
        try (RequestDao requestDao = daoFactory.createRequestDao()) {
            result = requestDao.find(getCurrentAccount(request).getEmail());
        }


        return result;
    }
    public Account getCurrentAccount(HttpServletRequest request) {
        String email = (String) request.getSession().getAttribute("email");
        Account result;
        try (AccountDao accountDao = daoFactory.createAccountDao()) {
            result = accountDao.findByEmail(email).get();
        }
        return result;
    }
    public Optional<Account> getManagerForRequest(Role role){
        Optional<Account> result;
        try (AccountDao accountDao = daoFactory.createAccountDao()) {
            result = accountDao.findAccountWithMinRequests(role);
        }
        return result;
    }
    public List<Request> findAll() {
        List<Request> result;
        try (RequestDao requestDao = daoFactory.createRequestDao()) {
            result = requestDao.findAll();
        }
        return result;
    }

    public int findSize(String email, String state) {
        int result;
        try (RequestDao requestDao = daoFactory.createRequestDao()) {
            result = requestDao.findSize(email, state);
        }
        return result;
    }

    public List<Request> findWithLimit(int offset, int limit, Account account, String state) {
        List<Request> result;
        try (RequestDao requestDao = daoFactory.createRequestDao()) {
            result = requestDao.findWithLimit(offset, limit, account, state);
        }
        return result;

    }

}
