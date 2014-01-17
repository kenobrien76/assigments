package com.mtt.presistance.repository;

import org.springframework.data.repository.CrudRepository;

import com.mtt.presistance.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
	

}
