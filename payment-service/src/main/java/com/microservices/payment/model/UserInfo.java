package com.microservices.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {
    public String name;
    public boolean cardInfo;

    public UserInfo(
            @JsonProperty("username") String name,
            @JsonProperty("cardInfo") boolean cardInfo) {
        this.name = name;
        this.cardInfo = cardInfo;
    }
}
