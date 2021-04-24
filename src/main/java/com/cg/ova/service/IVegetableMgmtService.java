package com.cg.ova.service;

import java.util.List;

import com.cg.ova.entity.VegetableDTO;
import com.cg.ova.exception.VegetableIdNotFoundException;

public interface IVegetableMgmtService {
	public VegetableDTO addVegetable(VegetableDTO dto) throws VegetableIdNotFoundException;
	public VegetableDTO updateVegetable(VegetableDTO dto) throws VegetableIdNotFoundException;
	public VegetableDTO removeVegetable(VegetableDTO dto)throws VegetableIdNotFoundException;
	public VegetableDTO viewVegetable(VegetableDTO dto) throws VegetableIdNotFoundException;
	public List<VegetableDTO> viewAllVegetables() throws VegetableIdNotFoundException;
	public List<VegetableDTO> viewVegetableList(String category) throws VegetableIdNotFoundException;
	public List<VegetableDTO> viewVegetableByName(String name) throws VegetableIdNotFoundException;

}
