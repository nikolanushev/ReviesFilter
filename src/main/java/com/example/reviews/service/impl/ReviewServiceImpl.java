package com.example.reviews.service.impl;

import com.example.reviews.model.Review;
import com.example.reviews.repository.ReviewRepository;
import com.example.reviews.service.ReviewService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAll() {
        return this.reviewRepository.findAll();
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Iterable<Review> save(List<Review> reviews) {
        return reviewRepository.saveAll(reviews);
    }

    @Override
    public List<Review> filter(String sortByRating, Integer minRating, String sortByDate, String prioritize) {
        List<Review> reviews = new ArrayList<>();
//        List<Review> nulls = this.reviewRepository.findAllByReviewTextIsNull();
//        List<Review> notNulls = this.reviewRepository.findAllByReviewTextIsNotNull();
//        notNulls.addAll(nulls);
        if (sortByRating.equals("Highest First")) {
            reviews = this.reviewRepository.findByOrderByRatingDesc();
        } else if (sortByRating.equals("Lowest First")) {
            reviews = this.reviewRepository.findByOrderByRatingAsc();
        }
        if (minRating != null) {
            reviews = this.reviewRepository.findByRatingGreaterThanEqual(minRating);
        }

        return reviews;
    }
}
