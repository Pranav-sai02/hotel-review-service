package com.neoteric.hotel_review_service.rating;


import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public  class CategoryReview {
    private String type;


    private double averageRating;

    private String percentage;

    private Category category;

    @JsonProperty("subRatings")
    private List<SubRating> subRatings;


}
