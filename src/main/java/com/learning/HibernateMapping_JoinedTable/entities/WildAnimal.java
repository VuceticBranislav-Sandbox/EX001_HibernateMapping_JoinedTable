package com.learning.HibernateMapping_JoinedTable.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "wildId")
public class WildAnimal extends Animal {
	
	private String name;

	public WildAnimal() {
		super();
	}
	
	public WildAnimal(String species, String name) {
		super(species);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
