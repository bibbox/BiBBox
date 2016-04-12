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
 * Provides a wrapper for {@link GeneReferenceLocalService}.
 *
 * @author reihsr
 * @see GeneReferenceLocalService
 * @generated
 */
public class GeneReferenceLocalServiceWrapper
	implements GeneReferenceLocalService,
		ServiceWrapper<GeneReferenceLocalService> {
	public GeneReferenceLocalServiceWrapper(
		GeneReferenceLocalService geneReferenceLocalService) {
		_geneReferenceLocalService = geneReferenceLocalService;
	}

	/**
	* Adds the gene reference to the database. Also notifies the appropriate model listeners.
	*
	* @param geneReference the gene reference
	* @return the gene reference that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneReference addGeneReference(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneReference geneReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geneReferenceLocalService.addGeneReference(geneReference);
	}

	/**
	* Creates a new gene reference with the primary key. Does not add the gene reference to the database.
	*
	* @param genereferenceId the primary key for the new gene reference
	* @return the new gene reference
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneReference createGeneReference(
		long genereferenceId) {
		return _geneReferenceLocalService.createGeneReference(genereferenceId);
	}

	/**
	* Deletes the gene reference with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param genereferenceId the primary key of the gene reference
	* @return the gene reference that was removed
	* @throws PortalException if a gene reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneReference deleteGeneReference(
		long genereferenceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geneReferenceLocalService.deleteGeneReference(genereferenceId);
	}

	/**
	* Deletes the gene reference from the database. Also notifies the appropriate model listeners.
	*
	* @param geneReference the gene reference
	* @return the gene reference that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneReference deleteGeneReference(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneReference geneReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geneReferenceLocalService.deleteGeneReference(geneReference);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _geneReferenceLocalService.dynamicQuery();
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
		return _geneReferenceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _geneReferenceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _geneReferenceLocalService.dynamicQuery(dynamicQuery, start,
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
		return _geneReferenceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _geneReferenceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneReference fetchGeneReference(
		long genereferenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geneReferenceLocalService.fetchGeneReference(genereferenceId);
	}

	/**
	* Returns the gene reference with the primary key.
	*
	* @param genereferenceId the primary key of the gene reference
	* @return the gene reference
	* @throws PortalException if a gene reference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneReference getGeneReference(
		long genereferenceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geneReferenceLocalService.getGeneReference(genereferenceId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geneReferenceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the gene references.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneReferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gene references
	* @param end the upper bound of the range of gene references (not inclusive)
	* @return the range of gene references
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.GeneReference> getGeneReferences(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geneReferenceLocalService.getGeneReferences(start, end);
	}

	/**
	* Returns the number of gene references.
	*
	* @return the number of gene references
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGeneReferencesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geneReferenceLocalService.getGeneReferencesCount();
	}

	/**
	* Updates the gene reference in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param geneReference the gene reference
	* @return the gene reference that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneReference updateGeneReference(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneReference geneReference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geneReferenceLocalService.updateGeneReference(geneReference);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _geneReferenceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_geneReferenceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _geneReferenceLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GeneReferenceLocalService getWrappedGeneReferenceLocalService() {
		return _geneReferenceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGeneReferenceLocalService(
		GeneReferenceLocalService geneReferenceLocalService) {
		_geneReferenceLocalService = geneReferenceLocalService;
	}

	@Override
	public GeneReferenceLocalService getWrappedService() {
		return _geneReferenceLocalService;
	}

	@Override
	public void setWrappedService(
		GeneReferenceLocalService geneReferenceLocalService) {
		_geneReferenceLocalService = geneReferenceLocalService;
	}

	private GeneReferenceLocalService _geneReferenceLocalService;
}