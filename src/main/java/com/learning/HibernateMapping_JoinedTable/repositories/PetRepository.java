package com.learning.HibernateMapping_JoinedTable.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

import com.learning.HibernateMapping_JoinedTable.entities.Pet;

@RestController
public interface PetRepository extends CrudRepository<Pet, Integer>{

	List<Pet> findAll();
	
}

