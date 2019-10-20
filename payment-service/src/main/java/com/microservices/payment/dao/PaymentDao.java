package com.microservices.payment.dao;

import com.microservices.payment.dto.PaymentCreationDto;
import com.microservices.payment.dto.PaymentDto;


public interface PaymentDao {
    PaymentDto initPayment(int orderId, PaymentCreationDto item);

    PaymentDto getPaymentStatus(int orderId);
}

