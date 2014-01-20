package com.mtt.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mtt.presistance.PresistanceAppContext;
import com.mtt.presistance.repository.ItemRepository;


@Configuration
@ComponentScan(basePackages = {"com.mtt.service"})
@Import(PresistanceAppContext.class)
public class ServiceAppContext {
	
	
	

}
