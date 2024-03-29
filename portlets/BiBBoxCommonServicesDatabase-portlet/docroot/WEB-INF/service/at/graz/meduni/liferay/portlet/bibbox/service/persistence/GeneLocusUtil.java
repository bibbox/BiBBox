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

import at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the gene locus service. This utility wraps {@link GeneLocusPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see GeneLocusPersistence
 * @see GeneLocusPersistenceImpl
 * @generated
 */
public class GeneLocusUtil {
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
	public static void clearCache(GeneLocus geneLocus) {
		getPersistence().clearCache(geneLocus);
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
	public static List<GeneLocus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GeneLocus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GeneLocus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GeneLocus update(GeneLocus geneLocus)
		throws SystemException {
		return getPersistence().update(geneLocus);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GeneLocus update(GeneLocus geneLocus,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(geneLocus, serviceContext);
	}

	/**
	* Caches the gene locus in the entity cache if it is enabled.
	*
	* @param geneLocus the gene locus
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus geneLocus) {
		getPersistence().cacheResult(geneLocus);
	}

	/**
	* Caches the gene locuses in the entity cache if it is enabled.
	*
	* @param geneLocuses the gene locuses
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus> geneLocuses) {
		getPersistence().cacheResult(geneLocuses);
	}

	/**
	* Creates a new gene locus with the primary key. Does not add the gene locus to the database.
	*
	* @param genelocusId the primary key for the new gene locus
	* @return the new gene locus
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus create(
		long genelocusId) {
		return getPersistence().create(genelocusId);
	}

	/**
	* Removes the gene locus with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param genelocusId the primary key of the gene locus
	* @return the gene locus that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneLocusException if a gene locus with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus remove(
		long genelocusId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneLocusException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(genelocusId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus geneLocus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(geneLocus);
	}

	/**
	* Returns the gene locus with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneLocusException} if it could not be found.
	*
	* @param genelocusId the primary key of the gene locus
	* @return the gene locus
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneLocusException if a gene locus with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus findByPrimaryKey(
		long genelocusId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneLocusException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(genelocusId);
	}

	/**
	* Returns the gene locus with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param genelocusId the primary key of the gene locus
	* @return the gene locus, or <code>null</code> if a gene locus with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus fetchByPrimaryKey(
		long genelocusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(genelocusId);
	}

	/**
	* Returns all the gene locuses.
	*
	* @return the gene locuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the gene locuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneLocusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gene locuses
	* @param end the upper bound of the range of gene locuses (not inclusive)
	* @return the range of gene locuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the gene locuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneLocusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gene locuses
	* @param end the upper bound of the range of gene locuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of gene locuses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the gene locuses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of gene locuses.
	*
	* @return the number of gene locuses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GeneLocusPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GeneLocusPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.service.ClpSerializer.getServletContextName(),
					GeneLocusPersistence.class.getName());

			ReferenceRegistry.registerReference(GeneLocusUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GeneLocusPersistence persistence) {
	}

	private static GeneLocusPersistence _persistence;
}