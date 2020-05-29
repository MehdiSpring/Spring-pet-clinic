package com.springguru.service.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springguru.model.Pet;
import com.springguru.model.PetType;
import com.springguru.service.OwnerService;
import com.springguru.service.PetService;
import com.springguru.service.PetTypeService;


@Service
@Profile({"default","map"})
public class PetServiceMap extends AbstractMapService<Long, Pet> implements PetService {

	@Override
	public Pet findById(Long id) {
		
		return super.findById(id);
	}

	@Override
	public Pet save(Pet object) {
		
		/*if(object != null)
		{
			if(object.getPetType() != null)
			{
				if(object.getPetType().getId() == null)
					this.petTypeService.save(object.getPetType());
				
			}
			
			if(object.getOwner() != null)
			{
				if(object.getOwner().getId() == null)
				{
					object.getOwner().getPets().add(object);
					this.ownerService.save(object.getOwner());
				}
			}
			
		}*/
		return super.save(object);
	}

	@Override
	public Set<Pet> findAll() {
		
		return super.findAll();
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);

	}

}
