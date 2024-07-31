package com.prabha.restapp.service;

import java.util.List;

import com.prabha.restapp.model.Owner;

public interface OwnerService {
	public String addOwner(Owner owner);

	public Owner getOwner(int id);

	public List<Owner> getAllOwners();

	public String updateOwner(Owner owner);

	public String deleteOwner(int id);
}
