package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Menu;
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{

	Optional<Menu> findByMenuName(String menuname);
	
    @Query("select sum(m.price) from Menu m where customer_id=:id")
	float findMenuPriceByCustomerId(@Param("id") Integer cid) ;

    @Modifying
    @Query("delete from Menu where customer_id=:id")
    Integer deleteMenuByCustomerId(@Param("id") Integer cid);
	
}
