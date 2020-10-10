package com.ford.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car_type_fd")
public class CarType implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_type_car;

	private String type_car;

	public CarType() {
		super();
	}

	public int getId_type_car() {
		return id_type_car;
	}

	public void setId_type_car(int id_type_car) {
		this.id_type_car = id_type_car;
	}

	public String getType_car() {
		return type_car;
	}

	public void setType_car(String type_car) {
		this.type_car = type_car;
	}	

}
