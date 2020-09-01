package com.springguru.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Pet extends BaseEntity {
	
	@Builder
	public Pet(Long id, String name, LocalDate birthDate)
	{
		super(id);
		this.name=name;
		this.birthDate=birthDate;
	}
	
	private String name;
	
	private LocalDate birthDate;
	
	private String stringDate;
	
	@ManyToOne
	private PetType petType;
	
	@ManyToOne
	private Owner owner;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
	private Set<Visit> visits = new HashSet<Visit>();
	
	
	/*
	 * public PetType getPetType() { return petType; } public void
	 * setPetType(PetType petType) { this.petType = petType; } public Owner
	 * getOwner() { return owner; } public void setOwner(Owner owner) { this.owner =
	 * owner; } public LocalDate getBirthDate() { return birthDate; } public void
	 * setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; } public
	 * String getName() { return name; } public void setName(String name) {
	 * this.name = name; } public Set<Visit> getVisits() { return visits; } public
	 * void setVisits(Set<Visit> visits) { this.visits = visits; }
	 */
	
	

}
