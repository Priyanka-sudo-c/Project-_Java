package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	@NotEmpty(message="customer name should not be empty")
	@Size(min=2,max=30,message="customer name should be minimum 2 characters max 30 characters") 
	private String customerName;
	@NotEmpty(message="customer number should not be empty")
	@Size(min=10,max=10,message="customer number can only have 10 digits") 
	private String customerContactNo;
	
	////////////////////////////
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="room_no", referencedColumnName = "roomNo")
	private Room room;

	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	
	private Set<Menu> menu=new HashSet<>();

//	@OneToMany(mappedBy="customer")
//	private Set<Payment> payment=new HashSet<>();
	////////////////////////////////////
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerContactNo() {
		return customerContactNo;
	}

	public void setCustomerContactNo(String customerContactNo) {
		this.customerContactNo = customerContactNo;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	

	

	public Set<Menu> getMenu() {
		return menu;
	}

	public void setMenu(Set<Menu> menu) {
		this.menu = menu;
	}

	public void bookedRoom(Room room1) {
		// TODO Auto-generated method stub
		this.room=room1;
	}

//	public void choosedMenu(Menu menu1) {
//		// TODO Auto-generated method stub
//		this.choosedMenu(menu1);
//	}

	
	
//	public Set<Payment> getPayment() {
//		return payment;
//	}
//
//	public void setPayment(Set<Payment> payment) {
//		this.payment = payment;
//	}

//	public void bookedRoom(Room room1) {
//		// TODO Auto-generated method stub
//		this.room=room1;
//	}



//	
	

	
	
	
}
