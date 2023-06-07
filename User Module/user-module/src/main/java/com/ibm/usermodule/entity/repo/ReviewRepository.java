package com.ibm.usermodule.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.usermodule.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    
}
