package com.mtt.ken.rest.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

import com.mtt.service.ItemService;
import com.mtt.ken.rest.controller.ItemQueriesController;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

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
	public void thatViewItemOrderUsesHttpNotFound() throws Exception {

	    when(itemService.requestItem(Long.valueOf(1))).thenReturn(null);


	    this.mockMvc.perform(
	            get("/rest/items/1")
                .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isNotFound());
	  }

}