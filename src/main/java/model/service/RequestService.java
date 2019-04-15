package model.service;

import model.dao.AccountDao;
import model.dao.DaoFactory;
import model.dao.RequestDao;
import model.entity.Account;
import model.entity.Request;

public class RequestService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public Request create(Request request, Account account) {
        Request result;

        try (RequestDao requestDao = daoFactory.createRequestDao()) {
            result = requestDao.create(request, account);
        }

        return result;
    }
}
