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

package com.inkwell.internet.productregistration.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for PRProduct. This utility wraps
 * {@link com.inkwell.internet.productregistration.service.impl.PRProductLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Rich Sezov
 * @see PRProductLocalService
 * @see com.inkwell.internet.productregistration.service.base.PRProductLocalServiceBaseImpl
 * @see com.inkwell.internet.productregistration.service.impl.PRProductLocalServiceImpl
 * @generated
 */
public class PRProductLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.inkwell.internet.productregistration.service.impl.PRProductLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the p r product to the database. Also notifies the appropriate model listeners.
	*
	* @param prProduct the p r product
	* @return the p r product that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRProduct addPRProduct(
		com.inkwell.internet.productregistration.model.PRProduct prProduct)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPRProduct(prProduct);
	}

	/**
	* Creates a new p r product with the primary key. Does not add the p r product to the database.
	*
	* @param productId the primary key for the new p r product
	* @return the new p r product
	*/
	public static com.inkwell.internet.productregistration.model.PRProduct createPRProduct(
		long productId) {
		return getService().createPRProduct(productId);
	}

	/**
	* Deletes the p r product with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param productId the primary key of the p r product
	* @return the p r product that was removed
	* @throws PortalException if a p r product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRProduct deletePRProduct(
		long productId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePRProduct(productId);
	}

	/**
	* Deletes the p r product from the database. Also notifies the appropriate model listeners.
	*
	* @param prProduct the p r product
	* @return the p r product that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRProduct deletePRProduct(
		com.inkwell.internet.productregistration.model.PRProduct prProduct)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePRProduct(prProduct);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.inkwell.internet.productregistration.model.PRProduct fetchPRProduct(
		long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPRProduct(productId);
	}

	/**
	* Returns the p r product with the primary key.
	*
	* @param productId the primary key of the p r product
	* @return the p r product
	* @throws PortalException if a p r product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRProduct getPRProduct(
		long productId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPRProduct(productId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the p r products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.inkwell.internet.productregistration.model.impl.PRProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p r products
	* @param end the upper bound of the range of p r products (not inclusive)
	* @return the range of p r products
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRProduct> getPRProducts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPRProducts(start, end);
	}

	/**
	* Returns the number of p r products.
	*
	* @return the number of p r products
	* @throws SystemException if a system exception occurred
	*/
	public static int getPRProductsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPRProductsCount();
	}

	/**
	* Updates the p r product in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param prProduct the p r product
	* @return the p r product that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.inkwell.internet.productregistration.model.PRProduct updatePRProduct(
		com.inkwell.internet.productregistration.model.PRProduct prProduct)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePRProduct(prProduct);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Adds a new product to the database.
	*
	* @param productName
	* @param productSerial
	* @return
	* @throws com.liferay.portal.kernel.exception.SystemException
	*/
	public static com.inkwell.internet.productregistration.model.PRProduct addProduct(
		com.inkwell.internet.productregistration.model.PRProduct newProduct,
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addProduct(newProduct, userId);
	}

	/**
	* Retrieves all of the products from the database.
	*
	* @return
	* @throws com.liferay.portal.kernel.exception.SystemException
	*/
	public static java.util.List<com.inkwell.internet.productregistration.model.PRProduct> getAllProducts(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllProducts(groupId);
	}

	/**
	* Removes the specified product from the database.
	*
	* @param productId
	* @throws com.inkwell.internet.portlets.prodreg.sb.NoSuchProductException
	* @throws com.liferay.portal.kernel.exception.SystemException
	* @throws com.liferay.portal.kernel.exception.PortalException
	*/
	public static void deleteProduct(long productId)
		throws com.inkwell.internet.productregistration.NoSuchProductException,
			com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteProduct(productId);
	}

	/**
	* Removes the specified product from the database.
	*
	* @param product
	* @throws com.liferay.portal.kernel.exception.PortalException
	* @throws com.liferay.portal.kernel.exception.SystemException
	*/
	public static void deleteProduct(
		com.inkwell.internet.productregistration.model.PRProduct product)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteProduct(product);
	}

	public static void clearService() {
		_service = null;
	}

	public static PRProductLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PRProductLocalService.class.getName());

			if (invokableLocalService instanceof PRProductLocalService) {
				_service = (PRProductLocalService)invokableLocalService;
			}
			else {
				_service = new PRProductLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PRProductLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PRProductLocalService service) {
	}

	private static PRProductLocalService _service;
}