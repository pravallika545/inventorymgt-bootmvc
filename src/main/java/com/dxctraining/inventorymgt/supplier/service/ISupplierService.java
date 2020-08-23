package com.dxctraining.inventorymgt.supplier.service;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;

public interface ISupplierService {
	Supplier findById(int id);
	Supplier addSupplier(Supplier supplier);
	Supplier updateSupplier(Supplier supplier);
	void removeSupplier(int id);
}
