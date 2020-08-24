package com.dxctraining.inventorymgt.dao;

import java.util.List;

import com.dxctraining.inventorymgt.entities.Supplier;

public interface ISupplierDao {
	Supplier findById(int id);
	Supplier addSupplier(Supplier supplier);
	Supplier updateSupplier(Supplier supplier);
	void removeSupplier(int id);
	List<Supplier> listAll();
}
