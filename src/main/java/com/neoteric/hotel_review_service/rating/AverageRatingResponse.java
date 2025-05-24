package com.neoteric.hotel_review_service.rating;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AverageRatingResponse {
    private String status;
    private String message;
    private double averageRating;
    private int maxRating;
    private String starsVisual;
    private Map<String, Double> averageRatingsByTripType;

    // constructor, getters, setters
}
