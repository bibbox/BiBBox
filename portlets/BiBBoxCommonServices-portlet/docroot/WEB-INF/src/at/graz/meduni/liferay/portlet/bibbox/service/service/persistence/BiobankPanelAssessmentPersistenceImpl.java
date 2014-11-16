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

package at.graz.meduni.liferay.portlet.bibbox.service.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException;
import at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.BiobankPanelAssessmentImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.BiobankPanelAssessmentModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the biobank panel assessment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see BiobankPanelAssessmentPersistence
 * @see BiobankPanelAssessmentUtil
 * @generated
 */
public class BiobankPanelAssessmentPersistenceImpl extends BasePersistenceImpl<BiobankPanelAssessment>
	implements BiobankPanelAssessmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BiobankPanelAssessmentUtil} to access the biobank panel assessment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BiobankPanelAssessmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BiobankPanelAssessmentModelImpl.ENTITY_CACHE_ENABLED,
			BiobankPanelAssessmentModelImpl.FINDER_CACHE_ENABLED,
			BiobankPanelAssessmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BiobankPanelAssessmentModelImpl.ENTITY_CACHE_ENABLED,
			BiobankPanelAssessmentModelImpl.FINDER_CACHE_ENABLED,
			BiobankPanelAssessmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BiobankPanelAssessmentModelImpl.ENTITY_CACHE_ENABLED,
			BiobankPanelAssessmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BiobankPanelAssessmentPersistenceImpl() {
		setModelClass(BiobankPanelAssessment.class);
	}

	/**
	 * Caches the biobank panel assessment in the entity cache if it is enabled.
	 *
	 * @param biobankPanelAssessment the biobank panel assessment
	 */
	@Override
	public void cacheResult(BiobankPanelAssessment biobankPanelAssessment) {
		EntityCacheUtil.putResult(BiobankPanelAssessmentModelImpl.ENTITY_CACHE_ENABLED,
			BiobankPanelAssessmentImpl.class,
			biobankPanelAssessment.getPrimaryKey(), biobankPanelAssessment);

		biobankPanelAssessment.resetOriginalValues();
	}

	/**
	 * Caches the biobank panel assessments in the entity cache if it is enabled.
	 *
	 * @param biobankPanelAssessments the biobank panel assessments
	 */
	@Override
	public void cacheResult(
		List<BiobankPanelAssessment> biobankPanelAssessments) {
		for (BiobankPanelAssessment biobankPanelAssessment : biobankPanelAssessments) {
			if (EntityCacheUtil.getResult(
						BiobankPanelAssessmentModelImpl.ENTITY_CACHE_ENABLED,
						BiobankPanelAssessmentImpl.class,
						biobankPanelAssessment.getPrimaryKey()) == null) {
				cacheResult(biobankPanelAssessment);
			}
			else {
				biobankPanelAssessment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all biobank panel assessments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BiobankPanelAssessmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BiobankPanelAssessmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the biobank panel assessment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BiobankPanelAssessment biobankPanelAssessment) {
		EntityCacheUtil.removeResult(BiobankPanelAssessmentModelImpl.ENTITY_CACHE_ENABLED,
			BiobankPanelAssessmentImpl.class,
			biobankPanelAssessment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BiobankPanelAssessment> biobankPanelAssessments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BiobankPanelAssessment biobankPanelAssessment : biobankPanelAssessments) {
			EntityCacheUtil.removeResult(BiobankPanelAssessmentModelImpl.ENTITY_CACHE_ENABLED,
				BiobankPanelAssessmentImpl.class,
				biobankPanelAssessment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new biobank panel assessment with the primary key. Does not add the biobank panel assessment to the database.
	 *
	 * @param biobankpanelassessmentId the primary key for the new biobank panel assessment
	 * @return the new biobank panel assessment
	 */
	@Override
	public BiobankPanelAssessment create(long biobankpanelassessmentId) {
		BiobankPanelAssessment biobankPanelAssessment = new BiobankPanelAssessmentImpl();

		biobankPanelAssessment.setNew(true);
		biobankPanelAssessment.setPrimaryKey(biobankpanelassessmentId);

		return biobankPanelAssessment;
	}

	/**
	 * Removes the biobank panel assessment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param biobankpanelassessmentId the primary key of the biobank panel assessment
	 * @return the biobank panel assessment that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException if a biobank panel assessment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankPanelAssessment remove(long biobankpanelassessmentId)
		throws NoSuchBiobankPanelAssessmentException, SystemException {
		return remove((Serializable)biobankpanelassessmentId);
	}

	/**
	 * Removes the biobank panel assessment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the biobank panel assessment
	 * @return the biobank panel assessment that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException if a biobank panel assessment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankPanelAssessment remove(Serializable primaryKey)
		throws NoSuchBiobankPanelAssessmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BiobankPanelAssessment biobankPanelAssessment = (BiobankPanelAssessment)session.get(BiobankPanelAssessmentImpl.class,
					primaryKey);

			if (biobankPanelAssessment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBiobankPanelAssessmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(biobankPanelAssessment);
		}
		catch (NoSuchBiobankPanelAssessmentException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected BiobankPanelAssessment removeImpl(
		BiobankPanelAssessment biobankPanelAssessment)
		throws SystemException {
		biobankPanelAssessment = toUnwrappedModel(biobankPanelAssessment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(biobankPanelAssessment)) {
				biobankPanelAssessment = (BiobankPanelAssessment)session.get(BiobankPanelAssessmentImpl.class,
						biobankPanelAssessment.getPrimaryKeyObj());
			}

			if (biobankPanelAssessment != null) {
				session.delete(biobankPanelAssessment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (biobankPanelAssessment != null) {
			clearCache(biobankPanelAssessment);
		}

		return biobankPanelAssessment;
	}

	@Override
	public BiobankPanelAssessment updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment biobankPanelAssessment)
		throws SystemException {
		biobankPanelAssessment = toUnwrappedModel(biobankPanelAssessment);

		boolean isNew = biobankPanelAssessment.isNew();

		Session session = null;

		try {
			session = openSession();

			if (biobankPanelAssessment.isNew()) {
				session.save(biobankPanelAssessment);

				biobankPanelAssessment.setNew(false);
			}
			else {
				session.merge(biobankPanelAssessment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(BiobankPanelAssessmentModelImpl.ENTITY_CACHE_ENABLED,
			BiobankPanelAssessmentImpl.class,
			biobankPanelAssessment.getPrimaryKey(), biobankPanelAssessment);

		return biobankPanelAssessment;
	}

	protected BiobankPanelAssessment toUnwrappedModel(
		BiobankPanelAssessment biobankPanelAssessment) {
		if (biobankPanelAssessment instanceof BiobankPanelAssessmentImpl) {
			return biobankPanelAssessment;
		}

		BiobankPanelAssessmentImpl biobankPanelAssessmentImpl = new BiobankPanelAssessmentImpl();

		biobankPanelAssessmentImpl.setNew(biobankPanelAssessment.isNew());
		biobankPanelAssessmentImpl.setPrimaryKey(biobankPanelAssessment.getPrimaryKey());

		biobankPanelAssessmentImpl.setBiobankpanelassessmentId(biobankPanelAssessment.getBiobankpanelassessmentId());
		biobankPanelAssessmentImpl.setOrganizationId(biobankPanelAssessment.getOrganizationId());
		biobankPanelAssessmentImpl.setUserId(biobankPanelAssessment.getUserId());
		biobankPanelAssessmentImpl.setDateofassessment(biobankPanelAssessment.getDateofassessment());
		biobankPanelAssessmentImpl.setBackground1_1(biobankPanelAssessment.getBackground1_1());
		biobankPanelAssessmentImpl.setBackground1_1_comments(biobankPanelAssessment.getBackground1_1_comments());
		biobankPanelAssessmentImpl.setElsi1_2(biobankPanelAssessment.getElsi1_2());
		biobankPanelAssessmentImpl.setQuality1_3(biobankPanelAssessment.getQuality1_3());
		biobankPanelAssessmentImpl.setQuality1_3_comments(biobankPanelAssessment.getQuality1_3_comments());
		biobankPanelAssessmentImpl.setCataloguemeetpurposes2_1(biobankPanelAssessment.getCataloguemeetpurposes2_1());
		biobankPanelAssessmentImpl.setAdequateitplatform2_2(biobankPanelAssessment.getAdequateitplatform2_2());
		biobankPanelAssessmentImpl.setAddedvaluecatalogue2_3(biobankPanelAssessment.getAddedvaluecatalogue2_3());
		biobankPanelAssessmentImpl.setAssociateddata2_4(biobankPanelAssessment.getAssociateddata2_4());
		biobankPanelAssessmentImpl.setAssociateddata2_4_comments(biobankPanelAssessment.getAssociateddata2_4_comments());
		biobankPanelAssessmentImpl.setReasonstoaccept3_1(biobankPanelAssessment.getReasonstoaccept3_1());
		biobankPanelAssessmentImpl.setRecommendation3_2(biobankPanelAssessment.getRecommendation3_2());
		biobankPanelAssessmentImpl.setNeedadditionalinformation3_3(biobankPanelAssessment.getNeedadditionalinformation3_3());
		biobankPanelAssessmentImpl.setFinalrecommendation_4(biobankPanelAssessment.getFinalrecommendation_4());

		return biobankPanelAssessmentImpl;
	}

	/**
	 * Returns the biobank panel assessment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the biobank panel assessment
	 * @return the biobank panel assessment
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException if a biobank panel assessment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankPanelAssessment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBiobankPanelAssessmentException, SystemException {
		BiobankPanelAssessment biobankPanelAssessment = fetchByPrimaryKey(primaryKey);

		if (biobankPanelAssessment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBiobankPanelAssessmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return biobankPanelAssessment;
	}

	/**
	 * Returns the biobank panel assessment with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException} if it could not be found.
	 *
	 * @param biobankpanelassessmentId the primary key of the biobank panel assessment
	 * @return the biobank panel assessment
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException if a biobank panel assessment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankPanelAssessment findByPrimaryKey(
		long biobankpanelassessmentId)
		throws NoSuchBiobankPanelAssessmentException, SystemException {
		return findByPrimaryKey((Serializable)biobankpanelassessmentId);
	}

	/**
	 * Returns the biobank panel assessment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the biobank panel assessment
	 * @return the biobank panel assessment, or <code>null</code> if a biobank panel assessment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankPanelAssessment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BiobankPanelAssessment biobankPanelAssessment = (BiobankPanelAssessment)EntityCacheUtil.getResult(BiobankPanelAssessmentModelImpl.ENTITY_CACHE_ENABLED,
				BiobankPanelAssessmentImpl.class, primaryKey);

		if (biobankPanelAssessment == _nullBiobankPanelAssessment) {
			return null;
		}

		if (biobankPanelAssessment == null) {
			Session session = null;

			try {
				session = openSession();

				biobankPanelAssessment = (BiobankPanelAssessment)session.get(BiobankPanelAssessmentImpl.class,
						primaryKey);

				if (biobankPanelAssessment != null) {
					cacheResult(biobankPanelAssessment);
				}
				else {
					EntityCacheUtil.putResult(BiobankPanelAssessmentModelImpl.ENTITY_CACHE_ENABLED,
						BiobankPanelAssessmentImpl.class, primaryKey,
						_nullBiobankPanelAssessment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BiobankPanelAssessmentModelImpl.ENTITY_CACHE_ENABLED,
					BiobankPanelAssessmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return biobankPanelAssessment;
	}

	/**
	 * Returns the biobank panel assessment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param biobankpanelassessmentId the primary key of the biobank panel assessment
	 * @return the biobank panel assessment, or <code>null</code> if a biobank panel assessment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankPanelAssessment fetchByPrimaryKey(
		long biobankpanelassessmentId) throws SystemException {
		return fetchByPrimaryKey((Serializable)biobankpanelassessmentId);
	}

	/**
	 * Returns all the biobank panel assessments.
	 *
	 * @return the biobank panel assessments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankPanelAssessment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the biobank panel assessments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.BiobankPanelAssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of biobank panel assessments
	 * @param end the upper bound of the range of biobank panel assessments (not inclusive)
	 * @return the range of biobank panel assessments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankPanelAssessment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the biobank panel assessments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.BiobankPanelAssessmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of biobank panel assessments
	 * @param end the upper bound of the range of biobank panel assessments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of biobank panel assessments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankPanelAssessment> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<BiobankPanelAssessment> list = (List<BiobankPanelAssessment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BIOBANKPANELASSESSMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BIOBANKPANELASSESSMENT;

				if (pagination) {
					sql = sql.concat(BiobankPanelAssessmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BiobankPanelAssessment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BiobankPanelAssessment>(list);
				}
				else {
					list = (List<BiobankPanelAssessment>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the biobank panel assessments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BiobankPanelAssessment biobankPanelAssessment : findAll()) {
			remove(biobankPanelAssessment);
		}
	}

	/**
	 * Returns the number of biobank panel assessments.
	 *
	 * @return the number of biobank panel assessments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BIOBANKPANELASSESSMENT);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the biobank panel assessment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BiobankPanelAssessment>> listenersList = new ArrayList<ModelListener<BiobankPanelAssessment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BiobankPanelAssessment>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(BiobankPanelAssessmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BIOBANKPANELASSESSMENT = "SELECT biobankPanelAssessment FROM BiobankPanelAssessment biobankPanelAssessment";
	private static final String _SQL_COUNT_BIOBANKPANELASSESSMENT = "SELECT COUNT(biobankPanelAssessment) FROM BiobankPanelAssessment biobankPanelAssessment";
	private static final String _ORDER_BY_ENTITY_ALIAS = "biobankPanelAssessment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BiobankPanelAssessment exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BiobankPanelAssessmentPersistenceImpl.class);
	private static BiobankPanelAssessment _nullBiobankPanelAssessment = new BiobankPanelAssessmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BiobankPanelAssessment> toCacheModel() {
				return _nullBiobankPanelAssessmentCacheModel;
			}
		};

	private static CacheModel<BiobankPanelAssessment> _nullBiobankPanelAssessmentCacheModel =
		new CacheModel<BiobankPanelAssessment>() {
			@Override
			public BiobankPanelAssessment toEntityModel() {
				return _nullBiobankPanelAssessment;
			}
		};
}