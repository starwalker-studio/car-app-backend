package com.ford.app.rest.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ford.app.model.UserCode;
import com.ford.app.model.UserRegister;
import com.ford.app.service.IUserCode;
import com.ford.app.service.IUserService;
import com.ford.app.util.FordEndPoints;
import com.ford.app.util.LogConstants;
import com.ford.app.util.UtilConstants;

@RestController
@RequestMapping("/auth")
public class RestSendMail {
	
	private static final Logger LOG = Logger.getLogger(RestSendMail.class);	
	private static final String USED_CODE = "false";	

	@Autowired
	private JavaMailSender javaMail;
	
	@Autowired
	private IUserCode userCode;
	
	@Autowired
	private IUserService user;
	
	@RequestMapping(value = FordEndPoints.ENVIAR_CORREO, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String sendMail(@RequestBody UserRegister userObj) {
		
		List<UserRegister> list = new ArrayList<UserRegister>();
		Random randomNumber = new Random();
		Date date = new Date();
		SimpleDateFormat todayFormat = new SimpleDateFormat(UtilConstants.DATE_FORMAT);
		int idUser = 0;
		UserCode userCodeObj = new UserCode();
		UserRegister userRegisterObj = new UserRegister();
		SimpleMailMessage email = new SimpleMailMessage();
		boolean checkMail = false;
		boolean codeExist = false;
		
		LOG.info(LogConstants.RENOVAR_CONTRASENA);
		/*Extrayendo lista de la tabla*/
		list = user.findAllUser();
		LOG.info(LogConstants.VALIDANDO_CORREO + userObj.getMail());
		LOG.info(LogConstants.EXTRAYENDO_INFO_TABLA_REGISTER);
		for (int i = 0; i < list.size(); i++) {
			/*Verificando mail existente*/
			if (userObj.getMail().equals(list.get(i).getMail())) {
				/*Extrayendo id del usuario*/
				idUser = list.get(i).getId_user();
				checkMail = true;
				break;
			}
		}		
		if (checkMail) {
			LOG.info(LogConstants.CORREO_ENCONTRADO);
			int random = randomNumber.nextInt((UtilConstants.MATH_RANDOM_NINE_THOUSAND - UtilConstants.MATH_RANDOM_THOUSAND) 
					+ UtilConstants.MATH_RANDOM_ONE) + UtilConstants.MATH_RANDOM_THOUSAND;
			userCodeObj.setCode(random);
			userCodeObj.setDate_require(todayFormat.format(date));
			userRegisterObj.setId_user(idUser);
			userCodeObj.setUserRegister(userRegisterObj);
			userCodeObj.setUsed_code(USED_CODE);
			/*Iniciando registro en BD en tabla: user_code_confirm*/ 
			LOG.info(LogConstants.REGISTRO_TABLA_USER_CODE);
			userCode.saveCode(userCodeObj);
			String subject = UtilConstants.CODE_ACTIVATION;
			String msg = 
					UtilConstants.GREETINGS
					+ UtilConstants.SALTO_DE_LINEA
					+ UtilConstants.SALTO_DE_LINEA 
					+ UtilConstants.HERE_IS_YOUR_CODE
					+ UtilConstants.PELASE_ENTER_THIS_CODE + String.valueOf(random) 
					+ UtilConstants.SALTO_DE_LINEA
					+ UtilConstants.SALTO_DE_LINEA 
					+ UtilConstants.SALTO_DE_LINEA
					+ UtilConstants.FORD_WEB_SITE 
					+ UtilConstants.SALTO_DE_LINEA 
					+ UtilConstants.SALTO_DE_LINEA
					+ UtilConstants.DO_NOT_REPLY;
			/* Construyendo correo */
			email.setTo(userObj.getMail());
			email.setSubject(subject);
			email.setText(msg);
			
			LOG.info(LogConstants.ENVIANDO_CORREO_A + userObj.getMail());
			/* Enviando correo */
			javaMail.send(email);
			codeExist = true;
		} else {
			LOG.info(LogConstants.CORREO_INEXISTENTE);
		}

		return String.valueOf(codeExist);

	}
	
}
