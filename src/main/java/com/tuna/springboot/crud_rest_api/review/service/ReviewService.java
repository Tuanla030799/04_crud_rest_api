package com.tuna.springboot.crud_rest_api.review.service;


import com.tuna.springboot.crud_rest_api.review.entity.Review;

import java.util.List;

public interface ReviewService {
	List<Review> findAll();
	
	Review findById(int theId);
	
	Review save(Review theReview);
	
	void deleteById(int theId);
}
