package com.ford.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_log_fd")
public class UserLog implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_log;
	
	@Column(name = "id_user")
	private int idUser;
	
	@Column(name = "date_log")
	private String dateLog;
	
	private String date_update_user;
	
	private String date_update_password;
	
	private String date_buy_car;
	
	private String date_end_payment;
	
	public UserLog() {
		super();
	}

	public int getId_log() {
		return id_log;
	}

	public void setId_log(int id_log) {
		this.id_log = id_log;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getDate_update_user() {
		return date_update_user;
	}

	public void setDate_update_user(String date_update_user) {
		this.date_update_user = date_update_user;
	}

	public String getDate_update_password() {
		return date_update_password;
	}

	public void setDate_update_password(String date_update_password) {
		this.date_update_password = date_update_password;
	}

	public String getDate_buy_car() {
		return date_buy_car;
	}

	public void setDate_buy_car(String date_buy_car) {
		this.date_buy_car = date_buy_car;
	}

	public String getDate_end_payment() {
		return date_end_payment;
	}

	public void setDate_end_payment(String date_end_payment) {
		this.date_end_payment = date_end_payment;
	}

	public String getDateLog() {
		return dateLog;
	}

	public void setDateLog(String dateLog) {
		this.dateLog = dateLog;
	}
	
}
