package org.example.uberreviewservice.services;

import org.example.uberreviewservice.models.Booking;
import org.example.uberreviewservice.models.BookingStatus;
import org.example.uberreviewservice.models.Review;
import org.example.uberreviewservice.repositories.BookingRepository;
import org.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository){

        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("*****************");
//
//        Review r = Review.builder()
//                .content("Amazing ride quality")
//                .rating(5.0)
//                .build(); // code to create plain java object
////        reviewRepository.save(r);  // this code executes sql query
//
//        Booking b = Booking.builder()
//                .startTime(new Date())
//                .endTime(new Date())
//                .TotalDistance(10L)
//                .bookingStatus(BookingStatus.COMPLETED)
//                .review(r)
//                .build();
//
//        bookingRepository.save(b);
//
//        List<Review> reviews = reviewRepository.findAll();
//
//        for(Review review : reviews){
//            System.out.println(review.getContent());
//        }
        //reviewRepository.deleteById(1L);


        Booking booking = bookingRepository.findById(1L).get();
        if(booking != null){
            bookingRepository.delete(booking);
        }

    }
}
