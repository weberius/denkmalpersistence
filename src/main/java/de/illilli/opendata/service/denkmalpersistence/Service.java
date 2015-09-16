package de.illilli.opendata.service.denkmalpersistence;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

@Path("/")
public class Service {

	private final static Logger logger = Logger.getLogger(Service.class);

	@Context
	private HttpServletRequest request;
	@Context
	private HttpServletResponse response;

	/**
	 * <p>
	 * Beispiel: <a href="http://localhost:8080/denkmalpersistence/service/load"
	 * >/denkmalpersistence/service/load</a>
	 * </p>
	 * 
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/load")
	public String getGenerate() throws MalformedURLException, IOException {
		LoadFacade facade = new LoadFacade();
		facade.generate();
		return "all data loaded";
	}

	/**
	 * 
	 * <p>
	 * Beispiel: <a href="http://localhost:8080/denkmalpersistence/service/geo"
	 * >/denkmalpersistence/service/geo</a>
	 * </p>
	 * 
	 * @return GeoJson-FeatureCollection as String
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/geo")
	public String getGeojson() throws MalformedURLException, IOException {
		logger.info("geo");
		response.setCharacterEncoding("UTF-8");
		GeoFacade facade = new GeoFacade();
		return facade.getJson();
	}

	/**
	 * 
	 * <p>
	 * Beispiel: <a
	 * href="http://localhost:8080/denkmalpersistence/service/nogeo"
	 * >/denkmalpersistence/service/nogeo</a>
	 * </p>
	 * 
	 * @return GeoJson-FeatureCollection as String
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/nogeo")
	public String getNotlocated() throws MalformedURLException, IOException {
		response.setCharacterEncoding("UTF-8");
		NoGeoFacade facade = new NoGeoFacade();
		return facade.getJson();
	}

	/**
	 * Beispiel: <a href=
	 * "http://localhost:8080/denkmalpersistence/service/Denkmalliste.csv"
	 * >/denkmalpersistence/service/Denkmalliste.csv</a></p>
	 * 
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@GET
	@Produces("application/vnd.ms-excel")
	@Path("/Denkmalliste.csv")
	public String getCsv() throws MalformedURLException, IOException {
		response.setCharacterEncoding("UTF-8");
		CreateCvsFacade facade = new CreateCvsFacade(
				new AllFacade().getDenkmalList());
		return facade.getCvs();
	}

	/**
	 * Beispiel: <a href=
	 * "http://localhost:8080/denkmalpersistence/service/geo/Denkmalliste.csv"
	 * >/denkmalpersistence/service/geo/Denkmalliste.csv</a></p>
	 * 
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@GET
	@Produces("application/vnd.ms-excel")
	@Path("/geo/Denkmalliste.csv")
	public String getGeoCsv() throws MalformedURLException, IOException {
		response.setCharacterEncoding("UTF-8");
		CreateCvsFacade facade = new CreateCvsFacade(
				new GeoFacade().getDenkmalList());
		return facade.getCvs();
	}

	/**
	 * Beispiel: <a href=
	 * "http://localhost:8080/denkmalpersistence/service/nogeo/Denkmalliste.csv"
	 * >/denkmalpersistence/service/nogeo/Denkmalliste.csv</a></p>
	 * 
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@GET
	@Produces("application/vnd.ms-excel")
	@Path("/nogeo/Denkmalliste.csv")
	public String getNoGeoCsv() throws MalformedURLException, IOException {
		response.setCharacterEncoding("UTF-8");
		CreateCvsFacade facade = new CreateCvsFacade(
				new NoGeoFacade().getDenkmalList());
		return facade.getCvs();
	}

}
