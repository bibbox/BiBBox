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

import com.liferay.portal.service.InvokableService;

/**
 * @author reihsr
 * @generated
 */
public class LogapiServiceClp implements LogapiService {
	public LogapiServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getBeanIdentifier";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "setBeanIdentifier";

		_methodParameterTypes1 = new String[] { "java.lang.String" };

		_methodName3 = "getAPIVersion";

		_methodParameterTypes3 = new String[] {  };

		_methodName4 = "regbbs";

		_methodParameterTypes4 = new String[] { "java.lang.String" };

		_methodName5 = "regbbs";

		_methodParameterTypes5 = new String[] {  };

		_methodName6 = "regs";

		_methodParameterTypes6 = new String[] {  };

		_methodName7 = "bbs";

		_methodParameterTypes7 = new String[] {  };

		_methodName8 = "regbb";

		_methodParameterTypes8 = new String[] { "long" };

		_methodName9 = "regbb";

		_methodParameterTypes9 = new String[] { "long", "long" };

		_methodName10 = "regbb";

		_methodParameterTypes10 = new String[] { "java.lang.String" };

		_methodName11 = "testMethode";

		_methodParameterTypes11 = new String[] { "java.lang.String" };

		_methodName12 = "resttest01";

		_methodParameterTypes12 = new String[] { "long" };

		_methodName13 = "resttest02";

		_methodParameterTypes13 = new String[] { "java.lang.String" };

		_methodName14 = "resttest03";

		_methodParameterTypes14 = new String[] { "long[][]" };

		_methodName15 = "resttest04";

		_methodParameterTypes15 = new String[] { "java.lang.String[][]" };

		_methodName16 = "resttest05";

		_methodParameterTypes16 = new String[] {
				"java.lang.String", "com.liferay.portal.model.User"
			};

		_methodName17 = "resttest06";

		_methodParameterTypes17 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName18 = "resttest07";

		_methodParameterTypes18 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
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
			_invokableService.invokeMethod(_methodName1,
				_methodParameterTypes1,
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
	public com.liferay.portal.kernel.json.JSONObject getAPIVersion() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3, new Object[] {  });
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

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray regbbs(
		java.lang.String data) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] { ClpSerializer.translateInput(data) });
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

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray regbbs() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5, new Object[] {  });
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

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray regs() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6, new Object[] {  });
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

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray bbs() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName7,
					_methodParameterTypes7, new Object[] {  });
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

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject regbb(long organizationId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName8,
					_methodParameterTypes8, new Object[] { organizationId });
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

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject regbb(
		long organizationId, long collectionId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] { organizationId, collectionId });
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

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject regbb(java.lang.String id) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName10,
					_methodParameterTypes10,
					new Object[] { ClpSerializer.translateInput(id) });
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

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void testMethode(java.lang.String jason) {
		try {
			_invokableService.invokeMethod(_methodName11,
				_methodParameterTypes11,
				new Object[] { ClpSerializer.translateInput(jason) });
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
	public void resttest01(long organizationId) {
		try {
			_invokableService.invokeMethod(_methodName12,
				_methodParameterTypes12, new Object[] { organizationId });
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
	public void resttest02(java.lang.String text) {
		try {
			_invokableService.invokeMethod(_methodName13,
				_methodParameterTypes13,
				new Object[] { ClpSerializer.translateInput(text) });
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
	public void resttest03(long[] array) {
		try {
			_invokableService.invokeMethod(_methodName14,
				_methodParameterTypes14,
				new Object[] { ClpSerializer.translateInput(array) });
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
	public void resttest04(java.lang.String[] array) {
		try {
			_invokableService.invokeMethod(_methodName15,
				_methodParameterTypes15,
				new Object[] { ClpSerializer.translateInput(array) });
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
	public void resttest05(java.lang.String url,
		com.liferay.portal.model.User user) {
		try {
			_invokableService.invokeMethod(_methodName16,
				_methodParameterTypes16,
				new Object[] {
					ClpSerializer.translateInput(url),
					
				ClpSerializer.translateInput(user)
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
	}

	@Override
	public void resttest06(java.lang.String url, java.lang.String diseasname,
		java.lang.String patientcount, java.lang.String gene,
		java.lang.String orphanumber, java.lang.String icd10,
		java.lang.String omim, java.lang.String synonym) {
		try {
			_invokableService.invokeMethod(_methodName17,
				_methodParameterTypes17,
				new Object[] {
					ClpSerializer.translateInput(url),
					
				ClpSerializer.translateInput(diseasname),
					
				ClpSerializer.translateInput(patientcount),
					
				ClpSerializer.translateInput(gene),
					
				ClpSerializer.translateInput(orphanumber),
					
				ClpSerializer.translateInput(icd10),
					
				ClpSerializer.translateInput(omim),
					
				ClpSerializer.translateInput(synonym)
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
	}

	@Override
	public void resttest07(java.lang.String url, java.lang.String diseasname,
		java.lang.String patientcount, java.lang.String gene,
		java.lang.String orphanumber, java.lang.String icd10,
		java.lang.String omim, java.lang.String synonym) {
		try {
			_invokableService.invokeMethod(_methodName18,
				_methodParameterTypes18,
				new Object[] {
					ClpSerializer.translateInput(url),
					
				ClpSerializer.translateInput(diseasname),
					
				ClpSerializer.translateInput(patientcount),
					
				ClpSerializer.translateInput(gene),
					
				ClpSerializer.translateInput(orphanumber),
					
				ClpSerializer.translateInput(icd10),
					
				ClpSerializer.translateInput(omim),
					
				ClpSerializer.translateInput(synonym)
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
	}

	private InvokableService _invokableService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
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
}