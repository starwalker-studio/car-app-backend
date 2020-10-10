package com.ford.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ford.app.model.UserRegister;
import com.ford.app.repository.UserRepo;

@Service
public class UserJPA implements IUserService {
	
	@Autowired
	private UserRepo userRepo;  

	@Override
	public List<UserRegister> findAllUser() {
		List<UserRegister> list = userRepo.findAll();
		return list;
	}

	@Override
	public void registerNewUser(UserRegister user) {
		userRepo.save(user);		
	}
	
	@Override
	public void updatePassword(UserRegister user) {
		userRepo.save(user);		
	}

	@Override
	public UserRegister findByMail(String mail) {
		return userRepo.findByMail(mail);
	}

	@Override
	public UserRegister findById(int id) {
		return userRepo.findById(id);
	}

	@Override
	public void updateUser(UserRegister user) {
		userRepo.save(user);		
	}

	@Override
	public UserRegister findByPassword(String password) {
		return userRepo.findByPassword(password);
	}

}
