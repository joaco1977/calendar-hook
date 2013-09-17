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
import com.liferay.hook.calendar.model.CalEventAttendeeModel;
import com.liferay.hook.calendar.model.CalEventAttendeeSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CalEventAttendee service. Represents a row in the &quot;cal_CalEventAttendee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.hook.calendar.model.CalEventAttendeeModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CalEventAttendeeImpl}.
 * </p>
 *
 * @author Joaquin Cabal
 * @see CalEventAttendeeImpl
 * @see com.liferay.hook.calendar.model.CalEventAttendee
 * @see com.liferay.hook.calendar.model.CalEventAttendeeModel
 * @generated
 */
@JSON(strict = true)
public class CalEventAttendeeModelImpl extends BaseModelImpl<CalEventAttendee>
	implements CalEventAttendeeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cal event attendee model instance should use the {@link com.liferay.hook.calendar.model.CalEventAttendee} interface instead.
	 */
	public static final String TABLE_NAME = "cal_CalEventAttendee";
	public static final Object[][] TABLE_COLUMNS = {
			{ "calEventAttendeeId", Types.BIGINT },
			{ "eventId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "assist", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table cal_CalEventAttendee (calEventAttendeeId LONG not null primary key,eventId LONG,userId LONG,assist BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table cal_CalEventAttendee";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.hook.calendar.model.CalEventAttendee"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.hook.calendar.model.CalEventAttendee"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.hook.calendar.model.CalEventAttendee"),
			true);
	public static long ASSIST_COLUMN_BITMASK = 1L;
	public static long EVENTID_COLUMN_BITMASK = 2L;
	public static long USERID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CalEventAttendee toModel(CalEventAttendeeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CalEventAttendee model = new CalEventAttendeeImpl();

		model.setCalEventAttendeeId(soapModel.getCalEventAttendeeId());
		model.setEventId(soapModel.getEventId());
		model.setUserId(soapModel.getUserId());
		model.setAssist(soapModel.getAssist());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CalEventAttendee> toModels(
		CalEventAttendeeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CalEventAttendee> models = new ArrayList<CalEventAttendee>(soapModels.length);

		for (CalEventAttendeeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.hook.calendar.model.CalEventAttendee"));

	public CalEventAttendeeModelImpl() {
	}

	public long getPrimaryKey() {
		return _calEventAttendeeId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCalEventAttendeeId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_calEventAttendeeId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return CalEventAttendee.class;
	}

	public String getModelClassName() {
		return CalEventAttendee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("calEventAttendeeId", getCalEventAttendeeId());
		attributes.put("eventId", getEventId());
		attributes.put("userId", getUserId());
		attributes.put("assist", getAssist());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long calEventAttendeeId = (Long)attributes.get("calEventAttendeeId");

		if (calEventAttendeeId != null) {
			setCalEventAttendeeId(calEventAttendeeId);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Boolean assist = (Boolean)attributes.get("assist");

		if (assist != null) {
			setAssist(assist);
		}
	}

	@JSON
	public long getCalEventAttendeeId() {
		return _calEventAttendeeId;
	}

	public void setCalEventAttendeeId(long calEventAttendeeId) {
		_calEventAttendeeId = calEventAttendeeId;
	}

	@JSON
	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_columnBitmask |= EVENTID_COLUMN_BITMASK;

		if (!_setOriginalEventId) {
			_setOriginalEventId = true;

			_originalEventId = _eventId;
		}

		_eventId = eventId;
	}

	public long getOriginalEventId() {
		return _originalEventId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	public boolean getAssist() {
		return _assist;
	}

	public boolean isAssist() {
		return _assist;
	}

	public void setAssist(boolean assist) {
		_columnBitmask |= ASSIST_COLUMN_BITMASK;

		if (!_setOriginalAssist) {
			_setOriginalAssist = true;

			_originalAssist = _assist;
		}

		_assist = assist;
	}

	public boolean getOriginalAssist() {
		return _originalAssist;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			CalEventAttendee.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CalEventAttendee toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (CalEventAttendee)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		CalEventAttendeeImpl calEventAttendeeImpl = new CalEventAttendeeImpl();

		calEventAttendeeImpl.setCalEventAttendeeId(getCalEventAttendeeId());
		calEventAttendeeImpl.setEventId(getEventId());
		calEventAttendeeImpl.setUserId(getUserId());
		calEventAttendeeImpl.setAssist(getAssist());

		calEventAttendeeImpl.resetOriginalValues();

		return calEventAttendeeImpl;
	}

	public int compareTo(CalEventAttendee calEventAttendee) {
		long primaryKey = calEventAttendee.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CalEventAttendee calEventAttendee = null;

		try {
			calEventAttendee = (CalEventAttendee)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = calEventAttendee.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		CalEventAttendeeModelImpl calEventAttendeeModelImpl = this;

		calEventAttendeeModelImpl._originalEventId = calEventAttendeeModelImpl._eventId;

		calEventAttendeeModelImpl._setOriginalEventId = false;

		calEventAttendeeModelImpl._originalUserId = calEventAttendeeModelImpl._userId;

		calEventAttendeeModelImpl._setOriginalUserId = false;

		calEventAttendeeModelImpl._originalAssist = calEventAttendeeModelImpl._assist;

		calEventAttendeeModelImpl._setOriginalAssist = false;

		calEventAttendeeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CalEventAttendee> toCacheModel() {
		CalEventAttendeeCacheModel calEventAttendeeCacheModel = new CalEventAttendeeCacheModel();

		calEventAttendeeCacheModel.calEventAttendeeId = getCalEventAttendeeId();

		calEventAttendeeCacheModel.eventId = getEventId();

		calEventAttendeeCacheModel.userId = getUserId();

		calEventAttendeeCacheModel.assist = getAssist();

		return calEventAttendeeCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{calEventAttendeeId=");
		sb.append(getCalEventAttendeeId());
		sb.append(", eventId=");
		sb.append(getEventId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", assist=");
		sb.append(getAssist());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.liferay.hook.calendar.model.CalEventAttendee");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>calEventAttendeeId</column-name><column-value><![CDATA[");
		sb.append(getCalEventAttendeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assist</column-name><column-value><![CDATA[");
		sb.append(getAssist());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CalEventAttendee.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			CalEventAttendee.class
		};
	private long _calEventAttendeeId;
	private long _eventId;
	private long _originalEventId;
	private boolean _setOriginalEventId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private boolean _assist;
	private boolean _originalAssist;
	private boolean _setOriginalAssist;
	private long _columnBitmask;
	private CalEventAttendee _escapedModelProxy;
}