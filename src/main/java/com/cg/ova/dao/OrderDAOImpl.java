package com.cg.ova.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.cg.ova.entity.Customer;
import com.cg.ova.entity.Order;
import com.cg.ova.exception.CustomerIdNotFoundException;
import com.cg.ova.exception.OrderIdNotFoundException;
import com.cg.ova.util.JPAutil;

public class OrderDAOImpl implements IOrderDAO {
public final EntityManagerFactory emf = JPAutil.getEntityManagerFactory();
public final EntityManager em = emf.createEntityManager();
public final EntityTransaction txn = em.getTransaction();


@Override
public Order addOrder(Order order) throws OrderIdNotFoundException {
	if (order != null) {
		try {
			txn.begin();
			em.persist(order);
			txn.commit();
		} catch (Exception excep) {
			throw new OrderIdNotFoundException("Order could not be inserted");
		}
	}
	return order;
}

@Override
public Order updateOrder(Order order) throws OrderIdNotFoundException  {
	if (order != null) {
		try {
			txn.begin();
			em.merge(order);
			txn.commit();
		} catch (Exception excep) {
			throw new OrderIdNotFoundException("Order could not be updated");
		}
	}
	else 
		em.persist(order);
	return order;
}

@Override
public Order cancelOrder(Order order) throws OrderIdNotFoundException {
	if (order!= null) {
		try {
			txn.begin();
			em.remove(order);
			txn.commit();
		} catch (Exception excep) {
			throw new OrderIdNotFoundException("Order could not be deleted");
		}
	}
	return order ;
}

@Override
public Order viewOrderList(Order order) throws OrderIdNotFoundException  {
if(	 order!=null) {
	try {
		order=em.find(Order.class, order.getOrderNo());
	} catch (Exception excep) {
		throw new OrderIdNotFoundException("Order could not be found");
	}
}
return order;
}

@Override
public List<Order> viewAllOrders(LocalDate orderDate) throws OrderIdNotFoundException {
	List<Order> x = null;
	try {
		String jpql = "SELECT e FROM order e";
		TypedQuery<Order> tqry = em.createQuery(jpql,Order.class);
		x = tqry.getResultList();
	}
	catch (Exception excep) {
		throw new OrderIdNotFoundException("Order is not found");

	}
	return x;
}

@Override
public List<Order> viewAllOrders(Customer customer) throws OrderIdNotFoundException {
	
	List<Order> x = null;
	try {
		String jpql = "SELECT o FROM ORDER o WHERE EXISTS (Select f FROM CARTDTO f WHERE EXISTS (SELECT c FROM CUSTOMER c WHERE c.customerId = ?1))";
		TypedQuery<Order> tqry = em.createQuery(jpql,Order.class);
		tqry.setParameter(1, customer.getCustomerId());
		x = tqry.getResultList();
	}
	catch (Exception excep) {
		throw new OrderIdNotFoundException("Customer id not found");

	}
	return x;
}

}



	

	