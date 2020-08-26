package com.dxctraining.inventorymgt.item.controller;

import com.dxctraining.inventorymgt.item.dto.CreatePhoneRequest;
import com.dxctraining.inventorymgt.item.dto.PhoneDto;
import com.dxctraining.inventorymgt.item.dto.SupplierDto;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.entities.Phone;
import com.dxctraining.inventorymgt.item.service.IItemService;
import com.dxctraining.inventorymgt.item.util.PhoneUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(("/phone"))
public class PhoneRestController {

	@Autowired
	private IItemService service;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private PhoneUtil phoneUtil;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public PhoneDto add(@RequestBody CreatePhoneRequest requestData) {
		Phone phone = new Phone(requestData.getName(), requestData.getSupplierId(),requestData.getStoragesize());
		service.addItem(phone);
		SupplierDto supplierDto = fetchFromSupplierById(requestData.getSupplierId());
		PhoneDto response = phoneUtil.phoneDto(phone, supplierDto.getId(), supplierDto.getName());
		return response;
	}

	@GetMapping("/get/{id}")
	public PhoneDto getPhone(@PathVariable("id") int id) {
		Item item = service.findById(id);
		Phone phone = (Phone)item;
		int supplierId = phone.getSupplierId();
		SupplierDto supplierDto = fetchFromSupplierById(supplierId);
		PhoneDto response = phoneUtil.phoneDto(phone, supplierId, supplierDto.getName());
		return response;
	}

	@GetMapping
	public List<PhoneDto> fetchAll() {
		List<Phone> list = service.phonelist();
		List<PhoneDto> response = new ArrayList<>();
		for (Phone phone : list) {
			int supplierId = phone.getSupplierId();
			SupplierDto supplierDto = fetchFromSupplierById(supplierId);
			PhoneDto phoneDto = phoneUtil.phoneDto(phone, supplierId, supplierDto.getName());
			response.add(phoneDto);
		}
		return response;
	}

	@GetMapping("/supplier/{supplierId}")
	public List<PhoneDto> fetchAllPhonesBySupplier(@PathVariable("supplierId") int supplierId) {
		List<Phone> list = service.phonesBySupplier(supplierId);
		List<PhoneDto> response = new ArrayList<>();
		SupplierDto supplierDto = fetchFromSupplierById(supplierId);
		for (Phone phone : list) {
			PhoneDto phoneDto = phoneUtil.phoneDto(phone, supplierId, supplierDto.getName());
			response.add(phoneDto);
		}
		return response;
	}

	public SupplierDto fetchFromSupplierById(int supplierId) {
		String url = "http://localhost:8585/suppliers/get/" + supplierId;
		SupplierDto dto = restTemplate.getForObject(url, SupplierDto.class);
		return dto;
	}

}
