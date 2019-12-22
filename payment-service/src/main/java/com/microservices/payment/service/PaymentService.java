package com.microservices.payment.service;

import com.microservices.payment.dao.PaymentDao;
import com.microservices.payment.dto.PaymentDto;
import com.microservices.payment.dto.UserDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


@Service
public class PaymentService {

    private final PaymentDao paymentDao;

    @Autowired
    public PaymentService(@Qualifier("sqlite") PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    public PaymentDto initPayment(int orderId, UserDetailsDto userDetails) {
        this.changeOrderStatus(orderId, userDetails);
        return paymentDao.initPayment(orderId, userDetails);
    }

    public PaymentDto getPaymentStatus(int orderId) {
        return paymentDao.getPaymentStatus(orderId);
    }

    private void changeOrderStatus(int orderId, UserDetailsDto userDetailsDto) {
        String orderStatus = "";
        if (userDetailsDto.getCardAuthorizationInfo().equals("AUTHORIZED")) {
           orderStatus = "PAID";
        } else if (userDetailsDto.getCardAuthorizationInfo().equals("UNAUTHORIZED")) {
            orderStatus = "FAILED";
        }

        if (!orderStatus.equals("")) {
            URL url = null;
            try {
                url = new URL(String.format("http://orders:9000/orders/%d/status/%s", orderId, orderStatus));
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("PUT");
                con.setDoOutput(true);
                con.setDoInput(true);
                int responseCode = con.getResponseCode();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            HttpURLConnection con = null;
        }
    }
}
