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

package at.graz.meduni.liferay.portlet.bibbox.service.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.PermissionServiceUtil;

import at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException;
import at.graz.meduni.liferay.portlet.bibbox.service.model.Networks;
import at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.service.NetworksLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.service.base.idcardServiceBaseImpl;
import at.meduni.liferay.portlet.rdconnect.model.SearchIndex;
import at.meduni.liferay.portlet.rdconnect.service.SearchIndexLocalServiceUtil;

/**
 * The implementation of the idcard remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.service.service.idcardService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.base.idcardServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.idcardServiceUtil
 */
public class idcardServiceImpl extends idcardServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.service.idcardServiceUtil} to access the idcard remote service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	String calss_name = "at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl";
	
	@JSONWebService(value = "testvariables", method = "POST")
	public JSONObject TestVariables(long idcardid) throws PortalException, SystemException {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("TestVariables", "View all available Variabels");
		json.put("this.counterLocalService", "possible counter");
		json.put("this.getUser().getLastLoginDate()", this.getUser().getLastLoginDate().toString());
		json.put("this.getUser().getLoginDate()", this.getUser().getLoginDate().toString());
		json.put("this.getUser().getLogin()", this.getUser().getLogin());
		return json; 
	}
	
	@JSONWebService(value = "diseasematrix", method = "POST")
	public JSONObject DiseaseMatrix(long idcardid, long diseaseid, String diseasname, String patientcount, String gene, String orphanumber, String icd10, String omim, String synonym) {
		System.out.println("diseasematrix: v1");
		System.out.println("               idcardid: " + idcardid);
		System.out.println("               diseaseid: " + diseaseid);
		System.out.println("               diseasname: " + diseasname);
		System.out.println("               patientcount:  " + patientcount);
		System.out.println("               gene:  " + gene);
		System.out.println("               orphanumber:  " + orphanumber);
		System.out.println("               icd10:  " + icd10);
		System.out.println("               omim:  " + omim);
		System.out.println("               synonym:  " + synonym);
		/*
		 * Start of real code
		 */
		return updateDiseaseMatrix(idcardid, "", diseaseid, diseasname, patientcount, gene, orphanumber, icd10, omim, synonym);
	}
	
	@JSONWebService(value = "diseasematrix", method = "POST")
	public JSONObject DiseaseMatrix(String url, long diseaseid, String diseasname, String patientcount, String gene, String orphanumber, String icd10, String omim, String synonym) {
		System.out.println("diseasematrix: v2");
		System.out.println("               url: " + url);
		System.out.println("               diseaseid: " + diseaseid);
		System.out.println("               diseasname: " + diseasname);
		System.out.println("               patientcount:  " + patientcount);
		System.out.println("               gene:  " + gene);
		System.out.println("               orphanumber:  " + orphanumber);
		System.out.println("               icd10:  " + icd10);
		System.out.println("               omim:  " + omim);
		System.out.println("               synonym:  " + synonym);
		/*
		 * Start of real code
		 */
		return updateDiseaseMatrix(0, url, diseaseid, diseasname, patientcount, gene, orphanumber, icd10, omim, synonym);
	}
	
	@JSONWebService(value = "diseasematrix", method = "POST")
	public JSONObject DiseaseMatrix(long idcardid, String diseasname, String patientcount, String gene, String orphanumber, String icd10, String omim, String synonym) {
		System.out.println("diseasematrix: v3");
		System.out.println("               idcardid: " + idcardid);
		System.out.println("               diseasname: " + diseasname);
		System.out.println("               patientcount:  " + patientcount);
		System.out.println("               gene:  " + gene);
		System.out.println("               orphanumber:  " + orphanumber);
		System.out.println("               icd10:  " + icd10);
		System.out.println("               omim:  " + omim);
		System.out.println("               synonym:  " + synonym);
		/*
		 * Start of real code
		 */
		return updateDiseaseMatrix(idcardid, "", 0, diseasname, patientcount, gene, orphanumber, icd10, omim, synonym);
	}
	
	@JSONWebService(value = "diseasematrix", method = "POST")
	public JSONObject DiseaseMatrix(String url, String diseasname, String patientcount, String gene, String orphanumber, String icd10, String omim, String synonym) {
		System.out.println("diseasematrix: v4");
		System.out.println("               url: " + url);
		System.out.println("               diseasname: " + diseasname);
		System.out.println("               patientcount:  " + patientcount);
		System.out.println("               gene:  " + gene);
		System.out.println("               orphanumber:  " + orphanumber);
		System.out.println("               icd10:  " + icd10);
		System.out.println("               omim:  " + omim);
		System.out.println("               synonym:  " + synonym);
		/*
		 * Start of real code
		 */
		return updateDiseaseMatrix(0, url, 0, diseasname, patientcount, gene, orphanumber, icd10, omim, synonym);
	}
	
	private JSONObject updateDiseaseMatrix(long idcardid, String url, long diseaseid, String diseasename, String patientcount, String gene, String orphanumber, String icd10, String omim, String synonym) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		User user = null;
		try {
			user = this.getGuestOrUser();
			// TODO: Add Logging
			//LogapiLocalServiceUtil.addLogAPI(user.getUserId(), user.getLoginIP(), "API Request getAPIVersion().");
			System.out.println("User: " + user.getUserId() + " from IP: " + user.getLoginIP() + " Username:" + user.getFullName());
		} catch (Exception e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::getAPIVersion] Error getting user data for API Logging.");
			//LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::getAPIVersion] Error getting user data for API Logging.");
			//LogapiLocalServiceUtil.addLogAPI(userid, userip, e.getLocalizedMessage());
			e.printStackTrace();
		}
		// Organization
		Organization organization = null;
		try {
			if(idcardid != 0) {
				organization = OrganizationLocalServiceUtil.getOrganization(idcardid);
			}
			if(!url.equals("") && organization == null) {
				String value = url.replaceAll("/$", "");
				List<Long> organizationIds = SearchIndexLocalServiceUtil.getOrganizationIdByKeywordAndValue("OrganizationURL", value);
				if(organizationIds.size() > 1) {
					System.err.println("More than one organization found with the same url");
				} else {
					for(long organizationid : organizationIds) {
						organization = OrganizationLocalServiceUtil.getOrganization(organizationid);
					}
				}
			}
		} catch (PortalException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(organization != null) {
			if(checkPermission(user, organization)) {
				System.out.println("Organization found with name: " + organization.getName());
				json.put("Organization", organization.getName());
				// DiseaseMatrix
				at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasmatrix = null;
				System.out.println("diseaseid: " + diseaseid);
				if(diseaseid != 0) {
					try {
						try {
							diseasmatrix = DiseaseMatrixLocalServiceUtil.getDiseaseMatrix(diseaseid);
						} catch (Exception e) {
							System.out.println("No Diseas Matrix Exists " + diseaseid);
						}
						if(diseasmatrix.getOrganizationId() == organization.getOrganizationId()) {
							diseasmatrix = updateDiseaseMatrix(diseasmatrix, diseasename, patientcount, gene, orphanumber, icd10, omim, synonym);
							json.put("DiseaseMatrix", getJsonFromDiseaseMatrix(diseasmatrix));
							return json;
						} else {
							json.put("API", "RD-Connect ID-Card API");
							json.put("ERROR", "DiseaseId not matching Organization; Organization: " + organization.getName() + "; DiseaseId" + diseaseid);
							return json;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					List<SearchIndex> searchindexs = SearchIndexLocalServiceUtil.getSearchIndexByOrganizationKeyValue(organization.getOrganizationId(), "DiseaseName", diseasename.trim());
					// Multiple matches when "diseasename-xy" and "diseasename-xy Type I"
					for(SearchIndex searchindex : searchindexs) {
						try {
							if(searchindex.getValue().equalsIgnoreCase(diseasename)) {
								diseasmatrix = DiseaseMatrixLocalServiceUtil.getDiseaseMatrix(searchindex.getLocationid());
								diseasmatrix = updateDiseaseMatrix(diseasmatrix, diseasename, patientcount, gene, orphanumber, icd10, omim, synonym);
								json.put("DiseaseMatrix", getJsonFromDiseaseMatrix(diseasmatrix));
								return json;
							}
						} catch (PortalException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SystemException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(searchindexs.size() == 0) {
						try {
							diseasmatrix = DiseaseMatrixLocalServiceUtil.createEmpltyDiseaseMatrix();
							diseasmatrix.setOrganizationId(organization.getOrganizationId());
							diseasmatrix.setDiseasename(diseasename);
							diseasmatrix.setPatientcount(patientcount);
							diseasmatrix.setGene(gene);
							diseasmatrix.setOrphanumber(orphanumber);
							diseasmatrix.setIcd10(icd10);
							diseasmatrix.setOmim(omim);
							diseasmatrix.setSynonym(synonym);
							diseasmatrix.setModifieddate(new Date());
							DiseaseMatrixLocalServiceUtil.updateDiseaseMatrix(diseasmatrix);
							json.put("DiseaseMatrix", getJsonFromDiseaseMatrix(diseasmatrix));
							return json;
						} catch (SystemException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} else {
				System.out.println("No Permission to edit Organization data for Organization: " + organization.getName() + " from User: " + user.getFullName());
				json.put("API", "RD-Connect ID-Card API");
				json.put("ERROR", "No Permission to edit Organization data for Organization: " + organization.getName() + " from User: " + user.getFullName());
				return json;
			}
		} else {
			String identifier = "URL: " + url;
			if(idcardid != 0) {
				identifier = "ID-Card ID: " + idcardid;
			}
			System.out.println("No Organization found with " + identifier);
			json.put("API", "RD-Connect ID-Card API");
			json.put("ERROR", "There was no organization found with " + identifier);
			return json;
		}
		return json;
	}
	
	private JSONObject getJsonFromDiseaseMatrix(at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasmatrix) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("DiseasematrixId", diseasmatrix.getDiseasematrixId());
		json.put("Diseasename", diseasmatrix.getDiseasename());
		json.put("Gene", diseasmatrix.getGene());
		json.put("ICD10", diseasmatrix.getIcd10());
		json.put("OMIM", diseasmatrix.getOmim());
		json.put("Orphanumber", diseasmatrix.getOrphanumber());
		json.put("Patient Count", diseasmatrix.getPatientcount());
		json.put("Synonym", diseasmatrix.getSynonym());
		return json;
	}

	private at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix updateDiseaseMatrix(at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseasmatrix, String diseasename, String patientcount, String gene, String orphanumber, String icd10, String omim, String synonym) {
		try {
			if(!diseasename.equalsIgnoreCase(diseasmatrix.getDiseasename())) {
				diseasmatrix.setDiseasename(diseasename);
			}
			if(!patientcount.equalsIgnoreCase(diseasmatrix.getPatientcount())) {
				diseasmatrix.setPatientcount(patientcount);
			}
			if(!gene.equalsIgnoreCase(diseasmatrix.getGene())) {
				diseasmatrix.setGene(gene);
			}
			if(!orphanumber.equalsIgnoreCase(diseasmatrix.getOrphanumber())) {
				diseasmatrix.setOrphanumber(orphanumber);
			}
			if(!icd10.equalsIgnoreCase(diseasmatrix.getIcd10())) {
				diseasmatrix.setIcd10(icd10);
			}
			if(!omim.equalsIgnoreCase(diseasmatrix.getOmim())) {
				diseasmatrix.setOmim(omim);
			}
			if(!synonym.equalsIgnoreCase(diseasmatrix.getSynonym())) {
				diseasmatrix.setSynonym(synonym);
			}
			diseasmatrix.setModifieddate(new Date());
			DiseaseMatrixLocalServiceUtil.updateDiseaseMatrix(diseasmatrix);
			System.out.println("Update");
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return diseasmatrix;
	}
	
	/**
	 * Check for permissions of the user, also if the user is in a network that can update the reg/bb
	 * @param user
	 * @param organization
	 * @return
	 */
	private boolean checkPermission(User user, Organization organization) {
		if(user != null && organization != null) {
			try {
				List<Long> testorganizations = new ArrayList<Long>();
				testorganizations.add(organization.getOrganizationId());
				System.out.println("Add OrganizationId: " + organization.getOrganizationId());
				List<Networks> networks = NetworksLocalServiceUtil.getOrganizationNetworkOrganizations(organization.getOrganizationId());
				System.out.println("Network Size: " + networks.size());
				for(Networks network : networks) {
					if(!testorganizations.contains(network.getOrganizationnetworkId())) {
						testorganizations.add(network.getOrganizationnetworkId());
						System.out.println("Add OrganizationId: " + network.getOrganizationnetworkId());
					}
				}
				for(long userorganizationid : user.getOrganizationIds()) {
					System.out.println("Test User OrganizationIds: " + userorganizationid);
					if(testorganizations.contains(userorganizationid)) {
						return true;
					}
				}
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
}