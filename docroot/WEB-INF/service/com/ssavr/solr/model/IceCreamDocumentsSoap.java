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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ssavr.solr.service.http.IceCreamDocumentsServiceSoap}.
 *
 * @author    SAVRAMIS
 * @see       com.ssavr.solr.service.http.IceCreamDocumentsServiceSoap
 * @generated
 */
public class IceCreamDocumentsSoap implements Serializable {
	public static IceCreamDocumentsSoap toSoapModel(IceCreamDocuments model) {
		IceCreamDocumentsSoap soapModel = new IceCreamDocumentsSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setIceCreamDocumentsId(model.getIceCreamDocumentsId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDocumentId(model.getDocumentId());
		soapModel.setIceCreamId(model.getIceCreamId());

		return soapModel;
	}

	public static IceCreamDocumentsSoap[] toSoapModels(
		IceCreamDocuments[] models) {
		IceCreamDocumentsSoap[] soapModels = new IceCreamDocumentsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IceCreamDocumentsSoap[][] toSoapModels(
		IceCreamDocuments[][] models) {
		IceCreamDocumentsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new IceCreamDocumentsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new IceCreamDocumentsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IceCreamDocumentsSoap[] toSoapModels(
		List<IceCreamDocuments> models) {
		List<IceCreamDocumentsSoap> soapModels = new ArrayList<IceCreamDocumentsSoap>(models.size());

		for (IceCreamDocuments model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new IceCreamDocumentsSoap[soapModels.size()]);
	}

	public IceCreamDocumentsSoap() {
	}

	public long getPrimaryKey() {
		return _iceCreamDocumentsId;
	}

	public void setPrimaryKey(long pk) {
		setIceCreamDocumentsId(pk);
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

	private String _uuid;
	private long _iceCreamDocumentsId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _documentId;
	private long _iceCreamId;
}