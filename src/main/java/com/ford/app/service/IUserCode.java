package com.ford.app.service;

import java.util.List;

import com.ford.app.model.UserCode;

public interface IUserCode {
	
	List<UserCode> findAllCode();
	
	void saveCode(UserCode code);
	
	UserCode verifyCode(int code);

}
