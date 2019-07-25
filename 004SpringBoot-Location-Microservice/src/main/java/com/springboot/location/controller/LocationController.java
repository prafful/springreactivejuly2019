package com.springboot.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.location.entity.LocationEntity;
import com.springboot.location.service.LocationService;

@RestController
@RequestMapping("api/v1")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/message")
	public String welcome() {
		return "Hello from Location Microservice";
	}
	
	@GetMapping("/all")
	public List getAllPersons() {
		return locationService.getAllLocations();
	}
	
	@GetMapping("/{code}")
	public LocationEntity getLocationStatus(@PathVariable String code) {
		return locationService.getLocationStatus(code);
	}
	
	

}
