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

package com.ssavr.solr.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.ssavr.solr.model.IceCreamDocuments;

import java.util.List;

/**
 * The persistence utility for the ice cream documents service. This utility wraps {@link IceCreamDocumentsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SAVRAMIS
 * @see IceCreamDocumentsPersistence
 * @see IceCreamDocumentsPersistenceImpl
 * @generated
 */
public class IceCreamDocumentsUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(IceCreamDocuments iceCreamDocuments) {
		getPersistence().clearCache(iceCreamDocuments);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<IceCreamDocuments> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<IceCreamDocuments> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<IceCreamDocuments> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static IceCreamDocuments remove(IceCreamDocuments iceCreamDocuments)
		throws SystemException {
		return getPersistence().remove(iceCreamDocuments);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static IceCreamDocuments update(
		IceCreamDocuments iceCreamDocuments, boolean merge)
		throws SystemException {
		return getPersistence().update(iceCreamDocuments, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static IceCreamDocuments update(
		IceCreamDocuments iceCreamDocuments, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(iceCreamDocuments, merge, serviceContext);
	}

	/**
	* Caches the ice cream documents in the entity cache if it is enabled.
	*
	* @param iceCreamDocuments the ice cream documents to cache
	*/
	public static void cacheResult(
		com.ssavr.solr.model.IceCreamDocuments iceCreamDocuments) {
		getPersistence().cacheResult(iceCreamDocuments);
	}

	/**
	* Caches the ice cream documentses in the entity cache if it is enabled.
	*
	* @param iceCreamDocumentses the ice cream documentses to cache
	*/
	public static void cacheResult(
		java.util.List<com.ssavr.solr.model.IceCreamDocuments> iceCreamDocumentses) {
		getPersistence().cacheResult(iceCreamDocumentses);
	}

	/**
	* Creates a new ice cream documents with the primary key. Does not add the ice cream documents to the database.
	*
	* @param iceCreamDocumentsId the primary key for the new ice cream documents
	* @return the new ice cream documents
	*/
	public static com.ssavr.solr.model.IceCreamDocuments create(
		long iceCreamDocumentsId) {
		return getPersistence().create(iceCreamDocumentsId);
	}

	/**
	* Removes the ice cream documents with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param iceCreamDocumentsId the primary key of the ice cream documents to remove
	* @return the ice cream documents that was removed
	* @throws com.ssavr.solr.NoSuchIceCreamDocumentsException if a ice cream documents with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCreamDocuments remove(
		long iceCreamDocumentsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamDocumentsException {
		return getPersistence().remove(iceCreamDocumentsId);
	}

	public static com.ssavr.solr.model.IceCreamDocuments updateImpl(
		com.ssavr.solr.model.IceCreamDocuments iceCreamDocuments, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(iceCreamDocuments, merge);
	}

	/**
	* Finds the ice cream documents with the primary key or throws a {@link com.ssavr.solr.NoSuchIceCreamDocumentsException} if it could not be found.
	*
	* @param iceCreamDocumentsId the primary key of the ice cream documents to find
	* @return the ice cream documents
	* @throws com.ssavr.solr.NoSuchIceCreamDocumentsException if a ice cream documents with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCreamDocuments findByPrimaryKey(
		long iceCreamDocumentsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamDocumentsException {
		return getPersistence().findByPrimaryKey(iceCreamDocumentsId);
	}

	/**
	* Finds the ice cream documents with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param iceCreamDocumentsId the primary key of the ice cream documents to find
	* @return the ice cream documents, or <code>null</code> if a ice cream documents with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCreamDocuments fetchByPrimaryKey(
		long iceCreamDocumentsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(iceCreamDocumentsId);
	}

	/**
	* Finds all the ice cream documentses where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching ice cream documentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ssavr.solr.model.IceCreamDocuments> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Finds a range of all the ice cream documentses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of ice cream documentses to return
	* @param end the upper bound of the range of ice cream documentses to return (not inclusive)
	* @return the range of matching ice cream documentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ssavr.solr.model.IceCreamDocuments> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Finds an ordered range of all the ice cream documentses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of ice cream documentses to return
	* @param end the upper bound of the range of ice cream documentses to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching ice cream documentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ssavr.solr.model.IceCreamDocuments> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Finds the first ice cream documents in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching ice cream documents
	* @throws com.ssavr.solr.NoSuchIceCreamDocumentsException if a matching ice cream documents could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCreamDocuments findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamDocumentsException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Finds the last ice cream documents in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching ice cream documents
	* @throws com.ssavr.solr.NoSuchIceCreamDocumentsException if a matching ice cream documents could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCreamDocuments findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamDocumentsException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Finds the ice cream documentses before and after the current ice cream documents in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param iceCreamDocumentsId the primary key of the current ice cream documents
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next ice cream documents
	* @throws com.ssavr.solr.NoSuchIceCreamDocumentsException if a ice cream documents with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCreamDocuments[] findByUuid_PrevAndNext(
		long iceCreamDocumentsId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamDocumentsException {
		return getPersistence()
				   .findByUuid_PrevAndNext(iceCreamDocumentsId, uuid,
			orderByComparator);
	}

	/**
	* Finds all the ice cream documentses where iceCreamId = &#63;.
	*
	* @param iceCreamId the ice cream ID to search with
	* @return the matching ice cream documentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ssavr.solr.model.IceCreamDocuments> findByIceCreamId(
		long iceCreamId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIceCreamId(iceCreamId);
	}

	/**
	* Finds a range of all the ice cream documentses where iceCreamId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param iceCreamId the ice cream ID to search with
	* @param start the lower bound of the range of ice cream documentses to return
	* @param end the upper bound of the range of ice cream documentses to return (not inclusive)
	* @return the range of matching ice cream documentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ssavr.solr.model.IceCreamDocuments> findByIceCreamId(
		long iceCreamId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIceCreamId(iceCreamId, start, end);
	}

	/**
	* Finds an ordered range of all the ice cream documentses where iceCreamId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param iceCreamId the ice cream ID to search with
	* @param start the lower bound of the range of ice cream documentses to return
	* @param end the upper bound of the range of ice cream documentses to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching ice cream documentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ssavr.solr.model.IceCreamDocuments> findByIceCreamId(
		long iceCreamId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIceCreamId(iceCreamId, start, end, orderByComparator);
	}

	/**
	* Finds the first ice cream documents in the ordered set where iceCreamId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param iceCreamId the ice cream ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching ice cream documents
	* @throws com.ssavr.solr.NoSuchIceCreamDocumentsException if a matching ice cream documents could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCreamDocuments findByIceCreamId_First(
		long iceCreamId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamDocumentsException {
		return getPersistence()
				   .findByIceCreamId_First(iceCreamId, orderByComparator);
	}

	/**
	* Finds the last ice cream documents in the ordered set where iceCreamId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param iceCreamId the ice cream ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching ice cream documents
	* @throws com.ssavr.solr.NoSuchIceCreamDocumentsException if a matching ice cream documents could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCreamDocuments findByIceCreamId_Last(
		long iceCreamId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamDocumentsException {
		return getPersistence()
				   .findByIceCreamId_Last(iceCreamId, orderByComparator);
	}

	/**
	* Finds the ice cream documentses before and after the current ice cream documents in the ordered set where iceCreamId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param iceCreamDocumentsId the primary key of the current ice cream documents
	* @param iceCreamId the ice cream ID to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next ice cream documents
	* @throws com.ssavr.solr.NoSuchIceCreamDocumentsException if a ice cream documents with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCreamDocuments[] findByIceCreamId_PrevAndNext(
		long iceCreamDocumentsId, long iceCreamId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamDocumentsException {
		return getPersistence()
				   .findByIceCreamId_PrevAndNext(iceCreamDocumentsId,
			iceCreamId, orderByComparator);
	}

	/**
	* Finds all the ice cream documentses.
	*
	* @return the ice cream documentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ssavr.solr.model.IceCreamDocuments> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the ice cream documentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ice cream documentses to return
	* @param end the upper bound of the range of ice cream documentses to return (not inclusive)
	* @return the range of ice cream documentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ssavr.solr.model.IceCreamDocuments> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the ice cream documentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ice cream documentses to return
	* @param end the upper bound of the range of ice cream documentses to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of ice cream documentses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ssavr.solr.model.IceCreamDocuments> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ice cream documentses where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Removes all the ice cream documentses where iceCreamId = &#63; from the database.
	*
	* @param iceCreamId the ice cream ID to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIceCreamId(long iceCreamId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIceCreamId(iceCreamId);
	}

	/**
	* Removes all the ice cream documentses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the ice cream documentses where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching ice cream documentses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Counts all the ice cream documentses where iceCreamId = &#63;.
	*
	* @param iceCreamId the ice cream ID to search with
	* @return the number of matching ice cream documentses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIceCreamId(long iceCreamId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIceCreamId(iceCreamId);
	}

	/**
	* Counts all the ice cream documentses.
	*
	* @return the number of ice cream documentses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static IceCreamDocumentsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (IceCreamDocumentsPersistence)PortletBeanLocatorUtil.locate(com.ssavr.solr.service.ClpSerializer.getServletContextName(),
					IceCreamDocumentsPersistence.class.getName());

			ReferenceRegistry.registerReference(IceCreamDocumentsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(IceCreamDocumentsPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(IceCreamDocumentsUtil.class,
			"_persistence");
	}

	private static IceCreamDocumentsPersistence _persistence;
}