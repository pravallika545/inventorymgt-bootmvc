package com.dxctraining.inventorymgt.item.service;

import java.util.List;

import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.entities.Phone;

public interface IItemService {
	Item findById(int id);
	Item addItem(Item item);
	Item updateItem(Item item);
	void removeItem(int id);
	List<Phone>phonelist();
	List<Phone>phonesBySupplier(int supplierId);
}
