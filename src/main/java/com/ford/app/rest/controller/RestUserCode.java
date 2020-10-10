package com.ford.app.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ford.app.model.UserCode;
import com.ford.app.service.IUserCode;
import com.ford.app.util.FordEndPoints;
import com.ford.app.util.LogConstants;
import com.ford.app.util.UtilConstants;

@RestController
@RequestMapping("/auth")
public class RestUserCode {
	
	private static final Logger LOG = Logger.getLogger(RestUserCode.class);
	
	@Autowired
	private IUserCode userCode;
	
	@RequestMapping(value = FordEndPoints.VERIFICAR_CODIGO, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String verificarCodigo(@RequestBody UserCode enterCodeUser) {
		UserCode response = userCode.verifyCode(enterCodeUser.getCode());		
		LOG.info(LogConstants.VALIDANDO_CODIGO + enterCodeUser.getCode() + LogConstants.SEPARATOR + response.getUsed_code());
		return response.getUsed_code();
	}
	
	@RequestMapping(value = FordEndPoints.ACTUALIZAR_CODIGO, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String actualizarCodigoInactivo(@RequestBody UserCode enterCodeUser) {
		UserCode response = userCode.verifyCode(enterCodeUser.getCode());
		response.setUsed_code(UtilConstants.USED_CODE_VALUE_TRUE);
		userCode.saveCode(response);
		LOG.info(LogConstants.ACTUALIZANDO_CODIGO + enterCodeUser.getCode() + LogConstants.SEPARATOR + response.getUsed_code());
		return UtilConstants.RESPONSE_BOOLEAN;
	}
	
}
