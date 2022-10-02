package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	 

//	@Transactional
//	@Modifying
//	@Query("update Payment p set p.paymentMoney=(p.paymentMoney+:money)")
//	int customerPayment(@Param("money") float money) ;
//
//	String save(float paymentCustomer);
	@Query("select sum(p.paymentMoney) from Payment p")
	float totalMoneyInHotel();

}
