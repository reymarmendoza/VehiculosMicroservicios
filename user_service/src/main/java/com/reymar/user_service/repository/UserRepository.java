package com.reymar.user_service.repository;

import com.reymar.user_service.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
