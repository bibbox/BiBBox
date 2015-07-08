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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bio bank service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see BioBankPersistenceImpl
 * @see BioBankUtil
 * @generated
 */
public interface BioBankPersistence extends BasePersistence<BioBank> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BioBankUtil} to access the bio bank persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the bio bank where ldapbiobankID = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException} if it could not be found.
	*
	* @param ldapbiobankID the ldapbiobank i d
	* @return the matching bio bank
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank findByLADPBiobankId(
		java.lang.String ldapbiobankID)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bio bank where ldapbiobankID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ldapbiobankID the ldapbiobank i d
	* @return the matching bio bank, or <code>null</code> if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank fetchByLADPBiobankId(
		java.lang.String ldapbiobankID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bio bank where ldapbiobankID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ldapbiobankID the ldapbiobank i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bio bank, or <code>null</code> if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank fetchByLADPBiobankId(
		java.lang.String ldapbiobankID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the bio bank where ldapbiobankID = &#63; from the database.
	*
	* @param ldapbiobankID the ldapbiobank i d
	* @return the bio bank that was removed
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank removeByLADPBiobankId(
		java.lang.String ldapbiobankID)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bio banks where ldapbiobankID = &#63;.
	*
	* @param ldapbiobankID the ldapbiobank i d
	* @return the number of matching bio banks
	* @throws SystemException if a system exception occurred
	*/
	public int countByLADPBiobankId(java.lang.String ldapbiobankID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bio banks where biobankcountry = &#63;.
	*
	* @param biobankcountry the biobankcountry
	* @return the matching bio banks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> findByBiobankCountry(
		java.lang.String biobankcountry)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> findByBiobankCountry(
		java.lang.String biobankcountry, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> findByBiobankCountry(
		java.lang.String biobankcountry, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bio bank in the ordered set where biobankcountry = &#63;.
	*
	* @param biobankcountry the biobankcountry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bio bank
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank findByBiobankCountry_First(
		java.lang.String biobankcountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bio bank in the ordered set where biobankcountry = &#63;.
	*
	* @param biobankcountry the biobankcountry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bio bank, or <code>null</code> if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank fetchByBiobankCountry_First(
		java.lang.String biobankcountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bio bank in the ordered set where biobankcountry = &#63;.
	*
	* @param biobankcountry the biobankcountry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bio bank
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank findByBiobankCountry_Last(
		java.lang.String biobankcountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bio bank in the ordered set where biobankcountry = &#63;.
	*
	* @param biobankcountry the biobankcountry
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bio bank, or <code>null</code> if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank fetchByBiobankCountry_Last(
		java.lang.String biobankcountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank[] findByBiobankCountry_PrevAndNext(
		long biobankId, java.lang.String biobankcountry,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bio banks where biobankcountry = &#63; from the database.
	*
	* @param biobankcountry the biobankcountry
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBiobankCountry(java.lang.String biobankcountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bio banks where biobankcountry = &#63;.
	*
	* @param biobankcountry the biobankcountry
	* @return the number of matching bio banks
	* @throws SystemException if a system exception occurred
	*/
	public int countByBiobankCountry(java.lang.String biobankcountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bio banks where UUID &ne; &#63;.
	*
	* @param UUID the u u i d
	* @return the matching bio banks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> findByNotUUID(
		java.lang.String UUID)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> findByNotUUID(
		java.lang.String UUID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> findByNotUUID(
		java.lang.String UUID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bio bank in the ordered set where UUID &ne; &#63;.
	*
	* @param UUID the u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bio bank
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank findByNotUUID_First(
		java.lang.String UUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bio bank in the ordered set where UUID &ne; &#63;.
	*
	* @param UUID the u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bio bank, or <code>null</code> if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank fetchByNotUUID_First(
		java.lang.String UUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bio bank in the ordered set where UUID &ne; &#63;.
	*
	* @param UUID the u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bio bank
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank findByNotUUID_Last(
		java.lang.String UUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bio bank in the ordered set where UUID &ne; &#63;.
	*
	* @param UUID the u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bio bank, or <code>null</code> if a matching bio bank could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank fetchByNotUUID_Last(
		java.lang.String UUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank[] findByNotUUID_PrevAndNext(
		long biobankId, java.lang.String UUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bio banks where UUID &ne; &#63; from the database.
	*
	* @param UUID the u u i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNotUUID(java.lang.String UUID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bio banks where UUID &ne; &#63;.
	*
	* @param UUID the u u i d
	* @return the number of matching bio banks
	* @throws SystemException if a system exception occurred
	*/
	public int countByNotUUID(java.lang.String UUID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bio bank in the entity cache if it is enabled.
	*
	* @param bioBank the bio bank
	*/
	public void cacheResult(
		at.meduni.liferay.portlet.bbmrieric.model.BioBank bioBank);

	/**
	* Caches the bio banks in the entity cache if it is enabled.
	*
	* @param bioBanks the bio banks
	*/
	public void cacheResult(
		java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> bioBanks);

	/**
	* Creates a new bio bank with the primary key. Does not add the bio bank to the database.
	*
	* @param biobankId the primary key for the new bio bank
	* @return the new bio bank
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank create(
		long biobankId);

	/**
	* Removes the bio bank with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankId the primary key of the bio bank
	* @return the bio bank that was removed
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a bio bank with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank remove(
		long biobankId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.meduni.liferay.portlet.bbmrieric.model.BioBank updateImpl(
		at.meduni.liferay.portlet.bbmrieric.model.BioBank bioBank)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bio bank with the primary key or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException} if it could not be found.
	*
	* @param biobankId the primary key of the bio bank
	* @return the bio bank
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a bio bank with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank findByPrimaryKey(
		long biobankId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bio bank with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param biobankId the primary key of the bio bank
	* @return the bio bank, or <code>null</code> if a bio bank with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.meduni.liferay.portlet.bbmrieric.model.BioBank fetchByPrimaryKey(
		long biobankId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bio banks.
	*
	* @return the bio banks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.BioBank> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bio banks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bio banks.
	*
	* @return the number of bio banks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}