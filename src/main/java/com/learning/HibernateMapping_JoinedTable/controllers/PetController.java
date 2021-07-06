package com.learning.HibernateMapping_JoinedTable.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.HibernateMapping_JoinedTable.entities.Fish;
import com.learning.HibernateMapping_JoinedTable.entities.Pet;
import com.learning.HibernateMapping_JoinedTable.repositories.PetRepository;

@RestController
@RequestMapping(path = "/pet")
public class PetController {
	
	@Autowired
	PetRepository petRepository;
	
	@RequestMapping(method = RequestMethod.POST, path = "")
	public ResponseEntity<?> addPet() {
		Pet pet = new Pet("Hrcak mali", "Perica");
		petRepository.save(pet);
		return new ResponseEntity<Pet>(pet, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "")
	public ResponseEntity<?> getPet() {
		return new ResponseEntity<List<Pet>>(petRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<?> getPet2Fish(@PathVariable Long id) {
		
		Optional<Pet> op = petRepository.findById(id);
		if (!op.isPresent()) new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		Pet pet = op.get();		

		// Test if upcasting work
		Fish fish;
		fish = (Fish) pet;		
		
		return new ResponseEntity<String>(fish.getFishName(), HttpStatus.OK);
	}
}
