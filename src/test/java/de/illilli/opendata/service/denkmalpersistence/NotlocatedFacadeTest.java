package de.illilli.opendata.service.denkmalpersistence;

import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Ignore
public class NotlocatedFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws JsonParseException, JsonMappingException,
			IOException {
		NoGeoFacade facade = new NoGeoFacade();
		System.out.println(facade.getJson());
	}

}
