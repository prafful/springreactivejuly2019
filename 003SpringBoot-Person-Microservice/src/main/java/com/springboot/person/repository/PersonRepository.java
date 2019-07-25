package com.springboot.person.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.person.entity.PersonEntity;

public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
	
	PersonEntity findByPersonCode(String code);

}
