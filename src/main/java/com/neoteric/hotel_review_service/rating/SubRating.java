package com.neoteric.hotel_review_service.rating;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public  class SubRating {
    private String rating_type;
    private int rating;

    private int value;
    private String localized_name;
}
