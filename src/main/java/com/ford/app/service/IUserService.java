package com.ford.app.service;

import java.util.List;

import com.ford.app.model.UserRegister;

public interface IUserService {
	
	List<UserRegister> findAllUser();
	
	UserRegister findByMail(String mail);
	
	UserRegister findByPassword(String password);

	UserRegister findById(int id);
	
	void registerNewUser(UserRegister user);

	void updatePassword(UserRegister user);

	void updateUser(UserRegister user);

}
