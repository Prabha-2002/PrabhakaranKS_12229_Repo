package com.prabha.restapp.service;

import java.util.List;
import com.prabha.restapp.model.Land;

public interface LandService {
	public String addLand(Land land);

	public Land getLand(int id);

	public List<Land> getAllLands();

	public String updateLand(Land land);

	public String deleteLand(int id);
}
