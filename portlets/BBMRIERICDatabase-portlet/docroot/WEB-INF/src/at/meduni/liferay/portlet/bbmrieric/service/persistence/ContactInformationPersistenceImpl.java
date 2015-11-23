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

import at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException;
import at.meduni.liferay.portlet.bbmrieric.model.ContactInformation;
import at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationImpl;
import at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationModelImpl;

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
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the contact information service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see ContactInformationPersistence
 * @see ContactInformationUtil
 * @generated
 */
public class ContactInformationPersistenceImpl extends BasePersistenceImpl<ContactInformation>
	implements ContactInformationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContactInformationUtil} to access the contact information persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContactInformationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED,
			ContactInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED,
			ContactInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED,
			ContactInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED,
			ContactInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ContactInformationModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the contact informations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact informations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contact informations
	 * @param end the upper bound of the range of contact informations (not inclusive)
	 * @return the range of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact informations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of contact informations
	 * @param end the upper bound of the range of contact informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<ContactInformation> list = (List<ContactInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactInformation contactInformation : list) {
				if (!Validator.equals(uuid, contactInformation.getUuid())) {
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

			query.append(_SQL_SELECT_CONTACTINFORMATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContactInformationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<ContactInformation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactInformation>(list);
				}
				else {
					list = (List<ContactInformation>)QueryUtil.list(q,
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
	 * Returns the first contact information in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = fetchByUuid_First(uuid,
				orderByComparator);

		if (contactInformation != null) {
			return contactInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactInformationException(msg.toString());
	}

	/**
	 * Returns the first contact information in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact information, or <code>null</code> if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContactInformation> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact information in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = fetchByUuid_Last(uuid,
				orderByComparator);

		if (contactInformation != null) {
			return contactInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactInformationException(msg.toString());
	}

	/**
	 * Returns the last contact information in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact information, or <code>null</code> if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ContactInformation> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contact informations before and after the current contact information in the ordered set where uuid = &#63;.
	 *
	 * @param contactinformationId the primary key of the current contact information
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a contact information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation[] findByUuid_PrevAndNext(
		long contactinformationId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = findByPrimaryKey(contactinformationId);

		Session session = null;

		try {
			session = openSession();

			ContactInformation[] array = new ContactInformationImpl[3];

			array[0] = getByUuid_PrevAndNext(session, contactInformation, uuid,
					orderByComparator, true);

			array[1] = contactInformation;

			array[2] = getByUuid_PrevAndNext(session, contactInformation, uuid,
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

	protected ContactInformation getByUuid_PrevAndNext(Session session,
		ContactInformation contactInformation, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTINFORMATION_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
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
			query.append(ContactInformationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactInformation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactInformation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact informations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ContactInformation contactInformation : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contactInformation);
		}
	}

	/**
	 * Returns the number of contact informations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTINFORMATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "contactInformation.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "contactInformation.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(contactInformation.uuid IS NULL OR contactInformation.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED,
			ContactInformationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ContactInformationModelImpl.UUID_COLUMN_BITMASK |
			ContactInformationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the contact information where uuid = &#63; and groupId = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation findByUUID_G(String uuid, long groupId)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = fetchByUUID_G(uuid, groupId);

		if (contactInformation == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchContactInformationException(msg.toString());
		}

		return contactInformation;
	}

	/**
	 * Returns the contact information where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching contact information, or <code>null</code> if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the contact information where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching contact information, or <code>null</code> if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ContactInformation) {
			ContactInformation contactInformation = (ContactInformation)result;

			if (!Validator.equals(uuid, contactInformation.getUuid()) ||
					(groupId != contactInformation.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CONTACTINFORMATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<ContactInformation> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ContactInformation contactInformation = list.get(0);

					result = contactInformation;

					cacheResult(contactInformation);

					if ((contactInformation.getUuid() == null) ||
							!contactInformation.getUuid().equals(uuid) ||
							(contactInformation.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, contactInformation);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
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
			return (ContactInformation)result;
		}
	}

	/**
	 * Removes the contact information where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the contact information that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation removeByUUID_G(String uuid, long groupId)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = findByUUID_G(uuid, groupId);

		return remove(contactInformation);
	}

	/**
	 * Returns the number of contact informations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTINFORMATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "contactInformation.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "contactInformation.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(contactInformation.uuid IS NULL OR contactInformation.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "contactInformation.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED,
			ContactInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED,
			ContactInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ContactInformationModelImpl.UUID_COLUMN_BITMASK |
			ContactInformationModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the contact informations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact informations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contact informations
	 * @param end the upper bound of the range of contact informations (not inclusive)
	 * @return the range of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact informations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contact informations
	 * @param end the upper bound of the range of contact informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<ContactInformation> list = (List<ContactInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactInformation contactInformation : list) {
				if (!Validator.equals(uuid, contactInformation.getUuid()) ||
						(companyId != contactInformation.getCompanyId())) {
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

			query.append(_SQL_SELECT_CONTACTINFORMATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContactInformationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<ContactInformation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactInformation>(list);
				}
				else {
					list = (List<ContactInformation>)QueryUtil.list(q,
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
	 * Returns the first contact information in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (contactInformation != null) {
			return contactInformation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactInformationException(msg.toString());
	}

	/**
	 * Returns the first contact information in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact information, or <code>null</code> if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContactInformation> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact information in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (contactInformation != null) {
			return contactInformation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactInformationException(msg.toString());
	}

	/**
	 * Returns the last contact information in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact information, or <code>null</code> if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ContactInformation> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contact informations before and after the current contact information in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param contactinformationId the primary key of the current contact information
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a contact information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation[] findByUuid_C_PrevAndNext(
		long contactinformationId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = findByPrimaryKey(contactinformationId);

		Session session = null;

		try {
			session = openSession();

			ContactInformation[] array = new ContactInformationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, contactInformation,
					uuid, companyId, orderByComparator, true);

			array[1] = contactInformation;

			array[2] = getByUuid_C_PrevAndNext(session, contactInformation,
					uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactInformation getByUuid_C_PrevAndNext(Session session,
		ContactInformation contactInformation, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTINFORMATION_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(ContactInformationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactInformation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactInformation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact informations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ContactInformation contactInformation : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contactInformation);
		}
	}

	/**
	 * Returns the number of contact informations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTINFORMATION_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "contactInformation.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "contactInformation.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(contactInformation.uuid IS NULL OR contactInformation.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "contactInformation.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED,
			ContactInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED,
			ContactInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ContactInformationModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the contact informations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact informations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contact informations
	 * @param end the upper bound of the range of contact informations (not inclusive)
	 * @return the range of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact informations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of contact informations
	 * @param end the upper bound of the range of contact informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<ContactInformation> list = (List<ContactInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactInformation contactInformation : list) {
				if ((groupId != contactInformation.getGroupId())) {
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

			query.append(_SQL_SELECT_CONTACTINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContactInformationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<ContactInformation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactInformation>(list);
				}
				else {
					list = (List<ContactInformation>)QueryUtil.list(q,
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
	 * Returns the first contact information in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = fetchByGroupId_First(groupId,
				orderByComparator);

		if (contactInformation != null) {
			return contactInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactInformationException(msg.toString());
	}

	/**
	 * Returns the first contact information in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact information, or <code>null</code> if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContactInformation> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact information in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (contactInformation != null) {
			return contactInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactInformationException(msg.toString());
	}

	/**
	 * Returns the last contact information in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact information, or <code>null</code> if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ContactInformation> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contact informations before and after the current contact information in the ordered set where groupId = &#63;.
	 *
	 * @param contactinformationId the primary key of the current contact information
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a contact information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation[] findByGroupId_PrevAndNext(
		long contactinformationId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = findByPrimaryKey(contactinformationId);

		Session session = null;

		try {
			session = openSession();

			ContactInformation[] array = new ContactInformationImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, contactInformation,
					groupId, orderByComparator, true);

			array[1] = contactInformation;

			array[2] = getByGroupId_PrevAndNext(session, contactInformation,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactInformation getByGroupId_PrevAndNext(Session session,
		ContactInformation contactInformation, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTINFORMATION_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(ContactInformationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactInformation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactInformation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact informations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (ContactInformation contactInformation : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contactInformation);
		}
	}

	/**
	 * Returns the number of contact informations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "contactInformation.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED,
			ContactInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED,
			ContactInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			ContactInformationModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the contact informations where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the contact informations where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contact informations
	 * @param end the upper bound of the range of contact informations (not inclusive)
	 * @return the range of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findByCompanyId(long companyId, int start,
		int end) throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact informations where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of contact informations
	 * @param end the upper bound of the range of contact informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findByCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<ContactInformation> list = (List<ContactInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactInformation contactInformation : list) {
				if ((companyId != contactInformation.getCompanyId())) {
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

			query.append(_SQL_SELECT_CONTACTINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContactInformationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<ContactInformation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactInformation>(list);
				}
				else {
					list = (List<ContactInformation>)QueryUtil.list(q,
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
	 * Returns the first contact information in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (contactInformation != null) {
			return contactInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactInformationException(msg.toString());
	}

	/**
	 * Returns the first contact information in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact information, or <code>null</code> if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ContactInformation> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact information in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (contactInformation != null) {
			return contactInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactInformationException(msg.toString());
	}

	/**
	 * Returns the last contact information in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact information, or <code>null</code> if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<ContactInformation> list = findByCompanyId(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contact informations before and after the current contact information in the ordered set where companyId = &#63;.
	 *
	 * @param contactinformationId the primary key of the current contact information
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a contact information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation[] findByCompanyId_PrevAndNext(
		long contactinformationId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = findByPrimaryKey(contactinformationId);

		Session session = null;

		try {
			session = openSession();

			ContactInformation[] array = new ContactInformationImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, contactInformation,
					companyId, orderByComparator, true);

			array[1] = contactInformation;

			array[2] = getByCompanyId_PrevAndNext(session, contactInformation,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactInformation getByCompanyId_PrevAndNext(Session session,
		ContactInformation contactInformation, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTINFORMATION_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			query.append(ContactInformationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactInformation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactInformation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact informations where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (ContactInformation contactInformation : findByCompanyId(
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contactInformation);
		}
	}

	/**
	 * Returns the number of contact informations where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyId(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "contactInformation.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACT = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED,
			ContactInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContact",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT =
		new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED,
			ContactInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContact",
			new String[] { Long.class.getName(), String.class.getName() },
			ContactInformationModelImpl.GROUPID_COLUMN_BITMASK |
			ContactInformationModelImpl.CONTACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACT = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContact",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the contact informations where groupId = &#63; and contactID = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contactID the contact i d
	 * @return the matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findByContact(long groupId, String contactID)
		throws SystemException {
		return findByContact(groupId, contactID, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact informations where groupId = &#63; and contactID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contactID the contact i d
	 * @param start the lower bound of the range of contact informations
	 * @param end the upper bound of the range of contact informations (not inclusive)
	 * @return the range of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findByContact(long groupId,
		String contactID, int start, int end) throws SystemException {
		return findByContact(groupId, contactID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact informations where groupId = &#63; and contactID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contactID the contact i d
	 * @param start the lower bound of the range of contact informations
	 * @param end the upper bound of the range of contact informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findByContact(long groupId,
		String contactID, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT;
			finderArgs = new Object[] { groupId, contactID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACT;
			finderArgs = new Object[] {
					groupId, contactID,
					
					start, end, orderByComparator
				};
		}

		List<ContactInformation> list = (List<ContactInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactInformation contactInformation : list) {
				if ((groupId != contactInformation.getGroupId()) ||
						!Validator.equals(contactID,
							contactInformation.getContactID())) {
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

			query.append(_SQL_SELECT_CONTACTINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_CONTACT_GROUPID_2);

			boolean bindContactID = false;

			if (contactID == null) {
				query.append(_FINDER_COLUMN_CONTACT_CONTACTID_1);
			}
			else if (contactID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONTACT_CONTACTID_3);
			}
			else {
				bindContactID = true;

				query.append(_FINDER_COLUMN_CONTACT_CONTACTID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContactInformationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindContactID) {
					qPos.add(contactID);
				}

				if (!pagination) {
					list = (List<ContactInformation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactInformation>(list);
				}
				else {
					list = (List<ContactInformation>)QueryUtil.list(q,
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
	 * Returns the first contact information in the ordered set where groupId = &#63; and contactID = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contactID the contact i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation findByContact_First(long groupId,
		String contactID, OrderByComparator orderByComparator)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = fetchByContact_First(groupId,
				contactID, orderByComparator);

		if (contactInformation != null) {
			return contactInformation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contactID=");
		msg.append(contactID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactInformationException(msg.toString());
	}

	/**
	 * Returns the first contact information in the ordered set where groupId = &#63; and contactID = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contactID the contact i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact information, or <code>null</code> if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation fetchByContact_First(long groupId,
		String contactID, OrderByComparator orderByComparator)
		throws SystemException {
		List<ContactInformation> list = findByContact(groupId, contactID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact information in the ordered set where groupId = &#63; and contactID = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contactID the contact i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation findByContact_Last(long groupId,
		String contactID, OrderByComparator orderByComparator)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = fetchByContact_Last(groupId,
				contactID, orderByComparator);

		if (contactInformation != null) {
			return contactInformation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contactID=");
		msg.append(contactID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactInformationException(msg.toString());
	}

	/**
	 * Returns the last contact information in the ordered set where groupId = &#63; and contactID = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contactID the contact i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact information, or <code>null</code> if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation fetchByContact_Last(long groupId,
		String contactID, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByContact(groupId, contactID);

		if (count == 0) {
			return null;
		}

		List<ContactInformation> list = findByContact(groupId, contactID,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contact informations before and after the current contact information in the ordered set where groupId = &#63; and contactID = &#63;.
	 *
	 * @param contactinformationId the primary key of the current contact information
	 * @param groupId the group ID
	 * @param contactID the contact i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a contact information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation[] findByContact_PrevAndNext(
		long contactinformationId, long groupId, String contactID,
		OrderByComparator orderByComparator)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = findByPrimaryKey(contactinformationId);

		Session session = null;

		try {
			session = openSession();

			ContactInformation[] array = new ContactInformationImpl[3];

			array[0] = getByContact_PrevAndNext(session, contactInformation,
					groupId, contactID, orderByComparator, true);

			array[1] = contactInformation;

			array[2] = getByContact_PrevAndNext(session, contactInformation,
					groupId, contactID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactInformation getByContact_PrevAndNext(Session session,
		ContactInformation contactInformation, long groupId, String contactID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTINFORMATION_WHERE);

		query.append(_FINDER_COLUMN_CONTACT_GROUPID_2);

		boolean bindContactID = false;

		if (contactID == null) {
			query.append(_FINDER_COLUMN_CONTACT_CONTACTID_1);
		}
		else if (contactID.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CONTACT_CONTACTID_3);
		}
		else {
			bindContactID = true;

			query.append(_FINDER_COLUMN_CONTACT_CONTACTID_2);
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
			query.append(ContactInformationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindContactID) {
			qPos.add(contactID);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactInformation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactInformation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact informations where groupId = &#63; and contactID = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param contactID the contact i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContact(long groupId, String contactID)
		throws SystemException {
		for (ContactInformation contactInformation : findByContact(groupId,
				contactID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contactInformation);
		}
	}

	/**
	 * Returns the number of contact informations where groupId = &#63; and contactID = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contactID the contact i d
	 * @return the number of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContact(long groupId, String contactID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTACT;

		Object[] finderArgs = new Object[] { groupId, contactID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_CONTACT_GROUPID_2);

			boolean bindContactID = false;

			if (contactID == null) {
				query.append(_FINDER_COLUMN_CONTACT_CONTACTID_1);
			}
			else if (contactID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONTACT_CONTACTID_3);
			}
			else {
				bindContactID = true;

				query.append(_FINDER_COLUMN_CONTACT_CONTACTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindContactID) {
					qPos.add(contactID);
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

	private static final String _FINDER_COLUMN_CONTACT_GROUPID_2 = "contactInformation.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CONTACT_CONTACTID_1 = "contactInformation.contactID IS NULL";
	private static final String _FINDER_COLUMN_CONTACT_CONTACTID_2 = "contactInformation.contactID = ?";
	private static final String _FINDER_COLUMN_CONTACT_CONTACTID_3 = "(contactInformation.contactID IS NULL OR contactInformation.contactID = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_CONTACTBBMRIERICID = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED,
			ContactInformationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByContactBBMRIERICID",
			new String[] { Long.class.getName(), String.class.getName() },
			ContactInformationModelImpl.GROUPID_COLUMN_BITMASK |
			ContactInformationModelImpl.CONTACTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTBBMRIERICID = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByContactBBMRIERICID",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the contact information where groupId = &#63; and contactID = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException} if it could not be found.
	 *
	 * @param groupId the group ID
	 * @param contactID the contact i d
	 * @return the matching contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation findByContactBBMRIERICID(long groupId,
		String contactID)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = fetchByContactBBMRIERICID(groupId,
				contactID);

		if (contactInformation == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", contactID=");
			msg.append(contactID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchContactInformationException(msg.toString());
		}

		return contactInformation;
	}

	/**
	 * Returns the contact information where groupId = &#63; and contactID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param groupId the group ID
	 * @param contactID the contact i d
	 * @return the matching contact information, or <code>null</code> if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation fetchByContactBBMRIERICID(long groupId,
		String contactID) throws SystemException {
		return fetchByContactBBMRIERICID(groupId, contactID, true);
	}

	/**
	 * Returns the contact information where groupId = &#63; and contactID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param groupId the group ID
	 * @param contactID the contact i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching contact information, or <code>null</code> if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation fetchByContactBBMRIERICID(long groupId,
		String contactID, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { groupId, contactID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CONTACTBBMRIERICID,
					finderArgs, this);
		}

		if (result instanceof ContactInformation) {
			ContactInformation contactInformation = (ContactInformation)result;

			if ((groupId != contactInformation.getGroupId()) ||
					!Validator.equals(contactID,
						contactInformation.getContactID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CONTACTINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_CONTACTBBMRIERICID_GROUPID_2);

			boolean bindContactID = false;

			if (contactID == null) {
				query.append(_FINDER_COLUMN_CONTACTBBMRIERICID_CONTACTID_1);
			}
			else if (contactID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONTACTBBMRIERICID_CONTACTID_3);
			}
			else {
				bindContactID = true;

				query.append(_FINDER_COLUMN_CONTACTBBMRIERICID_CONTACTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindContactID) {
					qPos.add(contactID);
				}

				List<ContactInformation> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTBBMRIERICID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ContactInformationPersistenceImpl.fetchByContactBBMRIERICID(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ContactInformation contactInformation = list.get(0);

					result = contactInformation;

					cacheResult(contactInformation);

					if ((contactInformation.getGroupId() != groupId) ||
							(contactInformation.getContactID() == null) ||
							!contactInformation.getContactID().equals(contactID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTBBMRIERICID,
							finderArgs, contactInformation);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTACTBBMRIERICID,
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
			return (ContactInformation)result;
		}
	}

	/**
	 * Removes the contact information where groupId = &#63; and contactID = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param contactID the contact i d
	 * @return the contact information that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation removeByContactBBMRIERICID(long groupId,
		String contactID)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = findByContactBBMRIERICID(groupId,
				contactID);

		return remove(contactInformation);
	}

	/**
	 * Returns the number of contact informations where groupId = &#63; and contactID = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contactID the contact i d
	 * @return the number of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContactBBMRIERICID(long groupId, String contactID)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTACTBBMRIERICID;

		Object[] finderArgs = new Object[] { groupId, contactID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_CONTACTBBMRIERICID_GROUPID_2);

			boolean bindContactID = false;

			if (contactID == null) {
				query.append(_FINDER_COLUMN_CONTACTBBMRIERICID_CONTACTID_1);
			}
			else if (contactID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONTACTBBMRIERICID_CONTACTID_3);
			}
			else {
				bindContactID = true;

				query.append(_FINDER_COLUMN_CONTACTBBMRIERICID_CONTACTID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindContactID) {
					qPos.add(contactID);
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

	private static final String _FINDER_COLUMN_CONTACTBBMRIERICID_GROUPID_2 = "contactInformation.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CONTACTBBMRIERICID_CONTACTID_1 = "contactInformation.contactID IS NULL";
	private static final String _FINDER_COLUMN_CONTACTBBMRIERICID_CONTACTID_2 = "contactInformation.contactID = ?";
	private static final String _FINDER_COLUMN_CONTACTBBMRIERICID_CONTACTID_3 = "(contactInformation.contactID IS NULL OR contactInformation.contactID = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTUUID = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED,
			ContactInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNotUUID",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOTUUID = new FinderPath(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByNotUUID",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the contact informations where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @return the matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findByNotUUID(long groupId,
		String updateuuid) throws SystemException {
		return findByNotUUID(groupId, updateuuid, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact informations where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param start the lower bound of the range of contact informations
	 * @param end the upper bound of the range of contact informations (not inclusive)
	 * @return the range of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findByNotUUID(long groupId,
		String updateuuid, int start, int end) throws SystemException {
		return findByNotUUID(groupId, updateuuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact informations where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param start the lower bound of the range of contact informations
	 * @param end the upper bound of the range of contact informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findByNotUUID(long groupId,
		String updateuuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTUUID;
		finderArgs = new Object[] {
				groupId, updateuuid,
				
				start, end, orderByComparator
			};

		List<ContactInformation> list = (List<ContactInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ContactInformation contactInformation : list) {
				if ((groupId != contactInformation.getGroupId()) ||
						Validator.equals(updateuuid,
							contactInformation.getUpdateuuid())) {
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

			query.append(_SQL_SELECT_CONTACTINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_NOTUUID_GROUPID_2);

			boolean bindUpdateuuid = false;

			if (updateuuid == null) {
				query.append(_FINDER_COLUMN_NOTUUID_UPDATEUUID_1);
			}
			else if (updateuuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOTUUID_UPDATEUUID_3);
			}
			else {
				bindUpdateuuid = true;

				query.append(_FINDER_COLUMN_NOTUUID_UPDATEUUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ContactInformationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindUpdateuuid) {
					qPos.add(updateuuid);
				}

				if (!pagination) {
					list = (List<ContactInformation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactInformation>(list);
				}
				else {
					list = (List<ContactInformation>)QueryUtil.list(q,
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
	 * Returns the first contact information in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation findByNotUUID_First(long groupId,
		String updateuuid, OrderByComparator orderByComparator)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = fetchByNotUUID_First(groupId,
				updateuuid, orderByComparator);

		if (contactInformation != null) {
			return contactInformation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", updateuuid=");
		msg.append(updateuuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactInformationException(msg.toString());
	}

	/**
	 * Returns the first contact information in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact information, or <code>null</code> if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation fetchByNotUUID_First(long groupId,
		String updateuuid, OrderByComparator orderByComparator)
		throws SystemException {
		List<ContactInformation> list = findByNotUUID(groupId, updateuuid, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last contact information in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation findByNotUUID_Last(long groupId,
		String updateuuid, OrderByComparator orderByComparator)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = fetchByNotUUID_Last(groupId,
				updateuuid, orderByComparator);

		if (contactInformation != null) {
			return contactInformation;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", updateuuid=");
		msg.append(updateuuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchContactInformationException(msg.toString());
	}

	/**
	 * Returns the last contact information in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact information, or <code>null</code> if a matching contact information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation fetchByNotUUID_Last(long groupId,
		String updateuuid, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByNotUUID(groupId, updateuuid);

		if (count == 0) {
			return null;
		}

		List<ContactInformation> list = findByNotUUID(groupId, updateuuid,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the contact informations before and after the current contact information in the ordered set where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param contactinformationId the primary key of the current contact information
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a contact information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation[] findByNotUUID_PrevAndNext(
		long contactinformationId, long groupId, String updateuuid,
		OrderByComparator orderByComparator)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = findByPrimaryKey(contactinformationId);

		Session session = null;

		try {
			session = openSession();

			ContactInformation[] array = new ContactInformationImpl[3];

			array[0] = getByNotUUID_PrevAndNext(session, contactInformation,
					groupId, updateuuid, orderByComparator, true);

			array[1] = contactInformation;

			array[2] = getByNotUUID_PrevAndNext(session, contactInformation,
					groupId, updateuuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactInformation getByNotUUID_PrevAndNext(Session session,
		ContactInformation contactInformation, long groupId, String updateuuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTINFORMATION_WHERE);

		query.append(_FINDER_COLUMN_NOTUUID_GROUPID_2);

		boolean bindUpdateuuid = false;

		if (updateuuid == null) {
			query.append(_FINDER_COLUMN_NOTUUID_UPDATEUUID_1);
		}
		else if (updateuuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NOTUUID_UPDATEUUID_3);
		}
		else {
			bindUpdateuuid = true;

			query.append(_FINDER_COLUMN_NOTUUID_UPDATEUUID_2);
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
			query.append(ContactInformationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindUpdateuuid) {
			qPos.add(updateuuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactInformation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactInformation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the contact informations where groupId = &#63; and updateuuid &ne; &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNotUUID(long groupId, String updateuuid)
		throws SystemException {
		for (ContactInformation contactInformation : findByNotUUID(groupId,
				updateuuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(contactInformation);
		}
	}

	/**
	 * Returns the number of contact informations where groupId = &#63; and updateuuid &ne; &#63;.
	 *
	 * @param groupId the group ID
	 * @param updateuuid the updateuuid
	 * @return the number of matching contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNotUUID(long groupId, String updateuuid)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOTUUID;

		Object[] finderArgs = new Object[] { groupId, updateuuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_NOTUUID_GROUPID_2);

			boolean bindUpdateuuid = false;

			if (updateuuid == null) {
				query.append(_FINDER_COLUMN_NOTUUID_UPDATEUUID_1);
			}
			else if (updateuuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOTUUID_UPDATEUUID_3);
			}
			else {
				bindUpdateuuid = true;

				query.append(_FINDER_COLUMN_NOTUUID_UPDATEUUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindUpdateuuid) {
					qPos.add(updateuuid);
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

	private static final String _FINDER_COLUMN_NOTUUID_GROUPID_2 = "contactInformation.groupId = ? AND ";
	private static final String _FINDER_COLUMN_NOTUUID_UPDATEUUID_1 = "contactInformation.updateuuid IS NOT NULL";
	private static final String _FINDER_COLUMN_NOTUUID_UPDATEUUID_2 = "contactInformation.updateuuid != ?";
	private static final String _FINDER_COLUMN_NOTUUID_UPDATEUUID_3 = "(contactInformation.updateuuid IS NULL OR contactInformation.updateuuid != '')";

	public ContactInformationPersistenceImpl() {
		setModelClass(ContactInformation.class);
	}

	/**
	 * Caches the contact information in the entity cache if it is enabled.
	 *
	 * @param contactInformation the contact information
	 */
	@Override
	public void cacheResult(ContactInformation contactInformation) {
		EntityCacheUtil.putResult(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationImpl.class, contactInformation.getPrimaryKey(),
			contactInformation);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				contactInformation.getUuid(), contactInformation.getGroupId()
			}, contactInformation);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTBBMRIERICID,
			new Object[] {
				contactInformation.getGroupId(),
				contactInformation.getContactID()
			}, contactInformation);

		contactInformation.resetOriginalValues();
	}

	/**
	 * Caches the contact informations in the entity cache if it is enabled.
	 *
	 * @param contactInformations the contact informations
	 */
	@Override
	public void cacheResult(List<ContactInformation> contactInformations) {
		for (ContactInformation contactInformation : contactInformations) {
			if (EntityCacheUtil.getResult(
						ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
						ContactInformationImpl.class,
						contactInformation.getPrimaryKey()) == null) {
				cacheResult(contactInformation);
			}
			else {
				contactInformation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contact informations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContactInformationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContactInformationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contact information.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContactInformation contactInformation) {
		EntityCacheUtil.removeResult(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationImpl.class, contactInformation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(contactInformation);
	}

	@Override
	public void clearCache(List<ContactInformation> contactInformations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContactInformation contactInformation : contactInformations) {
			EntityCacheUtil.removeResult(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
				ContactInformationImpl.class, contactInformation.getPrimaryKey());

			clearUniqueFindersCache(contactInformation);
		}
	}

	protected void cacheUniqueFindersCache(
		ContactInformation contactInformation) {
		if (contactInformation.isNew()) {
			Object[] args = new Object[] {
					contactInformation.getUuid(),
					contactInformation.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				contactInformation);

			args = new Object[] {
					contactInformation.getGroupId(),
					contactInformation.getContactID()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTACTBBMRIERICID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTBBMRIERICID,
				args, contactInformation);
		}
		else {
			ContactInformationModelImpl contactInformationModelImpl = (ContactInformationModelImpl)contactInformation;

			if ((contactInformationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contactInformation.getUuid(),
						contactInformation.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					contactInformation);
			}

			if ((contactInformationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CONTACTBBMRIERICID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contactInformation.getGroupId(),
						contactInformation.getContactID()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTACTBBMRIERICID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTBBMRIERICID,
					args, contactInformation);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ContactInformation contactInformation) {
		ContactInformationModelImpl contactInformationModelImpl = (ContactInformationModelImpl)contactInformation;

		Object[] args = new Object[] {
				contactInformation.getUuid(), contactInformation.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((contactInformationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					contactInformationModelImpl.getOriginalUuid(),
					contactInformationModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				contactInformation.getGroupId(),
				contactInformation.getContactID()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTBBMRIERICID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTACTBBMRIERICID,
			args);

		if ((contactInformationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CONTACTBBMRIERICID.getColumnBitmask()) != 0) {
			args = new Object[] {
					contactInformationModelImpl.getOriginalGroupId(),
					contactInformationModelImpl.getOriginalContactID()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTBBMRIERICID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTACTBBMRIERICID,
				args);
		}
	}

	/**
	 * Creates a new contact information with the primary key. Does not add the contact information to the database.
	 *
	 * @param contactinformationId the primary key for the new contact information
	 * @return the new contact information
	 */
	@Override
	public ContactInformation create(long contactinformationId) {
		ContactInformation contactInformation = new ContactInformationImpl();

		contactInformation.setNew(true);
		contactInformation.setPrimaryKey(contactinformationId);

		String uuid = PortalUUIDUtil.generate();

		contactInformation.setUuid(uuid);

		return contactInformation;
	}

	/**
	 * Removes the contact information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactinformationId the primary key of the contact information
	 * @return the contact information that was removed
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a contact information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation remove(long contactinformationId)
		throws NoSuchContactInformationException, SystemException {
		return remove((Serializable)contactinformationId);
	}

	/**
	 * Removes the contact information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contact information
	 * @return the contact information that was removed
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a contact information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation remove(Serializable primaryKey)
		throws NoSuchContactInformationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContactInformation contactInformation = (ContactInformation)session.get(ContactInformationImpl.class,
					primaryKey);

			if (contactInformation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactInformationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contactInformation);
		}
		catch (NoSuchContactInformationException nsee) {
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
	protected ContactInformation removeImpl(
		ContactInformation contactInformation) throws SystemException {
		contactInformation = toUnwrappedModel(contactInformation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contactInformation)) {
				contactInformation = (ContactInformation)session.get(ContactInformationImpl.class,
						contactInformation.getPrimaryKeyObj());
			}

			if (contactInformation != null) {
				session.delete(contactInformation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (contactInformation != null) {
			clearCache(contactInformation);
		}

		return contactInformation;
	}

	@Override
	public ContactInformation updateImpl(
		at.meduni.liferay.portlet.bbmrieric.model.ContactInformation contactInformation)
		throws SystemException {
		contactInformation = toUnwrappedModel(contactInformation);

		boolean isNew = contactInformation.isNew();

		ContactInformationModelImpl contactInformationModelImpl = (ContactInformationModelImpl)contactInformation;

		if (Validator.isNull(contactInformation.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			contactInformation.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (contactInformation.isNew()) {
				session.save(contactInformation);

				contactInformation.setNew(false);
			}
			else {
				session.merge(contactInformation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContactInformationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contactInformationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contactInformationModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { contactInformationModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((contactInformationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contactInformationModelImpl.getOriginalUuid(),
						contactInformationModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						contactInformationModelImpl.getUuid(),
						contactInformationModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((contactInformationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contactInformationModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { contactInformationModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((contactInformationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contactInformationModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { contactInformationModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((contactInformationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contactInformationModelImpl.getOriginalGroupId(),
						contactInformationModelImpl.getOriginalContactID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT,
					args);

				args = new Object[] {
						contactInformationModelImpl.getGroupId(),
						contactInformationModelImpl.getContactID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACT,
					args);
			}
		}

		EntityCacheUtil.putResult(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
			ContactInformationImpl.class, contactInformation.getPrimaryKey(),
			contactInformation);

		clearUniqueFindersCache(contactInformation);
		cacheUniqueFindersCache(contactInformation);

		return contactInformation;
	}

	protected ContactInformation toUnwrappedModel(
		ContactInformation contactInformation) {
		if (contactInformation instanceof ContactInformationImpl) {
			return contactInformation;
		}

		ContactInformationImpl contactInformationImpl = new ContactInformationImpl();

		contactInformationImpl.setNew(contactInformation.isNew());
		contactInformationImpl.setPrimaryKey(contactInformation.getPrimaryKey());

		contactInformationImpl.setUuid(contactInformation.getUuid());
		contactInformationImpl.setContactinformationId(contactInformation.getContactinformationId());
		contactInformationImpl.setCompanyId(contactInformation.getCompanyId());
		contactInformationImpl.setGroupId(contactInformation.getGroupId());
		contactInformationImpl.setUserId(contactInformation.getUserId());
		contactInformationImpl.setUserName(contactInformation.getUserName());
		contactInformationImpl.setCreateDate(contactInformation.getCreateDate());
		contactInformationImpl.setModifiedDate(contactInformation.getModifiedDate());
		contactInformationImpl.setUpdateuuid(contactInformation.getUpdateuuid());
		contactInformationImpl.setContactID(contactInformation.getContactID());
		contactInformationImpl.setContactEmail(contactInformation.getContactEmail());
		contactInformationImpl.setContactCountry(contactInformation.getContactCountry());
		contactInformationImpl.setContactFirstName(contactInformation.getContactFirstName());
		contactInformationImpl.setContactLastName(contactInformation.getContactLastName());
		contactInformationImpl.setContactPhone(contactInformation.getContactPhone());
		contactInformationImpl.setContactAddress(contactInformation.getContactAddress());
		contactInformationImpl.setContactZIP(contactInformation.getContactZIP());
		contactInformationImpl.setContactCity(contactInformation.getContactCity());

		return contactInformationImpl;
	}

	/**
	 * Returns the contact information with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact information
	 * @return the contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a contact information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContactInformationException, SystemException {
		ContactInformation contactInformation = fetchByPrimaryKey(primaryKey);

		if (contactInformation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContactInformationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return contactInformation;
	}

	/**
	 * Returns the contact information with the primary key or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException} if it could not be found.
	 *
	 * @param contactinformationId the primary key of the contact information
	 * @return the contact information
	 * @throws at.meduni.liferay.portlet.bbmrieric.NoSuchContactInformationException if a contact information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation findByPrimaryKey(long contactinformationId)
		throws NoSuchContactInformationException, SystemException {
		return findByPrimaryKey((Serializable)contactinformationId);
	}

	/**
	 * Returns the contact information with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact information
	 * @return the contact information, or <code>null</code> if a contact information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ContactInformation contactInformation = (ContactInformation)EntityCacheUtil.getResult(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
				ContactInformationImpl.class, primaryKey);

		if (contactInformation == _nullContactInformation) {
			return null;
		}

		if (contactInformation == null) {
			Session session = null;

			try {
				session = openSession();

				contactInformation = (ContactInformation)session.get(ContactInformationImpl.class,
						primaryKey);

				if (contactInformation != null) {
					cacheResult(contactInformation);
				}
				else {
					EntityCacheUtil.putResult(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
						ContactInformationImpl.class, primaryKey,
						_nullContactInformation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ContactInformationModelImpl.ENTITY_CACHE_ENABLED,
					ContactInformationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return contactInformation;
	}

	/**
	 * Returns the contact information with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactinformationId the primary key of the contact information
	 * @return the contact information, or <code>null</code> if a contact information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactInformation fetchByPrimaryKey(long contactinformationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)contactinformationId);
	}

	/**
	 * Returns all the contact informations.
	 *
	 * @return the contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact informations
	 * @param end the upper bound of the range of contact informations (not inclusive)
	 * @return the range of contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.ContactInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact informations
	 * @param end the upper bound of the range of contact informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contact informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ContactInformation> findAll(int start, int end,
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

		List<ContactInformation> list = (List<ContactInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTACTINFORMATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTINFORMATION;

				if (pagination) {
					sql = sql.concat(ContactInformationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ContactInformation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ContactInformation>(list);
				}
				else {
					list = (List<ContactInformation>)QueryUtil.list(q,
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
	 * Removes all the contact informations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ContactInformation contactInformation : findAll()) {
			remove(contactInformation);
		}
	}

	/**
	 * Returns the number of contact informations.
	 *
	 * @return the number of contact informations
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

				Query q = session.createQuery(_SQL_COUNT_CONTACTINFORMATION);

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
	 * Initializes the contact information persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.at.meduni.liferay.portlet.bbmrieric.model.ContactInformation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContactInformation>> listenersList = new ArrayList<ModelListener<ContactInformation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContactInformation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContactInformationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONTACTINFORMATION = "SELECT contactInformation FROM ContactInformation contactInformation";
	private static final String _SQL_SELECT_CONTACTINFORMATION_WHERE = "SELECT contactInformation FROM ContactInformation contactInformation WHERE ";
	private static final String _SQL_COUNT_CONTACTINFORMATION = "SELECT COUNT(contactInformation) FROM ContactInformation contactInformation";
	private static final String _SQL_COUNT_CONTACTINFORMATION_WHERE = "SELECT COUNT(contactInformation) FROM ContactInformation contactInformation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contactInformation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContactInformation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContactInformation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContactInformationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ContactInformation _nullContactInformation = new ContactInformationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContactInformation> toCacheModel() {
				return _nullContactInformationCacheModel;
			}
		};

	private static CacheModel<ContactInformation> _nullContactInformationCacheModel =
		new CacheModel<ContactInformation>() {
			@Override
			public ContactInformation toEntityModel() {
				return _nullContactInformation;
			}
		};
}