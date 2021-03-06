package com.mtt.ken.config;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mtt.ken.rest.dto.ItemDTO;
import com.mtt.service.ServiceAppContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import static com.mtt.ken.utils.TestUtils.convertObjectToJsonBytes;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {ServiceAppContext.class, ItemsWebConfig.class})
public class ItemsWebConfigTest {

	
	 @Autowired
	 WebApplicationContext webApplicationContext;
	 
	 private MockMvc mockMvc;
	 
	 
	 @Before
	  public void setup() {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	  }
	 
	 
	  @Test
	  public void addAItem() throws Exception  {
		  
		  ItemDTO dto = new ItemDTO();
			dto.setDescription("My new Item");
		  
	    this.mockMvc.perform(
	            post("/rest/items")
	                    .content(convertObjectToJsonBytes(dto))
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .accept(MediaType.APPLICATION_JSON))
	            .andDo(print())
	            .andExpect(status().isCreated());

	    this.mockMvc.perform(
	            get("/rest/items")
	                    .accept(MediaType.APPLICATION_JSON))
	            .andDo(print())
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$[0].description", is("My new Item")));
	    
	    
	  }



}
