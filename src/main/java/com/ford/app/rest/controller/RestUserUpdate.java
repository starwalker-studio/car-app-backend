package com.ford.app.rest.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ford.app.model.UserLog;
import com.ford.app.model.UserRegister;
import com.ford.app.service.IUserLogService;
import com.ford.app.service.IUserService;
import com.ford.app.util.FordEndPoints;
import com.ford.app.util.LogConstants;
import com.ford.app.util.UtilConstants;

@RestController
@RequestMapping("/auth")
public class RestUserUpdate {
	
	private static final Logger LOG = Logger.getLogger(RestUserUpdate.class);
	
	@Autowired
	private IUserLogService userLog;
	
	@Autowired
	private IUserService user;
	
	@RequestMapping(value = FordEndPoints.ACTUALIZAR_USUARIO, method = RequestMethod.POST,
				produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateUser(@RequestBody UserRegister userObj){
		Date date = new Date();
		SimpleDateFormat todayFormat = new SimpleDateFormat(UtilConstants.DATE_FORMAT);
		List<UserLog> list = new ArrayList<UserLog>();
		UserLog objUserLog = new UserLog();
		LOG.info(LogConstants.BUSCANDO_ULTIMO_INGRESO_DE_USUARIO);
		list = userLog.findByIdUserOrderByDateLog(userObj.getId_user());
		boolean update = true;
		for (int i = 0; i < list.size(); i++) {
			objUserLog = list.get(0);
		}
		LOG.info(LogConstants.INSERTANDO_FECHA_DE_ACTUALIZACION_DE_USUARIO);		
		userLog.updateUserDate(todayFormat.format(date), userObj.getId_user(), objUserLog.getDateLog());
		LOG.info(LogConstants.REALIZANDO_ACTUALIZACION_DE_USUARIO);		
		user.updateUser(userObj);		
		return String.valueOf(update);
	}

}
