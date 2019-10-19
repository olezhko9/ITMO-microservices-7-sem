package com.microservices.payment.service;

import com.microservices.payment.dao.PaymentDao;
import com.microservices.payment.dto.PaymentCreationDto;
import com.microservices.payment.dto.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {

    private final PaymentDao paymentDao;

    @Autowired
    public PaymentService(@Qualifier("sqlite") PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    public PaymentDto initPayment(PaymentCreationDto payment) {
        return paymentDao.initPayment(payment);
    }

    public PaymentDto getPaymentStatus(int orderId) {
        return paymentDao.getPaymentStatus(orderId);
    }
}