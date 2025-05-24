package com.neoteric.hotel_review_service.review;


import com.neoteric.hotel_review_service.rating.ResponseData;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseWrapper {
    private String avootaStatus;
    private ResponseData response;


}

