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

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the kdssmp parameter options service. This utility wraps {@link KdssmpParameterOptionsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see KdssmpParameterOptionsPersistence
 * @see KdssmpParameterOptionsPersistenceImpl
 * @generated
 */
public class KdssmpParameterOptionsUtil {
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
	public static void clearCache(KdssmpParameterOptions kdssmpParameterOptions) {
		getPersistence().clearCache(kdssmpParameterOptions);
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
	public static List<KdssmpParameterOptions> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<KdssmpParameterOptions> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<KdssmpParameterOptions> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static KdssmpParameterOptions update(
		KdssmpParameterOptions kdssmpParameterOptions)
		throws SystemException {
		return getPersistence().update(kdssmpParameterOptions);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static KdssmpParameterOptions update(
		KdssmpParameterOptions kdssmpParameterOptions,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(kdssmpParameterOptions, serviceContext);
	}

	/**
	* Returns all the kdssmp parameter optionses where parameterconfigurationId = &#63;.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @return the matching kdssmp parameter optionses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions> findByOptions(
		long parameterconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOptions(parameterconfigurationId);
	}

	/**
	* Returns a range of all the kdssmp parameter optionses where parameterconfigurationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpParameterOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @param start the lower bound of the range of kdssmp parameter optionses
	* @param end the upper bound of the range of kdssmp parameter optionses (not inclusive)
	* @return the range of matching kdssmp parameter optionses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions> findByOptions(
		long parameterconfigurationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOptions(parameterconfigurationId, start, end);
	}

	/**
	* Returns an ordered range of all the kdssmp parameter optionses where parameterconfigurationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpParameterOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @param start the lower bound of the range of kdssmp parameter optionses
	* @param end the upper bound of the range of kdssmp parameter optionses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kdssmp parameter optionses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions> findByOptions(
		long parameterconfigurationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOptions(parameterconfigurationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first kdssmp parameter options in the ordered set where parameterconfigurationId = &#63;.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kdssmp parameter options
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException if a matching kdssmp parameter options could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions findByOptions_First(
		long parameterconfigurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOptions_First(parameterconfigurationId,
			orderByComparator);
	}

	/**
	* Returns the first kdssmp parameter options in the ordered set where parameterconfigurationId = &#63;.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kdssmp parameter options, or <code>null</code> if a matching kdssmp parameter options could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions fetchByOptions_First(
		long parameterconfigurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOptions_First(parameterconfigurationId,
			orderByComparator);
	}

	/**
	* Returns the last kdssmp parameter options in the ordered set where parameterconfigurationId = &#63;.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kdssmp parameter options
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException if a matching kdssmp parameter options could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions findByOptions_Last(
		long parameterconfigurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOptions_Last(parameterconfigurationId,
			orderByComparator);
	}

	/**
	* Returns the last kdssmp parameter options in the ordered set where parameterconfigurationId = &#63;.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kdssmp parameter options, or <code>null</code> if a matching kdssmp parameter options could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions fetchByOptions_Last(
		long parameterconfigurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOptions_Last(parameterconfigurationId,
			orderByComparator);
	}

	/**
	* Returns the kdssmp parameter optionses before and after the current kdssmp parameter options in the ordered set where parameterconfigurationId = &#63;.
	*
	* @param parameteroptionsId the primary key of the current kdssmp parameter options
	* @param parameterconfigurationId the parameterconfiguration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kdssmp parameter options
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException if a kdssmp parameter options with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions[] findByOptions_PrevAndNext(
		long parameteroptionsId, long parameterconfigurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOptions_PrevAndNext(parameteroptionsId,
			parameterconfigurationId, orderByComparator);
	}

	/**
	* Removes all the kdssmp parameter optionses where parameterconfigurationId = &#63; from the database.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOptions(long parameterconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOptions(parameterconfigurationId);
	}

	/**
	* Returns the number of kdssmp parameter optionses where parameterconfigurationId = &#63;.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @return the number of matching kdssmp parameter optionses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOptions(long parameterconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOptions(parameterconfigurationId);
	}

	/**
	* Caches the kdssmp parameter options in the entity cache if it is enabled.
	*
	* @param kdssmpParameterOptions the kdssmp parameter options
	*/
	public static void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions kdssmpParameterOptions) {
		getPersistence().cacheResult(kdssmpParameterOptions);
	}

	/**
	* Caches the kdssmp parameter optionses in the entity cache if it is enabled.
	*
	* @param kdssmpParameterOptionses the kdssmp parameter optionses
	*/
	public static void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions> kdssmpParameterOptionses) {
		getPersistence().cacheResult(kdssmpParameterOptionses);
	}

	/**
	* Creates a new kdssmp parameter options with the primary key. Does not add the kdssmp parameter options to the database.
	*
	* @param parameteroptionsId the primary key for the new kdssmp parameter options
	* @return the new kdssmp parameter options
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions create(
		long parameteroptionsId) {
		return getPersistence().create(parameteroptionsId);
	}

	/**
	* Removes the kdssmp parameter options with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param parameteroptionsId the primary key of the kdssmp parameter options
	* @return the kdssmp parameter options that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException if a kdssmp parameter options with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions remove(
		long parameteroptionsId)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(parameteroptionsId);
	}

	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions kdssmpParameterOptions)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(kdssmpParameterOptions);
	}

	/**
	* Returns the kdssmp parameter options with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException} if it could not be found.
	*
	* @param parameteroptionsId the primary key of the kdssmp parameter options
	* @return the kdssmp parameter options
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException if a kdssmp parameter options with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions findByPrimaryKey(
		long parameteroptionsId)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(parameteroptionsId);
	}

	/**
	* Returns the kdssmp parameter options with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param parameteroptionsId the primary key of the kdssmp parameter options
	* @return the kdssmp parameter options, or <code>null</code> if a kdssmp parameter options with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions fetchByPrimaryKey(
		long parameteroptionsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(parameteroptionsId);
	}

	/**
	* Returns all the kdssmp parameter optionses.
	*
	* @return the kdssmp parameter optionses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the kdssmp parameter optionses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpParameterOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kdssmp parameter optionses
	* @param end the upper bound of the range of kdssmp parameter optionses (not inclusive)
	* @return the range of kdssmp parameter optionses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the kdssmp parameter optionses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpParameterOptionsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kdssmp parameter optionses
	* @param end the upper bound of the range of kdssmp parameter optionses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of kdssmp parameter optionses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the kdssmp parameter optionses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of kdssmp parameter optionses.
	*
	* @return the number of kdssmp parameter optionses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static KdssmpParameterOptionsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (KdssmpParameterOptionsPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.ClpSerializer.getServletContextName(),
					KdssmpParameterOptionsPersistence.class.getName());

			ReferenceRegistry.registerReference(KdssmpParameterOptionsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(KdssmpParameterOptionsPersistence persistence) {
	}

	private static KdssmpParameterOptionsPersistence _persistence;
}