package com.prabha.restapp.model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Land")
public class Land {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LandId")
	private int id;
	@Column(name = "LandSquareFeet")
	private int landsqft;
	@Column(name = "LandAddress")
	private String landaddress;
	@ManyToOne(targetEntity = Owner.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "Owner")
	private Owner owner;

	public Land() {
		super();
	}

	public Land(int id, int landsqft, String landaddress, Owner owner) {
		super();
		this.id = id;
		this.landsqft = landsqft;
		this.landaddress = landaddress;
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Land [id=" + id + ", landsqft=" + landsqft + ", landaddress=" + landaddress + ", owner=" + owner + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLandsqft() {
		return landsqft;
	}

	public void setLandsqft(int landsqft) {
		this.landsqft = landsqft;
	}

	public String getLandaddress() {
		return landaddress;
	}

	public void setLandaddress(String landaddress) {
		this.landaddress = landaddress;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

}
