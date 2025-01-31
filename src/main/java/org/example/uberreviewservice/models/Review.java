package org.example.uberreviewservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Review {
    @Id
    Long id;
}
