package com.aditya.service;

import com.aditya.common.Payment;
import com.aditya.common.TransactionRequest;
import com.aditya.common.TransactionResponse;
import com.aditya.entity.Order;
import com.aditya.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder (TransactionRequest transactionRequest) {
        String response = "";
        Order order = transactionRequest.getOrder();
        Payment payment = transactionRequest.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        //REST call
        Payment paymentResponse = restTemplate.postForObject("http://localhost:9191/payment/makePayment", payment, payment.getClass());


        response = paymentResponse.getPaymentStatus().equals("success") ? "payment successful" : "failure";


         orderRepository.save(order);
         return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }
}
