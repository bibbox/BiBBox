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

import at.graz.meduni.liferay.model.Dictionary;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the dictionary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see DictionaryPersistenceImpl
 * @see DictionaryUtil
 * @generated
 */
public interface DictionaryPersistence extends BasePersistence<Dictionary> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DictionaryUtil} to access the dictionary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the dictionaries where synonym = &#63;.
	*
	* @param synonym the synonym
	* @return the matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.Dictionary> findBySynonym(
		java.lang.String synonym)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dictionaries where synonym = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param synonym the synonym
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @return the range of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.Dictionary> findBySynonym(
		java.lang.String synonym, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dictionaries where synonym = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param synonym the synonym
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.Dictionary> findBySynonym(
		java.lang.String synonym, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dictionary in the ordered set where synonym = &#63;.
	*
	* @param synonym the synonym
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary
	* @throws at.graz.meduni.liferay.NoSuchDictionaryException if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.Dictionary findBySynonym_First(
		java.lang.String synonym,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dictionary in the ordered set where synonym = &#63;.
	*
	* @param synonym the synonym
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.Dictionary fetchBySynonym_First(
		java.lang.String synonym,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dictionary in the ordered set where synonym = &#63;.
	*
	* @param synonym the synonym
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary
	* @throws at.graz.meduni.liferay.NoSuchDictionaryException if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.Dictionary findBySynonym_Last(
		java.lang.String synonym,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dictionary in the ordered set where synonym = &#63;.
	*
	* @param synonym the synonym
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.Dictionary fetchBySynonym_Last(
		java.lang.String synonym,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dictionaries before and after the current dictionary in the ordered set where synonym = &#63;.
	*
	* @param dictionary_id the primary key of the current dictionary
	* @param synonym the synonym
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary
	* @throws at.graz.meduni.liferay.NoSuchDictionaryException if a dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.Dictionary[] findBySynonym_PrevAndNext(
		long dictionary_id, java.lang.String synonym,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dictionaries where synonym = &#63; from the database.
	*
	* @param synonym the synonym
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySynonym(java.lang.String synonym)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dictionaries where synonym = &#63;.
	*
	* @param synonym the synonym
	* @return the number of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public int countBySynonym(java.lang.String synonym)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dictionaries where root = &#63;.
	*
	* @param root the root
	* @return the matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.Dictionary> findByRootNodes(
		boolean root)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dictionaries where root = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param root the root
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @return the range of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.Dictionary> findByRootNodes(
		boolean root, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dictionaries where root = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param root the root
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.Dictionary> findByRootNodes(
		boolean root, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dictionary in the ordered set where root = &#63;.
	*
	* @param root the root
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary
	* @throws at.graz.meduni.liferay.NoSuchDictionaryException if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.Dictionary findByRootNodes_First(
		boolean root,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dictionary in the ordered set where root = &#63;.
	*
	* @param root the root
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.Dictionary fetchByRootNodes_First(
		boolean root,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dictionary in the ordered set where root = &#63;.
	*
	* @param root the root
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary
	* @throws at.graz.meduni.liferay.NoSuchDictionaryException if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.Dictionary findByRootNodes_Last(
		boolean root,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dictionary in the ordered set where root = &#63;.
	*
	* @param root the root
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.Dictionary fetchByRootNodes_Last(
		boolean root,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dictionaries before and after the current dictionary in the ordered set where root = &#63;.
	*
	* @param dictionary_id the primary key of the current dictionary
	* @param root the root
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary
	* @throws at.graz.meduni.liferay.NoSuchDictionaryException if a dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.Dictionary[] findByRootNodes_PrevAndNext(
		long dictionary_id, boolean root,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dictionaries where root = &#63; from the database.
	*
	* @param root the root
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRootNodes(boolean root)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dictionaries where root = &#63;.
	*
	* @param root the root
	* @return the number of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public int countByRootNodes(boolean root)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the dictionary in the entity cache if it is enabled.
	*
	* @param dictionary the dictionary
	*/
	public void cacheResult(at.graz.meduni.liferay.model.Dictionary dictionary);

	/**
	* Caches the dictionaries in the entity cache if it is enabled.
	*
	* @param dictionaries the dictionaries
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.model.Dictionary> dictionaries);

	/**
	* Creates a new dictionary with the primary key. Does not add the dictionary to the database.
	*
	* @param dictionary_id the primary key for the new dictionary
	* @return the new dictionary
	*/
	public at.graz.meduni.liferay.model.Dictionary create(long dictionary_id);

	/**
	* Removes the dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionary_id the primary key of the dictionary
	* @return the dictionary that was removed
	* @throws at.graz.meduni.liferay.NoSuchDictionaryException if a dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.Dictionary remove(long dictionary_id)
		throws at.graz.meduni.liferay.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.model.Dictionary updateImpl(
		at.graz.meduni.liferay.model.Dictionary dictionary)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dictionary with the primary key or throws a {@link at.graz.meduni.liferay.NoSuchDictionaryException} if it could not be found.
	*
	* @param dictionary_id the primary key of the dictionary
	* @return the dictionary
	* @throws at.graz.meduni.liferay.NoSuchDictionaryException if a dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.Dictionary findByPrimaryKey(
		long dictionary_id)
		throws at.graz.meduni.liferay.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dictionary with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dictionary_id the primary key of the dictionary
	* @return the dictionary, or <code>null</code> if a dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.Dictionary fetchByPrimaryKey(
		long dictionary_id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dictionaries.
	*
	* @return the dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.Dictionary> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dictionaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @return the range of dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.Dictionary> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dictionaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.Dictionary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dictionaries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dictionaries.
	*
	* @return the number of dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}