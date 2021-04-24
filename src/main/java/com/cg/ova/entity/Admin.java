package com.cg.ova.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	private int adminId;
	private String name;
	private String contactNumber;
	
	public Admin() {
		//no implementation
	}
	
	
	
	public Admin(int adminId, String name, String contactNumber) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.contactNumber = contactNumber;
	}



	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

    @Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", contactNumber=" + contactNumber + "]";
	}
	
	

}
