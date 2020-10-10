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
@Table(name = "user_code_fd")
public class UserCode implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_code;
	
	private int code;
	
	private String date_require;
	
	@OneToOne
	@JoinColumn(name = "id_user")
	private UserRegister userRegister;
	
	private String used_code;
	
	public UserCode() {
		super();
	}

	public int getId_code() {
		return id_code;
	}

	public void setId_code(int id_code) {
		this.id_code = id_code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDate_require() {
		return date_require;
	}

	public void setDate_require(String date_require) {
		this.date_require = date_require;
	}

	public UserRegister getUserRegister() {
		return userRegister;
	}

	public void setUserRegister(UserRegister userRegister) {
		this.userRegister = userRegister;
	}

	public String getUsed_code() {
		return used_code;
	}

	public void setUsed_code(String used_code) {
		this.used_code = used_code;
	}	
	
}
