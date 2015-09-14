package de.illilli.opendata.service.denkmalpersistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.geojson.Feature;
import org.geojson.FeatureCollection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class GeoFacade {

	private static final Logger logger = Logger.getLogger(GeoFacade.class);

	private FeatureCollection featureCollection = new FeatureCollection();
	private List<Denkmal> denkmalList = new ArrayList<Denkmal>();

	public GeoFacade() {
		MongoClient client = new MongoClient();
		MongoDatabase database = client.getDatabase("denkmalinkoeln");

		MongoCollection<Document> collection = database
				.getCollection("denkmal");

		Bson filter = new Document("lon", new Document("$gt", 0.0));
		List<Document> all = collection.find(filter).into(
				new ArrayList<Document>());

		// Zur Darstellung der POIs auf einer Karte werden die Denkmaeler in
		// ein GeoJson Objekt umgewandelt. Die mongodb-id soll die eindeutige id
		// sien.
		for (Document document : all) {
			Denkmal denkmal = new Document2Denkmal(document).getDenkmal();
			DenkmalBo bo = new DenkmalBo(denkmal);
			Feature feature = new Feature();
			feature.setGeometry(bo.getPoint());
			feature.setProperties(bo.getProperties());
			feature.setId(bo.getId());
			featureCollection.add(feature);
			logger.debug(denkmal.toString());
			// add denkmal to list
			denkmalList.add(denkmal);
		}
	}

	public List<Denkmal> getDenkmalList() {
		return denkmalList;
	}

	public String getJson() throws JsonProcessingException {
		String json = new ObjectMapper().writeValueAsString(featureCollection);
		return json;
	}

}
