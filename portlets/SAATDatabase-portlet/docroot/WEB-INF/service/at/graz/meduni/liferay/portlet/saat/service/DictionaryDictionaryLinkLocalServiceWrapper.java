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

package at.graz.meduni.liferay.portlet.saat.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DictionaryDictionaryLinkLocalService}.
 *
 * @author reihsr
 * @see DictionaryDictionaryLinkLocalService
 * @generated
 */
public class DictionaryDictionaryLinkLocalServiceWrapper
	implements DictionaryDictionaryLinkLocalService,
		ServiceWrapper<DictionaryDictionaryLinkLocalService> {
	public DictionaryDictionaryLinkLocalServiceWrapper(
		DictionaryDictionaryLinkLocalService dictionaryDictionaryLinkLocalService) {
		_dictionaryDictionaryLinkLocalService = dictionaryDictionaryLinkLocalService;
	}

	/**
	* Adds the dictionary dictionary link to the database. Also notifies the appropriate model listeners.
	*
	* @param dictionaryDictionaryLink the dictionary dictionary link
	* @return the dictionary dictionary link that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink addDictionaryDictionaryLink(
		at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink dictionaryDictionaryLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryDictionaryLinkLocalService.addDictionaryDictionaryLink(dictionaryDictionaryLink);
	}

	/**
	* Creates a new dictionary dictionary link with the primary key. Does not add the dictionary dictionary link to the database.
	*
	* @param dictionary_dictionary_addiction_linkId the primary key for the new dictionary dictionary link
	* @return the new dictionary dictionary link
	*/
	@Override
	public at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink createDictionaryDictionaryLink(
		long dictionary_dictionary_addiction_linkId) {
		return _dictionaryDictionaryLinkLocalService.createDictionaryDictionaryLink(dictionary_dictionary_addiction_linkId);
	}

	/**
	* Deletes the dictionary dictionary link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionary_dictionary_addiction_linkId the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link that was removed
	* @throws PortalException if a dictionary dictionary link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink deleteDictionaryDictionaryLink(
		long dictionary_dictionary_addiction_linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryDictionaryLinkLocalService.deleteDictionaryDictionaryLink(dictionary_dictionary_addiction_linkId);
	}

	/**
	* Deletes the dictionary dictionary link from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionaryDictionaryLink the dictionary dictionary link
	* @return the dictionary dictionary link that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink deleteDictionaryDictionaryLink(
		at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink dictionaryDictionaryLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryDictionaryLinkLocalService.deleteDictionaryDictionaryLink(dictionaryDictionaryLink);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dictionaryDictionaryLinkLocalService.dynamicQuery();
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
		return _dictionaryDictionaryLinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dictionaryDictionaryLinkLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dictionaryDictionaryLinkLocalService.dynamicQuery(dynamicQuery,
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
		return _dictionaryDictionaryLinkLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dictionaryDictionaryLinkLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink fetchDictionaryDictionaryLink(
		long dictionary_dictionary_addiction_linkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryDictionaryLinkLocalService.fetchDictionaryDictionaryLink(dictionary_dictionary_addiction_linkId);
	}

	/**
	* Returns the dictionary dictionary link with the primary key.
	*
	* @param dictionary_dictionary_addiction_linkId the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link
	* @throws PortalException if a dictionary dictionary link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink getDictionaryDictionaryLink(
		long dictionary_dictionary_addiction_linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryDictionaryLinkLocalService.getDictionaryDictionaryLink(dictionary_dictionary_addiction_linkId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryDictionaryLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the dictionary dictionary links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @return the range of dictionary dictionary links
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink> getDictionaryDictionaryLinks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryDictionaryLinkLocalService.getDictionaryDictionaryLinks(start,
			end);
	}

	/**
	* Returns the number of dictionary dictionary links.
	*
	* @return the number of dictionary dictionary links
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDictionaryDictionaryLinksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryDictionaryLinkLocalService.getDictionaryDictionaryLinksCount();
	}

	/**
	* Updates the dictionary dictionary link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dictionaryDictionaryLink the dictionary dictionary link
	* @return the dictionary dictionary link that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink updateDictionaryDictionaryLink(
		at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink dictionaryDictionaryLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryDictionaryLinkLocalService.updateDictionaryDictionaryLink(dictionaryDictionaryLink);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _dictionaryDictionaryLinkLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dictionaryDictionaryLinkLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dictionaryDictionaryLinkLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DictionaryDictionaryLinkLocalService getWrappedDictionaryDictionaryLinkLocalService() {
		return _dictionaryDictionaryLinkLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDictionaryDictionaryLinkLocalService(
		DictionaryDictionaryLinkLocalService dictionaryDictionaryLinkLocalService) {
		_dictionaryDictionaryLinkLocalService = dictionaryDictionaryLinkLocalService;
	}

	@Override
	public DictionaryDictionaryLinkLocalService getWrappedService() {
		return _dictionaryDictionaryLinkLocalService;
	}

	@Override
	public void setWrappedService(
		DictionaryDictionaryLinkLocalService dictionaryDictionaryLinkLocalService) {
		_dictionaryDictionaryLinkLocalService = dictionaryDictionaryLinkLocalService;
	}

	private DictionaryDictionaryLinkLocalService _dictionaryDictionaryLinkLocalService;
}