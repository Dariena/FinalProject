package model.service;

import model.dao.AccountDao;
import model.dao.DaoFactory;
import model.entity.Account;

import javax.servlet.ServletContext;
import java.util.Optional;

public class UserService {


    DaoFactory daoFactory = DaoFactory.getInstance();

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



    public boolean validateData(Account account){

        return true;
    }


}
