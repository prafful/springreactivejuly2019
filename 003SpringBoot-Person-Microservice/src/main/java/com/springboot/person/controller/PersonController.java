package com.springboot.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springboot.person.entity.PersonEntity;
import com.springboot.person.service.PersonService;

@RestController
@RequestMapping("api/v1")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/message")
	public String welcome() {
		return "Hello from Person Microservice";
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
