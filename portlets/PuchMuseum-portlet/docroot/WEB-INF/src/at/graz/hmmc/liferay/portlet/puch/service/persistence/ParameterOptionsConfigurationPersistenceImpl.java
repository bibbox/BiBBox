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

package at.graz.hmmc.liferay.portlet.puch.service.persistence;

import at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException;
import at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration;
import at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterOptionsConfigurationImpl;
import at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterOptionsConfigurationModelImpl;

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
 * The persistence implementation for the parameter options configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ParameterOptionsConfigurationPersistence
 * @see ParameterOptionsConfigurationUtil
 * @generated
 */
public class ParameterOptionsConfigurationPersistenceImpl
	extends BasePersistenceImpl<ParameterOptionsConfiguration>
	implements ParameterOptionsConfigurationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ParameterOptionsConfigurationUtil} to access the parameter options configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ParameterOptionsConfigurationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ParameterOptionsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ParameterOptionsConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ParameterOptionsConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ParameterOptionsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ParameterOptionsConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ParameterOptionsConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ParameterOptionsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ParameterOptionsConfigurationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OPTIONSFORPARAMETER =
		new FinderPath(ParameterOptionsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ParameterOptionsConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ParameterOptionsConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOptionsForParameter",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFORPARAMETER =
		new FinderPath(ParameterOptionsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ParameterOptionsConfigurationModelImpl.FINDER_CACHE_ENABLED,
			ParameterOptionsConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOptionsForParameter", new String[] { Long.class.getName() },
			ParameterOptionsConfigurationModelImpl.PARAMETERCONFIGURATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OPTIONSFORPARAMETER = new FinderPath(ParameterOptionsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ParameterOptionsConfigurationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOptionsForParameter", new String[] { Long.class.getName() });

	/**
	 * Returns all the parameter options configurations where parameterconfigurationId = &#63;.
	 *
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @return the matching parameter options configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ParameterOptionsConfiguration> findByOptionsForParameter(
		long parameterconfigurationId) throws SystemException {
		return findByOptionsForParameter(parameterconfigurationId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the parameter options configurations where parameterconfigurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterOptionsConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @param start the lower bound of the range of parameter options configurations
	 * @param end the upper bound of the range of parameter options configurations (not inclusive)
	 * @return the range of matching parameter options configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ParameterOptionsConfiguration> findByOptionsForParameter(
		long parameterconfigurationId, int start, int end)
		throws SystemException {
		return findByOptionsForParameter(parameterconfigurationId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the parameter options configurations where parameterconfigurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterOptionsConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @param start the lower bound of the range of parameter options configurations
	 * @param end the upper bound of the range of parameter options configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching parameter options configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ParameterOptionsConfiguration> findByOptionsForParameter(
		long parameterconfigurationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFORPARAMETER;
			finderArgs = new Object[] { parameterconfigurationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OPTIONSFORPARAMETER;
			finderArgs = new Object[] {
					parameterconfigurationId,
					
					start, end, orderByComparator
				};
		}

		List<ParameterOptionsConfiguration> list = (List<ParameterOptionsConfiguration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ParameterOptionsConfiguration parameterOptionsConfiguration : list) {
				if ((parameterconfigurationId != parameterOptionsConfiguration.getParameterconfigurationId())) {
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

			query.append(_SQL_SELECT_PARAMETEROPTIONSCONFIGURATION_WHERE);

			query.append(_FINDER_COLUMN_OPTIONSFORPARAMETER_PARAMETERCONFIGURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ParameterOptionsConfigurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parameterconfigurationId);

				if (!pagination) {
					list = (List<ParameterOptionsConfiguration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ParameterOptionsConfiguration>(list);
				}
				else {
					list = (List<ParameterOptionsConfiguration>)QueryUtil.list(q,
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
	 * Returns the first parameter options configuration in the ordered set where parameterconfigurationId = &#63;.
	 *
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter options configuration
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException if a matching parameter options configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParameterOptionsConfiguration findByOptionsForParameter_First(
		long parameterconfigurationId, OrderByComparator orderByComparator)
		throws NoSuchParameterOptionsConfigurationException, SystemException {
		ParameterOptionsConfiguration parameterOptionsConfiguration = fetchByOptionsForParameter_First(parameterconfigurationId,
				orderByComparator);

		if (parameterOptionsConfiguration != null) {
			return parameterOptionsConfiguration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parameterconfigurationId=");
		msg.append(parameterconfigurationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchParameterOptionsConfigurationException(msg.toString());
	}

	/**
	 * Returns the first parameter options configuration in the ordered set where parameterconfigurationId = &#63;.
	 *
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching parameter options configuration, or <code>null</code> if a matching parameter options configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParameterOptionsConfiguration fetchByOptionsForParameter_First(
		long parameterconfigurationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ParameterOptionsConfiguration> list = findByOptionsForParameter(parameterconfigurationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last parameter options configuration in the ordered set where parameterconfigurationId = &#63;.
	 *
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter options configuration
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException if a matching parameter options configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParameterOptionsConfiguration findByOptionsForParameter_Last(
		long parameterconfigurationId, OrderByComparator orderByComparator)
		throws NoSuchParameterOptionsConfigurationException, SystemException {
		ParameterOptionsConfiguration parameterOptionsConfiguration = fetchByOptionsForParameter_Last(parameterconfigurationId,
				orderByComparator);

		if (parameterOptionsConfiguration != null) {
			return parameterOptionsConfiguration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parameterconfigurationId=");
		msg.append(parameterconfigurationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchParameterOptionsConfigurationException(msg.toString());
	}

	/**
	 * Returns the last parameter options configuration in the ordered set where parameterconfigurationId = &#63;.
	 *
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching parameter options configuration, or <code>null</code> if a matching parameter options configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParameterOptionsConfiguration fetchByOptionsForParameter_Last(
		long parameterconfigurationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByOptionsForParameter(parameterconfigurationId);

		if (count == 0) {
			return null;
		}

		List<ParameterOptionsConfiguration> list = findByOptionsForParameter(parameterconfigurationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the parameter options configurations before and after the current parameter options configuration in the ordered set where parameterconfigurationId = &#63;.
	 *
	 * @param parameteroptionsconfigurationId the primary key of the current parameter options configuration
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next parameter options configuration
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException if a parameter options configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParameterOptionsConfiguration[] findByOptionsForParameter_PrevAndNext(
		long parameteroptionsconfigurationId, long parameterconfigurationId,
		OrderByComparator orderByComparator)
		throws NoSuchParameterOptionsConfigurationException, SystemException {
		ParameterOptionsConfiguration parameterOptionsConfiguration = findByPrimaryKey(parameteroptionsconfigurationId);

		Session session = null;

		try {
			session = openSession();

			ParameterOptionsConfiguration[] array = new ParameterOptionsConfigurationImpl[3];

			array[0] = getByOptionsForParameter_PrevAndNext(session,
					parameterOptionsConfiguration, parameterconfigurationId,
					orderByComparator, true);

			array[1] = parameterOptionsConfiguration;

			array[2] = getByOptionsForParameter_PrevAndNext(session,
					parameterOptionsConfiguration, parameterconfigurationId,
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

	protected ParameterOptionsConfiguration getByOptionsForParameter_PrevAndNext(
		Session session,
		ParameterOptionsConfiguration parameterOptionsConfiguration,
		long parameterconfigurationId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PARAMETEROPTIONSCONFIGURATION_WHERE);

		query.append(_FINDER_COLUMN_OPTIONSFORPARAMETER_PARAMETERCONFIGURATIONID_2);

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
			query.append(ParameterOptionsConfigurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parameterconfigurationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(parameterOptionsConfiguration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ParameterOptionsConfiguration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the parameter options configurations where parameterconfigurationId = &#63; from the database.
	 *
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOptionsForParameter(long parameterconfigurationId)
		throws SystemException {
		for (ParameterOptionsConfiguration parameterOptionsConfiguration : findByOptionsForParameter(
				parameterconfigurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(parameterOptionsConfiguration);
		}
	}

	/**
	 * Returns the number of parameter options configurations where parameterconfigurationId = &#63;.
	 *
	 * @param parameterconfigurationId the parameterconfiguration ID
	 * @return the number of matching parameter options configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOptionsForParameter(long parameterconfigurationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OPTIONSFORPARAMETER;

		Object[] finderArgs = new Object[] { parameterconfigurationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PARAMETEROPTIONSCONFIGURATION_WHERE);

			query.append(_FINDER_COLUMN_OPTIONSFORPARAMETER_PARAMETERCONFIGURATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parameterconfigurationId);

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

	private static final String _FINDER_COLUMN_OPTIONSFORPARAMETER_PARAMETERCONFIGURATIONID_2 =
		"parameterOptionsConfiguration.parameterconfigurationId = ?";

	public ParameterOptionsConfigurationPersistenceImpl() {
		setModelClass(ParameterOptionsConfiguration.class);
	}

	/**
	 * Caches the parameter options configuration in the entity cache if it is enabled.
	 *
	 * @param parameterOptionsConfiguration the parameter options configuration
	 */
	@Override
	public void cacheResult(
		ParameterOptionsConfiguration parameterOptionsConfiguration) {
		EntityCacheUtil.putResult(ParameterOptionsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ParameterOptionsConfigurationImpl.class,
			parameterOptionsConfiguration.getPrimaryKey(),
			parameterOptionsConfiguration);

		parameterOptionsConfiguration.resetOriginalValues();
	}

	/**
	 * Caches the parameter options configurations in the entity cache if it is enabled.
	 *
	 * @param parameterOptionsConfigurations the parameter options configurations
	 */
	@Override
	public void cacheResult(
		List<ParameterOptionsConfiguration> parameterOptionsConfigurations) {
		for (ParameterOptionsConfiguration parameterOptionsConfiguration : parameterOptionsConfigurations) {
			if (EntityCacheUtil.getResult(
						ParameterOptionsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						ParameterOptionsConfigurationImpl.class,
						parameterOptionsConfiguration.getPrimaryKey()) == null) {
				cacheResult(parameterOptionsConfiguration);
			}
			else {
				parameterOptionsConfiguration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all parameter options configurations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ParameterOptionsConfigurationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ParameterOptionsConfigurationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the parameter options configuration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ParameterOptionsConfiguration parameterOptionsConfiguration) {
		EntityCacheUtil.removeResult(ParameterOptionsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ParameterOptionsConfigurationImpl.class,
			parameterOptionsConfiguration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ParameterOptionsConfiguration> parameterOptionsConfigurations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ParameterOptionsConfiguration parameterOptionsConfiguration : parameterOptionsConfigurations) {
			EntityCacheUtil.removeResult(ParameterOptionsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				ParameterOptionsConfigurationImpl.class,
				parameterOptionsConfiguration.getPrimaryKey());
		}
	}

	/**
	 * Creates a new parameter options configuration with the primary key. Does not add the parameter options configuration to the database.
	 *
	 * @param parameteroptionsconfigurationId the primary key for the new parameter options configuration
	 * @return the new parameter options configuration
	 */
	@Override
	public ParameterOptionsConfiguration create(
		long parameteroptionsconfigurationId) {
		ParameterOptionsConfiguration parameterOptionsConfiguration = new ParameterOptionsConfigurationImpl();

		parameterOptionsConfiguration.setNew(true);
		parameterOptionsConfiguration.setPrimaryKey(parameteroptionsconfigurationId);

		return parameterOptionsConfiguration;
	}

	/**
	 * Removes the parameter options configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parameteroptionsconfigurationId the primary key of the parameter options configuration
	 * @return the parameter options configuration that was removed
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException if a parameter options configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParameterOptionsConfiguration remove(
		long parameteroptionsconfigurationId)
		throws NoSuchParameterOptionsConfigurationException, SystemException {
		return remove((Serializable)parameteroptionsconfigurationId);
	}

	/**
	 * Removes the parameter options configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the parameter options configuration
	 * @return the parameter options configuration that was removed
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException if a parameter options configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParameterOptionsConfiguration remove(Serializable primaryKey)
		throws NoSuchParameterOptionsConfigurationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ParameterOptionsConfiguration parameterOptionsConfiguration = (ParameterOptionsConfiguration)session.get(ParameterOptionsConfigurationImpl.class,
					primaryKey);

			if (parameterOptionsConfiguration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchParameterOptionsConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(parameterOptionsConfiguration);
		}
		catch (NoSuchParameterOptionsConfigurationException nsee) {
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
	protected ParameterOptionsConfiguration removeImpl(
		ParameterOptionsConfiguration parameterOptionsConfiguration)
		throws SystemException {
		parameterOptionsConfiguration = toUnwrappedModel(parameterOptionsConfiguration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(parameterOptionsConfiguration)) {
				parameterOptionsConfiguration = (ParameterOptionsConfiguration)session.get(ParameterOptionsConfigurationImpl.class,
						parameterOptionsConfiguration.getPrimaryKeyObj());
			}

			if (parameterOptionsConfiguration != null) {
				session.delete(parameterOptionsConfiguration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (parameterOptionsConfiguration != null) {
			clearCache(parameterOptionsConfiguration);
		}

		return parameterOptionsConfiguration;
	}

	@Override
	public ParameterOptionsConfiguration updateImpl(
		at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration parameterOptionsConfiguration)
		throws SystemException {
		parameterOptionsConfiguration = toUnwrappedModel(parameterOptionsConfiguration);

		boolean isNew = parameterOptionsConfiguration.isNew();

		ParameterOptionsConfigurationModelImpl parameterOptionsConfigurationModelImpl =
			(ParameterOptionsConfigurationModelImpl)parameterOptionsConfiguration;

		Session session = null;

		try {
			session = openSession();

			if (parameterOptionsConfiguration.isNew()) {
				session.save(parameterOptionsConfiguration);

				parameterOptionsConfiguration.setNew(false);
			}
			else {
				session.merge(parameterOptionsConfiguration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!ParameterOptionsConfigurationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((parameterOptionsConfigurationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFORPARAMETER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						parameterOptionsConfigurationModelImpl.getOriginalParameterconfigurationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONSFORPARAMETER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFORPARAMETER,
					args);

				args = new Object[] {
						parameterOptionsConfigurationModelImpl.getParameterconfigurationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPTIONSFORPARAMETER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPTIONSFORPARAMETER,
					args);
			}
		}

		EntityCacheUtil.putResult(ParameterOptionsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			ParameterOptionsConfigurationImpl.class,
			parameterOptionsConfiguration.getPrimaryKey(),
			parameterOptionsConfiguration);

		return parameterOptionsConfiguration;
	}

	protected ParameterOptionsConfiguration toUnwrappedModel(
		ParameterOptionsConfiguration parameterOptionsConfiguration) {
		if (parameterOptionsConfiguration instanceof ParameterOptionsConfigurationImpl) {
			return parameterOptionsConfiguration;
		}

		ParameterOptionsConfigurationImpl parameterOptionsConfigurationImpl = new ParameterOptionsConfigurationImpl();

		parameterOptionsConfigurationImpl.setNew(parameterOptionsConfiguration.isNew());
		parameterOptionsConfigurationImpl.setPrimaryKey(parameterOptionsConfiguration.getPrimaryKey());

		parameterOptionsConfigurationImpl.setParameteroptionsconfigurationId(parameterOptionsConfiguration.getParameteroptionsconfigurationId());
		parameterOptionsConfigurationImpl.setParameterconfigurationId(parameterOptionsConfiguration.getParameterconfigurationId());
		parameterOptionsConfigurationImpl.setOptionkey(parameterOptionsConfiguration.getOptionkey());
		parameterOptionsConfigurationImpl.setOptionvalue(parameterOptionsConfiguration.getOptionvalue());

		return parameterOptionsConfigurationImpl;
	}

	/**
	 * Returns the parameter options configuration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the parameter options configuration
	 * @return the parameter options configuration
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException if a parameter options configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParameterOptionsConfiguration findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchParameterOptionsConfigurationException, SystemException {
		ParameterOptionsConfiguration parameterOptionsConfiguration = fetchByPrimaryKey(primaryKey);

		if (parameterOptionsConfiguration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchParameterOptionsConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return parameterOptionsConfiguration;
	}

	/**
	 * Returns the parameter options configuration with the primary key or throws a {@link at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException} if it could not be found.
	 *
	 * @param parameteroptionsconfigurationId the primary key of the parameter options configuration
	 * @return the parameter options configuration
	 * @throws at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException if a parameter options configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParameterOptionsConfiguration findByPrimaryKey(
		long parameteroptionsconfigurationId)
		throws NoSuchParameterOptionsConfigurationException, SystemException {
		return findByPrimaryKey((Serializable)parameteroptionsconfigurationId);
	}

	/**
	 * Returns the parameter options configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the parameter options configuration
	 * @return the parameter options configuration, or <code>null</code> if a parameter options configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParameterOptionsConfiguration fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		ParameterOptionsConfiguration parameterOptionsConfiguration = (ParameterOptionsConfiguration)EntityCacheUtil.getResult(ParameterOptionsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				ParameterOptionsConfigurationImpl.class, primaryKey);

		if (parameterOptionsConfiguration == _nullParameterOptionsConfiguration) {
			return null;
		}

		if (parameterOptionsConfiguration == null) {
			Session session = null;

			try {
				session = openSession();

				parameterOptionsConfiguration = (ParameterOptionsConfiguration)session.get(ParameterOptionsConfigurationImpl.class,
						primaryKey);

				if (parameterOptionsConfiguration != null) {
					cacheResult(parameterOptionsConfiguration);
				}
				else {
					EntityCacheUtil.putResult(ParameterOptionsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						ParameterOptionsConfigurationImpl.class, primaryKey,
						_nullParameterOptionsConfiguration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ParameterOptionsConfigurationModelImpl.ENTITY_CACHE_ENABLED,
					ParameterOptionsConfigurationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return parameterOptionsConfiguration;
	}

	/**
	 * Returns the parameter options configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param parameteroptionsconfigurationId the primary key of the parameter options configuration
	 * @return the parameter options configuration, or <code>null</code> if a parameter options configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParameterOptionsConfiguration fetchByPrimaryKey(
		long parameteroptionsconfigurationId) throws SystemException {
		return fetchByPrimaryKey((Serializable)parameteroptionsconfigurationId);
	}

	/**
	 * Returns all the parameter options configurations.
	 *
	 * @return the parameter options configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ParameterOptionsConfiguration> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the parameter options configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterOptionsConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of parameter options configurations
	 * @param end the upper bound of the range of parameter options configurations (not inclusive)
	 * @return the range of parameter options configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ParameterOptionsConfiguration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the parameter options configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterOptionsConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of parameter options configurations
	 * @param end the upper bound of the range of parameter options configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of parameter options configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ParameterOptionsConfiguration> findAll(int start, int end,
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

		List<ParameterOptionsConfiguration> list = (List<ParameterOptionsConfiguration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PARAMETEROPTIONSCONFIGURATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PARAMETEROPTIONSCONFIGURATION;

				if (pagination) {
					sql = sql.concat(ParameterOptionsConfigurationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ParameterOptionsConfiguration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ParameterOptionsConfiguration>(list);
				}
				else {
					list = (List<ParameterOptionsConfiguration>)QueryUtil.list(q,
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
	 * Removes all the parameter options configurations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ParameterOptionsConfiguration parameterOptionsConfiguration : findAll()) {
			remove(parameterOptionsConfiguration);
		}
	}

	/**
	 * Returns the number of parameter options configurations.
	 *
	 * @return the number of parameter options configurations
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

				Query q = session.createQuery(_SQL_COUNT_PARAMETEROPTIONSCONFIGURATION);

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
	 * Initializes the parameter options configuration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfiguration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ParameterOptionsConfiguration>> listenersList =
					new ArrayList<ModelListener<ParameterOptionsConfiguration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ParameterOptionsConfiguration>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ParameterOptionsConfigurationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PARAMETEROPTIONSCONFIGURATION = "SELECT parameterOptionsConfiguration FROM ParameterOptionsConfiguration parameterOptionsConfiguration";
	private static final String _SQL_SELECT_PARAMETEROPTIONSCONFIGURATION_WHERE = "SELECT parameterOptionsConfiguration FROM ParameterOptionsConfiguration parameterOptionsConfiguration WHERE ";
	private static final String _SQL_COUNT_PARAMETEROPTIONSCONFIGURATION = "SELECT COUNT(parameterOptionsConfiguration) FROM ParameterOptionsConfiguration parameterOptionsConfiguration";
	private static final String _SQL_COUNT_PARAMETEROPTIONSCONFIGURATION_WHERE = "SELECT COUNT(parameterOptionsConfiguration) FROM ParameterOptionsConfiguration parameterOptionsConfiguration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "parameterOptionsConfiguration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ParameterOptionsConfiguration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ParameterOptionsConfiguration exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ParameterOptionsConfigurationPersistenceImpl.class);
	private static ParameterOptionsConfiguration _nullParameterOptionsConfiguration =
		new ParameterOptionsConfigurationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ParameterOptionsConfiguration> toCacheModel() {
				return _nullParameterOptionsConfigurationCacheModel;
			}
		};

	private static CacheModel<ParameterOptionsConfiguration> _nullParameterOptionsConfigurationCacheModel =
		new CacheModel<ParameterOptionsConfiguration>() {
			@Override
			public ParameterOptionsConfiguration toEntityModel() {
				return _nullParameterOptionsConfiguration;
			}
		};
}