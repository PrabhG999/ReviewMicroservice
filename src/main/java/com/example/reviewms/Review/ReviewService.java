package com.example.reviewms.Review;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(int companyId);

    boolean addReview(int companyId, Review review);

    Review getReviewById(int reviewId);

    boolean updateReview(int reviewId, Review review);

    boolean deleteReview(int reviewId);

    boolean patchReview(int reviewId, Review review);

}
