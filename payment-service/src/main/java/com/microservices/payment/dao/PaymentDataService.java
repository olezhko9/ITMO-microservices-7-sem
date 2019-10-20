package com.microservices.payment.dao;

import com.microservices.payment.dto.PaymentCreationDto;
import com.microservices.payment.dto.PaymentDto;
import com.microservices.payment.model.Payment;
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
    public PaymentDto initPayment(PaymentCreationDto paymentCreationDto) {
        Payment payment = paymentCreationDto.toPayment();

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO Payments VALUES(NULL, ?, 0, ?');"
            );

            statement.setInt(1, paymentCreationDto.getOrderId());
            statement.setString(2, paymentCreationDto.getUserInfo().name);
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
//                payment.setOrderId(resultSet.getInt(1));
                resultSet.close();
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
                    "Select * FROM Payments WHERE OrderID=?;"
            );
            statement.setInt(1, orderId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                PaymentDto paymentDto = new PaymentDto();
                paymentDto.setOrderId(resultSet.getInt("OrderID"));
                paymentDto.setStatus(resultSet.getInt("Status"));
                resultSet.close();
                return paymentDto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
