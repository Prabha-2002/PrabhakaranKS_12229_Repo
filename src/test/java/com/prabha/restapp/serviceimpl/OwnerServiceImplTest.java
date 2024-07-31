package com.prabha.restapp.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prabha.restapp.model.Owner;

@SpringBootTest
class OwnerServiceImplTest {

	@Autowired
	OwnerServiceImpl ownerserviceimpl;
	@Test
	void testAddOwner() {
		Owner owner = new Owner(0,"galileo",768964562,2435678,9);
		assertEquals("added", ownerserviceimpl.addOwner(owner));
	}

	@Test
	void testGetOwner() {
		assertNotNull(ownerserviceimpl.getOwner(6));
	}

	@Test
	void testGetAllOwners() {
		assertNotNull(ownerserviceimpl.getAllOwners());
	}

	@Test
	void testUpdateOwner() {
		Owner owner = new Owner(6,"galileo",867543432,2435678,9);
		assertEquals("updated", ownerserviceimpl.updateOwner(owner));
	}

//	@Test
//	void testDeleteOwner() {
//		assertEquals("deleted", ownerserviceimpl.deleteOwner(7));
//
//	}

}
