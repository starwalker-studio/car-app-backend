package com.ford.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "car_info_fd")
public class CarInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_car_info;
	private String name;
	private String model;
	@OneToOne
	@JoinColumn(name = "id_type_car")
	private CarType carType;
	private String year;
	private String engine;
	private String transmission;
	private String cylinder;
	private String style;
	private String fuel_efficiency;
	private String series;
	private int top_speed;
	private int acceleration;
	private int brakes;
	private int fuel_percentaje;
	private String tune_car;
	private String more_car_info;
	private int price_car;

	public CarInfo() {
		super();
	}

	public int getId_car_info() {
		return id_car_info;
	}

	public void setId_car_info(int id_car_info) {
		this.id_car_info = id_car_info;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getCylinder() {
		return cylinder;
	}

	public void setCylinder(String cylinder) {
		this.cylinder = cylinder;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getFuel_efficiency() {
		return fuel_efficiency;
	}

	public void setFuel_efficiency(String fuel_efficiency) {
		this.fuel_efficiency = fuel_efficiency;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public int getTop_speed() {
		return top_speed;
	}

	public void setTop_speed(int top_speed) {
		this.top_speed = top_speed;
	}

	public int getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}

	public int getBrakes() {
		return brakes;
	}

	public void setBrakes(int brakes) {
		this.brakes = brakes;
	}

	public int getFuel_percentaje() {
		return fuel_percentaje;
	}

	public void setFuel_percentaje(int fuel_percentaje) {
		this.fuel_percentaje = fuel_percentaje;
	}

	public String getTune_car() {
		return tune_car;
	}

	public void setTune_car(String tune_car) {
		this.tune_car = tune_car;
	}

	public String getMore_car_info() {
		return more_car_info;
	}

	public void setMore_car_info(String more_car_info) {
		this.more_car_info = more_car_info;
	}

	public int getPrice_car() {
		return price_car;
	}

	public void setPrice_car(int price_car) {
		this.price_car = price_car;
	}

}
