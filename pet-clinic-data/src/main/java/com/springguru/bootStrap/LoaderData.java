package com.springguru.bootStrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springguru.model.Owner;
import com.springguru.model.Vet;
import com.springguru.service.OwnerService;
import com.springguru.service.VetService;
import com.springguru.service.map.OwnerServiceMap;
import com.springguru.service.map.VetServiceMap;

@Component
public class LoaderData implements CommandLineRunner{

	private final OwnerService ownerService;
	private final VetService vetService;
	
	public LoaderData()
	{
	    this.ownerService = new OwnerServiceMap();
	    this.vetService = new VetServiceMap();
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		//Save some owners
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Mehdi");
		owner1.setLastName("BOUMZZI");
		
		this.ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Oumayma");
		owner2.setLastName("MAOUAJ");
		
		this.ownerService.save(owner2);
		
		System.out.println("Owenrs have been saved !!!");
		
		//Save some Vets
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Jack");
		vet1.setLastName("BAUER");
		
		this.vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Jaqueline");
		vet2.setLastName("ROSE");
		
		this.vetService.save(vet2);
		
		System.out.println("Vets have been saved !!!");
		
	}

}
