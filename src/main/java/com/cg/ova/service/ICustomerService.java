package com.cg.ova.service;

import java.util.List;

import com.cg.ova.entity.Customer;
import com.cg.ova.exception.CustomerIdNotFoundException;
import com.cg.ova.exception.CustomerNotFoundInCityException;

public interface ICustomerService {
    public Customer add(Customer customer) throws CustomerIdNotFoundException;
	public Customer update(Customer customer)throws CustomerIdNotFoundException;
    public boolean  remove(Customer customer) throws CustomerIdNotFoundException;
	public Customer viewCustomer(int customerId) throws CustomerIdNotFoundException;
	public List<Customer> viewCustomerList(String location) throws CustomerNotFoundInCityException;

}
