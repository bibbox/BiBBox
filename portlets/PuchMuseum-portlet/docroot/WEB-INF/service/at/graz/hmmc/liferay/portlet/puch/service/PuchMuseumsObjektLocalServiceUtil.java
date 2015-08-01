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

package at.graz.hmmc.liferay.portlet.puch.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for PuchMuseumsObjekt. This utility wraps
 * {@link at.graz.hmmc.liferay.portlet.puch.service.impl.PuchMuseumsObjektLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author reihsr
 * @see PuchMuseumsObjektLocalService
 * @see at.graz.hmmc.liferay.portlet.puch.service.base.PuchMuseumsObjektLocalServiceBaseImpl
 * @see at.graz.hmmc.liferay.portlet.puch.service.impl.PuchMuseumsObjektLocalServiceImpl
 * @generated
 */
public class PuchMuseumsObjektLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.hmmc.liferay.portlet.puch.service.impl.PuchMuseumsObjektLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the puch museums objekt to the database. Also notifies the appropriate model listeners.
	*
	* @param puchMuseumsObjekt the puch museums objekt
	* @return the puch museums objekt that was added
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt addPuchMuseumsObjekt(
		at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt puchMuseumsObjekt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPuchMuseumsObjekt(puchMuseumsObjekt);
	}

	/**
	* Creates a new puch museums objekt with the primary key. Does not add the puch museums objekt to the database.
	*
	* @param puchmuseumsobjectId the primary key for the new puch museums objekt
	* @return the new puch museums objekt
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt createPuchMuseumsObjekt(
		long puchmuseumsobjectId) {
		return getService().createPuchMuseumsObjekt(puchmuseumsobjectId);
	}

	/**
	* Deletes the puch museums objekt with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param puchmuseumsobjectId the primary key of the puch museums objekt
	* @return the puch museums objekt that was removed
	* @throws PortalException if a puch museums objekt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt deletePuchMuseumsObjekt(
		long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePuchMuseumsObjekt(puchmuseumsobjectId);
	}

	/**
	* Deletes the puch museums objekt from the database. Also notifies the appropriate model listeners.
	*
	* @param puchMuseumsObjekt the puch museums objekt
	* @return the puch museums objekt that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt deletePuchMuseumsObjekt(
		at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt puchMuseumsObjekt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePuchMuseumsObjekt(puchMuseumsObjekt);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.PuchMuseumsObjektModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.PuchMuseumsObjektModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt fetchPuchMuseumsObjekt(
		long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPuchMuseumsObjekt(puchmuseumsobjectId);
	}

	/**
	* Returns the puch museums objekt with the primary key.
	*
	* @param puchmuseumsobjectId the primary key of the puch museums objekt
	* @return the puch museums objekt
	* @throws PortalException if a puch museums objekt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt getPuchMuseumsObjekt(
		long puchmuseumsobjectId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPuchMuseumsObjekt(puchmuseumsobjectId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the puch museums objekts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.PuchMuseumsObjektModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of puch museums objekts
	* @param end the upper bound of the range of puch museums objekts (not inclusive)
	* @return the range of puch museums objekts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt> getPuchMuseumsObjekts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPuchMuseumsObjekts(start, end);
	}

	/**
	* Returns the number of puch museums objekts.
	*
	* @return the number of puch museums objekts
	* @throws SystemException if a system exception occurred
	*/
	public static int getPuchMuseumsObjektsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPuchMuseumsObjektsCount();
	}

	/**
	* Updates the puch museums objekt in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param puchMuseumsObjekt the puch museums objekt
	* @return the puch museums objekt that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt updatePuchMuseumsObjekt(
		at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjekt puchMuseumsObjekt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePuchMuseumsObjekt(puchMuseumsObjekt);
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

	public static PuchMuseumsObjektLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PuchMuseumsObjektLocalService.class.getName());

			if (invokableLocalService instanceof PuchMuseumsObjektLocalService) {
				_service = (PuchMuseumsObjektLocalService)invokableLocalService;
			}
			else {
				_service = new PuchMuseumsObjektLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PuchMuseumsObjektLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PuchMuseumsObjektLocalService service) {
	}

	private static PuchMuseumsObjektLocalService _service;
}