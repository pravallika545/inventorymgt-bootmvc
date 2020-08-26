package com.dxctraining.inventorymgt.item.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Computer extends Item {
	
	@Id
	@GeneratedValue
	private int id;
	private int discsize;
	
	public Computer() {
		
	}
	public Computer(String name, int supplierId, int discsize) {
		super(name, supplierId);
		this.discsize = discsize;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDiscsize() {
		return discsize;
	}
	public void setDiscsize(int discsize) {
		this.discsize = discsize;
	}

}
