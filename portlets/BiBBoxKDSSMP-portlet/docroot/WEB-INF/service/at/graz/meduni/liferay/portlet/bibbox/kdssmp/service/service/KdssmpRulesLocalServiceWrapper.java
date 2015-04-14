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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link KdssmpRulesLocalService}.
 *
 * @author reihsr
 * @see KdssmpRulesLocalService
 * @generated
 */
public class KdssmpRulesLocalServiceWrapper implements KdssmpRulesLocalService,
	ServiceWrapper<KdssmpRulesLocalService> {
	public KdssmpRulesLocalServiceWrapper(
		KdssmpRulesLocalService kdssmpRulesLocalService) {
		_kdssmpRulesLocalService = kdssmpRulesLocalService;
	}

	/**
	* Adds the kdssmp rules to the database. Also notifies the appropriate model listeners.
	*
	* @param kdssmpRules the kdssmp rules
	* @return the kdssmp rules that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpRules addKdssmpRules(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpRules kdssmpRules)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpRulesLocalService.addKdssmpRules(kdssmpRules);
	}

	/**
	* Creates a new kdssmp rules with the primary key. Does not add the kdssmp rules to the database.
	*
	* @param ruleId the primary key for the new kdssmp rules
	* @return the new kdssmp rules
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpRules createKdssmpRules(
		long ruleId) {
		return _kdssmpRulesLocalService.createKdssmpRules(ruleId);
	}

	/**
	* Deletes the kdssmp rules with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ruleId the primary key of the kdssmp rules
	* @return the kdssmp rules that was removed
	* @throws PortalException if a kdssmp rules with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpRules deleteKdssmpRules(
		long ruleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpRulesLocalService.deleteKdssmpRules(ruleId);
	}

	/**
	* Deletes the kdssmp rules from the database. Also notifies the appropriate model listeners.
	*
	* @param kdssmpRules the kdssmp rules
	* @return the kdssmp rules that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpRules deleteKdssmpRules(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpRules kdssmpRules)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpRulesLocalService.deleteKdssmpRules(kdssmpRules);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _kdssmpRulesLocalService.dynamicQuery();
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
		return _kdssmpRulesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpRulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _kdssmpRulesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpRulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _kdssmpRulesLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _kdssmpRulesLocalService.dynamicQueryCount(dynamicQuery);
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
		return _kdssmpRulesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpRules fetchKdssmpRules(
		long ruleId) throws com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpRulesLocalService.fetchKdssmpRules(ruleId);
	}

	/**
	* Returns the kdssmp rules with the primary key.
	*
	* @param ruleId the primary key of the kdssmp rules
	* @return the kdssmp rules
	* @throws PortalException if a kdssmp rules with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpRules getKdssmpRules(
		long ruleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpRulesLocalService.getKdssmpRules(ruleId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpRulesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the kdssmp ruleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpRulesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kdssmp ruleses
	* @param end the upper bound of the range of kdssmp ruleses (not inclusive)
	* @return the range of kdssmp ruleses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpRules> getKdssmpRuleses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpRulesLocalService.getKdssmpRuleses(start, end);
	}

	/**
	* Returns the number of kdssmp ruleses.
	*
	* @return the number of kdssmp ruleses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getKdssmpRulesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpRulesLocalService.getKdssmpRulesesCount();
	}

	/**
	* Updates the kdssmp rules in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param kdssmpRules the kdssmp rules
	* @return the kdssmp rules that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpRules updateKdssmpRules(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpRules kdssmpRules)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _kdssmpRulesLocalService.updateKdssmpRules(kdssmpRules);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _kdssmpRulesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_kdssmpRulesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _kdssmpRulesLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public KdssmpRulesLocalService getWrappedKdssmpRulesLocalService() {
		return _kdssmpRulesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedKdssmpRulesLocalService(
		KdssmpRulesLocalService kdssmpRulesLocalService) {
		_kdssmpRulesLocalService = kdssmpRulesLocalService;
	}

	@Override
	public KdssmpRulesLocalService getWrappedService() {
		return _kdssmpRulesLocalService;
	}

	@Override
	public void setWrappedService(
		KdssmpRulesLocalService kdssmpRulesLocalService) {
		_kdssmpRulesLocalService = kdssmpRulesLocalService;
	}

	private KdssmpRulesLocalService _kdssmpRulesLocalService;
}