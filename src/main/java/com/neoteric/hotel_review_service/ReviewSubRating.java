package com.neoteric.hotel_review_service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewSubRating {
    private int value;
    private String localized_name;
}
