package com.dxctraining.inventorymgt.supplier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.inventorymgt.supplier.dto.CreateSupplierRequest;
import com.dxctraining.inventorymgt.supplier.dto.UpdateSupplierRequest;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierRestController {
	
	@Autowired
	private ISupplierService service;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Supplier createSupplier(@RequestBody CreateSupplierRequest supplier) {
		Supplier s1 = new Supplier(supplier.getName(), supplier.getPassword());
		s1 = service.addSupplier(s1);
		return s1;	
	}
	
	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Supplier getSupplier(@PathVariable("id")int id) {
		Supplier s1 = service.findById(id);
		return s1;
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Supplier updateSupplier(@RequestBody UpdateSupplierRequest supplier) {
		Supplier s1 = new Supplier(supplier.getName(),supplier.getPassword());
		s1.setId(supplier.getId());
		return service.addSupplier(s1);
	}

}
