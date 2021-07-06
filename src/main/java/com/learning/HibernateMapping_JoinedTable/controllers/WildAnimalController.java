package com.learning.HibernateMapping_JoinedTable.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.HibernateMapping_JoinedTable.entities.WildAnimal;
import com.learning.HibernateMapping_JoinedTable.repositories.WildAnimalRepository;

@RestController
@RequestMapping(path = "/wild")
public class WildAnimalController {
	
	@Autowired
	WildAnimalRepository wildAnimalRepository;
	
	@RequestMapping(method = RequestMethod.POST, path = "")
	public ResponseEntity<?> addWild() {
		WildAnimal wildAnimal = new WildAnimal("Zverov", "Jovica");
		wildAnimalRepository.save(wildAnimal);
		return new ResponseEntity<WildAnimal>(wildAnimal, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "")
	public ResponseEntity<?> getWild() {
		return new ResponseEntity<List<WildAnimal>>(wildAnimalRepository.findAll(), HttpStatus.OK);
	}
}