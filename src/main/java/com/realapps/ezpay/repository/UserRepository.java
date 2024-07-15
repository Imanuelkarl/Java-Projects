package com.realapps.ezpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realapps.ezpay.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	Boolean existsByEmail(String email);
	
}
