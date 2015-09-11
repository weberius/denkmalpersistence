package de.illilli.opendata.service.denkmalpersistence;

import java.util.Hashtable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <pre>
 * {
 * 	"denkmalnummer":1,
 * 	"untergruppe1":"",
 * 	"untergruppe2":"0",
 * 	"strasse":"Adolphstrasse",
 * 	"nummer":"o.Nr.",
 * 	"bezirk":1,
 * 	"plz":50679,
 * 	"ort":"Deutz",
 * 	"unterSchutz":"01.07.1980",
 * 	"baujahrZusatz":"",
 * 	"baujahr":"1910",
 * 	"kurzbezeichnung":"Allee",
 * 	"feedsFlatstoreEntryId":1,
 * 	"timestamp":1432648733,
 * 	"feedsEntityId":1187,
 * 	"lon":6.9767532,
 * 	"lat":50.9353499
 * }
 * </pre>
 */
public class Denkmal {

	@JsonProperty("_id")
	public String id;
	@JsonProperty("denkmalnummer")
	public int denkmalnummer;
	@JsonProperty("lon")
	public double lon;
	@JsonProperty("lat")
	public double lat;
	@JsonProperty("displayOsmAddress")
	public String displayOsmAddress;
	@JsonProperty("url")
	public String url;

	@JsonProperty("untergruppe1")
	public String untergruppe1;
	@JsonProperty("untergruppe2")
	public String untergruppe2;
	@JsonProperty("strasse")
	public String strasse;
	@JsonProperty("nummer")
	public String nummer;
	@JsonProperty("bezirk")
	public int bezirk;
	@JsonProperty("plz")
	public int plz;
	@JsonProperty("ort")
	public String ort;
	@JsonProperty("unterSchutz")
	public String unterSchutz;
	@JsonProperty("baujahrZusatz")
	public String baujahrZusatz;
	@JsonProperty("baujahr")
	public String baujahr;
	@JsonProperty("kurzbezeichnung")
	public String kurzbezeichnung;
	@JsonProperty("feedsFlatstoreEntryId")
	public int feedsFlatstoreEntryId;
	@JsonProperty("timestamp")
	public long timestamp;
	@JsonProperty("feedsEntityId")
	public int feedsEntityId;

	public Map<String, Object> getAsMap() {
		Map<String, Object> map = new Hashtable<String, Object>();
		map.put("denkmalnummer", denkmalnummer);
		map.put("untergruppe1", untergruppe1);
		map.put("untergruppe2", untergruppe2);
		map.put("strasse", strasse);
		map.put("nummer", nummer);
		map.put("bezirk", bezirk);
		map.put("plz", plz);
		map.put("ort", ort);
		map.put("unterSchutz", unterSchutz);
		map.put("baujahrZusatz", baujahrZusatz);
		map.put("baujahr", baujahr);
		map.put("kurzbezeichnung", kurzbezeichnung);
		map.put("feedsFlatstoreEntryId", feedsFlatstoreEntryId);
		map.put("timestamp", timestamp);
		map.put("feedsEntityId", feedsEntityId);
		map.put("lon", lon);
		map.put("lat", lat);
		if (displayOsmAddress != null) {
			map.put("displayOsmAddress", displayOsmAddress);
		}
		map.put("url", url);
		return map;
	}

	@Override
	public String toString() {
		return "Denkmal [denkmalnummer=" + denkmalnummer + ", untergruppe1="
				+ untergruppe1 + ", untergruppe2=" + untergruppe2
				+ ", strasse=" + strasse + ", nummer=" + nummer + ", bezirk="
				+ bezirk + ", plz=" + plz + ", ort=" + ort + ", unterSchutz="
				+ unterSchutz + ", baujahrZusatz=" + baujahrZusatz
				+ ", baujahr=" + baujahr + ", kurzbezeichnung="
				+ kurzbezeichnung + ", feedsFlatstoreEntryId="
				+ feedsFlatstoreEntryId + ", timestamp=" + timestamp
				+ ", feedsEntityId=" + feedsEntityId + ", lon=" + lon
				+ ", lat=" + lat + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baujahr == null) ? 0 : baujahr.hashCode());
		result = prime * result
				+ ((baujahrZusatz == null) ? 0 : baujahrZusatz.hashCode());
		result = prime * result + bezirk;
		result = prime * result + denkmalnummer;
		result = prime * result + feedsEntityId;
		result = prime * result + feedsFlatstoreEntryId;
		result = prime * result
				+ ((kurzbezeichnung == null) ? 0 : kurzbezeichnung.hashCode());
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lon);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nummer == null) ? 0 : nummer.hashCode());
		result = prime * result + ((ort == null) ? 0 : ort.hashCode());
		result = prime * result + plz;
		result = prime * result + ((strasse == null) ? 0 : strasse.hashCode());
		result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
		result = prime * result
				+ ((unterSchutz == null) ? 0 : unterSchutz.hashCode());
		result = prime * result
				+ ((untergruppe1 == null) ? 0 : untergruppe1.hashCode());
		result = prime * result
				+ ((untergruppe2 == null) ? 0 : untergruppe2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Denkmal other = (Denkmal) obj;
		if (baujahr == null) {
			if (other.baujahr != null)
				return false;
		} else if (!baujahr.equals(other.baujahr))
			return false;
		if (baujahrZusatz == null) {
			if (other.baujahrZusatz != null)
				return false;
		} else if (!baujahrZusatz.equals(other.baujahrZusatz))
			return false;
		if (bezirk != other.bezirk)
			return false;
		if (denkmalnummer != other.denkmalnummer)
			return false;
		if (feedsEntityId != other.feedsEntityId)
			return false;
		if (feedsFlatstoreEntryId != other.feedsFlatstoreEntryId)
			return false;
		if (kurzbezeichnung == null) {
			if (other.kurzbezeichnung != null)
				return false;
		} else if (!kurzbezeichnung.equals(other.kurzbezeichnung))
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lon) != Double.doubleToLongBits(other.lon))
			return false;
		if (nummer == null) {
			if (other.nummer != null)
				return false;
		} else if (!nummer.equals(other.nummer))
			return false;
		if (ort == null) {
			if (other.ort != null)
				return false;
		} else if (!ort.equals(other.ort))
			return false;
		if (plz != other.plz)
			return false;
		if (strasse == null) {
			if (other.strasse != null)
				return false;
		} else if (!strasse.equals(other.strasse))
			return false;
		if (timestamp != other.timestamp)
			return false;
		if (unterSchutz == null) {
			if (other.unterSchutz != null)
				return false;
		} else if (!unterSchutz.equals(other.unterSchutz))
			return false;
		if (untergruppe1 == null) {
			if (other.untergruppe1 != null)
				return false;
		} else if (!untergruppe1.equals(other.untergruppe1))
			return false;
		if (untergruppe2 == null) {
			if (other.untergruppe2 != null)
				return false;
		} else if (!untergruppe2.equals(other.untergruppe2))
			return false;
		return true;
	}

}
