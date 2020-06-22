package com.springguru.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
@Entity 
public class Owner extends Person {
	
	/*This annotation allows us to initialize an object without calling a setter in each property
	 * This annotation knows the parameters from the constructor with params
	 * We can declared it on the class with the @AllArgsConstructor,
	 * But in our case, that will give us a builder with just Address, city and tel properties,
	 * So we had to create our own constructor by calling the super constructor of Person and BaseEntity,
	 * And annotate the constructor with @Builder 
	 * */
	@Builder
	public Owner(String firstName, String lastName, String address, String city, String tel)
	{
		super(firstName, lastName);
		this.address = address;
		this.city=city;
		this.tel=tel;
	}
	
	private String address;
	private String city;
	private String tel;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets = new HashSet<Pet>();
	
	/*
	 * public String getAddress() { return address; }
	 * 
	 * public void setAddress(String address) { this.address = address; }
	 * 
	 * public String getCity() { return city; }
	 * 
	 * public void setCity(String city) { this.city = city; }
	 * 
	 * public String getTel() { return tel; }
	 * 
	 * public void setTel(String tel) { this.tel = tel; }
	 * 
	 * public Set<Pet> getPets() { return pets; }
	 * 
	 * public void setPets(Set<Pet> pets) { this.pets = pets; }
	 */
	
	

}
