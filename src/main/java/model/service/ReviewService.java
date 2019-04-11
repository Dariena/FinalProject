package model.service;

import model.dao.DaoFactory;
import model.dao.ReviewDao;
import model.entity.Review;

import java.util.List;

public class ReviewService {
    DaoFactory daoFactory = DaoFactory.getInstance();


    /*public List<Review> (){
        try (ReviewDao dao = daoFactory.createReviewDao()){
            return dao.getLatestReview();
        }
    }*/
}
