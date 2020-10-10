package com.ford.app.rest.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
public class RestUserLogin {
	
	private static final Logger LOG = Logger.getLogger(RestUserLogin.class);	
		
	@Autowired
	private IUserService user;
	
	@Autowired
	private IUserLogService userLogService;
	
	/*Service for log user*/
	
	@RequestMapping(value = FordEndPoints.USUARIO_LOG_IN, method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserRegister userLogIn(@RequestBody UserRegister userObj) {			
		Date date = new Date();
		SimpleDateFormat todayFormat = new SimpleDateFormat(UtilConstants.DATE_FORMAT);
		UserLog userLogObj = new UserLog();
		UserRegister sendResponse = new UserRegister();
		boolean checkPass = false;
		boolean checkMail = false;
		boolean access = false;
		
		LOG.info(LogConstants.VALIDAR_USUARIO_CONTRASENA);
		/*Extrayendo lista de la tabla*/
		sendResponse = user.findByMail(userObj.getMail());
		LOG.info(LogConstants.EXTRAYENDO_INFO_TABLA_REGISTER);
		try {			
			/*Verificando mail existente*/
			if (sendResponse.getMail() != null) {
				checkMail = true;
			}
		} catch (NullPointerException e) {
			checkMail = false;
		}
		
		sendResponse = new UserRegister();
		sendResponse = user.findByPassword(userObj.getPassword());
		try {			
			/*Verificando contraseña existente*/
			if (sendResponse.getPassword() != null) {
				checkPass = true;				
			}
		} catch (NullPointerException e) {
			checkPass = false;	
		}
		
		/*Validando si el mail y contraseña ingresados sean correctas*/
		access = (checkMail && checkPass) ? true : false;
		LOG.info(LogConstants.VALIDO + access);
		if (access) {
			sendResponse = new UserRegister();
			sendResponse = user.findByPassword(userObj.getPassword());
			userLogObj.setIdUser(sendResponse.getId_user());
			LOG.info(LogConstants.GUARDANDO_TABLA_USER_LOG);
			userLogObj.setDateLog(todayFormat.format(date));
			userLogService.saveUserLog(userLogObj);
			sendResponse = user.findById(sendResponse.getId_user());
		} else {
			sendResponse = new UserRegister();
		}
		
		return sendResponse;
		
	}

}
