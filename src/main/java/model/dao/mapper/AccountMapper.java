package model.dao.mapper;

import model.entity.Account;
import model.entity.enums.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class AccountMapper implements ObjectMapper<Account> {
    @Override
    public Account extractFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("idaccount");
        String nameUk = rs.getString("firstNameUk");
        String surnameUk = rs.getString("surNameUk");
        String nameUa = rs.getString("firstNameUa");
        String surnameUa = rs.getString("surNameUa");
        String email = rs.getString("email");
        String password = rs.getString("password");
        Role role = Role.valueOf(rs.getString("role"));

        return new Account(id, role, nameUk, surnameUk, nameUa, surnameUa, email, password);
    }

    @Override
    public Account makeUnique(Map<Integer, Account> existing, Account entity) {
        existing.putIfAbsent(entity.getId(), entity);

        return existing.get(entity.getId());
    }
}