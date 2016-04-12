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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the orphanet synonym service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see OrphanetSynonymPersistenceImpl
 * @see OrphanetSynonymUtil
 * @generated
 */
public interface OrphanetSynonymPersistence extends BasePersistence<OrphanetSynonym> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrphanetSynonymUtil} to access the orphanet synonym persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the orphanet synonyms where orphanetdisorderId = &#63;.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @return the matching orphanet synonyms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym> findByOrphanetDisorderId(
		long orphanetdisorderId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym> findByOrphanetDisorderId(
		long orphanetdisorderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym> findByOrphanetDisorderId(
		long orphanetdisorderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first orphanet synonym in the ordered set where orphanetdisorderId = &#63;.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching orphanet synonym
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException if a matching orphanet synonym could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym findByOrphanetDisorderId_First(
		long orphanetdisorderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first orphanet synonym in the ordered set where orphanetdisorderId = &#63;.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching orphanet synonym, or <code>null</code> if a matching orphanet synonym could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym fetchByOrphanetDisorderId_First(
		long orphanetdisorderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last orphanet synonym in the ordered set where orphanetdisorderId = &#63;.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching orphanet synonym
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException if a matching orphanet synonym could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym findByOrphanetDisorderId_Last(
		long orphanetdisorderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last orphanet synonym in the ordered set where orphanetdisorderId = &#63;.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching orphanet synonym, or <code>null</code> if a matching orphanet synonym could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym fetchByOrphanetDisorderId_Last(
		long orphanetdisorderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym[] findByOrphanetDisorderId_PrevAndNext(
		long orphanetsynonymId, long orphanetdisorderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the orphanet synonyms where orphanetdisorderId = &#63; from the database.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrphanetDisorderId(long orphanetdisorderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of orphanet synonyms where orphanetdisorderId = &#63;.
	*
	* @param orphanetdisorderId the orphanetdisorder ID
	* @return the number of matching orphanet synonyms
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrphanetDisorderId(long orphanetdisorderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the orphanet synonym in the entity cache if it is enabled.
	*
	* @param orphanetSynonym the orphanet synonym
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym orphanetSynonym);

	/**
	* Caches the orphanet synonyms in the entity cache if it is enabled.
	*
	* @param orphanetSynonyms the orphanet synonyms
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym> orphanetSynonyms);

	/**
	* Creates a new orphanet synonym with the primary key. Does not add the orphanet synonym to the database.
	*
	* @param orphanetsynonymId the primary key for the new orphanet synonym
	* @return the new orphanet synonym
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym create(
		long orphanetsynonymId);

	/**
	* Removes the orphanet synonym with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orphanetsynonymId the primary key of the orphanet synonym
	* @return the orphanet synonym that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException if a orphanet synonym with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym remove(
		long orphanetsynonymId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym orphanetSynonym)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the orphanet synonym with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException} if it could not be found.
	*
	* @param orphanetsynonymId the primary key of the orphanet synonym
	* @return the orphanet synonym
	* @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException if a orphanet synonym with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym findByPrimaryKey(
		long orphanetsynonymId)
		throws at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the orphanet synonym with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orphanetsynonymId the primary key of the orphanet synonym
	* @return the orphanet synonym, or <code>null</code> if a orphanet synonym with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym fetchByPrimaryKey(
		long orphanetsynonymId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the orphanet synonyms.
	*
	* @return the orphanet synonyms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the orphanet synonyms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of orphanet synonyms.
	*
	* @return the number of orphanet synonyms
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}