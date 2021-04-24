package com.cg.ova.dao;

import java.util.List;

import com.cg.ova.entity.CartDTO;
import com.cg.ova.entity.VegetableDTO;
import com.cg.ova.exception.CartIdNotFoundException;
import com.cg.ova.exception.VegetableIdNotFoundException;

public interface ICartDAO {
	public VegetableDTO addToCart(VegetableDTO veg) throws VegetableIdNotFoundException;
	public CartDTO increaseVegQuantity(int vegId, int quantity) throws CartIdNotFoundException;
	public CartDTO decreaseVegQuantity(int vegId, int quantity) throws CartIdNotFoundException;
	public CartDTO removeVeg(int cartId) throws CartIdNotFoundException;
	public CartDTO removeAllVegetable() throws CartIdNotFoundException;
    public List<VegetableDTO> viewAllItems() throws CartIdNotFoundException;

}
