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

/**
 * <p>
 * This class is a wrapper for {@link IceCreamDocuments}.
 * </p>
 *
 * @author    SAVRAMIS
 * @see       IceCreamDocuments
 * @generated
 */
public class IceCreamDocumentsWrapper implements IceCreamDocuments {
	public IceCreamDocumentsWrapper(IceCreamDocuments iceCreamDocuments) {
		_iceCreamDocuments = iceCreamDocuments;
	}

	public Class<?> getModelClass() {
		return IceCreamDocuments.class;
	}

	public String getModelClassName() {
		return IceCreamDocuments.class.getName();
	}

	/**
	* Gets the primary key of this ice cream documents.
	*
	* @return the primary key of this ice cream documents
	*/
	public long getPrimaryKey() {
		return _iceCreamDocuments.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ice cream documents
	*
	* @param primaryKey the primary key of this ice cream documents
	*/
	public void setPrimaryKey(long primaryKey) {
		_iceCreamDocuments.setPrimaryKey(primaryKey);
	}

	/**
	* Gets the uuid of this ice cream documents.
	*
	* @return the uuid of this ice cream documents
	*/
	public java.lang.String getUuid() {
		return _iceCreamDocuments.getUuid();
	}

	/**
	* Sets the uuid of this ice cream documents.
	*
	* @param uuid the uuid of this ice cream documents
	*/
	public void setUuid(java.lang.String uuid) {
		_iceCreamDocuments.setUuid(uuid);
	}

	/**
	* Gets the ice cream documents ID of this ice cream documents.
	*
	* @return the ice cream documents ID of this ice cream documents
	*/
	public long getIceCreamDocumentsId() {
		return _iceCreamDocuments.getIceCreamDocumentsId();
	}

	/**
	* Sets the ice cream documents ID of this ice cream documents.
	*
	* @param iceCreamDocumentsId the ice cream documents ID of this ice cream documents
	*/
	public void setIceCreamDocumentsId(long iceCreamDocumentsId) {
		_iceCreamDocuments.setIceCreamDocumentsId(iceCreamDocumentsId);
	}

	/**
	* Gets the company ID of this ice cream documents.
	*
	* @return the company ID of this ice cream documents
	*/
	public long getCompanyId() {
		return _iceCreamDocuments.getCompanyId();
	}

	/**
	* Sets the company ID of this ice cream documents.
	*
	* @param companyId the company ID of this ice cream documents
	*/
	public void setCompanyId(long companyId) {
		_iceCreamDocuments.setCompanyId(companyId);
	}

	/**
	* Gets the user ID of this ice cream documents.
	*
	* @return the user ID of this ice cream documents
	*/
	public long getUserId() {
		return _iceCreamDocuments.getUserId();
	}

	/**
	* Sets the user ID of this ice cream documents.
	*
	* @param userId the user ID of this ice cream documents
	*/
	public void setUserId(long userId) {
		_iceCreamDocuments.setUserId(userId);
	}

	/**
	* Gets the user uuid of this ice cream documents.
	*
	* @return the user uuid of this ice cream documents
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iceCreamDocuments.getUserUuid();
	}

	/**
	* Sets the user uuid of this ice cream documents.
	*
	* @param userUuid the user uuid of this ice cream documents
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_iceCreamDocuments.setUserUuid(userUuid);
	}

	/**
	* Gets the create date of this ice cream documents.
	*
	* @return the create date of this ice cream documents
	*/
	public java.util.Date getCreateDate() {
		return _iceCreamDocuments.getCreateDate();
	}

	/**
	* Sets the create date of this ice cream documents.
	*
	* @param createDate the create date of this ice cream documents
	*/
	public void setCreateDate(java.util.Date createDate) {
		_iceCreamDocuments.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this ice cream documents.
	*
	* @return the modified date of this ice cream documents
	*/
	public java.util.Date getModifiedDate() {
		return _iceCreamDocuments.getModifiedDate();
	}

	/**
	* Sets the modified date of this ice cream documents.
	*
	* @param modifiedDate the modified date of this ice cream documents
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_iceCreamDocuments.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the document ID of this ice cream documents.
	*
	* @return the document ID of this ice cream documents
	*/
	public long getDocumentId() {
		return _iceCreamDocuments.getDocumentId();
	}

	/**
	* Sets the document ID of this ice cream documents.
	*
	* @param documentId the document ID of this ice cream documents
	*/
	public void setDocumentId(long documentId) {
		_iceCreamDocuments.setDocumentId(documentId);
	}

	/**
	* Gets the ice cream ID of this ice cream documents.
	*
	* @return the ice cream ID of this ice cream documents
	*/
	public long getIceCreamId() {
		return _iceCreamDocuments.getIceCreamId();
	}

	/**
	* Sets the ice cream ID of this ice cream documents.
	*
	* @param iceCreamId the ice cream ID of this ice cream documents
	*/
	public void setIceCreamId(long iceCreamId) {
		_iceCreamDocuments.setIceCreamId(iceCreamId);
	}

	public boolean isNew() {
		return _iceCreamDocuments.isNew();
	}

	public void setNew(boolean n) {
		_iceCreamDocuments.setNew(n);
	}

	public boolean isCachedModel() {
		return _iceCreamDocuments.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_iceCreamDocuments.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _iceCreamDocuments.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_iceCreamDocuments.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _iceCreamDocuments.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_iceCreamDocuments.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _iceCreamDocuments.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_iceCreamDocuments.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new IceCreamDocumentsWrapper((IceCreamDocuments)_iceCreamDocuments.clone());
	}

	public int compareTo(
		com.ssavr.solr.model.IceCreamDocuments iceCreamDocuments) {
		return _iceCreamDocuments.compareTo(iceCreamDocuments);
	}

	@Override
	public int hashCode() {
		return _iceCreamDocuments.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ssavr.solr.model.IceCreamDocuments> toCacheModel() {
		return _iceCreamDocuments.toCacheModel();
	}

	public com.ssavr.solr.model.IceCreamDocuments toEscapedModel() {
		return new IceCreamDocumentsWrapper(_iceCreamDocuments.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _iceCreamDocuments.toString();
	}

	public java.lang.String toXmlString() {
		return _iceCreamDocuments.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_iceCreamDocuments.persist();
	}

	public java.lang.String getTitle() {
		return _iceCreamDocuments.getTitle();
	}

	public IceCreamDocuments getWrappedIceCreamDocuments() {
		return _iceCreamDocuments;
	}

	public void resetOriginalValues() {
		_iceCreamDocuments.resetOriginalValues();
	}

	private IceCreamDocuments _iceCreamDocuments;
}