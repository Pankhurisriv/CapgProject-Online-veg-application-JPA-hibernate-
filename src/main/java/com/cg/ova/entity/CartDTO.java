package com.cg.ova.entity;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class CartDTO {
	private int cartId;
	private int custId;
	private List<VegetableDTO> vegetables;
	
	public CartDTO() {
		//no implementation
	}
	
	
	public CartDTO(int cartId, int custId, List<VegetableDTO> vegetables) {
		super();
		this.cartId = cartId;
		this.custId = custId;
		this.vegetables = vegetables;
	}

	
   public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public List<VegetableDTO> getVegetables() {
		return vegetables;
	}
	public void setVegetables(List<VegetableDTO> vegetables) {
		this.vegetables = vegetables;
	}


	@Override
	public String toString() {
		return "CartDTO [cartId=" + cartId + ", custId=" + custId + ", vegetables=" + vegetables + "]";
	}
	
	

}
