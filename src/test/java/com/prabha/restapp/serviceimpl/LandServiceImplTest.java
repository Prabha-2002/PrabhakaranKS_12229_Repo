package com.prabha.restapp.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prabha.restapp.model.Land;
import com.prabha.restapp.model.Owner;

@SpringBootTest
class LandServiceImplTest {
	@Autowired
	LandServiceImpl landserviceimpl;
	@Test
	void testAddLand() {
		Owner owner = new Owner(5,"madhi",8455677,669802676,8);
		Land land = new Land(2,896,"plotno:656,kalai nagar, vnagar",owner);
		assertEquals("added successfully", landserviceimpl.addLand(land));
	}

	@Test
	void testGetLand() {
		assertNotNull(landserviceimpl.getLand(3));
	}

	@Test
	void testGetAllLands() {
		assertNotNull(landserviceimpl.getAllLands());
	}

	@Test
	void testUpdateLand() {
		Land land = new Land(2, 896, "plotno:656,kalai nagar,vinagar", null);
		assertEquals("updated successfully", landserviceimpl.updateLand(land));
	}

	@Test
	void testDeleteLand() {
		assertEquals("deletion success",landserviceimpl.deleteLand(1));
	}

}
