package com.mtt.ken.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mtt.presistance.model.Item;
import com.mtt.service.ItemService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("/rest/items")
public class ItemQueriesController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Item> getAllItems(){
		return itemService.getAllItems();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<Item> viewItem(@PathVariable String id){
		Item item = itemService.requestItem(Long.getLong(id));
		return (item != null )
				   ? new ResponseEntity<Item>(item, HttpStatus.OK)
						: new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
	}

}
