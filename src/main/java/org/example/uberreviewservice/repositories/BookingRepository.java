package org.example.uberreviewservice.repositories;

import org.example.uberreviewservice.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
