package com.springboot.person.service;

import java.util.List;

import org.bouncycastle.asn1.x509.sigi.PersonalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.person.dao.PersonDAO;
import com.springboot.person.entity.PersonEntity;

@Service("personService")
public class PersonService {
	
	@Autowired
	private PersonDAO personDao;

	public List getAllPersons() {
		// TODO Auto-generated method stub
		return personDao.getAllPersons();
	}

	public PersonEntity getPersonStatus(String code) {
		// TODO Auto-generated method stub
		return personDao.getPersonStatus(code);
	}

}
