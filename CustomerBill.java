package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Menu;
import com.example.demo.entity.Payment;
import com.example.demo.entity.Room;
import com.example.demo.error.CustomerNotFoundException;
import com.example.demo.error.MenuNotFoundException;
import com.example.demo.error.RoomNotFoundException;
import com.example.demo.service.PaymentService;

@RestController
public class CustomerBill {

	@Autowired
	private MenuRepository menuRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	@GetMapping("/bill/room/{roomno}/customer/{cid}")
	public String getBill(@PathVariable("cid") Integer cid, @PathVariable("roomno") Integer roomno) {
		float bill=menuRepository.findMenuPriceByCustomerId(cid)+roomRepository.findRoomPriceByNo(roomno);
		return "customer bill="+bill;
	}
	
	
		
		
			
			
		
		
			
		
		
	
}
