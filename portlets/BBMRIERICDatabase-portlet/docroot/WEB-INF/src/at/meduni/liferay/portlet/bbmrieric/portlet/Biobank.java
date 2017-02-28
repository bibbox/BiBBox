package at.meduni.liferay.portlet.bbmrieric.portlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class D2Biobank
 */
public class Biobank extends MVCPortlet {
	
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	String negotiator_url_ = "https://bbmri-demo.mitro.dkfz.de/api/directory/create_query";
	
	/*
	 * (non-Javadoc)
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
	 */
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject();
			String searchurl = ParamUtil.getString(resourceRequest, "searchurl");
			String humanReadable = ParamUtil.getString(resourceRequest, "humanReadable");
			String collections = ParamUtil.getString(resourceRequest, "collections");
			String nTockenLiferay = ParamUtil.getString(resourceRequest, "nTockenLiferay");
			
			String redirect_uri = "";
			try {
				redirect_uri = createNegotiation(searchurl, humanReadable, collections, nTockenLiferay);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(redirect_uri.equalsIgnoreCase("")) {
				redirect_uri = "An Error occurred, please try later again.";
			}
			json.put("redirect_uri", redirect_uri);
			resourceResponse.getPortletOutputStream().write(json.toString().getBytes());
		} catch (IOException e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.portlet.Biobank::serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)] Error creating Negotiation.");
			e.printStackTrace();
		}
	}
	
	private String createNegotiation(String searchurl, String humanReadable, String collections, String nTockenLiferay) throws ClientProtocolException, IOException, JSONException {
		


		/*CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("molgenis", "gogogo"));
		CloseableHttpClient c = HttpClientBuilder.create().setDefaultCredentialsProvider(credentialsProvider).build();*/


		
		HttpClient c = HttpClientBuilder.create().build();
		HttpPost p = new HttpPost(negotiator_url_);
		
		if(nTockenLiferay.equalsIgnoreCase("false")) {
			nTockenLiferay = "";
		} else {
			nTockenLiferay = ", \"nToken\":\"" + nTockenLiferay + "\"";
		}

		p.setEntity(new StringEntity("{\"URL\":\"" + searchurl
				+ "\",\"humanReadable\":\"" + humanReadable
				+ "\",\"collections\":" + collections + nTockenLiferay + "}",
				ContentType.create("application/json")));
		
		p.setHeader("Authorization", "Basic bW9sZ2VuaXM6Z29nb2dv");
		
		HttpResponse r = c.execute(p);

		BufferedReader rd = new BufferedReader(new InputStreamReader(r.getEntity().getContent()));
		String line = "";
		String redirect_uri = "";
		while ((line = rd.readLine()) != null) {
			// Parse our JSON response
			System.out.println(line);
			JSONObject o = JSONFactoryUtil.createJSONObject(line);

			redirect_uri = o.getString("redirect_uri");
		}
		return redirect_uri;
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void addBiobank(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Biobank.class.getName(), request);

		try {
			D2BiobankLocalServiceUtil.addD2Biobank(D2BiobankLocalServiceUtil.d2BiobankFromRequest(request), serviceContext);
			SessionMessages.add(request, "BiobankAdded");
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.portlet.Biobank::addBiobank] Error creating D2Biobank.");
			e.printStackTrace();
			SessionErrors.add(request, e.getClass().getName());
			response.setRenderParameter("mvcPath", "/html/idcard/biobank/edit_biobank.jsp");
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void updateBiobank(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Biobank.class.getName(), request);
		try {
			at.meduni.liferay.portlet.bbmrieric.model.D2Biobank biobank = D2BiobankLocalServiceUtil.d2BiobankFromRequest(request);
			D2BiobankLocalServiceUtil.updateD2Biobank(biobank, serviceContext);
			SessionMessages.add(request, "BiobankAdded");
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.portlet.Biobank::updateBiobank] Error creating D2Biobank.");
			e.printStackTrace();
			SessionErrors.add(request, e.getClass().getName());
			response.setRenderParameter("mvcPath", "/html/idcard/biobank/edit_biobank.jsp");
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 */
	public void deleteBiobank (ActionRequest request, ActionResponse response) {
		long biobankId = ParamUtil.getLong(request, "biobankId");
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Biobank.class.getName(), request);
			response.setRenderParameter("biobankId", Long.toString(biobankId));
			D2BiobankLocalServiceUtil.deleteD2Biobank(biobankId, serviceContext);
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.portlet.Biobank::deleteBiobank] Error deleating D2Biobank.");
			e.printStackTrace();
			SessionErrors.add(request, e.getClass().getName());
		}
	}

}
