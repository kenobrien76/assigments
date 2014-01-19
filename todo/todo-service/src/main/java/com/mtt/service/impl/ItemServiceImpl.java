package com.mtt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mtt.presistance.model.Item;
import com.mtt.presistance.repository.ItemRepository;
import com.mtt.service.ItemService;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
	
	@Resource
	private ItemRepository itemRepository;

	@Override
	public Item createItem(final Item item) {
		return itemRepository.save(item);
	}

	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public Item requestItem(final Long id) {
		return itemRepository.findOne(id);
	}

	@Override
	public void deleteItem(final Long id) {
		itemRepository.delete(id);
	}
	

}
