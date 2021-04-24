package com.cg.ova.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {
	@Id
	private int orderNo;
	private int custId;
	private List<VegetableDTO> vegList;
	private double totalAmount;
	private LocalDate orderDate;
	private String status;
	
	public Order() {
		//no implementation
	}
	
	public Order(int orderNo, int custId, List<VegetableDTO> vegList, double totalAmount, LocalDate orderDate,
			String status) {
		super();
		this.orderNo = orderNo;
		this.custId = custId;
		this.vegList = vegList;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
		this.status = status;
	}

	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public List<VegetableDTO> getVegList() {
		return vegList;
	}
	public void setVegList(List<VegetableDTO> vegList) {
		this.vegList = vegList;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", custId=" + custId + ", vegList=" + vegList + ", totalAmount="
				+ totalAmount + ", orderDate=" + orderDate + ", status=" + status + "]";
	}
	
	

}
