package com.prabha.restapp.repo;
import java.util.List;
import com.prabha.restapp.model.Land;
public interface LandRepo {
	public String save(Land land);

	public List<Land> findAll();

	public Land findById(int id);

	public String update(Land land);

	public String deleteById(int id);
}
