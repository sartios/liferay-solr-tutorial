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

import com.ssavr.solr.model.IceCreamDocuments;

import java.util.Date;

/**
 * The cache model class for representing IceCreamDocuments in entity cache.
 *
 * @author SAVRAMIS
 * @see IceCreamDocuments
 * @generated
 */
public class IceCreamDocumentsCacheModel implements CacheModel<IceCreamDocuments> {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", iceCreamDocumentsId=");
		sb.append(iceCreamDocumentsId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", documentId=");
		sb.append(documentId);
		sb.append(", iceCreamId=");
		sb.append(iceCreamId);
		sb.append("}");

		return sb.toString();
	}

	public IceCreamDocuments toEntityModel() {
		IceCreamDocumentsImpl iceCreamDocumentsImpl = new IceCreamDocumentsImpl();

		if (uuid == null) {
			iceCreamDocumentsImpl.setUuid(StringPool.BLANK);
		}
		else {
			iceCreamDocumentsImpl.setUuid(uuid);
		}

		iceCreamDocumentsImpl.setIceCreamDocumentsId(iceCreamDocumentsId);
		iceCreamDocumentsImpl.setCompanyId(companyId);
		iceCreamDocumentsImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			iceCreamDocumentsImpl.setCreateDate(null);
		}
		else {
			iceCreamDocumentsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			iceCreamDocumentsImpl.setModifiedDate(null);
		}
		else {
			iceCreamDocumentsImpl.setModifiedDate(new Date(modifiedDate));
		}

		iceCreamDocumentsImpl.setDocumentId(documentId);
		iceCreamDocumentsImpl.setIceCreamId(iceCreamId);

		iceCreamDocumentsImpl.resetOriginalValues();

		return iceCreamDocumentsImpl;
	}

	public String uuid;
	public long iceCreamDocumentsId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long documentId;
	public long iceCreamId;
}