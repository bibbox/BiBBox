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

package at.rdconnect.update.service;

import at.rdconnect.update.model.AccessibilityUpdateClp;
import at.rdconnect.update.model.AddressUpdateClp;
import at.rdconnect.update.model.CoreUpdateClp;
import at.rdconnect.update.model.QualityUpdateClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author reihsr
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"UpdateRDConnect-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"UpdateRDConnect-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "UpdateRDConnect-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(AccessibilityUpdateClp.class.getName())) {
			return translateInputAccessibilityUpdate(oldModel);
		}

		if (oldModelClassName.equals(AddressUpdateClp.class.getName())) {
			return translateInputAddressUpdate(oldModel);
		}

		if (oldModelClassName.equals(CoreUpdateClp.class.getName())) {
			return translateInputCoreUpdate(oldModel);
		}

		if (oldModelClassName.equals(QualityUpdateClp.class.getName())) {
			return translateInputQualityUpdate(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputAccessibilityUpdate(
		BaseModel<?> oldModel) {
		AccessibilityUpdateClp oldClpModel = (AccessibilityUpdateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAccessibilityUpdateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputAddressUpdate(BaseModel<?> oldModel) {
		AddressUpdateClp oldClpModel = (AddressUpdateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAddressUpdateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCoreUpdate(BaseModel<?> oldModel) {
		CoreUpdateClp oldClpModel = (CoreUpdateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCoreUpdateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputQualityUpdate(BaseModel<?> oldModel) {
		QualityUpdateClp oldClpModel = (QualityUpdateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getQualityUpdateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"at.rdconnect.update.model.impl.AccessibilityUpdateImpl")) {
			return translateOutputAccessibilityUpdate(oldModel);
		}

		if (oldModelClassName.equals(
					"at.rdconnect.update.model.impl.AddressUpdateImpl")) {
			return translateOutputAddressUpdate(oldModel);
		}

		if (oldModelClassName.equals(
					"at.rdconnect.update.model.impl.CoreUpdateImpl")) {
			return translateOutputCoreUpdate(oldModel);
		}

		if (oldModelClassName.equals(
					"at.rdconnect.update.model.impl.QualityUpdateImpl")) {
			return translateOutputQualityUpdate(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"at.rdconnect.update.NoSuchAccessibilityUpdateException")) {
			return new at.rdconnect.update.NoSuchAccessibilityUpdateException();
		}

		if (className.equals("at.rdconnect.update.NoSuchAddressUpdateException")) {
			return new at.rdconnect.update.NoSuchAddressUpdateException();
		}

		if (className.equals("at.rdconnect.update.NoSuchCoreUpdateException")) {
			return new at.rdconnect.update.NoSuchCoreUpdateException();
		}

		if (className.equals("at.rdconnect.update.NoSuchQualityUpdateException")) {
			return new at.rdconnect.update.NoSuchQualityUpdateException();
		}

		return throwable;
	}

	public static Object translateOutputAccessibilityUpdate(
		BaseModel<?> oldModel) {
		AccessibilityUpdateClp newModel = new AccessibilityUpdateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAccessibilityUpdateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputAddressUpdate(BaseModel<?> oldModel) {
		AddressUpdateClp newModel = new AddressUpdateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAddressUpdateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCoreUpdate(BaseModel<?> oldModel) {
		CoreUpdateClp newModel = new CoreUpdateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCoreUpdateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputQualityUpdate(BaseModel<?> oldModel) {
		QualityUpdateClp newModel = new QualityUpdateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setQualityUpdateRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}