package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Menu;
import com.example.demo.entity.Room;
import com.example.demo.error.CustomerNotFoundException;
import com.example.demo.error.MenuNotFoundException;
import com.example.demo.error.RoomNotFoundException;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.MenuRepository;
import com.example.demo.repository.RoomRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private MenuRepository menuRepository ;
	@Override
	public Customer addCustomer(@Valid Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}
	@Override
	public Customer findCustomerById(Integer cid) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> customer=customerRepository.findById(cid);
		if(!customer.isPresent()) {
			throw new CustomerNotFoundException("Customer Not Found");
		}
		return customer.get();
	}
	
	@Override
	public void deleteCustomer(Integer cid) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> customer=customerRepository.findById(cid);
		if(!customer.isPresent()) {
			throw new CustomerNotFoundException("customer not found");
			
		}else {
			customerRepository.deleteById(cid);
		}
	}
	@Override
	public Customer bookRoomByCustomer(Integer roomno, Integer cid) throws CustomerNotFoundException, RoomNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> customer=customerRepository.findById(cid);
		Optional<Room> room=roomRepository.findById(roomno);
		if(!customer.isPresent()) {
			throw new CustomerNotFoundException("customer not found");
		}else if(!room.isPresent()) {
			throw new RoomNotFoundException("room not found");
		}else {
			Customer customer1=customerRepository.findById(cid).get();
			Room room1=roomRepository.findById(roomno).get();
			customer1.bookedRoom(room1);
			return customerRepository.save(customer1);
		}
	}
	
	
	
	
	

	
	
	
	

}
