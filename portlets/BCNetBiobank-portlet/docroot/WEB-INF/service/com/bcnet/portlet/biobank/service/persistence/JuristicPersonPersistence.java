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

package com.bcnet.portlet.biobank.service.persistence;

import com.bcnet.portlet.biobank.model.JuristicPerson;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the juristic person service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see JuristicPersonPersistenceImpl
 * @see JuristicPersonUtil
 * @generated
 */
public interface JuristicPersonPersistence extends BasePersistence<JuristicPerson> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JuristicPersonUtil} to access the juristic person persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the juristic person in the entity cache if it is enabled.
	*
	* @param juristicPerson the juristic person
	*/
	public void cacheResult(
		com.bcnet.portlet.biobank.model.JuristicPerson juristicPerson);

	/**
	* Caches the juristic persons in the entity cache if it is enabled.
	*
	* @param juristicPersons the juristic persons
	*/
	public void cacheResult(
		java.util.List<com.bcnet.portlet.biobank.model.JuristicPerson> juristicPersons);

	/**
	* Creates a new juristic person with the primary key. Does not add the juristic person to the database.
	*
	* @param juristicPersonId the primary key for the new juristic person
	* @return the new juristic person
	*/
	public com.bcnet.portlet.biobank.model.JuristicPerson create(
		long juristicPersonId);

	/**
	* Removes the juristic person with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param juristicPersonId the primary key of the juristic person
	* @return the juristic person that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchJuristicPersonException if a juristic person with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.JuristicPerson remove(
		long juristicPersonId)
		throws com.bcnet.portlet.biobank.NoSuchJuristicPersonException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bcnet.portlet.biobank.model.JuristicPerson updateImpl(
		com.bcnet.portlet.biobank.model.JuristicPerson juristicPerson)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the juristic person with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchJuristicPersonException} if it could not be found.
	*
	* @param juristicPersonId the primary key of the juristic person
	* @return the juristic person
	* @throws com.bcnet.portlet.biobank.NoSuchJuristicPersonException if a juristic person with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.JuristicPerson findByPrimaryKey(
		long juristicPersonId)
		throws com.bcnet.portlet.biobank.NoSuchJuristicPersonException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the juristic person with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param juristicPersonId the primary key of the juristic person
	* @return the juristic person, or <code>null</code> if a juristic person with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.JuristicPerson fetchByPrimaryKey(
		long juristicPersonId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the juristic persons.
	*
	* @return the juristic persons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.JuristicPerson> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the juristic persons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.JuristicPersonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of juristic persons
	* @param end the upper bound of the range of juristic persons (not inclusive)
	* @return the range of juristic persons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.JuristicPerson> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the juristic persons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.JuristicPersonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of juristic persons
	* @param end the upper bound of the range of juristic persons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of juristic persons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.JuristicPerson> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the juristic persons from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of juristic persons.
	*
	* @return the number of juristic persons
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}