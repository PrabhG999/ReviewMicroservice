package com.example.reviewms.Review.Impl;

import com.example.reviewms.Review.Review;
import com.example.reviewms.Review.ReviewRepository;
import com.example.reviewms.Review.ReviewService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(int companyId) {
        return reviewRepository.findAll();
    }

    @Override
    @Transactional
    public boolean addReview(int companyId, Review review) {
        if (review != null) {
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview(int reviewId,  Review updateReview) {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
        if (reviewOptional.isPresent()) {
            Review review = reviewOptional.get();
            review.setTitle(updateReview.getTitle());
            review.setDescription(updateReview.getDescription());
            review.setRating(updateReview.getRating());
            review.setCompanyId(updateReview.getCompanyId());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteReview(int reviewId) {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
        if (reviewOptional.isPresent()) {
            Review review = reviewOptional.get();
            reviewRepository.delete(review);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean patchReview(int reviewId, Review patchReview) {

        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
        if (reviewOptional.isPresent()) {
            Review existingReview = reviewOptional.get();
            if (patchReview.getTitle() != null) {
                existingReview.setTitle(patchReview.getTitle());
            }
            if (patchReview.getDescription() != null) {
                existingReview.setDescription(patchReview.getDescription());
            }
            if(patchReview.getCompanyId()!= 0){
                existingReview.setCompanyId(patchReview.getCompanyId());
            }
            reviewRepository.save(existingReview);
            return true;
        }
        return false;
    }
}
