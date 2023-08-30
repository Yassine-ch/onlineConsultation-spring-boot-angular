package com.yassine.javaProject.onlineConsultation.controllers;

import com.yassine.javaProject.onlineConsultation.models.Review;
import com.yassine.javaProject.onlineConsultation.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // Create One Review
    @PostMapping(value = "/reviews")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review reviewCreated = reviewService.createReview(review);
        return new ResponseEntity<>(reviewCreated, HttpStatus.CREATED);
    }

    // Get All Reviews
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> allReviews = reviewService.allReviews();
        return new ResponseEntity<>(allReviews, HttpStatus.OK);
    }

    // Find One Review
    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getOneReview(@PathVariable Long id) {
        Review oneReview = reviewService.findReview(id);
        return new ResponseEntity<>(oneReview, HttpStatus.OK);
    }

    // Update One Review
    @PutMapping("/reviews/{id}")
    public ResponseEntity<Review> updateOneReview(@PathVariable Long id, @RequestBody Review review) {
        Review existingReview = reviewService.findReview(id);
        if (existingReview != null) {
            existingReview.setReview(review.getReview());
            existingReview.setRate(review.getRate());
            Review updatedReview = reviewService.updateReview(review);
            return new ResponseEntity<>(updatedReview, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a consultation by ID
    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<Review> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}