package de.illilli.opendata.service.denkmalpersistence;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

@Ignore
public class LocatedFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws JsonProcessingException {
		GeoFacade facade = new GeoFacade();
		System.out.println(facade.getJson());
	}

}
