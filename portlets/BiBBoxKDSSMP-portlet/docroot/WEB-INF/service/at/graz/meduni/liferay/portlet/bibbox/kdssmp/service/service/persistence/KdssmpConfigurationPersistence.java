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

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the kdssmp configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see KdssmpConfigurationPersistenceImpl
 * @see KdssmpConfigurationUtil
 * @generated
 */
public interface KdssmpConfigurationPersistence extends BasePersistence<KdssmpConfiguration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link KdssmpConfigurationUtil} to access the kdssmp configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the kdssmp configuration where scope = &#63; and optionkey = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException} if it could not be found.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @return the matching kdssmp configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a matching kdssmp configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration findByoptionfinder(
		java.lang.String scope, java.lang.String optionkey)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kdssmp configuration where scope = &#63; and optionkey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @return the matching kdssmp configuration, or <code>null</code> if a matching kdssmp configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration fetchByoptionfinder(
		java.lang.String scope, java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kdssmp configuration where scope = &#63; and optionkey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching kdssmp configuration, or <code>null</code> if a matching kdssmp configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration fetchByoptionfinder(
		java.lang.String scope, java.lang.String optionkey,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the kdssmp configuration where scope = &#63; and optionkey = &#63; from the database.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @return the kdssmp configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration removeByoptionfinder(
		java.lang.String scope, java.lang.String optionkey)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kdssmp configurations where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @return the number of matching kdssmp configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countByoptionfinder(java.lang.String scope,
		java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kdssmp configuration where scope = &#63; and optionvalue = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException} if it could not be found.
	*
	* @param scope the scope
	* @param optionvalue the optionvalue
	* @return the matching kdssmp configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a matching kdssmp configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration findByoptionsfindervalue(
		java.lang.String scope, java.lang.String optionvalue)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kdssmp configuration where scope = &#63; and optionvalue = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param scope the scope
	* @param optionvalue the optionvalue
	* @return the matching kdssmp configuration, or <code>null</code> if a matching kdssmp configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration fetchByoptionsfindervalue(
		java.lang.String scope, java.lang.String optionvalue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kdssmp configuration where scope = &#63; and optionvalue = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param scope the scope
	* @param optionvalue the optionvalue
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching kdssmp configuration, or <code>null</code> if a matching kdssmp configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration fetchByoptionsfindervalue(
		java.lang.String scope, java.lang.String optionvalue,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the kdssmp configuration where scope = &#63; and optionvalue = &#63; from the database.
	*
	* @param scope the scope
	* @param optionvalue the optionvalue
	* @return the kdssmp configuration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration removeByoptionsfindervalue(
		java.lang.String scope, java.lang.String optionvalue)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kdssmp configurations where scope = &#63; and optionvalue = &#63;.
	*
	* @param scope the scope
	* @param optionvalue the optionvalue
	* @return the number of matching kdssmp configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countByoptionsfindervalue(java.lang.String scope,
		java.lang.String optionvalue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the kdssmp configurations where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @return the matching kdssmp configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration> findByoptionsfinderkey(
		java.lang.String scope, java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the kdssmp configurations where scope = &#63; and optionkey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @param start the lower bound of the range of kdssmp configurations
	* @param end the upper bound of the range of kdssmp configurations (not inclusive)
	* @return the range of matching kdssmp configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration> findByoptionsfinderkey(
		java.lang.String scope, java.lang.String optionkey, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the kdssmp configurations where scope = &#63; and optionkey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @param start the lower bound of the range of kdssmp configurations
	* @param end the upper bound of the range of kdssmp configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kdssmp configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration> findByoptionsfinderkey(
		java.lang.String scope, java.lang.String optionkey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first kdssmp configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kdssmp configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a matching kdssmp configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration findByoptionsfinderkey_First(
		java.lang.String scope, java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first kdssmp configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kdssmp configuration, or <code>null</code> if a matching kdssmp configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration fetchByoptionsfinderkey_First(
		java.lang.String scope, java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last kdssmp configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kdssmp configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a matching kdssmp configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration findByoptionsfinderkey_Last(
		java.lang.String scope, java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last kdssmp configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kdssmp configuration, or <code>null</code> if a matching kdssmp configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration fetchByoptionsfinderkey_Last(
		java.lang.String scope, java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kdssmp configurations before and after the current kdssmp configuration in the ordered set where scope = &#63; and optionkey = &#63;.
	*
	* @param configurationId the primary key of the current kdssmp configuration
	* @param scope the scope
	* @param optionkey the optionkey
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kdssmp configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a kdssmp configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration[] findByoptionsfinderkey_PrevAndNext(
		long configurationId, java.lang.String scope,
		java.lang.String optionkey,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the kdssmp configurations where scope = &#63; and optionkey = &#63; from the database.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @throws SystemException if a system exception occurred
	*/
	public void removeByoptionsfinderkey(java.lang.String scope,
		java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kdssmp configurations where scope = &#63; and optionkey = &#63;.
	*
	* @param scope the scope
	* @param optionkey the optionkey
	* @return the number of matching kdssmp configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countByoptionsfinderkey(java.lang.String scope,
		java.lang.String optionkey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the kdssmp configurations where scope = &#63;.
	*
	* @param scope the scope
	* @return the matching kdssmp configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration> findByoptionsfinder(
		java.lang.String scope)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the kdssmp configurations where scope = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scope the scope
	* @param start the lower bound of the range of kdssmp configurations
	* @param end the upper bound of the range of kdssmp configurations (not inclusive)
	* @return the range of matching kdssmp configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration> findByoptionsfinder(
		java.lang.String scope, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the kdssmp configurations where scope = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scope the scope
	* @param start the lower bound of the range of kdssmp configurations
	* @param end the upper bound of the range of kdssmp configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kdssmp configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration> findByoptionsfinder(
		java.lang.String scope, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first kdssmp configuration in the ordered set where scope = &#63;.
	*
	* @param scope the scope
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kdssmp configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a matching kdssmp configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration findByoptionsfinder_First(
		java.lang.String scope,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first kdssmp configuration in the ordered set where scope = &#63;.
	*
	* @param scope the scope
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kdssmp configuration, or <code>null</code> if a matching kdssmp configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration fetchByoptionsfinder_First(
		java.lang.String scope,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last kdssmp configuration in the ordered set where scope = &#63;.
	*
	* @param scope the scope
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kdssmp configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a matching kdssmp configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration findByoptionsfinder_Last(
		java.lang.String scope,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last kdssmp configuration in the ordered set where scope = &#63;.
	*
	* @param scope the scope
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kdssmp configuration, or <code>null</code> if a matching kdssmp configuration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration fetchByoptionsfinder_Last(
		java.lang.String scope,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kdssmp configurations before and after the current kdssmp configuration in the ordered set where scope = &#63;.
	*
	* @param configurationId the primary key of the current kdssmp configuration
	* @param scope the scope
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kdssmp configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a kdssmp configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration[] findByoptionsfinder_PrevAndNext(
		long configurationId, java.lang.String scope,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the kdssmp configurations where scope = &#63; from the database.
	*
	* @param scope the scope
	* @throws SystemException if a system exception occurred
	*/
	public void removeByoptionsfinder(java.lang.String scope)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kdssmp configurations where scope = &#63;.
	*
	* @param scope the scope
	* @return the number of matching kdssmp configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countByoptionsfinder(java.lang.String scope)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the kdssmp configuration in the entity cache if it is enabled.
	*
	* @param kdssmpConfiguration the kdssmp configuration
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration kdssmpConfiguration);

	/**
	* Caches the kdssmp configurations in the entity cache if it is enabled.
	*
	* @param kdssmpConfigurations the kdssmp configurations
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration> kdssmpConfigurations);

	/**
	* Creates a new kdssmp configuration with the primary key. Does not add the kdssmp configuration to the database.
	*
	* @param configurationId the primary key for the new kdssmp configuration
	* @return the new kdssmp configuration
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration create(
		long configurationId);

	/**
	* Removes the kdssmp configuration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configurationId the primary key of the kdssmp configuration
	* @return the kdssmp configuration that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a kdssmp configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration remove(
		long configurationId)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration kdssmpConfiguration)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kdssmp configuration with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException} if it could not be found.
	*
	* @param configurationId the primary key of the kdssmp configuration
	* @return the kdssmp configuration
	* @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException if a kdssmp configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration findByPrimaryKey(
		long configurationId)
		throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpConfigurationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the kdssmp configuration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param configurationId the primary key of the kdssmp configuration
	* @return the kdssmp configuration, or <code>null</code> if a kdssmp configuration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration fetchByPrimaryKey(
		long configurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the kdssmp configurations.
	*
	* @return the kdssmp configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the kdssmp configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kdssmp configurations
	* @param end the upper bound of the range of kdssmp configurations (not inclusive)
	* @return the range of kdssmp configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the kdssmp configurations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kdssmp configurations
	* @param end the upper bound of the range of kdssmp configurations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of kdssmp configurations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpConfiguration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the kdssmp configurations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of kdssmp configurations.
	*
	* @return the number of kdssmp configurations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}