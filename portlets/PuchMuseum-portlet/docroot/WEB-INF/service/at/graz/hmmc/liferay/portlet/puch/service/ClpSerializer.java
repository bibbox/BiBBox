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

package at.graz.hmmc.liferay.portlet.puch.service;

import at.graz.hmmc.liferay.portlet.puch.model.ConfigurationClp;
import at.graz.hmmc.liferay.portlet.puch.model.ObjectDataClp;
import at.graz.hmmc.liferay.portlet.puch.model.ParameterConfigurationClp;
import at.graz.hmmc.liferay.portlet.puch.model.ParameterOptionsConfigurationClp;
import at.graz.hmmc.liferay.portlet.puch.model.PersonClp;
import at.graz.hmmc.liferay.portlet.puch.model.PuchMuseumsObjektClp;
import at.graz.hmmc.liferay.portlet.puch.model.TransaktionClp;

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
						"PuchMuseum-portlet-deployment-context");

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
							"PuchMuseum-portlet-deployment-context");

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
				_servletContextName = "PuchMuseum-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ConfigurationClp.class.getName())) {
			return translateInputConfiguration(oldModel);
		}

		if (oldModelClassName.equals(ObjectDataClp.class.getName())) {
			return translateInputObjectData(oldModel);
		}

		if (oldModelClassName.equals(ParameterConfigurationClp.class.getName())) {
			return translateInputParameterConfiguration(oldModel);
		}

		if (oldModelClassName.equals(
					ParameterOptionsConfigurationClp.class.getName())) {
			return translateInputParameterOptionsConfiguration(oldModel);
		}

		if (oldModelClassName.equals(PersonClp.class.getName())) {
			return translateInputPerson(oldModel);
		}

		if (oldModelClassName.equals(PuchMuseumsObjektClp.class.getName())) {
			return translateInputPuchMuseumsObjekt(oldModel);
		}

		if (oldModelClassName.equals(TransaktionClp.class.getName())) {
			return translateInputTransaktion(oldModel);
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

	public static Object translateInputConfiguration(BaseModel<?> oldModel) {
		ConfigurationClp oldClpModel = (ConfigurationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getConfigurationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputObjectData(BaseModel<?> oldModel) {
		ObjectDataClp oldClpModel = (ObjectDataClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getObjectDataRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputParameterConfiguration(
		BaseModel<?> oldModel) {
		ParameterConfigurationClp oldClpModel = (ParameterConfigurationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getParameterConfigurationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputParameterOptionsConfiguration(
		BaseModel<?> oldModel) {
		ParameterOptionsConfigurationClp oldClpModel = (ParameterOptionsConfigurationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getParameterOptionsConfigurationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPerson(BaseModel<?> oldModel) {
		PersonClp oldClpModel = (PersonClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPersonRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPuchMuseumsObjekt(BaseModel<?> oldModel) {
		PuchMuseumsObjektClp oldClpModel = (PuchMuseumsObjektClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPuchMuseumsObjektRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTransaktion(BaseModel<?> oldModel) {
		TransaktionClp oldClpModel = (TransaktionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTransaktionRemoteModel();

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
					"at.graz.hmmc.liferay.portlet.puch.model.impl.ConfigurationImpl")) {
			return translateOutputConfiguration(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.hmmc.liferay.portlet.puch.model.impl.ObjectDataImpl")) {
			return translateOutputObjectData(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterConfigurationImpl")) {
			return translateOutputParameterConfiguration(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.hmmc.liferay.portlet.puch.model.impl.ParameterOptionsConfigurationImpl")) {
			return translateOutputParameterOptionsConfiguration(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.hmmc.liferay.portlet.puch.model.impl.PersonImpl")) {
			return translateOutputPerson(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.hmmc.liferay.portlet.puch.model.impl.PuchMuseumsObjektImpl")) {
			return translateOutputPuchMuseumsObjekt(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.hmmc.liferay.portlet.puch.model.impl.TransaktionImpl")) {
			return translateOutputTransaktion(oldModel);
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
					"at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException")) {
			return new at.graz.hmmc.liferay.portlet.puch.NoSuchConfigurationException();
		}

		if (className.equals(
					"at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException")) {
			return new at.graz.hmmc.liferay.portlet.puch.NoSuchObjectDataException();
		}

		if (className.equals(
					"at.graz.hmmc.liferay.portlet.puch.NoSuchParameterConfigurationException")) {
			return new at.graz.hmmc.liferay.portlet.puch.NoSuchParameterConfigurationException();
		}

		if (className.equals(
					"at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException")) {
			return new at.graz.hmmc.liferay.portlet.puch.NoSuchParameterOptionsConfigurationException();
		}

		if (className.equals(
					"at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException")) {
			return new at.graz.hmmc.liferay.portlet.puch.NoSuchPersonException();
		}

		if (className.equals(
					"at.graz.hmmc.liferay.portlet.puch.NoSuchPuchMuseumsObjektException")) {
			return new at.graz.hmmc.liferay.portlet.puch.NoSuchPuchMuseumsObjektException();
		}

		if (className.equals(
					"at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException")) {
			return new at.graz.hmmc.liferay.portlet.puch.NoSuchTransaktionException();
		}

		return throwable;
	}

	public static Object translateOutputConfiguration(BaseModel<?> oldModel) {
		ConfigurationClp newModel = new ConfigurationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setConfigurationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputObjectData(BaseModel<?> oldModel) {
		ObjectDataClp newModel = new ObjectDataClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setObjectDataRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputParameterConfiguration(
		BaseModel<?> oldModel) {
		ParameterConfigurationClp newModel = new ParameterConfigurationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setParameterConfigurationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputParameterOptionsConfiguration(
		BaseModel<?> oldModel) {
		ParameterOptionsConfigurationClp newModel = new ParameterOptionsConfigurationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setParameterOptionsConfigurationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPerson(BaseModel<?> oldModel) {
		PersonClp newModel = new PersonClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPersonRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPuchMuseumsObjekt(BaseModel<?> oldModel) {
		PuchMuseumsObjektClp newModel = new PuchMuseumsObjektClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPuchMuseumsObjektRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTransaktion(BaseModel<?> oldModel) {
		TransaktionClp newModel = new TransaktionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTransaktionRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}