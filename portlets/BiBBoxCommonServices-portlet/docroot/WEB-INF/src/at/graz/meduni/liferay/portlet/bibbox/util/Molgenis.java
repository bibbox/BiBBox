package at.graz.meduni.liferay.portlet.bibbox.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder;
import at.graz.meduni.liferay.portlet.bibbox.service.OrphanetDisorderLocalServiceUtil;

import com.liferay.portal.kernel.servlet.SessionErrors;

/**
 * Molgenis Util Object
 * 
 * Based on Singleton Pattern
 */
public class Molgenis {
	private static Molgenis molgenis_instance_ = new Molgenis();
	private static Date token_date_ = null;
	private static String token_ = null;
	private String login_url_ = "https://molgenis21.gcc.rug.nl/api/v1/login";
	private String username_ = "user";
	private String password_ = "hackathon789";
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	String class_ = "BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.util.Molgenis::";
	
	/**
	 * Private constructor
	 */
	private Molgenis() {
		
	}
	
	/**
	 * Get an instance of the Molgenis Object
	 * 
	 * @return
	 */
	public static Molgenis getInstance() {
		return molgenis_instance_;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAgregatedJsonFromMolgenis(String biobankid) {
		Date currentdate = new Date();
		if (token_date_ == null || (currentdate.getTime() - token_date_.getTime()) > 6000000) { // login after 100 minutes
			login();
		}
		System.out.println("getAgregatedJsonFromMolgenis");
		String jsondata = readData(biobankid);
		return jsondata;
	}
	
	/**
	 * 
	 * @param biobankid
	 * @return
	 */
	private String readData(String biobankid) {
		//biobankid = "77350";
		//String url = "https://molgenis21.gcc.rug.nl/api/v2/rdconnect_Sample?aggs=x==Disease;y==RegistryID;distinct==ParticipantID&q=BiobankID==" + biobankid;
		String url = "https://molgenis21.gcc.rug.nl/api/v2/rdconnect_Sample?aggs=x==Disease;y==RegistryID;distinct==ParticipantID&q=BiobankID==" + biobankid;
		System.out.println(url);
		try {
			// Create request
			HttpClient clinet = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			get.addHeader("x-molgenis-token", token_);
			HttpResponse response = clinet.execute(get);
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				if(line.contains("{\"errors\":[{\"message\":\"No COUNT permission on entity test\"}]}")) {
					// Login Error:
					return "ERROR:LoginPermission.";
				} else {
					String data = "";
					// Parse our JSON response
					JSONParser jsonparser = new JSONParser();
					JSONObject baseobject = (JSONObject) jsonparser.parse(line);
					// getting the aggregated table
					JSONObject aggregates = (JSONObject) baseobject.get("aggs");
					JSONArray xlabelarray = (JSONArray) aggregates.get("xLabels");
					JSONArray ylabelarray = (JSONArray) aggregates.get("yLabels");
					JSONArray matrixarray = (JSONArray) aggregates.get("matrix");
					for(int rows = 0; rows < xlabelarray.size(); rows ++) {
						JSONObject xlabel = (JSONObject) xlabelarray.get(rows);
						JSONArray count = (JSONArray) matrixarray.get(rows);
						
						if(!data.equals("")) {
							data += ",";
						}
						
						int numberofdoners = 0;
						String registryorganizations = "";
						String splitter = "";
						
						for(int rowsy = 0; rowsy < ylabelarray.size(); rowsy ++) {
							JSONObject ylabel = (JSONObject) ylabelarray.get(rowsy);
							registryorganizations += splitter + ylabel.get("OrganizationID");
							splitter = ",";
							try {
								numberofdoners += Integer.parseInt(count.get(0).toString());
							} catch (Exception e) {
								System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + class_ + "readData] Parser error in patient count.");
								System.out.println(e);
							}
						}
						
						try {
							long orphanumber = Long.parseLong(xlabel.get("Code").toString());
							OrphanetDisorder disorder = OrphanetDisorderLocalServiceUtil.getOrphanetDisorderByOrphanumber(orphanumber);
							
							data += "{\"ORPHA Code\":\"ORPHA" + xlabel.get("Code").toString() + "\",";
							data += "\"NumberofPatientsDonors\":\"" + numberofdoners + "\",";
							data += "\"Disease Name\":\"" + disorder.getDiseasename() + "\",";
							data += "\"Gene\":\"" + "" + "\",";
							data += "\"ICD 10\":\"" + disorder.getICD10() + "\",";
							data += "\"OMIM\":\"" + disorder.getOMIM() + "\",";
							data += "\"Synonym\":\"" + disorder.getSynonym() + "\",";
							data += "\"SampleCatalogue\":\"https://molgenis21.gcc.rug.nl/menu/main/dataexplorer?entity=rdconnect_Sample&hideselect=true\",";
							data += "\"Registries\":\"" + registryorganizations + "\"}";
							
							// Disease Name, Number of Patients, Donors, Gene, ORPHA Code, ICD 10, OMIM, Synonym(s), Modified Date
						} catch (Exception e) {
							System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + class_ + "readData] Error creating data entry for disearmatrix.");
							System.out.println(e);
						}
						
					}
					System.out.println("data: " + data);
					return data;
				}
			}
		} catch (ParseException e) {
			System.out.println("ERROR: readData(String token)");
			System.out.println(e);
		} catch (IOException e) {
			System.out.println("ERROR: readData(String token)");
			System.out.println(e);
		}
		return "";
	}
	
	/**
	 * Login to the Molgenis system. Retrieving the header token and updating the date for the token
	 * 
	 */
	private void login() {
		try {
			System.out.println("Login to Molgenis");
			HttpClient c = HttpClientBuilder.create().build();
			HttpPost p = new HttpPost(login_url_);

			p.setEntity(new StringEntity("{\"username\":\"" + username_
					+ "\",\"password\":\"" + password_ + "\"}",
					ContentType.create("application/json")));

			HttpResponse r = c.execute(p);

			BufferedReader rd = new BufferedReader(new InputStreamReader(r.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				// Parse our JSON response
				JSONParser j = new JSONParser();
				JSONObject o = (JSONObject) j.parse(line);

				token_ = (String) o.get("token");
				token_date_ = new Date();
			}
		} catch (ParseException e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + class_ + "login] Parser Exaption while trying to login to molgenis.");
			System.out.println(e);
		} catch (IOException e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + class_ + "login] IO Exaption while trying to login to molgenis.");
			System.out.println(e);
		}
	}
}
