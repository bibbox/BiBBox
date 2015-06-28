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

package at.graz.meduni.liferay.portlet.bibbox.service;

import at.graz.meduni.liferay.portlet.bibbox.model.DDLConfigurationClp;
import at.graz.meduni.liferay.portlet.bibbox.model.GeneClp;
import at.graz.meduni.liferay.portlet.bibbox.model.GeneLocusClp;
import at.graz.meduni.liferay.portlet.bibbox.model.GeneReferenceClp;
import at.graz.meduni.liferay.portlet.bibbox.model.GeneSynonymClp;
import at.graz.meduni.liferay.portlet.bibbox.model.IconConfigurationClp;
import at.graz.meduni.liferay.portlet.bibbox.model.IconsClp;
import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetDisorderClp;
import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetReferenceClp;
import at.graz.meduni.liferay.portlet.bibbox.model.OrphanetSynonymClp;
import at.graz.meduni.liferay.portlet.bibbox.model.SymbolConfigurationClp;
import at.graz.meduni.liferay.portlet.bibbox.model.SymbolTypeConfigurationClp;

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
						"BiBBoxCommonServicesDatabase-portlet-deployment-context");

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
							"BiBBoxCommonServicesDatabase-portlet-deployment-context");

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
				_servletContextName = "BiBBoxCommonServicesDatabase-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(DDLConfigurationClp.class.getName())) {
			return translateInputDDLConfiguration(oldModel);
		}

		if (oldModelClassName.equals(GeneClp.class.getName())) {
			return translateInputGene(oldModel);
		}

		if (oldModelClassName.equals(GeneLocusClp.class.getName())) {
			return translateInputGeneLocus(oldModel);
		}

		if (oldModelClassName.equals(GeneReferenceClp.class.getName())) {
			return translateInputGeneReference(oldModel);
		}

		if (oldModelClassName.equals(GeneSynonymClp.class.getName())) {
			return translateInputGeneSynonym(oldModel);
		}

		if (oldModelClassName.equals(IconConfigurationClp.class.getName())) {
			return translateInputIconConfiguration(oldModel);
		}

		if (oldModelClassName.equals(IconsClp.class.getName())) {
			return translateInputIcons(oldModel);
		}

		if (oldModelClassName.equals(OrphanetDisorderClp.class.getName())) {
			return translateInputOrphanetDisorder(oldModel);
		}

		if (oldModelClassName.equals(OrphanetReferenceClp.class.getName())) {
			return translateInputOrphanetReference(oldModel);
		}

		if (oldModelClassName.equals(OrphanetSynonymClp.class.getName())) {
			return translateInputOrphanetSynonym(oldModel);
		}

		if (oldModelClassName.equals(SymbolConfigurationClp.class.getName())) {
			return translateInputSymbolConfiguration(oldModel);
		}

		if (oldModelClassName.equals(SymbolTypeConfigurationClp.class.getName())) {
			return translateInputSymbolTypeConfiguration(oldModel);
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

	public static Object translateInputDDLConfiguration(BaseModel<?> oldModel) {
		DDLConfigurationClp oldClpModel = (DDLConfigurationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDDLConfigurationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGene(BaseModel<?> oldModel) {
		GeneClp oldClpModel = (GeneClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGeneRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGeneLocus(BaseModel<?> oldModel) {
		GeneLocusClp oldClpModel = (GeneLocusClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGeneLocusRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGeneReference(BaseModel<?> oldModel) {
		GeneReferenceClp oldClpModel = (GeneReferenceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGeneReferenceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGeneSynonym(BaseModel<?> oldModel) {
		GeneSynonymClp oldClpModel = (GeneSynonymClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGeneSynonymRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputIconConfiguration(BaseModel<?> oldModel) {
		IconConfigurationClp oldClpModel = (IconConfigurationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getIconConfigurationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputIcons(BaseModel<?> oldModel) {
		IconsClp oldClpModel = (IconsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getIconsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOrphanetDisorder(BaseModel<?> oldModel) {
		OrphanetDisorderClp oldClpModel = (OrphanetDisorderClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOrphanetDisorderRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOrphanetReference(BaseModel<?> oldModel) {
		OrphanetReferenceClp oldClpModel = (OrphanetReferenceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOrphanetReferenceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOrphanetSynonym(BaseModel<?> oldModel) {
		OrphanetSynonymClp oldClpModel = (OrphanetSynonymClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOrphanetSynonymRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSymbolConfiguration(
		BaseModel<?> oldModel) {
		SymbolConfigurationClp oldClpModel = (SymbolConfigurationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSymbolConfigurationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSymbolTypeConfiguration(
		BaseModel<?> oldModel) {
		SymbolTypeConfigurationClp oldClpModel = (SymbolTypeConfigurationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSymbolTypeConfigurationRemoteModel();

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
					"at.graz.meduni.liferay.portlet.bibbox.model.impl.DDLConfigurationImpl")) {
			return translateOutputDDLConfiguration(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneImpl")) {
			return translateOutputGene(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneLocusImpl")) {
			return translateOutputGeneLocus(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneReferenceImpl")) {
			return translateOutputGeneReference(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.meduni.liferay.portlet.bibbox.model.impl.GeneSynonymImpl")) {
			return translateOutputGeneSynonym(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.meduni.liferay.portlet.bibbox.model.impl.IconConfigurationImpl")) {
			return translateOutputIconConfiguration(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.meduni.liferay.portlet.bibbox.model.impl.IconsImpl")) {
			return translateOutputIcons(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetDisorderImpl")) {
			return translateOutputOrphanetDisorder(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetReferenceImpl")) {
			return translateOutputOrphanetReference(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.meduni.liferay.portlet.bibbox.model.impl.OrphanetSynonymImpl")) {
			return translateOutputOrphanetSynonym(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolConfigurationImpl")) {
			return translateOutputSymbolConfiguration(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.meduni.liferay.portlet.bibbox.model.impl.SymbolTypeConfigurationImpl")) {
			return translateOutputSymbolTypeConfiguration(oldModel);
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
					"at.graz.meduni.liferay.portlet.bibbox.NoSuchDDLConfigurationException")) {
			return new at.graz.meduni.liferay.portlet.bibbox.NoSuchDDLConfigurationException();
		}

		if (className.equals(
					"at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneException")) {
			return new at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneException();
		}

		if (className.equals(
					"at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneLocusException")) {
			return new at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneLocusException();
		}

		if (className.equals(
					"at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneReferenceException")) {
			return new at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneReferenceException();
		}

		if (className.equals(
					"at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneSynonymException")) {
			return new at.graz.meduni.liferay.portlet.bibbox.NoSuchGeneSynonymException();
		}

		if (className.equals(
					"at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException")) {
			return new at.graz.meduni.liferay.portlet.bibbox.NoSuchIconConfigurationException();
		}

		if (className.equals(
					"at.graz.meduni.liferay.portlet.bibbox.NoSuchIconsException")) {
			return new at.graz.meduni.liferay.portlet.bibbox.NoSuchIconsException();
		}

		if (className.equals(
					"at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException")) {
			return new at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetDisorderException();
		}

		if (className.equals(
					"at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException")) {
			return new at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetReferenceException();
		}

		if (className.equals(
					"at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException")) {
			return new at.graz.meduni.liferay.portlet.bibbox.NoSuchOrphanetSynonymException();
		}

		if (className.equals(
					"at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException")) {
			return new at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolConfigurationException();
		}

		if (className.equals(
					"at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException")) {
			return new at.graz.meduni.liferay.portlet.bibbox.NoSuchSymbolTypeConfigurationException();
		}

		return throwable;
	}

	public static Object translateOutputDDLConfiguration(BaseModel<?> oldModel) {
		DDLConfigurationClp newModel = new DDLConfigurationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDDLConfigurationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGene(BaseModel<?> oldModel) {
		GeneClp newModel = new GeneClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGeneRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGeneLocus(BaseModel<?> oldModel) {
		GeneLocusClp newModel = new GeneLocusClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGeneLocusRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGeneReference(BaseModel<?> oldModel) {
		GeneReferenceClp newModel = new GeneReferenceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGeneReferenceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGeneSynonym(BaseModel<?> oldModel) {
		GeneSynonymClp newModel = new GeneSynonymClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGeneSynonymRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputIconConfiguration(BaseModel<?> oldModel) {
		IconConfigurationClp newModel = new IconConfigurationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setIconConfigurationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputIcons(BaseModel<?> oldModel) {
		IconsClp newModel = new IconsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setIconsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOrphanetDisorder(BaseModel<?> oldModel) {
		OrphanetDisorderClp newModel = new OrphanetDisorderClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOrphanetDisorderRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOrphanetReference(BaseModel<?> oldModel) {
		OrphanetReferenceClp newModel = new OrphanetReferenceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOrphanetReferenceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOrphanetSynonym(BaseModel<?> oldModel) {
		OrphanetSynonymClp newModel = new OrphanetSynonymClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOrphanetSynonymRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSymbolConfiguration(
		BaseModel<?> oldModel) {
		SymbolConfigurationClp newModel = new SymbolConfigurationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSymbolConfigurationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSymbolTypeConfiguration(
		BaseModel<?> oldModel) {
		SymbolTypeConfigurationClp newModel = new SymbolTypeConfigurationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSymbolTypeConfigurationRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}