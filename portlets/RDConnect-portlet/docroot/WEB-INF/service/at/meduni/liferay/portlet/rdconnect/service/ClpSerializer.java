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

package at.meduni.liferay.portlet.rdconnect.service;

import at.meduni.liferay.portlet.rdconnect.model.AQRRatingClp;
import at.meduni.liferay.portlet.rdconnect.model.CandidateClp;
import at.meduni.liferay.portlet.rdconnect.model.MasterCandidateClp;
import at.meduni.liferay.portlet.rdconnect.model.MasterCandidateLinkCandidateClp;
import at.meduni.liferay.portlet.rdconnect.model.SearchIndexClp;

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
 * @author Robert Reihs
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
						"RDConnect-portlet-deployment-context");

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
							"RDConnect-portlet-deployment-context");

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
				_servletContextName = "RDConnect-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(AQRRatingClp.class.getName())) {
			return translateInputAQRRating(oldModel);
		}

		if (oldModelClassName.equals(CandidateClp.class.getName())) {
			return translateInputCandidate(oldModel);
		}

		if (oldModelClassName.equals(MasterCandidateClp.class.getName())) {
			return translateInputMasterCandidate(oldModel);
		}

		if (oldModelClassName.equals(
					MasterCandidateLinkCandidateClp.class.getName())) {
			return translateInputMasterCandidateLinkCandidate(oldModel);
		}

		if (oldModelClassName.equals(SearchIndexClp.class.getName())) {
			return translateInputSearchIndex(oldModel);
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

	public static Object translateInputAQRRating(BaseModel<?> oldModel) {
		AQRRatingClp oldClpModel = (AQRRatingClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAQRRatingRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCandidate(BaseModel<?> oldModel) {
		CandidateClp oldClpModel = (CandidateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCandidateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMasterCandidate(BaseModel<?> oldModel) {
		MasterCandidateClp oldClpModel = (MasterCandidateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMasterCandidateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMasterCandidateLinkCandidate(
		BaseModel<?> oldModel) {
		MasterCandidateLinkCandidateClp oldClpModel = (MasterCandidateLinkCandidateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMasterCandidateLinkCandidateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSearchIndex(BaseModel<?> oldModel) {
		SearchIndexClp oldClpModel = (SearchIndexClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSearchIndexRemoteModel();

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
					"at.meduni.liferay.portlet.rdconnect.model.impl.AQRRatingImpl")) {
			return translateOutputAQRRating(oldModel);
		}

		if (oldModelClassName.equals(
					"at.meduni.liferay.portlet.rdconnect.model.impl.CandidateImpl")) {
			return translateOutputCandidate(oldModel);
		}

		if (oldModelClassName.equals(
					"at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateImpl")) {
			return translateOutputMasterCandidate(oldModel);
		}

		if (oldModelClassName.equals(
					"at.meduni.liferay.portlet.rdconnect.model.impl.MasterCandidateLinkCandidateImpl")) {
			return translateOutputMasterCandidateLinkCandidate(oldModel);
		}

		if (oldModelClassName.equals(
					"at.meduni.liferay.portlet.rdconnect.model.impl.SearchIndexImpl")) {
			return translateOutputSearchIndex(oldModel);
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
					"at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException")) {
			return new at.meduni.liferay.portlet.rdconnect.NoSuchAQRRatingException();
		}

		if (className.equals(
					"at.meduni.liferay.portlet.rdconnect.NoSuchCandidateException")) {
			return new at.meduni.liferay.portlet.rdconnect.NoSuchCandidateException();
		}

		if (className.equals(
					"at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateException")) {
			return new at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateException();
		}

		if (className.equals(
					"at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateLinkCandidateException")) {
			return new at.meduni.liferay.portlet.rdconnect.NoSuchMasterCandidateLinkCandidateException();
		}

		if (className.equals(
					"at.meduni.liferay.portlet.rdconnect.NoSuchSearchIndexException")) {
			return new at.meduni.liferay.portlet.rdconnect.NoSuchSearchIndexException();
		}

		return throwable;
	}

	public static Object translateOutputAQRRating(BaseModel<?> oldModel) {
		AQRRatingClp newModel = new AQRRatingClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAQRRatingRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCandidate(BaseModel<?> oldModel) {
		CandidateClp newModel = new CandidateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCandidateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMasterCandidate(BaseModel<?> oldModel) {
		MasterCandidateClp newModel = new MasterCandidateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMasterCandidateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMasterCandidateLinkCandidate(
		BaseModel<?> oldModel) {
		MasterCandidateLinkCandidateClp newModel = new MasterCandidateLinkCandidateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMasterCandidateLinkCandidateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSearchIndex(BaseModel<?> oldModel) {
		SearchIndexClp newModel = new SearchIndexClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSearchIndexRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}