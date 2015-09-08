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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the ice cream local service. This utility wraps {@link com.ssavr.solr.service.impl.IceCreamLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author SAVRAMIS
 * @see IceCreamLocalService
 * @see com.ssavr.solr.service.base.IceCreamLocalServiceBaseImpl
 * @see com.ssavr.solr.service.impl.IceCreamLocalServiceImpl
 * @generated
 */
public class IceCreamLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ssavr.solr.service.impl.IceCreamLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the ice cream to the database. Also notifies the appropriate model listeners.
	*
	* @param iceCream the ice cream
	* @return the ice cream that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCream addIceCream(
		com.ssavr.solr.model.IceCream iceCream)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addIceCream(iceCream);
	}

	/**
	* Creates a new ice cream with the primary key. Does not add the ice cream to the database.
	*
	* @param iceCreamId the primary key for the new ice cream
	* @return the new ice cream
	*/
	public static com.ssavr.solr.model.IceCream createIceCream(long iceCreamId) {
		return getService().createIceCream(iceCreamId);
	}

	/**
	* Deletes the ice cream with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param iceCreamId the primary key of the ice cream
	* @throws PortalException if a ice cream with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteIceCream(long iceCreamId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteIceCream(iceCreamId);
	}

	/**
	* Deletes the ice cream from the database. Also notifies the appropriate model listeners.
	*
	* @param iceCream the ice cream
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteIceCream(com.ssavr.solr.model.IceCream iceCream)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteIceCream(iceCream);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the ice cream with the primary key.
	*
	* @param iceCreamId the primary key of the ice cream
	* @return the ice cream
	* @throws PortalException if a ice cream with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCream getIceCream(long iceCreamId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getIceCream(iceCreamId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.ssavr.solr.model.IceCream> getIceCreams(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getIceCreams(start, end);
	}

	/**
	* Returns the number of ice creams.
	*
	* @return the number of ice creams
	* @throws SystemException if a system exception occurred
	*/
	public static int getIceCreamsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getIceCreamsCount();
	}

	/**
	* Updates the ice cream in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param iceCream the ice cream
	* @return the ice cream that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCream updateIceCream(
		com.ssavr.solr.model.IceCream iceCream)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateIceCream(iceCream);
	}

	/**
	* Updates the ice cream in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param iceCream the ice cream
	* @param merge whether to merge the ice cream with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the ice cream that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCream updateIceCream(
		com.ssavr.solr.model.IceCream iceCream, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateIceCream(iceCream, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static com.ssavr.solr.model.IceCream addIceCream(long userId,
		long companyId,
		com.liferay.portal.service.ServiceContext serviceContext,
		java.lang.String name, java.lang.String flavor,
		java.lang.String[] documents) throws java.lang.Exception {
		return getService()
				   .addIceCream(userId, companyId, serviceContext, name,
			flavor, documents);
	}

	/**
	* GET ********************************************
	*/
	public static com.ssavr.solr.beans.IceCreamBean getIceCreamBean(
		com.ssavr.solr.model.IceCream iceCream) throws java.lang.Exception {
		return getService().getIceCreamBean(iceCream);
	}

	public static java.util.List<com.ssavr.solr.model.IceCream> getAllIceCreams()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllIceCreams();
	}

	public static java.util.List<com.ssavr.solr.model.IceCream> getIceCreams(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getIceCreams(start, end, orderByComparator);
	}

	public static java.util.List<org.apache.solr.client.solrj.response.FacetField> getIceCreamsFacets()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getIceCreamsFacets();
	}

	public static java.util.List<com.ssavr.solr.model.IceCream> facetIceCreams(
		java.lang.String facetValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().facetIceCreams(facetValue);
	}

	public static java.util.List<com.ssavr.solr.model.IceCream> searchIceCreams(
		java.lang.String name, java.lang.String flavor, java.lang.String text,
		int start, int rows, java.lang.String orderByCol,
		java.lang.String orderByType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchIceCreams(name, flavor, text, start, rows,
			orderByCol, orderByType);
	}

	public static java.util.List<com.ssavr.solr.model.IceCream> searchIceCreamsWithEDisMax(
		java.lang.String name, java.lang.String flavor, java.lang.String text,
		java.lang.String value, int start, int rows,
		java.lang.String orderByCol, java.lang.String orderByType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchIceCreamsWithEDisMax(name, flavor, text, value,
			start, rows, orderByCol, orderByType);
	}

	public static void clearService() {
		_service = null;
	}

	public static IceCreamLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					IceCreamLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					IceCreamLocalService.class.getName(), portletClassLoader);

			_service = new IceCreamLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(IceCreamLocalServiceUtil.class,
				"_service");
			MethodCache.remove(IceCreamLocalService.class);
		}

		return _service;
	}

	public void setService(IceCreamLocalService service) {
		MethodCache.remove(IceCreamLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(IceCreamLocalServiceUtil.class,
			"_service");
		MethodCache.remove(IceCreamLocalService.class);
	}

	private static IceCreamLocalService _service;
}