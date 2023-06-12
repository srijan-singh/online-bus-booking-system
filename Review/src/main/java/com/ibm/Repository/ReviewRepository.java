package com.ibm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.entity.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
	
}
