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

package com.bcnet.portlet.biobank.service.persistence;

import com.bcnet.portlet.biobank.model.BiobankContact;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the biobank contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see BiobankContactPersistenceImpl
 * @see BiobankContactUtil
 * @generated
 */
public interface BiobankContactPersistence extends BasePersistence<BiobankContact> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BiobankContactUtil} to access the biobank contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the biobank contact in the entity cache if it is enabled.
	*
	* @param biobankContact the biobank contact
	*/
	public void cacheResult(
		com.bcnet.portlet.biobank.model.BiobankContact biobankContact);

	/**
	* Caches the biobank contacts in the entity cache if it is enabled.
	*
	* @param biobankContacts the biobank contacts
	*/
	public void cacheResult(
		java.util.List<com.bcnet.portlet.biobank.model.BiobankContact> biobankContacts);

	/**
	* Creates a new biobank contact with the primary key. Does not add the biobank contact to the database.
	*
	* @param biobankContactPK the primary key for the new biobank contact
	* @return the new biobank contact
	*/
	public com.bcnet.portlet.biobank.model.BiobankContact create(
		com.bcnet.portlet.biobank.service.persistence.BiobankContactPK biobankContactPK);

	/**
	* Removes the biobank contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankContactPK the primary key of the biobank contact
	* @return the biobank contact that was removed
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankContactException if a biobank contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.BiobankContact remove(
		com.bcnet.portlet.biobank.service.persistence.BiobankContactPK biobankContactPK)
		throws com.bcnet.portlet.biobank.NoSuchBiobankContactException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.bcnet.portlet.biobank.model.BiobankContact updateImpl(
		com.bcnet.portlet.biobank.model.BiobankContact biobankContact)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the biobank contact with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchBiobankContactException} if it could not be found.
	*
	* @param biobankContactPK the primary key of the biobank contact
	* @return the biobank contact
	* @throws com.bcnet.portlet.biobank.NoSuchBiobankContactException if a biobank contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.BiobankContact findByPrimaryKey(
		com.bcnet.portlet.biobank.service.persistence.BiobankContactPK biobankContactPK)
		throws com.bcnet.portlet.biobank.NoSuchBiobankContactException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the biobank contact with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param biobankContactPK the primary key of the biobank contact
	* @return the biobank contact, or <code>null</code> if a biobank contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.bcnet.portlet.biobank.model.BiobankContact fetchByPrimaryKey(
		com.bcnet.portlet.biobank.service.persistence.BiobankContactPK biobankContactPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the biobank contacts.
	*
	* @return the biobank contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankContact> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the biobank contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank contacts
	* @param end the upper bound of the range of biobank contacts (not inclusive)
	* @return the range of biobank contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankContact> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the biobank contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank contacts
	* @param end the upper bound of the range of biobank contacts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of biobank contacts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.bcnet.portlet.biobank.model.BiobankContact> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the biobank contacts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of biobank contacts.
	*
	* @return the number of biobank contacts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}