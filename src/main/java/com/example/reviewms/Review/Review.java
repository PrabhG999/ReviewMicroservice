package com.example.reviewms.Review;

import jakarta.persistence.*;

@Entity
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;
    private String title;
    private String description;
    private double rating;
    private int companyId;

    public Review() { //JPA Constructor
    }

    public Review(int reviewId, String title, String description, double rating) {
        this.reviewId = reviewId;
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public int getId() {
        return reviewId;
    }

    public void setId(int id) {
        this.reviewId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

}
