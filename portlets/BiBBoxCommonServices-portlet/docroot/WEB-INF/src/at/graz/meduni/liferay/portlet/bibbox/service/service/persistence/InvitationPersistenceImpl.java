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

import at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException;
import at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationImpl;
import at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl;

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

/**
 * The persistence implementation for the invitation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see InvitationPersistence
 * @see InvitationUtil
 * @generated
 */
public class InvitationPersistenceImpl extends BasePersistenceImpl<Invitation>
	implements InvitationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InvitationUtil} to access the invitation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InvitationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationModelImpl.FINDER_CACHE_ENABLED, InvitationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationModelImpl.FINDER_CACHE_ENABLED, InvitationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public InvitationPersistenceImpl() {
		setModelClass(Invitation.class);
	}

	/**
	 * Caches the invitation in the entity cache if it is enabled.
	 *
	 * @param invitation the invitation
	 */
	@Override
	public void cacheResult(Invitation invitation) {
		EntityCacheUtil.putResult(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationImpl.class, invitation.getPrimaryKey(), invitation);

		invitation.resetOriginalValues();
	}

	/**
	 * Caches the invitations in the entity cache if it is enabled.
	 *
	 * @param invitations the invitations
	 */
	@Override
	public void cacheResult(List<Invitation> invitations) {
		for (Invitation invitation : invitations) {
			if (EntityCacheUtil.getResult(
						InvitationModelImpl.ENTITY_CACHE_ENABLED,
						InvitationImpl.class, invitation.getPrimaryKey()) == null) {
				cacheResult(invitation);
			}
			else {
				invitation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all invitations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InvitationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InvitationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the invitation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Invitation invitation) {
		EntityCacheUtil.removeResult(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationImpl.class, invitation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Invitation> invitations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Invitation invitation : invitations) {
			EntityCacheUtil.removeResult(InvitationModelImpl.ENTITY_CACHE_ENABLED,
				InvitationImpl.class, invitation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new invitation with the primary key. Does not add the invitation to the database.
	 *
	 * @param invitationID the primary key for the new invitation
	 * @return the new invitation
	 */
	@Override
	public Invitation create(long invitationID) {
		Invitation invitation = new InvitationImpl();

		invitation.setNew(true);
		invitation.setPrimaryKey(invitationID);

		return invitation;
	}

	/**
	 * Removes the invitation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invitationID the primary key of the invitation
	 * @return the invitation that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a invitation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation remove(long invitationID)
		throws NoSuchInvitationException, SystemException {
		return remove((Serializable)invitationID);
	}

	/**
	 * Removes the invitation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the invitation
	 * @return the invitation that was removed
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a invitation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation remove(Serializable primaryKey)
		throws NoSuchInvitationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Invitation invitation = (Invitation)session.get(InvitationImpl.class,
					primaryKey);

			if (invitation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInvitationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(invitation);
		}
		catch (NoSuchInvitationException nsee) {
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
	protected Invitation removeImpl(Invitation invitation)
		throws SystemException {
		invitation = toUnwrappedModel(invitation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(invitation)) {
				invitation = (Invitation)session.get(InvitationImpl.class,
						invitation.getPrimaryKeyObj());
			}

			if (invitation != null) {
				session.delete(invitation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (invitation != null) {
			clearCache(invitation);
		}

		return invitation;
	}

	@Override
	public Invitation updateImpl(
		at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation invitation)
		throws SystemException {
		invitation = toUnwrappedModel(invitation);

		boolean isNew = invitation.isNew();

		Session session = null;

		try {
			session = openSession();

			if (invitation.isNew()) {
				session.save(invitation);

				invitation.setNew(false);
			}
			else {
				session.merge(invitation);
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

		EntityCacheUtil.putResult(InvitationModelImpl.ENTITY_CACHE_ENABLED,
			InvitationImpl.class, invitation.getPrimaryKey(), invitation);

		return invitation;
	}

	protected Invitation toUnwrappedModel(Invitation invitation) {
		if (invitation instanceof InvitationImpl) {
			return invitation;
		}

		InvitationImpl invitationImpl = new InvitationImpl();

		invitationImpl.setNew(invitation.isNew());
		invitationImpl.setPrimaryKey(invitation.getPrimaryKey());

		invitationImpl.setInvitationID(invitation.getInvitationID());

		return invitationImpl;
	}

	/**
	 * Returns the invitation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the invitation
	 * @return the invitation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a invitation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInvitationException, SystemException {
		Invitation invitation = fetchByPrimaryKey(primaryKey);

		if (invitation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInvitationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return invitation;
	}

	/**
	 * Returns the invitation with the primary key or throws a {@link at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException} if it could not be found.
	 *
	 * @param invitationID the primary key of the invitation
	 * @return the invitation
	 * @throws at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException if a invitation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation findByPrimaryKey(long invitationID)
		throws NoSuchInvitationException, SystemException {
		return findByPrimaryKey((Serializable)invitationID);
	}

	/**
	 * Returns the invitation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the invitation
	 * @return the invitation, or <code>null</code> if a invitation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Invitation invitation = (Invitation)EntityCacheUtil.getResult(InvitationModelImpl.ENTITY_CACHE_ENABLED,
				InvitationImpl.class, primaryKey);

		if (invitation == _nullInvitation) {
			return null;
		}

		if (invitation == null) {
			Session session = null;

			try {
				session = openSession();

				invitation = (Invitation)session.get(InvitationImpl.class,
						primaryKey);

				if (invitation != null) {
					cacheResult(invitation);
				}
				else {
					EntityCacheUtil.putResult(InvitationModelImpl.ENTITY_CACHE_ENABLED,
						InvitationImpl.class, primaryKey, _nullInvitation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(InvitationModelImpl.ENTITY_CACHE_ENABLED,
					InvitationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return invitation;
	}

	/**
	 * Returns the invitation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param invitationID the primary key of the invitation
	 * @return the invitation, or <code>null</code> if a invitation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Invitation fetchByPrimaryKey(long invitationID)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)invitationID);
	}

	/**
	 * Returns all the invitations.
	 *
	 * @return the invitations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invitation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the invitations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of invitations
	 * @param end the upper bound of the range of invitations (not inclusive)
	 * @return the range of invitations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invitation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the invitations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of invitations
	 * @param end the upper bound of the range of invitations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of invitations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Invitation> findAll(int start, int end,
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

		List<Invitation> list = (List<Invitation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INVITATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INVITATION;

				if (pagination) {
					sql = sql.concat(InvitationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Invitation>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Invitation>(list);
				}
				else {
					list = (List<Invitation>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the invitations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Invitation invitation : findAll()) {
			remove(invitation);
		}
	}

	/**
	 * Returns the number of invitations.
	 *
	 * @return the number of invitations
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

				Query q = session.createQuery(_SQL_COUNT_INVITATION);

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
	 * Initializes the invitation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.graz.meduni.liferay.portlet.bibbox.service.model.Invitation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Invitation>> listenersList = new ArrayList<ModelListener<Invitation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Invitation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(InvitationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_INVITATION = "SELECT invitation FROM Invitation invitation";
	private static final String _SQL_COUNT_INVITATION = "SELECT COUNT(invitation) FROM Invitation invitation";
	private static final String _ORDER_BY_ENTITY_ALIAS = "invitation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Invitation exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InvitationPersistenceImpl.class);
	private static Invitation _nullInvitation = new InvitationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Invitation> toCacheModel() {
				return _nullInvitationCacheModel;
			}
		};

	private static CacheModel<Invitation> _nullInvitationCacheModel = new CacheModel<Invitation>() {
			@Override
			public Invitation toEntityModel() {
				return _nullInvitation;
			}
		};
}