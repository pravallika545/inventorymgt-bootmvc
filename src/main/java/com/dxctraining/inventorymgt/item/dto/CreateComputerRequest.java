package com.dxctraining.inventorymgt.item.dto;

public class CreateComputerRequest {
	
	private String name;
	private int disksize;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDisksize() {
		return disksize;
	}
	public void setDisksize(int disksize) {
		this.disksize = disksize;
	}
	
}
