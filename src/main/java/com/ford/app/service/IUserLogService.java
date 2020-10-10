package com.ford.app.service;

import java.util.List;

import com.ford.app.model.UserLog;

public interface IUserLogService {
	
	List<UserLog> findAllUserLogs();
	
	void saveUserLog(UserLog log);
	
	void updateUserDate(String dateUpdateUser, int idUser, String dateLog);
	
	List<UserLog> findByIdUserOrderByDateLog(int idUser);

}
