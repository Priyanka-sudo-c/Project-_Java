package com.example.demo.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.entity.Room;
import com.example.demo.error.CustomerNotFoundException;
import com.example.demo.error.RoomNotFoundException;
import com.example.demo.service.RoomService;

@RestController
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@PostMapping("/addRoom")
	public ResponseEntity<Room> addRoom(@Valid @RequestBody Room room){
		Room saveRoom=roomService.addRoom(room);
		return new ResponseEntity<Room>(saveRoom,HttpStatus.CREATED);
	}
	
	@GetMapping("/getRoom")
	public List<Room> getAllRooms(){
		return roomService.getAllRooms();
	}
	
	@GetMapping("/getRoomByNo/{roomno}")
	public Room findRoombyNo(@PathVariable("roomno")Integer roomno) throws RoomNotFoundException {
		return roomService.findRoombyNo(roomno);
	}
	
	@DeleteMapping("/deleteRoom/{roomno}")
	public String deleteRoomByNo(@PathVariable("roomno") Integer roomno) throws RoomNotFoundException {
		roomService.deleteRoomByNo(roomno);
		return "Room Deleted Successfully";
	}
	
	
	
}
