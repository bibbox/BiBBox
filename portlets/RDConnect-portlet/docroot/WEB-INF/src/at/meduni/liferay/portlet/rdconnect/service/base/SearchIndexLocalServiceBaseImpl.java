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

package at.meduni.liferay.portlet.rdconnect.service.base;

import at.meduni.liferay.portlet.rdconnect.model.SearchIndex;
import at.meduni.liferay.portlet.rdconnect.service.SearchIndexLocalService;
import at.meduni.liferay.portlet.rdconnect.service.persistence.AQRRatingPersistence;
import at.meduni.liferay.portlet.rdconnect.service.persistence.CandidatePersistence;
import at.meduni.liferay.portlet.rdconnect.service.persistence.MasterCandidateLinkCandidatePersistence;
import at.meduni.liferay.portlet.rdconnect.service.persistence.MasterCandidatePersistence;
import at.meduni.liferay.portlet.rdconnect.service.persistence.RDCOrganizationUserAccessPersistence;
import at.meduni.liferay.portlet.rdconnect.service.persistence.RDCRecommenderPersistence;
import at.meduni.liferay.portlet.rdconnect.service.persistence.SearchIndexPersistence;

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
 * Provides the base implementation for the search index local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link at.meduni.liferay.portlet.rdconnect.service.impl.SearchIndexLocalServiceImpl}.
 * </p>
 *
 * @author Robert Reihs
 * @see at.meduni.liferay.portlet.rdconnect.service.impl.SearchIndexLocalServiceImpl
 * @see at.meduni.liferay.portlet.rdconnect.service.SearchIndexLocalServiceUtil
 * @generated
 */
public abstract class SearchIndexLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements SearchIndexLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link at.meduni.liferay.portlet.rdconnect.service.SearchIndexLocalServiceUtil} to access the search index local service.
	 */

	/**
	 * Adds the search index to the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchIndex the search index
	 * @return the search index that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SearchIndex addSearchIndex(SearchIndex searchIndex)
		throws SystemException {
		searchIndex.setNew(true);

		return searchIndexPersistence.update(searchIndex);
	}

	/**
	 * Creates a new search index with the primary key. Does not add the search index to the database.
	 *
	 * @param searchid the primary key for the new search index
	 * @return the new search index
	 */
	@Override
	public SearchIndex createSearchIndex(long searchid) {
		return searchIndexPersistence.create(searchid);
	}

	/**
	 * Deletes the search index with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchid the primary key of the search index
	 * @return the search index that was removed
	 * @throws PortalException if a search index with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SearchIndex deleteSearchIndex(long searchid)
		throws PortalException, SystemException {
		return searchIndexPersistence.remove(searchid);
	}

	/**
	 * Deletes the search index from the database. Also notifies the appropriate model listeners.
	 *
	 * @param searchIndex the search index
	 * @return the search index that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SearchIndex deleteSearchIndex(SearchIndex searchIndex)
		throws SystemException {
		return searchIndexPersistence.remove(searchIndex);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(SearchIndex.class,
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
		return searchIndexPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return searchIndexPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return searchIndexPersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return searchIndexPersistence.countWithDynamicQuery(dynamicQuery);
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
		return searchIndexPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public SearchIndex fetchSearchIndex(long searchid)
		throws SystemException {
		return searchIndexPersistence.fetchByPrimaryKey(searchid);
	}

	/**
	 * Returns the search index with the primary key.
	 *
	 * @param searchid the primary key of the search index
	 * @return the search index
	 * @throws PortalException if a search index with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SearchIndex getSearchIndex(long searchid)
		throws PortalException, SystemException {
		return searchIndexPersistence.findByPrimaryKey(searchid);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return searchIndexPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the search indexs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.rdconnect.model.impl.SearchIndexModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of search indexs
	 * @param end the upper bound of the range of search indexs (not inclusive)
	 * @return the range of search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SearchIndex> getSearchIndexs(int start, int end)
		throws SystemException {
		return searchIndexPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of search indexs.
	 *
	 * @return the number of search indexs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSearchIndexsCount() throws SystemException {
		return searchIndexPersistence.countAll();
	}

	/**
	 * Updates the search index in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param searchIndex the search index
	 * @return the search index that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SearchIndex updateSearchIndex(SearchIndex searchIndex)
		throws SystemException {
		return searchIndexPersistence.update(searchIndex);
	}

	/**
	 * Returns the a q r rating local service.
	 *
	 * @return the a q r rating local service
	 */
	public at.meduni.liferay.portlet.rdconnect.service.AQRRatingLocalService getAQRRatingLocalService() {
		return aqrRatingLocalService;
	}

	/**
	 * Sets the a q r rating local service.
	 *
	 * @param aqrRatingLocalService the a q r rating local service
	 */
	public void setAQRRatingLocalService(
		at.meduni.liferay.portlet.rdconnect.service.AQRRatingLocalService aqrRatingLocalService) {
		this.aqrRatingLocalService = aqrRatingLocalService;
	}

	/**
	 * Returns the a q r rating persistence.
	 *
	 * @return the a q r rating persistence
	 */
	public AQRRatingPersistence getAQRRatingPersistence() {
		return aqrRatingPersistence;
	}

	/**
	 * Sets the a q r rating persistence.
	 *
	 * @param aqrRatingPersistence the a q r rating persistence
	 */
	public void setAQRRatingPersistence(
		AQRRatingPersistence aqrRatingPersistence) {
		this.aqrRatingPersistence = aqrRatingPersistence;
	}

	/**
	 * Returns the candidate local service.
	 *
	 * @return the candidate local service
	 */
	public at.meduni.liferay.portlet.rdconnect.service.CandidateLocalService getCandidateLocalService() {
		return candidateLocalService;
	}

	/**
	 * Sets the candidate local service.
	 *
	 * @param candidateLocalService the candidate local service
	 */
	public void setCandidateLocalService(
		at.meduni.liferay.portlet.rdconnect.service.CandidateLocalService candidateLocalService) {
		this.candidateLocalService = candidateLocalService;
	}

	/**
	 * Returns the candidate persistence.
	 *
	 * @return the candidate persistence
	 */
	public CandidatePersistence getCandidatePersistence() {
		return candidatePersistence;
	}

	/**
	 * Sets the candidate persistence.
	 *
	 * @param candidatePersistence the candidate persistence
	 */
	public void setCandidatePersistence(
		CandidatePersistence candidatePersistence) {
		this.candidatePersistence = candidatePersistence;
	}

	/**
	 * Returns the master candidate local service.
	 *
	 * @return the master candidate local service
	 */
	public at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLocalService getMasterCandidateLocalService() {
		return masterCandidateLocalService;
	}

	/**
	 * Sets the master candidate local service.
	 *
	 * @param masterCandidateLocalService the master candidate local service
	 */
	public void setMasterCandidateLocalService(
		at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLocalService masterCandidateLocalService) {
		this.masterCandidateLocalService = masterCandidateLocalService;
	}

	/**
	 * Returns the master candidate persistence.
	 *
	 * @return the master candidate persistence
	 */
	public MasterCandidatePersistence getMasterCandidatePersistence() {
		return masterCandidatePersistence;
	}

	/**
	 * Sets the master candidate persistence.
	 *
	 * @param masterCandidatePersistence the master candidate persistence
	 */
	public void setMasterCandidatePersistence(
		MasterCandidatePersistence masterCandidatePersistence) {
		this.masterCandidatePersistence = masterCandidatePersistence;
	}

	/**
	 * Returns the master candidate link candidate local service.
	 *
	 * @return the master candidate link candidate local service
	 */
	public at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLinkCandidateLocalService getMasterCandidateLinkCandidateLocalService() {
		return masterCandidateLinkCandidateLocalService;
	}

	/**
	 * Sets the master candidate link candidate local service.
	 *
	 * @param masterCandidateLinkCandidateLocalService the master candidate link candidate local service
	 */
	public void setMasterCandidateLinkCandidateLocalService(
		at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLinkCandidateLocalService masterCandidateLinkCandidateLocalService) {
		this.masterCandidateLinkCandidateLocalService = masterCandidateLinkCandidateLocalService;
	}

	/**
	 * Returns the master candidate link candidate persistence.
	 *
	 * @return the master candidate link candidate persistence
	 */
	public MasterCandidateLinkCandidatePersistence getMasterCandidateLinkCandidatePersistence() {
		return masterCandidateLinkCandidatePersistence;
	}

	/**
	 * Sets the master candidate link candidate persistence.
	 *
	 * @param masterCandidateLinkCandidatePersistence the master candidate link candidate persistence
	 */
	public void setMasterCandidateLinkCandidatePersistence(
		MasterCandidateLinkCandidatePersistence masterCandidateLinkCandidatePersistence) {
		this.masterCandidateLinkCandidatePersistence = masterCandidateLinkCandidatePersistence;
	}

	/**
	 * Returns the r d c organization user access local service.
	 *
	 * @return the r d c organization user access local service
	 */
	public at.meduni.liferay.portlet.rdconnect.service.RDCOrganizationUserAccessLocalService getRDCOrganizationUserAccessLocalService() {
		return rdcOrganizationUserAccessLocalService;
	}

	/**
	 * Sets the r d c organization user access local service.
	 *
	 * @param rdcOrganizationUserAccessLocalService the r d c organization user access local service
	 */
	public void setRDCOrganizationUserAccessLocalService(
		at.meduni.liferay.portlet.rdconnect.service.RDCOrganizationUserAccessLocalService rdcOrganizationUserAccessLocalService) {
		this.rdcOrganizationUserAccessLocalService = rdcOrganizationUserAccessLocalService;
	}

	/**
	 * Returns the r d c organization user access persistence.
	 *
	 * @return the r d c organization user access persistence
	 */
	public RDCOrganizationUserAccessPersistence getRDCOrganizationUserAccessPersistence() {
		return rdcOrganizationUserAccessPersistence;
	}

	/**
	 * Sets the r d c organization user access persistence.
	 *
	 * @param rdcOrganizationUserAccessPersistence the r d c organization user access persistence
	 */
	public void setRDCOrganizationUserAccessPersistence(
		RDCOrganizationUserAccessPersistence rdcOrganizationUserAccessPersistence) {
		this.rdcOrganizationUserAccessPersistence = rdcOrganizationUserAccessPersistence;
	}

	/**
	 * Returns the r d c recommender local service.
	 *
	 * @return the r d c recommender local service
	 */
	public at.meduni.liferay.portlet.rdconnect.service.RDCRecommenderLocalService getRDCRecommenderLocalService() {
		return rdcRecommenderLocalService;
	}

	/**
	 * Sets the r d c recommender local service.
	 *
	 * @param rdcRecommenderLocalService the r d c recommender local service
	 */
	public void setRDCRecommenderLocalService(
		at.meduni.liferay.portlet.rdconnect.service.RDCRecommenderLocalService rdcRecommenderLocalService) {
		this.rdcRecommenderLocalService = rdcRecommenderLocalService;
	}

	/**
	 * Returns the r d c recommender persistence.
	 *
	 * @return the r d c recommender persistence
	 */
	public RDCRecommenderPersistence getRDCRecommenderPersistence() {
		return rdcRecommenderPersistence;
	}

	/**
	 * Sets the r d c recommender persistence.
	 *
	 * @param rdcRecommenderPersistence the r d c recommender persistence
	 */
	public void setRDCRecommenderPersistence(
		RDCRecommenderPersistence rdcRecommenderPersistence) {
		this.rdcRecommenderPersistence = rdcRecommenderPersistence;
	}

	/**
	 * Returns the search index local service.
	 *
	 * @return the search index local service
	 */
	public at.meduni.liferay.portlet.rdconnect.service.SearchIndexLocalService getSearchIndexLocalService() {
		return searchIndexLocalService;
	}

	/**
	 * Sets the search index local service.
	 *
	 * @param searchIndexLocalService the search index local service
	 */
	public void setSearchIndexLocalService(
		at.meduni.liferay.portlet.rdconnect.service.SearchIndexLocalService searchIndexLocalService) {
		this.searchIndexLocalService = searchIndexLocalService;
	}

	/**
	 * Returns the search index persistence.
	 *
	 * @return the search index persistence
	 */
	public SearchIndexPersistence getSearchIndexPersistence() {
		return searchIndexPersistence;
	}

	/**
	 * Sets the search index persistence.
	 *
	 * @param searchIndexPersistence the search index persistence
	 */
	public void setSearchIndexPersistence(
		SearchIndexPersistence searchIndexPersistence) {
		this.searchIndexPersistence = searchIndexPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("at.meduni.liferay.portlet.rdconnect.model.SearchIndex",
			searchIndexLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"at.meduni.liferay.portlet.rdconnect.model.SearchIndex");
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
		return SearchIndex.class;
	}

	protected String getModelClassName() {
		return SearchIndex.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = searchIndexPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = at.meduni.liferay.portlet.rdconnect.service.AQRRatingLocalService.class)
	protected at.meduni.liferay.portlet.rdconnect.service.AQRRatingLocalService aqrRatingLocalService;
	@BeanReference(type = AQRRatingPersistence.class)
	protected AQRRatingPersistence aqrRatingPersistence;
	@BeanReference(type = at.meduni.liferay.portlet.rdconnect.service.CandidateLocalService.class)
	protected at.meduni.liferay.portlet.rdconnect.service.CandidateLocalService candidateLocalService;
	@BeanReference(type = CandidatePersistence.class)
	protected CandidatePersistence candidatePersistence;
	@BeanReference(type = at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLocalService.class)
	protected at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLocalService masterCandidateLocalService;
	@BeanReference(type = MasterCandidatePersistence.class)
	protected MasterCandidatePersistence masterCandidatePersistence;
	@BeanReference(type = at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLinkCandidateLocalService.class)
	protected at.meduni.liferay.portlet.rdconnect.service.MasterCandidateLinkCandidateLocalService masterCandidateLinkCandidateLocalService;
	@BeanReference(type = MasterCandidateLinkCandidatePersistence.class)
	protected MasterCandidateLinkCandidatePersistence masterCandidateLinkCandidatePersistence;
	@BeanReference(type = at.meduni.liferay.portlet.rdconnect.service.RDCOrganizationUserAccessLocalService.class)
	protected at.meduni.liferay.portlet.rdconnect.service.RDCOrganizationUserAccessLocalService rdcOrganizationUserAccessLocalService;
	@BeanReference(type = RDCOrganizationUserAccessPersistence.class)
	protected RDCOrganizationUserAccessPersistence rdcOrganizationUserAccessPersistence;
	@BeanReference(type = at.meduni.liferay.portlet.rdconnect.service.RDCRecommenderLocalService.class)
	protected at.meduni.liferay.portlet.rdconnect.service.RDCRecommenderLocalService rdcRecommenderLocalService;
	@BeanReference(type = RDCRecommenderPersistence.class)
	protected RDCRecommenderPersistence rdcRecommenderPersistence;
	@BeanReference(type = at.meduni.liferay.portlet.rdconnect.service.SearchIndexLocalService.class)
	protected at.meduni.liferay.portlet.rdconnect.service.SearchIndexLocalService searchIndexLocalService;
	@BeanReference(type = SearchIndexPersistence.class)
	protected SearchIndexPersistence searchIndexPersistence;
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
	private SearchIndexLocalServiceClpInvoker _clpInvoker = new SearchIndexLocalServiceClpInvoker();
}