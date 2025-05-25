package com.neoteric.hotel_review_service.rating;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private ReviewResponse reviewResponse;

    public double calculateAverageRating(List<Map<String, Object>> reviews) {

        double average = reviews.stream()
                .flatMap(review -> {
                    if (review.containsKey("subratings")) {
                        Map<String, Map<String, Object>> subratings = (Map<String, Map<String, Object>>) review.get("subratings");
                        return subratings.values().stream()
                                .map(sub -> sub.get("value"))
                                .filter(value -> value instanceof Number)
                                .map(value -> ((Number) value).doubleValue());
                    } else if (review.containsKey("rating")) {
                        Object ratingObj = review.get("rating");
                        if (ratingObj instanceof Number) {
                            return java.util.stream.Stream.of(((Number) ratingObj).doubleValue());
                        }
                    }
                    return java.util.stream.Stream.empty();
                })
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);

        return Math.round(average * 100.0) / 100.0;
    }


    public Map<String, Double> calculateAverageRatingByTripType(List<Map<String, Object>> reviews) {
        return reviews.stream()
                .filter(review -> review.get("tripType") != null)
                .collect(Collectors.groupingBy(
                        review -> review.get("tripType").toString(),
                        Collectors.collectingAndThen(
                                Collectors.averagingDouble(review -> {
                                    Object ratingObj = review.get("rating");
                                    if (ratingObj instanceof Number) {
                                        return ((Number) ratingObj).doubleValue();
                                    } else if (review.containsKey("subratings")) {
                                        Map<String, Map<String, Object>> subratings = (Map<String, Map<String, Object>>) review.get("subratings");
                                        return subratings.values().stream()
                                                .map(sr -> sr.get("value"))
                                                .filter(val -> val instanceof Number)
                                                .mapToDouble(val -> ((Number) val).doubleValue())
                                                .average()
                                                .orElse(0.0);
                                    }
                                    return 0.0;
                                }),
                                avg -> Math.round(avg * 100.0) / 100.0
                        )
                ));
    }



}
