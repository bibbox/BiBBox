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

import at.meduni.graz.patho.haybaeck.NoSuchTMAException;
import at.meduni.graz.patho.haybaeck.model.TMA;
import at.meduni.graz.patho.haybaeck.model.impl.TMAImpl;
import at.meduni.graz.patho.haybaeck.model.impl.TMAModelImpl;

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
 * The persistence implementation for the t m a service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see TMAPersistence
 * @see TMAUtil
 * @generated
 */
public class TMAPersistenceImpl extends BasePersistenceImpl<TMA>
	implements TMAPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TMAUtil} to access the t m a persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TMAImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TMAModelImpl.ENTITY_CACHE_ENABLED,
			TMAModelImpl.FINDER_CACHE_ENABLED, TMAImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TMAModelImpl.ENTITY_CACHE_ENABLED,
			TMAModelImpl.FINDER_CACHE_ENABLED, TMAImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TMAModelImpl.ENTITY_CACHE_ENABLED,
			TMAModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TMAPersistenceImpl() {
		setModelClass(TMA.class);
	}

	/**
	 * Caches the t m a in the entity cache if it is enabled.
	 *
	 * @param tma the t m a
	 */
	@Override
	public void cacheResult(TMA tma) {
		EntityCacheUtil.putResult(TMAModelImpl.ENTITY_CACHE_ENABLED,
			TMAImpl.class, tma.getPrimaryKey(), tma);

		tma.resetOriginalValues();
	}

	/**
	 * Caches the t m as in the entity cache if it is enabled.
	 *
	 * @param tmas the t m as
	 */
	@Override
	public void cacheResult(List<TMA> tmas) {
		for (TMA tma : tmas) {
			if (EntityCacheUtil.getResult(TMAModelImpl.ENTITY_CACHE_ENABLED,
						TMAImpl.class, tma.getPrimaryKey()) == null) {
				cacheResult(tma);
			}
			else {
				tma.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all t m as.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TMAImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TMAImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the t m a.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TMA tma) {
		EntityCacheUtil.removeResult(TMAModelImpl.ENTITY_CACHE_ENABLED,
			TMAImpl.class, tma.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TMA> tmas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TMA tma : tmas) {
			EntityCacheUtil.removeResult(TMAModelImpl.ENTITY_CACHE_ENABLED,
				TMAImpl.class, tma.getPrimaryKey());
		}
	}

	/**
	 * Creates a new t m a with the primary key. Does not add the t m a to the database.
	 *
	 * @param tma_Id the primary key for the new t m a
	 * @return the new t m a
	 */
	@Override
	public TMA create(long tma_Id) {
		TMA tma = new TMAImpl();

		tma.setNew(true);
		tma.setPrimaryKey(tma_Id);

		return tma;
	}

	/**
	 * Removes the t m a with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tma_Id the primary key of the t m a
	 * @return the t m a that was removed
	 * @throws at.meduni.graz.patho.haybaeck.NoSuchTMAException if a t m a with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMA remove(long tma_Id) throws NoSuchTMAException, SystemException {
		return remove((Serializable)tma_Id);
	}

	/**
	 * Removes the t m a with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the t m a
	 * @return the t m a that was removed
	 * @throws at.meduni.graz.patho.haybaeck.NoSuchTMAException if a t m a with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMA remove(Serializable primaryKey)
		throws NoSuchTMAException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TMA tma = (TMA)session.get(TMAImpl.class, primaryKey);

			if (tma == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTMAException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tma);
		}
		catch (NoSuchTMAException nsee) {
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
	protected TMA removeImpl(TMA tma) throws SystemException {
		tma = toUnwrappedModel(tma);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tma)) {
				tma = (TMA)session.get(TMAImpl.class, tma.getPrimaryKeyObj());
			}

			if (tma != null) {
				session.delete(tma);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tma != null) {
			clearCache(tma);
		}

		return tma;
	}

	@Override
	public TMA updateImpl(at.meduni.graz.patho.haybaeck.model.TMA tma)
		throws SystemException {
		tma = toUnwrappedModel(tma);

		boolean isNew = tma.isNew();

		Session session = null;

		try {
			session = openSession();

			if (tma.isNew()) {
				session.save(tma);

				tma.setNew(false);
			}
			else {
				session.merge(tma);
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

		EntityCacheUtil.putResult(TMAModelImpl.ENTITY_CACHE_ENABLED,
			TMAImpl.class, tma.getPrimaryKey(), tma);

		return tma;
	}

	protected TMA toUnwrappedModel(TMA tma) {
		if (tma instanceof TMAImpl) {
			return tma;
		}

		TMAImpl tmaImpl = new TMAImpl();

		tmaImpl.setNew(tma.isNew());
		tmaImpl.setPrimaryKey(tma.getPrimaryKey());

		tmaImpl.setTma_Id(tma.getTma_Id());
		tmaImpl.setSample_id(tma.getSample_id());
		tmaImpl.setTma_name(tma.getTma_name());
		tmaImpl.setTma_number(tma.getTma_number());
		tmaImpl.setTma_comment(tma.getTma_comment());
		tmaImpl.setCytoplasmic_stat_5_intensity(tma.getCytoplasmic_stat_5_intensity());
		tmaImpl.setCytoplasmic_stat_5_density(tma.getCytoplasmic_stat_5_density());
		tmaImpl.setNuclear_stat_5_intensity(tma.getNuclear_stat_5_intensity());
		tmaImpl.setNuclear_stat_5_density(tma.getNuclear_stat_5_density());
		tmaImpl.setCytoplasmic_cjun_intensity(tma.getCytoplasmic_cjun_intensity());
		tmaImpl.setCytoplasmic_cjun_density(tma.getCytoplasmic_cjun_density());
		tmaImpl.setNuclear_cjun_intensity(tma.getNuclear_cjun_intensity());
		tmaImpl.setNuclear_cjun_density(tma.getNuclear_cjun_density());
		tmaImpl.setCytoplasmic_pstat_3_intensity(tma.getCytoplasmic_pstat_3_intensity());
		tmaImpl.setCytoplasmic_pstat_3_density(tma.getCytoplasmic_pstat_3_density());
		tmaImpl.setNuclear_pstat_3_intensity(tma.getNuclear_pstat_3_intensity());
		tmaImpl.setNuclear_pstat_3_density(tma.getNuclear_pstat_3_density());
		tmaImpl.setCytoplasmic_pstat_5_intensity(tma.getCytoplasmic_pstat_5_intensity());
		tmaImpl.setCytoplasmic_pstat_5_density(tma.getCytoplasmic_pstat_5_density());
		tmaImpl.setNuclear_pstat_5_intensity(tma.getNuclear_pstat_5_intensity());
		tmaImpl.setNuclear_pstat_5_density(tma.getNuclear_pstat_5_density());
		tmaImpl.setCytoplasmic_pstat_1_intensity(tma.getCytoplasmic_pstat_1_intensity());
		tmaImpl.setCytoplasmic_pstat_1_density(tma.getCytoplasmic_pstat_1_density());
		tmaImpl.setNuclear_pstat_1_intensity(tma.getNuclear_pstat_1_intensity());
		tmaImpl.setCytoplasmic_il6r_intensity(tma.getCytoplasmic_il6r_intensity());
		tmaImpl.setCytoplasmic_il6r_density(tma.getCytoplasmic_il6r_density());
		tmaImpl.setNuclear_il6r_intensity(tma.getNuclear_il6r_intensity());
		tmaImpl.setNuclear_il6r_density(tma.getNuclear_il6r_density());
		tmaImpl.setCytoplasmic_socs1_intensity(tma.getCytoplasmic_socs1_intensity());
		tmaImpl.setCytoplasmic_socs1_density(tma.getCytoplasmic_socs1_density());
		tmaImpl.setNuclear_socs1_intensity(tma.getNuclear_socs1_intensity());
		tmaImpl.setNuclear_socs1_density(tma.getNuclear_socs1_density());
		tmaImpl.setCytoplasmic_socs3_intensity(tma.getCytoplasmic_socs3_intensity());
		tmaImpl.setCytoplasmic_socs3_density(tma.getCytoplasmic_socs3_density());
		tmaImpl.setNuclear_socs3_intensity(tma.getNuclear_socs3_intensity());
		tmaImpl.setNuclear_socs3_density(tma.getNuclear_socs3_density());
		tmaImpl.setCytoplasmic_junb_intensity(tma.getCytoplasmic_junb_intensity());
		tmaImpl.setCytoplasmic_junb_density(tma.getCytoplasmic_junb_density());
		tmaImpl.setNuclear_junb_intensity(tma.getNuclear_junb_intensity());
		tmaImpl.setNuclear_junb_density(tma.getNuclear_junb_density());
		tmaImpl.setCytoplasmic_stat_3_intensity(tma.getCytoplasmic_stat_3_intensity());
		tmaImpl.setCytoplasmic_stat_3_density(tma.getCytoplasmic_stat_3_density());
		tmaImpl.setNuclear_stat_3_intensity(tma.getNuclear_stat_3_intensity());
		tmaImpl.setNuclear_stat_3_density(tma.getNuclear_stat_3_density());
		tmaImpl.setCytoplasmic_stat_5a_intensity(tma.getCytoplasmic_stat_5a_intensity());
		tmaImpl.setCytoplasmic_stat_5a_density(tma.getCytoplasmic_stat_5a_density());
		tmaImpl.setNuclear_stat_5a_intensity(tma.getNuclear_stat_5a_intensity());
		tmaImpl.setNuclear_stat_5a_density(tma.getNuclear_stat_5a_density());
		tmaImpl.setCytoplasmic_stat_5b_intensity(tma.getCytoplasmic_stat_5b_intensity());
		tmaImpl.setCytoplasmic_stat_5b_density(tma.getCytoplasmic_stat_5b_density());
		tmaImpl.setNuclear_stat_5b_intensity(tma.getNuclear_stat_5b_intensity());
		tmaImpl.setNuclear_stat_5b_density(tma.getNuclear_stat_5b_density());
		tmaImpl.setCytoplasmic_eif3a_intensity(tma.getCytoplasmic_eif3a_intensity());
		tmaImpl.setCytoplasmic_eif3a_density(tma.getCytoplasmic_eif3a_density());
		tmaImpl.setCytoplasmic_eif3a_peter_intensity(tma.getCytoplasmic_eif3a_peter_intensity());
		tmaImpl.setCytoplasmic_eif3a_peter_density(tma.getCytoplasmic_eif3a_peter_density());
		tmaImpl.setCytoplasmic_itih_5_o1_intensity(tma.getCytoplasmic_itih_5_o1_intensity());
		tmaImpl.setCytoplasmic_itih_5_o1_density(tma.getCytoplasmic_itih_5_o1_density());
		tmaImpl.setNuclear_itih_5_o1_intensity(tma.getNuclear_itih_5_o1_intensity());
		tmaImpl.setNuclear_itih_5_o1_density(tma.getNuclear_itih_5_o1_density());
		tmaImpl.setCytoplasmic_itih_5_o2_intensity(tma.getCytoplasmic_itih_5_o2_intensity());
		tmaImpl.setCytoplasmic_itih_5_o2_density(tma.getCytoplasmic_itih_5_o2_density());
		tmaImpl.setNuclear_itih_5_o2_intensity(tma.getNuclear_itih_5_o2_intensity());
		tmaImpl.setNuclear_itih_5_o2_density(tma.getNuclear_itih_5_o2_density());
		tmaImpl.setCytoplasmic_imp2_2_intensity(tma.getCytoplasmic_imp2_2_intensity());
		tmaImpl.setCytoplasmic_imp2_2_density(tma.getCytoplasmic_imp2_2_density());
		tmaImpl.setCytoplasmic_stat_1_intensity(tma.getCytoplasmic_stat_1_intensity());
		tmaImpl.setCytoplasmic_stat_1_density(tma.getCytoplasmic_stat_1_density());
		tmaImpl.setNuclear_stat_1_intensity(tma.getNuclear_stat_1_intensity());
		tmaImpl.setNuclear_stat_1_density(tma.getNuclear_stat_1_density());
		tmaImpl.setCytoplasmic_nfkb1_intensity(tma.getCytoplasmic_nfkb1_intensity());
		tmaImpl.setCytoplasmic_nfkb1_density(tma.getCytoplasmic_nfkb1_density());
		tmaImpl.setNuclear_nfkb1_intensity(tma.getNuclear_nfkb1_intensity());
		tmaImpl.setNuclear_nfkb1_density(tma.getNuclear_nfkb1_density());
		tmaImpl.setCytoplasmic_nfkb2_intensity(tma.getCytoplasmic_nfkb2_intensity());
		tmaImpl.setCytoplasmic_nfkb2_density(tma.getCytoplasmic_nfkb2_density());
		tmaImpl.setNuclear_nfkb2_intensity(tma.getNuclear_nfkb2_intensity());
		tmaImpl.setNuclear_nfkb2_density(tma.getNuclear_nfkb2_density());
		tmaImpl.setCytoplasmic_pikb_intensity(tma.getCytoplasmic_pikb_intensity());
		tmaImpl.setCytoplasmic_pikb_density(tma.getCytoplasmic_pikb_density());
		tmaImpl.setCytoplasmic_phoshpo_pakt_o1_intensity(tma.getCytoplasmic_phoshpo_pakt_o1_intensity());
		tmaImpl.setCytoplasmic_phoshpo_pakt_o1_density(tma.getCytoplasmic_phoshpo_pakt_o1_density());
		tmaImpl.setNuclear_phoshpo_pakt_o1_intensity(tma.getNuclear_phoshpo_pakt_o1_intensity());
		tmaImpl.setNuclear_phoshpo_pakt_o1_density(tma.getNuclear_phoshpo_pakt_o1_density());
		tmaImpl.setCytoplasmic_phoshpo_pakt_o2_intensity(tma.getCytoplasmic_phoshpo_pakt_o2_intensity());
		tmaImpl.setCytoplasmic_phoshpo_pakt_o2_density(tma.getCytoplasmic_phoshpo_pakt_o2_density());
		tmaImpl.setNuclear_phoshpo_pakt_o2_intensity(tma.getNuclear_phoshpo_pakt_o2_intensity());
		tmaImpl.setNuclear_phoshpo_pakt_o2_density(tma.getNuclear_phoshpo_pakt_o2_density());
		tmaImpl.setCytoplasmic_phoshpo_pmtor_o1_intensity(tma.getCytoplasmic_phoshpo_pmtor_o1_intensity());
		tmaImpl.setCytoplasmic_phoshpo_pmtor_o1_density(tma.getCytoplasmic_phoshpo_pmtor_o1_density());
		tmaImpl.setNuclear_phoshpo_pmtor_o1_intensity(tma.getNuclear_phoshpo_pmtor_o1_intensity());
		tmaImpl.setNuclear_phoshpo_pmtor_o1_density(tma.getNuclear_phoshpo_pmtor_o1_density());
		tmaImpl.setCytoplasmic_phoshpo_pmtor_o2_intensity(tma.getCytoplasmic_phoshpo_pmtor_o2_intensity());
		tmaImpl.setCytoplasmic_phoshpo_pmtor_o2_density(tma.getCytoplasmic_phoshpo_pmtor_o2_density());
		tmaImpl.setNuclear_phoshpo_pmtor_o2_intensity(tma.getNuclear_phoshpo_pmtor_o2_intensity());
		tmaImpl.setNuclear_phoshpo_pmtor_o2_density(tma.getNuclear_phoshpo_pmtor_o2_density());
		tmaImpl.setCytoplasmic_phoshpo_pp70s6k_o1_density(tma.getCytoplasmic_phoshpo_pp70s6k_o1_density());
		tmaImpl.setNuclear_phoshpo_pp70s6k_o1_intensity(tma.getNuclear_phoshpo_pp70s6k_o1_intensity());
		tmaImpl.setNuclear_phoshpo_pp70s6k_o1_density(tma.getNuclear_phoshpo_pp70s6k_o1_density());
		tmaImpl.setCytoplasmic_phoshpo_pp70s6k_o2_intensity(tma.getCytoplasmic_phoshpo_pp70s6k_o2_intensity());
		tmaImpl.setCytoplasmic_phoshpo_pp70s6k_o2_density(tma.getCytoplasmic_phoshpo_pp70s6k_o2_density());
		tmaImpl.setNuclear_phoshpo_pp70s6k_o2_intensity(tma.getNuclear_phoshpo_pp70s6k_o2_intensity());
		tmaImpl.setNuclear_phoshpo_pp70s6k_o2_density(tma.getNuclear_phoshpo_pp70s6k_o2_density());
		tmaImpl.setCytoplasmic_phoshpo_pp70s6k_o1_intensity(tma.getCytoplasmic_phoshpo_pp70s6k_o1_intensity());
		tmaImpl.setCytoplasmic_phoshpo_pten_o1_intensity(tma.getCytoplasmic_phoshpo_pten_o1_intensity());
		tmaImpl.setCytoplasmic_phoshpo_pten_o1_density(tma.getCytoplasmic_phoshpo_pten_o1_density());
		tmaImpl.setNuclear_phoshpo_pten_o1_intensity(tma.getNuclear_phoshpo_pten_o1_intensity());
		tmaImpl.setNuclear_phoshpo_pten_o1_density(tma.getNuclear_phoshpo_pten_o1_density());
		tmaImpl.setCytoplasmic_phoshpo_pten_o2_intensity(tma.getCytoplasmic_phoshpo_pten_o2_intensity());
		tmaImpl.setCytoplasmic_phoshpo_pten_o2_density(tma.getCytoplasmic_phoshpo_pten_o2_density());
		tmaImpl.setNuclear_phoshpo_pten_o2_intensity(tma.getNuclear_phoshpo_pten_o2_intensity());
		tmaImpl.setNuclear_phoshpo_pten_o2_density(tma.getNuclear_phoshpo_pten_o2_density());

		return tmaImpl;
	}

	/**
	 * Returns the t m a with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the t m a
	 * @return the t m a
	 * @throws at.meduni.graz.patho.haybaeck.NoSuchTMAException if a t m a with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMA findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTMAException, SystemException {
		TMA tma = fetchByPrimaryKey(primaryKey);

		if (tma == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTMAException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tma;
	}

	/**
	 * Returns the t m a with the primary key or throws a {@link at.meduni.graz.patho.haybaeck.NoSuchTMAException} if it could not be found.
	 *
	 * @param tma_Id the primary key of the t m a
	 * @return the t m a
	 * @throws at.meduni.graz.patho.haybaeck.NoSuchTMAException if a t m a with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMA findByPrimaryKey(long tma_Id)
		throws NoSuchTMAException, SystemException {
		return findByPrimaryKey((Serializable)tma_Id);
	}

	/**
	 * Returns the t m a with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the t m a
	 * @return the t m a, or <code>null</code> if a t m a with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMA fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TMA tma = (TMA)EntityCacheUtil.getResult(TMAModelImpl.ENTITY_CACHE_ENABLED,
				TMAImpl.class, primaryKey);

		if (tma == _nullTMA) {
			return null;
		}

		if (tma == null) {
			Session session = null;

			try {
				session = openSession();

				tma = (TMA)session.get(TMAImpl.class, primaryKey);

				if (tma != null) {
					cacheResult(tma);
				}
				else {
					EntityCacheUtil.putResult(TMAModelImpl.ENTITY_CACHE_ENABLED,
						TMAImpl.class, primaryKey, _nullTMA);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TMAModelImpl.ENTITY_CACHE_ENABLED,
					TMAImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tma;
	}

	/**
	 * Returns the t m a with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tma_Id the primary key of the t m a
	 * @return the t m a, or <code>null</code> if a t m a with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TMA fetchByPrimaryKey(long tma_Id) throws SystemException {
		return fetchByPrimaryKey((Serializable)tma_Id);
	}

	/**
	 * Returns all the t m as.
	 *
	 * @return the t m as
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TMA> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the t m as.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.graz.patho.haybaeck.model.impl.TMAModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of t m as
	 * @param end the upper bound of the range of t m as (not inclusive)
	 * @return the range of t m as
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TMA> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the t m as.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.graz.patho.haybaeck.model.impl.TMAModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of t m as
	 * @param end the upper bound of the range of t m as (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of t m as
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TMA> findAll(int start, int end,
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

		List<TMA> list = (List<TMA>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TMA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TMA;

				if (pagination) {
					sql = sql.concat(TMAModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TMA>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TMA>(list);
				}
				else {
					list = (List<TMA>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the t m as from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TMA tma : findAll()) {
			remove(tma);
		}
	}

	/**
	 * Returns the number of t m as.
	 *
	 * @return the number of t m as
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

				Query q = session.createQuery(_SQL_COUNT_TMA);

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
	 * Initializes the t m a persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.graz.patho.haybaeck.model.TMA")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TMA>> listenersList = new ArrayList<ModelListener<TMA>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TMA>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TMAImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TMA = "SELECT tma FROM TMA tma";
	private static final String _SQL_COUNT_TMA = "SELECT COUNT(tma) FROM TMA tma";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tma.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TMA exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TMAPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"tma_Id"
			});
	private static TMA _nullTMA = new TMAImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TMA> toCacheModel() {
				return _nullTMACacheModel;
			}
		};

	private static CacheModel<TMA> _nullTMACacheModel = new CacheModel<TMA>() {
			@Override
			public TMA toEntityModel() {
				return _nullTMA;
			}
		};
}