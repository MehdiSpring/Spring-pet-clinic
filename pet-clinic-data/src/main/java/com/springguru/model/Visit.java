package com.springguru.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Visit extends BaseEntity{

	private LocalDate date;
	private String description;
	
	@ManyToOne
	private Pet pet;
	
	@Builder
	public Visit(Long id, LocalDate date, String desc)
	{
		super(id);
		this.date=date;
		this.description=desc;
	}
	
	/*
	 * public LocalDate getDate() { return date; } public void setDate(LocalDate
	 * date) { this.date = date; } public String getDescription() { return
	 * description; } public void setDescription(String description) {
	 * this.description = description; } public Pet getPet() { return pet; } public
	 * void setPet(Pet pet) { this.pet = pet; }
	 */
	
	
}
