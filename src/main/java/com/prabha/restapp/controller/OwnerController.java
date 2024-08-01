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
import com.prabha.restapp.model.Owner;
import com.prabha.restapp.serviceimpl.OwnerServiceImpl;
@RestController
@RequestMapping("/owner")
@CrossOrigin("*")
public class OwnerController {
	OwnerServiceImpl serv;
	public OwnerController(OwnerServiceImpl serv) {
		super();
		this.serv = serv;
	}

	@PostMapping
	public String insertOwner(@RequestBody Owner owner)
	{
		String msg="";
		try {
			serv.addOwner(owner);
			msg="Owner details are added";
		}
		catch(Exception e){
			msg="Owner details are not added";
		}
		return msg;
		
	}

	@GetMapping("{id}")
	public Owner getOwnerById(@PathVariable("id") int id) {
	return serv.getOwner(id);
	}
	
	
	@GetMapping("/all")
	public List<Owner> getOwners() {
	return serv.getAllOwners();
	}
	
	
	@PutMapping
	public String updateOwner(@RequestBody Owner owner) {
		String msg="";
		try {
			serv.updateOwner(owner);
			msg="Owner details are updated";
		}
		catch(Exception e){
			msg="Owner details are not updated";
		}
		return msg;
		
	}
	
	
	
	@DeleteMapping("{id}")
	public String deleteOwnerById(@PathVariable("id") int id) {
		String msg="";
		try {
			serv.deleteOwner(id);
			msg="Owner details are deleted";
		}
		catch(Exception e){
			msg="Owner details are not deleted";
		}
		return msg;
		
	}
}








	
