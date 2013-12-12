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
 * Provides a wrapper for {@link CandidateLocalService}.
 *
 * @author Robert Reihs
 * @see CandidateLocalService
 * @generated
 */
public class CandidateLocalServiceWrapper implements CandidateLocalService,
	ServiceWrapper<CandidateLocalService> {
	public CandidateLocalServiceWrapper(
		CandidateLocalService candidateLocalService) {
		_candidateLocalService = candidateLocalService;
	}

	/**
	* Adds the candidate to the database. Also notifies the appropriate model listeners.
	*
	* @param candidate the candidate
	* @return the candidate that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.Candidate addCandidate(
		at.meduni.liferay.portlet.rdconnect.model.Candidate candidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.addCandidate(candidate);
	}

	/**
	* Creates a new candidate with the primary key. Does not add the candidate to the database.
	*
	* @param candidateId the primary key for the new candidate
	* @return the new candidate
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.Candidate createCandidate(
		long candidateId) {
		return _candidateLocalService.createCandidate(candidateId);
	}

	/**
	* Deletes the candidate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateId the primary key of the candidate
	* @return the candidate that was removed
	* @throws PortalException if a candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.Candidate deleteCandidate(
		long candidateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.deleteCandidate(candidateId);
	}

	/**
	* Deletes the candidate from the database. Also notifies the appropriate model listeners.
	*
	* @param candidate the candidate
	* @return the candidate that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.Candidate deleteCandidate(
		at.meduni.liferay.portlet.rdconnect.model.Candidate candidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.deleteCandidate(candidate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _candidateLocalService.dynamicQuery();
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
		return _candidateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.CandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _candidateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.CandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _candidateLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _candidateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _candidateLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public at.meduni.liferay.portlet.rdconnect.model.Candidate fetchCandidate(
		long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.fetchCandidate(candidateId);
	}

	/**
	* Returns the candidate with the primary key.
	*
	* @param candidateId the primary key of the candidate
	* @return the candidate
	* @throws PortalException if a candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.Candidate getCandidate(
		long candidateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.getCandidate(candidateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the candidates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.CandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidates
	* @param end the upper bound of the range of candidates (not inclusive)
	* @return the range of candidates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.meduni.liferay.portlet.rdconnect.model.Candidate> getCandidates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.getCandidates(start, end);
	}

	/**
	* Returns the number of candidates.
	*
	* @return the number of candidates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCandidatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.getCandidatesCount();
	}

	/**
	* Updates the candidate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param candidate the candidate
	* @return the candidate that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.Candidate updateCandidate(
		at.meduni.liferay.portlet.rdconnect.model.Candidate candidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.updateCandidate(candidate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _candidateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_candidateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _candidateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void updateCandidate(long candidateId, boolean accepted,
		long masterId) {
		_candidateLocalService.updateCandidate(candidateId, accepted, masterId);
	}

	@Override
	public java.lang.String getTestString(java.lang.String candidateId) {
		return _candidateLocalService.getTestString(candidateId);
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.rdconnect.model.Candidate> getAllCandidates()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.getAllCandidates();
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.rdconnect.model.Candidate> getFilterdCandidates(
		java.lang.String name, java.lang.String country, java.lang.String type,
		java.lang.String source, java.lang.String diseases)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.getFilterdCandidates(name, country, type,
			source, diseases);
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.rdconnect.model.Candidate> getFilterdCandidates(
		java.lang.String name, java.lang.String country, java.lang.String type,
		java.lang.String source)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.getFilterdCandidates(name, country, type,
			source);
	}

	@Override
	public java.lang.String[] getSource() {
		return _candidateLocalService.getSource();
	}

	@Override
	public java.lang.String[] getTypesOfCandidates() {
		return _candidateLocalService.getTypesOfCandidates();
	}

	@Override
	public java.lang.String[] getTypesOfCandidatesNewEntry() {
		return _candidateLocalService.getTypesOfCandidatesNewEntry();
	}

	@Override
	public java.lang.String[] getCountryNames() {
		return _candidateLocalService.getCountryNames();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CandidateLocalService getWrappedCandidateLocalService() {
		return _candidateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCandidateLocalService(
		CandidateLocalService candidateLocalService) {
		_candidateLocalService = candidateLocalService;
	}

	@Override
	public CandidateLocalService getWrappedService() {
		return _candidateLocalService;
	}

	@Override
	public void setWrappedService(CandidateLocalService candidateLocalService) {
		_candidateLocalService = candidateLocalService;
	}

	private CandidateLocalService _candidateLocalService;
}