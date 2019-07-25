package com.springboot.location.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.location.entity.LocationEntity;
import com.springboot.location.repository.LocationRepository;

@Repository("locationDao")
public class LocationDAO {
	
	@Autowired
	private LocationRepository locationRepository;

	public List getAllLocations() {
		// TODO Auto-generated method stub
		return (List) locationRepository.findAll();
	}

	public LocationEntity getLocationStatus(String code) {
		// TODO Auto-generated method stub
		return locationRepository.findByPersonCode(code);
	}



}
