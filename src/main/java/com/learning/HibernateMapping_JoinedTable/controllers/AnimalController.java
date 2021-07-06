package com.learning.HibernateMapping_JoinedTable.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.HibernateMapping_JoinedTable.entities.Animal;
import com.learning.HibernateMapping_JoinedTable.repositories.AnimalRepository;

@RestController
@RequestMapping(path = "/animal")
public class AnimalController {
	
	@Autowired
	AnimalRepository animalRepository;

	@RequestMapping(method = RequestMethod.POST, path = "")
	public ResponseEntity<?> addAnimal() {
		Animal animal = new Animal();
		animal.setSpecies("Skocimis");
		animalRepository.save(animal);
		return new ResponseEntity<Animal>(animal, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "")
	public ResponseEntity<?> getAnimal() {
		return new ResponseEntity<List<Animal>>(animalRepository.findAll(), HttpStatus.OK);
	}
}
