package com.dxctraining.inventorymgt.supplier.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.dxctraining.inventorymgt.item.entities.Item;

@Entity
public class Supplier {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "supplier")
	private Set<Item> item;
	
	public Supplier(String name) {
		this.name = name;
	}
	public Supplier() {
		this("");
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
	@Override
	public int hashCode() {
		return id;
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || !(o instanceof Supplier)) {
			return false;
		}
		Supplier that = (Supplier)o;
		boolean isequals = this.id == that.id;
		return isequals;
		
	}

}
