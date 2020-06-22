package com.springguru.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Vet extends Person {
	
	@Builder
	public Vet(String firstName, String lastName)
	{
		super(firstName,lastName);
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(joinColumns = {@JoinColumn(name = "vet_id")}, 
	           inverseJoinColumns = {@JoinColumn(name = "speciality_id")})
	private Set<Speciality> specialities = new HashSet<Speciality>();

	/*
	 * public Set<Speciality> getSpecialities() { return specialities; }
	 * 
	 * public void setSpecialities(Set<Speciality> specialities) { this.specialities
	 * = specialities; }
	 */
	
}
