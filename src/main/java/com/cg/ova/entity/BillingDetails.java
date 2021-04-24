package com.cg.ova.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BillingDetails {
	@Id
	private int billingId;
	private int orderId;
	private String transactionMode;
	private String transactionDate;
	private String tranactionStatus;
	@Embedded
	private Address address;
	public BillingDetails() {
		super();
	}
	public BillingDetails(int billingId, int orderId, String transactionMode, String transactionDate,
			String tranactionStatus, Address address) {
		super();
		this.billingId = billingId;
		this.orderId = orderId;
		this.transactionMode = transactionMode;
		this.transactionDate = transactionDate;
		this.tranactionStatus = tranactionStatus;
		this.address = address;
	}
	public int getBillingId() {
		return billingId;
	}
	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTranactionStatus() {
		return tranactionStatus;
	}
	public void setTranactionStatus(String tranactionStatus) {
		this.tranactionStatus = tranactionStatus;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "BillingDetails [billingId=" + billingId + ", orderId=" + orderId + ", transactionMode="
				+ transactionMode + ", transactionDate=" + transactionDate + ", tranactionStatus=" + tranactionStatus
				+ ", address=" + address + "]";
	}
	
	
	

}
