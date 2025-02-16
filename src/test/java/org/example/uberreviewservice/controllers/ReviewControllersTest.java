package org.example.uberreviewservice.controllers;


import org.example.uberreviewservice.DTOs.CreateReviewDto;
import org.example.uberreviewservice.Utils.SuccessResponse;
import org.example.uberreviewservice.adapters.CreateReviewDtoToReviewAdapterImpl;
import org.example.uberreviewservice.models.Booking;
import org.example.uberreviewservice.models.Review;
import org.example.uberreviewservice.services.ReviewServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReviewControllersTest {

    @InjectMocks
    private ReviewControllers reviewControllers;

    @Mock
    private ReviewServiceImpl reviewServiceImpl;

    @Mock
    private CreateReviewDtoToReviewAdapterImpl createReviewDtoToReviewAdapter;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetReviewById_Success(){

         long Id = 11L;
         Review review = Review.builder().build();
         review.setId(Id);

         // mocking
         when(reviewServiceImpl.findReviewById(Id)).thenReturn(Optional.of(review));

         // perform the test
         ResponseEntity<?> response = reviewControllers.getReviewById(Id);

         // assertions
         assertEquals(HttpStatus.OK,response.getStatusCode());
         SuccessResponse<Review> returnedResponse = (SuccessResponse<Review>) response.getBody();
         assertEquals(Id, returnedResponse.getData().getId());
    }

    @Test
    public void testCreateReview_Success(){
        CreateReviewDto reviewDto = new CreateReviewDto();
        Booking booking = Booking.builder().build();
        booking.setId(1L);
        reviewDto.setBookingId(booking.getId());


        Review incomingReview = Review.builder()
                .content("Good ride")
                .rating(4.5)
                .booking(booking)
                .build();

        // mocking
        when(createReviewDtoToReviewAdapter.convertDto(reviewDto)).thenReturn(incomingReview);

        Review savedReview = Review.builder()
                        .content(incomingReview.getContent())
                        .rating(incomingReview.getRating())
                        .booking(incomingReview.getBooking())
                        .build();

        // mocking
        when(reviewServiceImpl.createReview(incomingReview)).thenReturn(savedReview);

        // Perform Test
        ResponseEntity<?> response = reviewControllers.createReview(reviewDto);

        // assertions
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
    }
}
