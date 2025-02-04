package org.example.uberreviewservice.services;

import org.example.uberreviewservice.models.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    public Review findReviewById(Long id);

    public List<Review> findAllReviews();

    public boolean deleteReviewById(Long id);
}
