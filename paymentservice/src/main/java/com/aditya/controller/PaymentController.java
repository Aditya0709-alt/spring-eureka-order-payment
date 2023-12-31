package com.aditya.controller;

import com.aditya.entity.Payment;
import com.aditya.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/makePayment")
    public Payment makePayment(Payment payment) {
        return paymentService.makePayment(payment);
    }
}
