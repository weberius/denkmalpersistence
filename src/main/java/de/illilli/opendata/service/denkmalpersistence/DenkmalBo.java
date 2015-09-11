package de.illilli.opendata.service.denkmalpersistence;

import java.util.HashMap;
import java.util.Map;

import org.geojson.GeoJsonObject;
import org.geojson.LngLatAlt;
import org.geojson.Point;

public class DenkmalBo {

	private String id;
	Map<String, Object> properties;
	private Point point;

	public DenkmalBo(Denkmal denkmal) {
		id = denkmal.id;
		setPoint(denkmal);
		setProperties(denkmal);
	}

	private void setProperties(Denkmal denkmal) {
		properties = new HashMap<String, Object>();
		properties.put("denkmalnummer", denkmal.denkmalnummer);
		properties.put("strasse", denkmal.strasse);
		properties.put("nummer", denkmal.nummer);
		properties.put("plz", denkmal.plz);
		properties.put("baujahr", denkmal.baujahr);
		properties.put("kurzbezeichnung", denkmal.kurzbezeichnung);
		String adresse = denkmal.plz + " Köln, " + denkmal.strasse + " "
				+ denkmal.nummer;
		properties.put("adresse", adresse);

	}

	private void setPoint(Denkmal denkmal) {
		point = new Point();
		LngLatAlt coordinates = new LngLatAlt();
		coordinates.setLatitude(denkmal.lat);
		coordinates.setLongitude(denkmal.lon);
		point.setCoordinates(coordinates);
	}

	public String getId() {
		return id;
	}

	public GeoJsonObject getPoint() {
		return point;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

}
