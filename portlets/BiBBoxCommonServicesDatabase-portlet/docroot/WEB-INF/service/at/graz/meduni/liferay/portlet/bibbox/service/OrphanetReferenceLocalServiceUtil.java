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

package at.graz.meduni.liferay.portlet.bibbox.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for OrphanetReference. This utility wraps
 * {@link at.graz.meduni.liferay.portlet.bibbox.service.impl.OrphanetReferenceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author reihsr
 * @see OrphanetReferenceLocalService
 * @see at.graz.meduni.liferay.portlet.bibbox.service.base.OrphanetReferenceLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.impl.OrphanetReferenceLocalServiceImpl
 * @generated
 */
public class OrphanetReferenceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.meduni.liferay.portlet.bibbox.service.impl.OrphanetReferenceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the orphanet reference to the database. Also notifies the appropriate model listeners.
	*
	* @param orphanetReference the orphanet reference
	* @return the orphanet reference that was added
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference addOrphanetReference(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference orphanetReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addOrphanetReference(orphanetReference);
	}

	/**
	* Creates a new orphanet reference with the primary key. Does not add the orphanet reference to the database.
	*
	* @param orphanetreferenceId the primary key for the new orphanet reference
	* @return the new orphanet reference
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference createOrphanetReference(
		long orphanetreferenceId) {
		return getService().createOrphanetReference(orphanetreferenceId);
	}

	/**
	* Deletes the orphanet reference with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orphanetreferenceId the primary key of the orphanet reference
	* @return the orphanet reference that was removed
	* @throws PortalException if a orphanet reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference deleteOrphanetReference(
		long orphanetreferenceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOrphanetReference(orphanetreferenceId);
	}

	/**
	* Deletes the orphanet reference from the database. Also notifies the appropriate model listeners.
	*
	* @param orphanetReference the orphanet reference
	* @return the orphanet reference that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference deleteOrphanetReference(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference orphanetReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOrphanetReference(orphanetReference);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference fetchOrphanetReference(
		long orphanetreferenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchOrphanetReference(orphanetreferenceId);
	}

	/**
	* Returns the orphanet reference with the primary key.
	*
	* @param orphanetreferenceId the primary key of the orphanet reference
	* @return the orphanet reference
	* @throws PortalException if a orphanet reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference getOrphanetReference(
		long orphanetreferenceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrphanetReference(orphanetreferenceId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the orphanet references.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of orphanet references
	* @param end the upper bound of the range of orphanet references (not inclusive)
	* @return the range of orphanet references
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference> getOrphanetReferences(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrphanetReferences(start, end);
	}

	/**
	* Returns the number of orphanet references.
	*
	* @return the number of orphanet references
	* @throws SystemException if a system exception occurred
	*/
	public static int getOrphanetReferencesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrphanetReferencesCount();
	}

	/**
	* Updates the orphanet reference in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param orphanetReference the orphanet reference
	* @return the orphanet reference that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference updateOrphanetReference(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference orphanetReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateOrphanetReference(orphanetReference);
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

	public static at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference createOrphanetReference(
		long orphanetreferenceId, long orphanetdisorderId) {
		return getService()
				   .createOrphanetReference(orphanetreferenceId,
			orphanetdisorderId);
	}

	/**
	* @param orphanetdisorderId
	* @param source
	* @return
	*/
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReference> getOrphanetReferenceByOrpahnetDisorderIdAndSource(
		long orphanetdisorderId, java.lang.String source) {
		return getService()
				   .getOrphanetReferenceByOrpahnetDisorderIdAndSource(orphanetdisorderId,
			source);
	}

	public static void clearService() {
		_service = null;
	}

	public static OrphanetReferenceLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					OrphanetReferenceLocalService.class.getName());

			if (invokableLocalService instanceof OrphanetReferenceLocalService) {
				_service = (OrphanetReferenceLocalService)invokableLocalService;
			}
			else {
				_service = new OrphanetReferenceLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(OrphanetReferenceLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(OrphanetReferenceLocalService service) {
	}

	private static OrphanetReferenceLocalService _service;
}