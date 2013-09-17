/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.hook.calendar.model.impl;

import com.liferay.hook.calendar.model.CalEventAttendee;
import com.liferay.hook.calendar.service.CalEventAttendeeLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the CalEventAttendee service. Represents a row in the &quot;cal_CalEventAttendee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CalEventAttendeeImpl}.
 * </p>
 *
 * @author Joaquin Cabal
 * @see CalEventAttendeeImpl
 * @see com.liferay.hook.calendar.model.CalEventAttendee
 * @generated
 */
public abstract class CalEventAttendeeBaseImpl extends CalEventAttendeeModelImpl
	implements CalEventAttendee {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cal event attendee model instance should use the {@link CalEventAttendee} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			CalEventAttendeeLocalServiceUtil.addCalEventAttendee(this);
		}
		else {
			CalEventAttendeeLocalServiceUtil.updateCalEventAttendee(this);
		}
	}
}