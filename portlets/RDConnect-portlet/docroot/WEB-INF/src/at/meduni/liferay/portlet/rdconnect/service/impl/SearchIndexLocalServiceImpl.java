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

package at.meduni.liferay.portlet.rdconnect.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WebsiteLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

import at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix;
import at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixLocalServiceUtil;
import at.meduni.liferay.portlet.rdconnect.model.SearchIndex;
import at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateImpl;
import at.meduni.liferay.portlet.rdconnect.service.SearchIndexLocalServiceUtil;
import at.meduni.liferay.portlet.rdconnect.service.base.SearchIndexLocalServiceBaseImpl;

/**
 * The implementation of the search index local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.rdconnect.service.SearchIndexLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Robert Reihs
 * @see at.meduni.liferay.portlet.rdconnect.service.base.SearchIndexLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.rdconnect.service.SearchIndexLocalServiceUtil
 */
public class SearchIndexLocalServiceImpl extends SearchIndexLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.meduni.liferay.portlet.rdconnect.service.SearchIndexLocalServiceUtil} to access the search index local service.
	 */
	public String getSearchIndexByKeyword(String keyword, ThemeDisplay themeDisplay, String contextpath) {
		String searchresultstring = "";
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SearchIndex.class);
			Criterion criterion = RestrictionsFactoryUtil.ilike("value", StringPool.PERCENT + keyword + StringPool.PERCENT);
			dynamicQuery.add(criterion);
			Order order_organisationid = OrderFactoryUtil.asc("organisationid");
			Order order_location = OrderFactoryUtil.asc("location");
			Order order_locationid = OrderFactoryUtil.asc("locationid");
			dynamicQuery.addOrder(order_organisationid);
			dynamicQuery.addOrder(order_location);
			dynamicQuery.addOrder(order_locationid);
			List<SearchIndex> serachresults = SearchIndexLocalServiceUtil.dynamicQuery(dynamicQuery);
			// Format the result
			long oldorganizationid = 0;
			Organization organization = null;
			int regcount = 0;
			int bbcount = 0;
			SearchIndex oldsearchindex = null;
			String organizationline = "";
			String maincontactline = "";
			String organizationurl = "";
			HashMap<String, String> hits = null;
			for(SearchIndex serachresult : serachresults) {
				if(oldorganizationid == 0 || oldorganizationid != serachresult.getOrganisationid()) {
					if(hits != null) {
						// Generate previous entry
						searchresultstring += "<table class=\"rdc_coreinformation_organisation-table-images\">";
						searchresultstring += organizationline + maincontactline + organizationurl;
						for(String key : hits.keySet()) {
							searchresultstring += hits.get(key) + "</td></tr>";
						}
						searchresultstring += "</table>";
					}
					
					// Reset all variables
					organizationline = "";
					maincontactline = "";
					organizationurl = "";
					hits = new HashMap<String, String>();
					
					// New Hit
					oldorganizationid = serachresult.getOrganisationid();
					// Get Organization Data
					organization = OrganizationLocalServiceUtil.getOrganization(serachresult.getOrganisationid());
					long organizationId = organization.getOrganizationId();
					String organisationtype = "";
					String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+organization.getLogoId();
					String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
					String orgPathdiseases = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
					if(organization.getExpandoBridge().getAttribute("Organization Type").toString().equals("Biobank")) {
						bbcount++;
						if(organization.getLogoId() == 0) {
				 			imgPath = contextpath + "/images/Biobank.png";
				 		}
				 		orgPath = orgPath + "/bb_home";	
				 		orgPathdiseases = orgPathdiseases + "/bb_diseases";
				 		organisationtype = "Biobank";
					}
					if(organization.getExpandoBridge().getAttribute("Organization Type").toString().equals("Registry")) {
						regcount++;
						if(organization.getLogoId() == 0) {
				 			imgPath = contextpath + "/images/Registry.png";
				 		}
				 		orgPath = orgPath + "/reg_home";
				 		orgPathdiseases = orgPathdiseases + "/reg_diseases";
				 		organisationtype = "Registry";
					}
					// Organization Line
					organizationline = "<tr><td rowspan=\"3\" width=\"80px\"><a href=\"" + orgPath + "\"><img alt=\"logo\" src=\"" + imgPath + "\" width=\"60px\" /></a></td>";
					organizationline += "<td><a href=\"" + orgPath + "\">" + highlightResult(organization.getName(), keyword) + "</a></td></tr>";
					// Organization Main Contact
					long maincontactrole = 13320;
					User maincontact = null;
					List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organization.getOrganizationId());
					for(User usertmp : userlist) {
						List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(usertmp.getUserId(), organization.getGroup().getGroupId());
						for (UserGroupRole ugr : usergrouprolles) {
							if(ugr.getRoleId() == maincontactrole) {
								maincontact =  usertmp;
							}
						}
					}
					if(maincontact != null) {
						maincontactline += "<tr><td><a href=\"mailto:" + maincontact.getEmailAddress() + "\">" + highlightResult(maincontact.getFullName(), keyword) + "</a></td></tr>";
					} else {
						
					}
					// Organization URL
					organizationurl = "<tr><td>";
					boolean first = true;
					for(com.liferay.portal.model.Website website : WebsiteLocalServiceUtil.getWebsites(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId())) {
						if(!first) {
							organizationurl += "<br />";
							first = false;
						}
						organizationurl += "<a href=\"" + website.getUrl() + "\">" + highlightResult(website.getUrl(), keyword) + "</a>";
					}
					organizationurl += "</td></tr>";
					// First Hit
					if(!serachresult.getLocation().equalsIgnoreCase("OrganizationName")) {
						if(serachresult.getLocation().equalsIgnoreCase("Diseases")) {
							DiseaseMatrix diseasematrix = DiseaseMatrixLocalServiceUtil.getDiseaseMatrix(serachresult.getLocationid());
							hits.put(serachresult.getLocation() + serachresult.getLocationid(), "<tr><td>" + serachresult.getLocation() + "</td><td>" + 
									highlightResult(diseasematrix.getDiseasename(), keyword) + ": Number of Patients, Donors " + highlightResult(diseasematrix.getPatientcount(), keyword) + "<br />" +
									"&nbsp;&nbsp;&nbsp;&nbsp;" + highlightResult(serachresult.getKey(), keyword) + ": " + highlightResult(serachresult.getValue(), keyword));
						} else {
							hits.put(serachresult.getLocation() + serachresult.getLocationid(), "<tr><td>" + serachresult.getLocation() + "</td><td>" + 
									highlightResult(serachresult.getKey(), keyword) + ": " + highlightResult(serachresult.getValue(), keyword));
						}
					}				  	
				} else {
					if(hits.containsKey(serachresult.getLocation() + serachresult.getLocationid())) {
						if(serachresult.getLocation().equalsIgnoreCase("Diseases")) {
							hits.put(serachresult.getLocation() + serachresult.getLocationid(), hits.get(serachresult.getLocation() + serachresult.getLocationid()) + "<br />" + "&nbsp;&nbsp;&nbsp;&nbsp;" + highlightResult(serachresult.getKey(), keyword) + ": " + highlightResult(serachresult.getValue(), keyword));
						} else {
							hits.put(serachresult.getLocation() + serachresult.getLocationid(), hits.get(serachresult.getLocation() + serachresult.getLocationid()) + "<br />" + highlightResult(serachresult.getKey(), keyword) + ": " + highlightResult(serachresult.getValue(), keyword));
						}
					} else {
						if(serachresult.getLocation().equalsIgnoreCase("Diseases")) {
							DiseaseMatrix diseasematrix = DiseaseMatrixLocalServiceUtil.getDiseaseMatrix(serachresult.getLocationid());
							hits.put(serachresult.getLocation() + serachresult.getLocationid(), "<tr><td>" + serachresult.getLocation() + "</td><td>" + 
									highlightResult(diseasematrix.getDiseasename(), keyword) + ": Number of Patients, Donors " + highlightResult(diseasematrix.getPatientcount(), keyword) + "<br />" +
									"&nbsp;&nbsp;&nbsp;&nbsp;" + highlightResult(serachresult.getKey(), keyword) + ": " + highlightResult(serachresult.getValue(), keyword));
						} else {
							hits.put(serachresult.getLocation() + serachresult.getLocationid(), "<tr><td>" + serachresult.getLocation() + "</td><td>" + 
									highlightResult(serachresult.getKey(), keyword) + ": " + highlightResult(serachresult.getValue(), keyword));
						}
					}
				}
			}
			
			// Add the last entry
			searchresultstring += "<table class=\"rdc_coreinformation_organisation-table-images\">";
			searchresultstring += organizationline + maincontactline + organizationurl;
			for(String key : hits.keySet()) {
				searchresultstring += hits.get(key) + "</td></tr>";
			}
			searchresultstring += "</table>";
			// Add the number of Results
			searchresultstring = "<h4>Search returned " + serachresults.size() + " hits (Registries:" + regcount + " /Biobaks:" + bbcount + ")</h4><br /><br />" + searchresultstring;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(searchresultstring.length() == 0) {
			searchresultstring = "No Results for the query.";
		}
		return searchresultstring;
	}
	
	private String highlightResult(String text, String keyword) {
		if(text.toLowerCase().contains(keyword.toLowerCase())) {
			int beginindex = text.toLowerCase().indexOf(keyword.toLowerCase());
			while (beginindex >= 0) {
				beginindex = text.toLowerCase().indexOf(keyword.toLowerCase());
				int endindex = beginindex + keyword.length();
				text = text.substring(0, beginindex) + "<span style=\"background-color: yellow;\">" + text.substring(beginindex, endindex) + "</span>" + text.substring(endindex);
				beginindex = text.indexOf(keyword, beginindex + 1);
			}
		}
		return text;
	}
}