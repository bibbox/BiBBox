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

package at.graz.meduni.liferay.portlet.bibbox.service.service;

import at.graz.meduni.liferay.portlet.bibbox.service.model.BiobankPanelAssessmentClp;
import at.graz.meduni.liferay.portlet.bibbox.service.model.DiseaseMatrixClp;
import at.graz.meduni.liferay.portlet.bibbox.service.model.GeneralInformationClp;
import at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationClp;
import at.graz.meduni.liferay.portlet.bibbox.service.model.InvitationOrganisationClp;
import at.graz.meduni.liferay.portlet.bibbox.service.model.NetworksClp;

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
						"BiBBoxCommonServices-portlet-deployment-context");

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
							"BiBBoxCommonServices-portlet-deployment-context");

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
				_servletContextName = "BiBBoxCommonServices-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(BiobankPanelAssessmentClp.class.getName())) {
			return translateInputBiobankPanelAssessment(oldModel);
		}

		if (oldModelClassName.equals(DiseaseMatrixClp.class.getName())) {
			return translateInputDiseaseMatrix(oldModel);
		}

		if (oldModelClassName.equals(GeneralInformationClp.class.getName())) {
			return translateInputGeneralInformation(oldModel);
		}

		if (oldModelClassName.equals(InvitationClp.class.getName())) {
			return translateInputInvitation(oldModel);
		}

		if (oldModelClassName.equals(InvitationOrganisationClp.class.getName())) {
			return translateInputInvitationOrganisation(oldModel);
		}

		if (oldModelClassName.equals(NetworksClp.class.getName())) {
			return translateInputNetworks(oldModel);
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

	public static Object translateInputBiobankPanelAssessment(
		BaseModel<?> oldModel) {
		BiobankPanelAssessmentClp oldClpModel = (BiobankPanelAssessmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBiobankPanelAssessmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDiseaseMatrix(BaseModel<?> oldModel) {
		DiseaseMatrixClp oldClpModel = (DiseaseMatrixClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDiseaseMatrixRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGeneralInformation(BaseModel<?> oldModel) {
		GeneralInformationClp oldClpModel = (GeneralInformationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGeneralInformationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputInvitation(BaseModel<?> oldModel) {
		InvitationClp oldClpModel = (InvitationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getInvitationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputInvitationOrganisation(
		BaseModel<?> oldModel) {
		InvitationOrganisationClp oldClpModel = (InvitationOrganisationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getInvitationOrganisationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputNetworks(BaseModel<?> oldModel) {
		NetworksClp oldClpModel = (NetworksClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getNetworksRemoteModel();

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
					"at.graz.meduni.liferay.portlet.bibbox.service.model.impl.BiobankPanelAssessmentImpl")) {
			return translateOutputBiobankPanelAssessment(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.meduni.liferay.portlet.bibbox.service.model.impl.DiseaseMatrixImpl")) {
			return translateOutputDiseaseMatrix(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.meduni.liferay.portlet.bibbox.service.model.impl.GeneralInformationImpl")) {
			return translateOutputGeneralInformation(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationImpl")) {
			return translateOutputInvitation(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.meduni.liferay.portlet.bibbox.service.model.impl.InvitationOrganisationImpl")) {
			return translateOutputInvitationOrganisation(oldModel);
		}

		if (oldModelClassName.equals(
					"at.graz.meduni.liferay.portlet.bibbox.service.model.impl.NetworksImpl")) {
			return translateOutputNetworks(oldModel);
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
					"at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException")) {
			return new at.graz.meduni.liferay.portlet.bibbox.service.NoSuchBiobankPanelAssessmentException();
		}

		if (className.equals(
					"at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException")) {
			return new at.graz.meduni.liferay.portlet.bibbox.service.NoSuchDiseaseMatrixException();
		}

		if (className.equals(
					"at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException")) {
			return new at.graz.meduni.liferay.portlet.bibbox.service.NoSuchGeneralInformationException();
		}

		if (className.equals(
					"at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException")) {
			return new at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationException();
		}

		if (className.equals(
					"at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException")) {
			return new at.graz.meduni.liferay.portlet.bibbox.service.NoSuchInvitationOrganisationException();
		}

		if (className.equals(
					"at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException")) {
			return new at.graz.meduni.liferay.portlet.bibbox.service.NoSuchNetworksException();
		}

		return throwable;
	}

	public static Object translateOutputBiobankPanelAssessment(
		BaseModel<?> oldModel) {
		BiobankPanelAssessmentClp newModel = new BiobankPanelAssessmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBiobankPanelAssessmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDiseaseMatrix(BaseModel<?> oldModel) {
		DiseaseMatrixClp newModel = new DiseaseMatrixClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDiseaseMatrixRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGeneralInformation(
		BaseModel<?> oldModel) {
		GeneralInformationClp newModel = new GeneralInformationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGeneralInformationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputInvitation(BaseModel<?> oldModel) {
		InvitationClp newModel = new InvitationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setInvitationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputInvitationOrganisation(
		BaseModel<?> oldModel) {
		InvitationOrganisationClp newModel = new InvitationOrganisationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setInvitationOrganisationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputNetworks(BaseModel<?> oldModel) {
		NetworksClp newModel = new NetworksClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setNetworksRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}