package com.mtt.ken.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mtt.service.ServiceAppContext;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.mtt.ken.rest.controller"})
@Import(ServiceAppContext.class)
public class ItemsWebConfig {

}
