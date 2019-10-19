package com.microservices.payment.dto;

import com.microservices.payment.model.Payment;
import com.microservices.payment.model.UserInfo;

public class PaymentCreationDto {
    private int orderId;
    UserInfo userInfo;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Payment toPayment() {
        Payment payment = new Payment();
        payment.setOrderId(this.getOrderId());
        payment.setUserInfo(this.getUserInfo());
        return payment;
    }
}
