package com.prabha.restapp.repo;

import java.util.List;
import com.prabha.restapp.model.Owner;

public interface OwnerRepo {
	public String save(Owner owner);

	public List<Owner> findAll();

	public Owner findById(int id);

	public String update(Owner owner);

	public String deleteById(int id);
}
