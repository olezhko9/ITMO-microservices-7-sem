package com.microservices.payment.dto;

import com.microservices.payment.model.Payment;

public class PaymentDto {
    private int orderId;
    private boolean status;
    private String userName;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public static PaymentDto fromPayment(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setOrderId(payment.getOrderId());
        paymentDto.setStatus(payment.getUserInfo().cardInfo);
        return paymentDto;
    }
}
