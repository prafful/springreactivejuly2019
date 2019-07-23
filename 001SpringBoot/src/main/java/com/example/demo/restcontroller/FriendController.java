package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FriendEntity;
import com.example.demo.service.FriendService;

@RestController
@RequestMapping("/api")
public class FriendController {
	
	@Autowired
	private FriendService friendService;

	
	@RequestMapping("/")
	public String welcome() {
		return "Hello from STS!!!!";
	}
	
	//@RequestMapping(value = "/all", method = RequestMethod.GET)
	@GetMapping("/all")
	public List<FriendEntity> getAllFriends() {
		return friendService.getAllFriends();
	}
	
	
	
	
}
