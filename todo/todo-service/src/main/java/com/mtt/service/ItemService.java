package com.mtt.service;

import java.util.List;

import com.mtt.presistance.model.Item;

public interface ItemService {
	
	/**
	 * Create an item
	 * @param item
	 * @return
	 */
	Item createItem(final Item item);
	
	/**
	 * 
	 * @return
	 */
	List<Item> getAllItems();
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Item requestItem(final Long id);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	void deleteItem(final Long id);

}
