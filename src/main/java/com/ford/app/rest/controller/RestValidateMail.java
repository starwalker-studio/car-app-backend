package com.ford.app.rest.controller;

import java.util.ArrayList;
import java.util.List;

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

@RestController
@RequestMapping("/auth")
public class RestValidateMail {
	
	private static final Logger LOG = Logger.getLogger(RestValidateMail.class);	
	
	@Autowired
	private IUserService user;
	
	@RequestMapping(value = FordEndPoints.VALIDAR_CORREO, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String consultarMailVigente(@RequestBody UserRegister userObj) {
		
		List<UserRegister> list = new ArrayList<UserRegister>();
		boolean checkMail = false;
		boolean access = false;
		
		LOG.info(LogConstants.VALIDAR_USUARIO_NUEVA_CONTRASENA);
		/*Extrayendo lista de la tabla*/
		list = user.findAllUser();
		LOG.info(LogConstants.EXTRAYENDO_INFO_TABLA_REGISTER);
		for (int i = 0; i < list.size(); i++) {
			/*Verificando mail existente*/
			if (userObj.getMail().equals(list.get(i).getMail())) {
				checkMail = true;
				break;
			}
		}
		/*Validando si el mail es correcto*/
		access = (checkMail) ? true : false;
		LOG.info(LogConstants.VALIDO + access);
		
		return String.valueOf(access);
	}

}
