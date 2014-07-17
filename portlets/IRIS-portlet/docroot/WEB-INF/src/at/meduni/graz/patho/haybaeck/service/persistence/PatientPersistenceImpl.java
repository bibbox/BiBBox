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

import at.meduni.graz.patho.haybaeck.NoSuchPatientException;
import at.meduni.graz.patho.haybaeck.model.Patient;
import at.meduni.graz.patho.haybaeck.model.impl.PatientImpl;
import at.meduni.graz.patho.haybaeck.model.impl.PatientModelImpl;

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
 * The persistence implementation for the patient service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see PatientPersistence
 * @see PatientUtil
 * @generated
 */
public class PatientPersistenceImpl extends BasePersistenceImpl<Patient>
	implements PatientPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PatientUtil} to access the patient persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PatientImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PatientModelImpl.ENTITY_CACHE_ENABLED,
			PatientModelImpl.FINDER_CACHE_ENABLED, PatientImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PatientModelImpl.ENTITY_CACHE_ENABLED,
			PatientModelImpl.FINDER_CACHE_ENABLED, PatientImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PatientModelImpl.ENTITY_CACHE_ENABLED,
			PatientModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PatientPersistenceImpl() {
		setModelClass(Patient.class);
	}

	/**
	 * Caches the patient in the entity cache if it is enabled.
	 *
	 * @param patient the patient
	 */
	@Override
	public void cacheResult(Patient patient) {
		EntityCacheUtil.putResult(PatientModelImpl.ENTITY_CACHE_ENABLED,
			PatientImpl.class, patient.getPrimaryKey(), patient);

		patient.resetOriginalValues();
	}

	/**
	 * Caches the patients in the entity cache if it is enabled.
	 *
	 * @param patients the patients
	 */
	@Override
	public void cacheResult(List<Patient> patients) {
		for (Patient patient : patients) {
			if (EntityCacheUtil.getResult(
						PatientModelImpl.ENTITY_CACHE_ENABLED,
						PatientImpl.class, patient.getPrimaryKey()) == null) {
				cacheResult(patient);
			}
			else {
				patient.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all patients.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PatientImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PatientImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the patient.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Patient patient) {
		EntityCacheUtil.removeResult(PatientModelImpl.ENTITY_CACHE_ENABLED,
			PatientImpl.class, patient.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Patient> patients) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Patient patient : patients) {
			EntityCacheUtil.removeResult(PatientModelImpl.ENTITY_CACHE_ENABLED,
				PatientImpl.class, patient.getPrimaryKey());
		}
	}

	/**
	 * Creates a new patient with the primary key. Does not add the patient to the database.
	 *
	 * @param patient_Id the primary key for the new patient
	 * @return the new patient
	 */
	@Override
	public Patient create(long patient_Id) {
		Patient patient = new PatientImpl();

		patient.setNew(true);
		patient.setPrimaryKey(patient_Id);

		return patient;
	}

	/**
	 * Removes the patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param patient_Id the primary key of the patient
	 * @return the patient that was removed
	 * @throws at.meduni.graz.patho.haybaeck.NoSuchPatientException if a patient with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patient remove(long patient_Id)
		throws NoSuchPatientException, SystemException {
		return remove((Serializable)patient_Id);
	}

	/**
	 * Removes the patient with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the patient
	 * @return the patient that was removed
	 * @throws at.meduni.graz.patho.haybaeck.NoSuchPatientException if a patient with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patient remove(Serializable primaryKey)
		throws NoSuchPatientException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Patient patient = (Patient)session.get(PatientImpl.class, primaryKey);

			if (patient == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPatientException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(patient);
		}
		catch (NoSuchPatientException nsee) {
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
	protected Patient removeImpl(Patient patient) throws SystemException {
		patient = toUnwrappedModel(patient);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(patient)) {
				patient = (Patient)session.get(PatientImpl.class,
						patient.getPrimaryKeyObj());
			}

			if (patient != null) {
				session.delete(patient);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (patient != null) {
			clearCache(patient);
		}

		return patient;
	}

	@Override
	public Patient updateImpl(
		at.meduni.graz.patho.haybaeck.model.Patient patient)
		throws SystemException {
		patient = toUnwrappedModel(patient);

		boolean isNew = patient.isNew();

		Session session = null;

		try {
			session = openSession();

			if (patient.isNew()) {
				session.save(patient);

				patient.setNew(false);
			}
			else {
				session.merge(patient);
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

		EntityCacheUtil.putResult(PatientModelImpl.ENTITY_CACHE_ENABLED,
			PatientImpl.class, patient.getPrimaryKey(), patient);

		return patient;
	}

	protected Patient toUnwrappedModel(Patient patient) {
		if (patient instanceof PatientImpl) {
			return patient;
		}

		PatientImpl patientImpl = new PatientImpl();

		patientImpl.setNew(patient.isNew());
		patientImpl.setPrimaryKey(patient.getPrimaryKey());

		patientImpl.setPatient_Id(patient.getPatient_Id());
		patientImpl.setIdentifier(patient.getIdentifier());
		patientImpl.setCohort(patient.getCohort());
		patientImpl.setFirst_name(patient.getFirst_name());
		patientImpl.setLast_name(patient.getLast_name());
		patientImpl.setDate_of_birth(patient.getDate_of_birth());
		patientImpl.setDate_of_death(patient.getDate_of_death());
		patientImpl.setCouse_of_death(patient.getCouse_of_death());
		patientImpl.setGender(patient.getGender());

		return patientImpl;
	}

	/**
	 * Returns the patient with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the patient
	 * @return the patient
	 * @throws at.meduni.graz.patho.haybaeck.NoSuchPatientException if a patient with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patient findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPatientException, SystemException {
		Patient patient = fetchByPrimaryKey(primaryKey);

		if (patient == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPatientException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return patient;
	}

	/**
	 * Returns the patient with the primary key or throws a {@link at.meduni.graz.patho.haybaeck.NoSuchPatientException} if it could not be found.
	 *
	 * @param patient_Id the primary key of the patient
	 * @return the patient
	 * @throws at.meduni.graz.patho.haybaeck.NoSuchPatientException if a patient with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patient findByPrimaryKey(long patient_Id)
		throws NoSuchPatientException, SystemException {
		return findByPrimaryKey((Serializable)patient_Id);
	}

	/**
	 * Returns the patient with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the patient
	 * @return the patient, or <code>null</code> if a patient with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patient fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Patient patient = (Patient)EntityCacheUtil.getResult(PatientModelImpl.ENTITY_CACHE_ENABLED,
				PatientImpl.class, primaryKey);

		if (patient == _nullPatient) {
			return null;
		}

		if (patient == null) {
			Session session = null;

			try {
				session = openSession();

				patient = (Patient)session.get(PatientImpl.class, primaryKey);

				if (patient != null) {
					cacheResult(patient);
				}
				else {
					EntityCacheUtil.putResult(PatientModelImpl.ENTITY_CACHE_ENABLED,
						PatientImpl.class, primaryKey, _nullPatient);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PatientModelImpl.ENTITY_CACHE_ENABLED,
					PatientImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return patient;
	}

	/**
	 * Returns the patient with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param patient_Id the primary key of the patient
	 * @return the patient, or <code>null</code> if a patient with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Patient fetchByPrimaryKey(long patient_Id) throws SystemException {
		return fetchByPrimaryKey((Serializable)patient_Id);
	}

	/**
	 * Returns all the patients.
	 *
	 * @return the patients
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Patient> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.graz.patho.haybaeck.model.impl.PatientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @return the range of patients
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Patient> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the patients.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.graz.patho.haybaeck.model.impl.PatientModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of patients
	 * @param end the upper bound of the range of patients (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of patients
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Patient> findAll(int start, int end,
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

		List<Patient> list = (List<Patient>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PATIENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PATIENT;

				if (pagination) {
					sql = sql.concat(PatientModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Patient>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Patient>(list);
				}
				else {
					list = (List<Patient>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the patients from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Patient patient : findAll()) {
			remove(patient);
		}
	}

	/**
	 * Returns the number of patients.
	 *
	 * @return the number of patients
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

				Query q = session.createQuery(_SQL_COUNT_PATIENT);

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
	 * Initializes the patient persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.graz.patho.haybaeck.model.Patient")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Patient>> listenersList = new ArrayList<ModelListener<Patient>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Patient>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PatientImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PATIENT = "SELECT patient FROM Patient patient";
	private static final String _SQL_COUNT_PATIENT = "SELECT COUNT(patient) FROM Patient patient";
	private static final String _ORDER_BY_ENTITY_ALIAS = "patient.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Patient exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PatientPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"patient_Id"
			});
	private static Patient _nullPatient = new PatientImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Patient> toCacheModel() {
				return _nullPatientCacheModel;
			}
		};

	private static CacheModel<Patient> _nullPatientCacheModel = new CacheModel<Patient>() {
			@Override
			public Patient toEntityModel() {
				return _nullPatient;
			}
		};
}