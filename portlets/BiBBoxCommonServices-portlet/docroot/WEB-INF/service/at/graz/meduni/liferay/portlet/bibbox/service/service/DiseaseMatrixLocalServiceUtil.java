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

package at.graz.meduni.liferay.portlet.bibbox.service.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for DiseaseMatrix. This utility wraps
 * {@link at.graz.meduni.liferay.portlet.bibbox.service.service.impl.DiseaseMatrixLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author reihsr
 * @see DiseaseMatrixLocalService
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.base.DiseaseMatrixLocalServiceBaseImpl
 * @see at.graz.meduni.liferay.portlet.bibbox.service.service.impl.DiseaseMatrixLocalServiceImpl
 * @generated
 */
public class DiseaseMatrixLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.meduni.liferay.portlet.bibbox.service.service.impl.DiseaseMatrixLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the disease matrix to the database. Also notifies the appropriate model listeners.
	*
	* @param diseaseMatrix the disease matrix
	* @return the disease matrix that was added
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix addDiseaseMatrix(
		at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseaseMatrix)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDiseaseMatrix(diseaseMatrix);
	}

	/**
	* Creates a new disease matrix with the primary key. Does not add the disease matrix to the database.
	*
	* @param diseasematrixId the primary key for the new disease matrix
	* @return the new disease matrix
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix createDiseaseMatrix(
		long diseasematrixId) {
		return getService().createDiseaseMatrix(diseasematrixId);
	}

	/**
	* Deletes the disease matrix with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param diseasematrixId the primary key of the disease matrix
	* @return the disease matrix that was removed
	* @throws PortalException if a disease matrix with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix deleteDiseaseMatrix(
		long diseasematrixId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDiseaseMatrix(diseasematrixId);
	}

	/**
	* Deletes the disease matrix from the database. Also notifies the appropriate model listeners.
	*
	* @param diseaseMatrix the disease matrix
	* @return the disease matrix that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix deleteDiseaseMatrix(
		at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseaseMatrix)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDiseaseMatrix(diseaseMatrix);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix fetchDiseaseMatrix(
		long diseasematrixId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDiseaseMatrix(diseasematrixId);
	}

	/**
	* Returns the disease matrix with the primary key.
	*
	* @param diseasematrixId the primary key of the disease matrix
	* @return the disease matrix
	* @throws PortalException if a disease matrix with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix getDiseaseMatrix(
		long diseasematrixId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDiseaseMatrix(diseasematrixId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

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
	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> getDiseaseMatrixs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDiseaseMatrixs(start, end);
	}

	/**
	* Returns the number of disease matrixs.
	*
	* @return the number of disease matrixs
	* @throws SystemException if a system exception occurred
	*/
	public static int getDiseaseMatrixsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDiseaseMatrixsCount();
	}

	/**
	* Updates the disease matrix in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param diseaseMatrix the disease matrix
	* @return the disease matrix that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix updateDiseaseMatrix(
		at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseaseMatrix)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDiseaseMatrix(diseaseMatrix);
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

	public static java.lang.String getDiseaseMatrixTable(long organizationId) {
		return getService().getDiseaseMatrixTable(organizationId);
	}

	public static java.util.List<at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix> getDiseaseMatrixs(
		long organizationID, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDiseaseMatrixs(organizationID, begin, end);
	}

	public static int getDiseaseMatrixsCount(long organizationID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDiseaseMatrixsCount(organizationID);
	}

	/**
	* Convenience method to create a DiseaseMatrix object out of the request. Used
	* by the Add / Edit methods.
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix diseaseMatrixFromRequest(
		javax.portlet.PortletRequest request) {
		return getService().diseaseMatrixFromRequest(request);
	}

	/**
	* Adds the DiseaseMatrix to the database incrementing the primary key
	*/
	public static at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrix createEmpltyDiseaseMatrix()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createEmpltyDiseaseMatrix();
	}

	public static void clearService() {
		_service = null;
	}

	public static DiseaseMatrixLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DiseaseMatrixLocalService.class.getName());

			if (invokableLocalService instanceof DiseaseMatrixLocalService) {
				_service = (DiseaseMatrixLocalService)invokableLocalService;
			}
			else {
				_service = new DiseaseMatrixLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(DiseaseMatrixLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(DiseaseMatrixLocalService service) {
	}

	private static DiseaseMatrixLocalService _service;
}