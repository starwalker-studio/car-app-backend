package com.ford.app.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ford.app.model.UserRegister;
import com.ford.app.service.IUserService;
import com.ford.app.util.FordEndPoints;
import com.ford.app.util.LogConstants;
import com.ford.app.util.UtilConstants;

@RestController
@RequestMapping("/auth")
public class RestUserUpdatePassword {
	
	static final Logger LOG = Logger.getLogger(RestUserUpdatePassword.class);
	
	@Autowired
	private IUserService user;
	
	@RequestMapping(value = FordEndPoints.ACTUALIZAR_CONTRASENA, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateUserPassword(@RequestBody UserRegister userObj) {
		UserRegister userUpdate = user.findByMail(userObj.getMail());
		userUpdate.setPassword(userObj.getPassword());
		user.updatePassword(userUpdate);
		LOG.info(LogConstants.ACTUALIZANDO_CONTRASENA + userObj.getPassword() + " : " + LogConstants.DEL_CORREO + userObj.getMail());
		return UtilConstants.RESPONSE_BOOLEAN;
	}

}
