package de.illilli.opendata.service.denkmalpersistence;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

/**
 * <p>
 * <a href=
 * "http://demeranville.com/writing-csv-using-jackson-csvmapper-mixin-annotations/"
 * >Writing CSV using Jackson CSVMapper & Mixin annotations</a>
 * </p>
 * 
 */
public class CreateCvsFacade {

	private String cvs;

	public CreateCvsFacade(List<Denkmal> denkmalList)
			throws JsonProcessingException {

		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(Denkmal.class)
				.withColumnSeparator(';').withHeader();
		cvs = mapper.writer(schema).writeValueAsString(denkmalList);
	}

	public String getCvs() {
		return cvs;
	}

}
