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

package at.graz.hmmc.liferay.portlet.puch.service.base;

import at.graz.hmmc.liferay.portlet.puch.model.Transaktion;
import at.graz.hmmc.liferay.portlet.puch.service.TransaktionLocalService;
import at.graz.hmmc.liferay.portlet.puch.service.persistence.ConfigurationPersistence;
import at.graz.hmmc.liferay.portlet.puch.service.persistence.ObjectDataPersistence;
import at.graz.hmmc.liferay.portlet.puch.service.persistence.ObjectImagePersistence;
import at.graz.hmmc.liferay.portlet.puch.service.persistence.ParameterConfigurationPersistence;
import at.graz.hmmc.liferay.portlet.puch.service.persistence.ParameterOptionsConfigurationPersistence;
import at.graz.hmmc.liferay.portlet.puch.service.persistence.PersonPersistence;
import at.graz.hmmc.liferay.portlet.puch.service.persistence.PuchMuseumsObjektPersistence;
import at.graz.hmmc.liferay.portlet.puch.service.persistence.TransaktionDataPersistence;
import at.graz.hmmc.liferay.portlet.puch.service.persistence.TransaktionPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the transaktion local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link at.graz.hmmc.liferay.portlet.puch.service.impl.TransaktionLocalServiceImpl}.
 * </p>
 *
 * @author reihsr
 * @see at.graz.hmmc.liferay.portlet.puch.service.impl.TransaktionLocalServiceImpl
 * @see at.graz.hmmc.liferay.portlet.puch.service.TransaktionLocalServiceUtil
 * @generated
 */
public abstract class TransaktionLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements TransaktionLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link at.graz.hmmc.liferay.portlet.puch.service.TransaktionLocalServiceUtil} to access the transaktion local service.
	 */

	/**
	 * Adds the transaktion to the database. Also notifies the appropriate model listeners.
	 *
	 * @param transaktion the transaktion
	 * @return the transaktion that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Transaktion addTransaktion(Transaktion transaktion)
		throws SystemException {
		transaktion.setNew(true);

		return transaktionPersistence.update(transaktion);
	}

	/**
	 * Creates a new transaktion with the primary key. Does not add the transaktion to the database.
	 *
	 * @param transaktionId the primary key for the new transaktion
	 * @return the new transaktion
	 */
	@Override
	public Transaktion createTransaktion(long transaktionId) {
		return transaktionPersistence.create(transaktionId);
	}

	/**
	 * Deletes the transaktion with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transaktionId the primary key of the transaktion
	 * @return the transaktion that was removed
	 * @throws PortalException if a transaktion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Transaktion deleteTransaktion(long transaktionId)
		throws PortalException, SystemException {
		return transaktionPersistence.remove(transaktionId);
	}

	/**
	 * Deletes the transaktion from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transaktion the transaktion
	 * @return the transaktion that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Transaktion deleteTransaktion(Transaktion transaktion)
		throws SystemException {
		return transaktionPersistence.remove(transaktion);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Transaktion.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return transaktionPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return transaktionPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return transaktionPersistence.findWithDynamicQuery(dynamicQuery, start,
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return transaktionPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return transaktionPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Transaktion fetchTransaktion(long transaktionId)
		throws SystemException {
		return transaktionPersistence.fetchByPrimaryKey(transaktionId);
	}

	/**
	 * Returns the transaktion with the primary key.
	 *
	 * @param transaktionId the primary key of the transaktion
	 * @return the transaktion
	 * @throws PortalException if a transaktion with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Transaktion getTransaktion(long transaktionId)
		throws PortalException, SystemException {
		return transaktionPersistence.findByPrimaryKey(transaktionId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return transaktionPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the transaktions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of transaktions
	 * @param end the upper bound of the range of transaktions (not inclusive)
	 * @return the range of transaktions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Transaktion> getTransaktions(int start, int end)
		throws SystemException {
		return transaktionPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of transaktions.
	 *
	 * @return the number of transaktions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getTransaktionsCount() throws SystemException {
		return transaktionPersistence.countAll();
	}

	/**
	 * Updates the transaktion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param transaktion the transaktion
	 * @return the transaktion that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Transaktion updateTransaktion(Transaktion transaktion)
		throws SystemException {
		return transaktionPersistence.update(transaktion);
	}

	/**
	 * Returns the configuration local service.
	 *
	 * @return the configuration local service
	 */
	public at.graz.hmmc.liferay.portlet.puch.service.ConfigurationLocalService getConfigurationLocalService() {
		return configurationLocalService;
	}

	/**
	 * Sets the configuration local service.
	 *
	 * @param configurationLocalService the configuration local service
	 */
	public void setConfigurationLocalService(
		at.graz.hmmc.liferay.portlet.puch.service.ConfigurationLocalService configurationLocalService) {
		this.configurationLocalService = configurationLocalService;
	}

	/**
	 * Returns the configuration persistence.
	 *
	 * @return the configuration persistence
	 */
	public ConfigurationPersistence getConfigurationPersistence() {
		return configurationPersistence;
	}

	/**
	 * Sets the configuration persistence.
	 *
	 * @param configurationPersistence the configuration persistence
	 */
	public void setConfigurationPersistence(
		ConfigurationPersistence configurationPersistence) {
		this.configurationPersistence = configurationPersistence;
	}

	/**
	 * Returns the object data local service.
	 *
	 * @return the object data local service
	 */
	public at.graz.hmmc.liferay.portlet.puch.service.ObjectDataLocalService getObjectDataLocalService() {
		return objectDataLocalService;
	}

	/**
	 * Sets the object data local service.
	 *
	 * @param objectDataLocalService the object data local service
	 */
	public void setObjectDataLocalService(
		at.graz.hmmc.liferay.portlet.puch.service.ObjectDataLocalService objectDataLocalService) {
		this.objectDataLocalService = objectDataLocalService;
	}

	/**
	 * Returns the object data persistence.
	 *
	 * @return the object data persistence
	 */
	public ObjectDataPersistence getObjectDataPersistence() {
		return objectDataPersistence;
	}

	/**
	 * Sets the object data persistence.
	 *
	 * @param objectDataPersistence the object data persistence
	 */
	public void setObjectDataPersistence(
		ObjectDataPersistence objectDataPersistence) {
		this.objectDataPersistence = objectDataPersistence;
	}

	/**
	 * Returns the object image local service.
	 *
	 * @return the object image local service
	 */
	public at.graz.hmmc.liferay.portlet.puch.service.ObjectImageLocalService getObjectImageLocalService() {
		return objectImageLocalService;
	}

	/**
	 * Sets the object image local service.
	 *
	 * @param objectImageLocalService the object image local service
	 */
	public void setObjectImageLocalService(
		at.graz.hmmc.liferay.portlet.puch.service.ObjectImageLocalService objectImageLocalService) {
		this.objectImageLocalService = objectImageLocalService;
	}

	/**
	 * Returns the object image persistence.
	 *
	 * @return the object image persistence
	 */
	public ObjectImagePersistence getObjectImagePersistence() {
		return objectImagePersistence;
	}

	/**
	 * Sets the object image persistence.
	 *
	 * @param objectImagePersistence the object image persistence
	 */
	public void setObjectImagePersistence(
		ObjectImagePersistence objectImagePersistence) {
		this.objectImagePersistence = objectImagePersistence;
	}

	/**
	 * Returns the parameter configuration local service.
	 *
	 * @return the parameter configuration local service
	 */
	public at.graz.hmmc.liferay.portlet.puch.service.ParameterConfigurationLocalService getParameterConfigurationLocalService() {
		return parameterConfigurationLocalService;
	}

	/**
	 * Sets the parameter configuration local service.
	 *
	 * @param parameterConfigurationLocalService the parameter configuration local service
	 */
	public void setParameterConfigurationLocalService(
		at.graz.hmmc.liferay.portlet.puch.service.ParameterConfigurationLocalService parameterConfigurationLocalService) {
		this.parameterConfigurationLocalService = parameterConfigurationLocalService;
	}

	/**
	 * Returns the parameter configuration persistence.
	 *
	 * @return the parameter configuration persistence
	 */
	public ParameterConfigurationPersistence getParameterConfigurationPersistence() {
		return parameterConfigurationPersistence;
	}

	/**
	 * Sets the parameter configuration persistence.
	 *
	 * @param parameterConfigurationPersistence the parameter configuration persistence
	 */
	public void setParameterConfigurationPersistence(
		ParameterConfigurationPersistence parameterConfigurationPersistence) {
		this.parameterConfigurationPersistence = parameterConfigurationPersistence;
	}

	/**
	 * Returns the parameter options configuration local service.
	 *
	 * @return the parameter options configuration local service
	 */
	public at.graz.hmmc.liferay.portlet.puch.service.ParameterOptionsConfigurationLocalService getParameterOptionsConfigurationLocalService() {
		return parameterOptionsConfigurationLocalService;
	}

	/**
	 * Sets the parameter options configuration local service.
	 *
	 * @param parameterOptionsConfigurationLocalService the parameter options configuration local service
	 */
	public void setParameterOptionsConfigurationLocalService(
		at.graz.hmmc.liferay.portlet.puch.service.ParameterOptionsConfigurationLocalService parameterOptionsConfigurationLocalService) {
		this.parameterOptionsConfigurationLocalService = parameterOptionsConfigurationLocalService;
	}

	/**
	 * Returns the parameter options configuration persistence.
	 *
	 * @return the parameter options configuration persistence
	 */
	public ParameterOptionsConfigurationPersistence getParameterOptionsConfigurationPersistence() {
		return parameterOptionsConfigurationPersistence;
	}

	/**
	 * Sets the parameter options configuration persistence.
	 *
	 * @param parameterOptionsConfigurationPersistence the parameter options configuration persistence
	 */
	public void setParameterOptionsConfigurationPersistence(
		ParameterOptionsConfigurationPersistence parameterOptionsConfigurationPersistence) {
		this.parameterOptionsConfigurationPersistence = parameterOptionsConfigurationPersistence;
	}

	/**
	 * Returns the person local service.
	 *
	 * @return the person local service
	 */
	public at.graz.hmmc.liferay.portlet.puch.service.PersonLocalService getPersonLocalService() {
		return personLocalService;
	}

	/**
	 * Sets the person local service.
	 *
	 * @param personLocalService the person local service
	 */
	public void setPersonLocalService(
		at.graz.hmmc.liferay.portlet.puch.service.PersonLocalService personLocalService) {
		this.personLocalService = personLocalService;
	}

	/**
	 * Returns the person persistence.
	 *
	 * @return the person persistence
	 */
	public PersonPersistence getPersonPersistence() {
		return personPersistence;
	}

	/**
	 * Sets the person persistence.
	 *
	 * @param personPersistence the person persistence
	 */
	public void setPersonPersistence(PersonPersistence personPersistence) {
		this.personPersistence = personPersistence;
	}

	/**
	 * Returns the puch museums objekt local service.
	 *
	 * @return the puch museums objekt local service
	 */
	public at.graz.hmmc.liferay.portlet.puch.service.PuchMuseumsObjektLocalService getPuchMuseumsObjektLocalService() {
		return puchMuseumsObjektLocalService;
	}

	/**
	 * Sets the puch museums objekt local service.
	 *
	 * @param puchMuseumsObjektLocalService the puch museums objekt local service
	 */
	public void setPuchMuseumsObjektLocalService(
		at.graz.hmmc.liferay.portlet.puch.service.PuchMuseumsObjektLocalService puchMuseumsObjektLocalService) {
		this.puchMuseumsObjektLocalService = puchMuseumsObjektLocalService;
	}

	/**
	 * Returns the puch museums objekt persistence.
	 *
	 * @return the puch museums objekt persistence
	 */
	public PuchMuseumsObjektPersistence getPuchMuseumsObjektPersistence() {
		return puchMuseumsObjektPersistence;
	}

	/**
	 * Sets the puch museums objekt persistence.
	 *
	 * @param puchMuseumsObjektPersistence the puch museums objekt persistence
	 */
	public void setPuchMuseumsObjektPersistence(
		PuchMuseumsObjektPersistence puchMuseumsObjektPersistence) {
		this.puchMuseumsObjektPersistence = puchMuseumsObjektPersistence;
	}

	/**
	 * Returns the transaktion local service.
	 *
	 * @return the transaktion local service
	 */
	public at.graz.hmmc.liferay.portlet.puch.service.TransaktionLocalService getTransaktionLocalService() {
		return transaktionLocalService;
	}

	/**
	 * Sets the transaktion local service.
	 *
	 * @param transaktionLocalService the transaktion local service
	 */
	public void setTransaktionLocalService(
		at.graz.hmmc.liferay.portlet.puch.service.TransaktionLocalService transaktionLocalService) {
		this.transaktionLocalService = transaktionLocalService;
	}

	/**
	 * Returns the transaktion persistence.
	 *
	 * @return the transaktion persistence
	 */
	public TransaktionPersistence getTransaktionPersistence() {
		return transaktionPersistence;
	}

	/**
	 * Sets the transaktion persistence.
	 *
	 * @param transaktionPersistence the transaktion persistence
	 */
	public void setTransaktionPersistence(
		TransaktionPersistence transaktionPersistence) {
		this.transaktionPersistence = transaktionPersistence;
	}

	/**
	 * Returns the transaktion data local service.
	 *
	 * @return the transaktion data local service
	 */
	public at.graz.hmmc.liferay.portlet.puch.service.TransaktionDataLocalService getTransaktionDataLocalService() {
		return transaktionDataLocalService;
	}

	/**
	 * Sets the transaktion data local service.
	 *
	 * @param transaktionDataLocalService the transaktion data local service
	 */
	public void setTransaktionDataLocalService(
		at.graz.hmmc.liferay.portlet.puch.service.TransaktionDataLocalService transaktionDataLocalService) {
		this.transaktionDataLocalService = transaktionDataLocalService;
	}

	/**
	 * Returns the transaktion data persistence.
	 *
	 * @return the transaktion data persistence
	 */
	public TransaktionDataPersistence getTransaktionDataPersistence() {
		return transaktionDataPersistence;
	}

	/**
	 * Sets the transaktion data persistence.
	 *
	 * @param transaktionDataPersistence the transaktion data persistence
	 */
	public void setTransaktionDataPersistence(
		TransaktionDataPersistence transaktionDataPersistence) {
		this.transaktionDataPersistence = transaktionDataPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("at.graz.hmmc.liferay.portlet.puch.model.Transaktion",
			transaktionLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"at.graz.hmmc.liferay.portlet.puch.model.Transaktion");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Transaktion.class;
	}

	protected String getModelClassName() {
		return Transaktion.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = transaktionPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = at.graz.hmmc.liferay.portlet.puch.service.ConfigurationLocalService.class)
	protected at.graz.hmmc.liferay.portlet.puch.service.ConfigurationLocalService configurationLocalService;
	@BeanReference(type = ConfigurationPersistence.class)
	protected ConfigurationPersistence configurationPersistence;
	@BeanReference(type = at.graz.hmmc.liferay.portlet.puch.service.ObjectDataLocalService.class)
	protected at.graz.hmmc.liferay.portlet.puch.service.ObjectDataLocalService objectDataLocalService;
	@BeanReference(type = ObjectDataPersistence.class)
	protected ObjectDataPersistence objectDataPersistence;
	@BeanReference(type = at.graz.hmmc.liferay.portlet.puch.service.ObjectImageLocalService.class)
	protected at.graz.hmmc.liferay.portlet.puch.service.ObjectImageLocalService objectImageLocalService;
	@BeanReference(type = ObjectImagePersistence.class)
	protected ObjectImagePersistence objectImagePersistence;
	@BeanReference(type = at.graz.hmmc.liferay.portlet.puch.service.ParameterConfigurationLocalService.class)
	protected at.graz.hmmc.liferay.portlet.puch.service.ParameterConfigurationLocalService parameterConfigurationLocalService;
	@BeanReference(type = ParameterConfigurationPersistence.class)
	protected ParameterConfigurationPersistence parameterConfigurationPersistence;
	@BeanReference(type = at.graz.hmmc.liferay.portlet.puch.service.ParameterOptionsConfigurationLocalService.class)
	protected at.graz.hmmc.liferay.portlet.puch.service.ParameterOptionsConfigurationLocalService parameterOptionsConfigurationLocalService;
	@BeanReference(type = ParameterOptionsConfigurationPersistence.class)
	protected ParameterOptionsConfigurationPersistence parameterOptionsConfigurationPersistence;
	@BeanReference(type = at.graz.hmmc.liferay.portlet.puch.service.PersonLocalService.class)
	protected at.graz.hmmc.liferay.portlet.puch.service.PersonLocalService personLocalService;
	@BeanReference(type = PersonPersistence.class)
	protected PersonPersistence personPersistence;
	@BeanReference(type = at.graz.hmmc.liferay.portlet.puch.service.PuchMuseumsObjektLocalService.class)
	protected at.graz.hmmc.liferay.portlet.puch.service.PuchMuseumsObjektLocalService puchMuseumsObjektLocalService;
	@BeanReference(type = PuchMuseumsObjektPersistence.class)
	protected PuchMuseumsObjektPersistence puchMuseumsObjektPersistence;
	@BeanReference(type = at.graz.hmmc.liferay.portlet.puch.service.TransaktionLocalService.class)
	protected at.graz.hmmc.liferay.portlet.puch.service.TransaktionLocalService transaktionLocalService;
	@BeanReference(type = TransaktionPersistence.class)
	protected TransaktionPersistence transaktionPersistence;
	@BeanReference(type = at.graz.hmmc.liferay.portlet.puch.service.TransaktionDataLocalService.class)
	protected at.graz.hmmc.liferay.portlet.puch.service.TransaktionDataLocalService transaktionDataLocalService;
	@BeanReference(type = TransaktionDataPersistence.class)
	protected TransaktionDataPersistence transaktionDataPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private TransaktionLocalServiceClpInvoker _clpInvoker = new TransaktionLocalServiceClpInvoker();
}