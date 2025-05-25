package com.neoteric.hotel_review_service.rating;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public  class ReviewSummary {
    private String type;
    private double averageRating;
    private String percentage;


}
