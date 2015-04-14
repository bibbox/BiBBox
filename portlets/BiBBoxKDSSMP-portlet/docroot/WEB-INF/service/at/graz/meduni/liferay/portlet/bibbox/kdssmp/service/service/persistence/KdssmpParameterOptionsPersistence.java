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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the kdssmp parameter options service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see KdssmpParameterOptionsPersistenceImpl
 * @see KdssmpParameterOptionsUtil
 * @generated
 */
public interface KdssmpParameterOptionsPersistence extends BasePersistence<KdssmpParameterOptions> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link KdssmpParameterOptionsUtil} to access the kdssmp parameter options persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the kdssmp parameter optionses where parameterconfigurationId = &#63;.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @return the matching kdssmp parameter optionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions> findByOptions(
		long parameterconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions> findByOptions(
		long parameterconfigurationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions> findByOptions(
		long parameterconfigurationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first kdssmp parameter options in the ordered set where parameterconfigurationId = &#63;.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kdssmp parameter options
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException if a matching kdssmp parameter options could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions findByOptions_First(
		long parameterconfigurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first kdssmp parameter options in the ordered set where parameterconfigurationId = &#63;.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kdssmp parameter options, or <code>null</code> if a matching kdssmp parameter options could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions fetchByOptions_First(
		long parameterconfigurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last kdssmp parameter options in the ordered set where parameterconfigurationId = &#63;.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kdssmp parameter options
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException if a matching kdssmp parameter options could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions findByOptions_Last(
		long parameterconfigurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last kdssmp parameter options in the ordered set where parameterconfigurationId = &#63;.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kdssmp parameter options, or <code>null</code> if a matching kdssmp parameter options could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions fetchByOptions_Last(
		long parameterconfigurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions[] findByOptions_PrevAndNext(
		long parameteroptionsId, long parameterconfigurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the kdssmp parameter optionses where parameterconfigurationId = &#63; from the database.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOptions(long parameterconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kdssmp parameter optionses where parameterconfigurationId = &#63;.
	*
	* @param parameterconfigurationId the parameterconfiguration ID
	* @return the number of matching kdssmp parameter optionses
	* @throws SystemException if a system exception occurred
	*/
	public int countByOptions(long parameterconfigurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the kdssmp parameter options in the entity cache if it is enabled.
	*
	* @param kdssmpParameterOptions the kdssmp parameter options
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions kdssmpParameterOptions);

	/**
	* Caches the kdssmp parameter optionses in the entity cache if it is enabled.
	*
	* @param kdssmpParameterOptionses the kdssmp parameter optionses
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions> kdssmpParameterOptionses);

	/**
	* Creates a new kdssmp parameter options with the primary key. Does not add the kdssmp parameter options to the database.
	*
	* @param parameteroptionsId the primary key for the new kdssmp parameter options
	* @return the new kdssmp parameter options
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions create(
		long parameteroptionsId);

	/**
	* Removes the kdssmp parameter options with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param parameteroptionsId the primary key of the kdssmp parameter options
	* @return the kdssmp parameter options that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException if a kdssmp parameter options with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions remove(
		long parameteroptionsId)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions kdssmpParameterOptions)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kdssmp parameter options with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException} if it could not be found.
	*
	* @param parameteroptionsId the primary key of the kdssmp parameter options
	* @return the kdssmp parameter options
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException if a kdssmp parameter options with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions findByPrimaryKey(
		long parameteroptionsId)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpParameterOptionsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kdssmp parameter options with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param parameteroptionsId the primary key of the kdssmp parameter options
	* @return the kdssmp parameter options, or <code>null</code> if a kdssmp parameter options with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions fetchByPrimaryKey(
		long parameteroptionsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the kdssmp parameter optionses.
	*
	* @return the kdssmp parameter optionses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpParameterOptions> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the kdssmp parameter optionses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kdssmp parameter optionses.
	*
	* @return the number of kdssmp parameter optionses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}