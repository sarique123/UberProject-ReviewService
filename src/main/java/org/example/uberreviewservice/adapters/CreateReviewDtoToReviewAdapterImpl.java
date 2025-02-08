package org.example.uberreviewservice.adapters;

import org.example.uberreviewservice.DTOs.CreateReviewDto;
import org.example.uberreviewservice.models.Booking;
import org.example.uberreviewservice.models.Review;
import org.example.uberreviewservice.repositories.BookingRepository;
import org.springframework.stereotype.Component;


@Component
public class CreateReviewDtoToReviewAdapterImpl implements CreateReviewDtoToReviewAdapter {
    private BookingRepository bookingRepository;
    public CreateReviewDtoToReviewAdapterImpl(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Review convertDto(CreateReviewDto createReviewDto) {
        Booking booking = bookingRepository.findById(createReviewDto.getBookingId()).get();
        if(booking == null){
            return null;
        }
        Review review = Review.builder()
                .content(createReviewDto.getContent())
                .rating(createReviewDto.getRating())
                .booking(booking)
                .build();
        return review;
    }
}
