package com.neoteric.hotel_review_service.review;

import com.neoteric.hotel_review_service.rating.AverageRatingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<AverageRatingResponse> getAverageRating(@RequestBody List<Map<String, Object>> reviews) {
        double overallAvg = reviewAnalysisService.calculateAverageRating(reviews);
        String stars = getStars(overallAvg);

        Map<String, Double> avgByTripType = reviewAnalysisService.calculateAverageRatingByTripType(reviews);

        AverageRatingResponse response = new AverageRatingResponse(
                "success",
                "Average ratings calculated successfully.",
                overallAvg,
                5,
                stars,
                avgByTripType
        );

        return ResponseEntity.ok(response);
    }
    private String getStars(double rating) {
        int fullStars = (int) rating;
        boolean half = (rating - fullStars) >= 0.5;

        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < fullStars; i++) {
            stars.append("⭐");
        }
        if (half) {
            stars.append("✨");
        }
        return stars.toString();
    }

}
