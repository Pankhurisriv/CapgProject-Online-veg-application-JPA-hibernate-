package com.cg.ova.entity;
import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Customer implements  Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	
	private String name;
	
	private String mobileNumber;
	
	@Embedded
	private Address address;
	
	private String emailId;
	private String password;
	private String confirmPassword;
	
	public Customer() {
		//no implementation
	}

	public Customer(String name, String mobileNumber, Address address, String emailId, String password,
			String confirmPassword) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.emailId = emailId;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	
	
	

	public  int getCustomerId() {
		return customerId;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", mobileNumber=" + mobileNumber + ", address="
				+ address + ", emailId=" + emailId + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ "]";
	}
	
}
