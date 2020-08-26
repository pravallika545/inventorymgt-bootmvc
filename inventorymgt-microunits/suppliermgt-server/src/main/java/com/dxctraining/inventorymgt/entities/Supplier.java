package com.dxctraining.inventorymgt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Supplier {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String password;
	
	public Supplier(String name, String password) {
		this.name = name;
		this.password = password;
	}
	public Supplier() {
		this("","");
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
