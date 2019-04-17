package model.service;

import model.dao.DaoFactory;
import model.dao.RequestDao;
import model.dao.ReviewDao;
import model.entity.Account;
import model.entity.Request;
import model.entity.Review;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ReviewService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public Review create(Review review, Account account) {
        Review result;

        try (ReviewDao reviewDao = daoFactory.createReviewDao()) {
            result = reviewDao.create(review, account);
        }

        return result;
    }

    public Account getCurrentAccount(HttpServletRequest request) {
        String email = (String) request.getSession().getAttribute("email");
        return DaoFactory.getInstance().createAccountDao().findByEmail(email).get();
    }

    public List<Review> show(){
        List<Review> result;
        try (ReviewDao reviewDao = daoFactory.createReviewDao()) {
            result = reviewDao.findAll();
        }


        return result;
    }
    /*public List<Review> (){
        try (ReviewDao dao = daoFactory.createReviewDao()){
            return dao.getLatestReview();
        }
    }*/
}
