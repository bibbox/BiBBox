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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for MasterCandidateLinkCandidate. This utility wraps
 * {@link at.meduni.liferay.portlet.rdconnect.service.impl.MasterCandidateLinkCandidateLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Robert Reihs
 * @see MasterCandidateLinkCandidateLocalService
 * @see at.meduni.liferay.portlet.rdconnect.service.base.MasterCandidateLinkCandidateLocalServiceBaseImpl
 * @see at.meduni.liferay.portlet.rdconnect.service.impl.MasterCandidateLinkCandidateLocalServiceImpl
 * @generated
 */
public class MasterCandidateLinkCandidateLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.meduni.liferay.portlet.rdconnect.service.impl.MasterCandidateLinkCandidateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the master candidate link candidate to the database. Also notifies the appropriate model listeners.
	*
	* @param masterCandidateLinkCandidate the master candidate link candidate
	* @return the master candidate link candidate that was added
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate addMasterCandidateLinkCandidate(
		at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate masterCandidateLinkCandidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addMasterCandidateLinkCandidate(masterCandidateLinkCandidate);
	}

	/**
	* Creates a new master candidate link candidate with the primary key. Does not add the master candidate link candidate to the database.
	*
	* @param linkId the primary key for the new master candidate link candidate
	* @return the new master candidate link candidate
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate createMasterCandidateLinkCandidate(
		long linkId) {
		return getService().createMasterCandidateLinkCandidate(linkId);
	}

	/**
	* Deletes the master candidate link candidate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param linkId the primary key of the master candidate link candidate
	* @return the master candidate link candidate that was removed
	* @throws PortalException if a master candidate link candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate deleteMasterCandidateLinkCandidate(
		long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteMasterCandidateLinkCandidate(linkId);
	}

	/**
	* Deletes the master candidate link candidate from the database. Also notifies the appropriate model listeners.
	*
	* @param masterCandidateLinkCandidate the master candidate link candidate
	* @return the master candidate link candidate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate deleteMasterCandidateLinkCandidate(
		at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate masterCandidateLinkCandidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteMasterCandidateLinkCandidate(masterCandidateLinkCandidate);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate fetchMasterCandidateLinkCandidate(
		long linkId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchMasterCandidateLinkCandidate(linkId);
	}

	/**
	* Returns the master candidate link candidate with the primary key.
	*
	* @param linkId the primary key of the master candidate link candidate
	* @return the master candidate link candidate
	* @throws PortalException if a master candidate link candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate getMasterCandidateLinkCandidate(
		long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMasterCandidateLinkCandidate(linkId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate> getMasterCandidateLinkCandidates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMasterCandidateLinkCandidates(start, end);
	}

	/**
	* Returns the number of master candidate link candidates.
	*
	* @return the number of master candidate link candidates
	* @throws SystemException if a system exception occurred
	*/
	public static int getMasterCandidateLinkCandidatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMasterCandidateLinkCandidatesCount();
	}

	/**
	* Updates the master candidate link candidate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param masterCandidateLinkCandidate the master candidate link candidate
	* @return the master candidate link candidate that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate updateMasterCandidateLinkCandidate(
		at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidate masterCandidateLinkCandidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateMasterCandidateLinkCandidate(masterCandidateLinkCandidate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static MasterCandidateLinkCandidateLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					MasterCandidateLinkCandidateLocalService.class.getName());

			if (invokableLocalService instanceof MasterCandidateLinkCandidateLocalService) {
				_service = (MasterCandidateLinkCandidateLocalService)invokableLocalService;
			}
			else {
				_service = new MasterCandidateLinkCandidateLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(MasterCandidateLinkCandidateLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(MasterCandidateLinkCandidateLocalService service) {
	}

	private static MasterCandidateLinkCandidateLocalService _service;
}