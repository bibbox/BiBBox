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

import at.graz.meduni.liferay.portlet.bibbox.NoSuchIconsException;
import at.graz.meduni.liferay.portlet.bibbox.model.Icons;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.IconsImpl;
import at.graz.meduni.liferay.portlet.bibbox.model.impl.IconsModelImpl;

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
 * The persistence implementation for the icons service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see IconsPersistence
 * @see IconsUtil
 * @generated
 */
public class IconsPersistenceImpl extends BasePersistenceImpl<Icons>
	implements IconsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link IconsUtil} to access the icons persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = IconsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(IconsModelImpl.ENTITY_CACHE_ENABLED,
			IconsModelImpl.FINDER_CACHE_ENABLED, IconsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(IconsModelImpl.ENTITY_CACHE_ENABLED,
			IconsModelImpl.FINDER_CACHE_ENABLED, IconsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IconsModelImpl.ENTITY_CACHE_ENABLED,
			IconsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public IconsPersistenceImpl() {
		setModelClass(Icons.class);
	}

	/**
	 * Caches the icons in the entity cache if it is enabled.
	 *
	 * @param icons the icons
	 */
	@Override
	public void cacheResult(Icons icons) {
		EntityCacheUtil.putResult(IconsModelImpl.ENTITY_CACHE_ENABLED,
			IconsImpl.class, icons.getPrimaryKey(), icons);

		icons.resetOriginalValues();
	}

	/**
	 * Caches the iconses in the entity cache if it is enabled.
	 *
	 * @param iconses the iconses
	 */
	@Override
	public void cacheResult(List<Icons> iconses) {
		for (Icons icons : iconses) {
			if (EntityCacheUtil.getResult(IconsModelImpl.ENTITY_CACHE_ENABLED,
						IconsImpl.class, icons.getPrimaryKey()) == null) {
				cacheResult(icons);
			}
			else {
				icons.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all iconses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(IconsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(IconsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the icons.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Icons icons) {
		EntityCacheUtil.removeResult(IconsModelImpl.ENTITY_CACHE_ENABLED,
			IconsImpl.class, icons.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Icons> iconses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Icons icons : iconses) {
			EntityCacheUtil.removeResult(IconsModelImpl.ENTITY_CACHE_ENABLED,
				IconsImpl.class, icons.getPrimaryKey());
		}
	}

	/**
	 * Creates a new icons with the primary key. Does not add the icons to the database.
	 *
	 * @param iconsId the primary key for the new icons
	 * @return the new icons
	 */
	@Override
	public Icons create(long iconsId) {
		Icons icons = new IconsImpl();

		icons.setNew(true);
		icons.setPrimaryKey(iconsId);

		return icons;
	}

	/**
	 * Removes the icons with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param iconsId the primary key of the icons
	 * @return the icons that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconsException if a icons with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Icons remove(long iconsId)
		throws NoSuchIconsException, SystemException {
		return remove((Serializable)iconsId);
	}

	/**
	 * Removes the icons with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the icons
	 * @return the icons that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconsException if a icons with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Icons remove(Serializable primaryKey)
		throws NoSuchIconsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Icons icons = (Icons)session.get(IconsImpl.class, primaryKey);

			if (icons == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIconsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(icons);
		}
		catch (NoSuchIconsException nsee) {
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
	protected Icons removeImpl(Icons icons) throws SystemException {
		icons = toUnwrappedModel(icons);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(icons)) {
				icons = (Icons)session.get(IconsImpl.class,
						icons.getPrimaryKeyObj());
			}

			if (icons != null) {
				session.delete(icons);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (icons != null) {
			clearCache(icons);
		}

		return icons;
	}

	@Override
	public Icons updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.model.Icons icons)
		throws SystemException {
		icons = toUnwrappedModel(icons);

		boolean isNew = icons.isNew();

		Session session = null;

		try {
			session = openSession();

			if (icons.isNew()) {
				session.save(icons);

				icons.setNew(false);
			}
			else {
				session.merge(icons);
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

		EntityCacheUtil.putResult(IconsModelImpl.ENTITY_CACHE_ENABLED,
			IconsImpl.class, icons.getPrimaryKey(), icons);

		return icons;
	}

	protected Icons toUnwrappedModel(Icons icons) {
		if (icons instanceof IconsImpl) {
			return icons;
		}

		IconsImpl iconsImpl = new IconsImpl();

		iconsImpl.setNew(icons.isNew());
		iconsImpl.setPrimaryKey(icons.getPrimaryKey());

		iconsImpl.setIconsId(icons.getIconsId());
		iconsImpl.setIconurl(icons.getIconurl());
		iconsImpl.setGroup(icons.getGroup());

		return iconsImpl;
	}

	/**
	 * Returns the icons with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the icons
	 * @return the icons
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconsException if a icons with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Icons findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIconsException, SystemException {
		Icons icons = fetchByPrimaryKey(primaryKey);

		if (icons == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIconsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return icons;
	}

	/**
	 * Returns the icons with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.NoSuchIconsException} if it could not be found.
	 *
	 * @param iconsId the primary key of the icons
	 * @return the icons
	 * @throws at.graz.meduni.liferay.portlet.bibbox.NoSuchIconsException if a icons with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Icons findByPrimaryKey(long iconsId)
		throws NoSuchIconsException, SystemException {
		return findByPrimaryKey((Serializable)iconsId);
	}

	/**
	 * Returns the icons with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the icons
	 * @return the icons, or <code>null</code> if a icons with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Icons fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Icons icons = (Icons)EntityCacheUtil.getResult(IconsModelImpl.ENTITY_CACHE_ENABLED,
				IconsImpl.class, primaryKey);

		if (icons == _nullIcons) {
			return null;
		}

		if (icons == null) {
			Session session = null;

			try {
				session = openSession();

				icons = (Icons)session.get(IconsImpl.class, primaryKey);

				if (icons != null) {
					cacheResult(icons);
				}
				else {
					EntityCacheUtil.putResult(IconsModelImpl.ENTITY_CACHE_ENABLED,
						IconsImpl.class, primaryKey, _nullIcons);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(IconsModelImpl.ENTITY_CACHE_ENABLED,
					IconsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return icons;
	}

	/**
	 * Returns the icons with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param iconsId the primary key of the icons
	 * @return the icons, or <code>null</code> if a icons with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Icons fetchByPrimaryKey(long iconsId) throws SystemException {
		return fetchByPrimaryKey((Serializable)iconsId);
	}

	/**
	 * Returns all the iconses.
	 *
	 * @return the iconses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Icons> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the iconses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of iconses
	 * @param end the upper bound of the range of iconses (not inclusive)
	 * @return the range of iconses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Icons> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the iconses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.model.impl.IconsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of iconses
	 * @param end the upper bound of the range of iconses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of iconses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Icons> findAll(int start, int end,
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

		List<Icons> list = (List<Icons>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ICONS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ICONS;

				if (pagination) {
					sql = sql.concat(IconsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Icons>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Icons>(list);
				}
				else {
					list = (List<Icons>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the iconses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Icons icons : findAll()) {
			remove(icons);
		}
	}

	/**
	 * Returns the number of iconses.
	 *
	 * @return the number of iconses
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

				Query q = session.createQuery(_SQL_COUNT_ICONS);

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
	 * Initializes the icons persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.model.Icons")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Icons>> listenersList = new ArrayList<ModelListener<Icons>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Icons>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(IconsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ICONS = "SELECT icons FROM Icons icons";
	private static final String _SQL_COUNT_ICONS = "SELECT COUNT(icons) FROM Icons icons";
	private static final String _ORDER_BY_ENTITY_ALIAS = "icons.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Icons exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(IconsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"group"
			});
	private static Icons _nullIcons = new IconsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Icons> toCacheModel() {
				return _nullIconsCacheModel;
			}
		};

	private static CacheModel<Icons> _nullIconsCacheModel = new CacheModel<Icons>() {
			@Override
			public Icons toEntityModel() {
				return _nullIcons;
			}
		};
}