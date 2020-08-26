package com.dxctraining.inventorymgt.controllers;

import com.dxctraining.inventorymgt.dto.SupplierDto;
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

import com.dxctraining.inventorymgt.dto.CreateSupplierRequest;
import com.dxctraining.inventorymgt.dto.UpdateSupplierRequest;
import com.dxctraining.inventorymgt.entities.Supplier;
import com.dxctraining.inventorymgt.service.ISupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierRestController {
	
	@Autowired
	private ISupplierService service;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public SupplierDto createSupplier(@RequestBody CreateSupplierRequest supplier) {
		Supplier s1 = new Supplier(supplier.getName(), supplier.getPassword());
		s1 = service.addSupplier(s1);
		SupplierDto response = toDto(s1);
		return response;
	}

	public SupplierDto toDto(Supplier supplier) {
		SupplierDto dto = new SupplierDto();
		dto.setId(supplier.getId());
		dto.setName(supplier.getName());
		dto.setPassword(supplier.getPassword());
		return dto;
	}

	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public SupplierDto getSupplier(@PathVariable("id")int id) {
		Supplier s1 = service.findById(id);
		SupplierDto response = toDto(s1);
		return response;
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public SupplierDto updateSupplier(@RequestBody UpdateSupplierRequest supplier) {
		Supplier s1 = new Supplier(supplier.getName(),supplier.getPassword());
		s1.setId(supplier.getId());
		service.updateSupplier(s1);
		SupplierDto response = toDto(s1);
		return response;
	}
	
	@GetMapping("/authenticate/{id}/{password}")
	public boolean authenticate(@PathVariable("id")int id, @PathVariable("password")String password) {
		boolean status = service.authentication(id, password);
		return status;	
	}

}
