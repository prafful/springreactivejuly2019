package com.springboot.location.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.location.entity.LocationEntity;


public interface LocationRepository extends CrudRepository<LocationEntity, Long> {
	
	LocationEntity findByPersonCode(String code);

}
