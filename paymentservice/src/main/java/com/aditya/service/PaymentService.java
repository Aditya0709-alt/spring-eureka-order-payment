package com.aditya.service;

import com.aditya.entity.Payment;
import com.aditya.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment makePayment(Payment payment) {
        payment.setPaymentStatus(processPayment());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    public String processPayment() {
        // API should be third party payment gateway
        return new Random().nextBoolean() ? "success" : "false";
    }

}
