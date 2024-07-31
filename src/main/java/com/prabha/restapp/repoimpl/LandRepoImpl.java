package com.prabha.restapp.repoimpl;

import com.prabha.restapp.model.Land;
import com.prabha.restapp.repo.LandRepo;

import java.util.List;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LandRepoImpl implements LandRepo {
	EntityManager eManager;

	public LandRepoImpl(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	public String save(Land land) {
		if (land != null) {
			System.out.print(land);
			eManager.merge(land);
			return ("added successfully");
		} else {
			return ("added failed");
		}
	}

	public List<Land> findAll() {
		String hql = "from Land";
		Query query = eManager.createQuery(hql);
		return query.getResultList();
	}

	public Land findById(int id) {
		return eManager.find(Land.class, id);
	}

	@Override
	public String update(Land land) {
		if (land != null) {
			System.out.print(land);
			eManager.merge(land);
			return ("updated successfully");

		} else {
			return ("updated failed");
		}
	}

	@Override
	public String deleteById(int id) {
		if (id != 0) {
			Land e = eManager.find(Land.class, id);
			eManager.remove(e);
			return ("deletion success");
		} else {
			return ("deletion failed");
		}
	}
}
