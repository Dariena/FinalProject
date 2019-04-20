package model.service;

import model.dao.AccountDao;
import model.dao.DaoFactory;
import model.dao.RequestDao;
import model.entity.Account;
import model.entity.Request;
import model.entity.enums.Role;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class RequestService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private UserService userService = new UserService();

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

    public List<Request> show(HttpServletRequest request){
        List<Request> result;
        try (RequestDao requestDao = daoFactory.createRequestDao()) {
            result = requestDao.find(userService.getCurrentAccount(request).getEmail());
        }


        return result;
    }

    private Optional<Account> getManagerForRequest(Role role){
        Optional<Account> result;
        try (AccountDao accountDao = daoFactory.createAccountDao()) {
            result = accountDao.findAccountWithMinRequests(role);
        }
        return result;
    }


    public int findSize(String email, List<String> states) {
        int result;
        try (RequestDao requestDao = daoFactory.createRequestDao()) {
            result = requestDao.findSize(email, states);
        }
        return result;
    }

    public List<Request> findWithLimit(int offset, int limit, Account account, List<String> states) {
        List<Request> result;
        try (RequestDao requestDao = daoFactory.createRequestDao()) {
            result = requestDao.findWithLimit(offset, limit, account, states);
        }
        return result;

    }
    public void delete(int id){
        try (RequestDao requestDao = daoFactory.createRequestDao()) {

            requestDao.delete(id);
        }
    }

}
