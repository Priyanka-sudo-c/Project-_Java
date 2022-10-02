package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.entity.Customer;
import com.example.demo.error.CustomerNotFoundException;
import com.example.demo.error.MenuNotFoundException;
import com.example.demo.error.RoomNotFoundException;

public interface CustomerService {

	Customer addCustomer(@Valid Customer customer);

	List<Customer> getAllCustomer();

	Customer findCustomerById(Integer cid) throws CustomerNotFoundException;

	void deleteCustomer(Integer cid) throws CustomerNotFoundException;

	Customer bookRoomByCustomer(Integer roomno, Integer cid) throws CustomerNotFoundException, RoomNotFoundException;

	
	

	
	

	

	

}
