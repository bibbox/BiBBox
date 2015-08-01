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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the person service. This utility wraps {@link PersonPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see PersonPersistence
 * @see PersonPersistenceImpl
 * @generated
 */
public class PersonUtil {
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
	public static void clearCache(Person person) {
		getPersistence().clearCache(person);
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
	public static List<Person> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Person> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Person> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Person update(Person person) throws SystemException {
		return getPersistence().update(person);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Person update(Person person, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(person, serviceContext);
	}

	/**
	* Returns all the persons where vorname = &#63;.
	*
	* @param vorname the vorname
	* @return the matching persons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Person> findByVorname(
		java.lang.String vorname)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVorname(vorname);
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Person> findByVorname(
		java.lang.String vorname, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVorname(vorname, start, end);
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Person> findByVorname(
		java.lang.String vorname, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVorname(vorname, start, end, orderByComparator);
	}

	/**
	* Returns the first person in the ordered set where vorname = &#63;.
	*
	* @param vorname the vorname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching person
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException if a matching person could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Person findByVorname_First(
		java.lang.String vorname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVorname_First(vorname, orderByComparator);
	}

	/**
	* Returns the first person in the ordered set where vorname = &#63;.
	*
	* @param vorname the vorname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching person, or <code>null</code> if a matching person could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Person fetchByVorname_First(
		java.lang.String vorname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVorname_First(vorname, orderByComparator);
	}

	/**
	* Returns the last person in the ordered set where vorname = &#63;.
	*
	* @param vorname the vorname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching person
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException if a matching person could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Person findByVorname_Last(
		java.lang.String vorname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVorname_Last(vorname, orderByComparator);
	}

	/**
	* Returns the last person in the ordered set where vorname = &#63;.
	*
	* @param vorname the vorname
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching person, or <code>null</code> if a matching person could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Person fetchByVorname_Last(
		java.lang.String vorname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVorname_Last(vorname, orderByComparator);
	}

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
	public static at.graz.hmmc.liferay.portlet.puch.model.Person[] findByVorname_PrevAndNext(
		long personId, java.lang.String vorname,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVorname_PrevAndNext(personId, vorname,
			orderByComparator);
	}

	/**
	* Removes all the persons where vorname = &#63; from the database.
	*
	* @param vorname the vorname
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVorname(java.lang.String vorname)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVorname(vorname);
	}

	/**
	* Returns the number of persons where vorname = &#63;.
	*
	* @param vorname the vorname
	* @return the number of matching persons
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVorname(java.lang.String vorname)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVorname(vorname);
	}

	/**
	* Caches the person in the entity cache if it is enabled.
	*
	* @param person the person
	*/
	public static void cacheResult(
		at.graz.hmmc.liferay.portlet.puch.model.Person person) {
		getPersistence().cacheResult(person);
	}

	/**
	* Caches the persons in the entity cache if it is enabled.
	*
	* @param persons the persons
	*/
	public static void cacheResult(
		java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Person> persons) {
		getPersistence().cacheResult(persons);
	}

	/**
	* Creates a new person with the primary key. Does not add the person to the database.
	*
	* @param personId the primary key for the new person
	* @return the new person
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Person create(
		long personId) {
		return getPersistence().create(personId);
	}

	/**
	* Removes the person with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param personId the primary key of the person
	* @return the person that was removed
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException if a person with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Person remove(
		long personId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(personId);
	}

	public static at.graz.hmmc.liferay.portlet.puch.model.Person updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.Person person)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(person);
	}

	/**
	* Returns the person with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException} if it could not be found.
	*
	* @param personId the primary key of the person
	* @return the person
	* @throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException if a person with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Person findByPrimaryKey(
		long personId)
		throws at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(personId);
	}

	/**
	* Returns the person with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param personId the primary key of the person
	* @return the person, or <code>null</code> if a person with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.Person fetchByPrimaryKey(
		long personId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(personId);
	}

	/**
	* Returns all the persons.
	*
	* @return the persons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Person> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Person> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.Person> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the persons from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of persons.
	*
	* @return the number of persons
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PersonPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PersonPersistence)PortletBeanLocatorUtil.locate(at.graz.hmmc.liferay.portlet.puch.service.ClpSerializer.getServletContextName(),
					PersonPersistence.class.getName());

			ReferenceRegistry.registerReference(PersonUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PersonPersistence persistence) {
	}

	private static PersonPersistence _persistence;
}