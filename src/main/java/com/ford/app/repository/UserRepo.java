package com.ford.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ford.app.model.UserRegister;

@Repository
public interface UserRepo extends JpaRepository<UserRegister, Integer>{
	
	UserRegister findByMail(String mail);
	
	UserRegister findByPassword(String password);
	
	UserRegister findById(int id);

}
