package com.example.reviewms.Review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{id}")
public class ReviewController {
    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {          //created dependency of review service for controller
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@RequestBody Review review) {
        boolean isReviewAdded = reviewService.addReview(review);
        if (isReviewAdded) {
            return new ResponseEntity<>("Review Added Sucessfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review Was Not Added Successfully", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable int reviewId) {
        Review reviewById = reviewService.getReviewById(reviewId);
        if (reviewById != null) {
            return new ResponseEntity<>(reviewById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable int reviewId, @RequestBody Review review) {
        boolean isUpdated = reviewService.updateReview(reviewId, review);
        if (isUpdated) {
            return new ResponseEntity<>("Review Updated SucesfFully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review was not updated Successfully", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable int reviewId) {
        boolean isDeleted = reviewService.deleteReview(reviewId);
        if (isDeleted) {
            return new ResponseEntity<>("The review is deleted sucessfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review was not deleted sucessfully", HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/reviews/{reviewId}")
    public ResponseEntity<String> patchReview(@PathVariable int reviewId, @RequestBody Review review) {
        boolean isPatched = reviewService.patchReview(reviewId, review);
        if (isPatched) {
            return new ResponseEntity<>("Review Patched Sucessfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review was not patched Sucessfully", HttpStatus.BAD_REQUEST);
        }
    }
}
