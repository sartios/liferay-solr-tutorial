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

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author SAVRAMIS
 */
public class IceCreamLocalServiceClp implements IceCreamLocalService {
	public IceCreamLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addIceCreamMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addIceCream", com.ssavr.solr.model.IceCream.class);

		_createIceCreamMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createIceCream", long.class);

		_deleteIceCreamMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteIceCream", long.class);

		_deleteIceCreamMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteIceCream", com.ssavr.solr.model.IceCream.class);

		_dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class);

		_dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQueryCount",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_getIceCreamMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"getIceCream", long.class);

		_getPersistedModelMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getIceCreamsMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getIceCreams", int.class, int.class);

		_getIceCreamsCountMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getIceCreamsCount");

		_updateIceCreamMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateIceCream", com.ssavr.solr.model.IceCream.class);

		_updateIceCreamMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateIceCream", com.ssavr.solr.model.IceCream.class,
				boolean.class);

		_getBeanIdentifierMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_addIceCreamMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"addIceCream", long.class, long.class,
				com.liferay.portal.service.ServiceContext.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String[].class);

		_getIceCreamBeanMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"getIceCreamBean", com.ssavr.solr.model.IceCream.class);

		_getAllIceCreamsMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAllIceCreams");

		_getIceCreamsMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"getIceCreams", int.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_getIceCreamsFacetsMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"getIceCreamsFacets");

		_facetIceCreamsMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"facetIceCreams", java.lang.String.class);

		_searchIceCreamsMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchIceCreams", java.lang.String.class,
				java.lang.String.class, java.lang.String.class, int.class,
				int.class, java.lang.String.class, java.lang.String.class);

		_searchIceCreamsWithEDisMaxMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchIceCreamsWithEDisMax", java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, int.class, int.class,
				java.lang.String.class, java.lang.String.class);
	}

	public com.ssavr.solr.model.IceCream addIceCream(
		com.ssavr.solr.model.IceCream iceCream)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addIceCreamMethodKey0,
				ClpSerializer.translateInput(iceCream));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.ssavr.solr.model.IceCream)ClpSerializer.translateOutput(returnObj);
	}

	public com.ssavr.solr.model.IceCream createIceCream(long iceCreamId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createIceCreamMethodKey1,
				iceCreamId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.ssavr.solr.model.IceCream)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteIceCream(long iceCreamId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteIceCreamMethodKey2,
				iceCreamId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteIceCream(com.ssavr.solr.model.IceCream iceCream)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteIceCreamMethodKey3,
				ClpSerializer.translateInput(iceCream));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
				ClpSerializer.translateInput(dynamicQuery), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
				ClpSerializer.translateInput(dynamicQuery), start, end,
				ClpSerializer.translateInput(orderByComparator));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public com.ssavr.solr.model.IceCream getIceCream(long iceCreamId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getIceCreamMethodKey8,
				iceCreamId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.ssavr.solr.model.IceCream)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getPersistedModelMethodKey9,
				ClpSerializer.translateInput(primaryKeyObj));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.ssavr.solr.model.IceCream> getIceCreams(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getIceCreamsMethodKey10,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.ssavr.solr.model.IceCream>)ClpSerializer.translateOutput(returnObj);
	}

	public int getIceCreamsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getIceCreamsCountMethodKey11);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public com.ssavr.solr.model.IceCream updateIceCream(
		com.ssavr.solr.model.IceCream iceCream)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateIceCreamMethodKey12,
				ClpSerializer.translateInput(iceCream));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.ssavr.solr.model.IceCream)ClpSerializer.translateOutput(returnObj);
	}

	public com.ssavr.solr.model.IceCream updateIceCream(
		com.ssavr.solr.model.IceCream iceCream, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateIceCreamMethodKey13,
				ClpSerializer.translateInput(iceCream), merge);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.ssavr.solr.model.IceCream)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBeanIdentifierMethodKey14);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		MethodHandler methodHandler = new MethodHandler(_setBeanIdentifierMethodKey15,
				ClpSerializer.translateInput(beanIdentifier));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public com.ssavr.solr.model.IceCream addIceCream(long userId,
		long companyId,
		com.liferay.portal.service.ServiceContext serviceContext,
		java.lang.String name, java.lang.String flavor,
		java.lang.String[] documents) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addIceCreamMethodKey16,
				userId, companyId,
				ClpSerializer.translateInput(serviceContext),
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(flavor),
				ClpSerializer.translateInput(documents));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.ssavr.solr.model.IceCream)ClpSerializer.translateOutput(returnObj);
	}

	public com.ssavr.solr.beans.IceCreamBean getIceCreamBean(
		com.ssavr.solr.model.IceCream iceCream) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getIceCreamBeanMethodKey17,
				ClpSerializer.translateInput(iceCream));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.ssavr.solr.beans.IceCreamBean)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.ssavr.solr.model.IceCream> getAllIceCreams()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllIceCreamsMethodKey18);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.ssavr.solr.model.IceCream>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.ssavr.solr.model.IceCream> getIceCreams(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getIceCreamsMethodKey19,
				start, end, ClpSerializer.translateInput(orderByComparator));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.ssavr.solr.model.IceCream>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.apache.solr.client.solrj.response.FacetField> getIceCreamsFacets()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getIceCreamsFacetsMethodKey20);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<org.apache.solr.client.solrj.response.FacetField>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.ssavr.solr.model.IceCream> facetIceCreams(
		java.lang.String facetValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_facetIceCreamsMethodKey21,
				ClpSerializer.translateInput(facetValue));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.ssavr.solr.model.IceCream>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.ssavr.solr.model.IceCream> searchIceCreams(
		java.lang.String name, java.lang.String flavor, java.lang.String text,
		int start, int rows, java.lang.String orderByCol,
		java.lang.String orderByType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchIceCreamsMethodKey22,
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(flavor),
				ClpSerializer.translateInput(text), start, rows,
				ClpSerializer.translateInput(orderByCol),
				ClpSerializer.translateInput(orderByType));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.ssavr.solr.model.IceCream>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.ssavr.solr.model.IceCream> searchIceCreamsWithEDisMax(
		java.lang.String name, java.lang.String flavor, java.lang.String text,
		java.lang.String value, int start, int rows,
		java.lang.String orderByCol, java.lang.String orderByType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchIceCreamsWithEDisMaxMethodKey23,
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(flavor),
				ClpSerializer.translateInput(text),
				ClpSerializer.translateInput(value), start, rows,
				ClpSerializer.translateInput(orderByCol),
				ClpSerializer.translateInput(orderByType));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.ssavr.solr.model.IceCream>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addIceCreamMethodKey0;
	private MethodKey _createIceCreamMethodKey1;
	private MethodKey _deleteIceCreamMethodKey2;
	private MethodKey _deleteIceCreamMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _getIceCreamMethodKey8;
	private MethodKey _getPersistedModelMethodKey9;
	private MethodKey _getIceCreamsMethodKey10;
	private MethodKey _getIceCreamsCountMethodKey11;
	private MethodKey _updateIceCreamMethodKey12;
	private MethodKey _updateIceCreamMethodKey13;
	private MethodKey _getBeanIdentifierMethodKey14;
	private MethodKey _setBeanIdentifierMethodKey15;
	private MethodKey _addIceCreamMethodKey16;
	private MethodKey _getIceCreamBeanMethodKey17;
	private MethodKey _getAllIceCreamsMethodKey18;
	private MethodKey _getIceCreamsMethodKey19;
	private MethodKey _getIceCreamsFacetsMethodKey20;
	private MethodKey _facetIceCreamsMethodKey21;
	private MethodKey _searchIceCreamsMethodKey22;
	private MethodKey _searchIceCreamsWithEDisMaxMethodKey23;
}