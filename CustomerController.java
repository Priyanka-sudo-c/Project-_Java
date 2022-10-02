package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Menu;
import com.example.demo.entity.Room;
import com.example.demo.error.CustomerNotFoundException;
import com.example.demo.error.MenuNotFoundException;
import com.example.demo.error.RoomNotFoundException;
import com.example.demo.service.CustomerService;


@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer){
		Customer saveCustomer=customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(saveCustomer,HttpStatus.CREATED);
	}
	@GetMapping("/getCustomer")
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomer();
	}
	
	@GetMapping("/getCustomerById/{cid}")
	public Customer findCustomerById(@PathVariable ("cid") Integer cid) throws CustomerNotFoundException {
		return customerService.findCustomerById(cid);
	}
	@DeleteMapping("/deleteCustomer/{cid}")
	public String deleteCustomer(@PathVariable("cid") Integer cid) throws CustomerNotFoundException {
		customerService.deleteCustomer(cid);
		return "Customer deleted successfully";
	}
	
	@PutMapping("/room/{roomno}/customer/{cid}")
	public Customer bookRoomByCustomer(@PathVariable("roomno") Integer roomno, @PathVariable("cid") Integer cid) throws CustomerNotFoundException, RoomNotFoundException {
		return customerService.bookRoomByCustomer(roomno,cid);
	} 
	
	
	
}
