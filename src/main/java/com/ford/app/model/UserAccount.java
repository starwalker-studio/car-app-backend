package com.ford.app.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_account_fd")
public class UserAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_user_account;
	
	@Column(name = "id_user")
	private int iduser;

	private String car_selection;

	@OneToOne
	@JoinColumn(name = "id_car")
	private CarInfo car;

	private String card_register;

	private BigInteger card_number;

	private String payment_account;

	private BigInteger amount_account;

	private String table_detail_payment;

	private String table_detail_icon;

	public UserAccount() {
		super();
	}

	public int getId_user_account() {
		return id_user_account;
	}

	public void setId_user_account(int id_user_account) {
		this.id_user_account = id_user_account;
	}

	public String getCar_selection() {
		return car_selection;
	}

	public void setCar_selection(String car_selection) {
		this.car_selection = car_selection;
	}

	public String getCard_register() {
		return card_register;
	}

	public void setCard_register(String card_register) {
		this.card_register = card_register;
	}

	public BigInteger getCard_number() {
		return card_number;
	}

	public void setCard_number(BigInteger card_number) {
		this.card_number = card_number;
	}

	public String getPayment_account() {
		return payment_account;
	}

	public void setPayment_account(String payment_account) {
		this.payment_account = payment_account;
	}

	public BigInteger getAmount_account() {
		return amount_account;
	}

	public void setAmount_account(BigInteger amount_account) {
		this.amount_account = amount_account;
	}

	public String getTable_detail_payment() {
		return table_detail_payment;
	}

	public void setTable_detail_payment(String table_detail_payment) {
		this.table_detail_payment = table_detail_payment;
	}

	public String getTable_detail_icon() {
		return table_detail_icon;
	}

	public void setTable_detail_icon(String table_detail_icon) {
		this.table_detail_icon = table_detail_icon;
	}
	
	public CarInfo getCar() {
		return car;
	}

	public void setCar(CarInfo car) {
		this.car = car;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

}
