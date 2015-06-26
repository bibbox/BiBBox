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

package at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpPatientException;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpPatientImpl;
import at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpPatientModelImpl;

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
 * The persistence implementation for the kdssmp patient service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see KdssmpPatientPersistence
 * @see KdssmpPatientUtil
 * @generated
 */
public class KdssmpPatientPersistenceImpl extends BasePersistenceImpl<KdssmpPatient>
	implements KdssmpPatientPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link KdssmpPatientUtil} to access the kdssmp patient persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = KdssmpPatientImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KdssmpPatientModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpPatientModelImpl.FINDER_CACHE_ENABLED,
			KdssmpPatientImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KdssmpPatientModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpPatientModelImpl.FINDER_CACHE_ENABLED,
			KdssmpPatientImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KdssmpPatientModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpPatientModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ORGANIZATION = new FinderPath(KdssmpPatientModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpPatientModelImpl.FINDER_CACHE_ENABLED,
			KdssmpPatientImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByOrganization", new String[] { Long.class.getName() },
			KdssmpPatientModelImpl.ORGANIZATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATION = new FinderPath(KdssmpPatientModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpPatientModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganization",
			new String[] { Long.class.getName() });

	/**
	 * Returns the kdssmp patient where organizationId = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpPatientException} if it could not be found.
	 *
	 * @param organizationId the organization ID
	 * @return the matching kdssmp patient
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpPatientException if a matching kdssmp patient could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpPatient findByOrganization(long organizationId)
		throws NoSuchKdssmpPatientException, SystemException {
		KdssmpPatient kdssmpPatient = fetchByOrganization(organizationId);

		if (kdssmpPatient == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("organizationId=");
			msg.append(organizationId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchKdssmpPatientException(msg.toString());
		}

		return kdssmpPatient;
	}

	/**
	 * Returns the kdssmp patient where organizationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @return the matching kdssmp patient, or <code>null</code> if a matching kdssmp patient could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpPatient fetchByOrganization(long organizationId)
		throws SystemException {
		return fetchByOrganization(organizationId, true);
	}

	/**
	 * Returns the kdssmp patient where organizationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param organizationId the organization ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching kdssmp patient, or <code>null</code> if a matching kdssmp patient could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpPatient fetchByOrganization(long organizationId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { organizationId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ORGANIZATION,
					finderArgs, this);
		}

		if (result instanceof KdssmpPatient) {
			KdssmpPatient kdssmpPatient = (KdssmpPatient)result;

			if ((organizationId != kdssmpPatient.getOrganizationId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_KDSSMPPATIENT_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationId);

				List<KdssmpPatient> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORGANIZATION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"KdssmpPatientPersistenceImpl.fetchByOrganization(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					KdssmpPatient kdssmpPatient = list.get(0);

					result = kdssmpPatient;

					cacheResult(kdssmpPatient);

					if ((kdssmpPatient.getOrganizationId() != organizationId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORGANIZATION,
							finderArgs, kdssmpPatient);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ORGANIZATION,
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
			return (KdssmpPatient)result;
		}
	}

	/**
	 * Removes the kdssmp patient where organizationId = &#63; from the database.
	 *
	 * @param organizationId the organization ID
	 * @return the kdssmp patient that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpPatient removeByOrganization(long organizationId)
		throws NoSuchKdssmpPatientException, SystemException {
		KdssmpPatient kdssmpPatient = findByOrganization(organizationId);

		return remove(kdssmpPatient);
	}

	/**
	 * Returns the number of kdssmp patients where organizationId = &#63;.
	 *
	 * @param organizationId the organization ID
	 * @return the number of matching kdssmp patients
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOrganization(long organizationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ORGANIZATION;

		Object[] finderArgs = new Object[] { organizationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KDSSMPPATIENT_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

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

	private static final String _FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2 = "kdssmpPatient.organizationId = ?";

	public KdssmpPatientPersistenceImpl() {
		setModelClass(KdssmpPatient.class);
	}

	/**
	 * Caches the kdssmp patient in the entity cache if it is enabled.
	 *
	 * @param kdssmpPatient the kdssmp patient
	 */
	@Override
	public void cacheResult(KdssmpPatient kdssmpPatient) {
		EntityCacheUtil.putResult(KdssmpPatientModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpPatientImpl.class, kdssmpPatient.getPrimaryKey(),
			kdssmpPatient);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORGANIZATION,
			new Object[] { kdssmpPatient.getOrganizationId() }, kdssmpPatient);

		kdssmpPatient.resetOriginalValues();
	}

	/**
	 * Caches the kdssmp patients in the entity cache if it is enabled.
	 *
	 * @param kdssmpPatients the kdssmp patients
	 */
	@Override
	public void cacheResult(List<KdssmpPatient> kdssmpPatients) {
		for (KdssmpPatient kdssmpPatient : kdssmpPatients) {
			if (EntityCacheUtil.getResult(
						KdssmpPatientModelImpl.ENTITY_CACHE_ENABLED,
						KdssmpPatientImpl.class, kdssmpPatient.getPrimaryKey()) == null) {
				cacheResult(kdssmpPatient);
			}
			else {
				kdssmpPatient.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all kdssmp patients.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(KdssmpPatientImpl.class.getName());
		}

		EntityCacheUtil.clearCache(KdssmpPatientImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the kdssmp patient.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(KdssmpPatient kdssmpPatient) {
		EntityCacheUtil.removeResult(KdssmpPatientModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpPatientImpl.class, kdssmpPatient.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(kdssmpPatient);
	}

	@Override
	public void clearCache(List<KdssmpPatient> kdssmpPatients) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (KdssmpPatient kdssmpPatient : kdssmpPatients) {
			EntityCacheUtil.removeResult(KdssmpPatientModelImpl.ENTITY_CACHE_ENABLED,
				KdssmpPatientImpl.class, kdssmpPatient.getPrimaryKey());

			clearUniqueFindersCache(kdssmpPatient);
		}
	}

	protected void cacheUniqueFindersCache(KdssmpPatient kdssmpPatient) {
		if (kdssmpPatient.isNew()) {
			Object[] args = new Object[] { kdssmpPatient.getOrganizationId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGANIZATION, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORGANIZATION, args,
				kdssmpPatient);
		}
		else {
			KdssmpPatientModelImpl kdssmpPatientModelImpl = (KdssmpPatientModelImpl)kdssmpPatient;

			if ((kdssmpPatientModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ORGANIZATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { kdssmpPatient.getOrganizationId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGANIZATION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ORGANIZATION,
					args, kdssmpPatient);
			}
		}
	}

	protected void clearUniqueFindersCache(KdssmpPatient kdssmpPatient) {
		KdssmpPatientModelImpl kdssmpPatientModelImpl = (KdssmpPatientModelImpl)kdssmpPatient;

		Object[] args = new Object[] { kdssmpPatient.getOrganizationId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATION, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ORGANIZATION, args);

		if ((kdssmpPatientModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ORGANIZATION.getColumnBitmask()) != 0) {
			args = new Object[] {
					kdssmpPatientModelImpl.getOriginalOrganizationId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ORGANIZATION, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ORGANIZATION, args);
		}
	}

	/**
	 * Creates a new kdssmp patient with the primary key. Does not add the kdssmp patient to the database.
	 *
	 * @param patientId the primary key for the new kdssmp patient
	 * @return the new kdssmp patient
	 */
	@Override
	public KdssmpPatient create(long patientId) {
		KdssmpPatient kdssmpPatient = new KdssmpPatientImpl();

		kdssmpPatient.setNew(true);
		kdssmpPatient.setPrimaryKey(patientId);

		return kdssmpPatient;
	}

	/**
	 * Removes the kdssmp patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param patientId the primary key of the kdssmp patient
	 * @return the kdssmp patient that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpPatientException if a kdssmp patient with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpPatient remove(long patientId)
		throws NoSuchKdssmpPatientException, SystemException {
		return remove((Serializable)patientId);
	}

	/**
	 * Removes the kdssmp patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the kdssmp patient
	 * @return the kdssmp patient that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpPatientException if a kdssmp patient with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpPatient remove(Serializable primaryKey)
		throws NoSuchKdssmpPatientException, SystemException {
		Session session = null;

		try {
			session = openSession();

			KdssmpPatient kdssmpPatient = (KdssmpPatient)session.get(KdssmpPatientImpl.class,
					primaryKey);

			if (kdssmpPatient == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKdssmpPatientException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(kdssmpPatient);
		}
		catch (NoSuchKdssmpPatientException nsee) {
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
	protected KdssmpPatient removeImpl(KdssmpPatient kdssmpPatient)
		throws SystemException {
		kdssmpPatient = toUnwrappedModel(kdssmpPatient);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(kdssmpPatient)) {
				kdssmpPatient = (KdssmpPatient)session.get(KdssmpPatientImpl.class,
						kdssmpPatient.getPrimaryKeyObj());
			}

			if (kdssmpPatient != null) {
				session.delete(kdssmpPatient);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (kdssmpPatient != null) {
			clearCache(kdssmpPatient);
		}

		return kdssmpPatient;
	}

	@Override
	public KdssmpPatient updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient kdssmpPatient)
		throws SystemException {
		kdssmpPatient = toUnwrappedModel(kdssmpPatient);

		boolean isNew = kdssmpPatient.isNew();

		Session session = null;

		try {
			session = openSession();

			if (kdssmpPatient.isNew()) {
				session.save(kdssmpPatient);

				kdssmpPatient.setNew(false);
			}
			else {
				session.merge(kdssmpPatient);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !KdssmpPatientModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(KdssmpPatientModelImpl.ENTITY_CACHE_ENABLED,
			KdssmpPatientImpl.class, kdssmpPatient.getPrimaryKey(),
			kdssmpPatient);

		clearUniqueFindersCache(kdssmpPatient);
		cacheUniqueFindersCache(kdssmpPatient);

		return kdssmpPatient;
	}

	protected KdssmpPatient toUnwrappedModel(KdssmpPatient kdssmpPatient) {
		if (kdssmpPatient instanceof KdssmpPatientImpl) {
			return kdssmpPatient;
		}

		KdssmpPatientImpl kdssmpPatientImpl = new KdssmpPatientImpl();

		kdssmpPatientImpl.setNew(kdssmpPatient.isNew());
		kdssmpPatientImpl.setPrimaryKey(kdssmpPatient.getPrimaryKey());

		kdssmpPatientImpl.setPatientId(kdssmpPatient.getPatientId());
		kdssmpPatientImpl.setOrganizationId(kdssmpPatient.getOrganizationId());
		kdssmpPatientImpl.setFirstname(kdssmpPatient.getFirstname());
		kdssmpPatientImpl.setLastname(kdssmpPatient.getLastname());
		kdssmpPatientImpl.setGender(kdssmpPatient.getGender());
		kdssmpPatientImpl.setDateofbirth(kdssmpPatient.getDateofbirth());
		kdssmpPatientImpl.setDateofdeath(kdssmpPatient.getDateofdeath());

		return kdssmpPatientImpl;
	}

	/**
	 * Returns the kdssmp patient with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the kdssmp patient
	 * @return the kdssmp patient
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpPatientException if a kdssmp patient with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpPatient findByPrimaryKey(Serializable primaryKey)
		throws NoSuchKdssmpPatientException, SystemException {
		KdssmpPatient kdssmpPatient = fetchByPrimaryKey(primaryKey);

		if (kdssmpPatient == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchKdssmpPatientException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return kdssmpPatient;
	}

	/**
	 * Returns the kdssmp patient with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpPatientException} if it could not be found.
	 *
	 * @param patientId the primary key of the kdssmp patient
	 * @return the kdssmp patient
	 * @throws at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.NoSuchKdssmpPatientException if a kdssmp patient with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpPatient findByPrimaryKey(long patientId)
		throws NoSuchKdssmpPatientException, SystemException {
		return findByPrimaryKey((Serializable)patientId);
	}

	/**
	 * Returns the kdssmp patient with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the kdssmp patient
	 * @return the kdssmp patient, or <code>null</code> if a kdssmp patient with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpPatient fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		KdssmpPatient kdssmpPatient = (KdssmpPatient)EntityCacheUtil.getResult(KdssmpPatientModelImpl.ENTITY_CACHE_ENABLED,
				KdssmpPatientImpl.class, primaryKey);

		if (kdssmpPatient == _nullKdssmpPatient) {
			return null;
		}

		if (kdssmpPatient == null) {
			Session session = null;

			try {
				session = openSession();

				kdssmpPatient = (KdssmpPatient)session.get(KdssmpPatientImpl.class,
						primaryKey);

				if (kdssmpPatient != null) {
					cacheResult(kdssmpPatient);
				}
				else {
					EntityCacheUtil.putResult(KdssmpPatientModelImpl.ENTITY_CACHE_ENABLED,
						KdssmpPatientImpl.class, primaryKey, _nullKdssmpPatient);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(KdssmpPatientModelImpl.ENTITY_CACHE_ENABLED,
					KdssmpPatientImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return kdssmpPatient;
	}

	/**
	 * Returns the kdssmp patient with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param patientId the primary key of the kdssmp patient
	 * @return the kdssmp patient, or <code>null</code> if a kdssmp patient with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public KdssmpPatient fetchByPrimaryKey(long patientId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)patientId);
	}

	/**
	 * Returns all the kdssmp patients.
	 *
	 * @return the kdssmp patients
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpPatient> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kdssmp patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpPatientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kdssmp patients
	 * @param end the upper bound of the range of kdssmp patients (not inclusive)
	 * @return the range of kdssmp patients
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpPatient> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the kdssmp patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.impl.KdssmpPatientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kdssmp patients
	 * @param end the upper bound of the range of kdssmp patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of kdssmp patients
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<KdssmpPatient> findAll(int start, int end,
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

		List<KdssmpPatient> list = (List<KdssmpPatient>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_KDSSMPPATIENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KDSSMPPATIENT;

				if (pagination) {
					sql = sql.concat(KdssmpPatientModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<KdssmpPatient>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<KdssmpPatient>(list);
				}
				else {
					list = (List<KdssmpPatient>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the kdssmp patients from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (KdssmpPatient kdssmpPatient : findAll()) {
			remove(kdssmpPatient);
		}
	}

	/**
	 * Returns the number of kdssmp patients.
	 *
	 * @return the number of kdssmp patients
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

				Query q = session.createQuery(_SQL_COUNT_KDSSMPPATIENT);

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
	 * Initializes the kdssmp patient persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.kdssmp.service.model.KdssmpPatient")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<KdssmpPatient>> listenersList = new ArrayList<ModelListener<KdssmpPatient>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<KdssmpPatient>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(KdssmpPatientImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_KDSSMPPATIENT = "SELECT kdssmpPatient FROM KdssmpPatient kdssmpPatient";
	private static final String _SQL_SELECT_KDSSMPPATIENT_WHERE = "SELECT kdssmpPatient FROM KdssmpPatient kdssmpPatient WHERE ";
	private static final String _SQL_COUNT_KDSSMPPATIENT = "SELECT COUNT(kdssmpPatient) FROM KdssmpPatient kdssmpPatient";
	private static final String _SQL_COUNT_KDSSMPPATIENT_WHERE = "SELECT COUNT(kdssmpPatient) FROM KdssmpPatient kdssmpPatient WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "kdssmpPatient.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No KdssmpPatient exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No KdssmpPatient exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(KdssmpPatientPersistenceImpl.class);
	private static KdssmpPatient _nullKdssmpPatient = new KdssmpPatientImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<KdssmpPatient> toCacheModel() {
				return _nullKdssmpPatientCacheModel;
			}
		};

	private static CacheModel<KdssmpPatient> _nullKdssmpPatientCacheModel = new CacheModel<KdssmpPatient>() {
			@Override
			public KdssmpPatient toEntityModel() {
				return _nullKdssmpPatient;
			}
		};
}