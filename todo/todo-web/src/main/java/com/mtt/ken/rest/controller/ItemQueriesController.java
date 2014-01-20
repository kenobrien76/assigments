package com.mtt.ken.rest.controller;

import static com.mtt.ken.rest.dto.ItemDTO.fromItem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mtt.ken.rest.dto.ItemDTO;
import com.mtt.presistance.model.Item;
import com.mtt.service.ItemService;
import com.mtt.service.exception.ItemNotFoundException;

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
	public List<Item> viewAllItems(){
		return itemService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public ResponseEntity<ItemDTO> viewItem(@PathVariable String id){
		
		try{
			return new ResponseEntity<ItemDTO>(fromItem(itemService.findById(Long.valueOf(id))), HttpStatus.OK);
		}catch(ItemNotFoundException infe){
			//logging
		}
		
		return new ResponseEntity<ItemDTO>(HttpStatus.NOT_FOUND);
	}

}
