package com.mtt.service.impl;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.mtt.presistance.repository.ItemRepository;
import com.mtt.service.ItemService;



public class ItemServiceImplTest {
	
	private static final Long ITEM_ID = Long.valueOf(1);
    private static final String DESCRIPTION = "My firsts item";
    
    private ItemServiceImpl itemService;
    private ItemRepository mockItemRepository;
    
    
    @Before
    public void setup(){
    	itemService = new ItemServiceImpl();
    	mockItemRepository = mock(ItemRepository.class);
    	itemService.setItemRepository(mockItemRepository);
    }
    
	@Test
	public void Create() {
	}

}
