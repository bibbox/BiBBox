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

package at.meduni.liferay.portlet.bbmrieric.service.persistence;

import at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException;
import at.meduni.liferay.portlet.bbmrieric.model.BioBank;
import at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankImpl;
import at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the bio bank service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see BioBankPersistence
 * @see BioBankUtil
 * @generated
 */
public class BioBankPersistenceImpl extends BasePersistenceImpl<BioBank>
	implements BioBankPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BioBankUtil} to access the bio bank persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BioBankImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BioBankModelImpl.ENTITY_CACHE_ENABLED,
			BioBankModelImpl.FINDER_CACHE_ENABLED, BioBankImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BioBankModelImpl.ENTITY_CACHE_ENABLED,
			BioBankModelImpl.FINDER_CACHE_ENABLED, BioBankImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BioBankModelImpl.ENTITY_CACHE_ENABLED,
			BioBankModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_LADPBIOBANKID = new FinderPath(BioBankModelImpl.ENTITY_CACHE_ENABLED,
			BioBankModelImpl.FINDER_CACHE_ENABLED, BioBankImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLADPBiobankId",
			new String[] { String.class.getName() },
			BioBankModelImpl.LDAPBIOBANKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LADPBIOBANKID = new FinderPath(BioBankModelImpl.ENTITY_CACHE_ENABLED,
			BioBankModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLADPBiobankId",
			new String[] { String.class.getName() });

	/**
	 * Returns the bio bank where ldapbiobankID = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException} if it could not be found.
	 *
	 * @param ldapbiobankID the ldapbiobank i d
	 * @return the matching bio bank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a matching bio bank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank findByLADPBiobankId(String ldapbiobankID)
		throws NoSuchBioBankException, SystemException {
		BioBank bioBank = fetchByLADPBiobankId(ldapbiobankID);

		if (bioBank == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ldapbiobankID=");
			msg.append(ldapbiobankID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBioBankException(msg.toString());
		}

		return bioBank;
	}

	/**
	 * Returns the bio bank where ldapbiobankID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ldapbiobankID the ldapbiobank i d
	 * @return the matching bio bank, or <code>null</code> if a matching bio bank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank fetchByLADPBiobankId(String ldapbiobankID)
		throws SystemException {
		return fetchByLADPBiobankId(ldapbiobankID, true);
	}

	/**
	 * Returns the bio bank where ldapbiobankID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ldapbiobankID the ldapbiobank i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching bio bank, or <code>null</code> if a matching bio bank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank fetchByLADPBiobankId(String ldapbiobankID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { ldapbiobankID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LADPBIOBANKID,
					finderArgs, this);
		}

		if (result instanceof BioBank) {
			BioBank bioBank = (BioBank)result;

			if (!Validator.equals(ldapbiobankID, bioBank.getLdapbiobankID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BIOBANK_WHERE);

			boolean bindLdapbiobankID = false;

			if (ldapbiobankID == null) {
				query.append(_FINDER_COLUMN_LADPBIOBANKID_LDAPBIOBANKID_1);
			}
			else if (ldapbiobankID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LADPBIOBANKID_LDAPBIOBANKID_3);
			}
			else {
				bindLdapbiobankID = true;

				query.append(_FINDER_COLUMN_LADPBIOBANKID_LDAPBIOBANKID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLdapbiobankID) {
					qPos.add(ldapbiobankID);
				}

				List<BioBank> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LADPBIOBANKID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BioBankPersistenceImpl.fetchByLADPBiobankId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BioBank bioBank = list.get(0);

					result = bioBank;

					cacheResult(bioBank);

					if ((bioBank.getLdapbiobankID() == null) ||
							!bioBank.getLdapbiobankID().equals(ldapbiobankID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LADPBIOBANKID,
							finderArgs, bioBank);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LADPBIOBANKID,
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
			return (BioBank)result;
		}
	}

	/**
	 * Removes the bio bank where ldapbiobankID = &#63; from the database.
	 *
	 * @param ldapbiobankID the ldapbiobank i d
	 * @return the bio bank that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank removeByLADPBiobankId(String ldapbiobankID)
		throws NoSuchBioBankException, SystemException {
		BioBank bioBank = findByLADPBiobankId(ldapbiobankID);

		return remove(bioBank);
	}

	/**
	 * Returns the number of bio banks where ldapbiobankID = &#63;.
	 *
	 * @param ldapbiobankID the ldapbiobank i d
	 * @return the number of matching bio banks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLADPBiobankId(String ldapbiobankID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LADPBIOBANKID;

		Object[] finderArgs = new Object[] { ldapbiobankID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BIOBANK_WHERE);

			boolean bindLdapbiobankID = false;

			if (ldapbiobankID == null) {
				query.append(_FINDER_COLUMN_LADPBIOBANKID_LDAPBIOBANKID_1);
			}
			else if (ldapbiobankID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LADPBIOBANKID_LDAPBIOBANKID_3);
			}
			else {
				bindLdapbiobankID = true;

				query.append(_FINDER_COLUMN_LADPBIOBANKID_LDAPBIOBANKID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLdapbiobankID) {
					qPos.add(ldapbiobankID);
				}

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

	private static final String _FINDER_COLUMN_LADPBIOBANKID_LDAPBIOBANKID_1 = "bioBank.ldapbiobankID IS NULL";
	private static final String _FINDER_COLUMN_LADPBIOBANKID_LDAPBIOBANKID_2 = "bioBank.ldapbiobankID = ?";
	private static final String _FINDER_COLUMN_LADPBIOBANKID_LDAPBIOBANKID_3 = "(bioBank.ldapbiobankID IS NULL OR bioBank.ldapbiobankID = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BIOBANKCOUNTRY =
		new FinderPath(BioBankModelImpl.ENTITY_CACHE_ENABLED,
			BioBankModelImpl.FINDER_CACHE_ENABLED, BioBankImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBiobankCountry",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKCOUNTRY =
		new FinderPath(BioBankModelImpl.ENTITY_CACHE_ENABLED,
			BioBankModelImpl.FINDER_CACHE_ENABLED, BioBankImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBiobankCountry",
			new String[] { String.class.getName() },
			BioBankModelImpl.BIOBANKCOUNTRY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BIOBANKCOUNTRY = new FinderPath(BioBankModelImpl.ENTITY_CACHE_ENABLED,
			BioBankModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBiobankCountry",
			new String[] { String.class.getName() });

	/**
	 * Returns all the bio banks where biobankcountry = &#63;.
	 *
	 * @param biobankcountry the biobankcountry
	 * @return the matching bio banks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BioBank> findByBiobankCountry(String biobankcountry)
		throws SystemException {
		return findByBiobankCountry(biobankcountry, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bio banks where biobankcountry = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param biobankcountry the biobankcountry
	 * @param start the lower bound of the range of bio banks
	 * @param end the upper bound of the range of bio banks (not inclusive)
	 * @return the range of matching bio banks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BioBank> findByBiobankCountry(String biobankcountry, int start,
		int end) throws SystemException {
		return findByBiobankCountry(biobankcountry, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bio banks where biobankcountry = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param biobankcountry the biobankcountry
	 * @param start the lower bound of the range of bio banks
	 * @param end the upper bound of the range of bio banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bio banks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BioBank> findByBiobankCountry(String biobankcountry, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKCOUNTRY;
			finderArgs = new Object[] { biobankcountry };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BIOBANKCOUNTRY;
			finderArgs = new Object[] {
					biobankcountry,
					
					start, end, orderByComparator
				};
		}

		List<BioBank> list = (List<BioBank>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BioBank bioBank : list) {
				if (!Validator.equals(biobankcountry,
							bioBank.getBiobankcountry())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BIOBANK_WHERE);

			boolean bindBiobankcountry = false;

			if (biobankcountry == null) {
				query.append(_FINDER_COLUMN_BIOBANKCOUNTRY_BIOBANKCOUNTRY_1);
			}
			else if (biobankcountry.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BIOBANKCOUNTRY_BIOBANKCOUNTRY_3);
			}
			else {
				bindBiobankcountry = true;

				query.append(_FINDER_COLUMN_BIOBANKCOUNTRY_BIOBANKCOUNTRY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BioBankModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBiobankcountry) {
					qPos.add(biobankcountry);
				}

				if (!pagination) {
					list = (List<BioBank>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BioBank>(list);
				}
				else {
					list = (List<BioBank>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bio bank in the ordered set where biobankcountry = &#63;.
	 *
	 * @param biobankcountry the biobankcountry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bio bank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a matching bio bank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank findByBiobankCountry_First(String biobankcountry,
		OrderByComparator orderByComparator)
		throws NoSuchBioBankException, SystemException {
		BioBank bioBank = fetchByBiobankCountry_First(biobankcountry,
				orderByComparator);

		if (bioBank != null) {
			return bioBank;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("biobankcountry=");
		msg.append(biobankcountry);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBioBankException(msg.toString());
	}

	/**
	 * Returns the first bio bank in the ordered set where biobankcountry = &#63;.
	 *
	 * @param biobankcountry the biobankcountry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bio bank, or <code>null</code> if a matching bio bank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank fetchByBiobankCountry_First(String biobankcountry,
		OrderByComparator orderByComparator) throws SystemException {
		List<BioBank> list = findByBiobankCountry(biobankcountry, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bio bank in the ordered set where biobankcountry = &#63;.
	 *
	 * @param biobankcountry the biobankcountry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bio bank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a matching bio bank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank findByBiobankCountry_Last(String biobankcountry,
		OrderByComparator orderByComparator)
		throws NoSuchBioBankException, SystemException {
		BioBank bioBank = fetchByBiobankCountry_Last(biobankcountry,
				orderByComparator);

		if (bioBank != null) {
			return bioBank;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("biobankcountry=");
		msg.append(biobankcountry);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBioBankException(msg.toString());
	}

	/**
	 * Returns the last bio bank in the ordered set where biobankcountry = &#63;.
	 *
	 * @param biobankcountry the biobankcountry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bio bank, or <code>null</code> if a matching bio bank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank fetchByBiobankCountry_Last(String biobankcountry,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBiobankCountry(biobankcountry);

		if (count == 0) {
			return null;
		}

		List<BioBank> list = findByBiobankCountry(biobankcountry, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bio banks before and after the current bio bank in the ordered set where biobankcountry = &#63;.
	 *
	 * @param biobankId the primary key of the current bio bank
	 * @param biobankcountry the biobankcountry
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bio bank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a bio bank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank[] findByBiobankCountry_PrevAndNext(long biobankId,
		String biobankcountry, OrderByComparator orderByComparator)
		throws NoSuchBioBankException, SystemException {
		BioBank bioBank = findByPrimaryKey(biobankId);

		Session session = null;

		try {
			session = openSession();

			BioBank[] array = new BioBankImpl[3];

			array[0] = getByBiobankCountry_PrevAndNext(session, bioBank,
					biobankcountry, orderByComparator, true);

			array[1] = bioBank;

			array[2] = getByBiobankCountry_PrevAndNext(session, bioBank,
					biobankcountry, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BioBank getByBiobankCountry_PrevAndNext(Session session,
		BioBank bioBank, String biobankcountry,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BIOBANK_WHERE);

		boolean bindBiobankcountry = false;

		if (biobankcountry == null) {
			query.append(_FINDER_COLUMN_BIOBANKCOUNTRY_BIOBANKCOUNTRY_1);
		}
		else if (biobankcountry.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BIOBANKCOUNTRY_BIOBANKCOUNTRY_3);
		}
		else {
			bindBiobankcountry = true;

			query.append(_FINDER_COLUMN_BIOBANKCOUNTRY_BIOBANKCOUNTRY_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BioBankModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindBiobankcountry) {
			qPos.add(biobankcountry);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bioBank);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BioBank> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bio banks where biobankcountry = &#63; from the database.
	 *
	 * @param biobankcountry the biobankcountry
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBiobankCountry(String biobankcountry)
		throws SystemException {
		for (BioBank bioBank : findByBiobankCountry(biobankcountry,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(bioBank);
		}
	}

	/**
	 * Returns the number of bio banks where biobankcountry = &#63;.
	 *
	 * @param biobankcountry the biobankcountry
	 * @return the number of matching bio banks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBiobankCountry(String biobankcountry)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BIOBANKCOUNTRY;

		Object[] finderArgs = new Object[] { biobankcountry };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BIOBANK_WHERE);

			boolean bindBiobankcountry = false;

			if (biobankcountry == null) {
				query.append(_FINDER_COLUMN_BIOBANKCOUNTRY_BIOBANKCOUNTRY_1);
			}
			else if (biobankcountry.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BIOBANKCOUNTRY_BIOBANKCOUNTRY_3);
			}
			else {
				bindBiobankcountry = true;

				query.append(_FINDER_COLUMN_BIOBANKCOUNTRY_BIOBANKCOUNTRY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBiobankcountry) {
					qPos.add(biobankcountry);
				}

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

	private static final String _FINDER_COLUMN_BIOBANKCOUNTRY_BIOBANKCOUNTRY_1 = "bioBank.biobankcountry IS NULL";
	private static final String _FINDER_COLUMN_BIOBANKCOUNTRY_BIOBANKCOUNTRY_2 = "bioBank.biobankcountry = ?";
	private static final String _FINDER_COLUMN_BIOBANKCOUNTRY_BIOBANKCOUNTRY_3 = "(bioBank.biobankcountry IS NULL OR bioBank.biobankcountry = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTUUID = new FinderPath(BioBankModelImpl.ENTITY_CACHE_ENABLED,
			BioBankModelImpl.FINDER_CACHE_ENABLED, BioBankImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNotUUID",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOTUUID = new FinderPath(BioBankModelImpl.ENTITY_CACHE_ENABLED,
			BioBankModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByNotUUID",
			new String[] { String.class.getName() });

	/**
	 * Returns all the bio banks where UUID &ne; &#63;.
	 *
	 * @param UUID the u u i d
	 * @return the matching bio banks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BioBank> findByNotUUID(String UUID) throws SystemException {
		return findByNotUUID(UUID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bio banks where UUID &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param UUID the u u i d
	 * @param start the lower bound of the range of bio banks
	 * @param end the upper bound of the range of bio banks (not inclusive)
	 * @return the range of matching bio banks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BioBank> findByNotUUID(String UUID, int start, int end)
		throws SystemException {
		return findByNotUUID(UUID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bio banks where UUID &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param UUID the u u i d
	 * @param start the lower bound of the range of bio banks
	 * @param end the upper bound of the range of bio banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bio banks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BioBank> findByNotUUID(String UUID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTUUID;
		finderArgs = new Object[] { UUID, start, end, orderByComparator };

		List<BioBank> list = (List<BioBank>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BioBank bioBank : list) {
				if (Validator.equals(UUID, bioBank.getUUID())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_BIOBANK_WHERE);

			boolean bindUUID = false;

			if (UUID == null) {
				query.append(_FINDER_COLUMN_NOTUUID_UUID_1);
			}
			else if (UUID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOTUUID_UUID_3);
			}
			else {
				bindUUID = true;

				query.append(_FINDER_COLUMN_NOTUUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BioBankModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUUID) {
					qPos.add(UUID);
				}

				if (!pagination) {
					list = (List<BioBank>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BioBank>(list);
				}
				else {
					list = (List<BioBank>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bio bank in the ordered set where UUID &ne; &#63;.
	 *
	 * @param UUID the u u i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bio bank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a matching bio bank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank findByNotUUID_First(String UUID,
		OrderByComparator orderByComparator)
		throws NoSuchBioBankException, SystemException {
		BioBank bioBank = fetchByNotUUID_First(UUID, orderByComparator);

		if (bioBank != null) {
			return bioBank;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("UUID=");
		msg.append(UUID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBioBankException(msg.toString());
	}

	/**
	 * Returns the first bio bank in the ordered set where UUID &ne; &#63;.
	 *
	 * @param UUID the u u i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bio bank, or <code>null</code> if a matching bio bank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank fetchByNotUUID_First(String UUID,
		OrderByComparator orderByComparator) throws SystemException {
		List<BioBank> list = findByNotUUID(UUID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bio bank in the ordered set where UUID &ne; &#63;.
	 *
	 * @param UUID the u u i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bio bank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a matching bio bank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank findByNotUUID_Last(String UUID,
		OrderByComparator orderByComparator)
		throws NoSuchBioBankException, SystemException {
		BioBank bioBank = fetchByNotUUID_Last(UUID, orderByComparator);

		if (bioBank != null) {
			return bioBank;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("UUID=");
		msg.append(UUID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBioBankException(msg.toString());
	}

	/**
	 * Returns the last bio bank in the ordered set where UUID &ne; &#63;.
	 *
	 * @param UUID the u u i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bio bank, or <code>null</code> if a matching bio bank could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank fetchByNotUUID_Last(String UUID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNotUUID(UUID);

		if (count == 0) {
			return null;
		}

		List<BioBank> list = findByNotUUID(UUID, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bio banks before and after the current bio bank in the ordered set where UUID &ne; &#63;.
	 *
	 * @param biobankId the primary key of the current bio bank
	 * @param UUID the u u i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bio bank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a bio bank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank[] findByNotUUID_PrevAndNext(long biobankId, String UUID,
		OrderByComparator orderByComparator)
		throws NoSuchBioBankException, SystemException {
		BioBank bioBank = findByPrimaryKey(biobankId);

		Session session = null;

		try {
			session = openSession();

			BioBank[] array = new BioBankImpl[3];

			array[0] = getByNotUUID_PrevAndNext(session, bioBank, UUID,
					orderByComparator, true);

			array[1] = bioBank;

			array[2] = getByNotUUID_PrevAndNext(session, bioBank, UUID,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BioBank getByNotUUID_PrevAndNext(Session session,
		BioBank bioBank, String UUID, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BIOBANK_WHERE);

		boolean bindUUID = false;

		if (UUID == null) {
			query.append(_FINDER_COLUMN_NOTUUID_UUID_1);
		}
		else if (UUID.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NOTUUID_UUID_3);
		}
		else {
			bindUUID = true;

			query.append(_FINDER_COLUMN_NOTUUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(BioBankModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUUID) {
			qPos.add(UUID);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bioBank);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BioBank> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bio banks where UUID &ne; &#63; from the database.
	 *
	 * @param UUID the u u i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNotUUID(String UUID) throws SystemException {
		for (BioBank bioBank : findByNotUUID(UUID, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(bioBank);
		}
	}

	/**
	 * Returns the number of bio banks where UUID &ne; &#63;.
	 *
	 * @param UUID the u u i d
	 * @return the number of matching bio banks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNotUUID(String UUID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOTUUID;

		Object[] finderArgs = new Object[] { UUID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BIOBANK_WHERE);

			boolean bindUUID = false;

			if (UUID == null) {
				query.append(_FINDER_COLUMN_NOTUUID_UUID_1);
			}
			else if (UUID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOTUUID_UUID_3);
			}
			else {
				bindUUID = true;

				query.append(_FINDER_COLUMN_NOTUUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUUID) {
					qPos.add(UUID);
				}

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

	private static final String _FINDER_COLUMN_NOTUUID_UUID_1 = "bioBank.UUID IS NOT NULL";
	private static final String _FINDER_COLUMN_NOTUUID_UUID_2 = "bioBank.UUID != ?";
	private static final String _FINDER_COLUMN_NOTUUID_UUID_3 = "(bioBank.UUID IS NULL OR bioBank.UUID != '')";

	public BioBankPersistenceImpl() {
		setModelClass(BioBank.class);
	}

	/**
	 * Caches the bio bank in the entity cache if it is enabled.
	 *
	 * @param bioBank the bio bank
	 */
	@Override
	public void cacheResult(BioBank bioBank) {
		EntityCacheUtil.putResult(BioBankModelImpl.ENTITY_CACHE_ENABLED,
			BioBankImpl.class, bioBank.getPrimaryKey(), bioBank);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LADPBIOBANKID,
			new Object[] { bioBank.getLdapbiobankID() }, bioBank);

		bioBank.resetOriginalValues();
	}

	/**
	 * Caches the bio banks in the entity cache if it is enabled.
	 *
	 * @param bioBanks the bio banks
	 */
	@Override
	public void cacheResult(List<BioBank> bioBanks) {
		for (BioBank bioBank : bioBanks) {
			if (EntityCacheUtil.getResult(
						BioBankModelImpl.ENTITY_CACHE_ENABLED,
						BioBankImpl.class, bioBank.getPrimaryKey()) == null) {
				cacheResult(bioBank);
			}
			else {
				bioBank.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bio banks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BioBankImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BioBankImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bio bank.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BioBank bioBank) {
		EntityCacheUtil.removeResult(BioBankModelImpl.ENTITY_CACHE_ENABLED,
			BioBankImpl.class, bioBank.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(bioBank);
	}

	@Override
	public void clearCache(List<BioBank> bioBanks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BioBank bioBank : bioBanks) {
			EntityCacheUtil.removeResult(BioBankModelImpl.ENTITY_CACHE_ENABLED,
				BioBankImpl.class, bioBank.getPrimaryKey());

			clearUniqueFindersCache(bioBank);
		}
	}

	protected void cacheUniqueFindersCache(BioBank bioBank) {
		if (bioBank.isNew()) {
			Object[] args = new Object[] { bioBank.getLdapbiobankID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LADPBIOBANKID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LADPBIOBANKID, args,
				bioBank);
		}
		else {
			BioBankModelImpl bioBankModelImpl = (BioBankModelImpl)bioBank;

			if ((bioBankModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LADPBIOBANKID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { bioBank.getLdapbiobankID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LADPBIOBANKID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LADPBIOBANKID,
					args, bioBank);
			}
		}
	}

	protected void clearUniqueFindersCache(BioBank bioBank) {
		BioBankModelImpl bioBankModelImpl = (BioBankModelImpl)bioBank;

		Object[] args = new Object[] { bioBank.getLdapbiobankID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LADPBIOBANKID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LADPBIOBANKID, args);

		if ((bioBankModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LADPBIOBANKID.getColumnBitmask()) != 0) {
			args = new Object[] { bioBankModelImpl.getOriginalLdapbiobankID() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LADPBIOBANKID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LADPBIOBANKID,
				args);
		}
	}

	/**
	 * Creates a new bio bank with the primary key. Does not add the bio bank to the database.
	 *
	 * @param biobankId the primary key for the new bio bank
	 * @return the new bio bank
	 */
	@Override
	public BioBank create(long biobankId) {
		BioBank bioBank = new BioBankImpl();

		bioBank.setNew(true);
		bioBank.setPrimaryKey(biobankId);

		return bioBank;
	}

	/**
	 * Removes the bio bank with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param biobankId the primary key of the bio bank
	 * @return the bio bank that was removed
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a bio bank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank remove(long biobankId)
		throws NoSuchBioBankException, SystemException {
		return remove((Serializable)biobankId);
	}

	/**
	 * Removes the bio bank with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bio bank
	 * @return the bio bank that was removed
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a bio bank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank remove(Serializable primaryKey)
		throws NoSuchBioBankException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BioBank bioBank = (BioBank)session.get(BioBankImpl.class, primaryKey);

			if (bioBank == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBioBankException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bioBank);
		}
		catch (NoSuchBioBankException nsee) {
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
	protected BioBank removeImpl(BioBank bioBank) throws SystemException {
		bioBank = toUnwrappedModel(bioBank);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bioBank)) {
				bioBank = (BioBank)session.get(BioBankImpl.class,
						bioBank.getPrimaryKeyObj());
			}

			if (bioBank != null) {
				session.delete(bioBank);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bioBank != null) {
			clearCache(bioBank);
		}

		return bioBank;
	}

	@Override
	public BioBank updateImpl(
		at.meduni.liferay.portlet.bbmrieric.model.BioBank bioBank)
		throws SystemException {
		bioBank = toUnwrappedModel(bioBank);

		boolean isNew = bioBank.isNew();

		BioBankModelImpl bioBankModelImpl = (BioBankModelImpl)bioBank;

		Session session = null;

		try {
			session = openSession();

			if (bioBank.isNew()) {
				session.save(bioBank);

				bioBank.setNew(false);
			}
			else {
				session.merge(bioBank);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BioBankModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bioBankModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKCOUNTRY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bioBankModelImpl.getOriginalBiobankcountry()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIOBANKCOUNTRY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKCOUNTRY,
					args);

				args = new Object[] { bioBankModelImpl.getBiobankcountry() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIOBANKCOUNTRY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIOBANKCOUNTRY,
					args);
			}
		}

		EntityCacheUtil.putResult(BioBankModelImpl.ENTITY_CACHE_ENABLED,
			BioBankImpl.class, bioBank.getPrimaryKey(), bioBank);

		clearUniqueFindersCache(bioBank);
		cacheUniqueFindersCache(bioBank);

		return bioBank;
	}

	protected BioBank toUnwrappedModel(BioBank bioBank) {
		if (bioBank instanceof BioBankImpl) {
			return bioBank;
		}

		BioBankImpl bioBankImpl = new BioBankImpl();

		bioBankImpl.setNew(bioBank.isNew());
		bioBankImpl.setPrimaryKey(bioBank.getPrimaryKey());

		bioBankImpl.setBiobankId(bioBank.getBiobankId());
		bioBankImpl.setOrganisationid(bioBank.getOrganisationid());
		bioBankImpl.setLdapbiobankID(bioBank.getLdapbiobankID());
		bioBankImpl.setBiobankcountry(bioBank.getBiobankcountry());
		bioBankImpl.setBiobankname(bioBank.getBiobankname());
		bioBankImpl.setBiobanktype(bioBank.getBiobanktype());
		bioBankImpl.setBiobanksize(bioBank.getBiobanksize());
		bioBankImpl.setBiobankdescription(bioBank.getBiobankdescription());
		bioBankImpl.setBiobankjuristicperson(bioBank.getBiobankjuristicperson());
		bioBankImpl.setUUID(bioBank.getUUID());

		return bioBankImpl;
	}

	/**
	 * Returns the bio bank with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bio bank
	 * @return the bio bank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a bio bank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBioBankException, SystemException {
		BioBank bioBank = fetchByPrimaryKey(primaryKey);

		if (bioBank == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBioBankException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bioBank;
	}

	/**
	 * Returns the bio bank with the primary key or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException} if it could not be found.
	 *
	 * @param biobankId the primary key of the bio bank
	 * @return the bio bank
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchBioBankException if a bio bank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank findByPrimaryKey(long biobankId)
		throws NoSuchBioBankException, SystemException {
		return findByPrimaryKey((Serializable)biobankId);
	}

	/**
	 * Returns the bio bank with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bio bank
	 * @return the bio bank, or <code>null</code> if a bio bank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BioBank bioBank = (BioBank)EntityCacheUtil.getResult(BioBankModelImpl.ENTITY_CACHE_ENABLED,
				BioBankImpl.class, primaryKey);

		if (bioBank == _nullBioBank) {
			return null;
		}

		if (bioBank == null) {
			Session session = null;

			try {
				session = openSession();

				bioBank = (BioBank)session.get(BioBankImpl.class, primaryKey);

				if (bioBank != null) {
					cacheResult(bioBank);
				}
				else {
					EntityCacheUtil.putResult(BioBankModelImpl.ENTITY_CACHE_ENABLED,
						BioBankImpl.class, primaryKey, _nullBioBank);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BioBankModelImpl.ENTITY_CACHE_ENABLED,
					BioBankImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bioBank;
	}

	/**
	 * Returns the bio bank with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param biobankId the primary key of the bio bank
	 * @return the bio bank, or <code>null</code> if a bio bank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BioBank fetchByPrimaryKey(long biobankId) throws SystemException {
		return fetchByPrimaryKey((Serializable)biobankId);
	}

	/**
	 * Returns all the bio banks.
	 *
	 * @return the bio banks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BioBank> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bio banks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bio banks
	 * @param end the upper bound of the range of bio banks (not inclusive)
	 * @return the range of bio banks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BioBank> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bio banks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.BioBankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bio banks
	 * @param end the upper bound of the range of bio banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bio banks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BioBank> findAll(int start, int end,
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

		List<BioBank> list = (List<BioBank>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BIOBANK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BIOBANK;

				if (pagination) {
					sql = sql.concat(BioBankModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BioBank>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BioBank>(list);
				}
				else {
					list = (List<BioBank>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the bio banks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BioBank bioBank : findAll()) {
			remove(bioBank);
		}
	}

	/**
	 * Returns the number of bio banks.
	 *
	 * @return the number of bio banks
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

				Query q = session.createQuery(_SQL_COUNT_BIOBANK);

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
	 * Initializes the bio bank persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.liferay.portlet.bbmrieric.model.BioBank")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BioBank>> listenersList = new ArrayList<ModelListener<BioBank>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BioBank>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BioBankImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BIOBANK = "SELECT bioBank FROM BioBank bioBank";
	private static final String _SQL_SELECT_BIOBANK_WHERE = "SELECT bioBank FROM BioBank bioBank WHERE ";
	private static final String _SQL_COUNT_BIOBANK = "SELECT COUNT(bioBank) FROM BioBank bioBank";
	private static final String _SQL_COUNT_BIOBANK_WHERE = "SELECT COUNT(bioBank) FROM BioBank bioBank WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bioBank.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BioBank exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BioBank exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BioBankPersistenceImpl.class);
	private static BioBank _nullBioBank = new BioBankImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BioBank> toCacheModel() {
				return _nullBioBankCacheModel;
			}
		};

	private static CacheModel<BioBank> _nullBioBankCacheModel = new CacheModel<BioBank>() {
			@Override
			public BioBank toEntityModel() {
				return _nullBioBank;
			}
		};
}