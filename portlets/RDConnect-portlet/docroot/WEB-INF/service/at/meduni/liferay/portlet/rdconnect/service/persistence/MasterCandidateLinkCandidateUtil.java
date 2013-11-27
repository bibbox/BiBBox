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

import at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the master candidate link candidate service. This utility wraps {@link MasterCandidateLinkCandidatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see MasterCandidateLinkCandidatePersistence
 * @see MasterCandidateLinkCandidatePersistenceImpl
 * @generated
 */
public class MasterCandidateLinkCandidateUtil {
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
	public static void clearCache(
		MasterCandidateLinkCandidate masterCandidateLinkCandidate) {
		getPersistence().clearCache(masterCandidateLinkCandidate);
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
	public static List<MasterCandidateLinkCandidate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MasterCandidateLinkCandidate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MasterCandidateLinkCandidate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MasterCandidateLinkCandidate update(
		MasterCandidateLinkCandidate masterCandidateLinkCandidate)
		throws SystemException {
		return getPersistence().update(masterCandidateLinkCandidate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MasterCandidateLinkCandidate update(
		MasterCandidateLinkCandidate masterCandidateLinkCandidate,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(masterCandidateLinkCandidate, serviceContext);
	}

	/**
	* Caches the master candidate link candidate in the entity cache if it is enabled.
	*
	* @param masterCandidateLinkCandidate the master candidate link candidate
	*/
	public static void cacheResult(
		at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate masterCandidateLinkCandidate) {
		getPersistence().cacheResult(masterCandidateLinkCandidate);
	}

	/**
	* Caches the master candidate link candidates in the entity cache if it is enabled.
	*
	* @param masterCandidateLinkCandidates the master candidate link candidates
	*/
	public static void cacheResult(
		java.util.List<at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate> masterCandidateLinkCandidates) {
		getPersistence().cacheResult(masterCandidateLinkCandidates);
	}

	/**
	* Creates a new master candidate link candidate with the primary key. Does not add the master candidate link candidate to the database.
	*
	* @param linkId the primary key for the new master candidate link candidate
	* @return the new master candidate link candidate
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate create(
		long linkId) {
		return getPersistence().create(linkId);
	}

	/**
	* Removes the master candidate link candidate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param linkId the primary key of the master candidate link candidate
	* @return the master candidate link candidate that was removed
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateLinkCandidateException if a master candidate link candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate remove(
		long linkId)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateLinkCandidateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(linkId);
	}

	public static at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate updateImpl(
		at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate masterCandidateLinkCandidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(masterCandidateLinkCandidate);
	}

	/**
	* Returns the master candidate link candidate with the primary key or throws a {@link at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateLinkCandidateException} if it could not be found.
	*
	* @param linkId the primary key of the master candidate link candidate
	* @return the master candidate link candidate
	* @throws at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateLinkCandidateException if a master candidate link candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate findByPrimaryKey(
		long linkId)
		throws at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateLinkCandidateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(linkId);
	}

	/**
	* Returns the master candidate link candidate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param linkId the primary key of the master candidate link candidate
	* @return the master candidate link candidate, or <code>null</code> if a master candidate link candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate fetchByPrimaryKey(
		long linkId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(linkId);
	}

	/**
	* Returns all the master candidate link candidates.
	*
	* @return the master candidate link candidates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the master candidate link candidates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateLinkCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of master candidate link candidates
	* @param end the upper bound of the range of master candidate link candidates (not inclusive)
	* @return the range of master candidate link candidates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the master candidate link candidates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateLinkCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of master candidate link candidates
	* @param end the upper bound of the range of master candidate link candidates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of master candidate link candidates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the master candidate link candidates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of master candidate link candidates.
	*
	* @return the number of master candidate link candidates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MasterCandidateLinkCandidatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MasterCandidateLinkCandidatePersistence)PortletBeanLocatorUtil.locate(at.meduni.liferay.portlet.rdconnect.service.ClpSerializer.getServletContextName(),
					MasterCandidateLinkCandidatePersistence.class.getName());

			ReferenceRegistry.registerReference(MasterCandidateLinkCandidateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		MasterCandidateLinkCandidatePersistence persistence) {
	}

	private static MasterCandidateLinkCandidatePersistence _persistence;
}