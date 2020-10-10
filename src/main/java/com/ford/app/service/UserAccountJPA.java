package com.ford.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ford.app.model.UserAccount;
import com.ford.app.repository.UserRepoAccount;

@Service
public class UserAccountJPA implements IUserAccount {

	@Autowired
	private UserRepoAccount repoUserAccount;
	
	@Override
	public List<UserAccount> findByIdUser(int id) {
		return repoUserAccount.findByIduser(id);
	}

	@Override
	public void saveAccount(UserAccount account) {
		repoUserAccount.save(account);
	}

}
