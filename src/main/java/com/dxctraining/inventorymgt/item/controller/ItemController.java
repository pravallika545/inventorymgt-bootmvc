package com.dxctraining.inventorymgt.item.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt.item.dto.CreateComputerRequest;
import com.dxctraining.inventorymgt.item.dto.CreatePhoneRequest;
import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.entities.Phone;
import com.dxctraining.inventorymgt.item.service.IItemService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Controller
public class ItemController {
	
	@Autowired
	private IItemService service1;
	
	@Autowired
	private ISupplierService service2;
	
	@PostConstruct
	public void init() {
		Supplier supplier1 = new Supplier("adil","2222");
		service2.addSupplier(supplier1);
		Supplier supplier2 = new Supplier("fazil","1111");
		service2.addSupplier(supplier2);
		
		Computer computer1 = new Computer("Hp",supplier1,1024);
		service1.addItem(computer1);
		Phone phone1 = new Phone("Apple",supplier2, 64);
		service1.addItem(phone1);
	}
	
	@GetMapping("/computers")
	public ModelAndView AllComputers() {
		List<Computer>computer = service1.computerlist();
		System.out.println("inside computers method, computers="+computer);
		ModelAndView modelAndView = new ModelAndView("computerlist", "computers", computer);
		return modelAndView;	
	}
	
	@GetMapping("/phones")
	public ModelAndView Allphones() {
		List<Phone>phone =service1.phonelist();
		System.out.println("inside phones method, phones="+phone);
		ModelAndView modelAndView = new ModelAndView("phonelist","phones", phone);
		return modelAndView;
	}
	
	@GetMapping("/addcomputer")
	public ModelAndView addComputer() {
		ModelAndView modelAndView = new ModelAndView("addcomputer");
		return modelAndView;
	}
	
	@GetMapping("/processaddcomputer")
	public ModelAndView processAddComputer(@RequestParam("name")String name, @RequestParam("discsize")int discsize) {
		Computer computer = new Computer(name, discsize);
		Item item = (Item)computer;
		item = service1.addItem(item);
		ModelAndView modelAndView = new ModelAndView("processaddcomputer","computer",item);
		return modelAndView;
	}
	
	@GetMapping("/postaddcomputer")
	public ModelAndView postAddComputer() {
		CreateComputerRequest computer = new CreateComputerRequest();
		ModelAndView modelAndView = new ModelAndView("postaddcomputer","computer",computer);
		return modelAndView;
	}
	
	@GetMapping("/addphone")
	public ModelAndView addPhone() {
		ModelAndView modelAndView = new ModelAndView("addphone");
		return modelAndView;
	}
	@GetMapping("/processaddphone")
	public ModelAndView processAddPhone(@RequestParam("name")String name, @RequestParam("storagesize")int storagesize) {
		Phone phone = new Phone(name, storagesize);
		Item item = (Item)phone;
		item = service1.addItem(item);
		ModelAndView modelAndView = new ModelAndView("processaddphone","phone",item);
		return modelAndView;
	}
	
	@GetMapping("/postaddphone")
	public ModelAndView postAddPhone() {
		CreatePhoneRequest phone = new CreatePhoneRequest();
		ModelAndView modelAndView = new ModelAndView("postaddphone","phone",phone);
		return modelAndView;
	}

}
