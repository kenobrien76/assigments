package com.mtt.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.mtt.presistance.PresistanceAppContext;


@Configuration
@Import(PresistanceAppContext.class)
public class ServiceAppContext {

}
