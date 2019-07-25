package com.springboot.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.location.dao.LocationDAO;
import com.springboot.location.entity.LocationEntity;

@Service("locationService")
public class LocationService {
	
	@Autowired
	private LocationDAO locationDao;

	public List getAllLocations() {
		// TODO Auto-generated method stub
		return locationDao.getAllLocations();
	}

	public LocationEntity getLocationStatus(String code) {
		// TODO Auto-generated method stub
		return locationDao.getLocationStatus(code);
	}

	

}
