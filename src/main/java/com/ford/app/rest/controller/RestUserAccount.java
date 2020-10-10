package com.ford.app.rest.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ford.app.model.UserAccount;
import com.ford.app.service.IUserAccount;
import com.ford.app.util.FordEndPoints;
import com.ford.app.util.LogConstants;

@RestController
@RequestMapping("/auth")
public class RestUserAccount {
	
	private static final Logger LOG = Logger.getLogger(RestUserAccount.class);
	
	@Autowired
	private IUserAccount iuserAccount;
	
	@RequestMapping(value = FordEndPoints.BUSCAR_CUENTA_DE_USUARIO_ID + "/{id}", method = RequestMethod.GET,
			 produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserAccount> searchAccount(@PathVariable("id") int idUser) {		
		LOG.info(LogConstants.SEARCHING_USER_ACCOUNT);
		LOG.info(LogConstants.ID_USER + idUser);
		return iuserAccount.findByIdUser(idUser);
	}
	
	@RequestMapping(value = FordEndPoints.REGISTRAR_USUARIO_CUENTA, method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveAccount(@RequestBody UserAccount account) {
		LOG.info(LogConstants.GUARDANDO_NUEVA_CUENTA_USUARIO);
		LOG.info(LogConstants.USUARIO_CUENTA + account.getIduser());
		iuserAccount.saveAccount(account);
	}

}
