package com.springboot.person.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springboot.person.entity.LocationResponse;
import com.springboot.person.entity.PersonEntity;
import com.springboot.person.repository.PersonRepository;

@Repository("personDao")
public class PersonDAO {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public List getAllPersons() {
		// TODO Auto-generated method stub
		return (List) personRepository.findAll();
	}

	@HystrixCommand(fallbackMethod = "getPersonStatus_FallBack",
			commandProperties = {
					@HystrixProperty(
							name="execution.isolation.thread.timeoutInMilliseconds", 
							value = "4000"
							)
			})
	public PersonEntity getPersonStatus(String code) {
		/*
		 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		// TODO Auto-generated method stub
		PersonEntity pe = personRepository.findByPersonCode(code);
		//if pe is not null then query location microservice!
		//http://localhost:4442/code 
		//will receive location entity
		String url = "http://localhost:8080/mytracking/v1/location/api/v1/"+code;
		ResponseEntity<LocationResponse> locationResponse =  restTemplate.getForEntity(url, LocationResponse.class);
		System.out.println(locationResponse.getBody());
		if(locationResponse.getStatusCode() == HttpStatus.OK) {
			if(locationResponse.getBody().getLatitude() !=0 && locationResponse.getBody().getLongitude()!=0) {
				//set status in pe to true
				pe.setStatus(true);
				personRepository.save(pe);
			}else {
				pe.setStatus(false);
				personRepository.save(pe);
			}
		}
		
		
		return pe;
	}
	
	
	public PersonEntity getPersonStatus_FallBack(String code) {
		System.out.println("###############################################################");
		System.out.println("CallBack called");
		System.out.println("###############################################################");
		return null;
	}
	
	
	

}
