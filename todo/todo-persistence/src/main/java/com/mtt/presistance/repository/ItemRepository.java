package com.mtt.presistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtt.presistance.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	

}
