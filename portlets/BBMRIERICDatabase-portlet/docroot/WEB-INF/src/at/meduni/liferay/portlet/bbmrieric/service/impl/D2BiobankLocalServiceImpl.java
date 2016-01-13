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
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;
import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

import at.meduni.liferay.portlet.bbmrieric.model.BioBank;
import at.meduni.liferay.portlet.bbmrieric.model.ContactInformation;
import at.meduni.liferay.portlet.bbmrieric.model.D2Biobank;
import at.meduni.liferay.portlet.bbmrieric.model.D2Collection;
import at.meduni.liferay.portlet.bbmrieric.model.SearchIndex;
import at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankImpl;
import at.meduni.liferay.portlet.bbmrieric.service.ContactInformationLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2BiobankLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.D2CollectionLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.SearchIndexLocalServiceUtil;
import at.meduni.liferay.portlet.bbmrieric.service.base.D2BiobankLocalServiceBaseImpl;
import at.meduni.liferay.portlet.bbmrieric.util.D2BiobankKeys;
import at.meduni.liferay.portlet.bbmrieric.util.LDAPAttributeEscaper;

/**
 * The implementation of the d2 biobank local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.meduni.liferay.portlet.bbmrieric.service.D2BiobankLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author reihsr
 * @see at.meduni.liferay.portlet.bbmrieric.service.base.D2BiobankLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.bbmrieric.service.D2BiobankLocalServiceUtil
 */
public class D2BiobankLocalServiceImpl extends D2BiobankLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link at.meduni.liferay.portlet.bbmrieric.service.D2BiobankLocalServiceUtil} to access the d2 biobank local service.
	 */
	/**
	 * Error Format for date
	 */
	String date_format_apache_error_pattern = "EEE MMM dd HH:mm:ss yyyy";
	SimpleDateFormat date_format_apache_error = new SimpleDateFormat(date_format_apache_error_pattern);
	
	public D2Biobank d2BiobankFromRequest(ActionRequest request) {
		D2BiobankImpl d2biobank = new D2BiobankImpl();
		d2biobank.setBiobankId(ParamUtil.getLong(request, "biobankId"));
		d2biobank.setBiobankName(ParamUtil.getString(request, "biobankName"));
		return d2biobank;
	}
	
	/**
	 * 
	 * @param groupId
	 * @return
	 * @throws SystemException
	 */
	public List<D2Biobank> getD2Biobanks(long groupId) throws SystemException {
		return d2BiobankPersistence.findByGroupId(groupId);
	}
	
	/**
	 * 
	 * @param groupId
	 * @param start
	 * @param end
	 * @return
	 * @throws SystemException
	 */
	public List<D2Biobank> getD2Biobanks(long groupId, int start, int end) throws SystemException {
		return d2BiobankPersistence.findByGroupId(groupId, start, end);
	}
	
	/**
	 * 
	 * @param groupId
	 * @param bbmribiobankID
	 * @return
	 */
	public D2Biobank getD2BiobankByBBMRIERICID(long groupId, String bbmribiobankID) {
		try {
			return d2BiobankPersistence.findByBiobankBBMRIERICID(groupId, bbmribiobankID);
		} catch (Exception ex) {
			 
		}
		return null;
	}
	
	/**
	 * 
	 * @param newbiobank
	 * @param serviceContext
	 * @return
	 */
	public D2Biobank addD2Biobank(D2Biobank newbiobank, ServiceContext serviceContext) {
		return addD2Biobank(newbiobank.getBiobankId(), newbiobank.getCompanyId(), newbiobank.getGroupId(), newbiobank.getUserId(), newbiobank.getBiobankName(), 
				newbiobank.getBbmribiobankID(), newbiobank.getUpdateuuid(), newbiobank.getContactIDRef(), newbiobank.getContactPriority(), newbiobank.getBiobankJurisdicalPerson(),
				newbiobank.getBiobankCountry(), newbiobank.getBiobankPartnerCharterSigned(), newbiobank.getBioresourceReference(), newbiobank.getBiobankNetworkIDRef(),
				newbiobank.getGeoLatitude(), newbiobank.getGeoLongitude(), newbiobank.getCollaborationPartnersCommercial(), newbiobank.getCollaborationPartnersNonforprofit(),
				newbiobank.getBiobankITSupportAvailable(), newbiobank.getBiobankITStaffSize(), newbiobank.getBiobankISAvailable(), newbiobank.getBiobankHISAvailable(),
				newbiobank.getBiobankAcronym(), newbiobank.getBiobankDescription(), newbiobank.getBiobankURL(), newbiobank.getBiobankHeadFirstName(), newbiobank.getBiobankHeadLastName(),
				newbiobank.getBiobankHeadRole(), newbiobank.getBiobankClinical(), newbiobank.getBiobankPopulation(), newbiobank.getBiobankResearchStudy(), newbiobank.getBiobankNonHuman(),
				newbiobank.getBiobankCollection(), newbiobank.getBiobankType(), serviceContext);
	}
	
	/**
	 * 
	 * @param biobankId
	 * @param serviceContext
	 * @return
	 */
	public D2Biobank addD2Biobank(long biobankId, long companyId, long groupId, long userId, String biobankName, 
			String ldapbiobankID, String ldapupdateuuid, String contactIDRef, long contactPriority, String biobankJurisdicalPerson,
			String biobankCountry, boolean biobankPartnerCharterSigned, String bioresourceReference, String biobankNetworkIDRef,
			String geoLatitude, String geoLongitude, boolean collaborationPartnersCommercial, boolean collaborationPartnersNonforprofit,
			boolean biobankITSupportAvailable, long biobankITStaffSize, boolean biobankISAvailable, boolean biobankHISAvailable,
			String biobankAcronym, String biobankDescription, String biobankURL, String biobankHeadFirstName, String biobankHeadLastName,
			String biobankHeadRole, boolean biobankClinical, boolean biobankPopulation, boolean biobankResearchStudy, boolean biobankNonHuman,
			boolean biobankCollection, String biobankType, ServiceContext serviceContext) {
		try {
			// Create the Biobank Entry
			// Set Primary Key
			if(biobankId == 0) {
				biobankId = counterLocalService.increment();
			}
			D2Biobank d2biobank = d2BiobankPersistence.create(biobankId);
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
			d2biobank.setCreateDate(serviceContext.getCreateDate(now));
			d2biobank.setModifiedDate(serviceContext.getModifiedDate(now));
			d2biobank.setUserId(userId);
			d2biobank.setGroupId(groupId);
			d2biobank.setCompanyId(companyId);
			// Set mandatory fields
			d2biobank.setBiobankName(biobankName);
	        d2biobank.setBbmribiobankID(ldapbiobankID);
	        d2biobank.setUpdateuuid(ldapupdateuuid);
	        d2biobank.setContactIDRef(contactIDRef);
	        d2biobank.setContactPriority(contactPriority);
	        d2biobank.setBiobankJurisdicalPerson(biobankJurisdicalPerson);
 	        d2biobank.setBiobankCountry(biobankCountry.toUpperCase());
	        d2biobank.setBiobankPartnerCharterSigned(biobankPartnerCharterSigned);
			// Set optional fields
	        d2biobank.setBioresourceReference(bioresourceReference);
	        d2biobank.setBiobankNetworkIDRef(biobankNetworkIDRef);
	        d2biobank.setGeoLatitude(geoLatitude);
	        d2biobank.setGeoLongitude(geoLongitude);
	        d2biobank.setCollaborationPartnersCommercial(collaborationPartnersCommercial);
	        d2biobank.setCollaborationPartnersNonforprofit(collaborationPartnersNonforprofit);
	        d2biobank.setBiobankITSupportAvailable(biobankITSupportAvailable);
	        d2biobank.setBiobankITStaffSize(biobankITStaffSize);
	        d2biobank.setBiobankISAvailable(biobankISAvailable);
	        d2biobank.setBiobankHISAvailable(biobankHISAvailable);
	        d2biobank.setBiobankAcronym(biobankAcronym);
	        d2biobank.setBiobankDescription(biobankDescription);
	        d2biobank.setBiobankURL(biobankURL);
	        d2biobank.setBiobankHeadFirstName(biobankHeadFirstName);
	        d2biobank.setBiobankHeadLastName(biobankHeadLastName);
	        d2biobank.setBiobankHeadRole(biobankHeadRole);
	        d2biobank.setBiobankClinical(biobankClinical);
	        d2biobank.setBiobankPopulation(biobankPopulation);
	        d2biobank.setBiobankResearchStudy(biobankResearchStudy);
	        d2biobank.setBiobankNonHuman(biobankNonHuman);
	        d2biobank.setBiobankCollection(biobankCollection);
	        d2biobank.setBiobankType(biobankType);
	        // Liferay Expension Fields
			d2biobank.setExpandoBridgeAttributes(serviceContext);
			d2BiobankPersistence.update(d2biobank);
			// Add Asset Entry to Liferay
			resourceLocalService.addResources(companyId, groupId, userId, D2Biobank.class.getName(), biobankId, false, true, true);
			AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId, groupId, d2biobank.getCreateDate(), d2biobank.getModifiedDate(), D2Biobank.class.getName(), 
					d2biobank.getBiobankId(), d2biobank.getUuid(), 0, serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, null, null, null, 
					ContentTypes.TEXT_HTML, d2biobank.getBiobankName(), d2biobank.getBiobankDescription(), null, null, null, 0, 0, null, false);
			//updateEntry(userId, groupId, createDate, modifiedDate, className, classPK, classUuid, classTypeId=0, categoryIds, tagNames, visible, startDate, endDate, expirationDate, mimeType, title, description, summary, url, layoutUuid, height, width, priority, sync)
			assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(), AssetLinkConstants.TYPE_RELATED);
			Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(D2Biobank.class);
			indexer.reindex(d2biobank);
			return d2biobank;
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.D2BiobankLocalServiceImpl::addD2Biobank] Error creating D2Biobank with (D2Biobank newbiobank, ServiceContext serviceContext).");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param newbiobank
	 * @param serviceContext
	 * @return
	 */
	public D2Biobank updateD2Biobank(D2Biobank d2biobank, ServiceContext serviceContext) {
		try {
			// Set provenance fields
			if(d2biobank.getUserId() == 0) {
				d2biobank.setUserId(serviceContext.getUserId());
			}
			Date now = new Date();
			d2biobank.setModifiedDate(serviceContext.getModifiedDate(now));
			
			d2biobank.setBiobankCountry(d2biobank.getBiobankCountry().toUpperCase());
	        // Liferay Expension Fields
			d2biobank.setExpandoBridgeAttributes(serviceContext);
			d2BiobankPersistence.update(d2biobank);
			// Add Asset Entry to Liferay
			resourceLocalService.updateResources(d2biobank.getCompanyId(), d2biobank.getGroupId(), d2biobank.getBiobankName(), d2biobank.getBiobankId(), serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
			AssetEntry assetEntry = assetEntryLocalService.updateEntry(d2biobank.getUserId(), d2biobank.getGroupId(), d2biobank.getCreateDate(), d2biobank.getModifiedDate(), D2Biobank.class.getName(), 
					d2biobank.getBiobankId(), d2biobank.getUuid(), 0, serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, null, null, null, 
					ContentTypes.TEXT_HTML, d2biobank.getBiobankName(), d2biobank.getBiobankDescription(), null, null, null, 0, 0, null, false);
			//updateEntry(userId, groupId, createDate, modifiedDate, className, classPK, classUuid, classTypeId=0, categoryIds, tagNames, visible, startDate, endDate, expirationDate, mimeType, title, description, summary, url, layoutUuid, height, width, priority, sync)
			assetLinkLocalService.updateLinks(d2biobank.getUserId(), assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(), AssetLinkConstants.TYPE_RELATED);
			Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(D2Biobank.class);
			indexer.reindex(d2biobank);
			return d2biobank;
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.D2BiobankLocalServiceImpl::updateD2Biobank] Error updateing D2Biobank with (D2Biobank newbiobank, ServiceContext serviceContext).");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param biobankId
	 * @param serviceContext
	 * @return
	 */
	public D2Biobank updateD2Biobank(long biobankId, long userId, String biobankName, 
			String ldapbiobankID, String ldapupdateuuid, String contactIDRef, long contactPriority, String biobankJurisdicalPerson,
			String biobankCountry, boolean biobankPartnerCharterSigned, String bioresourceReference, String biobankNetworkIDRef,
			String geoLatitude, String geoLongitude, boolean collaborationPartnersCommercial, boolean collaborationPartnersNonforprofit,
			boolean biobankITSupportAvailable, long biobankITStaffSize, boolean biobankISAvailable, boolean biobankHISAvailable,
			String biobankAcronym, String biobankDescription, String biobankURL, String biobankHeadFirstName, String biobankHeadLastName,
			String biobankHeadRole, boolean biobankClinical, boolean biobankPopulation, boolean biobankResearchStudy, boolean biobankNonHuman,
			boolean biobankCollection, String biobankType, ServiceContext serviceContext) {
		try {
			// Update the Biobank Entry
			D2Biobank d2biobank = getD2Biobank(biobankId);
			// Set provenance fields
			if(userId == 0) {
				userId =serviceContext.getUserId();
			}
			Date now = new Date();
			d2biobank.setModifiedDate(serviceContext.getModifiedDate(now));
			d2biobank.setUserId(userId);
			// Set mandatory fields
			d2biobank.setBiobankName(biobankName);
			d2biobank.setBbmribiobankID(ldapbiobankID);
	        d2biobank.setUpdateuuid(ldapupdateuuid);
	        d2biobank.setContactIDRef(contactIDRef);
	        d2biobank.setContactPriority(contactPriority);
	        d2biobank.setBiobankJurisdicalPerson(biobankJurisdicalPerson);
	        if(biobankCountry.equalsIgnoreCase("ee")) {
	        	biobankCountry = "et";
	        }
	        d2biobank.setBiobankCountry(biobankCountry);
	        d2biobank.setBiobankPartnerCharterSigned(biobankPartnerCharterSigned);
			// Set optional fields
	        d2biobank.setBioresourceReference(bioresourceReference);
	        d2biobank.setBiobankNetworkIDRef(biobankNetworkIDRef);
	        d2biobank.setGeoLatitude(geoLatitude);
	        d2biobank.setGeoLongitude(geoLongitude);
	        d2biobank.setCollaborationPartnersCommercial(collaborationPartnersCommercial);
	        d2biobank.setCollaborationPartnersNonforprofit(collaborationPartnersNonforprofit);
	        d2biobank.setBiobankITSupportAvailable(biobankITSupportAvailable);
	        d2biobank.setBiobankITStaffSize(biobankITStaffSize);
	        d2biobank.setBiobankISAvailable(biobankISAvailable);
	        d2biobank.setBiobankHISAvailable(biobankHISAvailable);
	        d2biobank.setBiobankAcronym(biobankAcronym);
	        d2biobank.setBiobankDescription(biobankDescription);
	        d2biobank.setBiobankURL(biobankURL);
	        d2biobank.setBiobankHeadFirstName(biobankHeadFirstName);
	        d2biobank.setBiobankHeadLastName(biobankHeadLastName);
	        d2biobank.setBiobankHeadRole(biobankHeadRole);
	        d2biobank.setBiobankClinical(biobankClinical);
	        d2biobank.setBiobankPopulation(biobankPopulation);
	        d2biobank.setBiobankResearchStudy(biobankResearchStudy);
	        d2biobank.setBiobankNonHuman(biobankNonHuman);
	        d2biobank.setBiobankCollection(biobankCollection);
	        d2biobank.setBiobankType(biobankType);
	        // Liferay Expension Fields
			d2biobank.setExpandoBridgeAttributes(serviceContext);
			d2BiobankPersistence.update(d2biobank);
			// Add Asset Entry to Liferay
			resourceLocalService.updateResources(d2biobank.getCompanyId(), d2biobank.getGroupId(), d2biobank.getBiobankName(), biobankId, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
			AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId, d2biobank.getGroupId(), d2biobank.getCreateDate(), d2biobank.getModifiedDate(), D2Biobank.class.getName(), 
					d2biobank.getBiobankId(), d2biobank.getUuid(), 0, serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, null, null, null, 
					ContentTypes.TEXT_HTML, d2biobank.getBiobankName(), d2biobank.getBiobankDescription(), null, null, null, 0, 0, null, false);
			//updateEntry(userId, groupId, createDate, modifiedDate, className, classPK, classUuid, classTypeId=0, categoryIds, tagNames, visible, startDate, endDate, expirationDate, mimeType, title, description, summary, url, layoutUuid, height, width, priority, sync)
			assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(), AssetLinkConstants.TYPE_RELATED);
			Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(D2Biobank.class);
			indexer.reindex(d2biobank);
			return d2biobank;
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.D2BiobankLocalServiceImpl::updateD2Biobank] Error updateing D2Biobank with (D2Biobank newbiobank, ServiceContext serviceContext).");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param biobankId
	 * @param serviceContext
	 * @return
	 */
	public D2Biobank deleteD2Biobank(long biobankId, ServiceContext serviceContext) {
		try {
			D2Biobank d2biobank = getD2Biobank(biobankId);
			resourceLocalService.deleteResource(serviceContext.getCompanyId(), D2Biobank.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, biobankId);
			AssetEntry assetEntry = assetEntryLocalService.fetchEntry(D2Biobank.class.getName(), biobankId);
			assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
			assetEntryLocalService.deleteEntry(assetEntry);
			Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(D2Biobank.class);
			indexer.delete(d2biobank);
			d2biobank = deleteD2Biobank(d2biobank);
			return d2biobank;
		} catch (Exception e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.D2BiobankLocalServiceImpl::deleteD2Biobank] Error deleteing D2Biobank " + biobankId + ".");
			e.printStackTrace();
		}
		return null;
	}
	
	public List<D2Biobank> getD2Biobanks(String keyword, String country, String materialtype, String diagnosisavailable, String biobanksize, String typeofbiobank, String typeofcollection) {
		keyword = keyword.trim();
		if(keyword.equals("") && country.equals("") && materialtype.equals("") && diagnosisavailable.equals("") && biobanksize.equals("") && typeofbiobank.equals("") && typeofcollection.equals("")) {
			try {
				return this.getD2Biobanks(-1, -1);
			} catch(Exception e) {
				System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.D2BiobankLocalServiceImpl::getD2Biobanks] Error getting all biobanks.");
				e.printStackTrace();
			}
		} else {
			DynamicQuery subquerycontact = null;
			DynamicQuery subquerycollection = null;
			DynamicQuery subquerycollectionkeyword = null;
			DynamicQuery dynamicQuerykeyword = null;
			DynamicQuery dynamicQuery = null;
			List<Long> searchlist_biobank = new ArrayList<Long>();
			if(!keyword.equals("")) {
				try {
					List<Long> searchlist_contact = new ArrayList<Long>();
					List<Long> searchlist_collection = new ArrayList<Long>();
					subquerycontact = getContactInformationSubquery(keyword);
					if(subquerycontact != null) {
						searchlist_contact.addAll(D2BiobankLocalServiceUtil.dynamicQuery(subquerycontact));
					}
					subquerycollectionkeyword = getCollectionSubqueryForKeywords(keyword);
					if(subquerycollectionkeyword != null) {
						searchlist_collection.addAll(D2BiobankLocalServiceUtil.dynamicQuery(subquerycollectionkeyword));
					}
					dynamicQuerykeyword = getBiobankQueryForKeywords(keyword);
					if(dynamicQuerykeyword != null) {
						searchlist_biobank.addAll(D2BiobankLocalServiceUtil.dynamicQuery(dynamicQuerykeyword));
					}
					searchlist_contact.removeAll(searchlist_biobank);
					searchlist_biobank.addAll(searchlist_contact);
					searchlist_collection.removeAll(searchlist_biobank);
					searchlist_biobank.addAll(searchlist_collection);
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			long powerof = 0;
			if(!biobanksize.equals("")) {
				powerof = D2BiobankKeys.getBiobankSizeFromSelect(biobanksize);
			}
			if(!materialtype.equals("") || !diagnosisavailable.equals("") || !biobanksize.equals("") || !typeofcollection.equals("")) {
				subquerycollection = getCollectionSubquery(materialtype, diagnosisavailable, biobanksize, powerof, typeofcollection);
			}
			//Create Main Query
			dynamicQuery = getBiobankQuery(country, typeofbiobank);
			if(subquerycollection != null) {
				dynamicQuery.add(PropertyFactoryUtil.forName("biobankId").in(subquerycollection));
			}
			if(searchlist_biobank.size() != 0) {
				dynamicQuery.add(PropertyFactoryUtil.forName("biobankId").in(searchlist_biobank));
			}
			try {
				List<D2Biobank> searchlist = D2BiobankLocalServiceUtil.dynamicQuery(dynamicQuery);
				return searchlist;
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private DynamicQuery getBiobankQueryForKeywords(String keyword) {
		DynamicQuery dynamicQuery = D2BiobankLocalServiceUtil.dynamicQuery();
		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
		projectionList.add(ProjectionFactoryUtil.groupProperty("biobankId"));
		dynamicQuery.setProjection(projectionList);
		String[] keywords = keyword.split(" ");
		Criterion criterion = null;
		if(!keyword.equals("")) {
			for(String search : keywords) {
				if(criterion == null) {
					criterion = RestrictionsFactoryUtil.ilike("bbmribiobankID", "%" + search + "%");
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("biobankName", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("biobankJurisdicalPerson", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("biobankCountry", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("bioresourceReference", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("biobankAcronym", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("biobankDescription", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("biobankHeadFirstName", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("biobankHeadLastName", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("biobankHeadRole", "%" + search + "%"));
				} else {
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("bbmribiobankID", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("biobankName", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("biobankJurisdicalPerson", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("biobankCountry", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("bioresourceReference", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("biobankAcronym", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("biobankDescription", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("biobankHeadFirstName", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("biobankHeadLastName", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("biobankHeadRole", "%" + search + "%"));
				}
			}
		}
		if(criterion != null) {
			dynamicQuery.add(criterion);
		}
		return dynamicQuery;
	}
	
	private DynamicQuery getBiobankQuery(String country, String typeofbiobank) {
		DynamicQuery dynamicQuery = D2BiobankLocalServiceUtil.dynamicQuery();
		Criterion criterion = null;
		if(!country.equals("")) {
			criterion = RestrictionsFactoryUtil.ilike("biobankCountry", "%" + country + "%");
		}
		if(!typeofbiobank.equals("")) {
			if(criterion == null) {
				criterion = RestrictionsFactoryUtil.ilike("biobankType", "%" + typeofbiobank.replaceAll(" ", "") + "%");
			} else {
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.ilike("biobankType", "%" + typeofbiobank.replaceAll(" ", "") + "%"));
			}
		}
		if(criterion != null) {
			dynamicQuery.add(criterion);
		}
		return dynamicQuery;
	}
	
	private DynamicQuery getCollectionSubqueryForKeywords(String keyword) {
		DynamicQuery dynamicQuery = D2CollectionLocalServiceUtil.dynamicQuery();
		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
		projectionList.add(ProjectionFactoryUtil.groupProperty("biobankId"));
		dynamicQuery.setProjection(projectionList);
		String[] keywords = keyword.split(" ");
		Criterion criterion = null;
		if(!keyword.equals("")) {
			for(String search : keywords) {
				if(criterion == null) {
					criterion = RestrictionsFactoryUtil.ilike("bbmricollectionID", "%" + search + "%");
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("collectionName", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("materialStoredOther", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("collectionTypeOther", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("bioresourceReference", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("collectionAcronym", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("collectionDescription", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("temperatureOther", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("diagnosisAvailable", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("collectionHeadFirstName", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("collectionHeadLastName", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("collectionHeadRole", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("collectionSampleAccessDescription", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("collectionDataAccessDescription", "%" + search + "%"));
				} else {
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("bbmricollectionID", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("collectionName", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("materialStoredOther", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("collectionTypeOther", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("bioresourceReference", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("collectionAcronym", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("collectionDescription", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("temperatureOther", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("diagnosisAvailable", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("collectionHeadFirstName", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("collectionHeadLastName", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("collectionHeadRole", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("collectionSampleAccessDescription", "%" + search + "%"));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("collectionDataAccessDescription", "%" + search + "%"));
				}
			}
		}
		if(criterion != null) {
			dynamicQuery.add(criterion);
		}
		return dynamicQuery;
	}
	
	private Criterion createSearchDiagnosisString(String diagnosisavailable) {
		Criterion criterion_sub = null;
		if(diagnosisavailable.contains("--")) {
			diagnosisavailable = diagnosisavailable.replaceAll("\\(.*\\)", "").replaceAll("-", "").trim();
			criterion_sub = RestrictionsFactoryUtil.like("diagnosisAvailable", "%" + diagnosisavailable + "%");
			if(diagnosisavailable.startsWith("B")) {
				criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%A00-B%"));
				criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%B*%"));
			} else if(diagnosisavailable.startsWith("D")) {
				try {
					int number = Integer.parseInt(diagnosisavailable.substring(1, 3));
					if(number >= 50) {
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%D50-D%"));
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%D*%"));
					} else {
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%C00-D%"));
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%D*%"));
					}
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			} else if(diagnosisavailable.startsWith("H")) {
				try {
					int number = Integer.parseInt(diagnosisavailable.substring(1, 3));
					if(number >= 60) {
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%H60-H%"));
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%H*%"));
					} else {
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%H00-H%"));
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%H*%"));
					}
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			} else if(diagnosisavailable.startsWith("T")) {
				criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%S00-T%"));
				criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%T*%"));
			} else if(diagnosisavailable.startsWith("Y")) {
				criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%V00-Y%"));
				criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%Y*%"));
			} else {
				criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%" + diagnosisavailable.charAt(0) + "00-%"));
				criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%" + diagnosisavailable.charAt(0) + "*%"));
			}
			criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%icd:*%"));
		} else if(diagnosisavailable.contains("-")) {
			// Subgroup
			try {
				diagnosisavailable = diagnosisavailable.replaceAll("\\(.*\\)", "").replaceAll("- ", "").trim();
				// Search for individual codes
				String startletter = String.valueOf(diagnosisavailable.charAt(0));
				int number = Integer.parseInt(diagnosisavailable.substring(1, 3));
				int number_stop = Integer.parseInt(diagnosisavailable.substring(5, 7));
				for(int counter = (int)Math.floor(number/10.); counter <= (int)Math.floor(number_stop/10.); counter ++) {
					if(criterion_sub == null) {
						criterion_sub = RestrictionsFactoryUtil.like("diagnosisAvailable", "%" + startletter + counter + "%");
					} else {
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%" + startletter + counter + "%"));
					}
				}
				// Search for groups
				if(diagnosisavailable.startsWith("B")) {
					criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%A00-B%"));
					criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%B*%"));
				} else if(diagnosisavailable.startsWith("D")) {
					try {
						if(number >= 50) {
							criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%D50-D%"));
							criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%D*%"));
						} else {
							criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%C00-D%"));
							criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%D*%"));
						}
					} catch(Exception ex) {
						ex.printStackTrace();
					}
				} else if(diagnosisavailable.startsWith("H")) {
					try {
						if(number >= 60) {
							criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%H60-H%"));
							criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%H*%"));
						} else {
							criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%H00-H%"));
							criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%H*%"));
						}
					} catch(Exception ex) {
						ex.printStackTrace();
					}
				} else if(diagnosisavailable.startsWith("T")) {
					criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%S00-T%"));
					criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%T*%"));
				} else if(diagnosisavailable.startsWith("Y")) {
					criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%V00-Y%"));
					criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%Y*%"));
				} else {
					criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%" + diagnosisavailable.charAt(0) + "00-%"));
					criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%" + diagnosisavailable.charAt(0) + "*%"));
				}
				criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%icd:*%"));
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		} else {
			if(diagnosisavailable.contains("ICD*")) {
				criterion_sub = RestrictionsFactoryUtil.like("diagnosisAvailable", "%icd:%");
			} else if(diagnosisavailable.contains("OMIM*")) {
				criterion_sub = RestrictionsFactoryUtil.like("diagnosisAvailable", "%omim:%");
			} else if(diagnosisavailable.contains("ORPHA*")) {
				criterion_sub = RestrictionsFactoryUtil.like("diagnosisAvailable", "%orphanet%");
			} else {
				// Gruppen Search
				try {
					diagnosisavailable = diagnosisavailable.replaceAll("\\(.*\\)", "").replaceAll("- ", "").trim();
					//System.out.println("++++++" + startletter + number + diagnosisavailable.substring(4, 5) + number_stop);
					String startletter = String.valueOf(diagnosisavailable.charAt(0));
					String endletter = diagnosisavailable.substring(4, 5);
					int number = Integer.parseInt(diagnosisavailable.substring(1, 3));
					int number_stop = Integer.parseInt(diagnosisavailable.substring(5, 7));
					// Search for individual codes
					if(startletter.equalsIgnoreCase(endletter)) {
						for(int counter = (int)Math.floor(number/10.); counter <= (int)Math.floor(number_stop/10.); counter ++) {
							if(criterion_sub == null) {
								criterion_sub = RestrictionsFactoryUtil.like("diagnosisAvailable", "%" + startletter + counter + "%");
							} else {
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%" + startletter + counter + "%"));
							}
						}
					} else {
						for(int counter = (int)Math.floor(number/10.); counter <= 9; counter ++) {
							if(criterion_sub == null) {
								criterion_sub = RestrictionsFactoryUtil.like("diagnosisAvailable", "%" + startletter + counter + "%");
							} else {
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%" + startletter + counter + "%"));
							}
						}
						for(int counter = 0; counter <= (int)Math.floor(number_stop/10.); counter ++) {
							if(criterion_sub == null) {
								criterion_sub = RestrictionsFactoryUtil.like("diagnosisAvailable", "%" + startletter + counter + "%");
							} else {
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%" + startletter + counter + "%"));
							}
						}
					}
					// Search for groups
					if(diagnosisavailable.startsWith("B")) {
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%A00-B%"));
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%B*%"));
					} else if(diagnosisavailable.startsWith("D")) {
						try {
							if(number >= 50) {
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%D50-D%"));
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%D*%"));
							} else {
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%C00-D%"));
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%D*%"));
							}
						} catch(Exception ex) {
							ex.printStackTrace();
						}
					} else if(diagnosisavailable.startsWith("H")) {
						try {
							if(number >= 60) {
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%H60-H%"));
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%H*%"));
							} else {
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%H00-H%"));
								criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%H*%"));
							}
						} catch(Exception ex) {
							ex.printStackTrace();
						}
					} else if(diagnosisavailable.startsWith("T")) {
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%S00-T%"));
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%T*%"));
					} else if(diagnosisavailable.startsWith("Y")) {
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%V00-Y%"));
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%Y*%"));
					} else {
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%" + diagnosisavailable.charAt(0) + "00-%"));
						criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%" + diagnosisavailable.charAt(0) + "*%"));
					}
					criterion_sub = RestrictionsFactoryUtil.or(criterion_sub, RestrictionsFactoryUtil.like("diagnosisAvailable", "%icd:*%"));
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return criterion_sub;
	}
	
	private DynamicQuery getCollectionSubquery(String materialtype, String diagnosisavailable, String biobanksize, long powerof, String typeofcollection) {
		DynamicQuery dynamicQuery = D2CollectionLocalServiceUtil.dynamicQuery();
		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
		projectionList.add(ProjectionFactoryUtil.groupProperty("biobankId"));
		dynamicQuery.setProjection(projectionList);
		
		Criterion criterion = null;
		
		if(!materialtype.equals("")) {
			String[] materialtypes = {"Plasma","Serum","Urine","Saliva","Faeces","RNA","Blood","Tissue Frozen","Tissue FFPE","Immortalized Cell Lines","Isolated Pathogen"};
			boolean others = true;
			
			for(String materialtypes_tmp : materialtypes) {
				if(materialtype.equalsIgnoreCase(materialtypes_tmp)) {
					String colname = "materialStored" + materialtypes_tmp.replaceAll(" ", "");
					if(criterion == null) {
						criterion = RestrictionsFactoryUtil.eq(colname, true);
					} else {
						criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq(colname, true));
					}
					others = false;
				}
			}
			if(others) {
				if(criterion == null) {
					criterion = RestrictionsFactoryUtil.ilike("materialStoredOther", "%" + materialtype + "%");
				} else {
					criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.ilike("materialStoredOther", "%" + materialtype + "%"));
				}
			}
		}
		if(!diagnosisavailable.equals("")) {
			if(criterion == null) {
				criterion = createSearchDiagnosisString(diagnosisavailable);
			} else {
				criterion = RestrictionsFactoryUtil.and(criterion, createSearchDiagnosisString(diagnosisavailable));
			}
		}
		if(!biobanksize.equals("")) {
			if(criterion == null) {
				criterion = RestrictionsFactoryUtil.eq("collectionOrderOfMagnitude", powerof);
			} else {
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("collectionOrderOfMagnitude", powerof));
			}
		}
		if(!typeofcollection.equals("")) {
			String[] typeofcollections = {"Case Control","Cohort","Cross Sectional","Longitudinal","Twin Study","Quality Control","Population Based","Disease Specific","Birth Cohort"};
			boolean others = true;
			for(String typeofcollection_tmp : typeofcollections) {
				if(typeofcollection.equalsIgnoreCase(typeofcollection_tmp)) {
					String colname = "collectionType" + typeofcollection_tmp.replaceAll(" ", "");
					if(criterion == null) {
						criterion = RestrictionsFactoryUtil.eq(colname, true);
					} else {
						criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq(colname, true));
					}
					others = false;
				}
			}
			if(others) {
				if(criterion == null) {
					criterion = RestrictionsFactoryUtil.ilike("collectionTypeOther", "%" + typeofcollection + "%");
				} else {
					criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.ilike("collectionTypeOther", "%" + typeofcollection + "%"));
				}
			}
		}
		dynamicQuery.add(criterion);
		return dynamicQuery;
	}
	
	private DynamicQuery getContactInformationSubquery(String keyword) {
		DynamicQuery dynamicQuery = D2BiobankLocalServiceUtil.dynamicQuery();
		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
		projectionList.add(ProjectionFactoryUtil.groupProperty("biobankId"));
		dynamicQuery.setProjection(projectionList);
		
		DynamicQuery dynamicQuerySub = ContactInformationLocalServiceUtil.dynamicQuery();
		ProjectionList projectionList_Sub = ProjectionFactoryUtil.projectionList();
		projectionList_Sub.add(ProjectionFactoryUtil.groupProperty("contactID"));
		dynamicQuerySub.setProjection(projectionList_Sub);
		String[] keywords = keyword.split(" ");
		Criterion criterion = null;
		for(String search : keywords) {
			if(criterion == null) {
				criterion = RestrictionsFactoryUtil.ilike("contactID", "%" + search + "%");
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("contactEmail", "%" + search + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("contactCountry", "%" + search + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("contactFirstName", "%" + search + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("contactLastName", "%" + search + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("contactPhone", "%" + search + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("contactAddress", "%" + search + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("contactZIP", "%" + search + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("contactCity", "%" + search + "%"));
			} else {
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("contactID", "%" + search + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("contactEmail", "%" + search + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("contactCountry", "%" + search + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("contactFirstName", "%" + search + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("contactLastName", "%" + search + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("contactPhone", "%" + search + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("contactAddress", "%" + search + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("contactZIP", "%" + search + "%"));
				criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ilike("contactCity", "%" + search + "%"));
			}
		}
		dynamicQuerySub.add(criterion);
		dynamicQuery.add(PropertyFactoryUtil.forName("contactIDRef").in(dynamicQuerySub));
		return dynamicQuery;
	}
	
	/**
	 * 
	 */
	public List<D2Biobank> getLDAPNotUpdatedBiobanks(long groupId, String ldapupdateuuid) {
		try {
			return d2BiobankPersistence.findByNotUUID(groupId, ldapupdateuuid);
		} catch (SystemException e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.D2BiobankLocalServiceImpl::getLDAPNotUpdatedBiobanks] Error getting Biobank List with updateId: " + ldapupdateuuid + ".");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 */
	public D2Biobank getBiobankWithLdapUpdate(long biobankId) {
		D2Biobank d2biobank = null;
		// ServiceContext to create the assets
		long companyId = Long.parseLong(PropsUtil.get("D2BiobankCompany"));
		long groupId = Long.parseLong(PropsUtil.get("D2BiobankGroup"));
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		try {
			Company company = CompanyLocalServiceUtil.getCompany(companyId);
			serviceContext.setUserId(company.getDefaultUser().getUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		serviceContext.setCompanyId(companyId);
		serviceContext.setScopeGroupId(groupId);
		
		// Reading data from the LDAP
		Hashtable<String, String> environment = new Hashtable<String, String>();
		environment.put(LdapContext.CONTROL_FACTORIES,
				"com.sun.jndi.ldap.ControlFactory");
		environment.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		environment.put(Context.PROVIDER_URL,
				"ldap://directory.bbmri-eric.eu:10389");
		environment.put(Context.SECURITY_AUTHENTICATION, "simple");
		environment.put(Context.REFERRAL, "follow");
		try {
			d2biobank = D2BiobankLocalServiceUtil
					.getD2Biobank(biobankId);

			DirContext ctx = new InitialDirContext(environment);
			SearchControls ctls = new SearchControls();
			ctls.setReturningAttributes(null);
			ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			// Search for objects using filter and controls
			String filter = "biobankID="
					+ d2biobank.getBbmribiobankID() + ",c="
					+ d2biobank.getBiobankCountry().toLowerCase()
					+ ",ou=biobanks,dc=directory,dc=bbmri-eric,dc=eu";
			NamingEnumeration<?> answer = ctx.search(filter, "(objectclass=*)",
					ctls);
			int counter_collections = 0;
			int counter_biobanks = 0;
			while (answer.hasMore()) {
				SearchResult sr = (SearchResult) answer.next();
				Attributes attrs = sr.getAttributes();
				try {
					if (attrs.get("biobankID") != null) {
						counter_biobanks++;
						String ldapbiobankID = getAttributeValues(attrs
								.get("biobankID"));

						d2biobank = getD2BiobankFromLDAP(d2biobank, attrs);
						D2BiobankLocalServiceUtil.updateD2Biobank(d2biobank,
								serviceContext);
					} else {
						/*counter_collections++;
						String[] ldapid = LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionID")).split(":");
						String bbmricollectionID = LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionID"));
						String bbmribiobankID = "";
						String bbmriparentcollectionID = "";
						int idcount = 0;
						for(int count = ldapid.length-1; count >= 0; count--) {
							idcount ++;
							if(ldapid[count].equals("collection")) {
								if(idcount > 2) {
									for(int parentcounter = 0; parentcounter < ldapid.length-1; parentcounter++) {
										if(bbmriparentcollectionID.length() != 0) {
											bbmriparentcollectionID += ":";
										}
										bbmriparentcollectionID += ldapid[parentcounter];
									}
									break;
								} else {
									break;
								}
							}
						}
						for(int count = 0; count < ldapid.length-idcount; count++) {
							if(bbmribiobankID.length() != 0) {
								bbmribiobankID += ":";
							}
							bbmribiobankID += ldapid[count];
						}*/
						String id_string = sr.getNameInNamespace();
						String bbmricollectionID = LDAPAttributeEscaper.getAttributeValues(attrs.get("collectionID"));
						String bbmribiobankID = "";
						String bbmriparentcollectionID = "";
						
						String[] ldapid = id_string.split(",");
						boolean firstid = true;
						for(String id : ldapid) {
							if(firstid) {
								firstid = false;
								continue;
							}
							String[] title_id = id.split("=");
							if(title_id[0].equalsIgnoreCase("collectionID") && bbmriparentcollectionID.equals("")) {
								bbmriparentcollectionID = title_id[1];
								continue;
							}
							if(title_id[0].equalsIgnoreCase("biobankID")) {
								bbmribiobankID = title_id[1];
								break;
							}
						}
						long parentcollectionId = 0;
						if(!bbmriparentcollectionID.equals("")) {
							D2Collection parentcollection = D2CollectionLocalServiceUtil.getD2CollectionByBBMRIERICID(groupId, bbmriparentcollectionID, bbmribiobankID);
							if(parentcollection != null) {
								parentcollectionId = parentcollection.getD2collectionId();
							}
						}
						D2Collection collection = D2CollectionLocalServiceUtil.getD2CollectionByBBMRIERICID(groupId, bbmricollectionID, bbmribiobankID);
						if(collection == null) {	
							serviceContext.setCreateDate(new Date());
							collection = D2CollectionLocalServiceUtil.getD2CollectionFromLDAP(collection, attrs, sr);
							collection.setBiobankId(biobankId);
							collection.setParentd2collectionId(parentcollectionId);
							collection = D2CollectionLocalServiceUtil.addD2Collection(collection, serviceContext);
						} else {
							collection = D2CollectionLocalServiceUtil.getD2CollectionFromLDAP(collection, attrs, sr);
							collection.setBiobankId(biobankId);
							collection.setParentd2collectionId(parentcollectionId);
							collection = D2CollectionLocalServiceUtil.updateD2Collection(collection, serviceContext);
						}
					}
				} catch (Exception ex) {
					System.err
							.println("["
									+ date_format_apache_error
											.format(new Date())
									+ "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::connectLDAP] Error Creating Entrys for Biobank: "
									+ getAttributeValues(attrs
											.get("biobankName")));
					ex.printStackTrace();
				}
			}
			System.out.println("LDAP contained: " + counter_biobanks + " Biobanks and " + counter_collections + " Collections");
		} catch (Exception ex) {
			System.err
					.println("["
							+ date_format_apache_error.format(new Date())
							+ "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::connectLDAP] Error reading data from LDAP Server.");
			ex.printStackTrace();
		}
		return d2biobank;
	}
	
	public D2Biobank getD2BiobankFromLDAP(D2Biobank d2biobank, Attributes attrs) {
		d2biobank.setBiobankName(getAttributeValues(attrs.get("biobankName")));
        d2biobank.setContactIDRef(getAttributeValues(attrs.get("contactIDRef")));
        d2biobank.setContactPriority(getAttributeValuesLong(attrs.get("contactPriority")));
        d2biobank.setBiobankJurisdicalPerson(getAttributeValues(attrs.get("biobankJuridicalPerson")));
        String biobankCountry = getAttributeValues(attrs.get("biobankCountry"));
        d2biobank.setBiobankCountry(biobankCountry.toUpperCase());
        d2biobank.setBiobankPartnerCharterSigned(getAttributeValuesBoolean(attrs.get("biobankPartnerCharterSigned")));
        // Optional Fields
        d2biobank.setBioresourceReference(getAttributeValues(attrs.get("bioresourceReference")));
        d2biobank.setBiobankNetworkIDRef(getAttributeValues(attrs.get("biobankNetworkIDRef")));
        d2biobank.setGeoLatitude(getAttributeValues(attrs.get("geoLatitude")));
        d2biobank.setGeoLongitude(getAttributeValues(attrs.get("geoLongitude")));
        d2biobank.setCollaborationPartnersCommercial(getAttributeValuesBoolean(attrs.get("collaborationPartnersCommercial")));
        d2biobank.setCollaborationPartnersNonforprofit(getAttributeValuesBoolean(attrs.get("collaborationPartnersNonforprofit")));
        d2biobank.setBiobankITSupportAvailable(getAttributeValuesBoolean(attrs.get("biobankITSupportAvailable")));
        d2biobank.setBiobankITStaffSize(getAttributeValuesLong(attrs.get("biobankITStaffSize")));
        d2biobank.setBiobankISAvailable(getAttributeValuesBoolean(attrs.get("biobankISAvailable")));
        d2biobank.setBiobankHISAvailable(getAttributeValuesBoolean(attrs.get("biobankHISAvailable")));
        d2biobank.setBiobankAcronym(getAttributeValues(attrs.get("biobankAcronym")));
        d2biobank.setBiobankDescription(getAttributeValues(attrs.get("biobankDescription")));
        d2biobank.setBiobankURL(getAttributeValues(attrs.get("biobankURL")));
        d2biobank.setBiobankHeadFirstName(getAttributeValues(attrs.get("biobankHeadFirstName")));
        d2biobank.setBiobankHeadLastName(getAttributeValues(attrs.get("biobankHeadLastName")));
        d2biobank.setBiobankHeadRole(getAttributeValues(attrs.get("biobankHeadRole")));
        String types = getAttributeValues(attrs.get("objectClass"));
        d2biobank.setBiobankType(types);
        if(types.contains("biobankClinical")) {
        	d2biobank.setBiobankClinical(true);
        } else {
        	d2biobank.setBiobankClinical(false);
        }
        if(types.contains("biobankPopulation")) {
        	d2biobank.setBiobankPopulation(true);
        } else {
        	d2biobank.setBiobankPopulation(false);
        }
        if(types.contains("biobankResearchStudy")) {
        	d2biobank.setBiobankResearchStudy(true);
        } else {
        	d2biobank.setBiobankResearchStudy(false);
        }
        if(types.contains("biobankNonHuman")) {
        	d2biobank.setBiobankNonHuman(true);
        } else {
        	d2biobank.setBiobankNonHuman(false);
        }
        if(types.contains("biobankCollection")) {
        	d2biobank.setBiobankCollection(true);
        } else {
        	d2biobank.setBiobankCollection(false);
        }
        return d2biobank;
	}
	
	/**
	 * 
	 * @param attr
	 * @return
	 */
	private String getAttributeValues(Attribute attr) {
		String values = "";
		String seperator = "";
		try {
			for (NamingEnumeration e = attr.getAll(); e.hasMore(); ) {
				values += seperator + e.next();
				seperator = ", ";
			}
		} catch (Exception ex) {
			//System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::getAttributeValues] Error getting Attributes.");
			//ex.printStackTrace();
			return "";
		}
		return values; 
	}
	
	/**
	 * 
	 * @param attr
	 * @return
	 */
	private Long getAttributeValuesLong(Attribute attr) {
		String values = "";
		String seperator = "";
		long return_value = 0;
		try {
			for (NamingEnumeration e = attr.getAll(); e.hasMore(); ) {
				values += seperator + e.next();
				seperator = ", ";
			}
			return_value = Long.parseLong(values);
		} catch (Exception ex) {
			//System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::getAttributeValues] Error getting Attributes.");
			//ex.printStackTrace();
			return (long) 0;
		}
		return return_value; 
	}
	
	/**
	 * 
	 * @param attr
	 * @return
	 */
	private Boolean getAttributeValuesBoolean(Attribute attr) {
		String values = "";
		String seperator = "";
		boolean return_value = false;
		try {
			for (NamingEnumeration e = attr.getAll(); e.hasMore(); ) {
				values += seperator + e.next();
				seperator = ", ";
			}
			return_value = Boolean.parseBoolean(values);
		} catch (Exception ex) {
			//System.err.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.scheduler.LDAPSyncService::getAttributeValues] Error getting Attributes.");
			//ex.printStackTrace();
			return false;
		}
		return return_value; 
	}
}