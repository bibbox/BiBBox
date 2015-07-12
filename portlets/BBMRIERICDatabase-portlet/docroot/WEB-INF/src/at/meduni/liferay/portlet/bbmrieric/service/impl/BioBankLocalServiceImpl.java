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

package at.meduni.liferay.portlet.bbmrieric.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import at.meduni.liferay.portlet.bbmrieric.model.BioBank;
import at.meduni.liferay.portlet.bbmrieric.model.SearchIndex;
import at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankImpl;
import at.meduni.liferay.portlet.bbmrieric.service.BioBankLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.SearchIndexLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.base.BioBankLocalServiceBaseImpl;

/**
 * The implementation of the bio bank local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.bbmrieric.service.BioBankLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.meduni.liferay.portlet.bbmrieric.service.base.BioBankLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.bbmrieric.service.BioBankLocalServiceUtil
 */
public class BioBankLocalServiceImpl extends BioBankLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.meduni.liferay.portlet.bbmrieric.service.BioBankLocalServiceUtil} to access the bio bank local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	/**
	 * 
	 */
	public List<BioBank> notUpdatedBioBank(String uuid) {
		try {
			return bioBankPersistence.findByNotUUID(uuid);
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.BioBankLocalServiceImpl::notUpdatedBioBank] Could not find BioBnaks with not having (" + uuid + ").");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public BioBank createBioBank(String ldapbiobankID) {
		try {
			BioBankImpl biobank = new BioBankImpl();
			biobank.setBiobankId(CounterLocalServiceUtil.increment(BioBank.class.getName()));
			biobank.setLdapbiobankID(ldapbiobankID);
			return biobank;
		} catch (Exception ex) {
			System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.BioBankLocalServiceImpl::createBioBank] Error creating new Biobank.");
			ex.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param ldapbiobankid
	 * @return
	 */
	public BioBank getBioBank(String ldapbiobankID) {
		try {
			return bioBankPersistence.findByLADPBiobankId(ldapbiobankID);
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.BioBankLocalServiceImpl::getBioBank] Could not get Biobank with LDAPBiobankId " + ldapbiobankID + ".");
		}
		return null;
	}
	
	/**
	 * 
	 */
	public List<BioBank> getBioBankByCountry(String country) {
		try {
			if(country.equalsIgnoreCase("")) {
				return bioBankPersistence.findAll();
			} else {
				return bioBankPersistence.findByBiobankCountry(country);
			}
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.BioBankLocalServiceImpl::getBioBankByCountry] Could not get Biobank List for Countrys " + country + ".");
		}
		return null;
	}
	
	/**
	 * 
	 */
	public String getBioBankByCountryInJavaScriptArray(String country) {
		String array = "";
		//{Name: 'Test', OrganizationLink: '/home', Type: 'Biobank', 'Number of Cases': 5, 'Data Access Committe': 'no', 'Request data':  'http://rd-connect.eu', 'Nuber of access': 0}
		try {
			List<BioBank> biobanks = null;
			if(country.equalsIgnoreCase("")) {
				biobanks = bioBankPersistence.findAll();
			} else {
				biobanks = bioBankPersistence.findByBiobankCountry(country);
			}
			String seperator = "";
			for(BioBank biobank : biobanks) {
				array += seperator + "{";
				//Country
				array += "Country: '" + biobank.getBiobankcountry().replaceAll("'", "\\\\'") + "',";
				//BB ID
				array += "'BB_ID': '" + biobank.getLdapbiobankID().replaceAll("'", "\\\\'") + "',";
				//Name
				array += "Name: '" + biobank.getBiobankname().replaceAll("'", "\\\\'") + "',";
				//Type
				array += "Type: '" + biobank.getBiobanktype().replaceAll("'", "\\\\'") + "',";
				//Size
				array += "Size: '" + biobank.getBiobanksize().replaceAll("'", "\\\\'") + "',";
				//Juristic Person
				array += "'Juristic Person': '" + biobank.getBiobankjuristicperson().replaceAll("'", "\\\\'") + "'";
				array += "}";
				seperator = ",";
			}
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.BioBankLocalServiceImpl::getBioBankByCountry] Could not get Biobank List for Countrys " + country + ".");
		}
		return array;
	}
	
	public String getBioBankFiltered(String keyword, String country, String materialtype, String diagnosisavailable, String biobanksize) {
		String array = "";
		try {
			DynamicQuery dynamicQuery = BioBankLocalServiceUtil.dynamicQuery();		
			Criterion criterion = null;
			
			if(!keyword.equalsIgnoreCase("")) {
				DynamicQuery subQuery = DynamicQueryFactoryUtil.forClass(SearchIndex.class);
				subQuery.add(PropertyFactoryUtil.forName("searchindexvalue").like("%" + keyword + "%"));
				subQuery.setProjection(ProjectionFactoryUtil.property("organisationid"));
				
				if(criterion == null) {
					criterion = PropertyFactoryUtil.forName("organisationid").in(subQuery);
				} else {
					criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("organisationid").in(subQuery));
				}
			}
			if(!country.equalsIgnoreCase("")) {
				DynamicQuery subQuery = DynamicQueryFactoryUtil.forClass(SearchIndex.class);
				subQuery.add(PropertyFactoryUtil.forName("searchindexvalue").eq(country));
				subQuery.setProjection(ProjectionFactoryUtil.property("organisationid"));
				
				if(criterion == null) {
					criterion = PropertyFactoryUtil.forName("organisationid").in(subQuery);
				} else {
					criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("organisationid").in(subQuery));
				}
			}
			if(!diagnosisavailable.equalsIgnoreCase("")) {
				DynamicQuery subQuery = DynamicQueryFactoryUtil.forClass(SearchIndex.class);
				subQuery.add(PropertyFactoryUtil.forName("searchindexvalue").eq(diagnosisavailable));
				subQuery.setProjection(ProjectionFactoryUtil.property("organisationid"));

				if(criterion == null) {
					criterion = PropertyFactoryUtil.forName("organisationid").in(subQuery);
				} else {
					criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("organisationid").in(subQuery));
				}
			}
			if(!materialtype.equalsIgnoreCase("")) {
				DynamicQuery subQuery = DynamicQueryFactoryUtil.forClass(SearchIndex.class);
				Criterion criterion_sub = RestrictionsFactoryUtil.like("searchindexkey", materialtype);
				criterion_sub = RestrictionsFactoryUtil.and(criterion_sub, RestrictionsFactoryUtil.like("searchindexvalue", "TRUE"));
				subQuery.add(criterion_sub);
				subQuery.setProjection(ProjectionFactoryUtil.property("organisationid"));
				
				if(criterion == null) {
					criterion = PropertyFactoryUtil.forName("organisationid").in(subQuery);
				} else {
					criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("organisationid").in(subQuery));
				}
			}
			if(criterion != null) {
				dynamicQuery.add(criterion);
			}
			List<BioBank> biobanks = BioBankLocalServiceUtil.dynamicQuery(dynamicQuery);
			String seperator = "";
			for(BioBank biobank : biobanks) {
				array += seperator + "{";
				//Country
				array += "Country: '" + biobank.getBiobankcountry().replaceAll("'", "\\\\'") + "',";
				//BB ID
				array += "'BB_ID': '" + biobank.getLdapbiobankID().replaceAll("'", "\\\\'") + "',";
				//Name
				array += "Name: '" + biobank.getBiobankname().replaceAll("'", "\\\\'") + "',";
				//Type
				array += "Type: '" + biobank.getBiobanktype().replaceAll("'", "\\\\'") + "',";
				//Size
				array += "Size: '" + biobank.getBiobanksize().replaceAll("'", "\\\\'") + "',";
				//Juristic Person
				array += "'Juristic Person': '" + biobank.getBiobankjuristicperson().replaceAll("'", "\\\\'") + "'";
				array += "}";
				seperator = ",";
			}
		} catch (Exception ex) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [info] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.BioBankLocalServiceImpl::getBioBankFiltered] Could not get Biobank List filtered (" + keyword + ", " + country + ", " + materialtype + ", " + diagnosisavailable + ", " + biobanksize + ").");
			ex.printStackTrace();
		}
		return array;
	}
}