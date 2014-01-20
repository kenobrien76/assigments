package com.mtt.ken.rest.controller;

import static com.mtt.ken.rest.dto.ItemDTO.fromItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtt.ken.rest.dto.ItemDTO;
import com.mtt.service.ItemService;
import com.mtt.service.exception.ItemNotFoundException;
	

@Controller
@RequestMapping("/rest/items")
public class ItemCommandController {
	
	@Autowired
	private ItemService itemService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ItemDTO> add(@RequestBody ItemDTO itemDto){
		return new ResponseEntity<ItemDTO>(fromItem(itemService.create(itemDto.toItem())),HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<ItemDTO>  removeItem(@PathVariable String id){
		
		try{
			return new ResponseEntity<ItemDTO>(fromItem(itemService.deleteById(Long.valueOf(id))),HttpStatus.OK);
		}catch(ItemNotFoundException infe){
			 //logging
		}
		return new ResponseEntity<ItemDTO>(HttpStatus.NOT_FOUND);
		
	}
		
	
}
