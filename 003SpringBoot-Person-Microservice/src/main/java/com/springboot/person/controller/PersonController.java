package com.springboot.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springboot.person.entity.PersonEntity;
import com.springboot.person.service.PersonService;

@RestController
@RequestMapping("api/v1")
@RefreshScope
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@Value("${welcome.message}")
	private String message;
	
	@GetMapping("/message")
	public String welcome() {
		return message;
	}
	
	@GetMapping("/all")
	public List getAllPersons() {
		return personService.getAllPersons();
	}
	
	@GetMapping("/{code}")
	public PersonEntity getPersonStatus(@PathVariable String code) {
		return personService.getPersonStatus(code);
	}
	
	

}
