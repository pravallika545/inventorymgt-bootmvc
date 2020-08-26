package com.dxctraining.inventorymgt.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.inventorymgt.item.dao.IItemDao;
import com.dxctraining.inventorymgt.item.entities.Item;
import com.dxctraining.inventorymgt.item.entities.Phone;
import com.dxctraining.inventorymgt.item.exceptions.InvalidItemArgumentException;

@Transactional
@Service
public class ItemServiceImpl implements IItemService {
	
	@Autowired
	private IItemDao dao;
	
	@Override
	public Item findById(int id) {
		validateId(id);
		Item item = dao.findById(id);
		return item;
	}

	private void validateId(int id) {
		if(id == 0) {
			throw new InvalidItemArgumentException("id should not be null");
		}
		
	}


	@Override
	public Item addItem(Item item) {
		validateItem(item);
		item = dao.addItem(item);
		return item;
	}

	private void validateItem(Item item) {
		if(item == null) {
			throw new InvalidItemArgumentException("item is invalid");
		}
		
	}

	@Override
	public Item updateItem(Item item) {
		validateItem(item);
		item = dao.updateItem(item);
		return item;
	}

	@Override
	public void removeItem(int id) {
		dao.removeItem(id);
		
	}

	@Override
	public List<Phone> phonelist() {
		List<Phone>list = dao.phonelist();
		return list;
	}

	@Override
	public List<Phone> phonesBySupplier(int supplierId) {
		List<Phone>list = dao.phonesBySupplier(supplierId);
		return list;
	}

}
