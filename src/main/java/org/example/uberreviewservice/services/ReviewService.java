package org.example.uberreviewservice.services;

import org.example.uberreviewservice.models.Review;
import org.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;
    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("*****************");

        Review r = Review.builder()
                .content("Average ride quality")
                .rating(4.0)
                .build(); // code to create plain java object
        reviewRepository.save(r);  // this code executes sql query

        List<Review> reviews = reviewRepository.findAll();

        for(Review review : reviews){
            System.out.println(review.getContent());
        }
        reviewRepository.deleteById(1L);
    }
}
