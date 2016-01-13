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

package at.meduni.liferay.portlet.bbmrieric.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author reihsr
 * @generated
 */
public class D2CollectionLocalServiceClp implements D2CollectionLocalService {
	public D2CollectionLocalServiceClp(
		InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "addD2Collection";

		_methodParameterTypes0 = new String[] {
				"at.meduni.liferay.portlet.bbmrieric.model.D2Collection"
			};

		_methodName1 = "createD2Collection";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteD2Collection";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteD2Collection";

		_methodParameterTypes3 = new String[] {
				"at.meduni.liferay.portlet.bbmrieric.model.D2Collection"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchD2Collection";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchD2CollectionByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchD2CollectionByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getD2Collection";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getD2CollectionByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getD2CollectionByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getD2Collections";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getD2CollectionsCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateD2Collection";

		_methodParameterTypes19 = new String[] {
				"at.meduni.liferay.portlet.bbmrieric.model.D2Collection"
			};

		_methodName20 = "getBeanIdentifier";

		_methodParameterTypes20 = new String[] {  };

		_methodName21 = "setBeanIdentifier";

		_methodParameterTypes21 = new String[] { "java.lang.String" };

		_methodName23 = "addD2Collection";

		_methodParameterTypes23 = new String[] {
				"at.meduni.liferay.portlet.bbmrieric.model.D2Collection",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName24 = "addD2Collection";

		_methodParameterTypes24 = new String[] {
				"long", "long", "long", "long", "long", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "boolean", "boolean",
				"boolean", "boolean", "boolean", "boolean", "boolean", "boolean",
				"boolean", "boolean", "boolean", "boolean", "java.lang.String",
				"boolean", "boolean", "boolean", "boolean", "boolean", "boolean",
				"boolean", "boolean", "boolean", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"boolean", "boolean", "java.lang.String", "java.lang.String",
				"boolean", "boolean", "boolean", "boolean", "long", "long",
				"java.lang.String", "boolean", "boolean", "boolean", "boolean",
				"boolean", "boolean", "boolean", "java.lang.String", "boolean",
				"boolean", "boolean", "boolean", "boolean", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "boolean", "boolean", "java.lang.String",
				"java.lang.String", "boolean", "boolean", "java.lang.String",
				"java.lang.String", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName25 = "updateD2Collection";

		_methodParameterTypes25 = new String[] {
				"at.meduni.liferay.portlet.bbmrieric.model.D2Collection",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName26 = "updateD2Collection";

		_methodParameterTypes26 = new String[] {
				"long", "long", "long", "long", "long", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "boolean", "boolean",
				"boolean", "boolean", "boolean", "boolean", "boolean", "boolean",
				"boolean", "boolean", "boolean", "boolean", "java.lang.String",
				"boolean", "boolean", "boolean", "boolean", "boolean", "boolean",
				"boolean", "boolean", "boolean", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"boolean", "boolean", "java.lang.String", "java.lang.String",
				"boolean", "boolean", "boolean", "boolean", "long", "long",
				"java.lang.String", "boolean", "boolean", "boolean", "boolean",
				"boolean", "boolean", "boolean", "java.lang.String", "boolean",
				"boolean", "boolean", "boolean", "boolean", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "boolean", "boolean", "java.lang.String",
				"java.lang.String", "boolean", "boolean", "java.lang.String",
				"java.lang.String", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName27 = "getD2CollectionByBBMRIERICID";

		_methodParameterTypes27 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName28 = "getD2CollectionByBiobankId";

		_methodParameterTypes28 = new String[] { "long" };

		_methodName29 = "getRootD2Collection";

		_methodParameterTypes29 = new String[] { "long" };

		_methodName30 = "getChildD2Collection";

		_methodParameterTypes30 = new String[] { "long", "long" };

		_methodName31 = "getD2CollectionByBiobankIdCount";

		_methodParameterTypes31 = new String[] { "long" };

		_methodName32 = "getD2CollectionFromLDAP";

		_methodParameterTypes32 = new String[] {
				"at.meduni.liferay.portlet.bbmrieric.model.D2Collection",
				"javax.naming.directory.Attributes",
				"javax.naming.directory.SearchResult"
			};

		_methodName33 = "getLDAPNotUpdatedCollection";

		_methodParameterTypes33 = new String[] { "long", "java.lang.String" };
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection addD2Collection(
		at.meduni.liferay.portlet.bbmrieric.model.D2Collection d2Collection)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0,
					new Object[] { ClpSerializer.translateInput(d2Collection) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (at.meduni.liferay.portlet.bbmrieric.model.D2Collection)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection createD2Collection(
		long d2collectionId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName1,
					_methodParameterTypes1, new Object[] { d2collectionId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (at.meduni.liferay.portlet.bbmrieric.model.D2Collection)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection deleteD2Collection(
		long d2collectionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName2,
					_methodParameterTypes2, new Object[] { d2collectionId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (at.meduni.liferay.portlet.bbmrieric.model.D2Collection)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection deleteD2Collection(
		at.meduni.liferay.portlet.bbmrieric.model.D2Collection d2Collection)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { ClpSerializer.translateInput(d2Collection) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (at.meduni.liferay.portlet.bbmrieric.model.D2Collection)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName4,
					_methodParameterTypes4, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.dao.orm.DynamicQuery)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { ClpSerializer.translateInput(dynamicQuery) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] { ClpSerializer.translateInput(dynamicQuery) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					ClpSerializer.translateInput(projection)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection fetchD2Collection(
		long d2collectionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10, new Object[] { d2collectionId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (at.meduni.liferay.portlet.bbmrieric.model.D2Collection)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection fetchD2CollectionByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11,
					new Object[] { ClpSerializer.translateInput(uuid), companyId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (at.meduni.liferay.portlet.bbmrieric.model.D2Collection)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection fetchD2CollectionByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] { ClpSerializer.translateInput(uuid), groupId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (at.meduni.liferay.portlet.bbmrieric.model.D2Collection)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection getD2Collection(
		long d2collectionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName13,
					_methodParameterTypes13, new Object[] { d2collectionId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (at.meduni.liferay.portlet.bbmrieric.model.D2Collection)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName14,
					_methodParameterTypes14,
					new Object[] { ClpSerializer.translateInput(primaryKeyObj) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection getD2CollectionByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName15,
					_methodParameterTypes15,
					new Object[] { ClpSerializer.translateInput(uuid), companyId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (at.meduni.liferay.portlet.bbmrieric.model.D2Collection)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection getD2CollectionByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName16,
					_methodParameterTypes16,
					new Object[] { ClpSerializer.translateInput(uuid), groupId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (at.meduni.liferay.portlet.bbmrieric.model.D2Collection)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getD2Collections(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName17,
					_methodParameterTypes17, new Object[] { start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int getD2CollectionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName18,
					_methodParameterTypes18, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection updateD2Collection(
		at.meduni.liferay.portlet.bbmrieric.model.D2Collection d2Collection)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName19,
					_methodParameterTypes19,
					new Object[] { ClpSerializer.translateInput(d2Collection) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (at.meduni.liferay.portlet.bbmrieric.model.D2Collection)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName20,
					_methodParameterTypes20, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableLocalService.invokeMethod(_methodName21,
				_methodParameterTypes21,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection addD2Collection(
		at.meduni.liferay.portlet.bbmrieric.model.D2Collection d2collection,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName23,
					_methodParameterTypes23,
					new Object[] {
						ClpSerializer.translateInput(d2collection),
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (at.meduni.liferay.portlet.bbmrieric.model.D2Collection)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection addD2Collection(
		long collectionId, long companyId, long groupId, long userId,
		long biobankId, long parentcollectionId,
		java.lang.String ldapupdateuuid, java.lang.String bbmricollectionID,
		java.lang.String bbmriparentcollectionID,
		java.lang.String bbmribiobankID, java.lang.String collectionName,
		boolean materialStoredDNA, boolean materialStoredPlasma,
		boolean materialStoredSerum, boolean materialStoredUrine,
		boolean materialStoredSaliva, boolean materialStoredFaeces,
		boolean materialStoredRNA, boolean materialStoredBlood,
		boolean materialStoredTissueFrozen, boolean materialStoredTissueFFPE,
		boolean materialStoredImmortalizedCellLines,
		boolean materialStoredIsolatedPathogen,
		java.lang.String materialStoredOther,
		boolean collectionTypeCaseControl, boolean collectionTypeCohort,
		boolean collectionTypeCrossSectional,
		boolean collectionTypeLongitudinal, boolean collectionTypeTwinStudy,
		boolean collectionTypeQualityControl,
		boolean collectionTypePopulationBased,
		boolean collectionTypeDiseaseSpecific,
		boolean collectionTypeBirthCohort,
		java.lang.String collectionTypeOther, long collectionOrderOfMagnitude,
		java.lang.String bioresourceReference, java.lang.String contactIDRef,
		long contactPriority, java.lang.String biobankNetworkIDRef,
		java.lang.String geoLatitude, java.lang.String geoLongitude,
		boolean collaborationPartnersCommercial,
		boolean collaborationPartnersNonforprofit,
		java.lang.String collectionAcronym,
		java.lang.String collectionDescription, boolean collectionSexMale,
		boolean collectionSexFemale, boolean collectionSexUnknown,
		boolean collectionSexUndiferrentiated, long collectionAgeLow,
		long collectionAgeHigh, java.lang.String collectionAgeUnit,
		boolean collectionAvailableBiologicalSamples,
		boolean collectionAvailableSurveyData,
		boolean collectionAvailableImagingData,
		boolean collectionAvailableMedicalRecords,
		boolean collectionAvailableNationalRegistries,
		boolean collectionAvailableGenealogicalRecords,
		boolean collectionAvailablePhysioBiochemMeasurements,
		java.lang.String collectionAvailableOther, boolean temperatureRoom,
		boolean temperature2to10, boolean temperature18to35,
		boolean temperature60to85, boolean temperatureLN,
		java.lang.String temperatureOther, java.lang.String diagnosisAvailable,
		java.lang.String collectionHeadFirstName,
		java.lang.String collectionHeadLastName,
		java.lang.String collectionHeadRole, boolean collectionSampleAccessFee,
		boolean collectionSampleAccessJointProjects,
		java.lang.String collectionSampleAccessDescription,
		java.lang.String collectionSampleAccessURI,
		boolean collectionDataAccessFee,
		boolean collectionDataAccessJointProjects,
		java.lang.String collectionDataAccessDescription,
		java.lang.String collectionDataAccessURI, long collectionSize,
		long collectionSizeTimestamp,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName24,
					_methodParameterTypes24,
					new Object[] {
						collectionId,
						
					companyId,
						
					groupId,
						
					userId,
						
					biobankId,
						
					parentcollectionId,
						
					ClpSerializer.translateInput(ldapupdateuuid),
						
					ClpSerializer.translateInput(bbmricollectionID),
						
					ClpSerializer.translateInput(bbmriparentcollectionID),
						
					ClpSerializer.translateInput(bbmribiobankID),
						
					ClpSerializer.translateInput(collectionName),
						
					materialStoredDNA,
						
					materialStoredPlasma,
						
					materialStoredSerum,
						
					materialStoredUrine,
						
					materialStoredSaliva,
						
					materialStoredFaeces,
						
					materialStoredRNA,
						
					materialStoredBlood,
						
					materialStoredTissueFrozen,
						
					materialStoredTissueFFPE,
						
					materialStoredImmortalizedCellLines,
						
					materialStoredIsolatedPathogen,
						
					ClpSerializer.translateInput(materialStoredOther),
						
					collectionTypeCaseControl,
						
					collectionTypeCohort,
						
					collectionTypeCrossSectional,
						
					collectionTypeLongitudinal,
						
					collectionTypeTwinStudy,
						
					collectionTypeQualityControl,
						
					collectionTypePopulationBased,
						
					collectionTypeDiseaseSpecific,
						
					collectionTypeBirthCohort,
						
					ClpSerializer.translateInput(collectionTypeOther),
						
					collectionOrderOfMagnitude,
						
					ClpSerializer.translateInput(bioresourceReference),
						
					ClpSerializer.translateInput(contactIDRef),
						
					contactPriority,
						
					ClpSerializer.translateInput(biobankNetworkIDRef),
						
					ClpSerializer.translateInput(geoLatitude),
						
					ClpSerializer.translateInput(geoLongitude),
						
					collaborationPartnersCommercial,
						
					collaborationPartnersNonforprofit,
						
					ClpSerializer.translateInput(collectionAcronym),
						
					ClpSerializer.translateInput(collectionDescription),
						
					collectionSexMale,
						
					collectionSexFemale,
						
					collectionSexUnknown,
						
					collectionSexUndiferrentiated,
						
					collectionAgeLow,
						
					collectionAgeHigh,
						
					ClpSerializer.translateInput(collectionAgeUnit),
						
					collectionAvailableBiologicalSamples,
						
					collectionAvailableSurveyData,
						
					collectionAvailableImagingData,
						
					collectionAvailableMedicalRecords,
						
					collectionAvailableNationalRegistries,
						
					collectionAvailableGenealogicalRecords,
						
					collectionAvailablePhysioBiochemMeasurements,
						
					ClpSerializer.translateInput(collectionAvailableOther),
						
					temperatureRoom,
						
					temperature2to10,
						
					temperature18to35,
						
					temperature60to85,
						
					temperatureLN,
						
					ClpSerializer.translateInput(temperatureOther),
						
					ClpSerializer.translateInput(diagnosisAvailable),
						
					ClpSerializer.translateInput(collectionHeadFirstName),
						
					ClpSerializer.translateInput(collectionHeadLastName),
						
					ClpSerializer.translateInput(collectionHeadRole),
						
					collectionSampleAccessFee,
						
					collectionSampleAccessJointProjects,
						
					ClpSerializer.translateInput(
							collectionSampleAccessDescription),
						
					ClpSerializer.translateInput(collectionSampleAccessURI),
						
					collectionDataAccessFee,
						
					collectionDataAccessJointProjects,
						
					ClpSerializer.translateInput(
							collectionDataAccessDescription),
						
					ClpSerializer.translateInput(collectionDataAccessURI),
						
					collectionSize,
						
					collectionSizeTimestamp,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (at.meduni.liferay.portlet.bbmrieric.model.D2Collection)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection updateD2Collection(
		at.meduni.liferay.portlet.bbmrieric.model.D2Collection d2collection,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName25,
					_methodParameterTypes25,
					new Object[] {
						ClpSerializer.translateInput(d2collection),
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (at.meduni.liferay.portlet.bbmrieric.model.D2Collection)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection updateD2Collection(
		long collectionId, long companyId, long groupId, long userId,
		long biobankId, long parentcollectionId,
		java.lang.String ldapupdateuuid, java.lang.String bbmricollectionID,
		java.lang.String bbmriparentcollectionID,
		java.lang.String bbmribiobankID, java.lang.String collectionName,
		boolean materialStoredDNA, boolean materialStoredPlasma,
		boolean materialStoredSerum, boolean materialStoredUrine,
		boolean materialStoredSaliva, boolean materialStoredFaeces,
		boolean materialStoredRNA, boolean materialStoredBlood,
		boolean materialStoredTissueFrozen, boolean materialStoredTissueFFPE,
		boolean materialStoredImmortalizedCellLines,
		boolean materialStoredIsolatedPathogen,
		java.lang.String materialStoredOther,
		boolean collectionTypeCaseControl, boolean collectionTypeCohort,
		boolean collectionTypeCrossSectional,
		boolean collectionTypeLongitudinal, boolean collectionTypeTwinStudy,
		boolean collectionTypeQualityControl,
		boolean collectionTypePopulationBased,
		boolean collectionTypeDiseaseSpecific,
		boolean collectionTypeBirthCohort,
		java.lang.String collectionTypeOther, long collectionOrderOfMagnitude,
		java.lang.String bioresourceReference, java.lang.String contactIDRef,
		long contactPriority, java.lang.String biobankNetworkIDRef,
		java.lang.String geoLatitude, java.lang.String geoLongitude,
		boolean collaborationPartnersCommercial,
		boolean collaborationPartnersNonforprofit,
		java.lang.String collectionAcronym,
		java.lang.String collectionDescription, boolean collectionSexMale,
		boolean collectionSexFemale, boolean collectionSexUnknown,
		boolean collectionSexUndiferrentiated, long collectionAgeLow,
		long collectionAgeHigh, java.lang.String collectionAgeUnit,
		boolean collectionAvailableBiologicalSamples,
		boolean collectionAvailableSurveyData,
		boolean collectionAvailableImagingData,
		boolean collectionAvailableMedicalRecords,
		boolean collectionAvailableNationalRegistries,
		boolean collectionAvailableGenealogicalRecords,
		boolean collectionAvailablePhysioBiochemMeasurements,
		java.lang.String collectionAvailableOther, boolean temperatureRoom,
		boolean temperature2to10, boolean temperature18to35,
		boolean temperature60to85, boolean temperatureLN,
		java.lang.String temperatureOther, java.lang.String diagnosisAvailable,
		java.lang.String collectionHeadFirstName,
		java.lang.String collectionHeadLastName,
		java.lang.String collectionHeadRole, boolean collectionSampleAccessFee,
		boolean collectionSampleAccessJointProjects,
		java.lang.String collectionSampleAccessDescription,
		java.lang.String collectionSampleAccessURI,
		boolean collectionDataAccessFee,
		boolean collectionDataAccessJointProjects,
		java.lang.String collectionDataAccessDescription,
		java.lang.String collectionDataAccessURI, long collectionSize,
		long collectionSizeTimestamp,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName26,
					_methodParameterTypes26,
					new Object[] {
						collectionId,
						
					companyId,
						
					groupId,
						
					userId,
						
					biobankId,
						
					parentcollectionId,
						
					ClpSerializer.translateInput(ldapupdateuuid),
						
					ClpSerializer.translateInput(bbmricollectionID),
						
					ClpSerializer.translateInput(bbmriparentcollectionID),
						
					ClpSerializer.translateInput(bbmribiobankID),
						
					ClpSerializer.translateInput(collectionName),
						
					materialStoredDNA,
						
					materialStoredPlasma,
						
					materialStoredSerum,
						
					materialStoredUrine,
						
					materialStoredSaliva,
						
					materialStoredFaeces,
						
					materialStoredRNA,
						
					materialStoredBlood,
						
					materialStoredTissueFrozen,
						
					materialStoredTissueFFPE,
						
					materialStoredImmortalizedCellLines,
						
					materialStoredIsolatedPathogen,
						
					ClpSerializer.translateInput(materialStoredOther),
						
					collectionTypeCaseControl,
						
					collectionTypeCohort,
						
					collectionTypeCrossSectional,
						
					collectionTypeLongitudinal,
						
					collectionTypeTwinStudy,
						
					collectionTypeQualityControl,
						
					collectionTypePopulationBased,
						
					collectionTypeDiseaseSpecific,
						
					collectionTypeBirthCohort,
						
					ClpSerializer.translateInput(collectionTypeOther),
						
					collectionOrderOfMagnitude,
						
					ClpSerializer.translateInput(bioresourceReference),
						
					ClpSerializer.translateInput(contactIDRef),
						
					contactPriority,
						
					ClpSerializer.translateInput(biobankNetworkIDRef),
						
					ClpSerializer.translateInput(geoLatitude),
						
					ClpSerializer.translateInput(geoLongitude),
						
					collaborationPartnersCommercial,
						
					collaborationPartnersNonforprofit,
						
					ClpSerializer.translateInput(collectionAcronym),
						
					ClpSerializer.translateInput(collectionDescription),
						
					collectionSexMale,
						
					collectionSexFemale,
						
					collectionSexUnknown,
						
					collectionSexUndiferrentiated,
						
					collectionAgeLow,
						
					collectionAgeHigh,
						
					ClpSerializer.translateInput(collectionAgeUnit),
						
					collectionAvailableBiologicalSamples,
						
					collectionAvailableSurveyData,
						
					collectionAvailableImagingData,
						
					collectionAvailableMedicalRecords,
						
					collectionAvailableNationalRegistries,
						
					collectionAvailableGenealogicalRecords,
						
					collectionAvailablePhysioBiochemMeasurements,
						
					ClpSerializer.translateInput(collectionAvailableOther),
						
					temperatureRoom,
						
					temperature2to10,
						
					temperature18to35,
						
					temperature60to85,
						
					temperatureLN,
						
					ClpSerializer.translateInput(temperatureOther),
						
					ClpSerializer.translateInput(diagnosisAvailable),
						
					ClpSerializer.translateInput(collectionHeadFirstName),
						
					ClpSerializer.translateInput(collectionHeadLastName),
						
					ClpSerializer.translateInput(collectionHeadRole),
						
					collectionSampleAccessFee,
						
					collectionSampleAccessJointProjects,
						
					ClpSerializer.translateInput(
							collectionSampleAccessDescription),
						
					ClpSerializer.translateInput(collectionSampleAccessURI),
						
					collectionDataAccessFee,
						
					collectionDataAccessJointProjects,
						
					ClpSerializer.translateInput(
							collectionDataAccessDescription),
						
					ClpSerializer.translateInput(collectionDataAccessURI),
						
					collectionSize,
						
					collectionSizeTimestamp,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (at.meduni.liferay.portlet.bbmrieric.model.D2Collection)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection getD2CollectionByBBMRIERICID(
		long groupId, java.lang.String bbmricollectionID,
		java.lang.String bbmribiobankID) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName27,
					_methodParameterTypes27,
					new Object[] {
						groupId,
						
					ClpSerializer.translateInput(bbmricollectionID),
						
					ClpSerializer.translateInput(bbmribiobankID)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (at.meduni.liferay.portlet.bbmrieric.model.D2Collection)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getD2CollectionByBiobankId(
		long biobankId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName28,
					_methodParameterTypes28, new Object[] { biobankId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getRootD2Collection(
		long biobankId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName29,
					_methodParameterTypes29, new Object[] { biobankId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getChildD2Collection(
		long biobankId, long collectionId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName30,
					_methodParameterTypes30,
					new Object[] { biobankId, collectionId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int getD2CollectionByBiobankIdCount(long biobankId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName31,
					_methodParameterTypes31, new Object[] { biobankId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public at.meduni.liferay.portlet.bbmrieric.model.D2Collection getD2CollectionFromLDAP(
		at.meduni.liferay.portlet.bbmrieric.model.D2Collection d2collection,
		javax.naming.directory.Attributes attrs,
		javax.naming.directory.SearchResult sr) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName32,
					_methodParameterTypes32,
					new Object[] {
						ClpSerializer.translateInput(d2collection),
						
					ClpSerializer.translateInput(attrs),
						
					ClpSerializer.translateInput(sr)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (at.meduni.liferay.portlet.bbmrieric.model.D2Collection)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection> getLDAPNotUpdatedCollection(
		long groupId, java.lang.String ldapupdateuuid) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName33,
					_methodParameterTypes33,
					new Object[] {
						groupId,
						
					ClpSerializer.translateInput(ldapupdateuuid)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<at.meduni.liferay.portlet.bbmrieric.model.D2Collection>)ClpSerializer.translateOutput(returnObj);
	}

	private InvokableLocalService _invokableLocalService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
}