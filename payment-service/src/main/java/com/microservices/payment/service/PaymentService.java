package com.microservices.payment.service;

import com.microservices.payment.dao.PaymentDao;
import com.microservices.payment.dto.PaymentDto;
import com.microservices.payment.dto.UserDetailsDto;
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

    public PaymentDto initPayment(int orderId, UserDetailsDto userDetails) {
        return paymentDao.initPayment(orderId, userDetails);
    }

    public PaymentDto getPaymentStatus(int orderId) {
        return paymentDao.getPaymentStatus(orderId);
    }
}
