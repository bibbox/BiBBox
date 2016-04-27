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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the dictionary dictionary link service. This utility wraps {@link DictionaryDictionaryLinkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see DictionaryDictionaryLinkPersistence
 * @see DictionaryDictionaryLinkPersistenceImpl
 * @generated
 */
public class DictionaryDictionaryLinkUtil {
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
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		getPersistence().clearCache(dictionaryDictionaryLink);
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
	public static List<DictionaryDictionaryLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DictionaryDictionaryLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DictionaryDictionaryLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DictionaryDictionaryLink update(
		DictionaryDictionaryLink dictionaryDictionaryLink)
		throws SystemException {
		return getPersistence().update(dictionaryDictionaryLink);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DictionaryDictionaryLink update(
		DictionaryDictionaryLink dictionaryDictionaryLink,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dictionaryDictionaryLink, serviceContext);
	}

	/**
	* Returns all the dictionary dictionary links where dictionary_id = &#63;.
	*
	* @param dictionary_id the dictionary_id
	* @return the matching dictionary dictionary links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.model.DictionaryDictionaryLink> findByDictionaryId(
		long dictionary_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDictionaryId(dictionary_id);
	}

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
	public static java.util.List<at.graz.meduni.liferay.model.DictionaryDictionaryLink> findByDictionaryId(
		long dictionary_id, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDictionaryId(dictionary_id, start, end);
	}

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
	public static java.util.List<at.graz.meduni.liferay.model.DictionaryDictionaryLink> findByDictionaryId(
		long dictionary_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDictionaryId(dictionary_id, start, end,
			orderByComparator);
	}

	/**
	* Returns the first dictionary dictionary link in the ordered set where dictionary_id = &#63;.
	*
	* @param dictionary_id the dictionary_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link
	* @throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.model.DictionaryDictionaryLink findByDictionaryId_First(
		long dictionary_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDictionaryId_First(dictionary_id, orderByComparator);
	}

	/**
	* Returns the first dictionary dictionary link in the ordered set where dictionary_id = &#63;.
	*
	* @param dictionary_id the dictionary_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.model.DictionaryDictionaryLink fetchByDictionaryId_First(
		long dictionary_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDictionaryId_First(dictionary_id, orderByComparator);
	}

	/**
	* Returns the last dictionary dictionary link in the ordered set where dictionary_id = &#63;.
	*
	* @param dictionary_id the dictionary_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link
	* @throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.model.DictionaryDictionaryLink findByDictionaryId_Last(
		long dictionary_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDictionaryId_Last(dictionary_id, orderByComparator);
	}

	/**
	* Returns the last dictionary dictionary link in the ordered set where dictionary_id = &#63;.
	*
	* @param dictionary_id the dictionary_id
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.model.DictionaryDictionaryLink fetchByDictionaryId_Last(
		long dictionary_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDictionaryId_Last(dictionary_id, orderByComparator);
	}

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
	public static at.graz.meduni.liferay.model.DictionaryDictionaryLink[] findByDictionaryId_PrevAndNext(
		long id, long dictionary_id,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDictionaryId_PrevAndNext(id, dictionary_id,
			orderByComparator);
	}

	/**
	* Removes all the dictionary dictionary links where dictionary_id = &#63; from the database.
	*
	* @param dictionary_id the dictionary_id
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDictionaryId(long dictionary_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDictionaryId(dictionary_id);
	}

	/**
	* Returns the number of dictionary dictionary links where dictionary_id = &#63;.
	*
	* @param dictionary_id the dictionary_id
	* @return the number of matching dictionary dictionary links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDictionaryId(long dictionary_id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDictionaryId(dictionary_id);
	}

	/**
	* Caches the dictionary dictionary link in the entity cache if it is enabled.
	*
	* @param dictionaryDictionaryLink the dictionary dictionary link
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.model.DictionaryDictionaryLink dictionaryDictionaryLink) {
		getPersistence().cacheResult(dictionaryDictionaryLink);
	}

	/**
	* Caches the dictionary dictionary links in the entity cache if it is enabled.
	*
	* @param dictionaryDictionaryLinks the dictionary dictionary links
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.model.DictionaryDictionaryLink> dictionaryDictionaryLinks) {
		getPersistence().cacheResult(dictionaryDictionaryLinks);
	}

	/**
	* Creates a new dictionary dictionary link with the primary key. Does not add the dictionary dictionary link to the database.
	*
	* @param id the primary key for the new dictionary dictionary link
	* @return the new dictionary dictionary link
	*/
	public static at.graz.meduni.liferay.model.DictionaryDictionaryLink create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the dictionary dictionary link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link that was removed
	* @throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.model.DictionaryDictionaryLink remove(
		long id)
		throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static at.graz.meduni.liferay.model.DictionaryDictionaryLink updateImpl(
		at.graz.meduni.liferay.model.DictionaryDictionaryLink dictionaryDictionaryLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(dictionaryDictionaryLink);
	}

	/**
	* Returns the dictionary dictionary link with the primary key or throws a {@link at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException} if it could not be found.
	*
	* @param id the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link
	* @throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.model.DictionaryDictionaryLink findByPrimaryKey(
		long id)
		throws at.graz.meduni.liferay.NoSuchDictionaryDictionaryLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the dictionary dictionary link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link, or <code>null</code> if a dictionary dictionary link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.model.DictionaryDictionaryLink fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the dictionary dictionary links.
	*
	* @return the dictionary dictionary links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.model.DictionaryDictionaryLink> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<at.graz.meduni.liferay.model.DictionaryDictionaryLink> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<at.graz.meduni.liferay.model.DictionaryDictionaryLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the dictionary dictionary links from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dictionary dictionary links.
	*
	* @return the number of dictionary dictionary links
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DictionaryDictionaryLinkPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DictionaryDictionaryLinkPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.service.ClpSerializer.getServletContextName(),
					DictionaryDictionaryLinkPersistence.class.getName());

			ReferenceRegistry.registerReference(DictionaryDictionaryLinkUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DictionaryDictionaryLinkPersistence persistence) {
	}

	private static DictionaryDictionaryLinkPersistence _persistence;
}