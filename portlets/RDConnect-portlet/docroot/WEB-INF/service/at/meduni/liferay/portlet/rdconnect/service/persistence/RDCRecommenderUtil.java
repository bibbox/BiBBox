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

package at.meduni.liferay.portlet.rdconnect.service.persistence;

import at.meduni.liferay.portlet.rdconnect.model.RDCRecommender;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the r d c recommender service. This utility wraps {@link RDCRecommenderPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see RDCRecommenderPersistence
 * @see RDCRecommenderPersistenceImpl
 * @generated
 */
public class RDCRecommenderUtil {
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
	public static void clearCache(RDCRecommender rdcRecommender) {
		getPersistence().clearCache(rdcRecommender);
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
	public static List<RDCRecommender> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RDCRecommender> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RDCRecommender> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static RDCRecommender update(RDCRecommender rdcRecommender)
		throws SystemException {
		return getPersistence().update(rdcRecommender);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static RDCRecommender update(RDCRecommender rdcRecommender,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(rdcRecommender, serviceContext);
	}

	/**
	* Returns the r d c recommender where organisationId = &#63; and recommendedorganisationId = &#63; or throws a {@link at.meduni.liferay.portlet.rdconnect.NoSuchRDCRecommenderException} if it could not be found.
	*
	* @param organisationId the organisation ID
	* @param recommendedorganisationId the recommendedorganisation ID
	* @return the matching r d c recommender
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCRecommenderException if a matching r d c recommender could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.RDCRecommender findByRecommendation(
		long organisationId, long recommendedorganisationId)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCRecommenderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRecommendation(organisationId,
			recommendedorganisationId);
	}

	/**
	* Returns the r d c recommender where organisationId = &#63; and recommendedorganisationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param organisationId the organisation ID
	* @param recommendedorganisationId the recommendedorganisation ID
	* @return the matching r d c recommender, or <code>null</code> if a matching r d c recommender could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.RDCRecommender fetchByRecommendation(
		long organisationId, long recommendedorganisationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRecommendation(organisationId,
			recommendedorganisationId);
	}

	/**
	* Returns the r d c recommender where organisationId = &#63; and recommendedorganisationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param organisationId the organisation ID
	* @param recommendedorganisationId the recommendedorganisation ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching r d c recommender, or <code>null</code> if a matching r d c recommender could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.RDCRecommender fetchByRecommendation(
		long organisationId, long recommendedorganisationId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRecommendation(organisationId,
			recommendedorganisationId, retrieveFromCache);
	}

	/**
	* Removes the r d c recommender where organisationId = &#63; and recommendedorganisationId = &#63; from the database.
	*
	* @param organisationId the organisation ID
	* @param recommendedorganisationId the recommendedorganisation ID
	* @return the r d c recommender that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.RDCRecommender removeByRecommendation(
		long organisationId, long recommendedorganisationId)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCRecommenderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByRecommendation(organisationId,
			recommendedorganisationId);
	}

	/**
	* Returns the number of r d c recommenders where organisationId = &#63; and recommendedorganisationId = &#63;.
	*
	* @param organisationId the organisation ID
	* @param recommendedorganisationId the recommendedorganisation ID
	* @return the number of matching r d c recommenders
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRecommendation(long organisationId,
		long recommendedorganisationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByRecommendation(organisationId,
			recommendedorganisationId);
	}

	/**
	* Caches the r d c recommender in the entity cache if it is enabled.
	*
	* @param rdcRecommender the r d c recommender
	*/
	public static void cacheResult(
		at.meduni.liferay.portlet.rdconnect.model.RDCRecommender rdcRecommender) {
		getPersistence().cacheResult(rdcRecommender);
	}

	/**
	* Caches the r d c recommenders in the entity cache if it is enabled.
	*
	* @param rdcRecommenders the r d c recommenders
	*/
	public static void cacheResult(
		java.util.List<at.meduni.liferay.portlet.rdconnect.model.RDCRecommender> rdcRecommenders) {
		getPersistence().cacheResult(rdcRecommenders);
	}

	/**
	* Creates a new r d c recommender with the primary key. Does not add the r d c recommender to the database.
	*
	* @param rdcrecommenderid the primary key for the new r d c recommender
	* @return the new r d c recommender
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.RDCRecommender create(
		long rdcrecommenderid) {
		return getPersistence().create(rdcrecommenderid);
	}

	/**
	* Removes the r d c recommender with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param rdcrecommenderid the primary key of the r d c recommender
	* @return the r d c recommender that was removed
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCRecommenderException if a r d c recommender with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.RDCRecommender remove(
		long rdcrecommenderid)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCRecommenderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(rdcrecommenderid);
	}

	public static at.meduni.liferay.portlet.rdconnect.model.RDCRecommender updateImpl(
		at.meduni.liferay.portlet.rdconnect.model.RDCRecommender rdcRecommender)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(rdcRecommender);
	}

	/**
	* Returns the r d c recommender with the primary key or throws a {@link at.meduni.liferay.portlet.rdconnect.NoSuchRDCRecommenderException} if it could not be found.
	*
	* @param rdcrecommenderid the primary key of the r d c recommender
	* @return the r d c recommender
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCRecommenderException if a r d c recommender with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.RDCRecommender findByPrimaryKey(
		long rdcrecommenderid)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchRDCRecommenderException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(rdcrecommenderid);
	}

	/**
	* Returns the r d c recommender with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param rdcrecommenderid the primary key of the r d c recommender
	* @return the r d c recommender, or <code>null</code> if a r d c recommender with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.RDCRecommender fetchByPrimaryKey(
		long rdcrecommenderid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(rdcrecommenderid);
	}

	/**
	* Returns all the r d c recommenders.
	*
	* @return the r d c recommenders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.RDCRecommender> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the r d c recommenders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.RDCRecommenderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of r d c recommenders
	* @param end the upper bound of the range of r d c recommenders (not inclusive)
	* @return the range of r d c recommenders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.RDCRecommender> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the r d c recommenders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.RDCRecommenderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of r d c recommenders
	* @param end the upper bound of the range of r d c recommenders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of r d c recommenders
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.RDCRecommender> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the r d c recommenders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of r d c recommenders.
	*
	* @return the number of r d c recommenders
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RDCRecommenderPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RDCRecommenderPersistence)PortletBeanLocatorUtil.locate(at.meduni.liferay.portlet.rdconnect.service.ClpSerializer.getServletContextName(),
					RDCRecommenderPersistence.class.getName());

			ReferenceRegistry.registerReference(RDCRecommenderUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RDCRecommenderPersistence persistence) {
	}

	private static RDCRecommenderPersistence _persistence;
}