package com.dxctraining.inventorymgt.item.service;

import java.util.List;

import com.dxctraining.inventorymgt.item.entities.Computer;
import com.dxctraining.inventorymgt.item.entities.Item;

public interface IItemService {
	Item findById(int id);
	Item addItem(Item item);
	Item updateItem(Item item);
	void removeItem(int id);
	List<Computer>computerlist();
	List<Computer> computersBySupplier(int supplierId);

}
