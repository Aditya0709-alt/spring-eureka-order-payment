package com.aditya.repository;

import com.aditya.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository  extends JpaRepository<Payment, Integer> {
}
