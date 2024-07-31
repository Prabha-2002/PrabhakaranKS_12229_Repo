package com.prabha.restapp.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Owner")
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OwnerId")
	private int id;
	@Column(name = "OwnerName")
	private String name;
	@Column(name = "OwnerPhone")
	private int phone;
	@Column(name = "OwnerAadhar")
	private int aadhaar;
	@Column(name = "OwnerNumberOfLands")
	private int nooflands;

	public Owner() {
		super();
	}

	public Owner(int id, String name, int phone, int aadhaar, int nooflands) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.aadhaar = aadhaar;
		this.nooflands = nooflands;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", phone=" + phone + ", aadhaar=" + aadhaar + ", nooflands="
				+ nooflands + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(int aadhaar) {
		this.aadhaar = aadhaar;
	}

	public int getNooflands() {
		return nooflands;
	}

	public void setNooflands(int nooflands) {
		this.nooflands = nooflands;
	}

}
