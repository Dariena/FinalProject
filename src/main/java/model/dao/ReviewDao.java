package model.dao;

import model.entity.Review;

import java.util.List;


public interface ReviewDao extends GenericDao<Review> {
    List<Review> getLatestReview();


}
