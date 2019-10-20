package com.microservices.payment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payment {
    private int orderId;
    private boolean status;
    private UserInfo userInfo;

    public Payment(
            @JsonProperty("orderId") int orderId,
            @JsonProperty("status") int status,
            UserInfo userInfo) {
        this.orderId = orderId;
        this.status = status;
        this.userInfo = userInfo;
    }

    public Payment() {}

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
