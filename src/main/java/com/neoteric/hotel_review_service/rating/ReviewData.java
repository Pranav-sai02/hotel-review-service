package com.neoteric.hotel_review_service.rating;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReviewData {

    private List<Category> categories;

    
    @JsonProperty("reviewSummary")
    private List<ReviewSummary> reviewSummary;

    @JsonProperty("categoryReview")
    private List<CategoryReview> categoryReview;
}