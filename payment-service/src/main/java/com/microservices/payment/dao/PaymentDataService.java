package com.microservices.payment.dao;

import com.microservices.payment.dto.PaymentCreationDto;
import com.microservices.payment.dto.PaymentDto;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository("sqlite")
public class PaymentDataService implements PaymentDao {

    private static final String CONNECTION_STRING = "jdbc:sqlite:warehouse.db";
    private Connection connection;

    public PaymentDataService() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PaymentDto initPayment(PaymentCreationDto item) {
        return null;
    }

    @Override
    public PaymentDto getPaymentStatus(int orderId) {
        return null;
    }
}
