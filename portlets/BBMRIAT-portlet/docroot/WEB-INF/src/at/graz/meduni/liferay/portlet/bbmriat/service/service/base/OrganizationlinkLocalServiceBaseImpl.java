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

package at.graz.meduni.liferay.portlet.bbmriat.service.service.base;

import at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink;
import at.graz.meduni.liferay.portlet.bbmriat.service.service.OrganizationlinkLocalService;
import at.graz.meduni.liferay.portlet.bbmriat.service.service.persistence.OrganizationlinkPersistence;

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
 * Provides the base implementation for the organizationlink local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link at.graz.meduni.liferay.portlet.bbmriat.service.service.impl.OrganizationlinkLocalServiceImpl}.
 * </p>
 *
 * @author Reihs Robert
 * @see at.graz.meduni.liferay.portlet.bbmriat.service.service.impl.OrganizationlinkLocalServiceImpl
 * @see at.graz.meduni.liferay.portlet.bbmriat.service.service.OrganizationlinkLocalServiceUtil
 * @generated
 */
public abstract class OrganizationlinkLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements OrganizationlinkLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link at.graz.meduni.liferay.portlet.bbmriat.service.service.OrganizationlinkLocalServiceUtil} to access the organizationlink local service.
	 */

	/**
	 * Adds the organizationlink to the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationlink the organizationlink
	 * @return the organizationlink that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Organizationlink addOrganizationlink(
		Organizationlink organizationlink) throws SystemException {
		organizationlink.setNew(true);

		return organizationlinkPersistence.update(organizationlink);
	}

	/**
	 * Creates a new organizationlink with the primary key. Does not add the organizationlink to the database.
	 *
	 * @param organizationlinkId the primary key for the new organizationlink
	 * @return the new organizationlink
	 */
	@Override
	public Organizationlink createOrganizationlink(long organizationlinkId) {
		return organizationlinkPersistence.create(organizationlinkId);
	}

	/**
	 * Deletes the organizationlink with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationlinkId the primary key of the organizationlink
	 * @return the organizationlink that was removed
	 * @throws PortalException if a organizationlink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Organizationlink deleteOrganizationlink(long organizationlinkId)
		throws PortalException, SystemException {
		return organizationlinkPersistence.remove(organizationlinkId);
	}

	/**
	 * Deletes the organizationlink from the database. Also notifies the appropriate model listeners.
	 *
	 * @param organizationlink the organizationlink
	 * @return the organizationlink that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Organizationlink deleteOrganizationlink(
		Organizationlink organizationlink) throws SystemException {
		return organizationlinkPersistence.remove(organizationlink);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Organizationlink.class,
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
		return organizationlinkPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return organizationlinkPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return organizationlinkPersistence.findWithDynamicQuery(dynamicQuery,
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return organizationlinkPersistence.countWithDynamicQuery(dynamicQuery);
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
		return organizationlinkPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Organizationlink fetchOrganizationlink(long organizationlinkId)
		throws SystemException {
		return organizationlinkPersistence.fetchByPrimaryKey(organizationlinkId);
	}

	/**
	 * Returns the organizationlink with the primary key.
	 *
	 * @param organizationlinkId the primary key of the organizationlink
	 * @return the organizationlink
	 * @throws PortalException if a organizationlink with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Organizationlink getOrganizationlink(long organizationlinkId)
		throws PortalException, SystemException {
		return organizationlinkPersistence.findByPrimaryKey(organizationlinkId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return organizationlinkPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the organizationlinks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bbmriat.service.model.impl.OrganizationlinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of organizationlinks
	 * @param end the upper bound of the range of organizationlinks (not inclusive)
	 * @return the range of organizationlinks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Organizationlink> getOrganizationlinks(int start, int end)
		throws SystemException {
		return organizationlinkPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of organizationlinks.
	 *
	 * @return the number of organizationlinks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getOrganizationlinksCount() throws SystemException {
		return organizationlinkPersistence.countAll();
	}

	/**
	 * Updates the organizationlink in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param organizationlink the organizationlink
	 * @return the organizationlink that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Organizationlink updateOrganizationlink(
		Organizationlink organizationlink) throws SystemException {
		return organizationlinkPersistence.update(organizationlink);
	}

	/**
	 * Returns the organizationlink local service.
	 *
	 * @return the organizationlink local service
	 */
	public at.graz.meduni.liferay.portlet.bbmriat.service.service.OrganizationlinkLocalService getOrganizationlinkLocalService() {
		return organizationlinkLocalService;
	}

	/**
	 * Sets the organizationlink local service.
	 *
	 * @param organizationlinkLocalService the organizationlink local service
	 */
	public void setOrganizationlinkLocalService(
		at.graz.meduni.liferay.portlet.bbmriat.service.service.OrganizationlinkLocalService organizationlinkLocalService) {
		this.organizationlinkLocalService = organizationlinkLocalService;
	}

	/**
	 * Returns the organizationlink persistence.
	 *
	 * @return the organizationlink persistence
	 */
	public OrganizationlinkPersistence getOrganizationlinkPersistence() {
		return organizationlinkPersistence;
	}

	/**
	 * Sets the organizationlink persistence.
	 *
	 * @param organizationlinkPersistence the organizationlink persistence
	 */
	public void setOrganizationlinkPersistence(
		OrganizationlinkPersistence organizationlinkPersistence) {
		this.organizationlinkPersistence = organizationlinkPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink",
			organizationlinkLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"at.graz.meduni.liferay.portlet.bbmriat.service.model.Organizationlink");
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
		return Organizationlink.class;
	}

	protected String getModelClassName() {
		return Organizationlink.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = organizationlinkPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = at.graz.meduni.liferay.portlet.bbmriat.service.service.OrganizationlinkLocalService.class)
	protected at.graz.meduni.liferay.portlet.bbmriat.service.service.OrganizationlinkLocalService organizationlinkLocalService;
	@BeanReference(type = OrganizationlinkPersistence.class)
	protected OrganizationlinkPersistence organizationlinkPersistence;
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
	private OrganizationlinkLocalServiceClpInvoker _clpInvoker = new OrganizationlinkLocalServiceClpInvoker();
}