package com.dxctraining.inventorymgt.item.service;

import com.dxctraining.inventorymgt.item.entities.Item;

public interface IItemService {
	Item findById(int id);
	Item addItem(Item item);
	Item updateItem(Item item);
	void removeItem(int id);

}
