package com.prabha.restapp.serviceimpl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.prabha.restapp.model.Land;
import com.prabha.restapp.repo.LandRepo;
import com.prabha.restapp.service.LandService;

@Service
public class LandServiceImpl implements LandService {
	LandRepo repo;

	public LandServiceImpl(LandRepo repo) {
		super();
		this.repo = repo;
	}

	public String addLand(Land land) {
		return (repo.save(land));
	}

	public Land getLand(int id) {
		return repo.findById(id);
	}

	public List<Land> getAllLands() {
		return repo.findAll();
	}

	public String updateLand(Land land) {
		return (repo.update(land));
	}

	public String deleteLand(int id) {
		return(repo.deleteById(id));

	}
}
