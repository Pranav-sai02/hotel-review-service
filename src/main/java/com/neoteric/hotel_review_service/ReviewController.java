package com.neoteric.hotel_review_service;

import com.neoteric.hotel_review_service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewAnalysisService;

    @Autowired
    public ReviewController(ReviewService reviewAnalysisService) {
        this.reviewAnalysisService = reviewAnalysisService;
    }

    @PostMapping("/average-rating")
    public double getAverageRating(@RequestBody List<Map<String, Object>> reviews) {
        return reviewAnalysisService.calculateAverageRating(reviews); // ✅ no static call here
    }
}
