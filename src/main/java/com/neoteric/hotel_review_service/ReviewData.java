package com.neoteric.hotel_review_service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReviewData {
    private List<CategoryReview> categoryList;
}
