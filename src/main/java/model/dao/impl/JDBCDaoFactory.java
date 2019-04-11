package model.dao.impl;

import model.dao.DaoFactory;
import model.dao.RequestDao;
import model.dao.AccountDao;
import model.dao.ReviewDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();


    private Connection getConnection() {
        try{
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ReviewDao createReviewDao() {
        return new JDBCReviewFactory(getConnection());
    }

    @Override
    public AccountDao createAccountDao() {
        return new JDBCAccountFactory(getConnection());
    }

    @Override
    public RequestDao createRequestDao() {
        return new JDBCRequestFactory(getConnection());
    }
}
