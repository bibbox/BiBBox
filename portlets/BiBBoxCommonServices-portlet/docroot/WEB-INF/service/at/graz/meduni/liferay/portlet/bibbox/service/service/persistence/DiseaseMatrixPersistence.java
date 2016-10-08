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

package at.graz.meduni.liferay.portlet.bibbox.service.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the disease matrix service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see DiseaseMatrixPersistenceImpl
 * @see DiseaseMatrixUtil
 * @generated
 */
public interface DiseaseMatrixPersistence extends BasePersistence<DiseaseMatrix> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DiseaseMatrixUtil} to access the disease matrix persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the disease matrixs where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching disease matrixs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> findByOrganizationFinder(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the disease matrixs where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of disease matrixs
	* @param end the upper bound of the range of disease matrixs (not inclusive)
	* @return the range of matching disease matrixs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> findByOrganizationFinder(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the disease matrixs where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of disease matrixs
	* @param end the upper bound of the range of disease matrixs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching disease matrixs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> findByOrganizationFinder(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first disease matrix in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching disease matrix
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException if a matching disease matrix could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix findByOrganizationFinder_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first disease matrix in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching disease matrix, or <code>null</code> if a matching disease matrix could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix fetchByOrganizationFinder_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last disease matrix in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching disease matrix
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException if a matching disease matrix could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix findByOrganizationFinder_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last disease matrix in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching disease matrix, or <code>null</code> if a matching disease matrix could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix fetchByOrganizationFinder_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the disease matrixs before and after the current disease matrix in the ordered set where organizationId = &#63;.
	*
	* @param diseasematrixId the primary key of the current disease matrix
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next disease matrix
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException if a disease matrix with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix[] findByOrganizationFinder_PrevAndNext(
		long diseasematrixId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the disease matrixs where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrganizationFinder(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of disease matrixs where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching disease matrixs
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrganizationFinder(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the disease matrixs where organizationId = &#63; and orphanumber = &#63;.
	*
	* @param organizationId the organization ID
	* @param orphanumber the orphanumber
	* @return the matching disease matrixs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> findByOrganizationAndOrphanumber(
		long organizationId, java.lang.String orphanumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the disease matrixs where organizationId = &#63; and orphanumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param orphanumber the orphanumber
	* @param start the lower bound of the range of disease matrixs
	* @param end the upper bound of the range of disease matrixs (not inclusive)
	* @return the range of matching disease matrixs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> findByOrganizationAndOrphanumber(
		long organizationId, java.lang.String orphanumber, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the disease matrixs where organizationId = &#63; and orphanumber = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param orphanumber the orphanumber
	* @param start the lower bound of the range of disease matrixs
	* @param end the upper bound of the range of disease matrixs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching disease matrixs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> findByOrganizationAndOrphanumber(
		long organizationId, java.lang.String orphanumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first disease matrix in the ordered set where organizationId = &#63; and orphanumber = &#63;.
	*
	* @param organizationId the organization ID
	* @param orphanumber the orphanumber
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching disease matrix
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException if a matching disease matrix could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix findByOrganizationAndOrphanumber_First(
		long organizationId, java.lang.String orphanumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first disease matrix in the ordered set where organizationId = &#63; and orphanumber = &#63;.
	*
	* @param organizationId the organization ID
	* @param orphanumber the orphanumber
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching disease matrix, or <code>null</code> if a matching disease matrix could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix fetchByOrganizationAndOrphanumber_First(
		long organizationId, java.lang.String orphanumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last disease matrix in the ordered set where organizationId = &#63; and orphanumber = &#63;.
	*
	* @param organizationId the organization ID
	* @param orphanumber the orphanumber
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching disease matrix
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException if a matching disease matrix could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix findByOrganizationAndOrphanumber_Last(
		long organizationId, java.lang.String orphanumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last disease matrix in the ordered set where organizationId = &#63; and orphanumber = &#63;.
	*
	* @param organizationId the organization ID
	* @param orphanumber the orphanumber
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching disease matrix, or <code>null</code> if a matching disease matrix could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix fetchByOrganizationAndOrphanumber_Last(
		long organizationId, java.lang.String orphanumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the disease matrixs before and after the current disease matrix in the ordered set where organizationId = &#63; and orphanumber = &#63;.
	*
	* @param diseasematrixId the primary key of the current disease matrix
	* @param organizationId the organization ID
	* @param orphanumber the orphanumber
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next disease matrix
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException if a disease matrix with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix[] findByOrganizationAndOrphanumber_PrevAndNext(
		long diseasematrixId, long organizationId,
		java.lang.String orphanumber,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the disease matrixs where organizationId = &#63; and orphanumber = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @param orphanumber the orphanumber
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrganizationAndOrphanumber(long organizationId,
		java.lang.String orphanumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of disease matrixs where organizationId = &#63; and orphanumber = &#63;.
	*
	* @param organizationId the organization ID
	* @param orphanumber the orphanumber
	* @return the number of matching disease matrixs
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrganizationAndOrphanumber(long organizationId,
		java.lang.String orphanumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the disease matrix in the entity cache if it is enabled.
	*
	* @param diseaseMatrix the disease matrix
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseaseMatrix);

	/**
	* Caches the disease matrixs in the entity cache if it is enabled.
	*
	* @param diseaseMatrixs the disease matrixs
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> diseaseMatrixs);

	/**
	* Creates a new disease matrix with the primary key. Does not add the disease matrix to the database.
	*
	* @param diseasematrixId the primary key for the new disease matrix
	* @return the new disease matrix
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix create(
		long diseasematrixId);

	/**
	* Removes the disease matrix with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param diseasematrixId the primary key of the disease matrix
	* @return the disease matrix that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException if a disease matrix with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix remove(
		long diseasematrixId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseaseMatrix)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the disease matrix with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException} if it could not be found.
	*
	* @param diseasematrixId the primary key of the disease matrix
	* @return the disease matrix
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException if a disease matrix with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix findByPrimaryKey(
		long diseasematrixId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the disease matrix with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param diseasematrixId the primary key of the disease matrix
	* @return the disease matrix, or <code>null</code> if a disease matrix with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix fetchByPrimaryKey(
		long diseasematrixId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the disease matrixs.
	*
	* @return the disease matrixs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the disease matrixs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of disease matrixs
	* @param end the upper bound of the range of disease matrixs (not inclusive)
	* @return the range of disease matrixs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the disease matrixs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of disease matrixs
	* @param end the upper bound of the range of disease matrixs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of disease matrixs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the disease matrixs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of disease matrixs.
	*
	* @return the number of disease matrixs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}