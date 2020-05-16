package com.springguru.bootStrap;

import java.time.LocalDate;
import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springguru.model.Owner;
import com.springguru.model.Pet;
import com.springguru.model.PetType;
import com.springguru.model.Vet;
import com.springguru.service.OwnerService;
import com.springguru.service.PetService;
import com.springguru.service.PetTypeService;
import com.springguru.service.VetService;


@Component
public class LoaderData implements CommandLineRunner{

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final PetService petService;
	
	public LoaderData(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			PetService petService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.petService = petService;
	}



	@Override
	public void run(String... args) throws Exception {
		
		//Save some owners
		Owner owner1 = new Owner();
		
		owner1.setFirstName("Mehdi");
		owner1.setLastName("BOUMZZI");
		owner1.setAddress("51 avenue raymod aron");
		owner1.setCity("Paris");
		owner1.setTel("0760159528");
		
		this.ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		
		owner2.setFirstName("Oumayma");
		owner2.setLastName("MAOUAJ");
		owner2.setAddress("51 avenue raymond aron");
		owner2.setCity("Paris");
		owner2.setTel("0779297825");
		
		this.ownerService.save(owner2);
		
		//Save some PetTypes
		PetType petType1 = new PetType();
		petType1.setName("petType1");
				
		this.petTypeService.save(petType1);
				
		PetType petType2 = new PetType();
		petType2.setName("petType2");
				
		this.petTypeService.save(petType2);
				
		System.out.println("PetTypes have been saved !!!");
		
		//Save some pets
		Pet pet1 = new Pet();
		pet1.setName("pet1");
		pet1.setOwner(owner1);
		pet1.setPetType(petType1);
		pet1.setBirthDate(LocalDate.now());
		
		this.petService.save(pet1);
				
		Pet pet2 = new Pet();
		pet2.setName("pet2");
		pet2.setOwner(owner2);
		pet2.setPetType(petType2);
		pet2.setBirthDate(LocalDate.now());
		
		this.petService.save(pet2);
		
		System.out.println("Pet and owners have been saved !!!");
		
		//Save some Vets
		Vet vet1 = new Vet();
		
		vet1.setFirstName("Jack");
		vet1.setLastName("BAUER");
		
		this.vetService.save(vet1);
		
		Vet vet2 = new Vet();
		
		vet2.setFirstName("Jaqueline");
		vet2.setLastName("ROSE");
		
		this.vetService.save(vet2);
		
		System.out.println("Vets have been saved !!!");
		
		
		
		
	}

}
