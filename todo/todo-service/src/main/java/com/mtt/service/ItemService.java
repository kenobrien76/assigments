package com.mtt.service;

import java.util.List;

import com.mtt.presistance.model.Item;
import com.mtt.service.exception.ItemNotFoundException;

public interface ItemService {
	
	/**
	 * Create an item
	 * @param item
	 * @return
	 */
	Item create(final Item item);
	
	/**
	 * 
	 * @return
	 */
	List<Item> findAll();
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Item findById(final Long id) throws ItemNotFoundException;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Item deleteById(final Long id)  throws ItemNotFoundException;

}
