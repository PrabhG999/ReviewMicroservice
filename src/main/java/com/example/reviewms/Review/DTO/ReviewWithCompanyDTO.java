package com.example.reviewms.Review.DTO;

import com.example.companyms.Company.Company;
import com.example.reviewms.Review.Review;

public class ReviewWithCompanyDTO {
    private Review review;

    private Company company;

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
