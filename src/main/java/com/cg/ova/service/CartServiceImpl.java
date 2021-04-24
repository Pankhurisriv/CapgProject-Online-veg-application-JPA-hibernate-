package com.cg.ova.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.ova.dao.CartDAOImpl;
import com.cg.ova.dao.ICartDAO;
import com.cg.ova.entity.CartDTO;
import com.cg.ova.entity.Customer;
import com.cg.ova.entity.VegetableDTO;
import com.cg.ova.exception.CartIdNotFoundException;
import com.cg.ova.exception.VegetableIdNotFoundException;

public class CartServiceImpl implements ICartService {
private ICartDAO CartRepository;
	
	public CartServiceImpl() {
		CartRepository= new CartDAOImpl();
	}
	
	public boolean isValidCartId(int cartId) {
		return cartId !=0;
		}
	
	public boolean isValidcustomer(Customer customer) {
		return customer.getCustomerId()!=0;
	}
	public boolean isValidItem(List<VegetableDTO> vegetables) {
		return vegetables!=null;
	}
	
	public boolean isValidCart(CartDTO cart) throws CartIdNotFoundException{
	
	List<String> errorMesseges = new ArrayList<>();
	boolean isValid = true;
	
	if (cart!=null) {
		if(!isValidCartId(cart.getCartId())) {
			isValid=false;
			errorMesseges.add("Cart Id cannot be blank");
		}
		
		if(!isValidcustomer(cart.getCustomer())) {
			isValid=false;
			errorMesseges.add("Customer cannot be blank");
		}
		
		if(!isValidItem(cart.getVegetables())) {
			isValid=false;
			errorMesseges.add("Vegetable List cannot be empty");
		}
	}
	else {
		isValid = false;
		throw new CartIdNotFoundException("Cart details are not supplied");
	}
	return isValid;

    }
 

	public VegetableDTO addToCart(VegetableDTO veg) throws  VegetableIdNotFoundException {
		if(isValidCart(veg)) {
			CartRepository.addItemToCart();
		}
		return VegetableDTO;
	
	}

	public FoodCart increaseQuantity(FoodCart cart, Item item, int quantity) throws OFDAException {
		if(isValidCart(cart)) {
			CartRepository.increaseQuantity(cart, item, quantity);
		}
		return cart;
	}
	

	public FoodCart reduceQuantity(FoodCart cart, Item item, int quantity) throws OFDAException {
		if(isValidCart(cart)){
			CartRepository.reduceQuantity(cart, item, quantity);
		}
		return cart;
	}

	public FoodCart removeItem(FoodCart cart, Item item) throws OFDAException {
		if(isValidCart(cart)) {
			CartRepository.removeItem(cart, item);
		}
		return cart;
	}
	public FoodCart clearCart(FoodCart cart) throws OFDAException {
		if(isValidCart(cart)) {
			CartRepository.clearCart(cart);
		}
		return cart;
	}

	@Override
	public VegetableDTO addToCart(VegetableDTO veg) throws VegetableIdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDTO increaseVegQuantity(int vegId, int quantity) throws CartIdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDTO decreaseVegQuantity(int vegId, int quantity) throws CartIdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDTO removeVeg(int cartId) throws CartIdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDTO removeAllVegetable() throws CartIdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VegetableDTO> viewAllItems() throws CartIdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
