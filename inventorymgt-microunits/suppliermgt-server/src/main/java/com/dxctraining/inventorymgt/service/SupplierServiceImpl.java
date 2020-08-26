package com.dxctraining.inventorymgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.inventorymgt.dao.ISupplierDao;
import com.dxctraining.inventorymgt.entities.Supplier;
import com.dxctraining.inventorymgt.exceptions.InvalidSupplierArgumentException;
import com.dxctraining.inventorymgt.exceptions.SupplierNullException;

@Transactional
@Service
public class SupplierServiceImpl implements ISupplierService {
	
	@Autowired
	private ISupplierDao dao;
	
	@Override
	public Supplier findById(int id) {
		validateId(id);
		Supplier supplier = dao.findById(id);
		return supplier;
	}
	
	private void validateId(int id) {
		if(id == 0) {
			throw new InvalidSupplierArgumentException("id should not be null");
		}
		
	}

	@Override
	public Supplier addSupplier(Supplier supplier) {
		validateSupplier(supplier);
		dao.addSupplier(supplier);
		return supplier;
	}

	private void validateSupplier(Supplier supplier) {
		if(supplier == null) {
			throw new SupplierNullException("supplier is null");
		}
		
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		validateSupplier(supplier);
		dao.updateSupplier(supplier);
		return supplier;
	}


	@Override
	public void removeSupplier(int id) {
		validateId(id);
		dao.removeSupplier(id);
		
	}

	@Override
	public List<Supplier> listAll() {
		List<Supplier>listAll= dao.listAll();
		return listAll;
	}

	@Override
	public boolean authentication(int id, String password) {
		Supplier supplier = dao.findById(id);
		String fetchedpassword = supplier.getPassword();
		boolean equals = fetchedpassword.equals(password);
		return equals;
	}
	
}
