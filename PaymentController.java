package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Payment;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	@Autowired
	private PaymentRepository paymentRepository;
	@PostMapping("/payment")
	public Payment paymentSave(@RequestBody Payment payment) {
		return paymentService.paymentSave(payment);
	}
	
	@GetMapping("/getAllPayments")
	public List<Payment> getAllPayments(){
		return paymentService.getAllPayments();
	}
	
	@GetMapping("/checkTotalMoneyInHotel")
	public String checkTotalMoney() {
		float totalMoney=paymentRepository.totalMoneyInHotel();
		return "Total Money In Hotel Account="+totalMoney;
		
	}
}
