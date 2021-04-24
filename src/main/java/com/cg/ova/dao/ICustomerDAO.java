package com.cg.ova.dao;

import java.util.List;

import com.cg.ova.entity.Customer;
import com.cg.ova.exception.CustomerIdNotFoundException;
import com.cg.ova.exception.CustomerNotFoundInCityException;

public interface ICustomerDAO {
	Customer add(Customer customer) throws CustomerIdNotFoundException;
	Customer update(Customer customer) throws CustomerIdNotFoundException;
	boolean	remove(Customer customerId) throws CustomerIdNotFoundException;
	Customer viewCustomer(int customerId) throws CustomerIdNotFoundException;
	List<Customer> viewCustomerList(String location) throws CustomerNotFoundInCityException;
	
}


