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

import at.meduni.liferay.portlet.rdconnect.model.AQRRating;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the a q r rating service. This utility wraps {@link AQRRatingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see AQRRatingPersistence
 * @see AQRRatingPersistenceImpl
 * @generated
 */
public class AQRRatingUtil {
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
	public static void clearCache(AQRRating aqrRating) {
		getPersistence().clearCache(aqrRating);
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
	public static List<AQRRating> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AQRRating> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AQRRating> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AQRRating update(AQRRating aqrRating)
		throws SystemException {
		return getPersistence().update(aqrRating);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AQRRating update(AQRRating aqrRating,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(aqrRating, serviceContext);
	}

	/**
	* Returns all the a q r ratings where masterCandidateId = &#63;.
	*
	* @param masterCandidateId the master candidate ID
	* @return the matching a q r ratings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.AQRRating> findByMaster(
		long masterCandidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMaster(masterCandidateId);
	}

	/**
	* Returns a range of all the a q r ratings where masterCandidateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.AQRRatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param masterCandidateId the master candidate ID
	* @param start the lower bound of the range of a q r ratings
	* @param end the upper bound of the range of a q r ratings (not inclusive)
	* @return the range of matching a q r ratings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.AQRRating> findByMaster(
		long masterCandidateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMaster(masterCandidateId, start, end);
	}

	/**
	* Returns an ordered range of all the a q r ratings where masterCandidateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.AQRRatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param masterCandidateId the master candidate ID
	* @param start the lower bound of the range of a q r ratings
	* @param end the upper bound of the range of a q r ratings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching a q r ratings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.AQRRating> findByMaster(
		long masterCandidateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMaster(masterCandidateId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first a q r rating in the ordered set where masterCandidateId = &#63;.
	*
	* @param masterCandidateId the master candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a q r rating
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException if a matching a q r rating could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.AQRRating findByMaster_First(
		long masterCandidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMaster_First(masterCandidateId, orderByComparator);
	}

	/**
	* Returns the first a q r rating in the ordered set where masterCandidateId = &#63;.
	*
	* @param masterCandidateId the master candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching a q r rating, or <code>null</code> if a matching a q r rating could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.AQRRating fetchByMaster_First(
		long masterCandidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMaster_First(masterCandidateId, orderByComparator);
	}

	/**
	* Returns the last a q r rating in the ordered set where masterCandidateId = &#63;.
	*
	* @param masterCandidateId the master candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a q r rating
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException if a matching a q r rating could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.AQRRating findByMaster_Last(
		long masterCandidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMaster_Last(masterCandidateId, orderByComparator);
	}

	/**
	* Returns the last a q r rating in the ordered set where masterCandidateId = &#63;.
	*
	* @param masterCandidateId the master candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching a q r rating, or <code>null</code> if a matching a q r rating could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.AQRRating fetchByMaster_Last(
		long masterCandidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMaster_Last(masterCandidateId, orderByComparator);
	}

	/**
	* Returns the a q r ratings before and after the current a q r rating in the ordered set where masterCandidateId = &#63;.
	*
	* @param aqrId the primary key of the current a q r rating
	* @param masterCandidateId the master candidate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next a q r rating
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException if a a q r rating with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.AQRRating[] findByMaster_PrevAndNext(
		long aqrId, long masterCandidateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMaster_PrevAndNext(aqrId, masterCandidateId,
			orderByComparator);
	}

	/**
	* Removes all the a q r ratings where masterCandidateId = &#63; from the database.
	*
	* @param masterCandidateId the master candidate ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMaster(long masterCandidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMaster(masterCandidateId);
	}

	/**
	* Returns the number of a q r ratings where masterCandidateId = &#63;.
	*
	* @param masterCandidateId the master candidate ID
	* @return the number of matching a q r ratings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMaster(long masterCandidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMaster(masterCandidateId);
	}

	/**
	* Caches the a q r rating in the entity cache if it is enabled.
	*
	* @param aqrRating the a q r rating
	*/
	public static void cacheResult(
		at.meduni.liferay.portlet.rdconnect.model.AQRRating aqrRating) {
		getPersistence().cacheResult(aqrRating);
	}

	/**
	* Caches the a q r ratings in the entity cache if it is enabled.
	*
	* @param aqrRatings the a q r ratings
	*/
	public static void cacheResult(
		java.util.List<at.meduni.liferay.portlet.rdconnect.model.AQRRating> aqrRatings) {
		getPersistence().cacheResult(aqrRatings);
	}

	/**
	* Creates a new a q r rating with the primary key. Does not add the a q r rating to the database.
	*
	* @param aqrId the primary key for the new a q r rating
	* @return the new a q r rating
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.AQRRating create(
		long aqrId) {
		return getPersistence().create(aqrId);
	}

	/**
	* Removes the a q r rating with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param aqrId the primary key of the a q r rating
	* @return the a q r rating that was removed
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException if a a q r rating with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.AQRRating remove(
		long aqrId)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(aqrId);
	}

	public static at.meduni.liferay.portlet.rdconnect.model.AQRRating updateImpl(
		at.meduni.liferay.portlet.rdconnect.model.AQRRating aqrRating)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(aqrRating);
	}

	/**
	* Returns the a q r rating with the primary key or throws a {@link at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException} if it could not be found.
	*
	* @param aqrId the primary key of the a q r rating
	* @return the a q r rating
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException if a a q r rating with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.AQRRating findByPrimaryKey(
		long aqrId)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(aqrId);
	}

	/**
	* Returns the a q r rating with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param aqrId the primary key of the a q r rating
	* @return the a q r rating, or <code>null</code> if a a q r rating with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.AQRRating fetchByPrimaryKey(
		long aqrId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(aqrId);
	}

	/**
	* Returns all the a q r ratings.
	*
	* @return the a q r ratings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.AQRRating> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the a q r ratings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.AQRRatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of a q r ratings
	* @param end the upper bound of the range of a q r ratings (not inclusive)
	* @return the range of a q r ratings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.AQRRating> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the a q r ratings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.AQRRatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of a q r ratings
	* @param end the upper bound of the range of a q r ratings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of a q r ratings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.AQRRating> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the a q r ratings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of a q r ratings.
	*
	* @return the number of a q r ratings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AQRRatingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AQRRatingPersistence)PortletBeanLocatorUtil.locate(at.meduni.liferay.portlet.rdconnect.service.ClpSerializer.getServletContextName(),
					AQRRatingPersistence.class.getName());

			ReferenceRegistry.registerReference(AQRRatingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AQRRatingPersistence persistence) {
	}

	private static AQRRatingPersistence _persistence;
}