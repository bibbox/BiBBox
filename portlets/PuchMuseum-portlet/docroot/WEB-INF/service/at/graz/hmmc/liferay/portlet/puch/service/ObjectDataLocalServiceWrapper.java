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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ObjectDataLocalService}.
 *
 * @author reihsr
 * @see ObjectDataLocalService
 * @generated
 */
public class ObjectDataLocalServiceWrapper implements ObjectDataLocalService,
	ServiceWrapper<ObjectDataLocalService> {
	public ObjectDataLocalServiceWrapper(
		ObjectDataLocalService objectDataLocalService) {
		_objectDataLocalService = objectDataLocalService;
	}

	/**
	* Adds the object data to the database. Also notifies the appropriate model listeners.
	*
	* @param objectData the object data
	* @return the object data that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData addObjectData(
		at.graz.hmmc.liferay.portlet.puch.model.ObjectData objectData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectDataLocalService.addObjectData(objectData);
	}

	/**
	* Creates a new object data with the primary key. Does not add the object data to the database.
	*
	* @param objectdataId the primary key for the new object data
	* @return the new object data
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData createObjectData(
		long objectdataId) {
		return _objectDataLocalService.createObjectData(objectdataId);
	}

	/**
	* Deletes the object data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param objectdataId the primary key of the object data
	* @return the object data that was removed
	* @throws PortalException if a object data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData deleteObjectData(
		long objectdataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _objectDataLocalService.deleteObjectData(objectdataId);
	}

	/**
	* Deletes the object data from the database. Also notifies the appropriate model listeners.
	*
	* @param objectData the object data
	* @return the object data that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData deleteObjectData(
		at.graz.hmmc.liferay.portlet.puch.model.ObjectData objectData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectDataLocalService.deleteObjectData(objectData);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _objectDataLocalService.dynamicQuery();
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
		return _objectDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _objectDataLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _objectDataLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _objectDataLocalService.dynamicQueryCount(dynamicQuery);
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
		return _objectDataLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData fetchObjectData(
		long objectdataId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectDataLocalService.fetchObjectData(objectdataId);
	}

	/**
	* Returns the object data with the primary key.
	*
	* @param objectdataId the primary key of the object data
	* @return the object data
	* @throws PortalException if a object data with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData getObjectData(
		long objectdataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _objectDataLocalService.getObjectData(objectdataId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _objectDataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the object datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of object datas
	* @param end the upper bound of the range of object datas (not inclusive)
	* @return the range of object datas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.hmmc.liferay.portlet.puch.model.ObjectData> getObjectDatas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectDataLocalService.getObjectDatas(start, end);
	}

	/**
	* Returns the number of object datas.
	*
	* @return the number of object datas
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getObjectDatasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectDataLocalService.getObjectDatasCount();
	}

	/**
	* Updates the object data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param objectData the object data
	* @return the object data that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData updateObjectData(
		at.graz.hmmc.liferay.portlet.puch.model.ObjectData objectData)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _objectDataLocalService.updateObjectData(objectData);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _objectDataLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_objectDataLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _objectDataLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* @param request
	* @return
	*/
	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData objectDataFromRequest(
		javax.portlet.ActionRequest request) {
		return _objectDataLocalService.objectDataFromRequest(request);
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData addObjectData(
		long puchmuseumsobjectId, java.lang.String objectkey,
		java.lang.String objectvalue) {
		return _objectDataLocalService.addObjectData(puchmuseumsobjectId,
			objectkey, objectvalue);
	}

	@Override
	public at.graz.hmmc.liferay.portlet.puch.model.ObjectData getObjectDataForObject(
		long puchmuseumsobjectId, java.lang.String objectkey) {
		return _objectDataLocalService.getObjectDataForObject(puchmuseumsobjectId,
			objectkey);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ObjectDataLocalService getWrappedObjectDataLocalService() {
		return _objectDataLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedObjectDataLocalService(
		ObjectDataLocalService objectDataLocalService) {
		_objectDataLocalService = objectDataLocalService;
	}

	@Override
	public ObjectDataLocalService getWrappedService() {
		return _objectDataLocalService;
	}

	@Override
	public void setWrappedService(ObjectDataLocalService objectDataLocalService) {
		_objectDataLocalService = objectDataLocalService;
	}

	private ObjectDataLocalService _objectDataLocalService;
}