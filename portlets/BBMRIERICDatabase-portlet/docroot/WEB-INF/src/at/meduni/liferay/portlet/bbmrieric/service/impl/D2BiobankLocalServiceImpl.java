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

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

import at.meduni.liferay.portlet.bbmrieric.model.D2Biobank;
import at.meduni.liferay.portlet.bbmrieric.model.impl.D2BiobankImpl;
import at.meduni.liferay.portlet.bbmrieric.service.base.D2BiobankLocalServiceBaseImpl;

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
				newbiobank.getBiobankCollection(), serviceContext);
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
			boolean biobankCollection, ServiceContext serviceContext) {
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
			boolean biobankCollection, ServiceContext serviceContext) {
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
	
	public List<D2Biobank> getLDAPNotUpdatedBiobanks(long groupId, String ldapupdateuuid) {
		try {
			return d2BiobankPersistence.filterFindByNotUUID(groupId, ldapupdateuuid);
		} catch (SystemException e) {
			System.out.println("[" + date_format_apache_error.format(new Date()) + "] [error] [BBMRIERICDatabase-portlet::at.meduni.liferay.portlet.bbmrieric.service.impl.D2BiobankLocalServiceImpl::getLDAPNotUpdatedBiobanks] Error getting Biobank List with updateId: " + ldapupdateuuid + ".");
			e.printStackTrace();
		}
		return null;
	}
}