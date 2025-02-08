package org.example.uberreviewservice.services;

import org.example.uberreviewservice.models.Review;
import org.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    private final  ReviewRepository reviewRepository;
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review findReviewById(Long id) {
        return reviewRepository.findById(id).get();
    }

    public List<Review> findAllReviews(Double rating) {
        if(rating != null){
            return reviewRepository.findAllByRatingLessThanEqual(rating);
        }
        return reviewRepository.findAll();
    }

    public Review createReview(Review review){
        return reviewRepository.save(review);
    }

    public void deleteReviewById(Long id){
        try{
            reviewRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
