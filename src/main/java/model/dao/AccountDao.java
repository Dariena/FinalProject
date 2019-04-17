package model.dao;

import model.entity.Account;
import model.entity.enums.Role;

import java.util.List;
import java.util.Optional;

public interface AccountDao extends GenericDao<Account> {

    Optional<Account> findByEmail(String email);
    Account create(Account entity);
   // List<Account> findByRole(Role role);
    Optional<Account> findAccountWithMinRequests(Role role);
}
