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
			Supplier supplier1 = new Supplier("pravallika");
			supplierService.addSupplier(supplier1);
			Supplier supplier2 = new Supplier("pebbi");
			supplierService.addSupplier(supplier2);
			Supplier supplier3 = new Supplier("sai");
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
			
			System.out.println("Fetching supplier by id");
			int id1 = supplier1.getId();
			Supplier fetched = supplierService.findById(id1);
			System.out.println("fetched id is "+fetched.getId()+" fetched supplier = "+fetched.getName());
			
			System.out.println("Deleting an item");
			int itemid3 = item3.getId();
			itemService.removeItem(itemid3);
			System.out.println("removed item id is "+itemid3);
			
			System.out.println("Fetching item by id");
			int itemid1 = item1.getId();
			Item itemfetched = itemService.findById(itemid1);
			System.out.println("fetched item id is "+itemfetched.getId()+" fetched item name is "+itemfetched.getName());
			
			System.out.println("Displaying all  items");
			for(Item item:list) {
				displayItems(item);
			}
			
		}catch (InvalidSupplierArgumentException e) {
			e.printStackTrace();
		}catch (SupplierNullException e) {
			e.printStackTrace();
		}
		
	}

	public void displayItems(Item item) {
		if(item instanceof Phone) {
			Phone(item);
		}
		if(item instanceof Computer) {
			computer(item);
		}
		System.out.println("item id is "+item.getId()+" item name is "+item.getName()+" item supplier is "+item.getSupplier());
		
	}

	public void computer(Item item) {
		Computer c = (Computer)item;
		System.out.println("model name is "+c.getName()+" disc space is"+c.getDiscsize());
	}

	public void Phone(Item item) {
		Phone p = (Phone)item;
		System.out.println("model name is "+p.getName()+" storage is "+p.getStoragesize());
	}

}
