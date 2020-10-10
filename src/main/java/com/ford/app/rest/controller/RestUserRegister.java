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

import com.ford.app.model.UserRegister;
import com.ford.app.service.IUserService;
import com.ford.app.util.FordEndPoints;
import com.ford.app.util.LogConstants;
import com.ford.app.util.UtilConstants;

@RestController
@RequestMapping("/auth")
public class RestUserRegister {

	private static final Logger LOG = Logger.getLogger(RestUserRegister.class);

	@Autowired
	private IUserService user;
	
	/*Service for register user*/

	@RequestMapping(value = FordEndPoints.REGISTRAR_USUARIO, method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserRegister register(@RequestBody UserRegister userObj) {
		Date date = new Date();
		SimpleDateFormat todayFormat = new SimpleDateFormat(UtilConstants.DATE_FORMAT);
		boolean usuarioExistente;
		boolean mailUsuarioExistente = false;
		boolean contraseñaUsuarioExistente = false;
		UserRegister userRegistered = new UserRegister();
		userObj.setDate_register(todayFormat.format(date));

		LOG.info(LogConstants.VALIDAR_USUARIO_MSJ);
		userRegistered = user.findByMail(userObj.getMail());

		LOG.info(LogConstants.VALIDAR_CORREO_MSJ);
		try {			
			if (userRegistered.getMail() != null) {
				mailUsuarioExistente = true;
				LOG.info(LogConstants.MAIL_EXISTENTE + mailUsuarioExistente);
			}
		} catch (NullPointerException e) {
			mailUsuarioExistente = false;
		}
	
		userRegistered = user.findByPassword(userObj.getPassword());
		LOG.info(LogConstants.VALIDAR_CONTRASENA_MSJ);
		try {			
			if (userRegistered.getPassword() != null) {
				contraseñaUsuarioExistente = true;
				LOG.info(LogConstants.CONTRASENA_EXISTENTE + contraseñaUsuarioExistente);
			}
		} catch (NullPointerException e) {
			contraseñaUsuarioExistente = false;
		}

		usuarioExistente = (mailUsuarioExistente || contraseñaUsuarioExistente) ? true : false;

		if (usuarioExistente) {
			LOG.info(LogConstants.USUARIO_EXISTENTE_TBL_REGISTRO);
			userRegistered = new UserRegister();
			userRegistered.setId_user(0);
		} else {
			LOG.info(LogConstants.USUARIO_INEXISTENTE);
			LOG.info(LogConstants.NAME + userObj.getName());
			LOG.info(LogConstants.LAST_NAME + userObj.getLast_name());
			LOG.info(LogConstants.MAIL + userObj.getMail());
			LOG.info(LogConstants.PASSWORD + userObj.getPassword());
			LOG.info(LogConstants.DATE + userObj.getDate_register());
			LOG.info(LogConstants.LOCATION + userObj.getLocation());
			LOG.info(LogConstants.ACTIVE_ACCOUNT + userObj.getActive());
			if (userObj.getUserCategory().getId_user_category() == 1) {
				LOG.info(LogConstants.ADMIN + userObj.getUserCategory().getId_user_category());
			} else {
				LOG.info(LogConstants.USER + userObj.getUserCategory().getId_user_category());
			}
			LOG.info(LogConstants.REGISTRO_TABLA_USER_REGISTER);
			user.registerNewUser(userObj);
			userRegistered = user.findByMail(userObj.getMail());			
		}

		return userRegistered;

	}

}
