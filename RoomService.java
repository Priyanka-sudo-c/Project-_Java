package com.example.demo.service;

import java.util.List;


import javax.validation.Valid;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Room;
import com.example.demo.error.CustomerNotFoundException;
import com.example.demo.error.RoomNotFoundException;

public interface RoomService {

	Room addRoom(@Valid Room room);

	List<Room> getAllRooms();

	Room findRoombyNo(Integer roomno) throws RoomNotFoundException;

	void deleteRoomByNo(Integer roomno) throws RoomNotFoundException;

	

}
