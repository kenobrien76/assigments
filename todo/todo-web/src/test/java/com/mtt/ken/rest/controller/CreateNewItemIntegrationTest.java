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
import com.mtt.ken.rest.dto.ItemDTO;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static com.mtt.ken.utils.TestUtils.convertObjectToJsonBytes;

public class CreateNewItemIntegrationTest {
	
	
	MockMvc mockMvc;
	@InjectMocks
	ItemCommandController itemCommandController  = new ItemCommandController();
	@Mock
	ItemService itemService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		this.mockMvc = standaloneSetup(itemCommandController)
				.setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
	}
	
	
	@Test
	public void thatCreateItemHttpCreated() throws Exception {
		
	ItemDTO dto = new ItemDTO();
	dto.setDescription("My new Item");
	when(itemService.create(any(Item.class))).thenReturn(dto.toItem());
		this.mockMvc.perform(
	            post("/rest/items")
	                    .content(convertObjectToJsonBytes(dto))
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .accept(MediaType.APPLICATION_JSON))
	            .andDo(print())
	            .andExpect(status().isCreated());
	  }



}