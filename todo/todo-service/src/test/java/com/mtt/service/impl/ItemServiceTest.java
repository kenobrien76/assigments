package com.mtt.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mtt.presistance.model.Item;
import com.mtt.service.ItemService;
import com.mtt.service.ServiceAppContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceAppContext.class})
public class ItemServiceTest {
	
	@Autowired
	private ItemService itemService;

	@Test
	public void testAddNewItem() {
		Item item = new Item();
		item.setDescription("my first item");
		item = itemService.create(item);
		
		assertNotNull(item);	
		}

}
