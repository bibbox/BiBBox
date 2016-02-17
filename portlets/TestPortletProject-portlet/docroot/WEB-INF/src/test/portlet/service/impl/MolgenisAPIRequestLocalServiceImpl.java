/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package test.portlet.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import sun.misc.BASE64Encoder;
import test.portlet.service.base.MolgenisAPIRequestLocalServiceBaseImpl;

/**
 * The implementation of the molgenis a p i request local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link test.portlet.service.MolgenisAPIRequestLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author reihsr
 * @see test.portlet.service.base.MolgenisAPIRequestLocalServiceBaseImpl
 * @see test.portlet.service.MolgenisAPIRequestLocalServiceUtil
 */
public class MolgenisAPIRequestLocalServiceImpl extends
		MolgenisAPIRequestLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * test.portlet.service.MolgenisAPIRequestLocalServiceUtil} to access the
	 * molgenis a p i request local service.
	 */
	private static Date token_date_ = null;
	private static String token_ = null;
	private String username_ = "user";
	private String password_ = "hackathon789";

	/**
	 * 
	 * @return the javascript for creating the table or an empty sting if there was an error.
	 */
	public String getAgregatedJsonFromMolgenis(String biobankid) {
		//test();
		//javax.net.ssl.SSLProtocolException: handshake alert:  unrecognized_name
		System.setProperty("jsse.enableSNIExtension", "false");
		Date currentdate = new Date();
		System.out.println("## Calling Molgenis API");
		if (token_date_ == null || (currentdate.getTime() - token_date_.getTime()) > 6000000) { // login after 100 minutes
			loginToMolgenis();
		}
		for(int retries = 0; retries < 10; retries++) {
			System.out.println("Reading Data: " + retries);
			String return_string = readData(biobankid);
			if(return_string.equalsIgnoreCase("ERROR:LoginPermission.")) {
				loginToMolgenis();
			} else {
				return return_string;
			}
		}
		return "";
	}
	
	public void testAPIUpdate() {
		String url = "http://catalogue.rd-connect.eu/apiv1/update";
		System.out.println("-- API Update Test: " + url);
		try {
			HttpClient c = HttpClientBuilder.create().build();

			HttpPost p = new HttpPost(url);
			BASE64Encoder base = new BASE64Encoder();
			String encoding = base.encode("jud@patientcrossroads.com:rdc2016".getBytes());
			p.addHeader("Authorization", "Basic " + encoding);
			p.setHeader(HTTP.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
			System.out.println("Authorization:" + encoding);
		
			String entry = "[{\"/update-portlet.idcard/diseasematrix\": {\"url\": \"https://connect.patientcrossroads.org/?org=algsa\",\"diseasname\": \"Alagille Syndrome 1\",\"patientcount\": \"\",\"gene\": \"JAG1\",\"orphanumber\": \"ORPHA52\",\"icd10\": \"Q44.7\",\"omim\": \"#610205\",\"synonym\": \"ALGS1\"}}]";
			p.setEntity(new StringEntity(entry, ContentType.APPLICATION_JSON));

			HttpResponse r = c.execute(p);

			BufferedReader rd = new BufferedReader(new InputStreamReader(r.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				// Parse our JSON response
				System.out.println(line);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void test() {
		HttpClient c = HttpClientBuilder.create().build();
		HttpPost p = new HttpPost("http://localhost:8080/api/jsonws/invoke");
//BiBBoxCommonServices-portlet.logapi/getapiversion/data/
		//BiBBoxCommonServices-portlet.logapi/testmethode
		
		String post = "{\"/BiBBoxCommonServices-portlet.logapi/testmethode\": {\"jason\": abc,\"param2\": 123,\"param3\": test}}";
		
		p.setEntity(new StringEntity(post,
				ContentType.create("application/json")));

		try {
			HttpResponse r = c.execute(p);
			BufferedReader rd = new BufferedReader(new InputStreamReader(r
					.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				System.out.println("+++++++" + line);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Login to the Molgenis server and add the token to the class and updating the time for the token.
	 */
	private void loginToMolgenis() {
		String url = "https://molgenis21.target.rug.nl/api/v1/login";
		System.out.println("-- Calling Molgenis Login API: " + url);
		try {
			HttpClient c = HttpClientBuilder.create().build();
			HttpPost p = new HttpPost(url);

			p.setEntity(new StringEntity("{\"username\":\"" + username_
					+ "\",\"password\":\"" + password_ + "\"}",
					ContentType.create("application/json")));

			HttpResponse r = c.execute(p);

			BufferedReader rd = new BufferedReader(new InputStreamReader(r
					.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				// Parse our JSON response
				JSONParser j = new JSONParser();
				JSONObject o = (JSONObject) j.parse(line);

				token_ = (String) o.get("token");
				token_date_ = new Date();
			}
		} catch (ParseException e) {
			System.out.println("ERROR: loginToMolgenis()");
			System.out.println(e);
		} catch (IOException e) {
			System.out.println("ERROR: loginToMolgenis()");
			System.out.println(e);
		}
	}

	/**
	 * 
	 * @param token
	 * @return
	 */
	private String readData(String biobankid) {
		//String url = "https://molgenis21.target.rug.nl/api/v2/test?aggs=x==Diseases;distinct==ParticipantID&q=BiobankID=q=\"http%3A%2F%2Fcatalogue.rd-connect.eu%2Fweb%2F71542\"";
		//String url = "https://molgenis21.target.rug.nl/api/v2/test?aggs=x==Diseases;distinct==ParticipantID";
		String url = "https://molgenis21.target.rug.nl/api/v2/rdconnect_Sample?aggs=x==Disease;distinct==ParticipantID&q=BiobankID==" + biobankid;
		System.out.println(url);
		try {
			// Construct Table Columns
			String cols = "{key: 'Disease Name',sortable: true},";
			cols += "{key: 'Number of Patients, Donors',sortable: true},";
			cols += "{key: 'Gene',sortable: true},";
			cols += "{key: 'ORPHA Code',sortable: true},";
			cols += "{key: 'ICD 10',sortable: true},";
			cols += "{key: 'OMIM',sortable: true},";
			cols += "{key: 'Synonym(s)',sortable: true}";
			// Create request
			HttpClient clinet = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			get.addHeader("x-molgenis-token", token_);
			HttpResponse response = clinet.execute(get);
			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = reader.readLine()) != null) {
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
					JSONArray matrixarray = (JSONArray) aggregates.get("matrix");
					for(int rows = 0; rows < xlabelarray.size(); rows ++) {
						JSONObject xlabel = (JSONObject) xlabelarray.get(rows);
						JSONArray count = (JSONArray) matrixarray.get(rows);
						
						if(!data.equals("")) {
							data += ",";
						}
						
						data += "{'Disease Name':'" + (String) xlabel.get("Label") + "',";
						data += "'Number of Patients, Donors':'" + count.get(0) + "',";
						data += "'ORPHA Code':'" + (String) xlabel.get("IRI") + "'}";
						
					}
					
					String returnstring = "AUI().use('aui-datatable','aui-datatype','datatable-sort',function(Y) {var remoteData = ["
							+ data
							+ "];var nestedCols = ["
							+ cols
							+ "];var dataTable = new Y.DataTable({columns: nestedCols,data: remoteData}).render('#diseasematrix');dataTable.get('boundingBox').unselectable();});";
	
					return returnstring;
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
}