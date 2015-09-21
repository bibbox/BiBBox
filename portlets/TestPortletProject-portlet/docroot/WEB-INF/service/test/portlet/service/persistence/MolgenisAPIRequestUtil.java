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

package test.portlet.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import test.portlet.model.MolgenisAPIRequest;

import java.util.List;

/**
 * The persistence utility for the molgenis a p i request service. This utility wraps {@link MolgenisAPIRequestPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see MolgenisAPIRequestPersistence
 * @see MolgenisAPIRequestPersistenceImpl
 * @generated
 */
public class MolgenisAPIRequestUtil {
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
	public static void clearCache(MolgenisAPIRequest molgenisAPIRequest) {
		getPersistence().clearCache(molgenisAPIRequest);
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
	public static List<MolgenisAPIRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MolgenisAPIRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MolgenisAPIRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MolgenisAPIRequest update(
		MolgenisAPIRequest molgenisAPIRequest) throws SystemException {
		return getPersistence().update(molgenisAPIRequest);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MolgenisAPIRequest update(
		MolgenisAPIRequest molgenisAPIRequest, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(molgenisAPIRequest, serviceContext);
	}

	/**
	* Caches the molgenis a p i request in the entity cache if it is enabled.
	*
	* @param molgenisAPIRequest the molgenis a p i request
	*/
	public static void cacheResult(
		test.portlet.model.MolgenisAPIRequest molgenisAPIRequest) {
		getPersistence().cacheResult(molgenisAPIRequest);
	}

	/**
	* Caches the molgenis a p i requests in the entity cache if it is enabled.
	*
	* @param molgenisAPIRequests the molgenis a p i requests
	*/
	public static void cacheResult(
		java.util.List<test.portlet.model.MolgenisAPIRequest> molgenisAPIRequests) {
		getPersistence().cacheResult(molgenisAPIRequests);
	}

	/**
	* Creates a new molgenis a p i request with the primary key. Does not add the molgenis a p i request to the database.
	*
	* @param molgenisapirequestId the primary key for the new molgenis a p i request
	* @return the new molgenis a p i request
	*/
	public static test.portlet.model.MolgenisAPIRequest create(
		long molgenisapirequestId) {
		return getPersistence().create(molgenisapirequestId);
	}

	/**
	* Removes the molgenis a p i request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param molgenisapirequestId the primary key of the molgenis a p i request
	* @return the molgenis a p i request that was removed
	* @throws test.portlet.NoSuchMolgenisAPIRequestException if a molgenis a p i request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static test.portlet.model.MolgenisAPIRequest remove(
		long molgenisapirequestId)
		throws com.liferay.portal.kernel.exception.SystemException,
			test.portlet.NoSuchMolgenisAPIRequestException {
		return getPersistence().remove(molgenisapirequestId);
	}

	public static test.portlet.model.MolgenisAPIRequest updateImpl(
		test.portlet.model.MolgenisAPIRequest molgenisAPIRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(molgenisAPIRequest);
	}

	/**
	* Returns the molgenis a p i request with the primary key or throws a {@link test.portlet.NoSuchMolgenisAPIRequestException} if it could not be found.
	*
	* @param molgenisapirequestId the primary key of the molgenis a p i request
	* @return the molgenis a p i request
	* @throws test.portlet.NoSuchMolgenisAPIRequestException if a molgenis a p i request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static test.portlet.model.MolgenisAPIRequest findByPrimaryKey(
		long molgenisapirequestId)
		throws com.liferay.portal.kernel.exception.SystemException,
			test.portlet.NoSuchMolgenisAPIRequestException {
		return getPersistence().findByPrimaryKey(molgenisapirequestId);
	}

	/**
	* Returns the molgenis a p i request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param molgenisapirequestId the primary key of the molgenis a p i request
	* @return the molgenis a p i request, or <code>null</code> if a molgenis a p i request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static test.portlet.model.MolgenisAPIRequest fetchByPrimaryKey(
		long molgenisapirequestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(molgenisapirequestId);
	}

	/**
	* Returns all the molgenis a p i requests.
	*
	* @return the molgenis a p i requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<test.portlet.model.MolgenisAPIRequest> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the molgenis a p i requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link test.portlet.model.impl.MolgenisAPIRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of molgenis a p i requests
	* @param end the upper bound of the range of molgenis a p i requests (not inclusive)
	* @return the range of molgenis a p i requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<test.portlet.model.MolgenisAPIRequest> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the molgenis a p i requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link test.portlet.model.impl.MolgenisAPIRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of molgenis a p i requests
	* @param end the upper bound of the range of molgenis a p i requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of molgenis a p i requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<test.portlet.model.MolgenisAPIRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the molgenis a p i requests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of molgenis a p i requests.
	*
	* @return the number of molgenis a p i requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MolgenisAPIRequestPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MolgenisAPIRequestPersistence)PortletBeanLocatorUtil.locate(test.portlet.service.ClpSerializer.getServletContextName(),
					MolgenisAPIRequestPersistence.class.getName());

			ReferenceRegistry.registerReference(MolgenisAPIRequestUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MolgenisAPIRequestPersistence persistence) {
	}

	private static MolgenisAPIRequestPersistence _persistence;
}