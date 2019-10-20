package com.microservices.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetails {
    public String name;
    public String cardAuthorizationInfo;

    public UserDetails(
            @JsonProperty("username") String name,
            @JsonProperty("cardAuthorizationInfo") String cardAuthorizationInfo) {
        this.name = name;
        this.cardAuthorizationInfo = cardAuthorizationInfo;
    }
}
