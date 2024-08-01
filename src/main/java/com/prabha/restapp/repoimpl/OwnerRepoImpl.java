package com.prabha.restapp.repoimpl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.prabha.restapp.model.Owner;
import com.prabha.restapp.repo.OwnerRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class OwnerRepoImpl implements OwnerRepo {
	EntityManager eManager;

	public OwnerRepoImpl(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	public String save(Owner owner) {
		if (owner != null) {
			eManager.merge(owner);
			return ("added");
		} else {
			return ("not added");
		}
	}

	public List<Owner> findAll() {
		String owner = "from Owner";
		Query query = eManager.createQuery(owner);
		return query.getResultList();
	}

	public Owner findById(int id) {
		return eManager.find(Owner.class, id);
	}

	@Override
	public String update(Owner owner) {
		if (owner != null) {
			eManager.merge(owner);
			return ("updated");
		} else {
			return ("not updated");
		}
	}

	@Override
	public String deleteById(int id) {
		if (id != 0) {
			Owner e = eManager.find(Owner.class, id);
			eManager.remove(e);
			return ("deleted");
		} else {
			return ("not deleted");
		}
	}
}
