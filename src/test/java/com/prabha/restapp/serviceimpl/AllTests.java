package com.prabha.restapp.serviceimpl;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ LandServiceImplTest.class, OwnerServiceImplTest.class })
public class AllTests {

}
