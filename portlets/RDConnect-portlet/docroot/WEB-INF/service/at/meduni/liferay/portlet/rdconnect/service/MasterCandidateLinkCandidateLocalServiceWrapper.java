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

package at.meduni.liferay.portlet.rdconnect.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MasterCandidateLinkCandidateLocalService}.
 *
 * @author Robert Reihs
 * @see MasterCandidateLinkCandidateLocalService
 * @generated
 */
public class MasterCandidateLinkCandidateLocalServiceWrapper
	implements MasterCandidateLinkCandidateLocalService,
		ServiceWrapper<MasterCandidateLinkCandidateLocalService> {
	public MasterCandidateLinkCandidateLocalServiceWrapper(
		MasterCandidateLinkCandidateLocalService masterCandidateLinkCandidateLocalService) {
		_masterCandidateLinkCandidateLocalService = masterCandidateLinkCandidateLocalService;
	}

	/**
	* Adds the master candidate link candidate to the database. Also notifies the appropriate model listeners.
	*
	* @param masterCandidateLinkCandidate the master candidate link candidate
	* @return the master candidate link candidate that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate addMasterCandidateLinkCandidate(
		at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate masterCandidateLinkCandidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterCandidateLinkCandidateLocalService.addMasterCandidateLinkCandidate(masterCandidateLinkCandidate);
	}

	/**
	* Creates a new master candidate link candidate with the primary key. Does not add the master candidate link candidate to the database.
	*
	* @param linkId the primary key for the new master candidate link candidate
	* @return the new master candidate link candidate
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate createMasterCandidateLinkCandidate(
		long linkId) {
		return _masterCandidateLinkCandidateLocalService.createMasterCandidateLinkCandidate(linkId);
	}

	/**
	* Deletes the master candidate link candidate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param linkId the primary key of the master candidate link candidate
	* @return the master candidate link candidate that was removed
	* @throws PortalException if a master candidate link candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate deleteMasterCandidateLinkCandidate(
		long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _masterCandidateLinkCandidateLocalService.deleteMasterCandidateLinkCandidate(linkId);
	}

	/**
	* Deletes the master candidate link candidate from the database. Also notifies the appropriate model listeners.
	*
	* @param masterCandidateLinkCandidate the master candidate link candidate
	* @return the master candidate link candidate that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate deleteMasterCandidateLinkCandidate(
		at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate masterCandidateLinkCandidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterCandidateLinkCandidateLocalService.deleteMasterCandidateLinkCandidate(masterCandidateLinkCandidate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _masterCandidateLinkCandidateLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterCandidateLinkCandidateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateLinkCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _masterCandidateLinkCandidateLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateLinkCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterCandidateLinkCandidateLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterCandidateLinkCandidateLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterCandidateLinkCandidateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate fetchMasterCandidateLinkCandidate(
		long linkId) throws com.liferay.portal.kernel.exception.SystemException {
		return _masterCandidateLinkCandidateLocalService.fetchMasterCandidateLinkCandidate(linkId);
	}

	/**
	* Returns the master candidate link candidate with the primary key.
	*
	* @param linkId the primary key of the master candidate link candidate
	* @return the master candidate link candidate
	* @throws PortalException if a master candidate link candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate getMasterCandidateLinkCandidate(
		long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _masterCandidateLinkCandidateLocalService.getMasterCandidateLinkCandidate(linkId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _masterCandidateLinkCandidateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the master candidate link candidates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateLinkCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of master candidate link candidates
	* @param end the upper bound of the range of master candidate link candidates (not inclusive)
	* @return the range of master candidate link candidates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate> getMasterCandidateLinkCandidates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterCandidateLinkCandidateLocalService.getMasterCandidateLinkCandidates(start,
			end);
	}

	/**
	* Returns the number of master candidate link candidates.
	*
	* @return the number of master candidate link candidates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMasterCandidateLinkCandidatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterCandidateLinkCandidateLocalService.getMasterCandidateLinkCandidatesCount();
	}

	/**
	* Updates the master candidate link candidate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param masterCandidateLinkCandidate the master candidate link candidate
	* @return the master candidate link candidate that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate updateMasterCandidateLinkCandidate(
		at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate masterCandidateLinkCandidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _masterCandidateLinkCandidateLocalService.updateMasterCandidateLinkCandidate(masterCandidateLinkCandidate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _masterCandidateLinkCandidateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_masterCandidateLinkCandidateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _masterCandidateLinkCandidateLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MasterCandidateLinkCandidateLocalService getWrappedMasterCandidateLinkCandidateLocalService() {
		return _masterCandidateLinkCandidateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMasterCandidateLinkCandidateLocalService(
		MasterCandidateLinkCandidateLocalService masterCandidateLinkCandidateLocalService) {
		_masterCandidateLinkCandidateLocalService = masterCandidateLinkCandidateLocalService;
	}

	@Override
	public MasterCandidateLinkCandidateLocalService getWrappedService() {
		return _masterCandidateLinkCandidateLocalService;
	}

	@Override
	public void setWrappedService(
		MasterCandidateLinkCandidateLocalService masterCandidateLinkCandidateLocalService) {
		_masterCandidateLinkCandidateLocalService = masterCandidateLinkCandidateLocalService;
	}

	private MasterCandidateLinkCandidateLocalService _masterCandidateLinkCandidateLocalService;
}