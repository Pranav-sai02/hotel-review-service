package com.neoteric.hotel_review_service.rating;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public  class ResponseData {
    private List<Category> categoryList;
    // getters and setters
}