package com.dxctraining.inventorymgt.ui;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.entities.Phone;
import com.dxctraining.inventorymgt.item.service.IItemService;
import com.dxctraining.inventorymgt.supplier.entities.Supplier;
import com.dxctraining.inventorymgt.supplier.exceptions.InvalidSupplierArgumentException;
import com.dxctraining.inventorymgt.supplier.exceptions.SupplierNullException;
import com.dxctraining.inventorymgt.supplier.service.ISupplierService;

@Component
public class InventoryUi {
	
	@Autowired
	private ISupplierService supplierService;
	
	@Autowired
	private IItemService itemService;
	
	@PostConstruct
	public void runUi() {
		try {
			List<Item> list = new ArrayList<>();
			Supplier supplier1 = new Supplier("fazil","1111");
			supplierService.addSupplier(supplier1);
			Supplier supplier2 = new Supplier("adil","2222");
			supplierService.addSupplier(supplier2);
			Supplier supplier3 = new Supplier("mustaq","3333");
			supplierService.addSupplier(supplier3);
			
			Item item1 = new Item("phone", supplier1);
			list.add(item1);
			itemService.addItem(item1);
			Item item2 = new Item("Computer", supplier2);
			list.add(item2);
			itemService.addItem(item2);
			Item item3 = new Item("laptop", supplier3);
			list.add(item3);
			itemService.addItem(item3);
			
			Phone item4 = new Phone("Apple", supplier1, 256);
			list.add(item4);
			itemService.addItem(item4);
			Phone item5 = new Phone("Oneplus", supplier2, 128);
			list.add(item5);
			itemService.addItem(item5);
			
			Computer item6 = new Computer("Hp",supplier1,1024);
			list.add(item6);
			itemService.addItem(item6);
			Computer item7 = new Computer("Dell",supplier2, 2048);
			list.add(item7);
			itemService.addItem(item7);
			
			System.out.println("*****Fetching supplier by id*****");
			int id1 = supplier1.getId();
			Supplier fetched = supplierService.findById(id1);
			System.out.println("fetched id is "+fetched.getId()+" fetched supplier = "+fetched.getName());
			
			System.out.println("*****Deleting an item******");
			int itemid3 = item3.getId();
			itemService.removeItem(itemid3);
			System.out.println("removed item id is "+itemid3);
			
			System.out.println("******Fetching item by id******");
			int itemid1 = item1.getId();
			Item itemfetched = itemService.findById(itemid1);
			Supplier itemSupplier = itemfetched.getSupplier();
			System.out.println("fetched item id is "+itemid1+" fetched item name is "+itemfetched.getName()+" item supplier is "+itemSupplier.getName());
			
			System.out.println("*****Displaying all items*****");
			for(Item item:list) {
				displayAllItems(item);
			}
			
		}catch (InvalidSupplierArgumentException e) {
			e.printStackTrace();
		}catch (SupplierNullException e) {
			e.printStackTrace();
		}
		
	}

	public void displayAllItems(Item item) {
		if(item instanceof Phone) {
			phone(item);
		}
		if(item instanceof Computer) {
			computer(item);
		}
		
		System.out.println("item id :"+item.getId()+" item name :"+item.getName()+" item supplier :"+item.getSupplier().getName());
	}

	private void computer(Item item) {
		Computer c = (Computer)item;
		System.out.println(" model name :"+c.getName()+" disc size :"+c.getDiscsize());
		
	}

	private void phone(Item item) {
		Phone ph = (Phone)item;
		System.out.println(" model name :"+ph.getName()+" storage :"+ph.getStoragesize());
	}

}
