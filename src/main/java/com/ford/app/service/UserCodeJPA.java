package com.ford.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ford.app.model.UserCode;
import com.ford.app.repository.UserRepoCode;

@Service
public class UserCodeJPA implements IUserCode {

	@Autowired
	private UserRepoCode userCode;
	
	@Override
	public List<UserCode> findAllCode() {
		return userCode.findAll();
	}

	@Override
	public void saveCode(UserCode code) {
		userCode.save(code);
	}

	@Override
	public UserCode verifyCode(int code) {
		return userCode.findByCode(code);
	}

}
