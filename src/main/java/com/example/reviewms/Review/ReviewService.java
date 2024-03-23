package com.example.reviewms.Review;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();

    boolean addReview(@RequestBody Review review);

    Review getReviewById(int id);

    boolean updateReview(int id, @RequestBody Review review);

    boolean deleteReview(int id);

    boolean patchReview(int id, @RequestBody Review review);

}
