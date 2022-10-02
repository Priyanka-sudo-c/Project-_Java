package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Payment;

public interface PaymentService {

	Payment paymentSave(Payment payment);

	List<Payment> getAllPayments();

	

}
