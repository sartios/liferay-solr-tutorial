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
 * This class is a wrapper for {@link IceCream}.
 * </p>
 *
 * @author    SAVRAMIS
 * @see       IceCream
 * @generated
 */
public class IceCreamWrapper implements IceCream {
	public IceCreamWrapper(IceCream iceCream) {
		_iceCream = iceCream;
	}

	public Class<?> getModelClass() {
		return IceCream.class;
	}

	public String getModelClassName() {
		return IceCream.class.getName();
	}

	/**
	* Gets the primary key of this ice cream.
	*
	* @return the primary key of this ice cream
	*/
	public long getPrimaryKey() {
		return _iceCream.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ice cream
	*
	* @param primaryKey the primary key of this ice cream
	*/
	public void setPrimaryKey(long primaryKey) {
		_iceCream.setPrimaryKey(primaryKey);
	}

	/**
	* Gets the uuid of this ice cream.
	*
	* @return the uuid of this ice cream
	*/
	public java.lang.String getUuid() {
		return _iceCream.getUuid();
	}

	/**
	* Sets the uuid of this ice cream.
	*
	* @param uuid the uuid of this ice cream
	*/
	public void setUuid(java.lang.String uuid) {
		_iceCream.setUuid(uuid);
	}

	/**
	* Gets the ice cream ID of this ice cream.
	*
	* @return the ice cream ID of this ice cream
	*/
	public long getIceCreamId() {
		return _iceCream.getIceCreamId();
	}

	/**
	* Sets the ice cream ID of this ice cream.
	*
	* @param iceCreamId the ice cream ID of this ice cream
	*/
	public void setIceCreamId(long iceCreamId) {
		_iceCream.setIceCreamId(iceCreamId);
	}

	/**
	* Gets the company ID of this ice cream.
	*
	* @return the company ID of this ice cream
	*/
	public long getCompanyId() {
		return _iceCream.getCompanyId();
	}

	/**
	* Sets the company ID of this ice cream.
	*
	* @param companyId the company ID of this ice cream
	*/
	public void setCompanyId(long companyId) {
		_iceCream.setCompanyId(companyId);
	}

	/**
	* Gets the user ID of this ice cream.
	*
	* @return the user ID of this ice cream
	*/
	public long getUserId() {
		return _iceCream.getUserId();
	}

	/**
	* Sets the user ID of this ice cream.
	*
	* @param userId the user ID of this ice cream
	*/
	public void setUserId(long userId) {
		_iceCream.setUserId(userId);
	}

	/**
	* Gets the user uuid of this ice cream.
	*
	* @return the user uuid of this ice cream
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iceCream.getUserUuid();
	}

	/**
	* Sets the user uuid of this ice cream.
	*
	* @param userUuid the user uuid of this ice cream
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_iceCream.setUserUuid(userUuid);
	}

	/**
	* Gets the create date of this ice cream.
	*
	* @return the create date of this ice cream
	*/
	public java.util.Date getCreateDate() {
		return _iceCream.getCreateDate();
	}

	/**
	* Sets the create date of this ice cream.
	*
	* @param createDate the create date of this ice cream
	*/
	public void setCreateDate(java.util.Date createDate) {
		_iceCream.setCreateDate(createDate);
	}

	/**
	* Gets the modified date of this ice cream.
	*
	* @return the modified date of this ice cream
	*/
	public java.util.Date getModifiedDate() {
		return _iceCream.getModifiedDate();
	}

	/**
	* Sets the modified date of this ice cream.
	*
	* @param modifiedDate the modified date of this ice cream
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_iceCream.setModifiedDate(modifiedDate);
	}

	/**
	* Gets the flavor of this ice cream.
	*
	* @return the flavor of this ice cream
	*/
	public java.lang.String getFlavor() {
		return _iceCream.getFlavor();
	}

	/**
	* Sets the flavor of this ice cream.
	*
	* @param flavor the flavor of this ice cream
	*/
	public void setFlavor(java.lang.String flavor) {
		_iceCream.setFlavor(flavor);
	}

	/**
	* Gets the name of this ice cream.
	*
	* @return the name of this ice cream
	*/
	public java.lang.String getName() {
		return _iceCream.getName();
	}

	/**
	* Sets the name of this ice cream.
	*
	* @param name the name of this ice cream
	*/
	public void setName(java.lang.String name) {
		_iceCream.setName(name);
	}

	public boolean isNew() {
		return _iceCream.isNew();
	}

	public void setNew(boolean n) {
		_iceCream.setNew(n);
	}

	public boolean isCachedModel() {
		return _iceCream.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_iceCream.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _iceCream.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_iceCream.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _iceCream.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_iceCream.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _iceCream.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_iceCream.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new IceCreamWrapper((IceCream)_iceCream.clone());
	}

	public int compareTo(com.ssavr.solr.model.IceCream iceCream) {
		return _iceCream.compareTo(iceCream);
	}

	@Override
	public int hashCode() {
		return _iceCream.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ssavr.solr.model.IceCream> toCacheModel() {
		return _iceCream.toCacheModel();
	}

	public com.ssavr.solr.model.IceCream toEscapedModel() {
		return new IceCreamWrapper(_iceCream.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _iceCream.toString();
	}

	public java.lang.String toXmlString() {
		return _iceCream.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_iceCream.persist();
	}

	public java.util.List<com.ssavr.solr.model.IceCreamDocuments> getDocuments() {
		return _iceCream.getDocuments();
	}

	public IceCream getWrappedIceCream() {
		return _iceCream;
	}

	public void resetOriginalValues() {
		_iceCream.resetOriginalValues();
	}

	private IceCream _iceCream;
}