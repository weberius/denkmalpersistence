package de.illilli.opendata.service.denkmalpersistence;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class LoadFacade {

	private List<Denkmal> denkmalList = new ArrayList<Denkmal>();

	public void generate() throws MalformedURLException, IOException {

		AskForDenkmallisteKoeln askforDenkmalListeKoeln = new AskForDenkmallisteKoeln();
		Denkmal[] denkmalArray = askforDenkmalListeKoeln.getDenkmalArray();

		for (Denkmal denkmal : denkmalArray) {
			AskForDenkmalGeocoding askforDenkmalGeocoding = new AskForDenkmalGeocoding(
					denkmal.plz, "Köln", denkmal.strasse, denkmal.nummer);
			GeoCodingResult geoCoding = askforDenkmalGeocoding
					.geoCodingResult();
			denkmal.lon = geoCoding.lon;
			denkmal.lat = geoCoding.lat;
			denkmal.displayOsmAddress = geoCoding.displayName;
			denkmal.url = geoCoding.url;
			denkmalList.add(denkmal);
		}

		new StoreToMongoDb(denkmalList);
	}

}
