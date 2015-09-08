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

package com.ssavr.solr.service;

/**
 * <p>
 * This class is a wrapper for {@link IceCreamLocalService}.
 * </p>
 *
 * @author    SAVRAMIS
 * @see       IceCreamLocalService
 * @generated
 */
public class IceCreamLocalServiceWrapper implements IceCreamLocalService {
	public IceCreamLocalServiceWrapper(
		IceCreamLocalService iceCreamLocalService) {
		_iceCreamLocalService = iceCreamLocalService;
	}

	/**
	* Adds the ice cream to the database. Also notifies the appropriate model listeners.
	*
	* @param iceCream the ice cream
	* @return the ice cream that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ssavr.solr.model.IceCream addIceCream(
		com.ssavr.solr.model.IceCream iceCream)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iceCreamLocalService.addIceCream(iceCream);
	}

	/**
	* Creates a new ice cream with the primary key. Does not add the ice cream to the database.
	*
	* @param iceCreamId the primary key for the new ice cream
	* @return the new ice cream
	*/
	public com.ssavr.solr.model.IceCream createIceCream(long iceCreamId) {
		return _iceCreamLocalService.createIceCream(iceCreamId);
	}

	/**
	* Deletes the ice cream with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param iceCreamId the primary key of the ice cream
	* @throws PortalException if a ice cream with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteIceCream(long iceCreamId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_iceCreamLocalService.deleteIceCream(iceCreamId);
	}

	/**
	* Deletes the ice cream from the database. Also notifies the appropriate model listeners.
	*
	* @param iceCream the ice cream
	* @throws SystemException if a system exception occurred
	*/
	public void deleteIceCream(com.ssavr.solr.model.IceCream iceCream)
		throws com.liferay.portal.kernel.exception.SystemException {
		_iceCreamLocalService.deleteIceCream(iceCream);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iceCreamLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _iceCreamLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iceCreamLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iceCreamLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the ice cream with the primary key.
	*
	* @param iceCreamId the primary key of the ice cream
	* @return the ice cream
	* @throws PortalException if a ice cream with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ssavr.solr.model.IceCream getIceCream(long iceCreamId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _iceCreamLocalService.getIceCream(iceCreamId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _iceCreamLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the ice creams.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ice creams
	* @param end the upper bound of the range of ice creams (not inclusive)
	* @return the range of ice creams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ssavr.solr.model.IceCream> getIceCreams(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iceCreamLocalService.getIceCreams(start, end);
	}

	/**
	* Returns the number of ice creams.
	*
	* @return the number of ice creams
	* @throws SystemException if a system exception occurred
	*/
	public int getIceCreamsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iceCreamLocalService.getIceCreamsCount();
	}

	/**
	* Updates the ice cream in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param iceCream the ice cream
	* @return the ice cream that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ssavr.solr.model.IceCream updateIceCream(
		com.ssavr.solr.model.IceCream iceCream)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iceCreamLocalService.updateIceCream(iceCream);
	}

	/**
	* Updates the ice cream in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param iceCream the ice cream
	* @param merge whether to merge the ice cream with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the ice cream that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ssavr.solr.model.IceCream updateIceCream(
		com.ssavr.solr.model.IceCream iceCream, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iceCreamLocalService.updateIceCream(iceCream, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _iceCreamLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_iceCreamLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.ssavr.solr.model.IceCream addIceCream(long userId,
		long companyId,
		com.liferay.portal.service.ServiceContext serviceContext,
		java.lang.String name, java.lang.String flavor,
		java.lang.String[] documents) throws java.lang.Exception {
		return _iceCreamLocalService.addIceCream(userId, companyId,
			serviceContext, name, flavor, documents);
	}

	/**
	* GET ********************************************
	*/
	public com.ssavr.solr.beans.IceCreamBean getIceCreamBean(
		com.ssavr.solr.model.IceCream iceCream) throws java.lang.Exception {
		return _iceCreamLocalService.getIceCreamBean(iceCream);
	}

	public java.util.List<com.ssavr.solr.model.IceCream> getAllIceCreams()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iceCreamLocalService.getAllIceCreams();
	}

	public java.util.List<com.ssavr.solr.model.IceCream> getIceCreams(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iceCreamLocalService.getIceCreams(start, end, orderByComparator);
	}

	public java.util.List<org.apache.solr.client.solrj.response.FacetField> getIceCreamsFacets()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iceCreamLocalService.getIceCreamsFacets();
	}

	public java.util.List<com.ssavr.solr.model.IceCream> facetIceCreams(
		java.lang.String facetValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _iceCreamLocalService.facetIceCreams(facetValue);
	}

	public java.util.List<com.ssavr.solr.model.IceCream> searchIceCreams(
		java.lang.String name, java.lang.String flavor, java.lang.String text,
		int start, int rows, java.lang.String orderByCol,
		java.lang.String orderByType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _iceCreamLocalService.searchIceCreams(name, flavor, text, start,
			rows, orderByCol, orderByType);
	}

	public java.util.List<com.ssavr.solr.model.IceCream> searchIceCreamsWithEDisMax(
		java.lang.String name, java.lang.String flavor, java.lang.String text,
		java.lang.String value, int start, int rows,
		java.lang.String orderByCol, java.lang.String orderByType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _iceCreamLocalService.searchIceCreamsWithEDisMax(name, flavor,
			text, value, start, rows, orderByCol, orderByType);
	}

	public IceCreamLocalService getWrappedIceCreamLocalService() {
		return _iceCreamLocalService;
	}

	public void setWrappedIceCreamLocalService(
		IceCreamLocalService iceCreamLocalService) {
		_iceCreamLocalService = iceCreamLocalService;
	}

	private IceCreamLocalService _iceCreamLocalService;
}