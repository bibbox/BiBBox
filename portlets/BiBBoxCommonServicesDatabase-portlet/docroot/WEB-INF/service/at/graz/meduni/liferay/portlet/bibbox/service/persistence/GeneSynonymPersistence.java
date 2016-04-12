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

import at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the gene synonym service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see GeneSynonymPersistenceImpl
 * @see GeneSynonymUtil
 * @generated
 */
public interface GeneSynonymPersistence extends BasePersistence<GeneSynonym> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GeneSynonymUtil} to access the gene synonym persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the gene synonym in the entity cache if it is enabled.
	*
	* @param geneSynonym the gene synonym
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym geneSynonym);

	/**
	* Caches the gene synonyms in the entity cache if it is enabled.
	*
	* @param geneSynonyms the gene synonyms
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym> geneSynonyms);

	/**
	* Creates a new gene synonym with the primary key. Does not add the gene synonym to the database.
	*
	* @param genesynonymId the primary key for the new gene synonym
	* @return the new gene synonym
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym create(
		long genesynonymId);

	/**
	* Removes the gene synonym with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param genesynonymId the primary key of the gene synonym
	* @return the gene synonym that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneSynonymException if a gene synonym with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym remove(
		long genesynonymId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneSynonymException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym geneSynonym)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the gene synonym with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneSynonymException} if it could not be found.
	*
	* @param genesynonymId the primary key of the gene synonym
	* @return the gene synonym
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneSynonymException if a gene synonym with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym findByPrimaryKey(
		long genesynonymId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneSynonymException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the gene synonym with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param genesynonymId the primary key of the gene synonym
	* @return the gene synonym, or <code>null</code> if a gene synonym with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym fetchByPrimaryKey(
		long genesynonymId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the gene synonyms.
	*
	* @return the gene synonyms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the gene synonyms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneSynonymModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gene synonyms
	* @param end the upper bound of the range of gene synonyms (not inclusive)
	* @return the range of gene synonyms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the gene synonyms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneSynonymModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gene synonyms
	* @param end the upper bound of the range of gene synonyms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of gene synonyms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the gene synonyms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of gene synonyms.
	*
	* @return the number of gene synonyms
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}