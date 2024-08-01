package com.prabha.restapp.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prabha.restapp.model.Land;
import com.prabha.restapp.serviceimpl.LandServiceImpl;

@RestController
@RequestMapping("/Land")
@CrossOrigin("*")
public class LandController {
	LandServiceImpl serv;

	public LandController(LandServiceImpl serv) {
		super();
		this.serv = serv;
	}

	@PostMapping
	public String insertLand(@RequestBody Land land) {
		String msg = "";
		try {
			serv.addLand(land);
			msg = "land details are added";
		} catch (Exception e) {
			msg = "land details are failed to add";
		}
		return msg;

	}

	@GetMapping("{id}")
	public Land getLandById(@PathVariable("id") int id) {
		return serv.getLand(id);
	}

	@GetMapping("/all")
	public List<Land> getLands() {
		return serv.getAllLands();
	}

	@PutMapping
	public String updateLand(@RequestBody Land land) {
		String msg = "";
		try {
			serv.updateLand(land);
			msg = "land details are updated";
		} catch (Exception e) {
			msg = "land details are not updated";
		}
		return msg;

	}

	@DeleteMapping("{id}")
	public String deleteLandById(@PathVariable("id") int id) {
		String msg = "";
		try {
			serv.deleteLand(id);
			msg = "land details are deleted";
		} catch (Exception e) {
			msg = "land details are not deleted";
		}
		return msg;

	}

}
