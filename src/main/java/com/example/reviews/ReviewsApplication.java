package com.example.reviews;

import com.example.reviews.model.Review;
import com.example.reviews.service.ReviewService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class ReviewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReviewsApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ReviewService reviewService){
        return args -> {
            //read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Review>> typeReference = new TypeReference<List<Review>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/reviews.json");
            try{
                List<Review> reviews = mapper.readValue(inputStream, typeReference);
                reviewService.save(reviews);
                System.out.println("Reviews saved!");
            } catch (IOException e) {
                System.out.println("Unable to save reviews: " + e.getMessage());
            }
        };
    }
}
