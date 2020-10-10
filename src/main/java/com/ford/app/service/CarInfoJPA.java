package com.ford.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ford.app.model.CarInfo;
import com.ford.app.repository.CarInfoRepo;

@Service
public class CarInfoJPA implements ICarInfo {
	
	@Autowired
	private CarInfoRepo carRepo;

	@Override
	public List<CarInfo> findAllCars() {
		return carRepo.findAll();
	}

	@Override
	public void saveCar(CarInfo car) {
		carRepo.save(car);
	}

}
