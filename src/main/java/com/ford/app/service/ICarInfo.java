package com.ford.app.service;

import java.util.List;

import com.ford.app.model.CarInfo;

public interface ICarInfo {
	
	List<CarInfo> findAllCars();
	
	void saveCar(CarInfo car);

}
