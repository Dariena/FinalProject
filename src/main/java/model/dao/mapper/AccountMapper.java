package model.dao.mapper;

import model.entity.Account;
import model.entity.enums.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class AccountMapper implements ObjectMapper<Account>{
    @Override
    public Account extractFromResultSet(ResultSet rs) throws SQLException {
        Account account = new Account();

            account.setId(rs.getInt("idaccount"));
            account.setNameUk(rs.getString("firstNameUk"));
            account.setSurnameUk(rs.getString("surNameUk"));
            account.setNameUa(rs.getString("firstNameUa"));
            account.setSurnameUa(rs.getString("surNameUa"));
            account.setEmail(rs.getString("email"));
            account.setPassword(rs.getString("password"));
            account.setRole(Role.valueOf(rs.getString("role")));
        return account;
    }

    @Override
    public Account makeUnique(Map<Integer, Account> existing, Account entity) {
        existing.putIfAbsent(entity.getId(), entity);

        return existing.get(entity.getId());
    }
}