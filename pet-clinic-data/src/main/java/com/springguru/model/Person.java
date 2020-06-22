package com.springguru.model;

import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
  
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@MappedSuperclass
public class Person extends BaseEntity {
	
	
	private String firstName;
	private String lastName;
	
	 
	public Person(String firstName, String lastName)
	{
		//super(id);
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/*
	 * public String getFirstName() { return firstName; } public void
	 * setFirstName(String firstName) { this.firstName = firstName; } public String
	 * getLastName() { return lastName; } public void setLastName(String lastName) {
	 * this.lastName = lastName; }
	 */
	
	

}
