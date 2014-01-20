package com.mtt.presistance.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.mtt.presistance.PresistanceAppContext;
import com.mtt.presistance.model.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PresistanceAppContext.class})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class })
//@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
//    DirtiesContextTestExecutionListener.class,
//    TransactionalTestExecutionListener.class,
//    DbUnitTestExecutionListener.class })
//@DatabaseSetup("itemsData.xml")
public class ItemRepositoryTest {
	
	@Autowired
	private ItemRepository itemRepository;
	
	
	@Test
	public void createItemTest() {
		Item item = new Item();
		item.setDescription("My First Item");
		item = itemRepository.save(item);
		assertNotNull(item);
		assertNotNull(item.getId() );
	}
	
	
	
	@Test
	public void findItemTest() {
		//replace with dbunit
		Item item = new Item();
		item.setDescription("My First Item");
		item = itemRepository.save(item);
		
		
	     Item foundItem = itemRepository.findOne(item.getId());
	     assertNotNull(foundItem);
	     assertEquals(item.getId(), foundItem.getId());
	     assertEquals(item.getDescription(), foundItem.getDescription());
	     assertEquals(item.getCreationTime(), foundItem.getCreationTime());
	     assertEquals(item.getModificationTime(), foundItem.getModificationTime());
	}
	
	
	@Test
	public void itemNotFoundExceptionItemTest() {
		//replace with dbunit
		Item item = new Item();
		item.setDescription("My First Item");
		item = itemRepository.save(item);
		
		
	     Item foundItem = itemRepository.findOne(item.getId());
	     assertNotNull(foundItem);
	     assertEquals(item.getId(), foundItem.getId());
	     assertEquals(item.getDescription(), foundItem.getDescription());
	     assertEquals(item.getCreationTime(), foundItem.getCreationTime());
	     assertEquals(item.getModificationTime(), foundItem.getModificationTime());
	}
	
	@Test
	public void itemDeleteTest() {
		//replace with dbunit
		Item item = new Item();
		item.setDescription("My First Item");
		item = itemRepository.save(item);
				
		itemRepository.delete(item.getId());
		
		assertFalse(itemRepository.exists(item.getId()));
	}



}
