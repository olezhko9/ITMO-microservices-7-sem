package com.microservices.payment.dao;

import com.microservices.payment.dto.PaymentDto;
import com.microservices.payment.dto.UserDetailsDto;


public interface PaymentDao {
    PaymentDto initPayment(int orderId, UserDetailsDto userDetails);

    PaymentDto getPaymentStatus(int orderId);
}

