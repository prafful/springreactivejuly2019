package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	@GetMapping("/get/{id}")
	public FriendEntity getFriendById(@PathVariable int id) {
		return friendService.getFriendById(id);
		
	}
	
	//@PostMapping
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public FriendEntity updateFriend(int id, FriendEntity fe) {
		return null;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public List<FriendEntity> deleteFriend() {
		return null;
		
	}
	
	@PostMapping("/add")
	public FriendEntity addFriend(@RequestBody FriendEntity fe) {
		System.out.println(fe.toString());
		return friendService.addFriend(fe);
		
	}
	
	@GetMapping("/name/{friendname}")
	public FriendEntity getFriendByName(String name) {
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
}
