package com.cg.ova.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import com.cg.ova.dao.CustomerDAOImpl;
import com.cg.ova.dao.ICustomerDAO;
import com.cg.ova.entity.Address;
import com.cg.ova.entity.Customer;
import com.cg.ova.exception.CustomerIdNotFoundException;
import com.cg.ova.exception.CustomerNotFoundInCityException;
import java.util.ArrayList;


public class CustomerServiceImpl implements ICustomerService {
	
	private ICustomerDAO customerRepository;

	public CustomerServiceImpl() {
		customerRepository= new CustomerDAOImpl();
	}
	
	public boolean isValidCustomerId(int customerId) {
		return customerId!=0;
	}
	public boolean isValidName(String name) {
		return name!=null;
	}
	
	public boolean isValidMobileNumber(String mobileNumber) {
		return mobileNumber!=null;
	}
	
	public boolean isValidAddress(Address address) {
		return address.getFlatNo()!=null;
	}
	
	public boolean isValidEmailId(String emailId) {
		return emailId!=null;
	}
	public boolean isValidPassword(String password) {
		return password!=null;
	}
	public boolean isValidConfirmPassword(String Confirmpassword) {
		return Confirmpassword!=null;
	}
	
	
	public boolean isValidCustomer(Customer customer) throws CustomerIdNotFoundException {
		
	List<String> errorMesseges = new ArrayList<>();
	boolean isValid = true;
	
	if(customer!=null) {
		if(!isValidCustomerId(customer.getCustomerId())) {
			isValid=false;
			errorMesseges.add("Customer Id cannot be blank");
		}
		if(!isValidName(customer.getName())){
			isValid=false;
			errorMesseges.add(" Name cannot be blank");
		}
		
	
		
		if(!isValidMobileNumber(customer.getMobileNumber())) {
			isValid=false;
			errorMesseges.add("Mobile Number is not valid");
		}
		if(!isValidAddress(customer.getAddress())) {
			isValid=false;
			errorMesseges.add("Address is not valid");
		}
		
	}
	else { 
		isValid = false;
		throw new CustomerIdNotFoundException("Not Valid Customer");
	}
		return isValid;
	
}
	@Override
	public Customer add(Customer customer) throws CustomerIdNotFoundException {
	    if(isValidCustomer(customer))
	    	customerRepository.add(customer);
		return customer;
	}

	@Override
	public Customer update(Customer customer) throws CustomerIdNotFoundException {
		if(isValidCustomer(customer))
	    	customerRepository.update(customer);
		return customer;
	}

	@Override
	public boolean remove(Customer customer) throws CustomerIdNotFoundException {
		boolean isDeleted=false;
		if(isValidCustomer(customer)) {
	    	customerRepository.remove(customer);
	    	isDeleted=true;
		}
		return isDeleted;
	}

	@Override
	public Customer viewCustomer(int customerId) throws CustomerIdNotFoundException {
		customerRepository.viewCustomer(customerId);
		return viewCustomer(customerId);
	}

	@Override
	public List<Customer> viewCustomerList(String location) throws CustomerNotFoundInCityException {
		customerRepository.viewCustomerList(location);
		return viewCustomerList(location);
	}

}