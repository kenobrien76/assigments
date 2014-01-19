package com.mtt.ken.rest.controller;
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
		
		final Item  item = createItem();

	    when(itemService.requestItem(any(Long.class))).thenReturn(item);

	    this.mockMvc.perform(
	            get("/rest/items/1")
                .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk());
	  }
	
	
	 @Test
	  public void thatViewItemRendersCorrectly() throws Exception {
		 
		final Item  item = createItem();

		when(itemService.requestItem(any(Long.class))).thenReturn(item);

       /**
        * {"id":null,"description":"My test item","creationTime":null,"modificationTime":null}
        */
	    this.mockMvc.perform(
	            get("/rest/items/1")
	                    .accept(MediaType.APPLICATION_JSON))
	            .andExpect(jsonPath("$.description",is("My test item")));
	  }

	private Item createItem() {
		Item item = new Item();
		item.setDescription("My test item");
		return item;
	}

}