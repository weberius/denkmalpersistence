package de.illilli.opendata.service.denkmalpersistence;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class StoreToMongoDb {

	public StoreToMongoDb(List<Denkmal> denkmalList) {
		MongoClient client = new MongoClient();
		MongoDatabase database = client.getDatabase("denkmalinkoeln");

		MongoCollection<Document> collection = database
				.getCollection("denkmal");
		collection.drop();

		List<Document> documentList = new ArrayList<Document>();
		for (Denkmal denkmal : denkmalList) {
			Document document = new Document(denkmal.getAsMap());
			documentList.add(document);
		}

		collection.insertMany(documentList);
		client.close();
	}
}
