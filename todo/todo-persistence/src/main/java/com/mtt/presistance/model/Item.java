package com.mtt.presistance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Item implements Serializable {
	
	private static final long serialVersionUID = 4658192093790613543L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String description;
	private Date createdDate;
	
	public Item() {}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(final String description) {
		this.description = description;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(final Date createdDate) {
		this.createdDate = createdDate;
	}
	public Long getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Item [id=" + id + ", description=" + description
				+ ", createdDate=" + createdDate + "]";
	}
	
	
	
	
	
	
	
	
	

}
