package com.mtt.ken.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mtt.presistance.model.Item;
import com.mtt.service.ItemService;
	

@Controller
@RequestMapping("/rest/items")
public class ItemCommandController {
	
	@Autowired
	private ItemService itemService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Item> createItem(@RequestBody Item item, UriComponentsBuilder builder){
		return new ResponseEntity<Item>(itemService.createItem(item), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public HttpStatus removeItem(@PathVariable String id){
		
		if(itemService.requestItem(Long.valueOf(id)) != null){
			itemService.deleteItem(Long.valueOf(id));
			return HttpStatus.OK;
		}else{
			return HttpStatus.NOT_FOUND;
			}
	}
		
	
}
