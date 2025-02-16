package org.example.uberreviewservice.controllers;

import org.example.uberreviewservice.DTOs.CreateReviewDto;
import org.example.uberreviewservice.Utils.ErrorResponse;
import org.example.uberreviewservice.Utils.SuccessResponse;
import org.example.uberreviewservice.adapters.CreateReviewDtoToReviewAdapterImpl;
import org.example.uberreviewservice.models.Review;
import org.example.uberreviewservice.services.ReviewServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewControllers {
    private final ReviewServiceImpl reviewServiceImpl;
    private final CreateReviewDtoToReviewAdapterImpl createReviewDtoToReviewAdapterImpl;

    public ReviewControllers(ReviewServiceImpl reviewServiceImpl,CreateReviewDtoToReviewAdapterImpl createReviewDtoToReviewAdapterImpl) {
        this.reviewServiceImpl = reviewServiceImpl;
        this.createReviewDtoToReviewAdapterImpl = createReviewDtoToReviewAdapterImpl;
    }

    @GetMapping
    public ResponseEntity<?> getAllReviews(@RequestParam(required = false) Double rating){    // rating for reviews less than this given rating
        List<Review> reviews = reviewServiceImpl.findAllReviews(rating);
        if(reviews.isEmpty()){
            ErrorResponse errorResponse = new ErrorResponse(false,HttpStatus.NOT_FOUND.value(),"There are no reviews","No reviews",LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        SuccessResponse<List<Review>> successResponse = new SuccessResponse<>(true, HttpStatus.OK.value(),"Successfully fetched the reviews",reviews, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable Long id){
        try{
            Optional<Review> review = reviewServiceImpl.findReviewById(id);
            if(review.isPresent()){
                SuccessResponse<Review> successResponse = new SuccessResponse<>(true, HttpStatus.OK.value(),"Successfully fetched the review",review.get(),LocalDateTime.now());
                return ResponseEntity.status(HttpStatus.OK).body(successResponse);
            }else{
                ErrorResponse errorResponse = new ErrorResponse(false,HttpStatus.NOT_FOUND.value(), "Not found", "Review not found",LocalDateTime.now());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
            }
        }catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse(false,HttpStatus.NOT_FOUND.value(), e.getMessage(), "Review not found",LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody CreateReviewDto review){
        try{
            Review incomingReview = this.createReviewDtoToReviewAdapterImpl.convertDto(review);
            if(incomingReview == null){
                ErrorResponse errorResponse = new ErrorResponse(false,HttpStatus.NOT_FOUND.value(),"BookingId is not present","Error while creating the review",LocalDateTime.now());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
            }
            Review r =  reviewServiceImpl.createReview(incomingReview);
            SuccessResponse<Review> successResponse = new SuccessResponse<>(true,HttpStatus.CREATED.value(),"Successfully created the review",r,LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.CREATED).body(successResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(false,HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage(),"Error while creating the review",LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable Long id){
        try{
            reviewServiceImpl.deleteReviewById(id);
            SuccessResponse<String> successResponse = new SuccessResponse<>(true,HttpStatus.OK.value(), "Deleted successfully","Successfully deleted the review",LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.OK).body(successResponse);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(false,HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage(),"Error while deleting the review",LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
