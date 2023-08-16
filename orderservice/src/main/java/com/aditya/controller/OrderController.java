package com.aditya.controller;

import com.aditya.common.Payment;
import com.aditya.common.TransactionRequest;
import com.aditya.common.TransactionResponse;
import com.aditya.entity.Order;
import com.aditya.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest) {

        return orderService.saveOrder(transactionRequest);


        //if order is marked for checkout, make a REST call to payment API and pass order id
    }
}
