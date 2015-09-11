package de.illilli.opendata.service.denkmalpersistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class NoGeoFacade {

	private List<Denkmal> denkmalList = new ArrayList<Denkmal>();

	public NoGeoFacade() throws JsonParseException, JsonMappingException,
			IOException {
		MongoClient client = new MongoClient();
		MongoDatabase database = client.getDatabase("denkmalinkoeln");

		MongoCollection<Document> collection = database
				.getCollection("denkmal");

		Bson filter = new Document("lon", new Document("$lte", 0.0));
		List<Document> all = collection.find(filter).into(
				new ArrayList<Document>());

		// Es gibt keine Geolocation; daher koennen diese Objekte auch nicht auf
		// einer Karte dargestellt werden.
		for (Document document : all) {
			Denkmal denkmal = new Document2Denkmal(document).getDenkmal();
			denkmalList.add(denkmal);
		}

	}

	public String getJson() {
		return new Gson().toJson(denkmalList);
	}
}
