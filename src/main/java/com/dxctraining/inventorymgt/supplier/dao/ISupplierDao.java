package com.dxctraining.inventorymgt.supplier.dao;

import java.util.List;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;

public interface ISupplierDao {
	Supplier findById(int id);
	Supplier addSupplier(Supplier supplier);
	Supplier updateSupplier(Supplier supplier);
	void removeSupplier(int id);
	List<Supplier> listAll();
}
