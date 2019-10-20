package com.microservices.payment.api;

import com.microservices.payment.dto.PaymentCreationDto;
import com.microservices.payment.dto.PaymentDto;
import com.microservices.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("payments")
@RestController
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(path = "/{orderId}")
    public ResponseEntity<PaymentDto> initPayment(@PathVariable("orderId") int orderId, @RequestBody PaymentCreationDto payment) {
        return ResponseEntity.ok(paymentService.initPayment(orderId, payment));
    }

    @GetMapping(path = "/{orderId}")
    public ResponseEntity<PaymentDto> getPaymentStatus(@PathVariable("orderId") int id) {
        PaymentDto paymentDto = paymentService.getPaymentStatus(id);
        if (paymentDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paymentDto);
    }
}
