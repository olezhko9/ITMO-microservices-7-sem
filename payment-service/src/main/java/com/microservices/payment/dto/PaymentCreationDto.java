package com.microservices.payment.dto;

import com.microservices.payment.model.Payment;
import com.microservices.payment.model.UserDetails;

public class PaymentCreationDto {
    private UserDetails userDetails;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public Payment toPayment() {
        Payment payment = new Payment();
        payment.setStatus(this.getUserDetails().cardAuthorizationInfo);
        payment.setUserName(this.getUserDetails().name);
        return payment;
    }
}
