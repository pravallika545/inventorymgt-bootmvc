package com.dxctraining.inventorymgt.item.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Phone extends Item {
	
	@Id
	@GeneratedValue
	private int id;
	private int storagesize;
	
	public Phone() {
		
	}
	
	public Phone(String name, int supplierId, int storagesize) {
		super(name, supplierId);
		this.storagesize = storagesize;
	}
	
	public Phone(String name, int storagesize) {
		super(name);
		this.storagesize = storagesize;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStoragesize() {
		return storagesize;
	}

	public void setStoragesize(int storagesize) {
		this.storagesize = storagesize;
	}
	
	

}
