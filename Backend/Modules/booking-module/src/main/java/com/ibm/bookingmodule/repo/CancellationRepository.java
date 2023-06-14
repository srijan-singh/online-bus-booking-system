package com.ibm.bookingmodule.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.bookingmodule.entity.Cancellation;

public interface CancellationRepository extends JpaRepository<Cancellation, Integer> {
    
}
