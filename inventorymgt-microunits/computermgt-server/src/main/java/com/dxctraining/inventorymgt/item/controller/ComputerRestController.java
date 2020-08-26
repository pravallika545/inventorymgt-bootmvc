package com.dxctraining.inventorymgt.item.controller;

import com.dxctraining.inventorymgt.item.dto.ComputerDto;
import com.dxctraining.inventorymgt.item.dto.CreateComputerRequest;
import com.dxctraining.inventorymgt.item.dto.SupplierDto;
import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.service.IItemService;
import com.dxctraining.inventorymgt.item.util.ComputerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/computer")
public class ComputerRestController {
	
	@Autowired
	private IItemService service;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ComputerUtil computerUtil;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ComputerDto add(@RequestBody CreateComputerRequest requestData) {
		Computer computer = new Computer(requestData.getName(), requestData.getSupplierId(),requestData.getDiscsize());
		service.addItem(computer);
		SupplierDto supplierDto = fetchFromSupplierById(requestData.getSupplierId());
		ComputerDto response = computerUtil.computerDto(computer, supplierDto.getId(), supplierDto.getName());
		return response;
	}

	@GetMapping("/get/{id}")
	public ComputerDto getPhone(@PathVariable("id") int id) {
		Item item = service.findById(id);
		Computer computer = (Computer) item;
		int supplierId = computer.getSupplierId();
		SupplierDto supplierDto = fetchFromSupplierById(supplierId);
		ComputerDto response = computerUtil.computerDto(computer, supplierId, supplierDto.getName());
		return response;
	}

	@GetMapping
	public List<ComputerDto> fetchAll() {
		List<Computer> list = service.computerlist();
		List<ComputerDto> response = new ArrayList<>();
		for (Computer computer : list) {
			int supplierId = computer.getSupplierId();
			SupplierDto supplierDto = fetchFromSupplierById(supplierId);
			ComputerDto computerDto = computerUtil.computerDto(computer, supplierId, supplierDto.getName());
			response.add(computerDto);
		}
		return response;
	}

	@GetMapping("/supplier/{supplierId}")
	public List<ComputerDto> fetchAllComputersBySupplier(@PathVariable("supplierId") int supplierId) {
		List<Computer> list = service.computersBySupplier(supplierId);
		List<ComputerDto> response = new ArrayList<>();
		SupplierDto supplierDto = fetchFromSupplierById(supplierId);
		for (Computer computer : list) {
			ComputerDto computerDto = computerUtil.computerDto(computer, supplierId, supplierDto.getName());
			response.add(computerDto);
		}
		return response;
	}

	public SupplierDto fetchFromSupplierById(int supplierId) {
		String url = "http://localhost:8585/suppliers/get/" + supplierId;
		SupplierDto dto = restTemplate.getForObject(url, SupplierDto.class);
		return dto;
	}
}
