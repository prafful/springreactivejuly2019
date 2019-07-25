package com.springboot.person.entity;

import javax.persistence.Column;

import lombok.Data;


@Data
public class LocationResponse {
	
	private String personCode;
	
	
	private Long latitude;
	
	
	private Long longitude;

}
