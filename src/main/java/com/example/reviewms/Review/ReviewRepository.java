package com.example.reviewms.Review;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    //TODO : Define special functions which are not preBuilt in JPA Repo /CRUD REPO
}
