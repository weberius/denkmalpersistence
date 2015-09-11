package de.illilli.opendata.service.denkmalpersistence;

import org.bson.Document;

public class Document2Denkmal extends Denkmal {

	private Denkmal denkmal = new Denkmal();

	public Document2Denkmal(Document document) {

		this.denkmal.id = (String) document.get("id");
		this.denkmal.denkmalnummer = (Integer) document.get("denkmalnummer");
		this.denkmal.lon = (Double) document.get("lon");
		this.denkmal.lat = (Double) document.get("lat");
		this.denkmal.displayOsmAddress = (String) document
				.get("displayOsmAddress");
		this.denkmal.url = (String) document.get("url");
		this.denkmal.untergruppe1 = (String) document.get("untergruppe1");
		this.denkmal.untergruppe2 = (String) document.get("untergruppe2");
		this.denkmal.strasse = (String) document.get("strasse");
		this.denkmal.nummer = (String) document.get("nummer");
		this.denkmal.bezirk = (Integer) document.get("bezirk");
		this.denkmal.plz = (Integer) document.get("plz");
		this.denkmal.ort = (String) document.get("ort");
		this.denkmal.unterSchutz = (String) document.get("unterSchutz");
		this.denkmal.baujahrZusatz = (String) document.get("baujahrZusatz");
		this.denkmal.baujahr = (String) document.get("baujahr");
		this.denkmal.kurzbezeichnung = (String) document.get("kurzbezeichnung");
		this.denkmal.feedsFlatstoreEntryId = (Integer) document
				.get("feedsFlatstoreEntryId");
		this.denkmal.timestamp = (Long) document.get("timestamp");
		this.denkmal.feedsEntityId = (Integer) document.get("feedsEntityId");
	}

	public Denkmal getDenkmal() {
		return denkmal;
	}
}
