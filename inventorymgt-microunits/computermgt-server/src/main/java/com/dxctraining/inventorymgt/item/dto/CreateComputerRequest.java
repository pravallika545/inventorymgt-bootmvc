package com.dxctraining.inventorymgt.item.dto;

public class CreateComputerRequest {
	
	private String name;
	private int discsize;
	private int supplierId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDiscsize() {
		return discsize;
	}
	public void setDiscsize(int disksize) {
		this.discsize = disksize;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
}
