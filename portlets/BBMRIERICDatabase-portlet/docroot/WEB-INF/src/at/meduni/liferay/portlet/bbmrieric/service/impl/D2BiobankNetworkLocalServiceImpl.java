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

import javax.naming.directory.Attributes;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

import at.meduni.liferay.portlet.bbmrieric.model.D2Biobank;
import at.meduni.liferay.portlet.bbmrieric.model.D2BiobankNetwork;
import at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankNetworkImpl;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankNetworkLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.base.D2BiobankNetworkLocalServiceBaseImpl;
import at.meduni.liferay.portlet.bbmrieric.util.LDAPAttributeEscaper;

/**
 * The implementation of the d2 biobank network local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.bbmrieric.service.D2BiobankNetworkLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.meduni.liferay.portlet.bbmrieric.service.base.D2BiobankNetworkLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.bbmrieric.service.D2BiobankNetworkLocalServiceUtil
 */
public class D2BiobankNetworkLocalServiceImpl
	extends D2BiobankNetworkLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.meduni.liferay.portlet.bbmrieric.service.D2BiobankNetworkLocalServiceUtil} to access the d2 biobank network local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	String classname_ = "BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.D2BiobankNetworkLocalServiceImpl";
	
	/**
	 * 
	 * @param biobanknetwork
	 * @param serviceContext
	 * @return
	 */
	public D2BiobankNetwork addD2BiobankNetwork(D2BiobankNetwork biobanknetwork, ServiceContext serviceContext) {
		try {
			return addD2BiobankNetwork(biobanknetwork.getD2biobanknetworkId(), biobanknetwork.getCompanyId(), biobanknetwork.getGroupId(), biobanknetwork.getUserId(), 
					biobanknetwork.getUpdateuuid(), biobanknetwork.getContactIDRef(), biobanknetwork.getContactPriority(), biobanknetwork.getBbmriBiobankNetworkID(), 
					biobanknetwork.getBiobankNetworkName(), biobanknetwork.getBiobankNetworkCommonCollectionFocus(), biobanknetwork.getBiobankNetworkCommonCharter(), 
					biobanknetwork.getBiobankNetworkCommonSOPs(), biobanknetwork.getBiobankNetworkCommonDataAccessPolicy(), 
					biobanknetwork.getBiobankNetworkCommonSampleAccessPolicy(), biobanknetwork.getBiobankNetworkCommonMTA(), 
					biobanknetwork.getBiobankNetworkCommonRepresentation(), biobanknetwork.getBiobankNetworkCommonURL(), biobanknetwork.getBiobankNetworkIDRef(), 
					biobanknetwork.getGeoLatitude(), biobanknetwork.getGeoLongitude(), biobanknetwork.getBiobankNetworkAcronym(),
					biobanknetwork.getBiobankNetworkDescription(), biobanknetwork.getBiobankNetworkURL(), biobanknetwork.getBiobankNetworkJuridicalPerson(),
					serviceContext);
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classname_ + "::addD2BiobankNetwork] Error updateing D2BiobankNetwork with (D2BiobankNetwork biobanknetwork, ServiceContext serviceContext).");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param d2biobanknetworkId
	 * @param companyId
	 * @param groupId
	 * @param userId
	 * @param ldapupdateuuid
	 * @param contactIDRef
	 * @param contactPriority
	 * @param bbmriBiobankNetworkID
	 * @param biobankNetworkName
	 * @param biobankNetworkCommonCollectionFocus
	 * @param biobankNetworkCommonCharter
	 * @param biobankNetworkCommonSOPs
	 * @param biobankNetworkCommonDataAccessPolicy
	 * @param biobankNetworkCommonSampleAccessPolicy
	 * @param biobankNetworkCommonMTA
	 * @param biobankNetworkCommonRepresentation
	 * @param biobankNetworkCommonURL
	 * @param biobankNetworkIDRef
	 * @param geoLatitude
	 * @param geoLongitude
	 * @param biobankNetworkAcronym
	 * @param biobankNetworkDescription
	 * @param biobankNetworkURL
	 * @param biobankNetworkJuridicalPerson
	 * @param serviceContext
	 * @return
	 */
	public D2BiobankNetwork addD2BiobankNetwork(long d2biobanknetworkId, long companyId, long groupId, long userId, String ldapupdateuuid, 
			String contactIDRef, long contactPriority, String bbmriBiobankNetworkID, String biobankNetworkName, boolean biobankNetworkCommonCollectionFocus,
			boolean biobankNetworkCommonCharter, boolean biobankNetworkCommonSOPs, boolean biobankNetworkCommonDataAccessPolicy, 
			boolean biobankNetworkCommonSampleAccessPolicy, boolean biobankNetworkCommonMTA, boolean biobankNetworkCommonRepresentation,
			boolean biobankNetworkCommonURL, String biobankNetworkIDRef, String geoLatitude, String geoLongitude, String biobankNetworkAcronym,
			String biobankNetworkDescription, String biobankNetworkURL, String biobankNetworkJuridicalPerson,
			ServiceContext serviceContext) {
		try {
			// Set Primary Key
			if(d2biobanknetworkId != 0) {
				d2biobanknetworkId = counterLocalService.increment();
			}
			D2BiobankNetwork d2biobanknetwork = d2BiobankNetworkPersistence.create(d2biobanknetworkId);
			// Set provenance fields
			if(companyId == 0) {
				companyId =serviceContext.getCompanyId();
			}
			if(groupId == 0) {
				groupId = serviceContext.getScopeGroupId();
			}
			if(userId == 0) {
				userId =serviceContext.getUserId();
			}
			Date now = new Date();
			d2biobanknetwork.setCreateDate(serviceContext.getCreateDate(now));
			d2biobanknetwork.setModifiedDate(serviceContext.getModifiedDate(now));
			d2biobanknetwork.setUserId(userId);
			d2biobanknetwork.setGroupId(groupId);
			d2biobanknetwork.setCompanyId(companyId);
			d2biobanknetwork.setUpdateuuid(ldapupdateuuid);
			// Set mandatory fields
			d2biobanknetwork.setContactIDRef(contactIDRef);
			d2biobanknetwork.setContactPriority(contactPriority);
			d2biobanknetwork.setBbmriBiobankNetworkID(bbmriBiobankNetworkID);
			d2biobanknetwork.setBiobankNetworkName(biobankNetworkName);
			d2biobanknetwork.setBiobankNetworkCommonCollectionFocus(biobankNetworkCommonCollectionFocus);
			d2biobanknetwork.setBiobankNetworkCommonCharter(biobankNetworkCommonCharter);
			d2biobanknetwork.setBiobankNetworkCommonSOPs(biobankNetworkCommonSOPs);
			d2biobanknetwork.setBiobankNetworkCommonDataAccessPolicy(biobankNetworkCommonDataAccessPolicy);
			d2biobanknetwork.setBiobankNetworkCommonSampleAccessPolicy(biobankNetworkCommonSampleAccessPolicy);
			d2biobanknetwork.setBiobankNetworkCommonMTA(biobankNetworkCommonMTA);
			d2biobanknetwork.setBiobankNetworkCommonRepresentation(biobankNetworkCommonRepresentation);
			d2biobanknetwork.setBiobankNetworkCommonURL(biobankNetworkCommonURL);
			d2biobanknetwork.setBiobankNetworkIDRef(biobankNetworkIDRef);
			d2biobanknetwork.setGeoLatitude(geoLatitude);
			d2biobanknetwork.setGeoLongitude(geoLongitude);
			d2biobanknetwork.setBiobankNetworkAcronym(biobankNetworkAcronym);
			d2biobanknetwork.setBiobankNetworkDescription(biobankNetworkDescription);
			d2biobanknetwork.setBiobankNetworkURL(biobankNetworkURL);
			d2biobanknetwork.setBiobankNetworkJuridicalPerson(biobankNetworkJuridicalPerson);
	        // Liferay Expension Fields
			d2biobanknetwork.setExpandoBridgeAttributes(serviceContext);
			d2BiobankNetworkPersistence.update(d2biobanknetwork);
			return d2biobanknetwork;
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classname_ + "::addD2BiobankNetwork] Error updateing D2BiobankNetwork with (......, ServiceContext serviceContext).");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param groupId
	 * @param ldapupdateuuid
	 */
	public List<D2BiobankNetwork> getLDAPNotUpdatedNetworks(long groupId, String ldapupdateuuid) {
		try {
			return d2BiobankNetworkPersistence.findByNotUUID(groupId, ldapupdateuuid);
		} catch (SystemException e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classname_ + "::getLDAPNotUpdatedNetworks] Error getting BiobankNetwork List with updateId: " + ldapupdateuuid + ".");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param groupId
	 * @param bbmribiobanknetworkID
	 * @return
	 */
	public D2BiobankNetwork getD2BiobankNetworkByBBMRIERICID(long groupId, String bbmribiobanknetworkID) {
		try {
			return d2BiobankNetworkPersistence.findByBiobankNetworkBBMRIERICID(groupId, bbmribiobanknetworkID);
		} catch (Exception ex) {
			 
		}
		return null;
	}
	
	public D2BiobankNetwork getD2BiobankNetworkFromLDAP(D2BiobankNetwork d2biobanknetwork, Attributes attrs) {
		try {
			if(d2biobanknetwork == null) {
				d2biobanknetwork = new D2BiobankNetworkImpl();
				d2biobanknetwork.setD2biobanknetworkId(counterLocalService.increment());
			}
			d2biobanknetwork.setBbmriBiobankNetworkID(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankNetworkID")));
			d2biobanknetwork.setContactIDRef(LDAPAttributeEscaper.getAttributeValues(attrs.get("contactIDRef")));
			d2biobanknetwork.setContactPriority(LDAPAttributeEscaper.getAttributeValuesLong(attrs.get("contactPriority")));
			d2biobanknetwork.setBiobankNetworkName(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankNetworkName")));
			d2biobanknetwork.setBiobankNetworkCommonCollectionFocus(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("biobankNetworkCommonCollectionFocus")));
			d2biobanknetwork.setBiobankNetworkCommonCharter(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("biobankNetworkCommonCharter")));
			d2biobanknetwork.setBiobankNetworkCommonSOPs(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("biobankNetworkCommonSOPs")));
			d2biobanknetwork.setBiobankNetworkCommonDataAccessPolicy(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("biobankNetworkCommonDataAccessPolicy")));
			d2biobanknetwork.setBiobankNetworkCommonSampleAccessPolicy(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("biobankNetworkCommonSampleAccessPolicy")));
			d2biobanknetwork.setBiobankNetworkCommonMTA(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("biobankNetworkCommonMTA")));
			d2biobanknetwork.setBiobankNetworkCommonRepresentation(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("biobankNetworkCommonRepresentation")));
			d2biobanknetwork.setBiobankNetworkCommonURL(LDAPAttributeEscaper.getAttributeValuesBoolean(attrs.get("biobankNetworkCommonURL")));
			d2biobanknetwork.setBiobankNetworkIDRef(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankNetworkIDRef")));
			d2biobanknetwork.setGeoLatitude(LDAPAttributeEscaper.getAttributeValues(attrs.get("geoLatitude")));
			d2biobanknetwork.setGeoLongitude(LDAPAttributeEscaper.getAttributeValues(attrs.get("geoLongitude")));
			d2biobanknetwork.setBiobankNetworkAcronym(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankNetworkAcronym")));
			d2biobanknetwork.setBiobankNetworkDescription(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankNetworkDescription")));
			d2biobanknetwork.setBiobankNetworkURL(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankNetworkURL")));
			d2biobanknetwork.setBiobankNetworkJuridicalPerson(LDAPAttributeEscaper.getAttributeValues(attrs.get("biobankNetworkJuridicalPerson")));	
		} catch (SystemException e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classname_ + "::getD2BiobankNetworkFromLDAP] Error getting BiobankNetwork Data from LDAP.");
			e.printStackTrace();
		}
		return d2biobanknetwork;
	}
	
	/**
	 * 
	 * @param newbiobank
	 * @param serviceContext
	 * @return
	 */
	public D2BiobankNetwork updateD2BiobankNetwork(D2BiobankNetwork d2biobanknetwork, ServiceContext serviceContext) {
		try {
			// Set provenance fields
			if(d2biobanknetwork.getUserId() == 0) {
				d2biobanknetwork.setUserId(serviceContext.getUserId());
			}
			Date now = new Date();
			d2biobanknetwork.setModifiedDate(serviceContext.getModifiedDate(now));
	        // Liferay Expension Fields
			d2biobanknetwork.setExpandoBridgeAttributes(serviceContext);
			d2BiobankNetworkPersistence.update(d2biobanknetwork);
			return d2biobanknetwork;
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classname_ + "::updateD2BiobankNetwork] Error updateing D2BiobankNetwork with (D2BiobankNetwork biobanknetwork, ServiceContext serviceContext).");
			e.printStackTrace();
		}
		return null;
	}
	
	public D2BiobankNetwork updateD2BiobankNetwork(long d2biobanknetworkId, long companyId, long groupId, long userId, String ldapupdateuuid, 
			String contactIDRef, long contactPriority, String bbmriBiobankNetworkID, String biobankNetworkName, boolean biobankNetworkCommonCollectionFocus,
			boolean biobankNetworkCommonCharter, boolean biobankNetworkCommonSOPs, boolean biobankNetworkCommonDataAccessPolicy, 
			boolean biobankNetworkCommonSampleAccessPolicy, boolean biobankNetworkCommonMTA, boolean biobankNetworkCommonRepresentation,
			boolean biobankNetworkCommonURL, String biobankNetworkIDRef, String geoLatitude, String geoLongitude, String biobankNetworkAcronym,
			String biobankNetworkDescription, String biobankNetworkURL, String biobankNetworkJuridicalPerson,
			ServiceContext serviceContext) {
		try {
			D2BiobankNetwork d2biobanknetwork = D2BiobankNetworkLocalServiceUtil.getD2BiobankNetwork(d2biobanknetworkId);
			// Set provenance fields
			if(d2biobanknetwork.getUserId() == 0) {
				d2biobanknetwork.setUserId(serviceContext.getUserId());
			}
			Date now = new Date();
			d2biobanknetwork.setModifiedDate(serviceContext.getModifiedDate(now));
			// Update fields
			d2biobanknetwork.setContactIDRef(contactIDRef);
			d2biobanknetwork.setContactPriority(contactPriority);
			d2biobanknetwork.setBbmriBiobankNetworkID(bbmriBiobankNetworkID);
			d2biobanknetwork.setBiobankNetworkName(biobankNetworkName);
			d2biobanknetwork.setBiobankNetworkCommonCollectionFocus(biobankNetworkCommonCollectionFocus);
			d2biobanknetwork.setBiobankNetworkCommonCharter(biobankNetworkCommonCharter);
			d2biobanknetwork.setBiobankNetworkCommonSOPs(biobankNetworkCommonSOPs);
			d2biobanknetwork.setBiobankNetworkCommonDataAccessPolicy(biobankNetworkCommonDataAccessPolicy);
			d2biobanknetwork.setBiobankNetworkCommonSampleAccessPolicy(biobankNetworkCommonSampleAccessPolicy);
			d2biobanknetwork.setBiobankNetworkCommonMTA(biobankNetworkCommonMTA);
			d2biobanknetwork.setBiobankNetworkCommonRepresentation(biobankNetworkCommonRepresentation);
			d2biobanknetwork.setBiobankNetworkCommonURL(biobankNetworkCommonURL);
			d2biobanknetwork.setBiobankNetworkIDRef(biobankNetworkIDRef);
			d2biobanknetwork.setGeoLatitude(geoLatitude);
			d2biobanknetwork.setGeoLongitude(geoLongitude);
			d2biobanknetwork.setBiobankNetworkAcronym(biobankNetworkAcronym);
			d2biobanknetwork.setBiobankNetworkDescription(biobankNetworkDescription);
			d2biobanknetwork.setBiobankNetworkURL(biobankNetworkURL);
			d2biobanknetwork.setBiobankNetworkJuridicalPerson(biobankNetworkJuridicalPerson);
	        // Liferay Expension Fields
			d2biobanknetwork.setExpandoBridgeAttributes(serviceContext);
			d2BiobankNetworkPersistence.update(d2biobanknetwork);
			return d2biobanknetwork;
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [" + classname_ + "::updateD2BiobankNetwork] Error updateing D2BiobankNetwork with (D2BiobankNetwork biobanknetwork, ServiceContext serviceContext).");
			e.printStackTrace();
		}
		return null;
	}
}