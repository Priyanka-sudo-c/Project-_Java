package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Room;
@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{

//	Room findByRoomNo(Integer roomno);
	
	@Query("select r.roomPrice from Room r where r.roomNo=:n")
	float findRoomPriceByNo(@Param("n") Integer roomno);

}
