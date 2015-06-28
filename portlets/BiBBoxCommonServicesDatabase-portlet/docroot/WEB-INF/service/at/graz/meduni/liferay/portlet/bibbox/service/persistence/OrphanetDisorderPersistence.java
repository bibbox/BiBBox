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

import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the orphanet disorder service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see OrphanetDisorderPersistenceImpl
 * @see OrphanetDisorderUtil
 * @generated
 */
public interface OrphanetDisorderPersistence extends BasePersistence<OrphanetDisorder> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrphanetDisorderUtil} to access the orphanet disorder persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the orphanet disorder in the entity cache if it is enabled.
	*
	* @param orphanetDisorder the orphanet disorder
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder orphanetDisorder);

	/**
	* Caches the orphanet disorders in the entity cache if it is enabled.
	*
	* @param orphanetDisorders the orphanet disorders
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder> orphanetDisorders);

	/**
	* Creates a new orphanet disorder with the primary key. Does not add the orphanet disorder to the database.
	*
	* @param orphanetdisorderId the primary key for the new orphanet disorder
	* @return the new orphanet disorder
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder create(
		long orphanetdisorderId);

	/**
	* Removes the orphanet disorder with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orphanetdisorderId the primary key of the orphanet disorder
	* @return the orphanet disorder that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException if a orphanet disorder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder remove(
		long orphanetdisorderId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder orphanetDisorder)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the orphanet disorder with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException} if it could not be found.
	*
	* @param orphanetdisorderId the primary key of the orphanet disorder
	* @return the orphanet disorder
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException if a orphanet disorder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder findByPrimaryKey(
		long orphanetdisorderId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the orphanet disorder with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orphanetdisorderId the primary key of the orphanet disorder
	* @return the orphanet disorder, or <code>null</code> if a orphanet disorder with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder fetchByPrimaryKey(
		long orphanetdisorderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the orphanet disorders.
	*
	* @return the orphanet disorders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the orphanet disorders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetDisorderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of orphanet disorders
	* @param end the upper bound of the range of orphanet disorders (not inclusive)
	* @return the range of orphanet disorders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the orphanet disorders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetDisorderModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of orphanet disorders
	* @param end the upper bound of the range of orphanet disorders (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of orphanet disorders
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorder> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the orphanet disorders from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of orphanet disorders.
	*
	* @return the number of orphanet disorders
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}