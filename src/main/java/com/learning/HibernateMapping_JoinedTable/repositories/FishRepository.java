package com.learning.HibernateMapping_JoinedTable.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

import com.learning.HibernateMapping_JoinedTable.entities.Fish;

@RestController
public interface FishRepository extends CrudRepository<Fish, Integer>{

	List<Fish> findAll();
	
}

