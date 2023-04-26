package com.tuna.springboot.crud_rest_api.review.rest;

import com.tuna.springboot.crud_rest_api.review.entity.Review;
import com.tuna.springboot.crud_rest_api.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {
	private final ReviewService reviewService;
	
	@Autowired
	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@GetMapping("/reviews")
	public List<Review> findAll() {
		return this.reviewService.findAll();
	}
	
	@GetMapping("/reviews/{reviewId}")
	public Review findById(@PathVariable int reviewId) {
		Review theReview = this.reviewService.findById(reviewId);
		
		if (theReview == null) {
			throw new RuntimeException("Review id not found -" + reviewId);
		}
		
		return theReview;
	}
	
	@PostMapping("/reviews")
	public Review addBook(@RequestBody Review theReview) {
		theReview.setId(0);
		
		return this.reviewService.save(theReview);
	}
	
	@PutMapping("/reviews")
	public Review updateBook(@RequestBody Review theReview) {
		return this.reviewService.save(theReview);
	}
	
	@DeleteMapping("/reviews/{reviewId}")
	public String deleteBook(@PathVariable int reviewId) {
		Review tempReview = this.reviewService.findById(reviewId);
		
		if (tempReview == null) {
			throw new RuntimeException("Review id not found" + reviewId);
		}
		
		this.reviewService.deleteById(reviewId);
		
		return "Delete review id -" + reviewId;
	}
}
