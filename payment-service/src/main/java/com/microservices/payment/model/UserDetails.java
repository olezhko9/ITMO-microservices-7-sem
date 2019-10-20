package com.microservices.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {
    public String name;
    public boolean cardAuthorizationInfo;

    public UserInfo(
            @JsonProperty("username") String name,
            @JsonProperty("cardInfo") boolean cardAuthorizationInfo) {
        this.name = name;
        this.cardAuthorizationInfo = cardAuthorizationInfo;
    }
}
