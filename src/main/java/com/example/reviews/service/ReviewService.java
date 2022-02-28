package com.example.reviews.service;

import com.example.reviews.model.Review;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findAll();
    Review save(Review review);
    Iterable<Review> save(List<Review> reviews);
    List<Review> filter(String sortByRating, Integer minRating, String sortByDate, String prioritize);
}

