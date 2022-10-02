package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer roomNo;
	@NotEmpty(message="room type should not be empty")
	@Size(min=2,max=30,message="room type should be minimum 2 characters max 30 characters") 
	private String roomType;
	@Min(value= 100 ,message="room price minimum 1000rs")
	private float roomPrice;
	@JsonIgnore
	@OneToOne(mappedBy="room")
	
	private Customer customer;

	public Integer getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public float getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(float roomPrice) {
		this.roomPrice = roomPrice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

//	public void bookedRoom(Customer customer1) {
//		// TODO Auto-generated method stub
//		this.customer=customer1;
//	}
//	
	
	
}
