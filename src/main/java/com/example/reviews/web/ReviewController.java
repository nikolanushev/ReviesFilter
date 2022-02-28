package com.example.reviews.web;

import com.example.reviews.model.Review;
import com.example.reviews.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping({"/", "/reviews", "/reviews/list"})
    public String getReviewsPage(@RequestParam(required = false) String sortByRating,
                                 @RequestParam(required = false) Integer minRating,
                                 @RequestParam(required = false) String sortByDate,
                                 @RequestParam(required = false) String prioritize, Model model){
        List<Review> reviews;
        if(sortByRating == null && minRating == null && sortByDate == null && prioritize == null){
            reviews = this.reviewService.findAll();
        } else {
            reviews = this.reviewService.filter(sortByRating, minRating, sortByDate, prioritize);
        }
        model.addAttribute("reviews", reviews);
        return "list.html";
    }
}
