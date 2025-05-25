package com.neoteric.hotel_review_service.rating;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public  class Review {
    private String id;
    private String title;
    private String text;
    private int rating;
    private User user;
    private String trip_type;
    private String published_date;
    private Map<String, SubRating> subratings;
}
