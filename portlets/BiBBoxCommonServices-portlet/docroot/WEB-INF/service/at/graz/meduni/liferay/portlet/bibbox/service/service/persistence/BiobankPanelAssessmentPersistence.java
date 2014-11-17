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

import at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the biobank panel assessment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see BiobankPanelAssessmentPersistenceImpl
 * @see BiobankPanelAssessmentUtil
 * @generated
 */
public interface BiobankPanelAssessmentPersistence extends BasePersistence<BiobankPanelAssessment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BiobankPanelAssessmentUtil} to access the biobank panel assessment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the biobank panel assessments where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the matching biobank panel assessments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment> findByOrganizationFilter(
		long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the biobank panel assessments where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.BiobankPanelAssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of biobank panel assessments
	* @param end the upper bound of the range of biobank panel assessments (not inclusive)
	* @return the range of matching biobank panel assessments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment> findByOrganizationFilter(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the biobank panel assessments where organizationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.BiobankPanelAssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param organizationId the organization ID
	* @param start the lower bound of the range of biobank panel assessments
	* @param end the upper bound of the range of biobank panel assessments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching biobank panel assessments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment> findByOrganizationFilter(
		long organizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first biobank panel assessment in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching biobank panel assessment
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException if a matching biobank panel assessment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment findByOrganizationFilter_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first biobank panel assessment in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching biobank panel assessment, or <code>null</code> if a matching biobank panel assessment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment fetchByOrganizationFilter_First(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last biobank panel assessment in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching biobank panel assessment
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException if a matching biobank panel assessment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment findByOrganizationFilter_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last biobank panel assessment in the ordered set where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching biobank panel assessment, or <code>null</code> if a matching biobank panel assessment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment fetchByOrganizationFilter_Last(
		long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the biobank panel assessments before and after the current biobank panel assessment in the ordered set where organizationId = &#63;.
	*
	* @param biobankpanelassessmentId the primary key of the current biobank panel assessment
	* @param organizationId the organization ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next biobank panel assessment
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException if a biobank panel assessment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment[] findByOrganizationFilter_PrevAndNext(
		long biobankpanelassessmentId, long organizationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the biobank panel assessments where organizationId = &#63; from the database.
	*
	* @param organizationId the organization ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrganizationFilter(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of biobank panel assessments where organizationId = &#63;.
	*
	* @param organizationId the organization ID
	* @return the number of matching biobank panel assessments
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrganizationFilter(long organizationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the biobank panel assessment in the entity cache if it is enabled.
	*
	* @param biobankPanelAssessment the biobank panel assessment
	*/
	public void cacheResult(
		at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment biobankPanelAssessment);

	/**
	* Caches the biobank panel assessments in the entity cache if it is enabled.
	*
	* @param biobankPanelAssessments the biobank panel assessments
	*/
	public void cacheResult(
		java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment> biobankPanelAssessments);

	/**
	* Creates a new biobank panel assessment with the primary key. Does not add the biobank panel assessment to the database.
	*
	* @param biobankpanelassessmentId the primary key for the new biobank panel assessment
	* @return the new biobank panel assessment
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment create(
		long biobankpanelassessmentId);

	/**
	* Removes the biobank panel assessment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biobankpanelassessmentId the primary key of the biobank panel assessment
	* @return the biobank panel assessment that was removed
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException if a biobank panel assessment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment remove(
		long biobankpanelassessmentId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException,
			com.liferay.portal.kernel.exception.SystemException;

	public at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment biobankPanelAssessment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the biobank panel assessment with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException} if it could not be found.
	*
	* @param biobankpanelassessmentId the primary key of the biobank panel assessment
	* @return the biobank panel assessment
	* @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException if a biobank panel assessment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment findByPrimaryKey(
		long biobankpanelassessmentId)
		throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the biobank panel assessment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param biobankpanelassessmentId the primary key of the biobank panel assessment
	* @return the biobank panel assessment, or <code>null</code> if a biobank panel assessment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment fetchByPrimaryKey(
		long biobankpanelassessmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the biobank panel assessments.
	*
	* @return the biobank panel assessments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the biobank panel assessments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.BiobankPanelAssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank panel assessments
	* @param end the upper bound of the range of biobank panel assessments (not inclusive)
	* @return the range of biobank panel assessments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the biobank panel assessments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.BiobankPanelAssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biobank panel assessments
	* @param end the upper bound of the range of biobank panel assessments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of biobank panel assessments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the biobank panel assessments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of biobank panel assessments.
	*
	* @return the number of biobank panel assessments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}