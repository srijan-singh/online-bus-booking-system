package com.ibm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.Repository.ReviewRepository;
import com.ibm.entity.ReviewEntity;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReviewEntity getReview(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public ReviewEntity saveReview(ReviewEntity review) {
        return repository.save(review);
    }
}
