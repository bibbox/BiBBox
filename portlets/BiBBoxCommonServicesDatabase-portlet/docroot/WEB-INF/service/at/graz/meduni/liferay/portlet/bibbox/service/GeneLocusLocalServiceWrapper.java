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
 * Provides a wrapper for {@link GeneLocusLocalService}.
 *
 * @author reihsr
 * @see GeneLocusLocalService
 * @generated
 */
public class GeneLocusLocalServiceWrapper implements GeneLocusLocalService,
	ServiceWrapper<GeneLocusLocalService> {
	public GeneLocusLocalServiceWrapper(
		GeneLocusLocalService geneLocusLocalService) {
		_geneLocusLocalService = geneLocusLocalService;
	}

	/**
	* Adds the gene locus to the database. Also notifies the appropriate model listeners.
	*
	* @param geneLocus the gene locus
	* @return the gene locus that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus addGeneLocus(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus geneLocus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geneLocusLocalService.addGeneLocus(geneLocus);
	}

	/**
	* Creates a new gene locus with the primary key. Does not add the gene locus to the database.
	*
	* @param genelocusId the primary key for the new gene locus
	* @return the new gene locus
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus createGeneLocus(
		long genelocusId) {
		return _geneLocusLocalService.createGeneLocus(genelocusId);
	}

	/**
	* Deletes the gene locus with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param genelocusId the primary key of the gene locus
	* @return the gene locus that was removed
	* @throws PortalException if a gene locus with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus deleteGeneLocus(
		long genelocusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geneLocusLocalService.deleteGeneLocus(genelocusId);
	}

	/**
	* Deletes the gene locus from the database. Also notifies the appropriate model listeners.
	*
	* @param geneLocus the gene locus
	* @return the gene locus that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus deleteGeneLocus(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus geneLocus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geneLocusLocalService.deleteGeneLocus(geneLocus);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _geneLocusLocalService.dynamicQuery();
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
		return _geneLocusLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneLocusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _geneLocusLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneLocusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _geneLocusLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _geneLocusLocalService.dynamicQueryCount(dynamicQuery);
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
		return _geneLocusLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus fetchGeneLocus(
		long genelocusId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geneLocusLocalService.fetchGeneLocus(genelocusId);
	}

	/**
	* Returns the gene locus with the primary key.
	*
	* @param genelocusId the primary key of the gene locus
	* @return the gene locus
	* @throws PortalException if a gene locus with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus getGeneLocus(
		long genelocusId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geneLocusLocalService.getGeneLocus(genelocusId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _geneLocusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the gene locuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneLocusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gene locuses
	* @param end the upper bound of the range of gene locuses (not inclusive)
	* @return the range of gene locuses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus> getGeneLocuses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geneLocusLocalService.getGeneLocuses(start, end);
	}

	/**
	* Returns the number of gene locuses.
	*
	* @return the number of gene locuses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGeneLocusesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geneLocusLocalService.getGeneLocusesCount();
	}

	/**
	* Updates the gene locus in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param geneLocus the gene locus
	* @return the gene locus that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus updateGeneLocus(
		at.graz.meduni.liferay.portlet.bibbox.model.GeneLocus geneLocus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _geneLocusLocalService.updateGeneLocus(geneLocus);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _geneLocusLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_geneLocusLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _geneLocusLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GeneLocusLocalService getWrappedGeneLocusLocalService() {
		return _geneLocusLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGeneLocusLocalService(
		GeneLocusLocalService geneLocusLocalService) {
		_geneLocusLocalService = geneLocusLocalService;
	}

	@Override
	public GeneLocusLocalService getWrappedService() {
		return _geneLocusLocalService;
	}

	@Override
	public void setWrappedService(GeneLocusLocalService geneLocusLocalService) {
		_geneLocusLocalService = geneLocusLocalService;
	}

	private GeneLocusLocalService _geneLocusLocalService;
}