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
 * Provides a wrapper for {@link AQRRatingLocalService}.
 *
 * @author Robert Reihs
 * @see AQRRatingLocalService
 * @generated
 */
public class AQRRatingLocalServiceWrapper implements AQRRatingLocalService,
	ServiceWrapper<AQRRatingLocalService> {
	public AQRRatingLocalServiceWrapper(
		AQRRatingLocalService aqrRatingLocalService) {
		_aqrRatingLocalService = aqrRatingLocalService;
	}

	/**
	* Adds the a q r rating to the database. Also notifies the appropriate model listeners.
	*
	* @param aqrRating the a q r rating
	* @return the a q r rating that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.AQRRating addAQRRating(
		at.meduni.liferay.portlet.rdconnect.model.AQRRating aqrRating)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _aqrRatingLocalService.addAQRRating(aqrRating);
	}

	/**
	* Creates a new a q r rating with the primary key. Does not add the a q r rating to the database.
	*
	* @param aqrId the primary key for the new a q r rating
	* @return the new a q r rating
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.AQRRating createAQRRating(
		long aqrId) {
		return _aqrRatingLocalService.createAQRRating(aqrId);
	}

	/**
	* Deletes the a q r rating with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param aqrId the primary key of the a q r rating
	* @return the a q r rating that was removed
	* @throws PortalException if a a q r rating with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.AQRRating deleteAQRRating(
		long aqrId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _aqrRatingLocalService.deleteAQRRating(aqrId);
	}

	/**
	* Deletes the a q r rating from the database. Also notifies the appropriate model listeners.
	*
	* @param aqrRating the a q r rating
	* @return the a q r rating that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.AQRRating deleteAQRRating(
		at.meduni.liferay.portlet.rdconnect.model.AQRRating aqrRating)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _aqrRatingLocalService.deleteAQRRating(aqrRating);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _aqrRatingLocalService.dynamicQuery();
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
		return _aqrRatingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.AQRRatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _aqrRatingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.AQRRatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _aqrRatingLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _aqrRatingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _aqrRatingLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public at.meduni.liferay.portlet.rdconnect.model.AQRRating fetchAQRRating(
		long aqrId) throws com.liferay.portal.kernel.exception.SystemException {
		return _aqrRatingLocalService.fetchAQRRating(aqrId);
	}

	/**
	* Returns the a q r rating with the primary key.
	*
	* @param aqrId the primary key of the a q r rating
	* @return the a q r rating
	* @throws PortalException if a a q r rating with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.AQRRating getAQRRating(
		long aqrId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _aqrRatingLocalService.getAQRRating(aqrId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _aqrRatingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the a q r ratings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.AQRRatingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of a q r ratings
	* @param end the upper bound of the range of a q r ratings (not inclusive)
	* @return the range of a q r ratings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.meduni.liferay.portlet.rdconnect.model.AQRRating> getAQRRatings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _aqrRatingLocalService.getAQRRatings(start, end);
	}

	/**
	* Returns the number of a q r ratings.
	*
	* @return the number of a q r ratings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAQRRatingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _aqrRatingLocalService.getAQRRatingsCount();
	}

	/**
	* Updates the a q r rating in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param aqrRating the a q r rating
	* @return the a q r rating that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.meduni.liferay.portlet.rdconnect.model.AQRRating updateAQRRating(
		at.meduni.liferay.portlet.rdconnect.model.AQRRating aqrRating)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _aqrRatingLocalService.updateAQRRating(aqrRating);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _aqrRatingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_aqrRatingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _aqrRatingLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AQRRatingLocalService getWrappedAQRRatingLocalService() {
		return _aqrRatingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAQRRatingLocalService(
		AQRRatingLocalService aqrRatingLocalService) {
		_aqrRatingLocalService = aqrRatingLocalService;
	}

	@Override
	public AQRRatingLocalService getWrappedService() {
		return _aqrRatingLocalService;
	}

	@Override
	public void setWrappedService(AQRRatingLocalService aqrRatingLocalService) {
		_aqrRatingLocalService = aqrRatingLocalService;
	}

	private AQRRatingLocalService _aqrRatingLocalService;
}