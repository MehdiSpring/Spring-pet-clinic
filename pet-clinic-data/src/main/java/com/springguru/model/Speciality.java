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
public class Speciality extends BaseEntity{

	private String description;

	@Builder
	public Speciality(Long id, String desc)
	{
		super(id);
		this.description=desc;
	}
	
	/*
	 * public String getDescription() { return description; }
	 * 
	 * public void setDescription(String description) { this.description =
	 * description; }
	 */
	
	
}
