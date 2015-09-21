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

import com.liferay.portal.service.persistence.BasePersistence;

import test.portlet.model.MolgenisAPIRequest;

/**
 * The persistence interface for the molgenis a p i request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see MolgenisAPIRequestPersistenceImpl
 * @see MolgenisAPIRequestUtil
 * @generated
 */
public interface MolgenisAPIRequestPersistence extends BasePersistence<MolgenisAPIRequest> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MolgenisAPIRequestUtil} to access the molgenis a p i request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the molgenis a p i request in the entity cache if it is enabled.
	*
	* @param molgenisAPIRequest the molgenis a p i request
	*/
	public void cacheResult(
		test.portlet.model.MolgenisAPIRequest molgenisAPIRequest);

	/**
	* Caches the molgenis a p i requests in the entity cache if it is enabled.
	*
	* @param molgenisAPIRequests the molgenis a p i requests
	*/
	public void cacheResult(
		java.util.List<test.portlet.model.MolgenisAPIRequest> molgenisAPIRequests);

	/**
	* Creates a new molgenis a p i request with the primary key. Does not add the molgenis a p i request to the database.
	*
	* @param molgenisapirequestId the primary key for the new molgenis a p i request
	* @return the new molgenis a p i request
	*/
	public test.portlet.model.MolgenisAPIRequest create(
		long molgenisapirequestId);

	/**
	* Removes the molgenis a p i request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param molgenisapirequestId the primary key of the molgenis a p i request
	* @return the molgenis a p i request that was removed
	* @throws test.portlet.NoSuchMolgenisAPIRequestException if a molgenis a p i request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public test.portlet.model.MolgenisAPIRequest remove(
		long molgenisapirequestId)
		throws com.liferay.portal.kernel.exception.SystemException,
			test.portlet.NoSuchMolgenisAPIRequestException;

	public test.portlet.model.MolgenisAPIRequest updateImpl(
		test.portlet.model.MolgenisAPIRequest molgenisAPIRequest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the molgenis a p i request with the primary key or throws a {@link test.portlet.NoSuchMolgenisAPIRequestException} if it could not be found.
	*
	* @param molgenisapirequestId the primary key of the molgenis a p i request
	* @return the molgenis a p i request
	* @throws test.portlet.NoSuchMolgenisAPIRequestException if a molgenis a p i request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public test.portlet.model.MolgenisAPIRequest findByPrimaryKey(
		long molgenisapirequestId)
		throws com.liferay.portal.kernel.exception.SystemException,
			test.portlet.NoSuchMolgenisAPIRequestException;

	/**
	* Returns the molgenis a p i request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param molgenisapirequestId the primary key of the molgenis a p i request
	* @return the molgenis a p i request, or <code>null</code> if a molgenis a p i request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public test.portlet.model.MolgenisAPIRequest fetchByPrimaryKey(
		long molgenisapirequestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the molgenis a p i requests.
	*
	* @return the molgenis a p i requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<test.portlet.model.MolgenisAPIRequest> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<test.portlet.model.MolgenisAPIRequest> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<test.portlet.model.MolgenisAPIRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the molgenis a p i requests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of molgenis a p i requests.
	*
	* @return the number of molgenis a p i requests
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}