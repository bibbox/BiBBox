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

package at.graz.meduni.liferay.api.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.model.Website;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WebsiteLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;

import at.graz.meduni.liferay.api.model.rdconnect;
import at.graz.meduni.liferay.api.service.rdconnectLocalServiceUtil;
import at.graz.meduni.liferay.api.service.base.rdconnectServiceBaseImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix;
import at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixLocalServiceUtil;

/**
 * The implementation of the rdconnect remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.api.service.rdconnectService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.api.service.base.rdconnectServiceBaseImpl
 * @see at.graz.meduni.liferay.api.service.rdconnectServiceUtil
 */
public class rdconnectServiceImpl extends rdconnectServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.api.service.rdconnectServiceUtil} to access the rdconnect remote service.
	 */
	public rdconnect getRdconnect() throws PortalException, SystemException {
		return rdconnectLocalServiceUtil.getrdconnect(1);
	}
	
	/**
	 * 
	 */
	public JSONObject regbb(long organizationId) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		long maincontactrole = Long.parseLong(PropsUtil.get("rdconnectmaincontactid"));
		try {
			Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
			String type = organization.getExpandoBridge().getAttribute("Organization Type").toString().toLowerCase();
			json.put("ID", organization.getOrganizationId());
			json.put("name", organization.getName());
			json.put("date of inclusion", organization.getCreateDate());
			json.put("last activities", organization.getModifiedDate());
			JSONObject json_address = JSONFactoryUtil.createJSONObject();
			json_address.put("name of host institution", organization.getAddress().getStreet1());
			json_address.put("street1", organization.getAddress().getStreet2());
			json_address.put("street2", organization.getAddress().getStreet3());
			json_address.put("zip", organization.getAddress().getZip());
			json_address.put("city", organization.getAddress().getCity());
			json_address.put("country", organization.getAddress().getCountry().getNameCurrentValue());
			json.put("address", json_address);
			json.put("type", type);
			List<Website> websites = WebsiteLocalServiceUtil.getWebsites(organization.getCompanyId(), Organization.class.getName(), organization.getOrganizationId());
			JSONArray json_url_array = JSONFactoryUtil.createJSONArray();
			for(Website website : websites) {
				json_url_array.put(website.getUrl());
			}
			json.put("url", json_url_array);
			JSONObject json_main_contact = JSONFactoryUtil.createJSONObject();
			List<User> userlist = UserLocalServiceUtil.getOrganizationUsers(organizationId);
			for(User user_mc : userlist) {
				List<UserGroupRole> usergrouprolles = UserGroupRoleLocalServiceUtil.getUserGroupRoles(user_mc.getUserId(), organization.getGroup().getGroupId());
				for (UserGroupRole ugr : usergrouprolles) {
					if(ugr.getRoleId() == maincontactrole) {
						json_main_contact.put("title", user_mc.getGreeting());
						json_main_contact.put("first name", user_mc.getFirstName());
						json_main_contact.put("last name", user_mc.getLastName());
						List<Phone> phones = user_mc.getPhones();
						for(Phone phone: phones) {
							if(phone.isPrimary()) {
								json_main_contact.put("phone", phone.getNumber() + "" + phone.getExtension());
							}
						}
						json_main_contact.put("email", user_mc.getEmailAddress());
					}
				}
			}
			json.put("main contact", json_main_contact);
			// TODO
			String ddlname = "default";
			if(type.equalsIgnoreCase("biobank")) {
				ddlname = "bb_core";
			} else {
				ddlname = "core";
			}
			List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
		  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
		  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
		  		if(rdc_rsname.equalsIgnoreCase(ddlname)) {
		  			List<DDLRecord> records = rdc_rs.getRecords();
		  			for(DDLRecord record : records) {
		  				String type_of_host_institution = "";
		  				String target_population = "";
		  				JSONArray json_also_listed_in_array = JSONFactoryUtil.createJSONArray();
		  				if(record.getField("Host_institution_is_a") != null) {
		  					type_of_host_institution = record.getField("Host_institution_is_a").getValue().toString().replaceAll("\"\\]|\\[\"", "");
		  				}
		  				if(record.getField("Target_population_of_the_registry") != null) {
		  					target_population = record.getField("Target_population_of_the_registry").getValue().toString().replaceAll("\"\\]|\\[\"", "");
		  				}
		  				if(record.getField("The_registry_biobanks_is_listed_in_other_inventories_networks") != null) {
		  					String[] also_listed_in = record.getField("The_registry_biobanks_is_listed_in_other_inventories_networks").getValue().toString().replaceAll("\"\\]|\\[\"", "").split("\",\"");
		  					for(String also_listed_initems : also_listed_in) {
		  						if(also_listed_initems.equalsIgnoreCase("not specified")) {
		  							continue;
		  						}
		  						json_also_listed_in_array.put(also_listed_initems);
		  					}
		  				}
		  				
		  				json.put("type of host institution", type_of_host_institution);
		  				json.put("target population", target_population);
		  				json.put("also listed in", json_also_listed_in_array);
		  				
		  			}
		  		}
		  	}
			JSONArray json_diseases_array = JSONFactoryUtil.createJSONArray();
			List<DiseaseMatrix> diseasematrixs = DiseaseMatrixLocalServiceUtil.getDiseaseMatrixs(organizationId, -1, -1);
			for(DiseaseMatrix diseasematrix : diseasematrixs) {
				JSONObject json_disease_matrix = JSONFactoryUtil.createJSONObject();
				json_disease_matrix.put("name", diseasematrix.getDiseasename());
				json_disease_matrix.put("number", diseasematrix.getPatientcount());
				json_disease_matrix.put("gene", diseasematrix.getGene());
				json_disease_matrix.put("orphacode", diseasematrix.getOrphanumber());
				json_disease_matrix.put("icd10", diseasematrix.getIcd10());
				json_disease_matrix.put("omim", diseasematrix.getOmim());
				json_disease_matrix.put("synonym", diseasematrix.getSynonym());
				json_diseases_array.put(json_disease_matrix);
			}
			json.put("diseases", json_diseases_array);
		} catch (Exception e) {
			System.out.println("ERROR: rdconnectServiceImpl::regbb(long organizationId)");
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * 
	 */
	public JSONArray regbbs() {
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		try {
			String parentid_string = PropsUtil.get("rdconnectcatalougeid");
			long parentid = Long.parseLong(parentid_string);
			List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(CompanyThreadLocal.getCompanyId(), parentid);
			for(Organization organization : organizations) {
				String type = organization.getExpandoBridge().getAttribute("Organization Type").toString().toLowerCase();
				JSONObject json = JSONFactoryUtil.createJSONObject();
				json.put("ID", organization.getOrganizationId());
				json.put("name", organization.getName());
				json.put("type", type);
				jsonarray.put(json);
			}
		} catch (SystemException e) {
			System.out.println("ERROR: rdconnectServiceImpl::regbbs()");
			e.printStackTrace();
		}
		return jsonarray;
	}
	
	/**
	 * 
	 * @return
	 */
	public JSONArray regs() {
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		try {
			String parentid_string = PropsUtil.get("rdconnectcatalougeid");
			long parentid = Long.parseLong(parentid_string);
			List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(CompanyThreadLocal.getCompanyId(), parentid);
			for(Organization organization : organizations) {
				String type = organization.getExpandoBridge().getAttribute("Organization Type").toString().toLowerCase();
				if(!type.equalsIgnoreCase("registry")) {
					continue;
				}
				JSONObject json = JSONFactoryUtil.createJSONObject();
				json.put("ID", organization.getOrganizationId());
				json.put("name", organization.getName());
				json.put("type", type);
				jsonarray.put(json);
			}
		} catch (SystemException e) {
			System.out.println("ERROR: rdconnectServiceImpl::regbbs()");
			e.printStackTrace();
		}
		return jsonarray;
	}
	
	/**
	 * 
	 * @return
	 */
	public JSONArray bbs() {
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		try {
			String parentid_string = PropsUtil.get("rdconnectcatalougeid");
			long parentid = Long.parseLong(parentid_string);
			List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(CompanyThreadLocal.getCompanyId(), parentid);
			for(Organization organization : organizations) {
				String type = organization.getExpandoBridge().getAttribute("Organization Type").toString().toLowerCase();
				if(!type.equalsIgnoreCase("biobank")) {
					continue;
				}
				JSONObject json = JSONFactoryUtil.createJSONObject();
				json.put("ID", organization.getOrganizationId());
				json.put("name", organization.getName());
				json.put("type", type);
				jsonarray.put(json);
			}
		} catch (SystemException e) {
			System.out.println("ERROR: rdconnectServiceImpl::regbbs()");
			e.printStackTrace();
		}
		return jsonarray;
	}
}