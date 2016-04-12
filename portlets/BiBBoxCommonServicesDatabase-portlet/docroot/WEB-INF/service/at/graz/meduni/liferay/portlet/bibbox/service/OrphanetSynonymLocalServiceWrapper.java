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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OrphanetSynonymLocalService}.
 *
 * @author reihsr
 * @see OrphanetSynonymLocalService
 * @generated
 */
public class OrphanetSynonymLocalServiceWrapper
	implements OrphanetSynonymLocalService,
		ServiceWrapper<OrphanetSynonymLocalService> {
	public OrphanetSynonymLocalServiceWrapper(
		OrphanetSynonymLocalService orphanetSynonymLocalService) {
		_orphanetSynonymLocalService = orphanetSynonymLocalService;
	}

	/**
	* Adds the orphanet synonym to the database. Also notifies the appropriate model listeners.
	*
	* @param orphanetSynonym the orphanet synonym
	* @return the orphanet synonym that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym addOrphanetSynonym(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym orphanetSynonym)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orphanetSynonymLocalService.addOrphanetSynonym(orphanetSynonym);
	}

	/**
	* Creates a new orphanet synonym with the primary key. Does not add the orphanet synonym to the database.
	*
	* @param orphanetsynonymId the primary key for the new orphanet synonym
	* @return the new orphanet synonym
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym createOrphanetSynonym(
		long orphanetsynonymId) {
		return _orphanetSynonymLocalService.createOrphanetSynonym(orphanetsynonymId);
	}

	/**
	* Deletes the orphanet synonym with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orphanetsynonymId the primary key of the orphanet synonym
	* @return the orphanet synonym that was removed
	* @throws PortalException if a orphanet synonym with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym deleteOrphanetSynonym(
		long orphanetsynonymId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orphanetSynonymLocalService.deleteOrphanetSynonym(orphanetsynonymId);
	}

	/**
	* Deletes the orphanet synonym from the database. Also notifies the appropriate model listeners.
	*
	* @param orphanetSynonym the orphanet synonym
	* @return the orphanet synonym that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym deleteOrphanetSynonym(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym orphanetSynonym)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orphanetSynonymLocalService.deleteOrphanetSynonym(orphanetSynonym);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _orphanetSynonymLocalService.dynamicQuery();
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
		return _orphanetSynonymLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetSynonymModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _orphanetSynonymLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetSynonymModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _orphanetSynonymLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _orphanetSynonymLocalService.dynamicQueryCount(dynamicQuery);
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
		return _orphanetSynonymLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym fetchOrphanetSynonym(
		long orphanetsynonymId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orphanetSynonymLocalService.fetchOrphanetSynonym(orphanetsynonymId);
	}

	/**
	* Returns the orphanet synonym with the primary key.
	*
	* @param orphanetsynonymId the primary key of the orphanet synonym
	* @return the orphanet synonym
	* @throws PortalException if a orphanet synonym with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym getOrphanetSynonym(
		long orphanetsynonymId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orphanetSynonymLocalService.getOrphanetSynonym(orphanetsynonymId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orphanetSynonymLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the orphanet synonyms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetSynonymModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of orphanet synonyms
	* @param end the upper bound of the range of orphanet synonyms (not inclusive)
	* @return the range of orphanet synonyms
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym> getOrphanetSynonyms(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orphanetSynonymLocalService.getOrphanetSynonyms(start, end);
	}

	/**
	* Returns the number of orphanet synonyms.
	*
	* @return the number of orphanet synonyms
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOrphanetSynonymsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orphanetSynonymLocalService.getOrphanetSynonymsCount();
	}

	/**
	* Updates the orphanet synonym in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param orphanetSynonym the orphanet synonym
	* @return the orphanet synonym that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym updateOrphanetSynonym(
		at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym orphanetSynonym)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orphanetSynonymLocalService.updateOrphanetSynonym(orphanetSynonym);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _orphanetSynonymLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_orphanetSynonymLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _orphanetSynonymLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym createOrphanetSynonym(
		java.lang.String synonym, long orphanetdisorderId) {
		return _orphanetSynonymLocalService.createOrphanetSynonym(synonym,
			orphanetdisorderId);
	}

	/**
	* @param orphanetdisorderId
	* @return
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonym> getOrphanetSynonymByOrpahnetDisorderId(
		long orphanetdisorderId) {
		return _orphanetSynonymLocalService.getOrphanetSynonymByOrpahnetDisorderId(orphanetdisorderId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OrphanetSynonymLocalService getWrappedOrphanetSynonymLocalService() {
		return _orphanetSynonymLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOrphanetSynonymLocalService(
		OrphanetSynonymLocalService orphanetSynonymLocalService) {
		_orphanetSynonymLocalService = orphanetSynonymLocalService;
	}

	@Override
	public OrphanetSynonymLocalService getWrappedService() {
		return _orphanetSynonymLocalService;
	}

	@Override
	public void setWrappedService(
		OrphanetSynonymLocalService orphanetSynonymLocalService) {
		_orphanetSynonymLocalService = orphanetSynonymLocalService;
	}

	private OrphanetSynonymLocalService _orphanetSynonymLocalService;
}