package com.dxctraining.inventorymgt.supplier.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.supplier.dto.CreateSupplierRequest;
import com.dxctraining.inventorymgt.supplier.dto.SessionData;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Controller
public class SupplierController {
	
	@Autowired
	private ISupplierService service;
	
	@Autowired
	private SessionData sessionData;
	
	@PostConstruct
	public void init() {
		Supplier supplier1 = new Supplier("fazil","1111");
		int id1 = supplier1.getId();
		supplier1 = service.addSupplier(supplier1);
		
		Supplier supplier2 = new Supplier("adil","2222");
		int id2 = supplier2.getId();
		supplier2 = service.addSupplier(supplier2);
		
	}
	
	@GetMapping("/supplier")
	public ModelAndView supplierDetails(@RequestParam("id")int id) {
		if(!sessionData.isUserLoggedin()) {
			return new ModelAndView("login");
		}
		Supplier supplier = service.findById(id);
		ModelAndView modelAndView = new ModelAndView("supplierdetails", "supplier", supplier);
		return modelAndView;	
	}
	
	@GetMapping("/supplierlist")
	public ModelAndView allSuppliers() {
		if(!sessionData.isUserLoggedin()) {
			return new ModelAndView("login");
		}
		List<Supplier>listAll = service.listAll();
		ModelAndView modelAndView = new ModelAndView("supplierlist","suppliers",listAll);
		return modelAndView;
	}
	
	@GetMapping("/register")
	public ModelAndView registerSupplier() {
		ModelAndView modelAndView = new ModelAndView("register");
		return modelAndView;	
	}
	
	@GetMapping("/processregister")
	public ModelAndView processRegister(@RequestParam("name")String name, @RequestParam("password")String password) {
		Supplier supplier = new Supplier(name,password);
		supplier = service.addSupplier(supplier);
		ModelAndView modelAndView = new ModelAndView("details","supplier",supplier);
		return modelAndView;
	}
	
	@GetMapping("/postregister")
	public ModelAndView postRegister() {
		CreateSupplierRequest newSupplier = new CreateSupplierRequest();
		ModelAndView modelAndView = new ModelAndView("postregister","supplier",newSupplier);
		return modelAndView;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@GetMapping("/processlogin")
	public ModelAndView processLogin(@RequestParam("id")int id,@RequestParam("password")String password) {
		boolean correct = service.authentication(id,password);
		if(correct) {
			sessionData.saveLogin(id);
			Supplier supplier = service.findById(id);
			ModelAndView modelAndView = new ModelAndView("details","supplier",supplier);
			return modelAndView;
		}
			ModelAndView modelAndView = new ModelAndView("login");
			return modelAndView;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout() {
		sessionData.clear();
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	

}
