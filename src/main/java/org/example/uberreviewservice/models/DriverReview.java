package org.example.uberreviewservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "driver_review_id")
public class DriverReview extends Review{
    private String driverReviewComment;
}
