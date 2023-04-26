package com.tuna.springboot.crud_rest_api.review.service;

import com.tuna.springboot.crud_rest_api.review.entity.Review;
import com.tuna.springboot.crud_rest_api.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private final ReviewRepository reviewRepository;
	
	@Autowired
	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
	
	@Override
	public List<Review> findAll() {
		return this.reviewRepository.findAll();
	}
	
	@Override
	public Review findById(int theId) {
		Optional<Review> result = this.reviewRepository.findById(theId);
		
		Review theReview = null;
		
		if (result.isPresent()) {
			theReview = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find c id - " + theId);
		}
		
		return theReview;
	}
	
	@Override
	public Review save(Review theReview) {
		return this.reviewRepository.save(theReview);
	}
	
	@Override
	public void deleteById(int theId) {
		this.reviewRepository.deleteById(theId);
	}
}
