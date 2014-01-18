package com.mtt.service;

import com.mtt.presistance.model.Item;

public interface ItemService {
	
	/**
	 * Create an item
	 * @param item
	 * @return
	 */
	Item createItem(final Item item);

}
