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

import at.graz.meduni.liferay.model.ICD10;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the i c d10 service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ICD10PersistenceImpl
 * @see ICD10Util
 * @generated
 */
public interface ICD10Persistence extends BasePersistence<ICD10> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ICD10Util} to access the i c d10 persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the i c d10s where code = &#63;.
	*
	* @param code the code
	* @return the matching i c d10s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.ICD10> findByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i c d10s where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.ICD10ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of i c d10s
	* @param end the upper bound of the range of i c d10s (not inclusive)
	* @return the range of matching i c d10s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.ICD10> findByCode(
		java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i c d10s where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.ICD10ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of i c d10s
	* @param end the upper bound of the range of i c d10s (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i c d10s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.ICD10> findByCode(
		java.lang.String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i c d10 in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i c d10
	* @throws at.graz.meduni.liferay.NoSuchICD10Exception if a matching i c d10 could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.ICD10 findByCode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.NoSuchICD10Exception,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i c d10 in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i c d10, or <code>null</code> if a matching i c d10 could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.ICD10 fetchByCode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i c d10 in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i c d10
	* @throws at.graz.meduni.liferay.NoSuchICD10Exception if a matching i c d10 could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.ICD10 findByCode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.NoSuchICD10Exception,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last i c d10 in the ordered set where code = &#63;.
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i c d10, or <code>null</code> if a matching i c d10 could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.ICD10 fetchByCode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i c d10s before and after the current i c d10 in the ordered set where code = &#63;.
	*
	* @param id the primary key of the current i c d10
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i c d10
	* @throws at.graz.meduni.liferay.NoSuchICD10Exception if a i c d10 with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.ICD10[] findByCode_PrevAndNext(
		long id, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.NoSuchICD10Exception,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the i c d10s where code = &#63; from the database.
	*
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i c d10s where code = &#63;.
	*
	* @param code the code
	* @return the number of matching i c d10s
	* @throws SystemException if a system exception occurred
	*/
	public int countByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the i c d10 in the entity cache if it is enabled.
	*
	* @param icd10 the i c d10
	*/
	public void cacheResult(at.graz.meduni.liferay.model.ICD10 icd10);

	/**
	* Caches the i c d10s in the entity cache if it is enabled.
	*
	* @param icd10s the i c d10s
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.model.ICD10> icd10s);

	/**
	* Creates a new i c d10 with the primary key. Does not add the i c d10 to the database.
	*
	* @param id the primary key for the new i c d10
	* @return the new i c d10
	*/
	public at.graz.meduni.liferay.model.ICD10 create(long id);

	/**
	* Removes the i c d10 with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the i c d10
	* @return the i c d10 that was removed
	* @throws at.graz.meduni.liferay.NoSuchICD10Exception if a i c d10 with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.ICD10 remove(long id)
		throws at.graz.meduni.liferay.NoSuchICD10Exception,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.model.ICD10 updateImpl(
		at.graz.meduni.liferay.model.ICD10 icd10)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i c d10 with the primary key or throws a {@link at.graz.meduni.liferay.NoSuchICD10Exception} if it could not be found.
	*
	* @param id the primary key of the i c d10
	* @return the i c d10
	* @throws at.graz.meduni.liferay.NoSuchICD10Exception if a i c d10 with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.ICD10 findByPrimaryKey(long id)
		throws at.graz.meduni.liferay.NoSuchICD10Exception,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i c d10 with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the i c d10
	* @return the i c d10, or <code>null</code> if a i c d10 with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.model.ICD10 fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i c d10s.
	*
	* @return the i c d10s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.ICD10> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i c d10s.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.ICD10ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of i c d10s
	* @param end the upper bound of the range of i c d10s (not inclusive)
	* @return the range of i c d10s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.ICD10> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i c d10s.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.model.impl.ICD10ModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of i c d10s
	* @param end the upper bound of the range of i c d10s (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of i c d10s
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.model.ICD10> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the i c d10s from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i c d10s.
	*
	* @return the number of i c d10s
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}