package com.dxctraining.inventorymgt.service;

import java.util.List;

import com.dxctraining.inventorymgt.entities.Supplier;

public interface ISupplierService {
	Supplier findById(int id);
	Supplier addSupplier(Supplier supplier);
	Supplier updateSupplier(Supplier supplier);
	void removeSupplier(int id);
	List<Supplier>listAll();
	boolean authentication(int id, String password);
}
