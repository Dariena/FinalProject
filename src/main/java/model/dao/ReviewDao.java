package model.dao;

import model.entity.Account;
import model.entity.Review;

import java.util.List;


public interface ReviewDao extends GenericDao<Review> {
    List<Review> getLatestReview();
    Review create(Review request, Account account);
    List<Review> find(String email);


}
