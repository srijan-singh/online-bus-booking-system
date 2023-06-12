package com.ibm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.ibm.entity.ReviewEntity;
import com.ibm.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService service;

    @Autowired
    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ReviewEntity getReview(@PathVariable int id) {
        return service.getReview(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ReviewEntity saveReview(@RequestBody ReviewEntity review) {
        return service.saveReview(review);
    }


}
