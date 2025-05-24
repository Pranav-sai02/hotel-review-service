package com.neoteric.hotel_review_service.rating;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class RatingSummary {
    private double overallAverage;
    private Map<String, Double> categoryAverageRatings;
}
