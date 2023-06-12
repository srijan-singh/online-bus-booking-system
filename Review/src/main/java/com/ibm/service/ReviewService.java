package com.ibm.service;

import com.ibm.entity.ReviewEntity;

public interface ReviewService {
    ReviewEntity getReview(int id);

    ReviewEntity saveReview(ReviewEntity review);
}
