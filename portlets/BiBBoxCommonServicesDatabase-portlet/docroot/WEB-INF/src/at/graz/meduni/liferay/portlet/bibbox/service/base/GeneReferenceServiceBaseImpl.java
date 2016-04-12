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

package at.graz.meduni.liferay.portlet.bibbox.service.base;

import at.graz.meduni.liferay.portlet.bibbox.model.GeneReference;
import at.graz.meduni.liferay.portlet.bibbox.service.GeneReferenceService;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.DDLConfigurationPersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.GeneLocusPersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.GenePersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.GeneReferencePersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.GeneSynonymPersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.IconConfigurationPersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.IconsPersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.OrganizationSearchIndexPersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.OrphanetDisorderPersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.OrphanetReferencePersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.OrphanetSynonymPersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.SymbolConfigurationPersistence;
import at.graz.meduni.liferay.portlet.bibbox.service.persistence.SymbolTypeConfigurationPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the gene reference remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link at.graz.meduni.liferay.portlet.bibbox.service.impl.GeneReferenceServiceImpl}.
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.bibbox.service.impl.GeneReferenceServiceImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.GeneReferenceServiceUtil
 * @generated
 */
public abstract class GeneReferenceServiceBaseImpl extends BaseServiceImpl
	implements GeneReferenceService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link at.graz.meduni.liferay.portlet.bibbox.service.GeneReferenceServiceUtil} to access the gene reference remote service.
	 */

	/**
	 * Returns the d d l configuration local service.
	 *
	 * @return the d d l configuration local service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationLocalService getDDLConfigurationLocalService() {
		return ddlConfigurationLocalService;
	}

	/**
	 * Sets the d d l configuration local service.
	 *
	 * @param ddlConfigurationLocalService the d d l configuration local service
	 */
	public void setDDLConfigurationLocalService(
		at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationLocalService ddlConfigurationLocalService) {
		this.ddlConfigurationLocalService = ddlConfigurationLocalService;
	}

	/**
	 * Returns the d d l configuration remote service.
	 *
	 * @return the d d l configuration remote service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationService getDDLConfigurationService() {
		return ddlConfigurationService;
	}

	/**
	 * Sets the d d l configuration remote service.
	 *
	 * @param ddlConfigurationService the d d l configuration remote service
	 */
	public void setDDLConfigurationService(
		at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationService ddlConfigurationService) {
		this.ddlConfigurationService = ddlConfigurationService;
	}

	/**
	 * Returns the d d l configuration persistence.
	 *
	 * @return the d d l configuration persistence
	 */
	public DDLConfigurationPersistence getDDLConfigurationPersistence() {
		return ddlConfigurationPersistence;
	}

	/**
	 * Sets the d d l configuration persistence.
	 *
	 * @param ddlConfigurationPersistence the d d l configuration persistence
	 */
	public void setDDLConfigurationPersistence(
		DDLConfigurationPersistence ddlConfigurationPersistence) {
		this.ddlConfigurationPersistence = ddlConfigurationPersistence;
	}

	/**
	 * Returns the gene local service.
	 *
	 * @return the gene local service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.GeneLocalService getGeneLocalService() {
		return geneLocalService;
	}

	/**
	 * Sets the gene local service.
	 *
	 * @param geneLocalService the gene local service
	 */
	public void setGeneLocalService(
		at.graz.meduni.liferay.portlet.bibbox.service.GeneLocalService geneLocalService) {
		this.geneLocalService = geneLocalService;
	}

	/**
	 * Returns the gene remote service.
	 *
	 * @return the gene remote service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.GeneService getGeneService() {
		return geneService;
	}

	/**
	 * Sets the gene remote service.
	 *
	 * @param geneService the gene remote service
	 */
	public void setGeneService(
		at.graz.meduni.liferay.portlet.bibbox.service.GeneService geneService) {
		this.geneService = geneService;
	}

	/**
	 * Returns the gene persistence.
	 *
	 * @return the gene persistence
	 */
	public GenePersistence getGenePersistence() {
		return genePersistence;
	}

	/**
	 * Sets the gene persistence.
	 *
	 * @param genePersistence the gene persistence
	 */
	public void setGenePersistence(GenePersistence genePersistence) {
		this.genePersistence = genePersistence;
	}

	/**
	 * Returns the gene locus local service.
	 *
	 * @return the gene locus local service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.GeneLocusLocalService getGeneLocusLocalService() {
		return geneLocusLocalService;
	}

	/**
	 * Sets the gene locus local service.
	 *
	 * @param geneLocusLocalService the gene locus local service
	 */
	public void setGeneLocusLocalService(
		at.graz.meduni.liferay.portlet.bibbox.service.GeneLocusLocalService geneLocusLocalService) {
		this.geneLocusLocalService = geneLocusLocalService;
	}

	/**
	 * Returns the gene locus remote service.
	 *
	 * @return the gene locus remote service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.GeneLocusService getGeneLocusService() {
		return geneLocusService;
	}

	/**
	 * Sets the gene locus remote service.
	 *
	 * @param geneLocusService the gene locus remote service
	 */
	public void setGeneLocusService(
		at.graz.meduni.liferay.portlet.bibbox.service.GeneLocusService geneLocusService) {
		this.geneLocusService = geneLocusService;
	}

	/**
	 * Returns the gene locus persistence.
	 *
	 * @return the gene locus persistence
	 */
	public GeneLocusPersistence getGeneLocusPersistence() {
		return geneLocusPersistence;
	}

	/**
	 * Sets the gene locus persistence.
	 *
	 * @param geneLocusPersistence the gene locus persistence
	 */
	public void setGeneLocusPersistence(
		GeneLocusPersistence geneLocusPersistence) {
		this.geneLocusPersistence = geneLocusPersistence;
	}

	/**
	 * Returns the gene reference local service.
	 *
	 * @return the gene reference local service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.GeneReferenceLocalService getGeneReferenceLocalService() {
		return geneReferenceLocalService;
	}

	/**
	 * Sets the gene reference local service.
	 *
	 * @param geneReferenceLocalService the gene reference local service
	 */
	public void setGeneReferenceLocalService(
		at.graz.meduni.liferay.portlet.bibbox.service.GeneReferenceLocalService geneReferenceLocalService) {
		this.geneReferenceLocalService = geneReferenceLocalService;
	}

	/**
	 * Returns the gene reference remote service.
	 *
	 * @return the gene reference remote service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.GeneReferenceService getGeneReferenceService() {
		return geneReferenceService;
	}

	/**
	 * Sets the gene reference remote service.
	 *
	 * @param geneReferenceService the gene reference remote service
	 */
	public void setGeneReferenceService(
		at.graz.meduni.liferay.portlet.bibbox.service.GeneReferenceService geneReferenceService) {
		this.geneReferenceService = geneReferenceService;
	}

	/**
	 * Returns the gene reference persistence.
	 *
	 * @return the gene reference persistence
	 */
	public GeneReferencePersistence getGeneReferencePersistence() {
		return geneReferencePersistence;
	}

	/**
	 * Sets the gene reference persistence.
	 *
	 * @param geneReferencePersistence the gene reference persistence
	 */
	public void setGeneReferencePersistence(
		GeneReferencePersistence geneReferencePersistence) {
		this.geneReferencePersistence = geneReferencePersistence;
	}

	/**
	 * Returns the gene synonym local service.
	 *
	 * @return the gene synonym local service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.GeneSynonymLocalService getGeneSynonymLocalService() {
		return geneSynonymLocalService;
	}

	/**
	 * Sets the gene synonym local service.
	 *
	 * @param geneSynonymLocalService the gene synonym local service
	 */
	public void setGeneSynonymLocalService(
		at.graz.meduni.liferay.portlet.bibbox.service.GeneSynonymLocalService geneSynonymLocalService) {
		this.geneSynonymLocalService = geneSynonymLocalService;
	}

	/**
	 * Returns the gene synonym remote service.
	 *
	 * @return the gene synonym remote service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.GeneSynonymService getGeneSynonymService() {
		return geneSynonymService;
	}

	/**
	 * Sets the gene synonym remote service.
	 *
	 * @param geneSynonymService the gene synonym remote service
	 */
	public void setGeneSynonymService(
		at.graz.meduni.liferay.portlet.bibbox.service.GeneSynonymService geneSynonymService) {
		this.geneSynonymService = geneSynonymService;
	}

	/**
	 * Returns the gene synonym persistence.
	 *
	 * @return the gene synonym persistence
	 */
	public GeneSynonymPersistence getGeneSynonymPersistence() {
		return geneSynonymPersistence;
	}

	/**
	 * Sets the gene synonym persistence.
	 *
	 * @param geneSynonymPersistence the gene synonym persistence
	 */
	public void setGeneSynonymPersistence(
		GeneSynonymPersistence geneSynonymPersistence) {
		this.geneSynonymPersistence = geneSynonymPersistence;
	}

	/**
	 * Returns the icon configuration local service.
	 *
	 * @return the icon configuration local service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationLocalService getIconConfigurationLocalService() {
		return iconConfigurationLocalService;
	}

	/**
	 * Sets the icon configuration local service.
	 *
	 * @param iconConfigurationLocalService the icon configuration local service
	 */
	public void setIconConfigurationLocalService(
		at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationLocalService iconConfigurationLocalService) {
		this.iconConfigurationLocalService = iconConfigurationLocalService;
	}

	/**
	 * Returns the icon configuration remote service.
	 *
	 * @return the icon configuration remote service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationService getIconConfigurationService() {
		return iconConfigurationService;
	}

	/**
	 * Sets the icon configuration remote service.
	 *
	 * @param iconConfigurationService the icon configuration remote service
	 */
	public void setIconConfigurationService(
		at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationService iconConfigurationService) {
		this.iconConfigurationService = iconConfigurationService;
	}

	/**
	 * Returns the icon configuration persistence.
	 *
	 * @return the icon configuration persistence
	 */
	public IconConfigurationPersistence getIconConfigurationPersistence() {
		return iconConfigurationPersistence;
	}

	/**
	 * Sets the icon configuration persistence.
	 *
	 * @param iconConfigurationPersistence the icon configuration persistence
	 */
	public void setIconConfigurationPersistence(
		IconConfigurationPersistence iconConfigurationPersistence) {
		this.iconConfigurationPersistence = iconConfigurationPersistence;
	}

	/**
	 * Returns the icons local service.
	 *
	 * @return the icons local service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.IconsLocalService getIconsLocalService() {
		return iconsLocalService;
	}

	/**
	 * Sets the icons local service.
	 *
	 * @param iconsLocalService the icons local service
	 */
	public void setIconsLocalService(
		at.graz.meduni.liferay.portlet.bibbox.service.IconsLocalService iconsLocalService) {
		this.iconsLocalService = iconsLocalService;
	}

	/**
	 * Returns the icons remote service.
	 *
	 * @return the icons remote service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.IconsService getIconsService() {
		return iconsService;
	}

	/**
	 * Sets the icons remote service.
	 *
	 * @param iconsService the icons remote service
	 */
	public void setIconsService(
		at.graz.meduni.liferay.portlet.bibbox.service.IconsService iconsService) {
		this.iconsService = iconsService;
	}

	/**
	 * Returns the icons persistence.
	 *
	 * @return the icons persistence
	 */
	public IconsPersistence getIconsPersistence() {
		return iconsPersistence;
	}

	/**
	 * Sets the icons persistence.
	 *
	 * @param iconsPersistence the icons persistence
	 */
	public void setIconsPersistence(IconsPersistence iconsPersistence) {
		this.iconsPersistence = iconsPersistence;
	}

	/**
	 * Returns the organization search index local service.
	 *
	 * @return the organization search index local service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.OrganizationSearchIndexLocalService getOrganizationSearchIndexLocalService() {
		return organizationSearchIndexLocalService;
	}

	/**
	 * Sets the organization search index local service.
	 *
	 * @param organizationSearchIndexLocalService the organization search index local service
	 */
	public void setOrganizationSearchIndexLocalService(
		at.graz.meduni.liferay.portlet.bibbox.service.OrganizationSearchIndexLocalService organizationSearchIndexLocalService) {
		this.organizationSearchIndexLocalService = organizationSearchIndexLocalService;
	}

	/**
	 * Returns the organization search index persistence.
	 *
	 * @return the organization search index persistence
	 */
	public OrganizationSearchIndexPersistence getOrganizationSearchIndexPersistence() {
		return organizationSearchIndexPersistence;
	}

	/**
	 * Sets the organization search index persistence.
	 *
	 * @param organizationSearchIndexPersistence the organization search index persistence
	 */
	public void setOrganizationSearchIndexPersistence(
		OrganizationSearchIndexPersistence organizationSearchIndexPersistence) {
		this.organizationSearchIndexPersistence = organizationSearchIndexPersistence;
	}

	/**
	 * Returns the orphanet disorder local service.
	 *
	 * @return the orphanet disorder local service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.OrphanetDisorderLocalService getOrphanetDisorderLocalService() {
		return orphanetDisorderLocalService;
	}

	/**
	 * Sets the orphanet disorder local service.
	 *
	 * @param orphanetDisorderLocalService the orphanet disorder local service
	 */
	public void setOrphanetDisorderLocalService(
		at.graz.meduni.liferay.portlet.bibbox.service.OrphanetDisorderLocalService orphanetDisorderLocalService) {
		this.orphanetDisorderLocalService = orphanetDisorderLocalService;
	}

	/**
	 * Returns the orphanet disorder remote service.
	 *
	 * @return the orphanet disorder remote service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.OrphanetDisorderService getOrphanetDisorderService() {
		return orphanetDisorderService;
	}

	/**
	 * Sets the orphanet disorder remote service.
	 *
	 * @param orphanetDisorderService the orphanet disorder remote service
	 */
	public void setOrphanetDisorderService(
		at.graz.meduni.liferay.portlet.bibbox.service.OrphanetDisorderService orphanetDisorderService) {
		this.orphanetDisorderService = orphanetDisorderService;
	}

	/**
	 * Returns the orphanet disorder persistence.
	 *
	 * @return the orphanet disorder persistence
	 */
	public OrphanetDisorderPersistence getOrphanetDisorderPersistence() {
		return orphanetDisorderPersistence;
	}

	/**
	 * Sets the orphanet disorder persistence.
	 *
	 * @param orphanetDisorderPersistence the orphanet disorder persistence
	 */
	public void setOrphanetDisorderPersistence(
		OrphanetDisorderPersistence orphanetDisorderPersistence) {
		this.orphanetDisorderPersistence = orphanetDisorderPersistence;
	}

	/**
	 * Returns the orphanet reference local service.
	 *
	 * @return the orphanet reference local service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.OrphanetReferenceLocalService getOrphanetReferenceLocalService() {
		return orphanetReferenceLocalService;
	}

	/**
	 * Sets the orphanet reference local service.
	 *
	 * @param orphanetReferenceLocalService the orphanet reference local service
	 */
	public void setOrphanetReferenceLocalService(
		at.graz.meduni.liferay.portlet.bibbox.service.OrphanetReferenceLocalService orphanetReferenceLocalService) {
		this.orphanetReferenceLocalService = orphanetReferenceLocalService;
	}

	/**
	 * Returns the orphanet reference remote service.
	 *
	 * @return the orphanet reference remote service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.OrphanetReferenceService getOrphanetReferenceService() {
		return orphanetReferenceService;
	}

	/**
	 * Sets the orphanet reference remote service.
	 *
	 * @param orphanetReferenceService the orphanet reference remote service
	 */
	public void setOrphanetReferenceService(
		at.graz.meduni.liferay.portlet.bibbox.service.OrphanetReferenceService orphanetReferenceService) {
		this.orphanetReferenceService = orphanetReferenceService;
	}

	/**
	 * Returns the orphanet reference persistence.
	 *
	 * @return the orphanet reference persistence
	 */
	public OrphanetReferencePersistence getOrphanetReferencePersistence() {
		return orphanetReferencePersistence;
	}

	/**
	 * Sets the orphanet reference persistence.
	 *
	 * @param orphanetReferencePersistence the orphanet reference persistence
	 */
	public void setOrphanetReferencePersistence(
		OrphanetReferencePersistence orphanetReferencePersistence) {
		this.orphanetReferencePersistence = orphanetReferencePersistence;
	}

	/**
	 * Returns the orphanet synonym local service.
	 *
	 * @return the orphanet synonym local service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.OrphanetSynonymLocalService getOrphanetSynonymLocalService() {
		return orphanetSynonymLocalService;
	}

	/**
	 * Sets the orphanet synonym local service.
	 *
	 * @param orphanetSynonymLocalService the orphanet synonym local service
	 */
	public void setOrphanetSynonymLocalService(
		at.graz.meduni.liferay.portlet.bibbox.service.OrphanetSynonymLocalService orphanetSynonymLocalService) {
		this.orphanetSynonymLocalService = orphanetSynonymLocalService;
	}

	/**
	 * Returns the orphanet synonym remote service.
	 *
	 * @return the orphanet synonym remote service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.OrphanetSynonymService getOrphanetSynonymService() {
		return orphanetSynonymService;
	}

	/**
	 * Sets the orphanet synonym remote service.
	 *
	 * @param orphanetSynonymService the orphanet synonym remote service
	 */
	public void setOrphanetSynonymService(
		at.graz.meduni.liferay.portlet.bibbox.service.OrphanetSynonymService orphanetSynonymService) {
		this.orphanetSynonymService = orphanetSynonymService;
	}

	/**
	 * Returns the orphanet synonym persistence.
	 *
	 * @return the orphanet synonym persistence
	 */
	public OrphanetSynonymPersistence getOrphanetSynonymPersistence() {
		return orphanetSynonymPersistence;
	}

	/**
	 * Sets the orphanet synonym persistence.
	 *
	 * @param orphanetSynonymPersistence the orphanet synonym persistence
	 */
	public void setOrphanetSynonymPersistence(
		OrphanetSynonymPersistence orphanetSynonymPersistence) {
		this.orphanetSynonymPersistence = orphanetSynonymPersistence;
	}

	/**
	 * Returns the symbol configuration local service.
	 *
	 * @return the symbol configuration local service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationLocalService getSymbolConfigurationLocalService() {
		return symbolConfigurationLocalService;
	}

	/**
	 * Sets the symbol configuration local service.
	 *
	 * @param symbolConfigurationLocalService the symbol configuration local service
	 */
	public void setSymbolConfigurationLocalService(
		at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationLocalService symbolConfigurationLocalService) {
		this.symbolConfigurationLocalService = symbolConfigurationLocalService;
	}

	/**
	 * Returns the symbol configuration remote service.
	 *
	 * @return the symbol configuration remote service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationService getSymbolConfigurationService() {
		return symbolConfigurationService;
	}

	/**
	 * Sets the symbol configuration remote service.
	 *
	 * @param symbolConfigurationService the symbol configuration remote service
	 */
	public void setSymbolConfigurationService(
		at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationService symbolConfigurationService) {
		this.symbolConfigurationService = symbolConfigurationService;
	}

	/**
	 * Returns the symbol configuration persistence.
	 *
	 * @return the symbol configuration persistence
	 */
	public SymbolConfigurationPersistence getSymbolConfigurationPersistence() {
		return symbolConfigurationPersistence;
	}

	/**
	 * Sets the symbol configuration persistence.
	 *
	 * @param symbolConfigurationPersistence the symbol configuration persistence
	 */
	public void setSymbolConfigurationPersistence(
		SymbolConfigurationPersistence symbolConfigurationPersistence) {
		this.symbolConfigurationPersistence = symbolConfigurationPersistence;
	}

	/**
	 * Returns the symbol type configuration local service.
	 *
	 * @return the symbol type configuration local service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalService getSymbolTypeConfigurationLocalService() {
		return symbolTypeConfigurationLocalService;
	}

	/**
	 * Sets the symbol type configuration local service.
	 *
	 * @param symbolTypeConfigurationLocalService the symbol type configuration local service
	 */
	public void setSymbolTypeConfigurationLocalService(
		at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalService symbolTypeConfigurationLocalService) {
		this.symbolTypeConfigurationLocalService = symbolTypeConfigurationLocalService;
	}

	/**
	 * Returns the symbol type configuration remote service.
	 *
	 * @return the symbol type configuration remote service
	 */
	public at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationService getSymbolTypeConfigurationService() {
		return symbolTypeConfigurationService;
	}

	/**
	 * Sets the symbol type configuration remote service.
	 *
	 * @param symbolTypeConfigurationService the symbol type configuration remote service
	 */
	public void setSymbolTypeConfigurationService(
		at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationService symbolTypeConfigurationService) {
		this.symbolTypeConfigurationService = symbolTypeConfigurationService;
	}

	/**
	 * Returns the symbol type configuration persistence.
	 *
	 * @return the symbol type configuration persistence
	 */
	public SymbolTypeConfigurationPersistence getSymbolTypeConfigurationPersistence() {
		return symbolTypeConfigurationPersistence;
	}

	/**
	 * Sets the symbol type configuration persistence.
	 *
	 * @param symbolTypeConfigurationPersistence the symbol type configuration persistence
	 */
	public void setSymbolTypeConfigurationPersistence(
		SymbolTypeConfigurationPersistence symbolTypeConfigurationPersistence) {
		this.symbolTypeConfigurationPersistence = symbolTypeConfigurationPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return GeneReference.class;
	}

	protected String getModelClassName() {
		return GeneReference.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = geneReferencePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationLocalService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationLocalService ddlConfigurationLocalService;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.DDLConfigurationService ddlConfigurationService;
	@BeanReference(type = DDLConfigurationPersistence.class)
	protected DDLConfigurationPersistence ddlConfigurationPersistence;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.GeneLocalService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.GeneLocalService geneLocalService;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.GeneService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.GeneService geneService;
	@BeanReference(type = GenePersistence.class)
	protected GenePersistence genePersistence;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.GeneLocusLocalService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.GeneLocusLocalService geneLocusLocalService;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.GeneLocusService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.GeneLocusService geneLocusService;
	@BeanReference(type = GeneLocusPersistence.class)
	protected GeneLocusPersistence geneLocusPersistence;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.GeneReferenceLocalService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.GeneReferenceLocalService geneReferenceLocalService;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.GeneReferenceService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.GeneReferenceService geneReferenceService;
	@BeanReference(type = GeneReferencePersistence.class)
	protected GeneReferencePersistence geneReferencePersistence;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.GeneSynonymLocalService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.GeneSynonymLocalService geneSynonymLocalService;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.GeneSynonymService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.GeneSynonymService geneSynonymService;
	@BeanReference(type = GeneSynonymPersistence.class)
	protected GeneSynonymPersistence geneSynonymPersistence;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationLocalService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationLocalService iconConfigurationLocalService;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.IconConfigurationService iconConfigurationService;
	@BeanReference(type = IconConfigurationPersistence.class)
	protected IconConfigurationPersistence iconConfigurationPersistence;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.IconsLocalService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.IconsLocalService iconsLocalService;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.IconsService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.IconsService iconsService;
	@BeanReference(type = IconsPersistence.class)
	protected IconsPersistence iconsPersistence;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.OrganizationSearchIndexLocalService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.OrganizationSearchIndexLocalService organizationSearchIndexLocalService;
	@BeanReference(type = OrganizationSearchIndexPersistence.class)
	protected OrganizationSearchIndexPersistence organizationSearchIndexPersistence;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.OrphanetDisorderLocalService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.OrphanetDisorderLocalService orphanetDisorderLocalService;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.OrphanetDisorderService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.OrphanetDisorderService orphanetDisorderService;
	@BeanReference(type = OrphanetDisorderPersistence.class)
	protected OrphanetDisorderPersistence orphanetDisorderPersistence;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.OrphanetReferenceLocalService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.OrphanetReferenceLocalService orphanetReferenceLocalService;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.OrphanetReferenceService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.OrphanetReferenceService orphanetReferenceService;
	@BeanReference(type = OrphanetReferencePersistence.class)
	protected OrphanetReferencePersistence orphanetReferencePersistence;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.OrphanetSynonymLocalService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.OrphanetSynonymLocalService orphanetSynonymLocalService;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.OrphanetSynonymService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.OrphanetSynonymService orphanetSynonymService;
	@BeanReference(type = OrphanetSynonymPersistence.class)
	protected OrphanetSynonymPersistence orphanetSynonymPersistence;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationLocalService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationLocalService symbolConfigurationLocalService;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.SymbolConfigurationService symbolConfigurationService;
	@BeanReference(type = SymbolConfigurationPersistence.class)
	protected SymbolConfigurationPersistence symbolConfigurationPersistence;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationLocalService symbolTypeConfigurationLocalService;
	@BeanReference(type = at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationService.class)
	protected at.graz.meduni.liferay.portlet.bibbox.service.SymbolTypeConfigurationService symbolTypeConfigurationService;
	@BeanReference(type = SymbolTypeConfigurationPersistence.class)
	protected SymbolTypeConfigurationPersistence symbolTypeConfigurationPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private GeneReferenceServiceClpInvoker _clpInvoker = new GeneReferenceServiceClpInvoker();
}