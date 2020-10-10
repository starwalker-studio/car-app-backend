package com.ford.app.service;

import java.util.List;

import com.ford.app.model.UserAccount;

public interface IUserAccount {
	
	List<UserAccount> findByIdUser(int id);
	
	void saveAccount(UserAccount account);

}
