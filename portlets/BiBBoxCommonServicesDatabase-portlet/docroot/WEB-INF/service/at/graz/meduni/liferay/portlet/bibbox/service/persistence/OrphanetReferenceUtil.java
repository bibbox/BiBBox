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

import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the orphanet reference service. This utility wraps {@link OrphanetReferencePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see OrphanetReferencePersistence
 * @see OrphanetReferencePersistenceImpl
 * @generated
 */
public class OrphanetReferenceUtil {
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
	public static void clearCache(OrphanetReference orphanetReference) {
		getPersistence().clearCache(orphanetReference);
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
	public static List<OrphanetReference> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrphanetReference> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrphanetReference> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static OrphanetReference update(OrphanetReference orphanetReference)
		throws SystemException {
		return getPersistence().update(orphanetReference);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static OrphanetReference update(
		OrphanetReference orphanetReference, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(orphanetReference, serviceContext);
	}

	/**
	* Returns all the orphanet references where orphanetdisorderId = &#63; and source = &#63;.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param source the source
	* @return the matching orphanet references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference> findByOrphanetDisorderIdAndSource(
		long orphanetdisorderId, java.lang.String source)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrphanetDisorderIdAndSource(orphanetdisorderId, source);
	}

	/**
	* Returns a range of all the orphanet references where orphanetdisorderId = &#63; and source = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param source the source
	* @param start the lower bound of the range of orphanet references
	* @param end the upper bound of the range of orphanet references (not inclusive)
	* @return the range of matching orphanet references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference> findByOrphanetDisorderIdAndSource(
		long orphanetdisorderId, java.lang.String source, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrphanetDisorderIdAndSource(orphanetdisorderId,
			source, start, end);
	}

	/**
	* Returns an ordered range of all the orphanet references where orphanetdisorderId = &#63; and source = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param source the source
	* @param start the lower bound of the range of orphanet references
	* @param end the upper bound of the range of orphanet references (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching orphanet references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference> findByOrphanetDisorderIdAndSource(
		long orphanetdisorderId, java.lang.String source, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrphanetDisorderIdAndSource(orphanetdisorderId,
			source, start, end, orderByComparator);
	}

	/**
	* Returns the first orphanet reference in the ordered set where orphanetdisorderId = &#63; and source = &#63;.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param source the source
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching orphanet reference
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException if a matching orphanet reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference findByOrphanetDisorderIdAndSource_First(
		long orphanetdisorderId, java.lang.String source,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrphanetDisorderIdAndSource_First(orphanetdisorderId,
			source, orderByComparator);
	}

	/**
	* Returns the first orphanet reference in the ordered set where orphanetdisorderId = &#63; and source = &#63;.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param source the source
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching orphanet reference, or <code>null</code> if a matching orphanet reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference fetchByOrphanetDisorderIdAndSource_First(
		long orphanetdisorderId, java.lang.String source,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrphanetDisorderIdAndSource_First(orphanetdisorderId,
			source, orderByComparator);
	}

	/**
	* Returns the last orphanet reference in the ordered set where orphanetdisorderId = &#63; and source = &#63;.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param source the source
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching orphanet reference
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException if a matching orphanet reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference findByOrphanetDisorderIdAndSource_Last(
		long orphanetdisorderId, java.lang.String source,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrphanetDisorderIdAndSource_Last(orphanetdisorderId,
			source, orderByComparator);
	}

	/**
	* Returns the last orphanet reference in the ordered set where orphanetdisorderId = &#63; and source = &#63;.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param source the source
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching orphanet reference, or <code>null</code> if a matching orphanet reference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference fetchByOrphanetDisorderIdAndSource_Last(
		long orphanetdisorderId, java.lang.String source,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOrphanetDisorderIdAndSource_Last(orphanetdisorderId,
			source, orderByComparator);
	}

	/**
	* Returns the orphanet references before and after the current orphanet reference in the ordered set where orphanetdisorderId = &#63; and source = &#63;.
	*
	* @param orphanetreferenceId the primary key of the current orphanet reference
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param source the source
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next orphanet reference
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException if a orphanet reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference[] findByOrphanetDisorderIdAndSource_PrevAndNext(
		long orphanetreferenceId, long orphanetdisorderId,
		java.lang.String source,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrphanetDisorderIdAndSource_PrevAndNext(orphanetreferenceId,
			orphanetdisorderId, source, orderByComparator);
	}

	/**
	* Removes all the orphanet references where orphanetdisorderId = &#63; and source = &#63; from the database.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param source the source
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrphanetDisorderIdAndSource(
		long orphanetdisorderId, java.lang.String source)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByOrphanetDisorderIdAndSource(orphanetdisorderId, source);
	}

	/**
	* Returns the number of orphanet references where orphanetdisorderId = &#63; and source = &#63;.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param source the source
	* @return the number of matching orphanet references
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrphanetDisorderIdAndSource(
		long orphanetdisorderId, java.lang.String source)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByOrphanetDisorderIdAndSource(orphanetdisorderId,
			source);
	}

	/**
	* Caches the orphanet reference in the entity cache if it is enabled.
	*
	* @param orphanetReference the orphanet reference
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference orphanetReference) {
		getPersistence().cacheResult(orphanetReference);
	}

	/**
	* Caches the orphanet references in the entity cache if it is enabled.
	*
	* @param orphanetReferences the orphanet references
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference> orphanetReferences) {
		getPersistence().cacheResult(orphanetReferences);
	}

	/**
	* Creates a new orphanet reference with the primary key. Does not add the orphanet reference to the database.
	*
	* @param orphanetreferenceId the primary key for the new orphanet reference
	* @return the new orphanet reference
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference create(
		long orphanetreferenceId) {
		return getPersistence().create(orphanetreferenceId);
	}

	/**
	* Removes the orphanet reference with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orphanetreferenceId the primary key of the orphanet reference
	* @return the orphanet reference that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException if a orphanet reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference remove(
		long orphanetreferenceId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(orphanetreferenceId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference orphanetReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(orphanetReference);
	}

	/**
	* Returns the orphanet reference with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException} if it could not be found.
	*
	* @param orphanetreferenceId the primary key of the orphanet reference
	* @return the orphanet reference
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException if a orphanet reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference findByPrimaryKey(
		long orphanetreferenceId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(orphanetreferenceId);
	}

	/**
	* Returns the orphanet reference with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orphanetreferenceId the primary key of the orphanet reference
	* @return the orphanet reference, or <code>null</code> if a orphanet reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference fetchByPrimaryKey(
		long orphanetreferenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(orphanetreferenceId);
	}

	/**
	* Returns all the orphanet references.
	*
	* @return the orphanet references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the orphanet references.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of orphanet references
	* @param end the upper bound of the range of orphanet references (not inclusive)
	* @return the range of orphanet references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the orphanet references.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of orphanet references
	* @param end the upper bound of the range of orphanet references (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of orphanet references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the orphanet references from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of orphanet references.
	*
	* @return the number of orphanet references
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OrphanetReferencePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OrphanetReferencePersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.service.ClpSerializer.getServletContextName(),
					OrphanetReferencePersistence.class.getName());

			ReferenceRegistry.registerReference(OrphanetReferenceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(OrphanetReferencePersistence persistence) {
	}

	private static OrphanetReferencePersistence _persistence;
}