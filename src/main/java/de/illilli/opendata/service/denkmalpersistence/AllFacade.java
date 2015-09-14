package de.illilli.opendata.service.denkmalpersistence;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class AllFacade {

	private List<Denkmal> denkmalList = new ArrayList<Denkmal>();

	public AllFacade() {

		MongoClient client = new MongoClient();
		MongoDatabase database = client.getDatabase("denkmalinkoeln");

		MongoCollection<Document> collection = database
				.getCollection("denkmal");

		List<Document> all = collection.find().into(new ArrayList<Document>());

		// Es gibt keine Geolocation; daher koennen diese Objekte auch nicht auf
		// einer Karte dargestellt werden.
		for (Document document : all) {
			Denkmal denkmal = new Document2Denkmal(document).getDenkmal();
			denkmalList.add(denkmal);
		}

	}

	public List<Denkmal> getDenkmalList() {
		return denkmalList;
	}

	public String getJson() {
		return new Gson().toJson(denkmalList);
	}

}
