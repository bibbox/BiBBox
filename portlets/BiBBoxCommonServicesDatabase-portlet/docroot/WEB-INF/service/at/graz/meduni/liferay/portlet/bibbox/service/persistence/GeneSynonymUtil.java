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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the gene synonym service. This utility wraps {@link GeneSynonymPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see GeneSynonymPersistence
 * @see GeneSynonymPersistenceImpl
 * @generated
 */
public class GeneSynonymUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(GeneSynonym geneSynonym) {
		getPersistence().clearCache(geneSynonym);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GeneSynonym> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GeneSynonym> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GeneSynonym> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GeneSynonym update(GeneSynonym geneSynonym)
		throws SystemException {
		return getPersistence().update(geneSynonym);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GeneSynonym update(GeneSynonym geneSynonym,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(geneSynonym, serviceContext);
	}

	/**
	* Caches the gene synonym in the entity cache if it is enabled.
	*
	* @param geneSynonym the gene synonym
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym geneSynonym) {
		getPersistence().cacheResult(geneSynonym);
	}

	/**
	* Caches the gene synonyms in the entity cache if it is enabled.
	*
	* @param geneSynonyms the gene synonyms
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym> geneSynonyms) {
		getPersistence().cacheResult(geneSynonyms);
	}

	/**
	* Creates a new gene synonym with the primary key. Does not add the gene synonym to the database.
	*
	* @param genesynonymId the primary key for the new gene synonym
	* @return the new gene synonym
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym create(
		long genesynonymId) {
		return getPersistence().create(genesynonymId);
	}

	/**
	* Removes the gene synonym with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param genesynonymId the primary key of the gene synonym
	* @return the gene synonym that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneSynonymException if a gene synonym with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym remove(
		long genesynonymId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneSynonymException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(genesynonymId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym geneSynonym)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(geneSynonym);
	}

	/**
	* Returns the gene synonym with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneSynonymException} if it could not be found.
	*
	* @param genesynonymId the primary key of the gene synonym
	* @return the gene synonym
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneSynonymException if a gene synonym with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym findByPrimaryKey(
		long genesynonymId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneSynonymException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(genesynonymId);
	}

	/**
	* Returns the gene synonym with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param genesynonymId the primary key of the gene synonym
	* @return the gene synonym, or <code>null</code> if a gene synonym with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym fetchByPrimaryKey(
		long genesynonymId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(genesynonymId);
	}

	/**
	* Returns all the gene synonyms.
	*
	* @return the gene synonyms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the gene synonyms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of gene synonyms.
	*
	* @return the number of gene synonyms
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GeneSynonymPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GeneSynonymPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.service.ClpSerializer.getServletContextName(),
					GeneSynonymPersistence.class.getName());

			ReferenceRegistry.registerReference(GeneSynonymUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GeneSynonymPersistence persistence) {
	}

	private static GeneSynonymPersistence _persistence;
}