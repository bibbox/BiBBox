package at.meduni.liferay.portlet.rdconnect.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.http.HttpResponse;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.HttpClientBuilder;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SearchDisplay
 */
public class SearchDisplay extends MVCPortlet {

	public void negotiationStartUpdate(ActionRequest request, ActionResponse response) throws Exception {
		System.out.println("Start Negotiation!");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String ntoken = ParamUtil.getString(request, "ntoken");
		System.out.println("ntoken: " + ntoken);
		String organistionidlist = ParamUtil.getString(request, "negotiation_organistionidlist");
		System.out.println("organistionidlist: " + organistionidlist);
		String selected_ids = "";
		JSONObject json = JSONFactoryUtil.createJSONObject();
		JSONArray jsonarray_collections = JSONFactoryUtil.createJSONArray();
		for(String organizationid : organistionidlist.split(";")) {
			try {
				boolean negotiation = ParamUtil.getBoolean(request, "negotiation_" + organizationid);
				
				
				if(negotiation) {
					JSONObject json_collection = JSONFactoryUtil.createJSONObject();
					//Organization organization = OrganizationLocalServiceUtil.getOrganization(Long.parseLong(organizationid));
					json_collection.put("collectionId", organizationid);
					json_collection.put("biobankId", organizationid);
					jsonarray_collections.put(json_collection);
					selected_ids += organizationid + ";";
				}

				
			} catch(Exception e) {
				System.err.println("Error creating negotiater request");
				e.printStackTrace();
			}
		}
		
		String humanReadable =  ParamUtil.getString(request, "humanReadable");
		json.put("humanReadable", humanReadable);
		json.put("collections", jsonarray_collections);
		json.put("nToken", ntoken);
		String ntokenurl = "";
		if(ntoken != null && !ntoken.equals("") && !ntoken.equals("null")) {
			ntokenurl = "&nToken=" + ntoken;
		}
		json.put("URL", "http://catalogue.rd-connect.eu/web/guest/search?_portalmenu_WAR_RDConnectportlet_formDate=1540359556129&SEARCH=" + humanReadable.replace(" ", "+") + "&selectedbiobanks=" + selected_ids + ntokenurl);
	
		
		// -----
		String url = "https://negotiator.bbmri-eric.eu/api/directory/create_query";
		HttpClient clinet = HttpClientBuilder.create().build();
		HttpPost p = new HttpPost(url);
		UsernamePasswordCredentials creds = new UsernamePasswordCredentials("bbmri-directory", "l9DRKUDNq0Sl02IxZPd6");
		//p.addHeader("username", "admin");
		//p.addHeader("password", "admin");
		p.addHeader("content-type", "application/json");
		p.setHeader("Accept", "application/json");
		p.addHeader(new BasicScheme().authenticate(creds, p, null));
		p.setEntity(new StringEntity(json.toString(), ContentType.create("application/json")));
		
		System.out.println(json.toString());
		
		try {
			HttpResponse response_http = clinet.execute(p);
			BufferedReader reader = new BufferedReader(new InputStreamReader(response_http.getEntity().getContent()));
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				System.out.println("line: " + line);
				JSONObject json_response = JSONFactoryUtil.createJSONObject(line);
				String redirect_url = json_response.getString("redirect_uri");
				response.sendRedirect(redirect_url);
				System.out.println(line);
			}
		} catch(Exception e) {
			System.err.println("Error: Problem with the negotiation connection");
			e.printStackTrace();
		}
		
	}

}
