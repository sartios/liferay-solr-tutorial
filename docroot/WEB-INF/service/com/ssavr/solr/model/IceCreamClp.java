/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.ssavr.solr.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.ssavr.solr.service.IceCreamLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author SAVRAMIS
 */
public class IceCreamClp extends BaseModelImpl<IceCream> implements IceCream {
	public IceCreamClp() {
	}

	public Class<?> getModelClass() {
		return IceCream.class;
	}

	public String getModelClassName() {
		return IceCream.class.getName();
	}

	public long getPrimaryKey() {
		return _iceCreamId;
	}

	public void setPrimaryKey(long primaryKey) {
		setIceCreamId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_iceCreamId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getIceCreamId() {
		return _iceCreamId;
	}

	public void setIceCreamId(long iceCreamId) {
		_iceCreamId = iceCreamId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getFlavor() {
		return _flavor;
	}

	public void setFlavor(String flavor) {
		_flavor = flavor;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public java.util.List<com.ssavr.solr.model.IceCreamDocuments> getDocuments() {
		throw new UnsupportedOperationException();
	}

	public void persist() throws SystemException {
		IceCreamLocalServiceUtil.updateIceCream(this);
	}

	@Override
	public IceCream toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (IceCream)Proxy.newProxyInstance(IceCream.class.getClassLoader(),
				new Class[] { IceCream.class }, new AutoEscapeBeanHandler(this));
		}
	}

	@Override
	public Object clone() {
		IceCreamClp clone = new IceCreamClp();

		clone.setUuid(getUuid());
		clone.setIceCreamId(getIceCreamId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setFlavor(getFlavor());
		clone.setName(getName());

		return clone;
	}

	public int compareTo(IceCream iceCream) {
		int value = 0;

		if (getIceCreamId() < iceCream.getIceCreamId()) {
			value = -1;
		}
		else if (getIceCreamId() > iceCream.getIceCreamId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		IceCreamClp iceCream = null;

		try {
			iceCream = (IceCreamClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = iceCream.getPrimaryKey();

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
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", iceCreamId=");
		sb.append(getIceCreamId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", flavor=");
		sb.append(getFlavor());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ssavr.solr.model.IceCream");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>iceCreamId</column-name><column-value><![CDATA[");
		sb.append(getIceCreamId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flavor</column-name><column-value><![CDATA[");
		sb.append(getFlavor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _iceCreamId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _flavor;
	private String _name;
}