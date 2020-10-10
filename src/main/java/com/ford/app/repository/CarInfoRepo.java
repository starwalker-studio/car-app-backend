package com.ford.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ford.app.model.CarInfo;

public interface CarInfoRepo extends JpaRepository<CarInfo, Integer> {

}
