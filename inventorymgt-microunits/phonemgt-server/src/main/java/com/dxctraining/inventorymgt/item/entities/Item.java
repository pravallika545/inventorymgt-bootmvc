package com.dxctraining.inventorymgt.item.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int supplierId;
	
	public Item() {
		
	}
	
	public Item(String name, int supplierId) {
		this.name = name;
		this.supplierId = supplierId;
	}
	
	public Item(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplier(int supplierId) {
		this.supplierId = supplierId;
	}
	@Override
	public int hashCode() {
		return id;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || !(o instanceof Item)) {
			return false;
		}
		Item that = (Item)o;
		boolean isequals = this.id == that.id;
		return isequals;
		
	}
}
