package model.service;

import model.dao.AccountDao;
import model.dao.DaoFactory;
import model.dao.RequestDao;
import model.entity.Account;
import model.entity.Request;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class RequestService {
    private List<Request> requestList = new ArrayList<>();
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public Request create(Request request, Account account) {
        Request result;

        try (RequestDao requestDao = daoFactory.createRequestDao()) {
            result = requestDao.create(request, account);
        }

        return result;
    }

    public void update(Request request){

        try (RequestDao requestDao = daoFactory.createRequestDao()) {
            requestDao.update(request);
        }
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
        return DaoFactory.getInstance().createAccountDao().findByEmail(email).get();
    }
}
