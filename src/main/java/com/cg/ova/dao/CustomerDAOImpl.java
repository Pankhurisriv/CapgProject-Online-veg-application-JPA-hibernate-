package com.cg.ova.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import com.cg.ova.entity.Customer;
import com.cg.ova.exception.CustomerIdNotFoundException;
import com.cg.ova.exception.CustomerNotFoundInCityException;
import com.cg.ova.util.JPAutil;

public class CustomerDAOImpl implements ICustomerDAO {
	
	public final EntityManagerFactory emf = JPAutil.getEntityManagerFactory();
	public final EntityManager em = emf.createEntityManager();
	public final EntityTransaction txn = em.getTransaction();

	@Override
	public Customer add(Customer customer) throws CustomerIdNotFoundException {
		if (customer != null) {
			try {
				txn.begin();
				em.persist(customer);
				txn.commit();
			} catch (Exception excep) {
				throw new CustomerIdNotFoundException("Customer could not be inserted");
			}
		}
		return customer;
	}

	@Override
	public Customer update(Customer customer) throws CustomerIdNotFoundException {
		if (customer != null) {
			try {
				txn.begin();
				em.merge(customer);
				txn.commit();
			} catch (Exception excep) {
				throw new CustomerIdNotFoundException("Customer could be inserted");
			}
		}
		else
			em.persist(customer);
		return customer;
	}

	@Override
	public boolean remove(Customer customerId) throws CustomerIdNotFoundException {
		boolean isDeleted= false;
		if (customerId != null) {
			try {
				txn.begin();
				em.remove(customerId);
				txn.commit();
				isDeleted=true;
			} catch (Exception excep) {
				throw new CustomerIdNotFoundException("Customer Not Found");

			}
		}
		return isDeleted;
	}


	@Override
	public Customer viewCustomer(int customerId) throws CustomerIdNotFoundException {
		
		Customer c= null;
		try {
				c=em.find(Customer.class, customerId);
			}

			catch (Exception excep) {
				throw new CustomerIdNotFoundException("Customer Not found");

			}
		return c;
	}

	@Override
	public List<Customer> viewCustomerList(String location) throws CustomerNotFoundInCityException {
		List<Customer> x = null;
		try {
			String jpql = "SELECT c FROM customer c";
			TypedQuery<Customer> tqry = em.createQuery(jpql,Customer.class);
			x = tqry.getResultList();
		}
		catch (Exception excep) {
			throw new CustomerNotFoundInCityException("Customer not found on that location");

		}
		return x;
	}
}