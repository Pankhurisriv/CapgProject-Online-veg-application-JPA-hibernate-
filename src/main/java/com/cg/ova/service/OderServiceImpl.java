package com.cg.ova.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.cg.ova.dao.IOrderDAO;
import com.cg.ova.dao.OrderDAOImpl;
import com.cg.ova.entity.Customer;
import com.cg.ova.entity.Order;
import com.cg.ova.entity.VegetableDTO;
import com.cg.ova.exception.OrderIdNotFoundException;

public class OderServiceImpl implements IOrderService {
	private  IOrderDAO orderRepository;
	
	public void OrderServiceImpl() {
		orderRepository= new OrderDAOImpl();
	}
	
	public boolean isValidOrderNo(int orderNo) {
		return orderNo>0;
	}
	public boolean isValidCustId(int custId) {
		return custId>0;
	}
	
	
	public boolean isValidVegetableCart(List<VegetableDTO> list) {
		return list!=null;
	}
	public boolean isValidTotalAmount(double totalAmount) {
		return totalAmount>0;
	}
	
	public boolean isValidLocalDate (LocalDate orderDate) {
		return orderDate != null && orderDate.isBefore(LocalDate.now());
	}
	public boolean isValidOrderStatus(String status) {
		return status!=null;
	}
	
	
	public boolean isValidOrder(Order order) throws OrderIdNotFoundException {
		List<String> errorMesseges = new ArrayList<>();
		boolean isValid = true;
		
		if(order!= null) {
			         if(!isValidOrderNo(order.getOrderNo())){
			        	 isValid = false;
						 errorMesseges.add("Order id cannot be blank and must be a positive number");
						}
			         if(!isValidCustId(order.getCustId())){
			        	 isValid = false;
						 errorMesseges.add("Customer id cannot be blank and must be a positive number");
						}
			         if(!isValidVegetableCart(order.getVegList())) {
			        	 isValid = false;
						 errorMesseges.add("Cart id cannot be blank ");
						}
			         if(!isValidTotalAmount(order.getTotalAmount())){
			        	 isValid = false;
						 errorMesseges.add("Amount cannot be blank and must be a positive number");
						}
			         
			         if(!isValidLocalDate(order.getOrderDate())){
			        	 isValid = false;
						 errorMesseges.add("Order date cannot be blank and must be a present or past date");
						}
			         	 
			         if(!isValidOrderStatus(order.getStatus())) {
			        	 isValid = false;
						 errorMesseges.add("Order Status is not valid.");
						}
			        	 
			   }else {
				   isValid = false;
				   throw new OrderIdNotFoundException("Contact details are not supplied");
				}
				return isValid;
			        	 
			}
	@Override
	public Order addOrder(Order order) throws OrderIdNotFoundException{
		if(isValidOrder(order)) {
			orderRepository.addOrder(order);
		}
		return order;
		
	}

	
	@Override
	public Order updateOrder(Order order) throws OrderIdNotFoundException  {
		if(isValidOrder(order)) {
			orderRepository.updateOrder(order);
		}
		return order;
	}

	
	@Override
	public Order viewOrderList(Order order) throws OrderIdNotFoundException {
		if(isValidOrder(order)) {
			orderRepository.viewOrderList(order);
		}
		return order;
	}


	@Override
	public Order cancelOrder(Order order) throws OrderIdNotFoundException {
		if(isValidOrder(order)) {
			orderRepository.addOrder(order);
		}
		return order;
		
	}
	
	@Override
	public List<Order> viewAllOrders(LocalDate orderDate) throws OrderIdNotFoundException  {
			return orderRepository.viewAllOrders(orderDate);
		
	}

	@Override
	public List<Order> viewAllOrders(Customer customer) throws OrderIdNotFoundException {
		
		return orderRepository.viewAllOrders(customer);
	}

}
