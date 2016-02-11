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
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.model.Website;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WebsiteLocalServiceUtil;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;

import at.graz.meduni.liferay.portlet.bibbox.service.OrganizationSearchIndexLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix;
import at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.service.LogapiLocalServiceUtil;
import at.graz.meduni.liferay.portlet.bibbox.service.service.base.LogapiServiceBaseImpl;

/**
 * The implementation of the logapi remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.liferay.portlet.bibbox.service.service.LogapiService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.base.LogapiServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.LogapiServiceUtil
 */
public class LogapiServiceImpl extends LogapiServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.service.LogapiServiceUtil} to access the logapi remote service.
	 */
	
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 * @return
	 */
	@AccessControlled(guestAccessEnabled=true)
	@JSONWebService(value = "getapiversion", method = "GET")
	public JSONObject getAPIVersion() {
		long userid = 0;
		String userip = "";
		try {
			User user = this.getGuestOrUser();
			userid = user.getUserId();
			userip = user.getLoginIP();
			LogapiLocalServiceUtil.addLogAPI(user.getUserId(), user.getLoginIP(), "API Request getAPIVersion().");
		} catch (Exception e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::getAPIVersion] Error getting user data for API Logging.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::getAPIVersion] Error getting user data for API Logging.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, e.getLocalizedMessage());
			e.printStackTrace();
		}
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("API", "RD-Connect API");
		json.put("Version", "1.0");
		return json;
	}
	
	/**
	 * 
	 * @return
	 */
	@AccessControlled(guestAccessEnabled=true)
	@JSONWebService(value = "regbbs", method = "POST")
	public JSONArray regbbs(String data) {
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		try {
			JSONArray array = JSONFactoryUtil.createJSONArray(data);
			for(int arrayindex = 0; arrayindex < array.length(); arrayindex++) {
				jsonarray.put(regbb(array.getLong(arrayindex)));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return jsonarray;
	}
	
	/**
	 * 
	 * @return
	 */
	@AccessControlled(guestAccessEnabled=true)
	@JSONWebService(value = "regbbs", method = "GET")
	public JSONArray regbbs() {
		long userid = 0;
		String userip = "";
		try {
			User user = this.getGuestOrUser();
			userid = user.getUserId();
			userip = user.getLoginIP();
			LogapiLocalServiceUtil.addLogAPI(user.getUserId(), user.getLoginIP(), "API Request getAPIVersion().");
		} catch (Exception e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting user data for API Logging.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting user data for API Logging.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, e.getLocalizedMessage());
			e.printStackTrace();
		}
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		try {
			String parentid_string = PropsUtil.get("rdconnectcatalougeid");
			long parentid = Long.parseLong(parentid_string);
			List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(CompanyThreadLocal.getCompanyId(), parentid);
			for(Organization organization : organizations) {
				try {
					String type = "reg/bb";
					try {
						type = OrganizationSearchIndexLocalServiceUtil.getSearchIndexValueByKey("Type", organization.getOrganizationId()).toLowerCase();
					} catch (Exception ex) {
						System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting Expando Brige for Organization.");
						LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting Expando Brige for Organization.");
						LogapiLocalServiceUtil.addLogAPI(userid, userip, ex.getLocalizedMessage());
						ex.printStackTrace();
					}
					
					JSONObject json = JSONFactoryUtil.createJSONObject();
					json.put("ID", "http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/" + organization.getOrganizationId());
					json.put("OrganizationID", organization.getOrganizationId());
					json.put("name", organization.getName());
					json.put("type", type);
					JSONArray json_collection_array = JSONFactoryUtil.createJSONArray();
					JSONObject json_default_collection = JSONFactoryUtil.createJSONObject();
					json_default_collection.put("CollectionID", "http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/" + organization.getOrganizationId() + "/collection-id/" + 1);
					json_default_collection.put("CollectionName", "default");
					json_collection_array.put(json_default_collection);
					json.put("Collections", json_collection_array);
					jsonarray.put(json);
				} catch (Exception e) {
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error adding element to list of Biobanks and Registries.");
					LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error adding element to list of Biobanks and Registries.");
					LogapiLocalServiceUtil.addLogAPI(userid, userip, e.getLocalizedMessage());
					e.printStackTrace();
				}
			}
		} catch (SystemException e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error creating list of Biobanks and Registries.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error creating list of Biobanks and Registries.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, e.getLocalizedMessage());
			e.printStackTrace();
		}
		return jsonarray;
	}
	
	/**
	 * 
	 * @return
	 */
	@AccessControlled(guestAccessEnabled=true)
	@JSONWebService(value = "regs", method = "GET")
	public JSONArray regs() {
		long userid = 0;
		String userip = "";
		try {
			User user = this.getGuestOrUser();
			userid = user.getUserId();
			userip = user.getLoginIP();
			LogapiLocalServiceUtil.addLogAPI(user.getUserId(), user.getLoginIP(), "API Request getAPIVersion().");
		} catch (Exception e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting user data for API Logging.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting user data for API Logging.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, e.getLocalizedMessage());
			e.printStackTrace();
		}
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		try {
			String parentid_string = PropsUtil.get("rdconnectcatalougeid");
			long parentid = Long.parseLong(parentid_string);
			List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(CompanyThreadLocal.getCompanyId(), parentid);
			for(Organization organization : organizations) {
				try {
					String type = "reg/bb";
					try {
						type = OrganizationSearchIndexLocalServiceUtil.getSearchIndexValueByKey("Type", organization.getOrganizationId()).toLowerCase();
					} catch (Exception ex) {
						System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting Expando Brige for Organization.");
						LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting Expando Brige for Organization.");
						LogapiLocalServiceUtil.addLogAPI(userid, userip, ex.getLocalizedMessage());
						ex.printStackTrace();
					}
					if(!type.equalsIgnoreCase("registry")) {
						continue;
					}
					JSONObject json = JSONFactoryUtil.createJSONObject();
					json.put("ID", "http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/" + organization.getOrganizationId());
					json.put("OrganizationID", organization.getOrganizationId());
					json.put("name", organization.getName());
					json.put("type", type);
					JSONArray json_collection_array = JSONFactoryUtil.createJSONArray();
					JSONObject json_default_collection = JSONFactoryUtil.createJSONObject();
					json_default_collection.put("CollectionID", "http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/" + organization.getOrganizationId() + "/collection-id/" + 1);
					json_default_collection.put("CollectionName", "default");
					json_collection_array.put(json_default_collection);
					json.put("Collections", json_collection_array);
					jsonarray.put(json);
				} catch (Exception e) {
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regs] Error adding element to list of Registries.");
					LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regs] Error adding element to list of Registries.");
					LogapiLocalServiceUtil.addLogAPI(userid, userip, e.getLocalizedMessage());
					e.printStackTrace();
				}
			}
		} catch (SystemException e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regs] Error creating list of Registries.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regs] Error creating list of Registries.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, e.getLocalizedMessage());
			e.printStackTrace();
		}
		return jsonarray;
	}
	
	/**
	 * 
	 * @return
	 */
	@AccessControlled(guestAccessEnabled=true)
	@JSONWebService(value = "bbs", method = "GET")
	public JSONArray bbs() {
		long userid = 0;
		String userip = "";
		try {
			User user = this.getGuestOrUser();
			userid = user.getUserId();
			userip = user.getLoginIP();
			LogapiLocalServiceUtil.addLogAPI(user.getUserId(), user.getLoginIP(), "API Request getAPIVersion().");
		} catch (Exception e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting user data for API Logging.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting user data for API Logging.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, e.getLocalizedMessage());
			e.printStackTrace();
		}
		JSONArray jsonarray = JSONFactoryUtil.createJSONArray();
		try {
			String parentid_string = PropsUtil.get("rdconnectcatalougeid");
			long parentid = Long.parseLong(parentid_string);
			List<Organization> organizations = OrganizationLocalServiceUtil.getOrganizations(CompanyThreadLocal.getCompanyId(), parentid);
			for(Organization organization : organizations) {
				try {
					String type = "reg/bb";
					try {
						type = OrganizationSearchIndexLocalServiceUtil.getSearchIndexValueByKey("Type", organization.getOrganizationId()).toLowerCase();
					} catch (Exception ex) {
						System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting Expando Brige for Organization.");
						LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting Expando Brige for Organization.");
						LogapiLocalServiceUtil.addLogAPI(userid, userip, ex.getLocalizedMessage());
						ex.printStackTrace();
					}
					if(!type.equalsIgnoreCase("biobank")) {
						continue;
					}
					JSONObject json = JSONFactoryUtil.createJSONObject();
					json.put("ID", "http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/" + organization.getOrganizationId());
					json.put("OrganizationID", organization.getOrganizationId());
					json.put("name", organization.getName());
					json.put("type", type);
					JSONArray json_collection_array = JSONFactoryUtil.createJSONArray();
					JSONObject json_default_collection = JSONFactoryUtil.createJSONObject();
					json_default_collection.put("CollectionID", "http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/" + organization.getOrganizationId() + "/collection-id/" + 1);
					json_default_collection.put("CollectionName", "default");
					json_collection_array.put(json_default_collection);
					json.put("Collections", json_collection_array);
					jsonarray.put(json);
				} catch (Exception e) {
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::bbs] Error adding element to list of Biobanks.");
					LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::bbs] Error adding element to list of Biobanks.");
					LogapiLocalServiceUtil.addLogAPI(userid, userip, e.getLocalizedMessage());
					e.printStackTrace();
				}
			}
		} catch (SystemException e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::bbs] Error creating list of Biobanks.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::bbs] Error creating list of Biobanks.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, e.getLocalizedMessage());
			e.printStackTrace();
		}
		return jsonarray;
	}
	
	/**
	 * 
	 * @param organizationId
	 * @return
	 */
	@AccessControlled(guestAccessEnabled=true)
	@JSONWebService(value = "regbb", method = "GET")
	public JSONObject regbb(long organizationId) {
		long userid = 0;
		String userip = "";
		try {
			User user = this.getGuestOrUser();
			userid = user.getUserId();
			userip = user.getLoginIP();
			LogapiLocalServiceUtil.addLogAPI(user.getUserId(), user.getLoginIP(), "API Request getAPIVersion().");
		} catch (Exception e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting user data for API Logging.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting user data for API Logging.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, e.getLocalizedMessage());
			e.printStackTrace();
		}
		JSONObject json = JSONFactoryUtil.createJSONObject();
		long maincontactrole = Long.parseLong(PropsUtil.get("rdconnectmaincontactid"));
		try {
			Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
			String type = "reg/bb";
			try {
				type = OrganizationSearchIndexLocalServiceUtil.getSearchIndexValueByKey("Type", organization.getOrganizationId()).toLowerCase();
			} catch (Exception ex) {
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting Expando Brige for Organization.");
				LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting Expando Brige for Organization.");
				LogapiLocalServiceUtil.addLogAPI(userid, userip, ex.getLocalizedMessage());
				ex.printStackTrace();
			}
			json.put("ID", "http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/" + organization.getOrganizationId());
			json.put("OrganizationID", organization.getOrganizationId());
			json.put("name", organization.getName());
			json.put("date of inclusion", organization.getCreateDate());
			json.put("last activities", organization.getModifiedDate());
			JSONObject json_address = JSONFactoryUtil.createJSONObject();
			json_address.put("name of host institution", organization.getAddress().getStreet1());
			json_address.put("street1", organization.getAddress().getStreet2());
			json_address.put("street2", organization.getAddress().getStreet3());
			json_address.put("zip", organization.getAddress().getZip());
			json_address.put("city", organization.getAddress().getCity());

			json_address.put("country", LogapiLocalServiceUtil.getCountryNameByOrganizationId(organization.getOrganizationId()));
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
		  	JSONArray json_collection_array = JSONFactoryUtil.createJSONArray();
			JSONObject json_default_collection = JSONFactoryUtil.createJSONObject();
			json_default_collection.put("CollectionID", "http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/" + organization.getOrganizationId() + "/collection-id/" + 1);
			json_default_collection.put("CollectionName", "default");
			json_collection_array.put(json_default_collection);
			json.put("Collections", json_collection_array);
		  	/*
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
			json.put("diseases", json_diseases_array);*/
		} catch (Exception e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbb] Error getting data for organization with organizationId (" + organizationId + ").");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbb] Error getting data for organization with organizationId (" + organizationId + ").");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, e.getLocalizedMessage());
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * 
	 * @param organizationId
	 * @return
	 */
	@AccessControlled(guestAccessEnabled=true)
	@JSONWebService(value = "regbb", method = "GET")
	public JSONObject regbb(long organizationId, long collectionId) {
		long userid = 0;
		String userip = "";
		try {
			User user = this.getGuestOrUser();
			userid = user.getUserId();
			userip = user.getLoginIP();
			LogapiLocalServiceUtil.addLogAPI(user.getUserId(), user.getLoginIP(), "API Request getAPIVersion().");
		} catch (Exception e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting user data for API Logging.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting user data for API Logging.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, e.getLocalizedMessage());
			e.printStackTrace();
		}
		JSONObject json = JSONFactoryUtil.createJSONObject();
		if(collectionId != 1) {
			json.put("Error", "No Collection with the ID " + collectionId + " found.");
		} else {
			try {
				Organization organization = OrganizationLocalServiceUtil.getOrganization(organizationId);
				String type = "reg/bb";
				try {
					type = OrganizationSearchIndexLocalServiceUtil.getSearchIndexValueByKey("Type", organization.getOrganizationId()).toLowerCase();
				} catch (Exception ex) {
					System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting Expando Brige for Organization.");
					LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbbs] Error getting Expando Brige for Organization.");
					LogapiLocalServiceUtil.addLogAPI(userid, userip, ex.getLocalizedMessage());
					ex.printStackTrace();
				}
				json.put("ID", "http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/" + organization.getOrganizationId());
				json.put("OrganizationID", organization.getOrganizationId());
				json.put("name", organization.getName());
				json.put("CollectionID", "http://catalogue.rd-connect.eu/apiv1/regbb/organization-id/" + organization.getOrganizationId() + "/collection-id/" + 1);
				json.put("CollectionName", "default");
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
				System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbb] Error getting data for organization with organizationId (" + organizationId + ").");
				LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbb] Error getting data for organization with organizationId (" + organizationId + ").");
				LogapiLocalServiceUtil.addLogAPI(userid, userip, e.getLocalizedMessage());
				e.printStackTrace();
			}
		}
		return json;
	}
	
	@AccessControlled(guestAccessEnabled=true)
	@JSONWebService(value = "regbb", method = "GET")
	public JSONObject regbb(String id) {
		long userid = 0;
		String userip = "";
		try {
			User user = this.getGuestOrUser();
			userid = user.getUserId();
			userip = user.getLoginIP();
			LogapiLocalServiceUtil.addLogAPI(user.getUserId(), user.getLoginIP(), "API Request getAPIVersion().");
		} catch (Exception e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbb] Error getting user data for API Logging.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbb] Error getting user data for API Logging.");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, e.getLocalizedMessage());
			e.printStackTrace();
		}
		try {
			System.out.println(id);
			Matcher m = r.matcher(id);
			if (m.find( )) {
				long organizationid = Long.parseLong(m.group(1));
				if(m.group(2) != null) {
					long collectionid = Long.parseLong(m.group(3));
					return regbb(organizationid, collectionid);
				} else {
					return regbb(organizationid);
				}
			}
		} catch (Exception e) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbb] Error getting data for organization with organizationId (" + id + ").");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, "[" + date_format_apache_error.format(new Date()) + "] [error] [BiBBoxCommonServices-portlet::at.graz.meduni.liferay.portlet.bibbox.service.service.impl.LogapiServiceImpl::regbb] Error getting data for organization with organizationId (" + id + ").");
			LogapiLocalServiceUtil.addLogAPI(userid, userip, e.getLocalizedMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	@AccessControlled(guestAccessEnabled=true)
	@JSONWebService(value = "testmethode", method = "POST")
	public void testMethode(String jason) {
		System.out.println(jason);
	}
	
	//---------------------------
	// Test
	
	@JSONWebService(value = "resttest01", method = "POST")
	public void resttest01(long organizationId) {
		System.out.println("resttest01: (organizationId = " + organizationId + ")");
	}
	
	@JSONWebService(value = "resttest02", method = "POST")
	public void resttest02(String text) {
		System.out.println("resttest02: (text = " + text + ")");
	}
	
	@JSONWebService(value = "resttest03", method = "POST")
	public void resttest03(long[] array) {
		System.out.println("resttest03: (array = " + array.length + ")");
		for(long abc : array) {
			System.out.println("            value: " + abc);
		}
	}
	
	@JSONWebService(value = "resttest04", method = "POST")
	public void resttest04(String[] array) {
		System.out.println("resttest04: (array = " + array.length + ")");
		for(String abc : array) {
			System.out.println("            value: " + abc);
		}
	}
	
	@JSONWebService(value = "resttest05", method = "POST")
	public void resttest05(String url, User user) {
		System.out.println("resttest05: (array = " + url + ")");
		System.out.println("            firstname: " + user.getFirstName());
		System.out.println("            lastname:  " + user.getLastName());
	}
	
	@JSONWebService(value = "resttest06", method = "POST")
	public void resttest06(String url, String diseasname, String patientcount, String gene, String orphanumber, String icd10, String omim, String synonym) {
		System.out.println("resttest06: url: " + url);
		System.out.println("            diseasname: " + diseasname);
		System.out.println("            patientcount:  " + patientcount);
		System.out.println("            gene:  " + gene);
		System.out.println("            orphanumber:  " + orphanumber);
		System.out.println("            icd10:  " + icd10);
		System.out.println("            omim:  " + omim);
		System.out.println("            synonym:  " + synonym);
	}
	
	@JSONWebService(value = "/resttest07", method = "POST")
	public void resttest07(String url, String diseasname, String patientcount, String gene, String orphanumber, String icd10, String omim, String synonym) {
		System.out.println("resttest07: url: " + url);
		System.out.println("            diseasname: " + diseasname);
		System.out.println("            patientcount:  " + patientcount);
		System.out.println("            gene:  " + gene);
		System.out.println("            orphanumber:  " + orphanumber);
		System.out.println("            icd10:  " + icd10);
		System.out.println("            omim:  " + omim);
		System.out.println("            synonym:  " + synonym);
	}
	
	// Test
	//---------------------------
	
	
	String pattern = "http%3A%2F%2Fcatalogue.rd-connect.eu%2Fid%2Forganization-id%2F(\\d+)(%2Fcollection-id%2F)?(\\d+)?";
	Pattern r = Pattern.compile(pattern);
}