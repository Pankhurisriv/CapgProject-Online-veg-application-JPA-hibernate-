package com.cg.ova.service;

import com.cg.ova.entity.Admin;

public interface IAdminService {
	public Admin addAdmin(Admin admin);
	public Admin updateAdminDetails(Admin admin);
	public Admin removeAdmin(Admin admin);
	public Admin viewAdmin(Admin admin);

}
