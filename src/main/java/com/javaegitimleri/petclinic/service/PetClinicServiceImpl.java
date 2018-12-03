package com.javaegitimleri.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaegitimleri.petclinic.dao.OwnerRepository;
import com.javaegitimleri.petclinic.exception.OwnerNotFoundException;
import com.javaegitimleri.petclinic.model.Owner;

@Service
public class PetClinicServiceImpl implements PetClinicService {
	
	private OwnerRepository OwnerRepository;
	
	@Autowired
	public void setOwnerRepository(OwnerRepository ownerRepository) {
		OwnerRepository = ownerRepository;
	}
	
	@Override
	public List<Owner> findOwners() {
		return OwnerRepository.findAll();
	}

	@Override
	public List<Owner> findOwners(String lastName) {
		return OwnerRepository.findByLastName(lastName);
	}

	@Override
	public Owner findOwner(long id) throws OwnerNotFoundException {
		Owner owner = OwnerRepository.findById(id);
		if(owner == null) throw new OwnerNotFoundException("Onwer not found with id : "+id);
		return owner;
	}

	@Override
	public void createOwner(Owner owner) {
		OwnerRepository.create(owner);
	}

	@Override
	public void updateOwner(Owner owner) {
		OwnerRepository.update(owner);
	}

	@Override
	public void deleteOwner(Long id) {
		OwnerRepository.delete(id);
	}

}
