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

package at.graz.meduni.liferay.portlet.bibbox.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the orphanet synonym service. This utility wraps {@link OrphanetSynonymPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see OrphanetSynonymPersistence
 * @see OrphanetSynonymPersistenceImpl
 * @generated
 */
public class OrphanetSynonymUtil {
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
	public static void clearCache(OrphanetSynonym orphanetSynonym) {
		getPersistence().clearCache(orphanetSynonym);
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
	public static List<OrphanetSynonym> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrphanetSynonym> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrphanetSynonym> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static OrphanetSynonym update(OrphanetSynonym orphanetSynonym)
		throws SystemException {
		return getPersistence().update(orphanetSynonym);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static OrphanetSynonym update(OrphanetSynonym orphanetSynonym,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(orphanetSynonym, serviceContext);
	}

	/**
	* Returns all the orphanet synonyms where orphanetdisorderId = &#63;.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @return the matching orphanet synonyms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym> findByOrphanetDisorderId(
		long orphanetdisorderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrphanetDisorderId(orphanetdisorderId);
	}

	/**
	* Returns a range of all the orphanet synonyms where orphanetdisorderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetSynonymModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param start the lower bound of the range of orphanet synonyms
	* @param end the upper bound of the range of orphanet synonyms (not inclusive)
	* @return the range of matching orphanet synonyms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym> findByOrphanetDisorderId(
		long orphanetdisorderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrphanetDisorderId(orphanetdisorderId, start, end);
	}

	/**
	* Returns an ordered range of all the orphanet synonyms where orphanetdisorderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetSynonymModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param start the lower bound of the range of orphanet synonyms
	* @param end the upper bound of the range of orphanet synonyms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching orphanet synonyms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym> findByOrphanetDisorderId(
		long orphanetdisorderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrphanetDisorderId(orphanetdisorderId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first orphanet synonym in the ordered set where orphanetdisorderId = &#63;.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching orphanet synonym
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException if a matching orphanet synonym could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym findByOrphanetDisorderId_First(
		long orphanetdisorderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrphanetDisorderId_First(orphanetdisorderId,
			orderByComparator);
	}

	/**
	* Returns the first orphanet synonym in the ordered set where orphanetdisorderId = &#63;.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching orphanet synonym, or <code>null</code> if a matching orphanet synonym could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym fetchByOrphanetDisorderId_First(
		long orphanetdisorderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrphanetDisorderId_First(orphanetdisorderId,
			orderByComparator);
	}

	/**
	* Returns the last orphanet synonym in the ordered set where orphanetdisorderId = &#63;.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching orphanet synonym
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException if a matching orphanet synonym could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym findByOrphanetDisorderId_Last(
		long orphanetdisorderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrphanetDisorderId_Last(orphanetdisorderId,
			orderByComparator);
	}

	/**
	* Returns the last orphanet synonym in the ordered set where orphanetdisorderId = &#63;.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching orphanet synonym, or <code>null</code> if a matching orphanet synonym could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym fetchByOrphanetDisorderId_Last(
		long orphanetdisorderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrphanetDisorderId_Last(orphanetdisorderId,
			orderByComparator);
	}

	/**
	* Returns the orphanet synonyms before and after the current orphanet synonym in the ordered set where orphanetdisorderId = &#63;.
	*
	* @param orphanetsynonymId the primary key of the current orphanet synonym
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next orphanet synonym
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException if a orphanet synonym with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym[] findByOrphanetDisorderId_PrevAndNext(
		long orphanetsynonymId, long orphanetdisorderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrphanetDisorderId_PrevAndNext(orphanetsynonymId,
			orphanetdisorderId, orderByComparator);
	}

	/**
	* Removes all the orphanet synonyms where orphanetdisorderId = &#63; from the database.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrphanetDisorderId(long orphanetdisorderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrphanetDisorderId(orphanetdisorderId);
	}

	/**
	* Returns the number of orphanet synonyms where orphanetdisorderId = &#63;.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @return the number of matching orphanet synonyms
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrphanetDisorderId(long orphanetdisorderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOrphanetDisorderId(orphanetdisorderId);
	}

	/**
	* Caches the orphanet synonym in the entity cache if it is enabled.
	*
	* @param orphanetSynonym the orphanet synonym
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym orphanetSynonym) {
		getPersistence().cacheResult(orphanetSynonym);
	}

	/**
	* Caches the orphanet synonyms in the entity cache if it is enabled.
	*
	* @param orphanetSynonyms the orphanet synonyms
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym> orphanetSynonyms) {
		getPersistence().cacheResult(orphanetSynonyms);
	}

	/**
	* Creates a new orphanet synonym with the primary key. Does not add the orphanet synonym to the database.
	*
	* @param orphanetsynonymId the primary key for the new orphanet synonym
	* @return the new orphanet synonym
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym create(
		long orphanetsynonymId) {
		return getPersistence().create(orphanetsynonymId);
	}

	/**
	* Removes the orphanet synonym with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orphanetsynonymId the primary key of the orphanet synonym
	* @return the orphanet synonym that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException if a orphanet synonym with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym remove(
		long orphanetsynonymId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(orphanetsynonymId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym orphanetSynonym)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(orphanetSynonym);
	}

	/**
	* Returns the orphanet synonym with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException} if it could not be found.
	*
	* @param orphanetsynonymId the primary key of the orphanet synonym
	* @return the orphanet synonym
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException if a orphanet synonym with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym findByPrimaryKey(
		long orphanetsynonymId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(orphanetsynonymId);
	}

	/**
	* Returns the orphanet synonym with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orphanetsynonymId the primary key of the orphanet synonym
	* @return the orphanet synonym, or <code>null</code> if a orphanet synonym with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym fetchByPrimaryKey(
		long orphanetsynonymId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(orphanetsynonymId);
	}

	/**
	* Returns all the orphanet synonyms.
	*
	* @return the orphanet synonyms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the orphanet synonyms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetSynonymModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of orphanet synonyms
	* @param end the upper bound of the range of orphanet synonyms (not inclusive)
	* @return the range of orphanet synonyms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the orphanet synonyms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetSynonymModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of orphanet synonyms
	* @param end the upper bound of the range of orphanet synonyms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of orphanet synonyms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the orphanet synonyms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of orphanet synonyms.
	*
	* @return the number of orphanet synonyms
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OrphanetSynonymPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OrphanetSynonymPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.service.ClpSerializer.getServletContextName(),
					OrphanetSynonymPersistence.class.getName());

			ReferenceRegistry.registerReference(OrphanetSynonymUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(OrphanetSynonymPersistence persistence) {
	}

	private static OrphanetSynonymPersistence _persistence;
}