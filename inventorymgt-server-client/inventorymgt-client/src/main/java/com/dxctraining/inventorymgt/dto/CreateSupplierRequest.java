package com.dxctraining.inventorymgt.dto;

public class CreateSupplierRequest {
	
	private String name;
	private String password;

	public CreateSupplierRequest(String name, String password) {
		this.name = name;
		this.password = password;
	}
	public CreateSupplierRequest() {
		this("","");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
