package com.dxctraining.inventorymgt.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.dto.*;

@Controller
public class SupplierController {
	
	@Autowired
    private SessionData sessionData;

    @Autowired
    private RestTemplate restTemplate;

    private final String baseUrl="http://localhost:8585/suppliers";
	
	@GetMapping("/supplier")
	public ModelAndView supplierDetails(@RequestParam("id")int id) {
		if(!sessionData.isUserLoggedin()) {
			return new ModelAndView("login");
		}
		SupplierDto supplier = findSupplierById(id);
		ModelAndView modelAndView = new ModelAndView("supplierdetails", "supplier", supplier);
		return modelAndView;	
	}
	
	public SupplierDto findSupplierById(int id) {
		String url = baseUrl + "/get/" +id;
		SupplierDto supplier = restTemplate.getForObject(url, SupplierDto.class);
		return supplier;
	}

	@GetMapping("/supplierlist")
	public ModelAndView allSuppliers() {
		if(!sessionData.isUserLoggedin()) {
			return new ModelAndView("login");
		}
		String url = baseUrl;
		SupplierDto[] array = restTemplate.getForObject(url, SupplierDto[].class);
		List<SupplierDto>listAll = Arrays.asList(array);
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
		CreateSupplierRequest supplier = new CreateSupplierRequest(name,password);
		String url = baseUrl + "/add";
		SupplierDto supplierDto = restTemplate.postForObject(url,supplier, SupplierDto.class);
		ModelAndView modelAndView = new ModelAndView("details","supplier",supplierDto);
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
		String url = baseUrl+"/authenticate/" + id + "/" + password;
		boolean correct = restTemplate.getForObject(url, Boolean.class);
		if(correct) {
			sessionData.saveLogin(id);
			SupplierDto supplier = findSupplierById(id);
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
