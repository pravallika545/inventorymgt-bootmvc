package com.dxctraining.inventorymgt.item.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;

@Entity
public class Computer extends Item {
	
	@Id
	@GeneratedValue
	private int id;
	private int discsize;
	
	public Computer() {
		
	}
	public Computer(String name, Supplier supplier, int discsize) {
		super(name, supplier);
		this.discsize = discsize;
	}
	public Computer(String name, int discsize) {
		super(name);
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
