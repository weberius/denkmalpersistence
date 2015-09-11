package de.illilli.opendata.service.denkmalpersistence;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

public class GenerateFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGenerate() throws MalformedURLException, IOException {
		LoadFacade facade = new LoadFacade();
		facade.generate();
	}

}
