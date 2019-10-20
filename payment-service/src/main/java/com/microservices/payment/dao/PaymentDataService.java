package com.microservices.payment.dao;

import com.microservices.payment.dto.PaymentCreationDto;
import com.microservices.payment.dto.PaymentDto;
import com.microservices.payment.model.Payment;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository("sqlite")
public class PaymentDataService implements PaymentDao {

    private static final String CONNECTION_STRING = "jdbc:sqlite:Payments.db";
    private Connection connection;

    public PaymentDataService() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PaymentDto initPayment(int orderId, PaymentCreationDto paymentCreationDto) {
        Payment payment = paymentCreationDto.toPayment();

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO Payments VALUES(?, ?, ?);"
            );

            statement.setInt(1, orderId);
            statement.setString(2, paymentCreationDto.getUserDetails().cardAuthorizationInfo);
            statement.setString(3, paymentCreationDto.getUserDetails().name);


            int resultSet = statement.executeUpdate();
            if (resultSet != 0) {
                return PaymentDto.fromPayment(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public PaymentDto getPaymentStatus(int orderId) {
        ResultSet resultSet = null;

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "Select * FROM Payments WHERE orderId=?;"
            );
            statement.setInt(1, orderId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                PaymentDto paymentDto = new PaymentDto();
                paymentDto.setOrderId(resultSet.getInt("orderId"));
                paymentDto.setStatus(resultSet.getString("status"));
                resultSet.close();
                return paymentDto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
