package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;
	private float paymentMoney;
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public float getPaymentMoney() {
		return paymentMoney;
	}
	public void setPaymentMoney(float paymentMoney) {
		this.paymentMoney = paymentMoney;
	}
	
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	
//	
//	@JoinColumn(name="customer_id", referencedColumnName = "customerId")
//	private Customer customer;
//	public Customer getCustomer() {
//		return customer;
//	}
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
	
	
}
