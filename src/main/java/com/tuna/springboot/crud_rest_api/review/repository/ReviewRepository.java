package com.tuna.springboot.crud_rest_api.review.repository;

import com.tuna.springboot.crud_rest_api.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
