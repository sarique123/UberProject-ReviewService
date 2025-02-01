package org.example.uberreviewservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "passenger_review_id")
public class PassengerReview extends Review{
    private String passengerReviewComment;
}
