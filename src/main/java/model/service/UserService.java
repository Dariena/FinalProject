package model.service;

import model.dao.AccountDao;
import model.dao.DaoFactory;
import model.dao.RequestDao;
import model.entity.Account;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

public class UserService {


    private DaoFactory daoFactory = DaoFactory.getInstance();

    public Optional<Account> login(String email) {
        Optional<Account> result;

        try (AccountDao accountDao = daoFactory.createAccountDao()) {
            result = accountDao.findByEmail(email);
        }

        return result;
    }

    public Account create(Account account) {
        Account result;

        try (AccountDao accountDao = daoFactory.createAccountDao()) {
            result = accountDao.create(account);
        }

        return result;
    }

    public boolean exists(Account account) {
        boolean result;
        try (AccountDao accountDao = daoFactory.createAccountDao()) {
            result = accountDao.findByEmail(account.getEmail()).isPresent();
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


    public boolean validateData(Account account) {

        return true;
    }
    public List<String> findByIdEmail(int id) {
        List<String> email;

        try (AccountDao accountDao = daoFactory.createAccountDao()) {
            email = accountDao.findByIdEmail(id);
        }

        return email;
    }


}
