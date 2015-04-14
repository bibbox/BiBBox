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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the patientnamegenerator service. This utility wraps {@link patientnamegeneratorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see patientnamegeneratorPersistence
 * @see patientnamegeneratorPersistenceImpl
 * @generated
 */
public class patientnamegeneratorUtil {
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
	public static void clearCache(patientnamegenerator patientnamegenerator) {
		getPersistence().clearCache(patientnamegenerator);
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
	public static List<patientnamegenerator> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<patientnamegenerator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<patientnamegenerator> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static patientnamegenerator update(
		patientnamegenerator patientnamegenerator) throws SystemException {
		return getPersistence().update(patientnamegenerator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static patientnamegenerator update(
		patientnamegenerator patientnamegenerator, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(patientnamegenerator, serviceContext);
	}

	/**
	* Returns all the patientnamegenerators where name = &#63; and type = &#63;.
	*
	* @param name the name
	* @param type the type
	* @return the matching patientnamegenerators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator> findByNames(
		java.lang.String name, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNames(name, type);
	}

	/**
	* Returns a range of all the patientnamegenerators where name = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.patientnamegeneratorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param type the type
	* @param start the lower bound of the range of patientnamegenerators
	* @param end the upper bound of the range of patientnamegenerators (not inclusive)
	* @return the range of matching patientnamegenerators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator> findByNames(
		java.lang.String name, java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNames(name, type, start, end);
	}

	/**
	* Returns an ordered range of all the patientnamegenerators where name = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.patientnamegeneratorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param type the type
	* @param start the lower bound of the range of patientnamegenerators
	* @param end the upper bound of the range of patientnamegenerators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching patientnamegenerators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator> findByNames(
		java.lang.String name, java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNames(name, type, start, end, orderByComparator);
	}

	/**
	* Returns the first patientnamegenerator in the ordered set where name = &#63; and type = &#63;.
	*
	* @param name the name
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patientnamegenerator
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException if a matching patientnamegenerator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator findByNames_First(
		java.lang.String name, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNames_First(name, type, orderByComparator);
	}

	/**
	* Returns the first patientnamegenerator in the ordered set where name = &#63; and type = &#63;.
	*
	* @param name the name
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching patientnamegenerator, or <code>null</code> if a matching patientnamegenerator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator fetchByNames_First(
		java.lang.String name, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNames_First(name, type, orderByComparator);
	}

	/**
	* Returns the last patientnamegenerator in the ordered set where name = &#63; and type = &#63;.
	*
	* @param name the name
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patientnamegenerator
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException if a matching patientnamegenerator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator findByNames_Last(
		java.lang.String name, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNames_Last(name, type, orderByComparator);
	}

	/**
	* Returns the last patientnamegenerator in the ordered set where name = &#63; and type = &#63;.
	*
	* @param name the name
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching patientnamegenerator, or <code>null</code> if a matching patientnamegenerator could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator fetchByNames_Last(
		java.lang.String name, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNames_Last(name, type, orderByComparator);
	}

	/**
	* Returns the patientnamegenerators before and after the current patientnamegenerator in the ordered set where name = &#63; and type = &#63;.
	*
	* @param patientnamegeneratorId the primary key of the current patientnamegenerator
	* @param name the name
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next patientnamegenerator
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException if a patientnamegenerator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator[] findByNames_PrevAndNext(
		long patientnamegeneratorId, java.lang.String name,
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNames_PrevAndNext(patientnamegeneratorId, name, type,
			orderByComparator);
	}

	/**
	* Removes all the patientnamegenerators where name = &#63; and type = &#63; from the database.
	*
	* @param name the name
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNames(java.lang.String name,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNames(name, type);
	}

	/**
	* Returns the number of patientnamegenerators where name = &#63; and type = &#63;.
	*
	* @param name the name
	* @param type the type
	* @return the number of matching patientnamegenerators
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNames(java.lang.String name, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNames(name, type);
	}

	/**
	* Caches the patientnamegenerator in the entity cache if it is enabled.
	*
	* @param patientnamegenerator the patientnamegenerator
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator patientnamegenerator) {
		getPersistence().cacheResult(patientnamegenerator);
	}

	/**
	* Caches the patientnamegenerators in the entity cache if it is enabled.
	*
	* @param patientnamegenerators the patientnamegenerators
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator> patientnamegenerators) {
		getPersistence().cacheResult(patientnamegenerators);
	}

	/**
	* Creates a new patientnamegenerator with the primary key. Does not add the patientnamegenerator to the database.
	*
	* @param patientnamegeneratorId the primary key for the new patientnamegenerator
	* @return the new patientnamegenerator
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator create(
		long patientnamegeneratorId) {
		return getPersistence().create(patientnamegeneratorId);
	}

	/**
	* Removes the patientnamegenerator with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param patientnamegeneratorId the primary key of the patientnamegenerator
	* @return the patientnamegenerator that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException if a patientnamegenerator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator remove(
		long patientnamegeneratorId)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(patientnamegeneratorId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator patientnamegenerator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(patientnamegenerator);
	}

	/**
	* Returns the patientnamegenerator with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException} if it could not be found.
	*
	* @param patientnamegeneratorId the primary key of the patientnamegenerator
	* @return the patientnamegenerator
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException if a patientnamegenerator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator findByPrimaryKey(
		long patientnamegeneratorId)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchpatientnamegeneratorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(patientnamegeneratorId);
	}

	/**
	* Returns the patientnamegenerator with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param patientnamegeneratorId the primary key of the patientnamegenerator
	* @return the patientnamegenerator, or <code>null</code> if a patientnamegenerator with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator fetchByPrimaryKey(
		long patientnamegeneratorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(patientnamegeneratorId);
	}

	/**
	* Returns all the patientnamegenerators.
	*
	* @return the patientnamegenerators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the patientnamegenerators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.patientnamegeneratorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of patientnamegenerators
	* @param end the upper bound of the range of patientnamegenerators (not inclusive)
	* @return the range of patientnamegenerators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the patientnamegenerators.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.patientnamegeneratorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of patientnamegenerators
	* @param end the upper bound of the range of patientnamegenerators (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of patientnamegenerators
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.patientnamegenerator> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the patientnamegenerators from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of patientnamegenerators.
	*
	* @return the number of patientnamegenerators
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static patientnamegeneratorPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (patientnamegeneratorPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.ClpSerializer.getServletContextName(),
					patientnamegeneratorPersistence.class.getName());

			ReferenceRegistry.registerReference(patientnamegeneratorUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(patientnamegeneratorPersistence persistence) {
	}

	private static patientnamegeneratorPersistence _persistence;
}