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

package at.meduni.graz.patho.haybaeck.service.persistence;

import at.meduni.graz.patho.haybaeck.NoSuchSampleException;
import at.meduni.graz.patho.haybaeck.model.Sample;
import at.meduni.graz.patho.haybaeck.model.impl.SampleImpl;
import at.meduni.graz.patho.haybaeck.model.impl.SampleModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the sample service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see SamplePersistence
 * @see SampleUtil
 * @generated
 */
public class SamplePersistenceImpl extends BasePersistenceImpl<Sample>
	implements SamplePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SampleUtil} to access the sample persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SampleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SampleModelImpl.ENTITY_CACHE_ENABLED,
			SampleModelImpl.FINDER_CACHE_ENABLED, SampleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SampleModelImpl.ENTITY_CACHE_ENABLED,
			SampleModelImpl.FINDER_CACHE_ENABLED, SampleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SampleModelImpl.ENTITY_CACHE_ENABLED,
			SampleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SamplePersistenceImpl() {
		setModelClass(Sample.class);
	}

	/**
	 * Caches the sample in the entity cache if it is enabled.
	 *
	 * @param sample the sample
	 */
	@Override
	public void cacheResult(Sample sample) {
		EntityCacheUtil.putResult(SampleModelImpl.ENTITY_CACHE_ENABLED,
			SampleImpl.class, sample.getPrimaryKey(), sample);

		sample.resetOriginalValues();
	}

	/**
	 * Caches the samples in the entity cache if it is enabled.
	 *
	 * @param samples the samples
	 */
	@Override
	public void cacheResult(List<Sample> samples) {
		for (Sample sample : samples) {
			if (EntityCacheUtil.getResult(
						SampleModelImpl.ENTITY_CACHE_ENABLED, SampleImpl.class,
						sample.getPrimaryKey()) == null) {
				cacheResult(sample);
			}
			else {
				sample.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all samples.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SampleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SampleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sample.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Sample sample) {
		EntityCacheUtil.removeResult(SampleModelImpl.ENTITY_CACHE_ENABLED,
			SampleImpl.class, sample.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Sample> samples) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Sample sample : samples) {
			EntityCacheUtil.removeResult(SampleModelImpl.ENTITY_CACHE_ENABLED,
				SampleImpl.class, sample.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sample with the primary key. Does not add the sample to the database.
	 *
	 * @param sample_Id the primary key for the new sample
	 * @return the new sample
	 */
	@Override
	public Sample create(long sample_Id) {
		Sample sample = new SampleImpl();

		sample.setNew(true);
		sample.setPrimaryKey(sample_Id);

		return sample;
	}

	/**
	 * Removes the sample with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sample_Id the primary key of the sample
	 * @return the sample that was removed
	 * @throws at.meduni.graz.patho.haybaeck.NoSuchSampleException if a sample with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sample remove(long sample_Id)
		throws NoSuchSampleException, SystemException {
		return remove((Serializable)sample_Id);
	}

	/**
	 * Removes the sample with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sample
	 * @return the sample that was removed
	 * @throws at.meduni.graz.patho.haybaeck.NoSuchSampleException if a sample with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sample remove(Serializable primaryKey)
		throws NoSuchSampleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Sample sample = (Sample)session.get(SampleImpl.class, primaryKey);

			if (sample == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSampleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sample);
		}
		catch (NoSuchSampleException nsee) {
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
	protected Sample removeImpl(Sample sample) throws SystemException {
		sample = toUnwrappedModel(sample);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sample)) {
				sample = (Sample)session.get(SampleImpl.class,
						sample.getPrimaryKeyObj());
			}

			if (sample != null) {
				session.delete(sample);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sample != null) {
			clearCache(sample);
		}

		return sample;
	}

	@Override
	public Sample updateImpl(at.meduni.graz.patho.haybaeck.model.Sample sample)
		throws SystemException {
		sample = toUnwrappedModel(sample);

		boolean isNew = sample.isNew();

		Session session = null;

		try {
			session = openSession();

			if (sample.isNew()) {
				session.save(sample);

				sample.setNew(false);
			}
			else {
				session.merge(sample);
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

		EntityCacheUtil.putResult(SampleModelImpl.ENTITY_CACHE_ENABLED,
			SampleImpl.class, sample.getPrimaryKey(), sample);

		return sample;
	}

	protected Sample toUnwrappedModel(Sample sample) {
		if (sample instanceof SampleImpl) {
			return sample;
		}

		SampleImpl sampleImpl = new SampleImpl();

		sampleImpl.setNew(sample.isNew());
		sampleImpl.setPrimaryKey(sample.getPrimaryKey());

		sampleImpl.setSample_Id(sample.getSample_Id());
		sampleImpl.setPatient_id(sample.getPatient_id());
		sampleImpl.setT(sample.getT());
		sampleImpl.setN(sample.getN());
		sampleImpl.setM(sample.getM());
		sampleImpl.setG(sample.getG());
		sampleImpl.setR(sample.getR());
		sampleImpl.setP(sample.getP());
		sampleImpl.setL(sample.getL());
		sampleImpl.setV(sample.getV());
		sampleImpl.setStage(sample.getStage());
		sampleImpl.setOperation(sample.getOperation());
		sampleImpl.setPost_op_treatment(sample.getPost_op_treatment());
		sampleImpl.setRecurrence(sample.isRecurrence());
		sampleImpl.setRecurrence_date(sample.getRecurrence_date());
		sampleImpl.setDead_live(sample.getDead_live());
		sampleImpl.setLast_follow_up_date(sample.getLast_follow_up_date());
		sampleImpl.setHospital(sample.getHospital());
		sampleImpl.setTnm_staging(sample.getTnm_staging());
		sampleImpl.setDiagnosis(sample.getDiagnosis());
		sampleImpl.setOperation_date(sample.getOperation_date());
		sampleImpl.setTmp_identifier(sample.getTmp_identifier());

		return sampleImpl;
	}

	/**
	 * Returns the sample with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sample
	 * @return the sample
	 * @throws at.meduni.graz.patho.haybaeck.NoSuchSampleException if a sample with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sample findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSampleException, SystemException {
		Sample sample = fetchByPrimaryKey(primaryKey);

		if (sample == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSampleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sample;
	}

	/**
	 * Returns the sample with the primary key or throws a {@link at.meduni.graz.patho.haybaeck.NoSuchSampleException} if it could not be found.
	 *
	 * @param sample_Id the primary key of the sample
	 * @return the sample
	 * @throws at.meduni.graz.patho.haybaeck.NoSuchSampleException if a sample with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sample findByPrimaryKey(long sample_Id)
		throws NoSuchSampleException, SystemException {
		return findByPrimaryKey((Serializable)sample_Id);
	}

	/**
	 * Returns the sample with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sample
	 * @return the sample, or <code>null</code> if a sample with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sample fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Sample sample = (Sample)EntityCacheUtil.getResult(SampleModelImpl.ENTITY_CACHE_ENABLED,
				SampleImpl.class, primaryKey);

		if (sample == _nullSample) {
			return null;
		}

		if (sample == null) {
			Session session = null;

			try {
				session = openSession();

				sample = (Sample)session.get(SampleImpl.class, primaryKey);

				if (sample != null) {
					cacheResult(sample);
				}
				else {
					EntityCacheUtil.putResult(SampleModelImpl.ENTITY_CACHE_ENABLED,
						SampleImpl.class, primaryKey, _nullSample);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SampleModelImpl.ENTITY_CACHE_ENABLED,
					SampleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sample;
	}

	/**
	 * Returns the sample with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sample_Id the primary key of the sample
	 * @return the sample, or <code>null</code> if a sample with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sample fetchByPrimaryKey(long sample_Id) throws SystemException {
		return fetchByPrimaryKey((Serializable)sample_Id);
	}

	/**
	 * Returns all the samples.
	 *
	 * @return the samples
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sample> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the samples.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.graz.patho.haybaeck.model.impl.SampleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of samples
	 * @param end the upper bound of the range of samples (not inclusive)
	 * @return the range of samples
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sample> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the samples.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.graz.patho.haybaeck.model.impl.SampleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of samples
	 * @param end the upper bound of the range of samples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of samples
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sample> findAll(int start, int end,
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

		List<Sample> list = (List<Sample>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SAMPLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SAMPLE;

				if (pagination) {
					sql = sql.concat(SampleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Sample>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Sample>(list);
				}
				else {
					list = (List<Sample>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the samples from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Sample sample : findAll()) {
			remove(sample);
		}
	}

	/**
	 * Returns the number of samples.
	 *
	 * @return the number of samples
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

				Query q = session.createQuery(_SQL_COUNT_SAMPLE);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the sample persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.graz.patho.haybaeck.model.Sample")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Sample>> listenersList = new ArrayList<ModelListener<Sample>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Sample>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SampleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SAMPLE = "SELECT sample FROM Sample sample";
	private static final String _SQL_COUNT_SAMPLE = "SELECT COUNT(sample) FROM Sample sample";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sample.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Sample exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SamplePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"sample_Id"
			});
	private static Sample _nullSample = new SampleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Sample> toCacheModel() {
				return _nullSampleCacheModel;
			}
		};

	private static CacheModel<Sample> _nullSampleCacheModel = new CacheModel<Sample>() {
			@Override
			public Sample toEntityModel() {
				return _nullSample;
			}
		};
}