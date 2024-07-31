package com.prabha.restapp.serviceimpl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.prabha.restapp.model.Owner;
import com.prabha.restapp.repo.OwnerRepo;
import com.prabha.restapp.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService {
	OwnerRepo repo;

	public OwnerServiceImpl(OwnerRepo repo) {
		super();
		this.repo = repo;
	}

	public String addOwner(Owner owner) {
		return(repo.save(owner));

	}

	public Owner getOwner(int id) {
		return repo.findById(id);
	}

	public List<Owner> getAllOwners() {
		return repo.findAll();
	}

	public String updateOwner(Owner owner) {
		return(repo.update(owner));

	}

	public String deleteOwner(int id) {
		return(repo.deleteById(id));
	}

}
