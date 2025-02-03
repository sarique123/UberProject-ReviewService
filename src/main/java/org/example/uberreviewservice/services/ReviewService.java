package org.example.uberreviewservice.services;

import jakarta.transaction.Transactional;
import org.example.uberreviewservice.models.Booking;
import org.example.uberreviewservice.models.Driver;
import org.example.uberreviewservice.repositories.BookingRepository;
import org.example.uberreviewservice.repositories.DriverRepository;
import org.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ReviewService implements CommandLineRunner {
    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;
    private final DriverRepository driverRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepository driverRepository){
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

//        System.out.println("*****************");
////
//        Review r = Review.builder()
//                .content("Poor ride quality")
//                .rating(2.0)
//                .build(); // code to create plain java object
//        reviewRepository.save(r);  // this code executes sql query
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


//        Booking booking = bookingRepository.findById(1L).get();
//        if(booking != null){
//            bookingRepository.delete(booking);
//        }

//        Driver driver =  driverRepository.findByIdAndLicenceNumber(1L,"DL12345");
//        if(driver != null){
//           // List<Booking> bookings = bookingRepository.findAllByDriverId(1L);
//            List<Booking> bookings = driver.getBookings();
//            for(Booking booking : bookings){
//                System.out.println(booking.getBookingStatus());
//            }
//        }
//
//        Driver d1 = driverRepository.rawFindByIdAndLicenceNumber(1L,"DL12345");
//        System.out.println(d1.getName());
//       // Booking b = bookingRepository.findById(1L).get();
//
//        Driver d2 = driverRepository.hqlFindByIdAndLicenceNumber(2L,"DL54321");
//        System.out.println(d2.getName());



        // N + 1 Problem solution

        List<Long> driverIds = new ArrayList<>(Arrays.asList(1L,2L));
        List<Driver> drivers = driverRepository.findAllByIdIn(driverIds);

//        List<Booking> bookings = bookingRepository.findAllByDriverIn(drivers);

        for(Driver driver : drivers){
            List<Booking> bookings = driver.getBookings();
            bookings.forEach(booking -> System.out.println(booking.getId()));
        }

    }
}
