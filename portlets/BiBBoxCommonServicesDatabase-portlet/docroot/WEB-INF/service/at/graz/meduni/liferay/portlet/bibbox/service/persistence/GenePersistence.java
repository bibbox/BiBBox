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

package at.graz.meduni.liferay.portlet.bibbox.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.model.Gene;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the gene service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see GenePersistenceImpl
 * @see GeneUtil
 * @generated
 */
public interface GenePersistence extends BasePersistence<Gene> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GeneUtil} to access the gene persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the gene in the entity cache if it is enabled.
	*
	* @param gene the gene
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.model.Gene gene);

	/**
	* Caches the genes in the entity cache if it is enabled.
	*
	* @param genes the genes
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.Gene> genes);

	/**
	* Creates a new gene with the primary key. Does not add the gene to the database.
	*
	* @param geneId the primary key for the new gene
	* @return the new gene
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.Gene create(long geneId);

	/**
	* Removes the gene with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geneId the primary key of the gene
	* @return the gene that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneException if a gene with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.Gene remove(long geneId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bibbox.model.Gene updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.Gene gene)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the gene with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneException} if it could not be found.
	*
	* @param geneId the primary key of the gene
	* @return the gene
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneException if a gene with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.Gene findByPrimaryKey(
		long geneId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the gene with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param geneId the primary key of the gene
	* @return the gene, or <code>null</code> if a gene with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.Gene fetchByPrimaryKey(
		long geneId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the genes.
	*
	* @return the genes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.Gene> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the genes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of genes
	* @param end the upper bound of the range of genes (not inclusive)
	* @return the range of genes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.Gene> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the genes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of genes
	* @param end the upper bound of the range of genes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of genes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.Gene> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the genes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of genes.
	*
	* @return the number of genes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}