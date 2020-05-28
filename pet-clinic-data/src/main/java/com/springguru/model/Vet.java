package com.springguru.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Vet extends Person {
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(joinColumns = {@JoinColumn(name = "vet_id")}, 
	           inverseJoinColumns = {@JoinColumn(name = "speciality_id")})
	private Set<Speciality> specialities = new HashSet<Speciality>();

	public Set<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<Speciality> specialities) {
		this.specialities = specialities;
	}
	
}
