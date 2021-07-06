package com.learning.HibernateMapping_JoinedTable.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.HibernateMapping_JoinedTable.entities.Fish;
import com.learning.HibernateMapping_JoinedTable.repositories.FishRepository;

@RestController
@RequestMapping(path = "/fish")
public class FishController {
	
	@Autowired
	FishRepository fishRepository;
	
	@RequestMapping(method = RequestMethod.POST, path = "")
	public ResponseEntity<?> addPet() {
		Fish pet = new Fish("Brbucko");
		fishRepository.save(pet);
		return new ResponseEntity<Fish>(pet, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "")
	public ResponseEntity<?> getPet() {
		return new ResponseEntity<List<Fish>>(fishRepository.findAll(), HttpStatus.OK);
	}
}
