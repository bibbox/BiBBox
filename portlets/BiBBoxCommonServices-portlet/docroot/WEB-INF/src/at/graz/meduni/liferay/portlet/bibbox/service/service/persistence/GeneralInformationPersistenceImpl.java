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

import at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException;
import at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.GeneralInformationImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.GeneralInformationModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
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
 * The persistence implementation for the general information service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see GeneralInformationPersistence
 * @see GeneralInformationUtil
 * @generated
 */
public class GeneralInformationPersistenceImpl extends BasePersistenceImpl<GeneralInformation>
	implements GeneralInformationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GeneralInformationUtil} to access the general information persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GeneralInformationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
			GeneralInformationModelImpl.FINDER_CACHE_ENABLED,
			GeneralInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
			GeneralInformationModelImpl.FINDER_CACHE_ENABLED,
			GeneralInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
			GeneralInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ORGANIZATIONFINDER = new FinderPath(GeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
			GeneralInformationModelImpl.FINDER_CACHE_ENABLED,
			GeneralInformationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByOrganizationFinder", new String[] { Long.class.getName() },
			GeneralInformationModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATIONFINDER = new FinderPath(GeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
			GeneralInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOrganizationFinder", new String[] { Long.class.getName() });

	/**
	 * Returns the general information where organizationId = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException} if it could not be found.
	 *
	 * @param organizationId the organization ID
	 * @return the matching general information
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException if a matching general information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralInformation findByOrganizationFinder(long organizationId)
		throws NoSuchGeneralInformationException, SystemException {
		GeneralInformation generalInformation = fetchByOrganizationFinder(organizationId);

		if (generalInformation == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("organizationId=");
			msg.append(organizationId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchGeneralInformationException(msg.toString());
		}

		return generalInformation;
	}

	/**
	 * Returns the general information where organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @return the matching general information, or <code>null</code> if a matching general information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralInformation fetchByOrganizationFinder(long organizationId)
		throws SystemException {
		return fetchByOrganizationFinder(organizationId, true);
	}

	/**
	 * Returns the general information where organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching general information, or <code>null</code> if a matching general information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralInformation fetchByOrganizationFinder(long organizationId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { organizationId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ORGANIZATIONFINDER,
					finderArgs, this);
		}

		if (result instanceof GeneralInformation) {
			GeneralInformation generalInformation = (GeneralInformation)result;

			if ((organizationId != generalInformation.getOrganizationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_GENERALINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONFINDER_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				List<GeneralInformation> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORGANIZATIONFINDER,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"GeneralInformationPersistenceImpl.fetchByOrganizationFinder(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					GeneralInformation generalInformation = list.get(0);

					result = generalInformation;

					cacheResult(generalInformation);

					if ((generalInformation.getOrganizationId() != organizationId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORGANIZATIONFINDER,
							finderArgs, generalInformation);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ORGANIZATIONFINDER,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (GeneralInformation)result;
		}
	}

	/**
	 * Removes the general information where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @return the general information that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralInformation removeByOrganizationFinder(long organizationId)
		throws NoSuchGeneralInformationException, SystemException {
		GeneralInformation generalInformation = findByOrganizationFinder(organizationId);

		return remove(generalInformation);
	}

	/**
	 * Returns the number of general informations where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching general informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganizationFinder(long organizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATIONFINDER;

		Object[] finderArgs = new Object[] { organizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GENERALINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATIONFINDER_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ORGANIZATIONFINDER_ORGANIZATIONID_2 =
		"generalInformation.organizationId = ?";

	public GeneralInformationPersistenceImpl() {
		setModelClass(GeneralInformation.class);
	}

	/**
	 * Caches the general information in the entity cache if it is enabled.
	 *
	 * @param generalInformation the general information
	 */
	@Override
	public void cacheResult(GeneralInformation generalInformation) {
		EntityCacheUtil.putResult(GeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
			GeneralInformationImpl.class, generalInformation.getPrimaryKey(),
			generalInformation);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORGANIZATIONFINDER,
			new Object[] { generalInformation.getOrganizationId() },
			generalInformation);

		generalInformation.resetOriginalValues();
	}

	/**
	 * Caches the general informations in the entity cache if it is enabled.
	 *
	 * @param generalInformations the general informations
	 */
	@Override
	public void cacheResult(List<GeneralInformation> generalInformations) {
		for (GeneralInformation generalInformation : generalInformations) {
			if (EntityCacheUtil.getResult(
						GeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
						GeneralInformationImpl.class,
						generalInformation.getPrimaryKey()) == null) {
				cacheResult(generalInformation);
			}
			else {
				generalInformation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all general informations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GeneralInformationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GeneralInformationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the general information.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GeneralInformation generalInformation) {
		EntityCacheUtil.removeResult(GeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
			GeneralInformationImpl.class, generalInformation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(generalInformation);
	}

	@Override
	public void clearCache(List<GeneralInformation> generalInformations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GeneralInformation generalInformation : generalInformations) {
			EntityCacheUtil.removeResult(GeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
				GeneralInformationImpl.class, generalInformation.getPrimaryKey());

			clearUniqueFindersCache(generalInformation);
		}
	}

	protected void cacheUniqueFindersCache(
		GeneralInformation generalInformation) {
		if (generalInformation.isNew()) {
			Object[] args = new Object[] { generalInformation.getOrganizationId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGANIZATIONFINDER,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORGANIZATIONFINDER,
				args, generalInformation);
		}
		else {
			GeneralInformationModelImpl generalInformationModelImpl = (GeneralInformationModelImpl)generalInformation;

			if ((generalInformationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ORGANIZATIONFINDER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						generalInformation.getOrganizationId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGANIZATIONFINDER,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORGANIZATIONFINDER,
					args, generalInformation);
			}
		}
	}

	protected void clearUniqueFindersCache(
		GeneralInformation generalInformation) {
		GeneralInformationModelImpl generalInformationModelImpl = (GeneralInformationModelImpl)generalInformation;

		Object[] args = new Object[] { generalInformation.getOrganizationId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONFINDER,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ORGANIZATIONFINDER,
			args);

		if ((generalInformationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ORGANIZATIONFINDER.getColumnBitmask()) != 0) {
			args = new Object[] {
					generalInformationModelImpl.getOriginalOrganizationId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATIONFINDER,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ORGANIZATIONFINDER,
				args);
		}
	}

	/**
	 * Creates a new general information with the primary key. Does not add the general information to the database.
	 *
	 * @param generalinformationId the primary key for the new general information
	 * @return the new general information
	 */
	@Override
	public GeneralInformation create(long generalinformationId) {
		GeneralInformation generalInformation = new GeneralInformationImpl();

		generalInformation.setNew(true);
		generalInformation.setPrimaryKey(generalinformationId);

		return generalInformation;
	}

	/**
	 * Removes the general information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param generalinformationId the primary key of the general information
	 * @return the general information that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException if a general information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralInformation remove(long generalinformationId)
		throws NoSuchGeneralInformationException, SystemException {
		return remove((Serializable)generalinformationId);
	}

	/**
	 * Removes the general information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the general information
	 * @return the general information that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException if a general information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralInformation remove(Serializable primaryKey)
		throws NoSuchGeneralInformationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GeneralInformation generalInformation = (GeneralInformation)session.get(GeneralInformationImpl.class,
					primaryKey);

			if (generalInformation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGeneralInformationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(generalInformation);
		}
		catch (NoSuchGeneralInformationException nsee) {
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
	protected GeneralInformation removeImpl(
		GeneralInformation generalInformation) throws SystemException {
		generalInformation = toUnwrappedModel(generalInformation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(generalInformation)) {
				generalInformation = (GeneralInformation)session.get(GeneralInformationImpl.class,
						generalInformation.getPrimaryKeyObj());
			}

			if (generalInformation != null) {
				session.delete(generalInformation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (generalInformation != null) {
			clearCache(generalInformation);
		}

		return generalInformation;
	}

	@Override
	public GeneralInformation updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation generalInformation)
		throws SystemException {
		generalInformation = toUnwrappedModel(generalInformation);

		boolean isNew = generalInformation.isNew();

		Session session = null;

		try {
			session = openSession();

			if (generalInformation.isNew()) {
				session.save(generalInformation);

				generalInformation.setNew(false);
			}
			else {
				session.merge(generalInformation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GeneralInformationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(GeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
			GeneralInformationImpl.class, generalInformation.getPrimaryKey(),
			generalInformation);

		clearUniqueFindersCache(generalInformation);
		cacheUniqueFindersCache(generalInformation);

		return generalInformation;
	}

	protected GeneralInformation toUnwrappedModel(
		GeneralInformation generalInformation) {
		if (generalInformation instanceof GeneralInformationImpl) {
			return generalInformation;
		}

		GeneralInformationImpl generalInformationImpl = new GeneralInformationImpl();

		generalInformationImpl.setNew(generalInformation.isNew());
		generalInformationImpl.setPrimaryKey(generalInformation.getPrimaryKey());

		generalInformationImpl.setGeneralinformationId(generalInformation.getGeneralinformationId());
		generalInformationImpl.setOrganizationId(generalInformation.getOrganizationId());
		generalInformationImpl.setAcronym(generalInformation.getAcronym());
		generalInformationImpl.setDescription(generalInformation.getDescription());
		generalInformationImpl.setHosteinstitue(generalInformation.getHosteinstitue());
		generalInformationImpl.setTypeofhosteinstitue(generalInformation.getTypeofhosteinstitue());
		generalInformationImpl.setSourceoffunding(generalInformation.getSourceoffunding());
		generalInformationImpl.setCountry(generalInformation.getCountry());
		generalInformationImpl.setTargetpopulation(generalInformation.getTargetpopulation());
		generalInformationImpl.setYearofestablishment(generalInformation.getYearofestablishment());
		generalInformationImpl.setHowmanyrdsareintheregistrybiobank(generalInformation.getHowmanyrdsareintheregistrybiobank());
		generalInformationImpl.setPercentageofrarediseasesinyourregistrybiobank(generalInformation.getPercentageofrarediseasesinyourregistrybiobank());
		generalInformationImpl.setOntologies(generalInformation.getOntologies());
		generalInformationImpl.setBiomaterialcollected(generalInformation.getBiomaterialcollected());
		generalInformationImpl.setBiomaterialprepared(generalInformation.getBiomaterialprepared());
		generalInformationImpl.setOrigionofcollection(generalInformation.getOrigionofcollection());
		generalInformationImpl.setUseofcollection(generalInformation.getUseofcollection());
		generalInformationImpl.setAssociateddataavailable(generalInformation.getAssociateddataavailable());
		generalInformationImpl.setImagingavailable(generalInformation.getImagingavailable());
		generalInformationImpl.setTheregistrybiobanksislistedinotherinventoriesnetworks(generalInformation.getTheregistrybiobanksislistedinotherinventoriesnetworks());
		generalInformationImpl.setModifieddate(generalInformation.getModifieddate());

		return generalInformationImpl;
	}

	/**
	 * Returns the general information with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the general information
	 * @return the general information
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException if a general information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralInformation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGeneralInformationException, SystemException {
		GeneralInformation generalInformation = fetchByPrimaryKey(primaryKey);

		if (generalInformation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGeneralInformationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return generalInformation;
	}

	/**
	 * Returns the general information with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException} if it could not be found.
	 *
	 * @param generalinformationId the primary key of the general information
	 * @return the general information
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException if a general information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralInformation findByPrimaryKey(long generalinformationId)
		throws NoSuchGeneralInformationException, SystemException {
		return findByPrimaryKey((Serializable)generalinformationId);
	}

	/**
	 * Returns the general information with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the general information
	 * @return the general information, or <code>null</code> if a general information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralInformation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GeneralInformation generalInformation = (GeneralInformation)EntityCacheUtil.getResult(GeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
				GeneralInformationImpl.class, primaryKey);

		if (generalInformation == _nullGeneralInformation) {
			return null;
		}

		if (generalInformation == null) {
			Session session = null;

			try {
				session = openSession();

				generalInformation = (GeneralInformation)session.get(GeneralInformationImpl.class,
						primaryKey);

				if (generalInformation != null) {
					cacheResult(generalInformation);
				}
				else {
					EntityCacheUtil.putResult(GeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
						GeneralInformationImpl.class, primaryKey,
						_nullGeneralInformation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
					GeneralInformationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return generalInformation;
	}

	/**
	 * Returns the general information with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param generalinformationId the primary key of the general information
	 * @return the general information, or <code>null</code> if a general information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralInformation fetchByPrimaryKey(long generalinformationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)generalinformationId);
	}

	/**
	 * Returns all the general informations.
	 *
	 * @return the general informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneralInformation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the general informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.GeneralInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of general informations
	 * @param end the upper bound of the range of general informations (not inclusive)
	 * @return the range of general informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneralInformation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the general informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.GeneralInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of general informations
	 * @param end the upper bound of the range of general informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of general informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneralInformation> findAll(int start, int end,
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

		List<GeneralInformation> list = (List<GeneralInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GENERALINFORMATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GENERALINFORMATION;

				if (pagination) {
					sql = sql.concat(GeneralInformationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GeneralInformation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GeneralInformation>(list);
				}
				else {
					list = (List<GeneralInformation>)QueryUtil.list(q,
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
	 * Removes all the general informations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GeneralInformation generalInformation : findAll()) {
			remove(generalInformation);
		}
	}

	/**
	 * Returns the number of general informations.
	 *
	 * @return the number of general informations
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

				Query q = session.createQuery(_SQL_COUNT_GENERALINFORMATION);

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
	 * Initializes the general information persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GeneralInformation>> listenersList = new ArrayList<ModelListener<GeneralInformation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GeneralInformation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GeneralInformationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GENERALINFORMATION = "SELECT generalInformation FROM GeneralInformation generalInformation";
	private static final String _SQL_SELECT_GENERALINFORMATION_WHERE = "SELECT generalInformation FROM GeneralInformation generalInformation WHERE ";
	private static final String _SQL_COUNT_GENERALINFORMATION = "SELECT COUNT(generalInformation) FROM GeneralInformation generalInformation";
	private static final String _SQL_COUNT_GENERALINFORMATION_WHERE = "SELECT COUNT(generalInformation) FROM GeneralInformation generalInformation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "generalInformation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GeneralInformation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GeneralInformation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GeneralInformationPersistenceImpl.class);
	private static GeneralInformation _nullGeneralInformation = new GeneralInformationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GeneralInformation> toCacheModel() {
				return _nullGeneralInformationCacheModel;
			}
		};

	private static CacheModel<GeneralInformation> _nullGeneralInformationCacheModel =
		new CacheModel<GeneralInformation>() {
			@Override
			public GeneralInformation toEntityModel() {
				return _nullGeneralInformation;
			}
		};
}