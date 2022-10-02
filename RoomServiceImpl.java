package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Room;
import com.example.demo.error.CustomerNotFoundException;
import com.example.demo.error.RoomNotFoundException;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomRepository roomRepository; 
	@Autowired 
	private CustomerRepository customerRepository;
	@Override
	public Room addRoom(@Valid Room room) {
		// TODO Auto-generated method stub
		return roomRepository.save(room);
	}
	@Override
	public List<Room> getAllRooms() {
		// TODO Auto-generated method stub
		return roomRepository.findAll();
	}
	@Override
	public Room findRoombyNo(Integer roomno) throws RoomNotFoundException {
		// TODO Auto-generated method stub
		Optional<Room>room= roomRepository.findById(roomno);
		if(!room.isPresent()) {
			throw new RoomNotFoundException("Room is not present");
			
		}return room.get();
	}
	@Override
	public void deleteRoomByNo(Integer roomno) throws RoomNotFoundException {
		// TODO Auto-generated method stub
		Optional<Room>room= roomRepository.findById(roomno);
		if(!room.isPresent()) {
			throw new RoomNotFoundException("Room is not present");
			
		}else {
			roomRepository.deleteById(roomno);
		}
	}
	

	
	
}
