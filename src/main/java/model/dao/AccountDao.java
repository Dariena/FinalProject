package model.dao;

import model.entity.Account;
import java.util.Optional;

public interface AccountDao extends GenericDao<Account> {

    Optional<Account> findByEmail(String email);
    Account create(Account entity);
}
