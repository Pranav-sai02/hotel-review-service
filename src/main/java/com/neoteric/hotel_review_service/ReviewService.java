package com.neoteric.hotel_review_service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ReviewService {

    private ReviewResponse reviewResponse;



    public ReviewResponse getReviewResponse() {
        return reviewResponse;
    }

    public double calculateAverageRating(List<Map<String, Object>> reviews) {
        double totalRating = 0.0;
        int count = 0;

        for (Map<String, Object> review : reviews) {
            double reviewRating = 0.0;
            int ratingCount = 0;

            if (review.containsKey("subratings")) {
                Map<String, Map<String, Object>> subratings = (Map<String, Map<String, Object>>) review.get("subratings");
                for (Map<String, Object> sub : subratings.values()) {
                    Object valueObj = sub.get("value");
                    if (valueObj instanceof Number) {
                        reviewRating += ((Number) valueObj).doubleValue();
                        ratingCount++;
                    }
                }
            }

            if (ratingCount > 0) {
                totalRating += reviewRating / ratingCount;
            } else if (review.containsKey("rating")) {
                Object ratingObj = review.get("rating");
                if (ratingObj instanceof Number) {
                    totalRating += ((Number) ratingObj).doubleValue();
                }
            } else {
                continue; // skip if no rating data
            }

            count++;
        }

        return count > 0 ? totalRating / count : 0.0;
    }


}
