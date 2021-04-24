package com.cg.ova.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.cg.ova.entity.Customer;
import com.cg.ova.entity.Order;
import com.cg.ova.entity.VegetableDTO;
import com.cg.ova.exception.CustomerNotFoundInCityException;
import com.cg.ova.exception.OrderIdNotFoundException;
import com.cg.ova.exception.VegetableIdNotFoundException;
import com.cg.ova.util.JPAutil;

public class VegetableMgmtDAOImpl implements IVegetableDAO {
	public final EntityManagerFactory emf = JPAutil.getEntityManagerFactory();
	public final EntityManager em = emf.createEntityManager();
	public final EntityTransaction txn = em.getTransaction();

	

	@Override
	public VegetableDTO addVegetable(VegetableDTO dto) throws VegetableIdNotFoundException {
		if (dto != null) {
			try {
				txn.begin();
				em.persist(dto);
				txn.commit();
			} catch (Exception excep) {
				throw new VegetableIdNotFoundException("Vegetable could not be inserted");
			}
		}
		return dto;
	}

	@Override
	public VegetableDTO updateVegetable(VegetableDTO dto) throws VegetableIdNotFoundException {
		if (dto != null) {
			try {
				txn.begin();
				em.merge(dto);
				txn.commit();
			} catch (Exception excep) {
				throw new VegetableIdNotFoundException("Vegetable could not be updated");
			}
		}
		else 
			em.persist(dto);
		return dto;
	
	}

	@Override
	public VegetableDTO removeVegetable(VegetableDTO dto) throws VegetableIdNotFoundException {
		if (dto!= null) {
			try {
				txn.begin();
				em.remove(dto);
				txn.commit();
			} catch (Exception excep) {
				throw new VegetableIdNotFoundException("Vegetable could not be deleted");
			}
		}
		return dto ;
	}

	@Override
	public VegetableDTO viewVegetable(VegetableDTO dto) throws VegetableIdNotFoundException {
		if(	 dto!=null) {
			try {
				dto=em.find(VegetableDTO.class, dto.getVegId());
			} catch (Exception excep) {
				throw new VegetableIdNotFoundException("Vegetable could not be found");
			}
		}
		return dto;
	}

	@Override
	public List<VegetableDTO> viewAllVegetables() throws VegetableIdNotFoundException {
		
		List<VegetableDTO> x = null;
		try {
			String jpql = "SELECT v FROM vegetable v";
			TypedQuery<VegetableDTO> tqry = em.createQuery(jpql,VegetableDTO.class);
			x = tqry.getResultList();
		}
		catch (Exception excep) {
			throw new VegetableIdNotFoundException("Vegetbale not found ");

		}
		return x;
		
	}

	@Override
	public List<VegetableDTO> viewVegetableList(String category) throws VegetableIdNotFoundException {
		List<VegetableDTO> x = null;
		try {
			String jpql = "SELECT v FROM vegetable v";
			TypedQuery<VegetableDTO> tqry = em.createQuery(jpql,VegetableDTO.class);
			x = tqry.getResultList();
		}
		catch (Exception excep) {
			throw new VegetableIdNotFoundException("Vegetbale not found of that category");

		}
		return x;
	}
	

	@Override
	public List<VegetableDTO> viewVegetableByName(String name) throws VegetableIdNotFoundException {
		List<VegetableDTO> x = null;
		try {
			String jpql = "SELECT v FROM vegetable v";
			TypedQuery<VegetableDTO> tqry = em.createQuery(jpql,VegetableDTO.class);
			x = tqry.getResultList();
		}
		catch (Exception excep) {
			throw new VegetableIdNotFoundException("vegetble not found of that name");

		}
		return x;
	}

}
