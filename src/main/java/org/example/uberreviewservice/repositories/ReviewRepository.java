package org.example.uberreviewservice.repositories;
import org.example.uberprojectentityservice.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {

    Integer countAllByRatingLessThanEqual(Double rating);

    List<Review> findAllByRatingLessThanEqual(Double rating);

    List<Review> findAllByCreatedAtBefore(Date createdAt);

    @Query("select r from Booking b inner join Review r where b.id = :bookingId")
    Review findReviewByBookingId(Long bookingId);
}
