package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.FriendEntity;

public interface FriendRepository extends CrudRepository<FriendEntity, Long> {

	
	//CRUD is default!!!
	
}
