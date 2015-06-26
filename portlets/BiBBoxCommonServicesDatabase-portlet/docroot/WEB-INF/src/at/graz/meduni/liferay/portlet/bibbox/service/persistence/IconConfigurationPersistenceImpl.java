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

package at.graz.meduni.liferay.portlet.bibbox.service.persistence;

import at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException;
import at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationImpl;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the icon configuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see IconConfigurationPersistence
 * @see IconConfigurationUtil
 * @generated
 */
public class IconConfigurationPersistenceImpl extends BasePersistenceImpl<IconConfiguration>
	implements IconConfigurationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link IconConfigurationUtil} to access the icon configuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = IconConfigurationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationModelImpl.FINDER_CACHE_ENABLED,
			IconConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationModelImpl.FINDER_CACHE_ENABLED,
			IconConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ICONSPOSITION =
		new FinderPath(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationModelImpl.FINDER_CACHE_ENABLED,
			IconConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIconsPosition",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ICONSPOSITION =
		new FinderPath(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationModelImpl.FINDER_CACHE_ENABLED,
			IconConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIconsPosition",
			new String[] { Long.class.getName(), String.class.getName() },
			IconConfigurationModelImpl.SYMBOLCONFIGURATIONID_COLUMN_BITMASK |
			IconConfigurationModelImpl.POSITION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ICONSPOSITION = new FinderPath(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIconsPosition",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the icon configurations where symbolconfigurationId = &#63; and position = &#63;.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param position the position
	 * @return the matching icon configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IconConfiguration> findByIconsPosition(
		long symbolconfigurationId, String position) throws SystemException {
		return findByIconsPosition(symbolconfigurationId, position,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the icon configurations where symbolconfigurationId = &#63; and position = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param position the position
	 * @param start the lower bound of the range of icon configurations
	 * @param end the upper bound of the range of icon configurations (not inclusive)
	 * @return the range of matching icon configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IconConfiguration> findByIconsPosition(
		long symbolconfigurationId, String position, int start, int end)
		throws SystemException {
		return findByIconsPosition(symbolconfigurationId, position, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the icon configurations where symbolconfigurationId = &#63; and position = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param position the position
	 * @param start the lower bound of the range of icon configurations
	 * @param end the upper bound of the range of icon configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching icon configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IconConfiguration> findByIconsPosition(
		long symbolconfigurationId, String position, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ICONSPOSITION;
			finderArgs = new Object[] { symbolconfigurationId, position };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ICONSPOSITION;
			finderArgs = new Object[] {
					symbolconfigurationId, position,
					
					start, end, orderByComparator
				};
		}

		List<IconConfiguration> list = (List<IconConfiguration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IconConfiguration iconConfiguration : list) {
				if ((symbolconfigurationId != iconConfiguration.getSymbolconfigurationId()) ||
						!Validator.equals(position,
							iconConfiguration.getPosition())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ICONCONFIGURATION_WHERE);

			query.append(_FINDER_COLUMN_ICONSPOSITION_SYMBOLCONFIGURATIONID_2);

			boolean bindPosition = false;

			if (position == null) {
				query.append(_FINDER_COLUMN_ICONSPOSITION_POSITION_1);
			}
			else if (position.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ICONSPOSITION_POSITION_3);
			}
			else {
				bindPosition = true;

				query.append(_FINDER_COLUMN_ICONSPOSITION_POSITION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IconConfigurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(symbolconfigurationId);

				if (bindPosition) {
					qPos.add(position);
				}

				if (!pagination) {
					list = (List<IconConfiguration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IconConfiguration>(list);
				}
				else {
					list = (List<IconConfiguration>)QueryUtil.list(q,
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
	 * Returns the first icon configuration in the ordered set where symbolconfigurationId = &#63; and position = &#63;.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param position the position
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icon configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a matching icon configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration findByIconsPosition_First(
		long symbolconfigurationId, String position,
		OrderByComparator orderByComparator)
		throws NoSuchIconConfigurationException, SystemException {
		IconConfiguration iconConfiguration = fetchByIconsPosition_First(symbolconfigurationId,
				position, orderByComparator);

		if (iconConfiguration != null) {
			return iconConfiguration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("symbolconfigurationId=");
		msg.append(symbolconfigurationId);

		msg.append(", position=");
		msg.append(position);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIconConfigurationException(msg.toString());
	}

	/**
	 * Returns the first icon configuration in the ordered set where symbolconfigurationId = &#63; and position = &#63;.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param position the position
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icon configuration, or <code>null</code> if a matching icon configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration fetchByIconsPosition_First(
		long symbolconfigurationId, String position,
		OrderByComparator orderByComparator) throws SystemException {
		List<IconConfiguration> list = findByIconsPosition(symbolconfigurationId,
				position, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last icon configuration in the ordered set where symbolconfigurationId = &#63; and position = &#63;.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param position the position
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icon configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a matching icon configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration findByIconsPosition_Last(
		long symbolconfigurationId, String position,
		OrderByComparator orderByComparator)
		throws NoSuchIconConfigurationException, SystemException {
		IconConfiguration iconConfiguration = fetchByIconsPosition_Last(symbolconfigurationId,
				position, orderByComparator);

		if (iconConfiguration != null) {
			return iconConfiguration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("symbolconfigurationId=");
		msg.append(symbolconfigurationId);

		msg.append(", position=");
		msg.append(position);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIconConfigurationException(msg.toString());
	}

	/**
	 * Returns the last icon configuration in the ordered set where symbolconfigurationId = &#63; and position = &#63;.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param position the position
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icon configuration, or <code>null</code> if a matching icon configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration fetchByIconsPosition_Last(
		long symbolconfigurationId, String position,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIconsPosition(symbolconfigurationId, position);

		if (count == 0) {
			return null;
		}

		List<IconConfiguration> list = findByIconsPosition(symbolconfigurationId,
				position, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the icon configurations before and after the current icon configuration in the ordered set where symbolconfigurationId = &#63; and position = &#63;.
	 *
	 * @param iconconfigurationId the primary key of the current icon configuration
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param position the position
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next icon configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a icon configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration[] findByIconsPosition_PrevAndNext(
		long iconconfigurationId, long symbolconfigurationId, String position,
		OrderByComparator orderByComparator)
		throws NoSuchIconConfigurationException, SystemException {
		IconConfiguration iconConfiguration = findByPrimaryKey(iconconfigurationId);

		Session session = null;

		try {
			session = openSession();

			IconConfiguration[] array = new IconConfigurationImpl[3];

			array[0] = getByIconsPosition_PrevAndNext(session,
					iconConfiguration, symbolconfigurationId, position,
					orderByComparator, true);

			array[1] = iconConfiguration;

			array[2] = getByIconsPosition_PrevAndNext(session,
					iconConfiguration, symbolconfigurationId, position,
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

	protected IconConfiguration getByIconsPosition_PrevAndNext(
		Session session, IconConfiguration iconConfiguration,
		long symbolconfigurationId, String position,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ICONCONFIGURATION_WHERE);

		query.append(_FINDER_COLUMN_ICONSPOSITION_SYMBOLCONFIGURATIONID_2);

		boolean bindPosition = false;

		if (position == null) {
			query.append(_FINDER_COLUMN_ICONSPOSITION_POSITION_1);
		}
		else if (position.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ICONSPOSITION_POSITION_3);
		}
		else {
			bindPosition = true;

			query.append(_FINDER_COLUMN_ICONSPOSITION_POSITION_2);
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
			query.append(IconConfigurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(symbolconfigurationId);

		if (bindPosition) {
			qPos.add(position);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(iconConfiguration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IconConfiguration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the icon configurations where symbolconfigurationId = &#63; and position = &#63; from the database.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param position the position
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByIconsPosition(long symbolconfigurationId,
		String position) throws SystemException {
		for (IconConfiguration iconConfiguration : findByIconsPosition(
				symbolconfigurationId, position, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(iconConfiguration);
		}
	}

	/**
	 * Returns the number of icon configurations where symbolconfigurationId = &#63; and position = &#63;.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param position the position
	 * @return the number of matching icon configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIconsPosition(long symbolconfigurationId, String position)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ICONSPOSITION;

		Object[] finderArgs = new Object[] { symbolconfigurationId, position };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ICONCONFIGURATION_WHERE);

			query.append(_FINDER_COLUMN_ICONSPOSITION_SYMBOLCONFIGURATIONID_2);

			boolean bindPosition = false;

			if (position == null) {
				query.append(_FINDER_COLUMN_ICONSPOSITION_POSITION_1);
			}
			else if (position.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ICONSPOSITION_POSITION_3);
			}
			else {
				bindPosition = true;

				query.append(_FINDER_COLUMN_ICONSPOSITION_POSITION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(symbolconfigurationId);

				if (bindPosition) {
					qPos.add(position);
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

	private static final String _FINDER_COLUMN_ICONSPOSITION_SYMBOLCONFIGURATIONID_2 =
		"iconConfiguration.symbolconfigurationId = ? AND ";
	private static final String _FINDER_COLUMN_ICONSPOSITION_POSITION_1 = "iconConfiguration.position IS NULL";
	private static final String _FINDER_COLUMN_ICONSPOSITION_POSITION_2 = "iconConfiguration.position = ?";
	private static final String _FINDER_COLUMN_ICONSPOSITION_POSITION_3 = "(iconConfiguration.position IS NULL OR iconConfiguration.position = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ICONSKEY = new FinderPath(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationModelImpl.FINDER_CACHE_ENABLED,
			IconConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIconsKey",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ICONSKEY =
		new FinderPath(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationModelImpl.FINDER_CACHE_ENABLED,
			IconConfigurationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIconsKey",
			new String[] { Long.class.getName(), String.class.getName() },
			IconConfigurationModelImpl.SYMBOLCONFIGURATIONID_COLUMN_BITMASK |
			IconConfigurationModelImpl.KEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ICONSKEY = new FinderPath(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIconsKey",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the icon configurations where symbolconfigurationId = &#63; and key = &#63;.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param key the key
	 * @return the matching icon configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IconConfiguration> findByIconsKey(long symbolconfigurationId,
		String key) throws SystemException {
		return findByIconsKey(symbolconfigurationId, key, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the icon configurations where symbolconfigurationId = &#63; and key = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param key the key
	 * @param start the lower bound of the range of icon configurations
	 * @param end the upper bound of the range of icon configurations (not inclusive)
	 * @return the range of matching icon configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IconConfiguration> findByIconsKey(long symbolconfigurationId,
		String key, int start, int end) throws SystemException {
		return findByIconsKey(symbolconfigurationId, key, start, end, null);
	}

	/**
	 * Returns an ordered range of all the icon configurations where symbolconfigurationId = &#63; and key = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param key the key
	 * @param start the lower bound of the range of icon configurations
	 * @param end the upper bound of the range of icon configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching icon configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IconConfiguration> findByIconsKey(long symbolconfigurationId,
		String key, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ICONSKEY;
			finderArgs = new Object[] { symbolconfigurationId, key };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ICONSKEY;
			finderArgs = new Object[] {
					symbolconfigurationId, key,
					
					start, end, orderByComparator
				};
		}

		List<IconConfiguration> list = (List<IconConfiguration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (IconConfiguration iconConfiguration : list) {
				if ((symbolconfigurationId != iconConfiguration.getSymbolconfigurationId()) ||
						!Validator.equals(key, iconConfiguration.getKey())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ICONCONFIGURATION_WHERE);

			query.append(_FINDER_COLUMN_ICONSKEY_SYMBOLCONFIGURATIONID_2);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_ICONSKEY_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ICONSKEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_ICONSKEY_KEY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(IconConfigurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(symbolconfigurationId);

				if (bindKey) {
					qPos.add(key);
				}

				if (!pagination) {
					list = (List<IconConfiguration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IconConfiguration>(list);
				}
				else {
					list = (List<IconConfiguration>)QueryUtil.list(q,
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
	 * Returns the first icon configuration in the ordered set where symbolconfigurationId = &#63; and key = &#63;.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param key the key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icon configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a matching icon configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration findByIconsKey_First(long symbolconfigurationId,
		String key, OrderByComparator orderByComparator)
		throws NoSuchIconConfigurationException, SystemException {
		IconConfiguration iconConfiguration = fetchByIconsKey_First(symbolconfigurationId,
				key, orderByComparator);

		if (iconConfiguration != null) {
			return iconConfiguration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("symbolconfigurationId=");
		msg.append(symbolconfigurationId);

		msg.append(", key=");
		msg.append(key);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIconConfigurationException(msg.toString());
	}

	/**
	 * Returns the first icon configuration in the ordered set where symbolconfigurationId = &#63; and key = &#63;.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param key the key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching icon configuration, or <code>null</code> if a matching icon configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration fetchByIconsKey_First(long symbolconfigurationId,
		String key, OrderByComparator orderByComparator)
		throws SystemException {
		List<IconConfiguration> list = findByIconsKey(symbolconfigurationId,
				key, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last icon configuration in the ordered set where symbolconfigurationId = &#63; and key = &#63;.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param key the key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icon configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a matching icon configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration findByIconsKey_Last(long symbolconfigurationId,
		String key, OrderByComparator orderByComparator)
		throws NoSuchIconConfigurationException, SystemException {
		IconConfiguration iconConfiguration = fetchByIconsKey_Last(symbolconfigurationId,
				key, orderByComparator);

		if (iconConfiguration != null) {
			return iconConfiguration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("symbolconfigurationId=");
		msg.append(symbolconfigurationId);

		msg.append(", key=");
		msg.append(key);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchIconConfigurationException(msg.toString());
	}

	/**
	 * Returns the last icon configuration in the ordered set where symbolconfigurationId = &#63; and key = &#63;.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param key the key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching icon configuration, or <code>null</code> if a matching icon configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration fetchByIconsKey_Last(long symbolconfigurationId,
		String key, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByIconsKey(symbolconfigurationId, key);

		if (count == 0) {
			return null;
		}

		List<IconConfiguration> list = findByIconsKey(symbolconfigurationId,
				key, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the icon configurations before and after the current icon configuration in the ordered set where symbolconfigurationId = &#63; and key = &#63;.
	 *
	 * @param iconconfigurationId the primary key of the current icon configuration
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param key the key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next icon configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a icon configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration[] findByIconsKey_PrevAndNext(
		long iconconfigurationId, long symbolconfigurationId, String key,
		OrderByComparator orderByComparator)
		throws NoSuchIconConfigurationException, SystemException {
		IconConfiguration iconConfiguration = findByPrimaryKey(iconconfigurationId);

		Session session = null;

		try {
			session = openSession();

			IconConfiguration[] array = new IconConfigurationImpl[3];

			array[0] = getByIconsKey_PrevAndNext(session, iconConfiguration,
					symbolconfigurationId, key, orderByComparator, true);

			array[1] = iconConfiguration;

			array[2] = getByIconsKey_PrevAndNext(session, iconConfiguration,
					symbolconfigurationId, key, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IconConfiguration getByIconsKey_PrevAndNext(Session session,
		IconConfiguration iconConfiguration, long symbolconfigurationId,
		String key, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ICONCONFIGURATION_WHERE);

		query.append(_FINDER_COLUMN_ICONSKEY_SYMBOLCONFIGURATIONID_2);

		boolean bindKey = false;

		if (key == null) {
			query.append(_FINDER_COLUMN_ICONSKEY_KEY_1);
		}
		else if (key.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ICONSKEY_KEY_3);
		}
		else {
			bindKey = true;

			query.append(_FINDER_COLUMN_ICONSKEY_KEY_2);
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
			query.append(IconConfigurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(symbolconfigurationId);

		if (bindKey) {
			qPos.add(key);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(iconConfiguration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IconConfiguration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the icon configurations where symbolconfigurationId = &#63; and key = &#63; from the database.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param key the key
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByIconsKey(long symbolconfigurationId, String key)
		throws SystemException {
		for (IconConfiguration iconConfiguration : findByIconsKey(
				symbolconfigurationId, key, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(iconConfiguration);
		}
	}

	/**
	 * Returns the number of icon configurations where symbolconfigurationId = &#63; and key = &#63;.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param key the key
	 * @return the number of matching icon configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIconsKey(long symbolconfigurationId, String key)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ICONSKEY;

		Object[] finderArgs = new Object[] { symbolconfigurationId, key };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ICONCONFIGURATION_WHERE);

			query.append(_FINDER_COLUMN_ICONSKEY_SYMBOLCONFIGURATIONID_2);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_ICONSKEY_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ICONSKEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_ICONSKEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(symbolconfigurationId);

				if (bindKey) {
					qPos.add(key);
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

	private static final String _FINDER_COLUMN_ICONSKEY_SYMBOLCONFIGURATIONID_2 = "iconConfiguration.symbolconfigurationId = ? AND ";
	private static final String _FINDER_COLUMN_ICONSKEY_KEY_1 = "iconConfiguration.key IS NULL";
	private static final String _FINDER_COLUMN_ICONSKEY_KEY_2 = "iconConfiguration.key = ?";
	private static final String _FINDER_COLUMN_ICONSKEY_KEY_3 = "(iconConfiguration.key IS NULL OR iconConfiguration.key = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_ICONSKEYPOSITION = new FinderPath(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationModelImpl.FINDER_CACHE_ENABLED,
			IconConfigurationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByIconsKeyPosition",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			IconConfigurationModelImpl.SYMBOLCONFIGURATIONID_COLUMN_BITMASK |
			IconConfigurationModelImpl.KEY_COLUMN_BITMASK |
			IconConfigurationModelImpl.POSITION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ICONSKEYPOSITION = new FinderPath(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIconsKeyPosition",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the icon configuration where symbolconfigurationId = &#63; and key = &#63; and position = &#63; or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException} if it could not be found.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param key the key
	 * @param position the position
	 * @return the matching icon configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a matching icon configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration findByIconsKeyPosition(
		long symbolconfigurationId, String key, String position)
		throws NoSuchIconConfigurationException, SystemException {
		IconConfiguration iconConfiguration = fetchByIconsKeyPosition(symbolconfigurationId,
				key, position);

		if (iconConfiguration == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("symbolconfigurationId=");
			msg.append(symbolconfigurationId);

			msg.append(", key=");
			msg.append(key);

			msg.append(", position=");
			msg.append(position);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchIconConfigurationException(msg.toString());
		}

		return iconConfiguration;
	}

	/**
	 * Returns the icon configuration where symbolconfigurationId = &#63; and key = &#63; and position = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param key the key
	 * @param position the position
	 * @return the matching icon configuration, or <code>null</code> if a matching icon configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration fetchByIconsKeyPosition(
		long symbolconfigurationId, String key, String position)
		throws SystemException {
		return fetchByIconsKeyPosition(symbolconfigurationId, key, position,
			true);
	}

	/**
	 * Returns the icon configuration where symbolconfigurationId = &#63; and key = &#63; and position = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param key the key
	 * @param position the position
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching icon configuration, or <code>null</code> if a matching icon configuration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration fetchByIconsKeyPosition(
		long symbolconfigurationId, String key, String position,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { symbolconfigurationId, key, position };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ICONSKEYPOSITION,
					finderArgs, this);
		}

		if (result instanceof IconConfiguration) {
			IconConfiguration iconConfiguration = (IconConfiguration)result;

			if ((symbolconfigurationId != iconConfiguration.getSymbolconfigurationId()) ||
					!Validator.equals(key, iconConfiguration.getKey()) ||
					!Validator.equals(position, iconConfiguration.getPosition())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_ICONCONFIGURATION_WHERE);

			query.append(_FINDER_COLUMN_ICONSKEYPOSITION_SYMBOLCONFIGURATIONID_2);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_ICONSKEYPOSITION_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ICONSKEYPOSITION_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_ICONSKEYPOSITION_KEY_2);
			}

			boolean bindPosition = false;

			if (position == null) {
				query.append(_FINDER_COLUMN_ICONSKEYPOSITION_POSITION_1);
			}
			else if (position.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ICONSKEYPOSITION_POSITION_3);
			}
			else {
				bindPosition = true;

				query.append(_FINDER_COLUMN_ICONSKEYPOSITION_POSITION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(symbolconfigurationId);

				if (bindKey) {
					qPos.add(key);
				}

				if (bindPosition) {
					qPos.add(position);
				}

				List<IconConfiguration> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ICONSKEYPOSITION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"IconConfigurationPersistenceImpl.fetchByIconsKeyPosition(long, String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					IconConfiguration iconConfiguration = list.get(0);

					result = iconConfiguration;

					cacheResult(iconConfiguration);

					if ((iconConfiguration.getSymbolconfigurationId() != symbolconfigurationId) ||
							(iconConfiguration.getKey() == null) ||
							!iconConfiguration.getKey().equals(key) ||
							(iconConfiguration.getPosition() == null) ||
							!iconConfiguration.getPosition().equals(position)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ICONSKEYPOSITION,
							finderArgs, iconConfiguration);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ICONSKEYPOSITION,
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
			return (IconConfiguration)result;
		}
	}

	/**
	 * Removes the icon configuration where symbolconfigurationId = &#63; and key = &#63; and position = &#63; from the database.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param key the key
	 * @param position the position
	 * @return the icon configuration that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration removeByIconsKeyPosition(
		long symbolconfigurationId, String key, String position)
		throws NoSuchIconConfigurationException, SystemException {
		IconConfiguration iconConfiguration = findByIconsKeyPosition(symbolconfigurationId,
				key, position);

		return remove(iconConfiguration);
	}

	/**
	 * Returns the number of icon configurations where symbolconfigurationId = &#63; and key = &#63; and position = &#63;.
	 *
	 * @param symbolconfigurationId the symbolconfiguration ID
	 * @param key the key
	 * @param position the position
	 * @return the number of matching icon configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIconsKeyPosition(long symbolconfigurationId, String key,
		String position) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ICONSKEYPOSITION;

		Object[] finderArgs = new Object[] { symbolconfigurationId, key, position };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_ICONCONFIGURATION_WHERE);

			query.append(_FINDER_COLUMN_ICONSKEYPOSITION_SYMBOLCONFIGURATIONID_2);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_ICONSKEYPOSITION_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ICONSKEYPOSITION_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_ICONSKEYPOSITION_KEY_2);
			}

			boolean bindPosition = false;

			if (position == null) {
				query.append(_FINDER_COLUMN_ICONSKEYPOSITION_POSITION_1);
			}
			else if (position.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ICONSKEYPOSITION_POSITION_3);
			}
			else {
				bindPosition = true;

				query.append(_FINDER_COLUMN_ICONSKEYPOSITION_POSITION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(symbolconfigurationId);

				if (bindKey) {
					qPos.add(key);
				}

				if (bindPosition) {
					qPos.add(position);
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

	private static final String _FINDER_COLUMN_ICONSKEYPOSITION_SYMBOLCONFIGURATIONID_2 =
		"iconConfiguration.symbolconfigurationId = ? AND ";
	private static final String _FINDER_COLUMN_ICONSKEYPOSITION_KEY_1 = "iconConfiguration.key IS NULL AND ";
	private static final String _FINDER_COLUMN_ICONSKEYPOSITION_KEY_2 = "iconConfiguration.key = ? AND ";
	private static final String _FINDER_COLUMN_ICONSKEYPOSITION_KEY_3 = "(iconConfiguration.key IS NULL OR iconConfiguration.key = '') AND ";
	private static final String _FINDER_COLUMN_ICONSKEYPOSITION_POSITION_1 = "iconConfiguration.position IS NULL";
	private static final String _FINDER_COLUMN_ICONSKEYPOSITION_POSITION_2 = "iconConfiguration.position = ?";
	private static final String _FINDER_COLUMN_ICONSKEYPOSITION_POSITION_3 = "(iconConfiguration.position IS NULL OR iconConfiguration.position = '')";

	public IconConfigurationPersistenceImpl() {
		setModelClass(IconConfiguration.class);
	}

	/**
	 * Caches the icon configuration in the entity cache if it is enabled.
	 *
	 * @param iconConfiguration the icon configuration
	 */
	@Override
	public void cacheResult(IconConfiguration iconConfiguration) {
		EntityCacheUtil.putResult(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationImpl.class, iconConfiguration.getPrimaryKey(),
			iconConfiguration);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ICONSKEYPOSITION,
			new Object[] {
				iconConfiguration.getSymbolconfigurationId(),
				iconConfiguration.getKey(), iconConfiguration.getPosition()
			}, iconConfiguration);

		iconConfiguration.resetOriginalValues();
	}

	/**
	 * Caches the icon configurations in the entity cache if it is enabled.
	 *
	 * @param iconConfigurations the icon configurations
	 */
	@Override
	public void cacheResult(List<IconConfiguration> iconConfigurations) {
		for (IconConfiguration iconConfiguration : iconConfigurations) {
			if (EntityCacheUtil.getResult(
						IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						IconConfigurationImpl.class,
						iconConfiguration.getPrimaryKey()) == null) {
				cacheResult(iconConfiguration);
			}
			else {
				iconConfiguration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all icon configurations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(IconConfigurationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(IconConfigurationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the icon configuration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(IconConfiguration iconConfiguration) {
		EntityCacheUtil.removeResult(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationImpl.class, iconConfiguration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(iconConfiguration);
	}

	@Override
	public void clearCache(List<IconConfiguration> iconConfigurations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (IconConfiguration iconConfiguration : iconConfigurations) {
			EntityCacheUtil.removeResult(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				IconConfigurationImpl.class, iconConfiguration.getPrimaryKey());

			clearUniqueFindersCache(iconConfiguration);
		}
	}

	protected void cacheUniqueFindersCache(IconConfiguration iconConfiguration) {
		if (iconConfiguration.isNew()) {
			Object[] args = new Object[] {
					iconConfiguration.getSymbolconfigurationId(),
					iconConfiguration.getKey(), iconConfiguration.getPosition()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ICONSKEYPOSITION,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ICONSKEYPOSITION,
				args, iconConfiguration);
		}
		else {
			IconConfigurationModelImpl iconConfigurationModelImpl = (IconConfigurationModelImpl)iconConfiguration;

			if ((iconConfigurationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ICONSKEYPOSITION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						iconConfiguration.getSymbolconfigurationId(),
						iconConfiguration.getKey(),
						iconConfiguration.getPosition()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ICONSKEYPOSITION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ICONSKEYPOSITION,
					args, iconConfiguration);
			}
		}
	}

	protected void clearUniqueFindersCache(IconConfiguration iconConfiguration) {
		IconConfigurationModelImpl iconConfigurationModelImpl = (IconConfigurationModelImpl)iconConfiguration;

		Object[] args = new Object[] {
				iconConfiguration.getSymbolconfigurationId(),
				iconConfiguration.getKey(), iconConfiguration.getPosition()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ICONSKEYPOSITION, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ICONSKEYPOSITION, args);

		if ((iconConfigurationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ICONSKEYPOSITION.getColumnBitmask()) != 0) {
			args = new Object[] {
					iconConfigurationModelImpl.getOriginalSymbolconfigurationId(),
					iconConfigurationModelImpl.getOriginalKey(),
					iconConfigurationModelImpl.getOriginalPosition()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ICONSKEYPOSITION,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ICONSKEYPOSITION,
				args);
		}
	}

	/**
	 * Creates a new icon configuration with the primary key. Does not add the icon configuration to the database.
	 *
	 * @param iconconfigurationId the primary key for the new icon configuration
	 * @return the new icon configuration
	 */
	@Override
	public IconConfiguration create(long iconconfigurationId) {
		IconConfiguration iconConfiguration = new IconConfigurationImpl();

		iconConfiguration.setNew(true);
		iconConfiguration.setPrimaryKey(iconconfigurationId);

		return iconConfiguration;
	}

	/**
	 * Removes the icon configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param iconconfigurationId the primary key of the icon configuration
	 * @return the icon configuration that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a icon configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration remove(long iconconfigurationId)
		throws NoSuchIconConfigurationException, SystemException {
		return remove((Serializable)iconconfigurationId);
	}

	/**
	 * Removes the icon configuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the icon configuration
	 * @return the icon configuration that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a icon configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration remove(Serializable primaryKey)
		throws NoSuchIconConfigurationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			IconConfiguration iconConfiguration = (IconConfiguration)session.get(IconConfigurationImpl.class,
					primaryKey);

			if (iconConfiguration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIconConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(iconConfiguration);
		}
		catch (NoSuchIconConfigurationException nsee) {
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
	protected IconConfiguration removeImpl(IconConfiguration iconConfiguration)
		throws SystemException {
		iconConfiguration = toUnwrappedModel(iconConfiguration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(iconConfiguration)) {
				iconConfiguration = (IconConfiguration)session.get(IconConfigurationImpl.class,
						iconConfiguration.getPrimaryKeyObj());
			}

			if (iconConfiguration != null) {
				session.delete(iconConfiguration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (iconConfiguration != null) {
			clearCache(iconConfiguration);
		}

		return iconConfiguration;
	}

	@Override
	public IconConfiguration updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration iconConfiguration)
		throws SystemException {
		iconConfiguration = toUnwrappedModel(iconConfiguration);

		boolean isNew = iconConfiguration.isNew();

		IconConfigurationModelImpl iconConfigurationModelImpl = (IconConfigurationModelImpl)iconConfiguration;

		Session session = null;

		try {
			session = openSession();

			if (iconConfiguration.isNew()) {
				session.save(iconConfiguration);

				iconConfiguration.setNew(false);
			}
			else {
				session.merge(iconConfiguration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !IconConfigurationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((iconConfigurationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ICONSPOSITION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						iconConfigurationModelImpl.getOriginalSymbolconfigurationId(),
						iconConfigurationModelImpl.getOriginalPosition()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ICONSPOSITION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ICONSPOSITION,
					args);

				args = new Object[] {
						iconConfigurationModelImpl.getSymbolconfigurationId(),
						iconConfigurationModelImpl.getPosition()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ICONSPOSITION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ICONSPOSITION,
					args);
			}

			if ((iconConfigurationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ICONSKEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						iconConfigurationModelImpl.getOriginalSymbolconfigurationId(),
						iconConfigurationModelImpl.getOriginalKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ICONSKEY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ICONSKEY,
					args);

				args = new Object[] {
						iconConfigurationModelImpl.getSymbolconfigurationId(),
						iconConfigurationModelImpl.getKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ICONSKEY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ICONSKEY,
					args);
			}
		}

		EntityCacheUtil.putResult(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
			IconConfigurationImpl.class, iconConfiguration.getPrimaryKey(),
			iconConfiguration);

		clearUniqueFindersCache(iconConfiguration);
		cacheUniqueFindersCache(iconConfiguration);

		return iconConfiguration;
	}

	protected IconConfiguration toUnwrappedModel(
		IconConfiguration iconConfiguration) {
		if (iconConfiguration instanceof IconConfigurationImpl) {
			return iconConfiguration;
		}

		IconConfigurationImpl iconConfigurationImpl = new IconConfigurationImpl();

		iconConfigurationImpl.setNew(iconConfiguration.isNew());
		iconConfigurationImpl.setPrimaryKey(iconConfiguration.getPrimaryKey());

		iconConfigurationImpl.setIconconfigurationId(iconConfiguration.getIconconfigurationId());
		iconConfigurationImpl.setSymbolconfigurationId(iconConfiguration.getSymbolconfigurationId());
		iconConfigurationImpl.setPosition(iconConfiguration.getPosition());
		iconConfigurationImpl.setKey(iconConfiguration.getKey());
		iconConfigurationImpl.setIconsId(iconConfiguration.getIconsId());
		iconConfigurationImpl.setElementcolor(iconConfiguration.getElementcolor());
		iconConfigurationImpl.setWidth(iconConfiguration.getWidth());
		iconConfigurationImpl.setHeight(iconConfiguration.getHeight());

		return iconConfigurationImpl;
	}

	/**
	 * Returns the icon configuration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the icon configuration
	 * @return the icon configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a icon configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIconConfigurationException, SystemException {
		IconConfiguration iconConfiguration = fetchByPrimaryKey(primaryKey);

		if (iconConfiguration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIconConfigurationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return iconConfiguration;
	}

	/**
	 * Returns the icon configuration with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException} if it could not be found.
	 *
	 * @param iconconfigurationId the primary key of the icon configuration
	 * @return the icon configuration
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException if a icon configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration findByPrimaryKey(long iconconfigurationId)
		throws NoSuchIconConfigurationException, SystemException {
		return findByPrimaryKey((Serializable)iconconfigurationId);
	}

	/**
	 * Returns the icon configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the icon configuration
	 * @return the icon configuration, or <code>null</code> if a icon configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		IconConfiguration iconConfiguration = (IconConfiguration)EntityCacheUtil.getResult(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
				IconConfigurationImpl.class, primaryKey);

		if (iconConfiguration == _nullIconConfiguration) {
			return null;
		}

		if (iconConfiguration == null) {
			Session session = null;

			try {
				session = openSession();

				iconConfiguration = (IconConfiguration)session.get(IconConfigurationImpl.class,
						primaryKey);

				if (iconConfiguration != null) {
					cacheResult(iconConfiguration);
				}
				else {
					EntityCacheUtil.putResult(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
						IconConfigurationImpl.class, primaryKey,
						_nullIconConfiguration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(IconConfigurationModelImpl.ENTITY_CACHE_ENABLED,
					IconConfigurationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return iconConfiguration;
	}

	/**
	 * Returns the icon configuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param iconconfigurationId the primary key of the icon configuration
	 * @return the icon configuration, or <code>null</code> if a icon configuration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IconConfiguration fetchByPrimaryKey(long iconconfigurationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)iconconfigurationId);
	}

	/**
	 * Returns all the icon configurations.
	 *
	 * @return the icon configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IconConfiguration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the icon configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of icon configurations
	 * @param end the upper bound of the range of icon configurations (not inclusive)
	 * @return the range of icon configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IconConfiguration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the icon configurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of icon configurations
	 * @param end the upper bound of the range of icon configurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of icon configurations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<IconConfiguration> findAll(int start, int end,
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

		List<IconConfiguration> list = (List<IconConfiguration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ICONCONFIGURATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ICONCONFIGURATION;

				if (pagination) {
					sql = sql.concat(IconConfigurationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<IconConfiguration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<IconConfiguration>(list);
				}
				else {
					list = (List<IconConfiguration>)QueryUtil.list(q,
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
	 * Removes all the icon configurations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (IconConfiguration iconConfiguration : findAll()) {
			remove(iconConfiguration);
		}
	}

	/**
	 * Returns the number of icon configurations.
	 *
	 * @return the number of icon configurations
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

				Query q = session.createQuery(_SQL_COUNT_ICONCONFIGURATION);

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
	 * Initializes the icon configuration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.model.IconConfiguration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<IconConfiguration>> listenersList = new ArrayList<ModelListener<IconConfiguration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<IconConfiguration>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(IconConfigurationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ICONCONFIGURATION = "SELECT iconConfiguration FROM IconConfiguration iconConfiguration";
	private static final String _SQL_SELECT_ICONCONFIGURATION_WHERE = "SELECT iconConfiguration FROM IconConfiguration iconConfiguration WHERE ";
	private static final String _SQL_COUNT_ICONCONFIGURATION = "SELECT COUNT(iconConfiguration) FROM IconConfiguration iconConfiguration";
	private static final String _SQL_COUNT_ICONCONFIGURATION_WHERE = "SELECT COUNT(iconConfiguration) FROM IconConfiguration iconConfiguration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "iconConfiguration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No IconConfiguration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No IconConfiguration exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(IconConfigurationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"key"
			});
	private static IconConfiguration _nullIconConfiguration = new IconConfigurationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<IconConfiguration> toCacheModel() {
				return _nullIconConfigurationCacheModel;
			}
		};

	private static CacheModel<IconConfiguration> _nullIconConfigurationCacheModel =
		new CacheModel<IconConfiguration>() {
			@Override
			public IconConfiguration toEntityModel() {
				return _nullIconConfiguration;
			}
		};
}