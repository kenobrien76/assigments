package com.mtt.service.impl;

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

	protected void setItemRepository(final ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	

}
