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
 * Provides a wrapper for {@link GeneSynonymLocalService}.
 *
 * @author reihsr
 * @see GeneSynonymLocalService
 * @generated
 */
public class GeneSynonymLocalServiceWrapper implements GeneSynonymLocalService,
	ServiceWrapper<GeneSynonymLocalService> {
	public GeneSynonymLocalServiceWrapper(
		GeneSynonymLocalService geneSynonymLocalService) {
		_geneSynonymLocalService = geneSynonymLocalService;
	}

	/**
	* Adds the gene synonym to the database. Also notifies the appropriate model listeners.
	*
	* @param geneSynonym the gene synonym
	* @return the gene synonym that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym addGeneSynonym(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym geneSynonym)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geneSynonymLocalService.addGeneSynonym(geneSynonym);
	}

	/**
	* Creates a new gene synonym with the primary key. Does not add the gene synonym to the database.
	*
	* @param genesynonymId the primary key for the new gene synonym
	* @return the new gene synonym
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym createGeneSynonym(
		long genesynonymId) {
		return _geneSynonymLocalService.createGeneSynonym(genesynonymId);
	}

	/**
	* Deletes the gene synonym with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param genesynonymId the primary key of the gene synonym
	* @return the gene synonym that was removed
	* @throws PortalException if a gene synonym with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym deleteGeneSynonym(
		long genesynonymId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geneSynonymLocalService.deleteGeneSynonym(genesynonymId);
	}

	/**
	* Deletes the gene synonym from the database. Also notifies the appropriate model listeners.
	*
	* @param geneSynonym the gene synonym
	* @return the gene synonym that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym deleteGeneSynonym(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym geneSynonym)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geneSynonymLocalService.deleteGeneSynonym(geneSynonym);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _geneSynonymLocalService.dynamicQuery();
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
		return _geneSynonymLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneSynonymModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _geneSynonymLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneSynonymModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _geneSynonymLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _geneSynonymLocalService.dynamicQueryCount(dynamicQuery);
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
		return _geneSynonymLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym fetchGeneSynonym(
		long genesynonymId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geneSynonymLocalService.fetchGeneSynonym(genesynonymId);
	}

	/**
	* Returns the gene synonym with the primary key.
	*
	* @param genesynonymId the primary key of the gene synonym
	* @return the gene synonym
	* @throws PortalException if a gene synonym with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym getGeneSynonym(
		long genesynonymId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geneSynonymLocalService.getGeneSynonym(genesynonymId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geneSynonymLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the gene synonyms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneSynonymModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gene synonyms
	* @param end the upper bound of the range of gene synonyms (not inclusive)
	* @return the range of gene synonyms
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym> getGeneSynonyms(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geneSynonymLocalService.getGeneSynonyms(start, end);
	}

	/**
	* Returns the number of gene synonyms.
	*
	* @return the number of gene synonyms
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGeneSynonymsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geneSynonymLocalService.getGeneSynonymsCount();
	}

	/**
	* Updates the gene synonym in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param geneSynonym the gene synonym
	* @return the gene synonym that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym updateGeneSynonym(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonym geneSynonym)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geneSynonymLocalService.updateGeneSynonym(geneSynonym);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _geneSynonymLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_geneSynonymLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _geneSynonymLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GeneSynonymLocalService getWrappedGeneSynonymLocalService() {
		return _geneSynonymLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGeneSynonymLocalService(
		GeneSynonymLocalService geneSynonymLocalService) {
		_geneSynonymLocalService = geneSynonymLocalService;
	}

	@Override
	public GeneSynonymLocalService getWrappedService() {
		return _geneSynonymLocalService;
	}

	@Override
	public void setWrappedService(
		GeneSynonymLocalService geneSynonymLocalService) {
		_geneSynonymLocalService = geneSynonymLocalService;
	}

	private GeneSynonymLocalService _geneSynonymLocalService;
}