package com.springguru.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
/*
 * this annotation tells JPA to not create a table for this class, and all its
 * informations and its mappings will be inherited by the subclasses
 */
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@MappedSuperclass
public class BaseEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	public BaseEntity(Long id)
	{
		this.id=id;
	}
	/*
	 * public Long getId() { return id; }
	 * 
	 * public void setId(Long id) { this.id = id; }
	 */
	
	public boolean isNew()
	{
		if(this.id==null)
			return true;
		
		return false;
	}

}
