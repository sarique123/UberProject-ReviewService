package org.example.uberreviewservice.services;

import org.example.uberreviewservice.models.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReviewService {
    public Optional<Review> findReviewById(Long id);

    public List<Review> findAllReviews(Double rating);

    public void deleteReviewById(Long id);
}
