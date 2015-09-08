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
 * This class is used by SOAP remote services, specifically {@link com.ssavr.solr.service.http.IceCreamServiceSoap}.
 *
 * @author    SAVRAMIS
 * @see       com.ssavr.solr.service.http.IceCreamServiceSoap
 * @generated
 */
public class IceCreamSoap implements Serializable {
	public static IceCreamSoap toSoapModel(IceCream model) {
		IceCreamSoap soapModel = new IceCreamSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setIceCreamId(model.getIceCreamId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFlavor(model.getFlavor());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static IceCreamSoap[] toSoapModels(IceCream[] models) {
		IceCreamSoap[] soapModels = new IceCreamSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IceCreamSoap[][] toSoapModels(IceCream[][] models) {
		IceCreamSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new IceCreamSoap[models.length][models[0].length];
		}
		else {
			soapModels = new IceCreamSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IceCreamSoap[] toSoapModels(List<IceCream> models) {
		List<IceCreamSoap> soapModels = new ArrayList<IceCreamSoap>(models.size());

		for (IceCream model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new IceCreamSoap[soapModels.size()]);
	}

	public IceCreamSoap() {
	}

	public long getPrimaryKey() {
		return _iceCreamId;
	}

	public void setPrimaryKey(long pk) {
		setIceCreamId(pk);
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

	private String _uuid;
	private long _iceCreamId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _flavor;
	private String _name;
}