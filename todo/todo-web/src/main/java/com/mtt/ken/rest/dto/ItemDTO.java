package com.mtt.ken.rest.dto;


import java.util.Date;

import com.mtt.presistance.model.Item;


public class ItemDTO {
	
	private Long id;
	private String description;
	private Date creationTime;
	
	public ItemDTO(){}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(final String description) {
		this.description = description;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(final Date creationTime) {
		this.creationTime = creationTime;
	}
	
	 public Item toItem(){
		Item item = new Item();
		item.setDescription(this.description);
		return item;
	}
	 
	public static ItemDTO fromItem(final Item item){
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setDescription(item.getDescription());
		itemDTO.setCreationTime(item.getCreationTime());
		itemDTO.setId(item.getId());
		return itemDTO;
	} 
	
	
}
