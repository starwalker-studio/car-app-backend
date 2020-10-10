package com.ford.app.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ford.app.model.CarInfo;
import com.ford.app.service.ICarInfo;
import com.ford.app.util.FordEndPoints;
import com.ford.app.util.LogConstants;
import com.ford.app.util.UtilConstants;

@RestController
@RequestMapping("/auth")
public class RestInfoCar {
	
	private static final Logger LOG = Logger.getLogger(RestInfoCar.class);
	
	@Autowired
	private ICarInfo service;
	
	@RequestMapping(value = FordEndPoints.INSERTAR_NUEVO_AUTO, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String insertNewCar(@RequestBody CarInfo car) {
		LOG.info(LogConstants.CREANDO_NUEVO_AUTO);
		LOG.info(LogConstants.NOMBRE_AUTO + car.getName());
		LOG.info(LogConstants.MODELO + car.getModel());
		LOG.info(LogConstants.TIPO_DE_AUTO + car.getCarType().getId_type_car());
		LOG.info(LogConstants.ANO + car.getYear());
		LOG.info(LogConstants.MOTOR + car.getEngine());
		LOG.info(LogConstants.TRANSMICION + car.getTransmission());
		LOG.info(LogConstants.CILINDROS + car.getCylinder());
		LOG.info(LogConstants.ESTILO + car.getStyle());
		LOG.info(LogConstants.COMBUSTIBLE_EFICIENCIA + car.getFuel_efficiency());
		LOG.info(LogConstants.SERIE + car.getSeries());
		LOG.info(LogConstants.TOP_SPEED + car.getTop_speed());
		LOG.info(LogConstants.ACELERACION + car.getAcceleration());
		LOG.info(LogConstants.FRENOS + car.getBrakes());
		LOG.info(LogConstants.PORCENTAJE_COMBUSTIBLE + car.getFuel_percentaje());
		LOG.info(LogConstants.TUNE + car.getTune_car());
		LOG.info(LogConstants.MAS_INFO + car.getMore_car_info());
		LOG.info(LogConstants.PRECIO + car.getPrice_car());		
		service.saveCar(car);
		return UtilConstants.RESPONSE_BOOLEAN;
	}

}
