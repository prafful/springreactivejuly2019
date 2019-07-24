package com.springboot.person.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class PersonController {
	
	@GetMapping("/message")
	public String welcome() {
		return "Hello from Person Microservice";
	}

}
