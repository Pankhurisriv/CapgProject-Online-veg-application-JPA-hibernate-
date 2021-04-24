package com.cg.ova.ui;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import com.cg.ova.entity.Customer;
import com.cg.ova.util.JPAutil;

public class CustomerApplication {

	public static void main(String[] args) {
		  
	   
			Scanner sc=new Scanner(System.in);
			CustomerMenu[] menus=CustomerMenu.values();
			CustomerMenu selectedmenu=null;
			while(selectedmenu!=CustomerMenu.QUIT) {
				System.out.println("Choice\tOperation");
				for(CustomerMenu m:menus) {
				System.out.println(m.ordinal() + "\t" + m);
				}
				System.out.println("Enter Choice : ");
				int ch= sc.nextInt();
				
				if(ch>=0 && ch<=menus.length) {
					selectedmenu = menus[ch];
					
					switch(selectedmenu) {
					case ADD : 
						doAdd();
						break;
					case UPDATE : 
						doUpdate();
						break;
					case REMOVE : 
						doRemove();
						break;
					case VIEW : 
						doView();
						break;
					case QUIT:
						break;
					}
				}else {
					selectedmenu =null;
					System.out.println("Invalid Choice");
				}
			}
			sc.close();
			System.out.println("Application Terminated");
		}
			
	       private static void doAdd(){
	    	   
			//program to add data in  contact table
	    	   
			EntityManagerFactory factory=JPAutil.getEntityManagerFactory();
			EntityManager em=factory.createEntityManager();
			Customer customer=new Customer();
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter Customer full name");
			customer.setName(scan.next());
			System.out.println("Enter customer mobile number");
			customer.setMobileNumber(scan.next());
			System.out.println("Enter Contact address");
			//customer.setAddress(scan.next());
			
			System.out.println("Enter Customer email");
			customer.setEmailId(scan.next());
			System.out.println("Enter Customer password");
			customer.setPassword(scan.next());
			System.out.println("Re-Type the password");
			customer.setConfirmPassword(scan.next());
			
		    System.out.println("Customer Added Sucessfully");

			EntityTransaction txn= em.getTransaction();
			txn.begin();
			em.persist(customer);
		    txn.commit();
			scan.close();
			JPAutil.shutdown();
			}
	        
		   private static void doView() {
			   
			//program to view data in contact table
			   
			EntityManagerFactory factory=JPAutil.getEntityManagerFactory();
			EntityManager em=factory.createEntityManager();
			
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter Customer id");
			int customerId=scan.nextInt();
			
			Customer customer=em.find(Customer.class,customerId);
			if(customer!=null) {
				System.out.println(customer);
				}else {
				System.out.println("Customer "+ customerId	+"is not Found");
				}
			
			scan.close();
			JPAutil.shutdown();
			
		}
		
		   private static void doRemove() {
			   
			//program to delete data from contact table
			
			EntityManagerFactory factory=JPAutil.getEntityManagerFactory();
	        EntityManager em=factory.createEntityManager();
	        Scanner scan=new Scanner(System.in);
	        System.out.println("Enter Customer id");
	        int customerId=scan.nextInt();
	        
	        Customer customer=em.find(Customer.class,customerId);
	        if(customer!=null) {
	        	EntityTransaction txn=em.getTransaction();
	        	txn.begin();
	        	em.remove(customer);
	        	txn.commit();
	        	System.out.println("Customer "+ customerId	+"is removed");
	        	}else {
	        	System.out.println("Contact "+ customerId	+"is not found");
	        	}
	        scan.close();
	        JPAutil.shutdown();
			
		}
		   
		 private static void doUpdate() {
			 
			//program to update data in contact table
			 
			EntityManagerFactory factory=JPAutil.getEntityManagerFactory();
			EntityManager em=factory.createEntityManager();
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter Customer id :");
			int customerId=scan.nextInt();
			
			Customer customer=em.find(Customer.class,customerId);
			
			if(customer!=null) {
				EntityTransaction txn=em.getTransaction();
				System.out.println("Enter new mobile no:");
				String modifiedmobile = scan.next();
				customer.setMobileNumber(modifiedmobile);
				txn.begin();
				em.merge(customer);
				txn.commit();
				System.out.println("customer "+ customerId	+"is updated");
				}else {
				System.out.println("customer #"+ customerId	+"is not found");
				}
			scan.close();
			JPAutil.shutdown();
			
		}

	}


