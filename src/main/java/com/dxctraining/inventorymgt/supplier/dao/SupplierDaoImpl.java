package com.dxctraining.inventorymgt.supplier.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.SupplierNullException;

@Repository
public class SupplierDaoImpl implements ISupplierDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Supplier findById(int id) {
		Supplier supplier = em.find(Supplier.class, id);
		if(supplier == null) {
			throw new SupplierNullException("Supplier is null");
		}
		return supplier;
	}

	@Override
	public Supplier addSupplier(Supplier supplier) {
		em.persist(supplier);
		return supplier;
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		em.merge(supplier);
		return supplier;
	}

	@Override
	public void removeSupplier(int id) {
		Supplier supplier = findById(id);
		em.remove(supplier);
		
	}


}
