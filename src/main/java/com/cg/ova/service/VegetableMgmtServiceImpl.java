package com.cg.ova.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.ova.dao.IVegetableDAO;
import com.cg.ova.dao.VegetableMgmtDAOImpl;
import com.cg.ova.entity.VegetableDTO;
import com.cg.ova.exception.VegetableIdNotFoundException;

public class VegetableMgmtServiceImpl implements IVegetableMgmtService {

  private IVegetableDAO   vegetableMgmtDAO;
	  
	  public VegetableMgmtServiceImpl() {
		  vegetableMgmtDAO = new VegetableMgmtDAOImpl();
	  }
	  public boolean isValidvegId(int  vegId) {
		  return vegId!=0;
	  }
	  public boolean isValidName(String  name) {
		  return name!=null;
	  }
	  public boolean isValidType(String  type) {
		  return type!=null;
	  }
	  public boolean isValidCategory(String  Category) {
		  return Category!=null;
	  }
	  public boolean isValidPrice(double  price) {
		  return price!=0;
	  }
	  public boolean isValidQuantity(int quantity) {
			return quantity!=0;
	  }
	  public boolean isValidvegetable(VegetableDTO dto){
			
			List<String> errorMesseges = new ArrayList<>();
			boolean isValid = true;
			
			if(dto!=null) {
				if(!isValidvegId(dto.getVegId())) {
					isValid=false;
					errorMesseges.add("Veg Id cannot be blank");
				}
				if(!isValidName(dto.getName())) {
					isValid=false;
					errorMesseges.add(" Name cannot be blank");
				}
				if(!isValidType(dto.getType())) {
					isValid=false;
					errorMesseges.add("type is not valid");
				}
				if(!isValidCategory(dto.getCategory())) {
					isValid=false;
					errorMesseges.add("category cannot be blank");
				}
				if(!isValidPrice(dto.getPrice())) {
					isValid=false;
					errorMesseges.add("price cannot be blank");
				}
				if(!isValidQuantity(dto.getQuantity())) {
					isValid=false;
					errorMesseges.add("quantity cannot be blank");
				}
				
			}else isValid = false;
			return isValid;
		}
			

	public VegetableDTO addVegetable(VegetableDTO dto) {
		if(isValidvegetable(dto))
			vegetableMgmtDAO.addVegetable(dto);
	return dto;
	}

	public VegetableDTO updateVegetable(VegetableDTO dto) {
		if(isValidvegetable(dto))
			vegetableMgmtDAO.updateVegetable(dto);
	return dto;
	}

	public VegetableDTO removeVegetable(VegetableDTO dto) throws VegetableIdNotFoundException {
		if(isValidvegetable(dto))
			vegetableMgmtDAO.removeVegetable(dto);
	return dto;
	}

	public VegetableDTO viewVegetable(VegetableDTO dto) throws VegetableIdNotFoundException {
		return vegetableMgmtDAO.viewVegetable(dto);
		
	}

	public List<VegetableDTO> viewAllVegetables() throws VegetableIdNotFoundException {
		 return vegetableMgmtDAO.viewAllVegetables();
		
	}

	public List<VegetableDTO> viewVegetableList(String category) throws VegetableIdNotFoundException {
		return vegetableMgmtDAO.viewVegetableList(category);
		
	}

	public List<VegetableDTO> viewVegetableByName(String name) throws VegetableIdNotFoundException {
		vegetableMgmtDAO.viewVegetableByName(name);
		return null;
	}

}
