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

import at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the disease discription service. This utility wraps {@link DiseaseDiscriptionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see DiseaseDiscriptionPersistence
 * @see DiseaseDiscriptionPersistenceImpl
 * @generated
 */
public class DiseaseDiscriptionUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(DiseaseDiscription diseaseDiscription) {
		getPersistence().clearCache(diseaseDiscription);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DiseaseDiscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DiseaseDiscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DiseaseDiscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DiseaseDiscription update(
		DiseaseDiscription diseaseDiscription) throws SystemException {
		return getPersistence().update(diseaseDiscription);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DiseaseDiscription update(
		DiseaseDiscription diseaseDiscription, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(diseaseDiscription, serviceContext);
	}

	/**
	* Returns the disease discription where diseasecode = &#63; or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException} if it could not be found.
	*
	* @param diseasecode the diseasecode
	* @return the matching disease discription
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a matching disease discription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription findByDiseaseCode(
		java.lang.String diseasecode)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDiseaseCode(diseasecode);
	}

	/**
	* Returns the disease discription where diseasecode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param diseasecode the diseasecode
	* @return the matching disease discription, or <code>null</code> if a matching disease discription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription fetchByDiseaseCode(
		java.lang.String diseasecode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDiseaseCode(diseasecode);
	}

	/**
	* Returns the disease discription where diseasecode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param diseasecode the diseasecode
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching disease discription, or <code>null</code> if a matching disease discription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription fetchByDiseaseCode(
		java.lang.String diseasecode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDiseaseCode(diseasecode, retrieveFromCache);
	}

	/**
	* Removes the disease discription where diseasecode = &#63; from the database.
	*
	* @param diseasecode the diseasecode
	* @return the disease discription that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription removeByDiseaseCode(
		java.lang.String diseasecode)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByDiseaseCode(diseasecode);
	}

	/**
	* Returns the number of disease discriptions where diseasecode = &#63;.
	*
	* @param diseasecode the diseasecode
	* @return the number of matching disease discriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDiseaseCode(java.lang.String diseasecode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDiseaseCode(diseasecode);
	}

	/**
	* Returns all the disease discriptions where diseasegroup = &#63;.
	*
	* @param diseasegroup the diseasegroup
	* @return the matching disease discriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription> findByDiseaseGroup(
		java.lang.String diseasegroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDiseaseGroup(diseasegroup);
	}

	/**
	* Returns a range of all the disease discriptions where diseasegroup = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.DiseaseDiscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param diseasegroup the diseasegroup
	* @param start the lower bound of the range of disease discriptions
	* @param end the upper bound of the range of disease discriptions (not inclusive)
	* @return the range of matching disease discriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription> findByDiseaseGroup(
		java.lang.String diseasegroup, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDiseaseGroup(diseasegroup, start, end);
	}

	/**
	* Returns an ordered range of all the disease discriptions where diseasegroup = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.DiseaseDiscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param diseasegroup the diseasegroup
	* @param start the lower bound of the range of disease discriptions
	* @param end the upper bound of the range of disease discriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching disease discriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription> findByDiseaseGroup(
		java.lang.String diseasegroup, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDiseaseGroup(diseasegroup, start, end,
			orderByComparator);
	}

	/**
	* Returns the first disease discription in the ordered set where diseasegroup = &#63;.
	*
	* @param diseasegroup the diseasegroup
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching disease discription
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a matching disease discription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription findByDiseaseGroup_First(
		java.lang.String diseasegroup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDiseaseGroup_First(diseasegroup, orderByComparator);
	}

	/**
	* Returns the first disease discription in the ordered set where diseasegroup = &#63;.
	*
	* @param diseasegroup the diseasegroup
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching disease discription, or <code>null</code> if a matching disease discription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription fetchByDiseaseGroup_First(
		java.lang.String diseasegroup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDiseaseGroup_First(diseasegroup, orderByComparator);
	}

	/**
	* Returns the last disease discription in the ordered set where diseasegroup = &#63;.
	*
	* @param diseasegroup the diseasegroup
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching disease discription
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a matching disease discription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription findByDiseaseGroup_Last(
		java.lang.String diseasegroup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDiseaseGroup_Last(diseasegroup, orderByComparator);
	}

	/**
	* Returns the last disease discription in the ordered set where diseasegroup = &#63;.
	*
	* @param diseasegroup the diseasegroup
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching disease discription, or <code>null</code> if a matching disease discription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription fetchByDiseaseGroup_Last(
		java.lang.String diseasegroup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDiseaseGroup_Last(diseasegroup, orderByComparator);
	}

	/**
	* Returns the disease discriptions before and after the current disease discription in the ordered set where diseasegroup = &#63;.
	*
	* @param diseasediscriptionId the primary key of the current disease discription
	* @param diseasegroup the diseasegroup
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next disease discription
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a disease discription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription[] findByDiseaseGroup_PrevAndNext(
		long diseasediscriptionId, java.lang.String diseasegroup,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDiseaseGroup_PrevAndNext(diseasediscriptionId,
			diseasegroup, orderByComparator);
	}

	/**
	* Removes all the disease discriptions where diseasegroup = &#63; from the database.
	*
	* @param diseasegroup the diseasegroup
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDiseaseGroup(java.lang.String diseasegroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDiseaseGroup(diseasegroup);
	}

	/**
	* Returns the number of disease discriptions where diseasegroup = &#63;.
	*
	* @param diseasegroup the diseasegroup
	* @return the number of matching disease discriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDiseaseGroup(java.lang.String diseasegroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDiseaseGroup(diseasegroup);
	}

	/**
	* Returns all the disease discriptions where root = &#63;.
	*
	* @param root the root
	* @return the matching disease discriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription> findByRoot(
		boolean root)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoot(root);
	}

	/**
	* Returns a range of all the disease discriptions where root = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.DiseaseDiscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param root the root
	* @param start the lower bound of the range of disease discriptions
	* @param end the upper bound of the range of disease discriptions (not inclusive)
	* @return the range of matching disease discriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription> findByRoot(
		boolean root, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoot(root, start, end);
	}

	/**
	* Returns an ordered range of all the disease discriptions where root = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.DiseaseDiscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param root the root
	* @param start the lower bound of the range of disease discriptions
	* @param end the upper bound of the range of disease discriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching disease discriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription> findByRoot(
		boolean root, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoot(root, start, end, orderByComparator);
	}

	/**
	* Returns the first disease discription in the ordered set where root = &#63;.
	*
	* @param root the root
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching disease discription
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a matching disease discription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription findByRoot_First(
		boolean root,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoot_First(root, orderByComparator);
	}

	/**
	* Returns the first disease discription in the ordered set where root = &#63;.
	*
	* @param root the root
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching disease discription, or <code>null</code> if a matching disease discription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription fetchByRoot_First(
		boolean root,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRoot_First(root, orderByComparator);
	}

	/**
	* Returns the last disease discription in the ordered set where root = &#63;.
	*
	* @param root the root
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching disease discription
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a matching disease discription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription findByRoot_Last(
		boolean root,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRoot_Last(root, orderByComparator);
	}

	/**
	* Returns the last disease discription in the ordered set where root = &#63;.
	*
	* @param root the root
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching disease discription, or <code>null</code> if a matching disease discription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription fetchByRoot_Last(
		boolean root,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRoot_Last(root, orderByComparator);
	}

	/**
	* Returns the disease discriptions before and after the current disease discription in the ordered set where root = &#63;.
	*
	* @param diseasediscriptionId the primary key of the current disease discription
	* @param root the root
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next disease discription
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a disease discription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription[] findByRoot_PrevAndNext(
		long diseasediscriptionId, boolean root,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRoot_PrevAndNext(diseasediscriptionId, root,
			orderByComparator);
	}

	/**
	* Removes all the disease discriptions where root = &#63; from the database.
	*
	* @param root the root
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRoot(boolean root)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRoot(root);
	}

	/**
	* Returns the number of disease discriptions where root = &#63;.
	*
	* @param root the root
	* @return the number of matching disease discriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRoot(boolean root)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRoot(root);
	}

	/**
	* Caches the disease discription in the entity cache if it is enabled.
	*
	* @param diseaseDiscription the disease discription
	*/
	public static void cacheResult(
		at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription diseaseDiscription) {
		getPersistence().cacheResult(diseaseDiscription);
	}

	/**
	* Caches the disease discriptions in the entity cache if it is enabled.
	*
	* @param diseaseDiscriptions the disease discriptions
	*/
	public static void cacheResult(
		java.util.List<at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription> diseaseDiscriptions) {
		getPersistence().cacheResult(diseaseDiscriptions);
	}

	/**
	* Creates a new disease discription with the primary key. Does not add the disease discription to the database.
	*
	* @param diseasediscriptionId the primary key for the new disease discription
	* @return the new disease discription
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription create(
		long diseasediscriptionId) {
		return getPersistence().create(diseasediscriptionId);
	}

	/**
	* Removes the disease discription with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param diseasediscriptionId the primary key of the disease discription
	* @return the disease discription that was removed
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a disease discription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription remove(
		long diseasediscriptionId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(diseasediscriptionId);
	}

	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription updateImpl(
		at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription diseaseDiscription)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(diseaseDiscription);
	}

	/**
	* Returns the disease discription with the primary key or throws a {@link at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException} if it could not be found.
	*
	* @param diseasediscriptionId the primary key of the disease discription
	* @return the disease discription
	* @throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException if a disease discription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription findByPrimaryKey(
		long diseasediscriptionId)
		throws at.meduni.liferay.portlet.bbmrieric.NoSuchDiseaseDiscriptionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(diseasediscriptionId);
	}

	/**
	* Returns the disease discription with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param diseasediscriptionId the primary key of the disease discription
	* @return the disease discription, or <code>null</code> if a disease discription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription fetchByPrimaryKey(
		long diseasediscriptionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(diseasediscriptionId);
	}

	/**
	* Returns all the disease discriptions.
	*
	* @return the disease discriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the disease discriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.DiseaseDiscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of disease discriptions
	* @param end the upper bound of the range of disease discriptions (not inclusive)
	* @return the range of disease discriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the disease discriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.meduni.liferay.portlet.bbmrieric.model.impl.DiseaseDiscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of disease discriptions
	* @param end the upper bound of the range of disease discriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of disease discriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<at.meduni.liferay.portlet.bbmrieric.model.DiseaseDiscription> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the disease discriptions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of disease discriptions.
	*
	* @return the number of disease discriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DiseaseDiscriptionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DiseaseDiscriptionPersistence)PortletBeanLocatorUtil.locate(at.meduni.liferay.portlet.bbmrieric.service.ClpSerializer.getServletContextName(),
					DiseaseDiscriptionPersistence.class.getName());

			ReferenceRegistry.registerReference(DiseaseDiscriptionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DiseaseDiscriptionPersistence persistence) {
	}

	private static DiseaseDiscriptionPersistence _persistence;
}