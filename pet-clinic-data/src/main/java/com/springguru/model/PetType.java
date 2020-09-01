package com.springguru.model;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
@Entity
public class PetType extends BaseEntity {
	
	private String name;

	@Builder
	public PetType(Long id, String name)
	{
	   	super(id);
	   	this.name=name;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	
	
	/*
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 */
	
	

}
