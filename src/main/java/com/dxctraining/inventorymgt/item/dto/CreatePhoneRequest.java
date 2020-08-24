package com.dxctraining.inventorymgt.item.dto;

public class CreatePhoneRequest {
	
	private String name;
	private int storagesize;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStoragesize() {
		return storagesize;
	}
	public void setStoragesize(int storagesize) {
		this.storagesize = storagesize;
	}

}
