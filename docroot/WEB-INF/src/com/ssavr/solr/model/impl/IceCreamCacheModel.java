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

package com.ssavr.solr.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.ssavr.solr.model.IceCream;

import java.util.Date;

/**
 * The cache model class for representing IceCream in entity cache.
 *
 * @author SAVRAMIS
 * @see IceCream
 * @generated
 */
public class IceCreamCacheModel implements CacheModel<IceCream> {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", iceCreamId=");
		sb.append(iceCreamId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", flavor=");
		sb.append(flavor);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	public IceCream toEntityModel() {
		IceCreamImpl iceCreamImpl = new IceCreamImpl();

		if (uuid == null) {
			iceCreamImpl.setUuid(StringPool.BLANK);
		}
		else {
			iceCreamImpl.setUuid(uuid);
		}

		iceCreamImpl.setIceCreamId(iceCreamId);
		iceCreamImpl.setCompanyId(companyId);
		iceCreamImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			iceCreamImpl.setCreateDate(null);
		}
		else {
			iceCreamImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			iceCreamImpl.setModifiedDate(null);
		}
		else {
			iceCreamImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (flavor == null) {
			iceCreamImpl.setFlavor(StringPool.BLANK);
		}
		else {
			iceCreamImpl.setFlavor(flavor);
		}

		if (name == null) {
			iceCreamImpl.setName(StringPool.BLANK);
		}
		else {
			iceCreamImpl.setName(name);
		}

		iceCreamImpl.resetOriginalValues();

		return iceCreamImpl;
	}

	public String uuid;
	public long iceCreamId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String flavor;
	public String name;
}