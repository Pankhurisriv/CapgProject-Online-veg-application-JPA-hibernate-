package com.cg.ova.dao;

import java.time.LocalDate;
import java.util.List;
import com.cg.ova.entity.Customer;
import com.cg.ova.entity.Order;
import com.cg.ova.exception.OrderIdNotFoundException;

public interface IOrderDAO {
	public Order addOrder(Order order) throws OrderIdNotFoundException ;
	public Order updateOrder(Order order) throws OrderIdNotFoundException ;
	public Order cancelOrder(Order order) throws OrderIdNotFoundException ;
	public Order viewOrderList(Order order) throws OrderIdNotFoundException ;
	public List<Order> viewAllOrders(LocalDate orderDate) throws OrderIdNotFoundException;
	public List<Order> viewAllOrders(Customer customer) throws OrderIdNotFoundException;
	
}


