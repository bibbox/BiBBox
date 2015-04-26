package at.graz.meduni.liferay.portlet.bibbox.network;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import at.graz.meduni.liferay.portlet.bibbox.rdconnect.service.service.RDConnectEventLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.model.Networks;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.NetworksImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.service.NetworksLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class NetworkViewOrganizations
 */
public class NetworkViewOrganizations extends MVCPortlet {
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void updateNetworkOrganisations(ActionRequest request, ActionResponse response) throws Exception {
		try {
			long counter = ParamUtil.getLong(request,"bibbox_cs_counter");
			long networkorganizationId = ParamUtil.getLong(request,"bibbox_cs_networkId");
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			List<Networks> networks = NetworksLocalServiceUtil.getNetworkOrganizations(networkorganizationId);
			HashMap<Long, Long> existingorganisationids = new HashMap<Long, Long>();
			System.out.println(networkorganizationId + " - " + counter);
			Organization network_organization = OrganizationLocalServiceUtil.getOrganization(networkorganizationId);
			for(Networks network : networks) {
				existingorganisationids.put(network.getOrganizationId(), network.getNetworkId());
			}	
			for(int i=0; i<counter; i++) {
				if(ParamUtil.getBoolean(request,"bibbox_cs_organisations_" + i)) {
					long request_organisationid = ParamUtil.getLong(request,"bibbox_cs_organisationsid_" + i);
					System.out.println(request_organisationid);
					if(existingorganisationids.containsKey(request_organisationid)) {
						existingorganisationids.remove(request_organisationid);
					} else {
						NetworksImpl newnetwork = new NetworksImpl();
						newnetwork.setNetworkId(CounterLocalServiceUtil.increment(Networks.class.getName()));
						newnetwork.setOrganizationnetworkId(networkorganizationId);
						newnetwork.setOrganizationId(request_organisationid);
						newnetwork.setRelation("");
						newnetwork.setExternalnetworkId("");
						newnetwork.setYearofestablishment("");
						NetworksLocalServiceUtil.addNetworks(newnetwork);
						
						Organization neworganization = OrganizationLocalServiceUtil.getOrganization(request_organisationid);
						String shorttext =  "The [url organization " + network_organization.getOrganizationId() + "]" + network_organization.getName() + "[urlend] added the " + neworganization.getExpandoBridge().getAttribute("Organization Type").toString() + ": [url organization " + neworganization.getOrganizationId() + "]" 
						+ neworganization.getName() + "[urlend] to the network.";
						String longtext =  "The [url organization " + network_organization.getOrganizationId() + "]" + network_organization.getName() + "[urlend] added the " + neworganization.getExpandoBridge().getAttribute("Organization Type").toString() + ": [url organization " + neworganization.getOrganizationId() + "]" 
						+ neworganization.getName() + "[urlend] to the network.";
						String link = "";
						String restriced = "";
						addEventEntry("Network Updated", new Date(), network_organization.getOrganizationId(), themeDisplay.getUserId(), shorttext, longtext, link, restriced);
					}
				}
			}
			for(long deleteorganisationid : existingorganisationids.keySet()) {
				try {
					NetworksLocalServiceUtil.deleteNetworks(existingorganisationids.get(deleteorganisationid));
					
					Organization neworganization = OrganizationLocalServiceUtil.getOrganization(deleteorganisationid);
					String shorttext =  "The " + neworganization.getExpandoBridge().getAttribute("Organization Type").toString() + ": [url organization " + neworganization.getOrganizationId() + "]" + neworganization.getName() + "[urlend] was removed from the [url organization " + network_organization.getOrganizationId() 
							+ "]" + network_organization.getName() + "[urlend] network.";
					String longtext =  "The " + neworganization.getExpandoBridge().getAttribute("Organization Type").toString() + ": [url organization " + neworganization.getOrganizationId() + "]" + neworganization.getName() + "[urlend] was removed from the [url organization " + network_organization.getOrganizationId() 
							+ "]" + network_organization.getName() + "[urlend] network.";
					String link = "";
					String restriced = "";
					addEventEntry("Network Updated", new Date(), network_organization.getOrganizationId(), themeDisplay.getUserId(), shorttext, longtext, link, restriced);
				} catch(Exception e) {
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.network.NetworkViewOrganizations::updateNetworkOrganisations] Error wihle deleting OrganizationId: " + deleteorganisationid + " from NetworkId: " + networkorganizationId + ".");
					e.printStackTrace();
				}
			}
		sendRedirect(request, response);
		} catch (Exception e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.network.NetworkViewOrganizations::updateNetworkOrganisations] Error wihle Updating Network.");
			e.printStackTrace();
		}
	}
	
	/**
	 * RD-Connect Event System add event entry
	 * 
	 * @param eventdate
	 * @param organizationId
	 * @param userId
	 * @param shorttext
	 * @param longtext
	 * @param link
	 * @param restricted
	 */
	private void addEventEntry(String eventtype, Date eventdate, long organizationId, long userId, String shorttext, String longtext, String link, String restricted) {
		RDConnectEventLocalServiceUtil.createEvent(eventtype, eventdate, organizationId, userId, shorttext, longtext, link, restricted);
	}
}
