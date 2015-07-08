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

package at.meduni.liferay.portlet.bbmrieric.service.persistence;

import at.meduni.liferay.portlet.bbmrieric.model.BioBank;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the bio bank service. This utility wraps {@link BioBankPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see BioBankPersistence
 * @see BioBankPersistenceImpl
 * @generated
 */
public class BioBankUtil {
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
	public static void clearCache(BioBank bioBank) {
		getPersistence().clearCache(bioBank);
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
	public static List<BioBank> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BioBank> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BioBank> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BioBank update(BioBank bioBank) throws SystemException {
		return getPersistence().update(bioBank);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BioBank update(BioBank bioBank, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(bioBank, serviceContext);
	}

	/**
	* Returns the bio bank where ldapbiobankID = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException} if it could not be found.
	*
	* @param ldapbiobankID the ldapbiobank i d
	* @return the matching bio bank
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank findByLADPBiobankId(
		java.lang.String ldapbiobankID)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLADPBiobankId(ldapbiobankID);
	}

	/**
	* Returns the bio bank where ldapbiobankID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ldapbiobankID the ldapbiobank i d
	* @return the matching bio bank, or <code>null</code> if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank fetchByLADPBiobankId(
		java.lang.String ldapbiobankID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLADPBiobankId(ldapbiobankID);
	}

	/**
	* Returns the bio bank where ldapbiobankID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ldapbiobankID the ldapbiobank i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bio bank, or <code>null</code> if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank fetchByLADPBiobankId(
		java.lang.String ldapbiobankID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLADPBiobankId(ldapbiobankID, retrieveFromCache);
	}

	/**
	* Removes the bio bank where ldapbiobankID = &#63; from the database.
	*
	* @param ldapbiobankID the ldapbiobank i d
	* @return the bio bank that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank removeByLADPBiobankId(
		java.lang.String ldapbiobankID)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByLADPBiobankId(ldapbiobankID);
	}

	/**
	* Returns the number of bio banks where ldapbiobankID = &#63;.
	*
	* @param ldapbiobankID the ldapbiobank i d
	* @return the number of matching bio banks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLADPBiobankId(java.lang.String ldapbiobankID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLADPBiobankId(ldapbiobankID);
	}

	/**
	* Returns all the bio banks where biobankcountry = &#63;.
	*
	* @param biobankcountry the biobankcountry
	* @return the matching bio banks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> findByBiobankCountry(
		java.lang.String biobankcountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBiobankCountry(biobankcountry);
	}

	/**
	* Returns a range of all the bio banks where biobankcountry = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param biobankcountry the biobankcountry
	* @param start the lower bound of the range of bio banks
	* @param end the upper bound of the range of bio banks (not inclusive)
	* @return the range of matching bio banks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> findByBiobankCountry(
		java.lang.String biobankcountry, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBiobankCountry(biobankcountry, start, end);
	}

	/**
	* Returns an ordered range of all the bio banks where biobankcountry = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param biobankcountry the biobankcountry
	* @param start the lower bound of the range of bio banks
	* @param end the upper bound of the range of bio banks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bio banks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> findByBiobankCountry(
		java.lang.String biobankcountry, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBiobankCountry(biobankcountry, start, end,
			orderByComparator);
	}

	/**
	* Returns the first bio bank in the ordered set where biobankcountry = &#63;.
	*
	* @param biobankcountry the biobankcountry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bio bank
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank findByBiobankCountry_First(
		java.lang.String biobankcountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBiobankCountry_First(biobankcountry, orderByComparator);
	}

	/**
	* Returns the first bio bank in the ordered set where biobankcountry = &#63;.
	*
	* @param biobankcountry the biobankcountry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bio bank, or <code>null</code> if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank fetchByBiobankCountry_First(
		java.lang.String biobankcountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBiobankCountry_First(biobankcountry,
			orderByComparator);
	}

	/**
	* Returns the last bio bank in the ordered set where biobankcountry = &#63;.
	*
	* @param biobankcountry the biobankcountry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bio bank
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank findByBiobankCountry_Last(
		java.lang.String biobankcountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBiobankCountry_Last(biobankcountry, orderByComparator);
	}

	/**
	* Returns the last bio bank in the ordered set where biobankcountry = &#63;.
	*
	* @param biobankcountry the biobankcountry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bio bank, or <code>null</code> if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank fetchByBiobankCountry_Last(
		java.lang.String biobankcountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBiobankCountry_Last(biobankcountry, orderByComparator);
	}

	/**
	* Returns the bio banks before and after the current bio bank in the ordered set where biobankcountry = &#63;.
	*
	* @param biobankId the primary key of the current bio bank
	* @param biobankcountry the biobankcountry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bio bank
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a bio bank with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank[] findByBiobankCountry_PrevAndNext(
		long biobankId, java.lang.String biobankcountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBiobankCountry_PrevAndNext(biobankId, biobankcountry,
			orderByComparator);
	}

	/**
	* Removes all the bio banks where biobankcountry = &#63; from the database.
	*
	* @param biobankcountry the biobankcountry
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBiobankCountry(java.lang.String biobankcountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBiobankCountry(biobankcountry);
	}

	/**
	* Returns the number of bio banks where biobankcountry = &#63;.
	*
	* @param biobankcountry the biobankcountry
	* @return the number of matching bio banks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBiobankCountry(java.lang.String biobankcountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBiobankCountry(biobankcountry);
	}

	/**
	* Returns all the bio banks where UUID &ne; &#63;.
	*
	* @param UUID the u u i d
	* @return the matching bio banks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> findByNotUUID(
		java.lang.String UUID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNotUUID(UUID);
	}

	/**
	* Returns a range of all the bio banks where UUID &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param UUID the u u i d
	* @param start the lower bound of the range of bio banks
	* @param end the upper bound of the range of bio banks (not inclusive)
	* @return the range of matching bio banks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> findByNotUUID(
		java.lang.String UUID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNotUUID(UUID, start, end);
	}

	/**
	* Returns an ordered range of all the bio banks where UUID &ne; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param UUID the u u i d
	* @param start the lower bound of the range of bio banks
	* @param end the upper bound of the range of bio banks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bio banks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> findByNotUUID(
		java.lang.String UUID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNotUUID(UUID, start, end, orderByComparator);
	}

	/**
	* Returns the first bio bank in the ordered set where UUID &ne; &#63;.
	*
	* @param UUID the u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bio bank
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank findByNotUUID_First(
		java.lang.String UUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNotUUID_First(UUID, orderByComparator);
	}

	/**
	* Returns the first bio bank in the ordered set where UUID &ne; &#63;.
	*
	* @param UUID the u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bio bank, or <code>null</code> if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank fetchByNotUUID_First(
		java.lang.String UUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNotUUID_First(UUID, orderByComparator);
	}

	/**
	* Returns the last bio bank in the ordered set where UUID &ne; &#63;.
	*
	* @param UUID the u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bio bank
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank findByNotUUID_Last(
		java.lang.String UUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNotUUID_Last(UUID, orderByComparator);
	}

	/**
	* Returns the last bio bank in the ordered set where UUID &ne; &#63;.
	*
	* @param UUID the u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bio bank, or <code>null</code> if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank fetchByNotUUID_Last(
		java.lang.String UUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNotUUID_Last(UUID, orderByComparator);
	}

	/**
	* Returns the bio banks before and after the current bio bank in the ordered set where UUID &ne; &#63;.
	*
	* @param biobankId the primary key of the current bio bank
	* @param UUID the u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bio bank
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a bio bank with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank[] findByNotUUID_PrevAndNext(
		long biobankId, java.lang.String UUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNotUUID_PrevAndNext(biobankId, UUID, orderByComparator);
	}

	/**
	* Removes all the bio banks where UUID &ne; &#63; from the database.
	*
	* @param UUID the u u i d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNotUUID(java.lang.String UUID)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNotUUID(UUID);
	}

	/**
	* Returns the number of bio banks where UUID &ne; &#63;.
	*
	* @param UUID the u u i d
	* @return the number of matching bio banks
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNotUUID(java.lang.String UUID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNotUUID(UUID);
	}

	/**
	* Caches the bio bank in the entity cache if it is enabled.
	*
	* @param bioBank the bio bank
	*/
	public static void cacheResult(
		at.meduni.liferay.portlet.bbmrieric.model.BioBank bioBank) {
		getPersistence().cacheResult(bioBank);
	}

	/**
	* Caches the bio banks in the entity cache if it is enabled.
	*
	* @param bioBanks the bio banks
	*/
	public static void cacheResult(
		java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> bioBanks) {
		getPersistence().cacheResult(bioBanks);
	}

	/**
	* Creates a new bio bank with the primary key. Does not add the bio bank to the database.
	*
	* @param biobankId the primary key for the new bio bank
	* @return the new bio bank
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank create(
		long biobankId) {
		return getPersistence().create(biobankId);
	}

	/**
	* Removes the bio bank with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankId the primary key of the bio bank
	* @return the bio bank that was removed
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a bio bank with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank remove(
		long biobankId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(biobankId);
	}

	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank updateImpl(
		at.meduni.liferay.portlet.bbmrieric.model.BioBank bioBank)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(bioBank);
	}

	/**
	* Returns the bio bank with the primary key or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException} if it could not be found.
	*
	* @param biobankId the primary key of the bio bank
	* @return the bio bank
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a bio bank with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank findByPrimaryKey(
		long biobankId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(biobankId);
	}

	/**
	* Returns the bio bank with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param biobankId the primary key of the bio bank
	* @return the bio bank, or <code>null</code> if a bio bank with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.BioBank fetchByPrimaryKey(
		long biobankId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(biobankId);
	}

	/**
	* Returns all the bio banks.
	*
	* @return the bio banks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bio banks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bio banks
	* @param end the upper bound of the range of bio banks (not inclusive)
	* @return the range of bio banks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bio banks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bio banks
	* @param end the upper bound of the range of bio banks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bio banks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bio banks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bio banks.
	*
	* @return the number of bio banks
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BioBankPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BioBankPersistence)PortletBeanLocatorUtil.locate(at.meduni.liferay.portlet.bbmrieric.service.ClpSerializer.getServletContextName(),
					BioBankPersistence.class.getName());

			ReferenceRegistry.registerReference(BioBankUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BioBankPersistence persistence) {
	}

	private static BioBankPersistence _persistence;
}