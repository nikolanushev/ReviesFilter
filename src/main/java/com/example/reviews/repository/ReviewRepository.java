package com.example.reviews.repository;

import com.example.reviews.model.Review;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByOrderByRatingAsc();
    List<Review> findByOrderByRatingDesc();
    List<Review> findByRatingGreaterThanEqual(Integer minRating);
    List<Review> findAllByReviewTextIsNotNull();
    List<Review> findAllByReviewTextIsNull();

}
