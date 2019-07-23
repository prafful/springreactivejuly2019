package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FriendDao;
import com.example.demo.entity.FriendEntity;

@Service("friendService")
public class FriendService {

	@Autowired
	private FriendDao friendDao;
	
	public List<FriendEntity> getAllFriends() {
		return friendDao.getAllFriends();
	};
}
