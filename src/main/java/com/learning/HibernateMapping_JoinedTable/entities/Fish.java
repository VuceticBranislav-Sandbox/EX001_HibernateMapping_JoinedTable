package com.learning.HibernateMapping_JoinedTable.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "fishid")
public class Fish extends Pet {
	
	private String fishName;

	public Fish() {
	}

	public Fish(String fishName) {
		super("fish", "ribic");
		this.fishName = fishName;
	}

	public String getFishName() {
		return fishName;
	}

	public void setFishName(String fishName) {
		this.fishName = fishName;
	}

}