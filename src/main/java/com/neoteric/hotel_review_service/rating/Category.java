package com.neoteric.hotel_review_service.rating;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.neoteric.hotel_review_service.review.CategoryReview;
import com.neoteric.hotel_review_service.review.Review;
import com.neoteric.hotel_review_service.review.ReviewSummary;
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
