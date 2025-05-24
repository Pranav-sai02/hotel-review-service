package com.neoteric.hotel_review_service;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryReview  {
    private String type;
    private double averageRating;
    private String percentage;
}
