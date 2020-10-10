package com.ford.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ford.app.model.UserLog;
import com.ford.app.repository.UserRepoLog;

@Service
public class UserLogJPA implements IUserLogService {

	@Autowired
	private UserRepoLog userLogIn;
	
	@Override
	public List<UserLog> findAllUserLogs() {
		return userLogIn.findAll();
	}

	@Override
	public void saveUserLog(UserLog log) {
		userLogIn.save(log);
	}

	@Override
	@Transactional
	public void updateUserDate(String dateUpdateUser, int idUser, String dateLog) {
		userLogIn.updateDateUserId(dateUpdateUser, idUser, dateLog);
	}

	@Override
	public List<UserLog> findByIdUserOrderByDateLog(int idUser) {
		return userLogIn.findByIdUserOrderByDateLogDesc(idUser);
	}

}
