package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FriendEntity;
import com.example.demo.repository.FriendRepository;

@Repository("friendDao")
public class FriendDao {

	@Autowired
	private FriendRepository friendRepository;

	public List<FriendEntity> getAllFriends() {

		return (List<FriendEntity>) friendRepository.findAll();
	}

	public FriendEntity addFriend(FriendEntity fe) {
		// TODO Auto-generated method stub
		return friendRepository.save(fe);
	}

	public FriendEntity getFriendById(int id) {
		// TODO Auto-generated method stub
		Optional<FriendEntity> fe = friendRepository.findById((long) id);
		if(!fe.isPresent()) {
			return null;
		}else {
			return fe.get(); 
		}
		
	}

}
