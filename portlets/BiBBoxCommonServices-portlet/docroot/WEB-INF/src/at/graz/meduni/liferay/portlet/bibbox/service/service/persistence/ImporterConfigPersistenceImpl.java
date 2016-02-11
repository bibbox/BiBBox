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

import at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException;
import at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.ImporterConfigImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.ImporterConfigModelImpl;

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
 * The persistence implementation for the importer config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ImporterConfigPersistence
 * @see ImporterConfigUtil
 * @generated
 */
public class ImporterConfigPersistenceImpl extends BasePersistenceImpl<ImporterConfig>
	implements ImporterConfigPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ImporterConfigUtil} to access the importer config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ImporterConfigImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
			ImporterConfigModelImpl.FINDER_CACHE_ENABLED,
			ImporterConfigImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
			ImporterConfigModelImpl.FINDER_CACHE_ENABLED,
			ImporterConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
			ImporterConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IMPORTERCONFIG =
		new FinderPath(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
			ImporterConfigModelImpl.FINDER_CACHE_ENABLED,
			ImporterConfigImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByImporterConfig",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTERCONFIG =
		new FinderPath(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
			ImporterConfigModelImpl.FINDER_CACHE_ENABLED,
			ImporterConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByImporterConfig",
			new String[] { String.class.getName(), String.class.getName() },
			ImporterConfigModelImpl.SCOPE_COLUMN_BITMASK |
			ImporterConfigModelImpl.ELEMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IMPORTERCONFIG = new FinderPath(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
			ImporterConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByImporterConfig",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the importer configs where scope = &#63; and elementId = &#63;.
	 *
	 * @param scope the scope
	 * @param elementId the element ID
	 * @return the matching importer configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImporterConfig> findByImporterConfig(String scope,
		String elementId) throws SystemException {
		return findByImporterConfig(scope, elementId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the importer configs where scope = &#63; and elementId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.ImporterConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scope the scope
	 * @param elementId the element ID
	 * @param start the lower bound of the range of importer configs
	 * @param end the upper bound of the range of importer configs (not inclusive)
	 * @return the range of matching importer configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImporterConfig> findByImporterConfig(String scope,
		String elementId, int start, int end) throws SystemException {
		return findByImporterConfig(scope, elementId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the importer configs where scope = &#63; and elementId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.ImporterConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scope the scope
	 * @param elementId the element ID
	 * @param start the lower bound of the range of importer configs
	 * @param end the upper bound of the range of importer configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching importer configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImporterConfig> findByImporterConfig(String scope,
		String elementId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTERCONFIG;
			finderArgs = new Object[] { scope, elementId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IMPORTERCONFIG;
			finderArgs = new Object[] {
					scope, elementId,
					
					start, end, orderByComparator
				};
		}

		List<ImporterConfig> list = (List<ImporterConfig>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ImporterConfig importerConfig : list) {
				if (!Validator.equals(scope, importerConfig.getScope()) ||
						!Validator.equals(elementId,
							importerConfig.getElementId())) {
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

			query.append(_SQL_SELECT_IMPORTERCONFIG_WHERE);

			boolean bindScope = false;

			if (scope == null) {
				query.append(_FINDER_COLUMN_IMPORTERCONFIG_SCOPE_1);
			}
			else if (scope.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IMPORTERCONFIG_SCOPE_3);
			}
			else {
				bindScope = true;

				query.append(_FINDER_COLUMN_IMPORTERCONFIG_SCOPE_2);
			}

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ImporterConfigModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScope) {
					qPos.add(scope);
				}

				if (bindElementId) {
					qPos.add(elementId);
				}

				if (!pagination) {
					list = (List<ImporterConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ImporterConfig>(list);
				}
				else {
					list = (List<ImporterConfig>)QueryUtil.list(q,
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
	 * Returns the first importer config in the ordered set where scope = &#63; and elementId = &#63;.
	 *
	 * @param scope the scope
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching importer config
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a matching importer config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig findByImporterConfig_First(String scope,
		String elementId, OrderByComparator orderByComparator)
		throws NoSuchImporterConfigException, SystemException {
		ImporterConfig importerConfig = fetchByImporterConfig_First(scope,
				elementId, orderByComparator);

		if (importerConfig != null) {
			return importerConfig;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scope=");
		msg.append(scope);

		msg.append(", elementId=");
		msg.append(elementId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImporterConfigException(msg.toString());
	}

	/**
	 * Returns the first importer config in the ordered set where scope = &#63; and elementId = &#63;.
	 *
	 * @param scope the scope
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching importer config, or <code>null</code> if a matching importer config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig fetchByImporterConfig_First(String scope,
		String elementId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ImporterConfig> list = findByImporterConfig(scope, elementId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last importer config in the ordered set where scope = &#63; and elementId = &#63;.
	 *
	 * @param scope the scope
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching importer config
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a matching importer config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig findByImporterConfig_Last(String scope,
		String elementId, OrderByComparator orderByComparator)
		throws NoSuchImporterConfigException, SystemException {
		ImporterConfig importerConfig = fetchByImporterConfig_Last(scope,
				elementId, orderByComparator);

		if (importerConfig != null) {
			return importerConfig;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scope=");
		msg.append(scope);

		msg.append(", elementId=");
		msg.append(elementId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchImporterConfigException(msg.toString());
	}

	/**
	 * Returns the last importer config in the ordered set where scope = &#63; and elementId = &#63;.
	 *
	 * @param scope the scope
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching importer config, or <code>null</code> if a matching importer config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig fetchByImporterConfig_Last(String scope,
		String elementId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByImporterConfig(scope, elementId);

		if (count == 0) {
			return null;
		}

		List<ImporterConfig> list = findByImporterConfig(scope, elementId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the importer configs before and after the current importer config in the ordered set where scope = &#63; and elementId = &#63;.
	 *
	 * @param importerconfigId the primary key of the current importer config
	 * @param scope the scope
	 * @param elementId the element ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next importer config
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a importer config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig[] findByImporterConfig_PrevAndNext(
		long importerconfigId, String scope, String elementId,
		OrderByComparator orderByComparator)
		throws NoSuchImporterConfigException, SystemException {
		ImporterConfig importerConfig = findByPrimaryKey(importerconfigId);

		Session session = null;

		try {
			session = openSession();

			ImporterConfig[] array = new ImporterConfigImpl[3];

			array[0] = getByImporterConfig_PrevAndNext(session, importerConfig,
					scope, elementId, orderByComparator, true);

			array[1] = importerConfig;

			array[2] = getByImporterConfig_PrevAndNext(session, importerConfig,
					scope, elementId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ImporterConfig getByImporterConfig_PrevAndNext(Session session,
		ImporterConfig importerConfig, String scope, String elementId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IMPORTERCONFIG_WHERE);

		boolean bindScope = false;

		if (scope == null) {
			query.append(_FINDER_COLUMN_IMPORTERCONFIG_SCOPE_1);
		}
		else if (scope.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_IMPORTERCONFIG_SCOPE_3);
		}
		else {
			bindScope = true;

			query.append(_FINDER_COLUMN_IMPORTERCONFIG_SCOPE_2);
		}

		boolean bindElementId = false;

		if (elementId == null) {
			query.append(_FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_1);
		}
		else if (elementId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_3);
		}
		else {
			bindElementId = true;

			query.append(_FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_2);
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
			query.append(ImporterConfigModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindScope) {
			qPos.add(scope);
		}

		if (bindElementId) {
			qPos.add(elementId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(importerConfig);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ImporterConfig> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the importer configs where scope = &#63; and elementId = &#63; from the database.
	 *
	 * @param scope the scope
	 * @param elementId the element ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByImporterConfig(String scope, String elementId)
		throws SystemException {
		for (ImporterConfig importerConfig : findByImporterConfig(scope,
				elementId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(importerConfig);
		}
	}

	/**
	 * Returns the number of importer configs where scope = &#63; and elementId = &#63;.
	 *
	 * @param scope the scope
	 * @param elementId the element ID
	 * @return the number of matching importer configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByImporterConfig(String scope, String elementId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IMPORTERCONFIG;

		Object[] finderArgs = new Object[] { scope, elementId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_IMPORTERCONFIG_WHERE);

			boolean bindScope = false;

			if (scope == null) {
				query.append(_FINDER_COLUMN_IMPORTERCONFIG_SCOPE_1);
			}
			else if (scope.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IMPORTERCONFIG_SCOPE_3);
			}
			else {
				bindScope = true;

				query.append(_FINDER_COLUMN_IMPORTERCONFIG_SCOPE_2);
			}

			boolean bindElementId = false;

			if (elementId == null) {
				query.append(_FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_1);
			}
			else if (elementId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_3);
			}
			else {
				bindElementId = true;

				query.append(_FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScope) {
					qPos.add(scope);
				}

				if (bindElementId) {
					qPos.add(elementId);
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

	private static final String _FINDER_COLUMN_IMPORTERCONFIG_SCOPE_1 = "importerConfig.scope IS NULL AND ";
	private static final String _FINDER_COLUMN_IMPORTERCONFIG_SCOPE_2 = "importerConfig.scope = ? AND ";
	private static final String _FINDER_COLUMN_IMPORTERCONFIG_SCOPE_3 = "(importerConfig.scope IS NULL OR importerConfig.scope = '') AND ";
	private static final String _FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_1 = "importerConfig.elementId IS NULL";
	private static final String _FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_2 = "importerConfig.elementId = ?";
	private static final String _FINDER_COLUMN_IMPORTERCONFIG_ELEMENTID_3 = "(importerConfig.elementId IS NULL OR importerConfig.elementId = '')";

	public ImporterConfigPersistenceImpl() {
		setModelClass(ImporterConfig.class);
	}

	/**
	 * Caches the importer config in the entity cache if it is enabled.
	 *
	 * @param importerConfig the importer config
	 */
	@Override
	public void cacheResult(ImporterConfig importerConfig) {
		EntityCacheUtil.putResult(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
			ImporterConfigImpl.class, importerConfig.getPrimaryKey(),
			importerConfig);

		importerConfig.resetOriginalValues();
	}

	/**
	 * Caches the importer configs in the entity cache if it is enabled.
	 *
	 * @param importerConfigs the importer configs
	 */
	@Override
	public void cacheResult(List<ImporterConfig> importerConfigs) {
		for (ImporterConfig importerConfig : importerConfigs) {
			if (EntityCacheUtil.getResult(
						ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
						ImporterConfigImpl.class, importerConfig.getPrimaryKey()) == null) {
				cacheResult(importerConfig);
			}
			else {
				importerConfig.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all importer configs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ImporterConfigImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ImporterConfigImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the importer config.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ImporterConfig importerConfig) {
		EntityCacheUtil.removeResult(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
			ImporterConfigImpl.class, importerConfig.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ImporterConfig> importerConfigs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ImporterConfig importerConfig : importerConfigs) {
			EntityCacheUtil.removeResult(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
				ImporterConfigImpl.class, importerConfig.getPrimaryKey());
		}
	}

	/**
	 * Creates a new importer config with the primary key. Does not add the importer config to the database.
	 *
	 * @param importerconfigId the primary key for the new importer config
	 * @return the new importer config
	 */
	@Override
	public ImporterConfig create(long importerconfigId) {
		ImporterConfig importerConfig = new ImporterConfigImpl();

		importerConfig.setNew(true);
		importerConfig.setPrimaryKey(importerconfigId);

		return importerConfig;
	}

	/**
	 * Removes the importer config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param importerconfigId the primary key of the importer config
	 * @return the importer config that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a importer config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig remove(long importerconfigId)
		throws NoSuchImporterConfigException, SystemException {
		return remove((Serializable)importerconfigId);
	}

	/**
	 * Removes the importer config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the importer config
	 * @return the importer config that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a importer config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig remove(Serializable primaryKey)
		throws NoSuchImporterConfigException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ImporterConfig importerConfig = (ImporterConfig)session.get(ImporterConfigImpl.class,
					primaryKey);

			if (importerConfig == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImporterConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(importerConfig);
		}
		catch (NoSuchImporterConfigException nsee) {
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
	protected ImporterConfig removeImpl(ImporterConfig importerConfig)
		throws SystemException {
		importerConfig = toUnwrappedModel(importerConfig);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(importerConfig)) {
				importerConfig = (ImporterConfig)session.get(ImporterConfigImpl.class,
						importerConfig.getPrimaryKeyObj());
			}

			if (importerConfig != null) {
				session.delete(importerConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (importerConfig != null) {
			clearCache(importerConfig);
		}

		return importerConfig;
	}

	@Override
	public ImporterConfig updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig importerConfig)
		throws SystemException {
		importerConfig = toUnwrappedModel(importerConfig);

		boolean isNew = importerConfig.isNew();

		ImporterConfigModelImpl importerConfigModelImpl = (ImporterConfigModelImpl)importerConfig;

		Session session = null;

		try {
			session = openSession();

			if (importerConfig.isNew()) {
				session.save(importerConfig);

				importerConfig.setNew(false);
			}
			else {
				session.merge(importerConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ImporterConfigModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((importerConfigModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTERCONFIG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						importerConfigModelImpl.getOriginalScope(),
						importerConfigModelImpl.getOriginalElementId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMPORTERCONFIG,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTERCONFIG,
					args);

				args = new Object[] {
						importerConfigModelImpl.getScope(),
						importerConfigModelImpl.getElementId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMPORTERCONFIG,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMPORTERCONFIG,
					args);
			}
		}

		EntityCacheUtil.putResult(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
			ImporterConfigImpl.class, importerConfig.getPrimaryKey(),
			importerConfig);

		return importerConfig;
	}

	protected ImporterConfig toUnwrappedModel(ImporterConfig importerConfig) {
		if (importerConfig instanceof ImporterConfigImpl) {
			return importerConfig;
		}

		ImporterConfigImpl importerConfigImpl = new ImporterConfigImpl();

		importerConfigImpl.setNew(importerConfig.isNew());
		importerConfigImpl.setPrimaryKey(importerConfig.getPrimaryKey());

		importerConfigImpl.setImporterconfigId(importerConfig.getImporterconfigId());
		importerConfigImpl.setScope(importerConfig.getScope());
		importerConfigImpl.setElementId(importerConfig.getElementId());
		importerConfigImpl.setElementvalue(importerConfig.getElementvalue());

		return importerConfigImpl;
	}

	/**
	 * Returns the importer config with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the importer config
	 * @return the importer config
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a importer config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig findByPrimaryKey(Serializable primaryKey)
		throws NoSuchImporterConfigException, SystemException {
		ImporterConfig importerConfig = fetchByPrimaryKey(primaryKey);

		if (importerConfig == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImporterConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return importerConfig;
	}

	/**
	 * Returns the importer config with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException} if it could not be found.
	 *
	 * @param importerconfigId the primary key of the importer config
	 * @return the importer config
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchImporterConfigException if a importer config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig findByPrimaryKey(long importerconfigId)
		throws NoSuchImporterConfigException, SystemException {
		return findByPrimaryKey((Serializable)importerconfigId);
	}

	/**
	 * Returns the importer config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the importer config
	 * @return the importer config, or <code>null</code> if a importer config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ImporterConfig importerConfig = (ImporterConfig)EntityCacheUtil.getResult(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
				ImporterConfigImpl.class, primaryKey);

		if (importerConfig == _nullImporterConfig) {
			return null;
		}

		if (importerConfig == null) {
			Session session = null;

			try {
				session = openSession();

				importerConfig = (ImporterConfig)session.get(ImporterConfigImpl.class,
						primaryKey);

				if (importerConfig != null) {
					cacheResult(importerConfig);
				}
				else {
					EntityCacheUtil.putResult(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
						ImporterConfigImpl.class, primaryKey,
						_nullImporterConfig);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ImporterConfigModelImpl.ENTITY_CACHE_ENABLED,
					ImporterConfigImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return importerConfig;
	}

	/**
	 * Returns the importer config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param importerconfigId the primary key of the importer config
	 * @return the importer config, or <code>null</code> if a importer config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ImporterConfig fetchByPrimaryKey(long importerconfigId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)importerconfigId);
	}

	/**
	 * Returns all the importer configs.
	 *
	 * @return the importer configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImporterConfig> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the importer configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.ImporterConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of importer configs
	 * @param end the upper bound of the range of importer configs (not inclusive)
	 * @return the range of importer configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImporterConfig> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the importer configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.ImporterConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of importer configs
	 * @param end the upper bound of the range of importer configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of importer configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ImporterConfig> findAll(int start, int end,
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

		List<ImporterConfig> list = (List<ImporterConfig>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_IMPORTERCONFIG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IMPORTERCONFIG;

				if (pagination) {
					sql = sql.concat(ImporterConfigModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ImporterConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ImporterConfig>(list);
				}
				else {
					list = (List<ImporterConfig>)QueryUtil.list(q,
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
	 * Removes all the importer configs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ImporterConfig importerConfig : findAll()) {
			remove(importerConfig);
		}
	}

	/**
	 * Returns the number of importer configs.
	 *
	 * @return the number of importer configs
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

				Query q = session.createQuery(_SQL_COUNT_IMPORTERCONFIG);

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
	 * Initializes the importer config persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.service.model.ImporterConfig")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ImporterConfig>> listenersList = new ArrayList<ModelListener<ImporterConfig>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ImporterConfig>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ImporterConfigImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_IMPORTERCONFIG = "SELECT importerConfig FROM ImporterConfig importerConfig";
	private static final String _SQL_SELECT_IMPORTERCONFIG_WHERE = "SELECT importerConfig FROM ImporterConfig importerConfig WHERE ";
	private static final String _SQL_COUNT_IMPORTERCONFIG = "SELECT COUNT(importerConfig) FROM ImporterConfig importerConfig";
	private static final String _SQL_COUNT_IMPORTERCONFIG_WHERE = "SELECT COUNT(importerConfig) FROM ImporterConfig importerConfig WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "importerConfig.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ImporterConfig exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ImporterConfig exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ImporterConfigPersistenceImpl.class);
	private static ImporterConfig _nullImporterConfig = new ImporterConfigImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ImporterConfig> toCacheModel() {
				return _nullImporterConfigCacheModel;
			}
		};

	private static CacheModel<ImporterConfig> _nullImporterConfigCacheModel = new CacheModel<ImporterConfig>() {
			@Override
			public ImporterConfig toEntityModel() {
				return _nullImporterConfig;
			}
		};
}