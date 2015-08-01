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

package at.graz.hmmc.liferay.portlet.puch.service.persistence;

import at.graz.hmmc.liferay.portlet.puch.model.Person;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the person service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see PersonPersistenceImpl
 * @see PersonUtil
 * @generated
 */
public interface PersonPersistence extends BasePersistence<Person> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersonUtil} to access the person persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the persons where vorname = &#63;.
	*
	* @param vorname the vorname
	* @return the matching persons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Person> findByVorname(
		java.lang.String vorname)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the persons where vorname = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.PersonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param vorname the vorname
	* @param start the lower bound of the range of persons
	* @param end the upper bound of the range of persons (not inclusive)
	* @return the range of matching persons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Person> findByVorname(
		java.lang.String vorname, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the persons where vorname = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.PersonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param vorname the vorname
	* @param start the lower bound of the range of persons
	* @param end the upper bound of the range of persons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching persons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Person> findByVorname(
		java.lang.String vorname, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first person in the ordered set where vorname = &#63;.
	*
	* @param vorname the vorname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching person
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException if a matching person could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Person findByVorname_First(
		java.lang.String vorname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first person in the ordered set where vorname = &#63;.
	*
	* @param vorname the vorname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching person, or <code>null</code> if a matching person could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Person fetchByVorname_First(
		java.lang.String vorname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last person in the ordered set where vorname = &#63;.
	*
	* @param vorname the vorname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching person
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException if a matching person could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Person findByVorname_Last(
		java.lang.String vorname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last person in the ordered set where vorname = &#63;.
	*
	* @param vorname the vorname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching person, or <code>null</code> if a matching person could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Person fetchByVorname_Last(
		java.lang.String vorname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the persons before and after the current person in the ordered set where vorname = &#63;.
	*
	* @param personId the primary key of the current person
	* @param vorname the vorname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next person
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException if a person with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Person[] findByVorname_PrevAndNext(
		long personId, java.lang.String vorname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the persons where vorname = &#63; from the database.
	*
	* @param vorname the vorname
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVorname(java.lang.String vorname)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of persons where vorname = &#63;.
	*
	* @param vorname the vorname
	* @return the number of matching persons
	* @throws SystemException if a system exception occurred
	*/
	public int countByVorname(java.lang.String vorname)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the person in the entity cache if it is enabled.
	*
	* @param person the person
	*/
	public void cacheResult(
		at.graz.hmmc.liferay.portlet.puch.model.Person person);

	/**
	* Caches the persons in the entity cache if it is enabled.
	*
	* @param persons the persons
	*/
	public void cacheResult(
		java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Person> persons);

	/**
	* Creates a new person with the primary key. Does not add the person to the database.
	*
	* @param personId the primary key for the new person
	* @return the new person
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Person create(long personId);

	/**
	* Removes the person with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personId the primary key of the person
	* @return the person that was removed
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException if a person with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Person remove(long personId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.hmmc.liferay.portlet.puch.model.Person updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.Person person)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the person with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException} if it could not be found.
	*
	* @param personId the primary key of the person
	* @return the person
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException if a person with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Person findByPrimaryKey(
		long personId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the person with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param personId the primary key of the person
	* @return the person, or <code>null</code> if a person with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.hmmc.liferay.portlet.puch.model.Person fetchByPrimaryKey(
		long personId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the persons.
	*
	* @return the persons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Person> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the persons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.PersonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of persons
	* @param end the upper bound of the range of persons (not inclusive)
	* @return the range of persons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Person> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the persons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.PersonModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of persons
	* @param end the upper bound of the range of persons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of persons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Person> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the persons from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of persons.
	*
	* @return the number of persons
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}