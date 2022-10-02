package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer menuId;
	@NotEmpty(message="menu name should not be empty")
	private String menuName;
	@Min(value=20,message ="Minimum price is 20rs")
	private float price;
	
	
	@ManyToOne
	@JoinColumn(name="customer_id", referencedColumnName = "customerId")
	private Customer customer;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	
	

	public void choosedMenu(Customer customer1) {
		// TODO Auto-generated method stub
		this.customer=customer1;
	}

	
	
	
	
	
}
