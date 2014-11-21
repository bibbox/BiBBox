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

package com.bcnet.portlet.biobank;

import com.liferay.portal.NoSuchModelException;

/**
 * @author suyama
 */
public class NoSuchBiobankContactException extends NoSuchModelException {

	public NoSuchBiobankContactException() {
		super();
	}

	public NoSuchBiobankContactException(String msg) {
		super(msg);
	}

	public NoSuchBiobankContactException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchBiobankContactException(Throwable cause) {
		super(cause);
	}

}