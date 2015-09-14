package de.illilli.opendata.service.denkmalpersistence;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateCvsFacadeTest {

	private List<Denkmal> denkmalList;

	@Before
	public void setUp() throws Exception {

		InputStream inputStream = this.getClass().getResourceAsStream(
				"/notlocated.json");

		ObjectMapper mapper = new ObjectMapper();
		Denkmal[] denkmalArray = mapper.readValue(inputStream, Denkmal[].class);

		denkmalList = Arrays.asList(denkmalArray);
	}

	@Test
	public void testGetCvs() throws JsonProcessingException {
		CreateCvsFacade facade = new CreateCvsFacade(denkmalList);
		String cvs = facade.getCvs();
		System.out.println(cvs);
	}

}
