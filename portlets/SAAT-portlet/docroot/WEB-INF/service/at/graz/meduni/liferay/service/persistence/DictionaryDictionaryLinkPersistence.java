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

package at.graz.meduni.liferay.service.persistence;

import at.graz.meduni.liferay.model.DictionaryDictionaryLink;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the dictionary dictionary link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see DictionaryDictionaryLinkPersistenceImpl
 * @see DictionaryDictionaryLinkUtil
 * @generated
 */
public interface DictionaryDictionaryLinkPersistence extends BasePersistence<DictionaryDictionaryLink> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DictionaryDictionaryLinkUtil} to access the dictionary dictionary link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the dictionary dictionary links where dictionary_id = &#63;.
	*
	* @param dictionary_id the dictionary_id
	* @return the matching dictionary dictionary links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.DictionaryDictionaryLink> findByDictionaryId(
		long dictionary_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dictionary dictionary links where dictionary_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictionary_id the dictionary_id
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @return the range of matching dictionary dictionary links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.DictionaryDictionaryLink> findByDictionaryId(
		long dictionary_id, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dictionary dictionary links where dictionary_id = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictionary_id the dictionary_id
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dictionary dictionary links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.DictionaryDictionaryLink> findByDictionaryId(
		long dictionary_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dictionary dictionary link in the ordered set where dictionary_id = &#63;.
	*
	* @param dictionary_id the dictionary_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link
	* @throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.DictionaryDictionaryLink findByDictionaryId_First(
		long dictionary_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dictionary dictionary link in the ordered set where dictionary_id = &#63;.
	*
	* @param dictionary_id the dictionary_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.DictionaryDictionaryLink fetchByDictionaryId_First(
		long dictionary_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dictionary dictionary link in the ordered set where dictionary_id = &#63;.
	*
	* @param dictionary_id the dictionary_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link
	* @throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.DictionaryDictionaryLink findByDictionaryId_Last(
		long dictionary_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dictionary dictionary link in the ordered set where dictionary_id = &#63;.
	*
	* @param dictionary_id the dictionary_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.DictionaryDictionaryLink fetchByDictionaryId_Last(
		long dictionary_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dictionary dictionary links before and after the current dictionary dictionary link in the ordered set where dictionary_id = &#63;.
	*
	* @param id the primary key of the current dictionary dictionary link
	* @param dictionary_id the dictionary_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary dictionary link
	* @throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.DictionaryDictionaryLink[] findByDictionaryId_PrevAndNext(
		long id, long dictionary_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dictionary dictionary links where dictionary_id = &#63; from the database.
	*
	* @param dictionary_id the dictionary_id
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDictionaryId(long dictionary_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dictionary dictionary links where dictionary_id = &#63;.
	*
	* @param dictionary_id the dictionary_id
	* @return the number of matching dictionary dictionary links
	* @throws SystemException if a system exception occurred
	*/
	public int countByDictionaryId(long dictionary_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the dictionary dictionary link in the entity cache if it is enabled.
	*
	* @param dictionaryDictionaryLink the dictionary dictionary link
	*/
	public void cacheResult(
		at.graz.meduni.liferay.model.DictionaryDictionaryLink dictionaryDictionaryLink);

	/**
	* Caches the dictionary dictionary links in the entity cache if it is enabled.
	*
	* @param dictionaryDictionaryLinks the dictionary dictionary links
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.model.DictionaryDictionaryLink> dictionaryDictionaryLinks);

	/**
	* Creates a new dictionary dictionary link with the primary key. Does not add the dictionary dictionary link to the database.
	*
	* @param id the primary key for the new dictionary dictionary link
	* @return the new dictionary dictionary link
	*/
	public at.graz.meduni.liferay.model.DictionaryDictionaryLink create(long id);

	/**
	* Removes the dictionary dictionary link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link that was removed
	* @throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.DictionaryDictionaryLink remove(long id)
		throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.model.DictionaryDictionaryLink updateImpl(
		at.graz.meduni.liferay.model.DictionaryDictionaryLink dictionaryDictionaryLink)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dictionary dictionary link with the primary key or throws a {@link at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException} if it could not be found.
	*
	* @param id the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link
	* @throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.DictionaryDictionaryLink findByPrimaryKey(
		long id)
		throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dictionary dictionary link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link, or <code>null</code> if a dictionary dictionary link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.DictionaryDictionaryLink fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dictionary dictionary links.
	*
	* @return the dictionary dictionary links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.DictionaryDictionaryLink> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dictionary dictionary links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @return the range of dictionary dictionary links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.DictionaryDictionaryLink> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dictionary dictionary links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dictionary dictionary links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.DictionaryDictionaryLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dictionary dictionary links from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dictionary dictionary links.
	*
	* @return the number of dictionary dictionary links
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}