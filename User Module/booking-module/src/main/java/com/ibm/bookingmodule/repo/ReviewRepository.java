package com.ibm.bookingmodule.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.bookingmodule.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    
}
