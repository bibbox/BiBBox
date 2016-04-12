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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WebsiteLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;

import at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix;
import at.graz.meduni.liferay.portlet.bibbox.service.service.DiseaseMatrixLocalServiceUtil;
import at.meduni.liferay.portlet.rdconnect.NoSuchSearchIndexException;
import at.meduni.liferay.portlet.rdconnect.model.SearchIndex;
import at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateImpl;
import at.meduni.liferay.portlet.rdconnect.service.RDCOrganizationUserAccessLocalServiceUtil;
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
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	String date_format_pattern_ = "dd.MM.yyyy";
	SimpleDateFormat date_format_ = new SimpleDateFormat(date_format_pattern_);
	
	/**
	 * 
	 */
	public String getSearchIndexValueByKey(String keyword, long organizationId) {
		try {
			return searchIndexPersistence.findByValueForOrganization(organizationId, keyword).getValue();
		} catch (NoSuchSearchIndexException e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [RDConnect-portlet::at.meduni.liferay.portlet.rdconnect.service.impl.SearchIndexLocalServiceImpl::getSearchIndexValueByKey] Could not find SearchIndex (" + keyword + ", " + organizationId + ".");
			e.printStackTrace();
		} catch (SystemException e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [RDConnect-portlet::at.meduni.liferay.portlet.rdconnect.service.impl.SearchIndexLocalServiceImpl::getSearchIndexValueByKey] Error gettint value from SearchIndex for (" + keyword + ", " + organizationId + ".");
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 
	 */
	public List<Long> getOrganizationIdByKeywordAndValue(String key, String value) {
		value = value.trim();
		List<Long> returnvalue = new ArrayList<Long>();
		//System.out.println("value for search: " + value);
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SearchIndex.class);
			Criterion criterion = RestrictionsFactoryUtil.ilike("value", StringPool.PERCENT + value + StringPool.PERCENT);
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.ilike("key", key));
			dynamicQuery.add(criterion);
			Order order_organisationid = OrderFactoryUtil.asc("organisationid");
			dynamicQuery.addOrder(order_organisationid);
			List<SearchIndex> serachresults = SearchIndexLocalServiceUtil.dynamicQuery(dynamicQuery);
			for(SearchIndex serachresult : serachresults) {
				if(!returnvalue.contains(serachresult.getOrganisationid())) {
					returnvalue.add(serachresult.getOrganisationid());
				}
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnvalue;
	}
	
	/**
	 * 
	 * @param organizationId
	 * @param key
	 * @param value
	 * @return
	 */
	public List<SearchIndex> getSearchIndexByOrganizationKeyValue(long organizationId, String key, String value) {
		try {
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(SearchIndex.class);
			Criterion criterion = RestrictionsFactoryUtil.ilike("value", StringPool.PERCENT + value + StringPool.PERCENT);
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.ilike("key", key));
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("organisationid", organizationId));
			dynamicQuery.add(criterion);
			Order order_organisationid = OrderFactoryUtil.asc("organisationid");
			dynamicQuery.addOrder(order_organisationid);
			List<SearchIndex> serachresults = SearchIndexLocalServiceUtil.dynamicQuery(dynamicQuery);
			return serachresults;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Search index for normal Search
	 */
	public String getSearchIndexByKeyword(String keyword, ThemeDisplay themeDisplay, String contextpath) {
		keyword = keyword.trim();
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
				try {
				if(oldorganizationid == 0 || oldorganizationid != serachresult.getOrganisationid()) {
					if(hits != null) {
						// Generate previous entry
						searchresultstring += "<table class=\"rdc_coreinformation_organisation-table-images\">";
						searchresultstring += organizationline + maincontactline + organizationurl;
						for(String key : hits.keySet()) {
							searchresultstring += hits.get(key) + "</td></tr>";
						}
						searchresultstring += "<tr><td class=\"rdc_coreinformation_organisation-table-images-bottomborder\">&nbsp;</td><td class=\"rdc_coreinformation_organisation-table-images-bottomborder\">&nbsp;</td></tr>";
						searchresultstring += "</table><br />";
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
									highlightResult(serachresult.getKey(), keyword) + ": " + highlightResult(serachresult.getValue(), keyword));
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
									highlightResult(serachresult.getKey(), keyword) + ": " + highlightResult(serachresult.getValue(), keyword));
						} else {
							hits.put(serachresult.getLocation() + serachresult.getLocationid(), "<tr><td>" + serachresult.getLocation() + "</td><td>" + 
									highlightResult(serachresult.getKey(), keyword) + ": " + highlightResult(serachresult.getValue(), keyword));
						}
					}
				}
				} catch (Exception ex) {
					//TODO add msg
					System.err.println("TODO add msg");
					ex.printStackTrace();
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
			searchresultstring = "<h4>Search returned " + serachresults.size() + " hits (Registries:" + regcount + " /Biobanks:" + bbcount + ")</h4><br /><br />" + searchresultstring;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(searchresultstring.length() == 0) {
			searchresultstring = "No Results for the query.";
		}
		return searchresultstring;
	}
	
	/**
	 * Search Higlight
	 * 
	 * @param text
	 * @param keyword
	 * @return
	 */
	private String highlightResult(String text, String keyword) {
		if(keyword.equalsIgnoreCase("")) {
			return text;
		}
		if(text.toLowerCase().contains(keyword.toLowerCase())) {
			int beginindex = text.toLowerCase().indexOf(keyword.toLowerCase());
			int endindex = beginindex + keyword.length();
			int counter = 0;
			while (beginindex >= 0) {
				if(counter > 15) {
					System.out.println("!!!!!!!Problem with Search keyword: '" + keyword + "'");
					return text;
				}
				//System.out.println("Hit" + beginindex);
				endindex = beginindex + keyword.length();
				text = text.substring(0, beginindex) + "<span style=\"background-color: yellow;\">" + text.substring(beginindex, endindex) + "</span>" + text.substring(endindex);
				//System.out.println(text + " " + endindex);
				beginindex = text.indexOf(keyword, endindex+46);
				counter++;
			}
		}
		return text;
	}
	
	/**
	 * Search for Reporting system for general user
	 * 
	 * @param keyword
	 * @param type
	 * @return
	 */
	public String getSearchIndexByKeyword(String keyword, String type, ThemeDisplay themeDisplay, String contextpath, long maincontactrole) {
		keyword = keyword.trim();
		type = type.trim();
		String searchresultstring = "";
		try {
			DynamicQuery dynamicQuery = null;
			if(type.equalsIgnoreCase("all")) {
				dynamicQuery = DynamicQueryFactoryUtil.forClass(SearchIndex.class);
				Criterion criterion = RestrictionsFactoryUtil.ilike("value", StringPool.PERCENT + keyword + StringPool.PERCENT);
				//if(!type.equalsIgnoreCase("all")) {
					//Criterion criterion_type = RestrictionsFactoryUtil.ilike("value", type);
					//criterion_type = RestrictionsFactoryUtil.and(criterion_type, RestrictionsFactoryUtil.ilike("key", StringPool.PERCENT + "Type" + StringPool.PERCENT));
					//criterion = RestrictionsFactoryUtil.and(criterion, criterion_type);
				
				dynamicQuery.add(criterion);
			} else {
				DynamicQuery subQuery = DynamicQueryFactoryUtil.forClass(SearchIndex.class)
						.add(PropertyFactoryUtil.forName("value").eq(type));
				subQuery.setProjection(ProjectionFactoryUtil.property("organisationid"));

				dynamicQuery  = DynamicQueryFactoryUtil.forClass(SearchIndex.class)
						.add(PropertyFactoryUtil.forName("value").like(StringPool.PERCENT + keyword + StringPool.PERCENT))
						.add(PropertyFactoryUtil.forName("organisationid").in(subQuery));
			}
			
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
			boolean first = true;
			for(SearchIndex serachresult : serachresults) {
				try {
					if(oldorganizationid == 0 || oldorganizationid != serachresult.getOrganisationid()) {
						if(!first) {
							searchresultstring += ",";
						}
						first = false;
						organization = OrganizationLocalServiceUtil.getOrganization(serachresult.getOrganisationid());
						// Disease Matrix
						List<DiseaseMatrix> diseasematrixes = DiseaseMatrixLocalServiceUtil.getDiseaseMatrixs(organization.getOrganizationId(), -1, -1);
						long diseascount = 0;
						Date tmp_lastupdated = null;
						for(DiseaseMatrix diseasematrix : diseasematrixes) {
							try {
								if(tmp_lastupdated == null) {
									tmp_lastupdated =diseasematrix.getModifieddate();
								}
								if(tmp_lastupdated.before(diseasematrix.getModifieddate())) {
									tmp_lastupdated =diseasematrix.getModifieddate();
								}
								
								diseascount += Long.parseLong(diseasematrix.getPatientcount());
							} catch(Exception ex) {
								
							}
						}
						String lastupdated = "";
						if(tmp_lastupdated != null) {
							lastupdated = date_format_.format(tmp_lastupdated);
						}
						// Data Access Committee
						String dataaccess = "not specified";
						List<DDLRecordSet> rdc_recordlist = DDLRecordSetLocalServiceUtil.getRecordSets(organization.getGroupId());
					  	for(DDLRecordSet rdc_rs : rdc_recordlist) {
					  		String rdc_rsname = String.valueOf(rdc_rs.getNameCurrentValue());
					  		 if(rdc_rsname.equals("reg_accessibility")) {
					  			List<DDLRecord> records = rdc_rs.getRecords();
					  			for(DDLRecord record : records) { 
					  				try {
					  					dataaccess = record.getFieldValue("Has_the_registry_a_Data_Access_Committee_").toString().replaceAll("\"\\]|\\[\"", "");
					  				} catch (Exception ex) {
					  					
					  				}
					  			}
					  		 }
					  	}
					  	String organizationtype = organization.getExpandoBridge().getAttribute("Organization Type").toString();
					  	String orgPath = themeDisplay.getURLPortal()+"/web"+organization.getGroup().getFriendlyURL();
					  	String imgPath = themeDisplay.getPathImage()+"/layout_set_logo?img_id="+organization.getLogoId();
					  	int numberofacces = RDCOrganizationUserAccessLocalServiceUtil.countRDCOrganizationUserAccess(organization.getOrganizationId());
						if(organizationtype.equalsIgnoreCase("Biobank")) {
							if(organization.getLogoId() == 0) {
					 			imgPath = "/BiBBoxCommonServices-portlet/images/Biobank.png";
					 		}
							orgPath = orgPath + "/bb_home";	
						} else {
							if(organization.getLogoId() == 0) {
					 			imgPath = "/BiBBoxCommonServices-portlet/images/Registry.png";
					 		}
							orgPath = orgPath + "/reg_home";
						} 
						String maincontactmail = "";
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
							maincontactmail = maincontact.getEmailAddress();
						}
						searchresultstring += "{Name: '" + organization.getName().replaceAll("'", "&lsquo;") + "', "
								+ "OrganizationLink: '" + orgPath + "',"
								+ "OrganizationImageLink: '" + imgPath + "',"
								+ "Type: '" + organization.getExpandoBridge().getAttribute("Organization Type").toString() + "',"
								+ "'NumberofCases': " + diseascount + ","
								+ "'Data Access Committe': '" + dataaccess + "',"
								+ "'Request data':  '" + maincontactmail + "', "
								+ "'lastupdated':  '" + lastupdated + "', "
								+ "'Number of access': " + numberofacces + "}";
						// New Hit
						oldorganizationid = serachresult.getOrganisationid();
					}	
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(searchresultstring.length() == 0) {
			searchresultstring = "No Results for the query.";
		}
		return searchresultstring;
	}
	
	/**
	 * Create User Statistics
	 * @return
	 */
	public String getUserStatistiks() {
		String date = "";
		String count = "";
		try {
			Connection connection = connectDatabase();
			String sql_grouped = "SELECT DATE(lastaccess), COUNT(*) FROM rdconnect.rdcorganizationuseraccess GROUP BY DATE(lastaccess) ORDER BY DATE(lastaccess);";
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(sql_grouped);
			String prefix = "";
			while(resultset.next()) {
				String date_convert = resultset.getString("date");
				date += prefix + "\"" + date_convert + "\"";
				count += prefix + resultset.getString("count");
				prefix = ",";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		String return_value = date + "§§split§§" + count;
		return return_value;
	}
	
	/**
	 * Connect to the liferay Database
	 * @return sql Connection
	 */
	private Connection connectDatabase() {

		try { 
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
			return null;
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(PropsUtil.get("jdbc.default.url"), PropsUtil.get("jdbc.default.username"),PropsUtil.get("jdbc.default.password"));
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
 
		if (connection != null) {
			System.out.println("Connected to database");
		} else {
			System.out.println("Failed to make connection!");
		}
		return connection;
	}
}