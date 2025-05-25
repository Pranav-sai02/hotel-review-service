package com.neoteric.hotel_review_service.rating;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Category {


    @JsonProperty("categoryName")
    private String categoryName;

    @JsonProperty("reviewSummary")
    private List<ReviewSummary> reviewSummary;

    @JsonProperty("categoryReview")
    private List<CategoryReview> categoryReview;

    private List<Review> reviewList;

    // getters and setters
}
