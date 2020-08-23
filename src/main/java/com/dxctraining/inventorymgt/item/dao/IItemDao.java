package com.dxctraining.inventorymgt.item.dao;

import com.dxctraining.inventorymgt.item.entities.Item;

public interface IItemDao {
	Item findById(int id);
	Item addItem(Item item);
	Item updateItem(Item item);
	void removeItem(int id);

}
