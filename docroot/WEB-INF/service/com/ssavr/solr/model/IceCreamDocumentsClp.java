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

import com.ssavr.solr.service.IceCreamDocumentsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author SAVRAMIS
 */
public class IceCreamDocumentsClp extends BaseModelImpl<IceCreamDocuments>
	implements IceCreamDocuments {
	public IceCreamDocumentsClp() {
	}

	public Class<?> getModelClass() {
		return IceCreamDocuments.class;
	}

	public String getModelClassName() {
		return IceCreamDocuments.class.getName();
	}

	public long getPrimaryKey() {
		return _iceCreamDocumentsId;
	}

	public void setPrimaryKey(long primaryKey) {
		setIceCreamDocumentsId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_iceCreamDocumentsId);
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

	public long getIceCreamDocumentsId() {
		return _iceCreamDocumentsId;
	}

	public void setIceCreamDocumentsId(long iceCreamDocumentsId) {
		_iceCreamDocumentsId = iceCreamDocumentsId;
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

	public long getDocumentId() {
		return _documentId;
	}

	public void setDocumentId(long documentId) {
		_documentId = documentId;
	}

	public long getIceCreamId() {
		return _iceCreamId;
	}

	public void setIceCreamId(long iceCreamId) {
		_iceCreamId = iceCreamId;
	}

	public java.lang.String getTitle() {
		throw new UnsupportedOperationException();
	}

	public void persist() throws SystemException {
		IceCreamDocumentsLocalServiceUtil.updateIceCreamDocuments(this);
	}

	@Override
	public IceCreamDocuments toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (IceCreamDocuments)Proxy.newProxyInstance(IceCreamDocuments.class.getClassLoader(),
				new Class[] { IceCreamDocuments.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	@Override
	public Object clone() {
		IceCreamDocumentsClp clone = new IceCreamDocumentsClp();

		clone.setUuid(getUuid());
		clone.setIceCreamDocumentsId(getIceCreamDocumentsId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDocumentId(getDocumentId());
		clone.setIceCreamId(getIceCreamId());

		return clone;
	}

	public int compareTo(IceCreamDocuments iceCreamDocuments) {
		long primaryKey = iceCreamDocuments.getPrimaryKey();

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

		IceCreamDocumentsClp iceCreamDocuments = null;

		try {
			iceCreamDocuments = (IceCreamDocumentsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = iceCreamDocuments.getPrimaryKey();

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
		sb.append(", iceCreamDocumentsId=");
		sb.append(getIceCreamDocumentsId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", documentId=");
		sb.append(getDocumentId());
		sb.append(", iceCreamId=");
		sb.append(getIceCreamId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ssavr.solr.model.IceCreamDocuments");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>iceCreamDocumentsId</column-name><column-value><![CDATA[");
		sb.append(getIceCreamDocumentsId());
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
			"<column><column-name>documentId</column-name><column-value><![CDATA[");
		sb.append(getDocumentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>iceCreamId</column-name><column-value><![CDATA[");
		sb.append(getIceCreamId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _iceCreamDocumentsId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _documentId;
	private long _iceCreamId;
}