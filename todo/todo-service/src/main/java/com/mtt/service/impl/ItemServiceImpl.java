package com.mtt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mtt.presistance.model.Item;
import com.mtt.presistance.repository.ItemRepository;
import com.mtt.service.ItemService;
import com.mtt.service.exception.ItemNotFoundException;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
	
	@Resource
	private ItemRepository itemRepository;



	@Override
	public Item create(final Item item) {
		return itemRepository.save(item);
	}

	@Override
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	@Override
	public Item findById(final Long id) throws ItemNotFoundException {
		return itemRepository.findOne(id);
	}

	@Override
	public Item deleteById(Long id) throws ItemNotFoundException {
		final Item item = itemRepository.findOne(id);
		itemRepository.delete(id);
		return item;
	}
	

}
