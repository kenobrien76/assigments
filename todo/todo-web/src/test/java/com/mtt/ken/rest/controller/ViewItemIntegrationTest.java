package com.mtt.ken.rest.controller;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

import com.mtt.presistance.model.Item;
import com.mtt.service.ItemService;
import com.mtt.ken.rest.controller.ItemQueriesController;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;

public class ViewItemIntegrationTest {
	
	
	MockMvc mockMvc;
	@InjectMocks
	ItemQueriesController itemQueriesController = new ItemQueriesController();
	@Mock
	ItemService itemService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		this.mockMvc = standaloneSetup(itemQueriesController)
				.setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
	}
	
	@Test
	public void thatViewItemHttpNotFound() throws Exception {

	    when(itemService.requestItem(any(Long.class))).thenReturn(null);

	    this.mockMvc.perform(
	            get("/rest/items/1")
                .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isNotFound());
	  }
	
	
	@Test
	public void thatViewItemHttpOK() throws Exception {
		

	    when(itemService.requestItem(any(Long.class))).thenReturn(createItem("My test item"));

	    this.mockMvc.perform(
	            get("/rest/items/1")
                .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk());
	  }
	
	
	 @Test
	  public void thatViewItemRendersCorrectly() throws Exception {

		when(itemService.requestItem(any(Long.class))).thenReturn(createItem("My test item"));

        this.mockMvc.perform(
	            get("/rest/items/1")
	                    .accept(MediaType.APPLICATION_JSON))
	            .andExpect(jsonPath("$.description",is("My test item")));
	  }
	 
	 @Test
	  public void thatViewAllItems() throws Exception {
		 
		 when(itemService.getAllItems()).thenReturn(createItems(new ArrayList<Item>()));

		 
		  mockMvc.perform(get("/rest/items"))
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$", hasSize(2)))
	                .andExpect(jsonPath("$[0].description", is("My test item 1")))
	                .andExpect(jsonPath("$[1].description", is("My test item 2")));
	    

	  }

	private List<Item> createItems(final List<Item> items) {
		
		items.add(createItem("My test item 1"));
		items.add(createItem("My test item 2"));
		
		return items;
	}

	private Item createItem(final String description) {
		Item item = new Item();
		item.prePersist();
		item.setDescription(description);
		return item;
	}

}