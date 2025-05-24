package com.neoteric.hotel_review_service.rating;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class RootResponse {
    @JsonProperty("avootaStatus")
    private String avootaStatus;

    @JsonProperty("response")
    private ResponseData response;

    // getters and setters
}


