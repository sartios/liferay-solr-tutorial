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

import com.ssavr.solr.model.IceCream;

import java.util.List;

/**
 * The persistence utility for the ice cream service. This utility wraps {@link IceCreamPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SAVRAMIS
 * @see IceCreamPersistence
 * @see IceCreamPersistenceImpl
 * @generated
 */
public class IceCreamUtil {
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
	public static void clearCache(IceCream iceCream) {
		getPersistence().clearCache(iceCream);
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
	public static List<IceCream> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<IceCream> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<IceCream> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static IceCream remove(IceCream iceCream) throws SystemException {
		return getPersistence().remove(iceCream);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static IceCream update(IceCream iceCream, boolean merge)
		throws SystemException {
		return getPersistence().update(iceCream, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static IceCream update(IceCream iceCream, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(iceCream, merge, serviceContext);
	}

	/**
	* Caches the ice cream in the entity cache if it is enabled.
	*
	* @param iceCream the ice cream to cache
	*/
	public static void cacheResult(com.ssavr.solr.model.IceCream iceCream) {
		getPersistence().cacheResult(iceCream);
	}

	/**
	* Caches the ice creams in the entity cache if it is enabled.
	*
	* @param iceCreams the ice creams to cache
	*/
	public static void cacheResult(
		java.util.List<com.ssavr.solr.model.IceCream> iceCreams) {
		getPersistence().cacheResult(iceCreams);
	}

	/**
	* Creates a new ice cream with the primary key. Does not add the ice cream to the database.
	*
	* @param iceCreamId the primary key for the new ice cream
	* @return the new ice cream
	*/
	public static com.ssavr.solr.model.IceCream create(long iceCreamId) {
		return getPersistence().create(iceCreamId);
	}

	/**
	* Removes the ice cream with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param iceCreamId the primary key of the ice cream to remove
	* @return the ice cream that was removed
	* @throws com.ssavr.solr.NoSuchIceCreamException if a ice cream with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCream remove(long iceCreamId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException {
		return getPersistence().remove(iceCreamId);
	}

	public static com.ssavr.solr.model.IceCream updateImpl(
		com.ssavr.solr.model.IceCream iceCream, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(iceCream, merge);
	}

	/**
	* Finds the ice cream with the primary key or throws a {@link com.ssavr.solr.NoSuchIceCreamException} if it could not be found.
	*
	* @param iceCreamId the primary key of the ice cream to find
	* @return the ice cream
	* @throws com.ssavr.solr.NoSuchIceCreamException if a ice cream with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCream findByPrimaryKey(
		long iceCreamId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException {
		return getPersistence().findByPrimaryKey(iceCreamId);
	}

	/**
	* Finds the ice cream with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param iceCreamId the primary key of the ice cream to find
	* @return the ice cream, or <code>null</code> if a ice cream with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCream fetchByPrimaryKey(
		long iceCreamId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(iceCreamId);
	}

	/**
	* Finds all the ice creams where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching ice creams
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ssavr.solr.model.IceCream> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Finds a range of all the ice creams where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of ice creams to return
	* @param end the upper bound of the range of ice creams to return (not inclusive)
	* @return the range of matching ice creams
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ssavr.solr.model.IceCream> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Finds an ordered range of all the ice creams where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param start the lower bound of the range of ice creams to return
	* @param end the upper bound of the range of ice creams to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching ice creams
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ssavr.solr.model.IceCream> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Finds the first ice cream in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching ice cream
	* @throws com.ssavr.solr.NoSuchIceCreamException if a matching ice cream could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCream findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Finds the last ice cream in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching ice cream
	* @throws com.ssavr.solr.NoSuchIceCreamException if a matching ice cream could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCream findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Finds the ice creams before and after the current ice cream in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param iceCreamId the primary key of the current ice cream
	* @param uuid the uuid to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next ice cream
	* @throws com.ssavr.solr.NoSuchIceCreamException if a ice cream with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCream[] findByUuid_PrevAndNext(
		long iceCreamId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException {
		return getPersistence()
				   .findByUuid_PrevAndNext(iceCreamId, uuid, orderByComparator);
	}

	/**
	* Finds all the ice creams where flavor = &#63;.
	*
	* @param flavor the flavor to search with
	* @return the matching ice creams
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ssavr.solr.model.IceCream> findByFlavor(
		java.lang.String flavor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFlavor(flavor);
	}

	/**
	* Finds a range of all the ice creams where flavor = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param flavor the flavor to search with
	* @param start the lower bound of the range of ice creams to return
	* @param end the upper bound of the range of ice creams to return (not inclusive)
	* @return the range of matching ice creams
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ssavr.solr.model.IceCream> findByFlavor(
		java.lang.String flavor, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFlavor(flavor, start, end);
	}

	/**
	* Finds an ordered range of all the ice creams where flavor = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param flavor the flavor to search with
	* @param start the lower bound of the range of ice creams to return
	* @param end the upper bound of the range of ice creams to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching ice creams
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ssavr.solr.model.IceCream> findByFlavor(
		java.lang.String flavor, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFlavor(flavor, start, end, orderByComparator);
	}

	/**
	* Finds the first ice cream in the ordered set where flavor = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param flavor the flavor to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching ice cream
	* @throws com.ssavr.solr.NoSuchIceCreamException if a matching ice cream could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCream findByFlavor_First(
		java.lang.String flavor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException {
		return getPersistence().findByFlavor_First(flavor, orderByComparator);
	}

	/**
	* Finds the last ice cream in the ordered set where flavor = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param flavor the flavor to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching ice cream
	* @throws com.ssavr.solr.NoSuchIceCreamException if a matching ice cream could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCream findByFlavor_Last(
		java.lang.String flavor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException {
		return getPersistence().findByFlavor_Last(flavor, orderByComparator);
	}

	/**
	* Finds the ice creams before and after the current ice cream in the ordered set where flavor = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param iceCreamId the primary key of the current ice cream
	* @param flavor the flavor to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next ice cream
	* @throws com.ssavr.solr.NoSuchIceCreamException if a ice cream with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCream[] findByFlavor_PrevAndNext(
		long iceCreamId, java.lang.String flavor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException {
		return getPersistence()
				   .findByFlavor_PrevAndNext(iceCreamId, flavor,
			orderByComparator);
	}

	/**
	* Finds the ice cream where name = &#63; or throws a {@link com.ssavr.solr.NoSuchIceCreamException} if it could not be found.
	*
	* @param name the name to search with
	* @return the matching ice cream
	* @throws com.ssavr.solr.NoSuchIceCreamException if a matching ice cream could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCream findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException {
		return getPersistence().findByName(name);
	}

	/**
	* Finds the ice cream where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name to search with
	* @return the matching ice cream, or <code>null</code> if a matching ice cream could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCream fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name);
	}

	/**
	* Finds the ice cream where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name to search with
	* @return the matching ice cream, or <code>null</code> if a matching ice cream could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ssavr.solr.model.IceCream fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Finds all the ice creams.
	*
	* @return the ice creams
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ssavr.solr.model.IceCream> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the ice creams.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ice creams to return
	* @param end the upper bound of the range of ice creams to return (not inclusive)
	* @return the range of ice creams
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ssavr.solr.model.IceCream> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the ice creams.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ice creams to return
	* @param end the upper bound of the range of ice creams to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of ice creams
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ssavr.solr.model.IceCream> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ice creams where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Removes all the ice creams where flavor = &#63; from the database.
	*
	* @param flavor the flavor to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFlavor(java.lang.String flavor)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFlavor(flavor);
	}

	/**
	* Removes the ice cream where name = &#63; from the database.
	*
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException {
		getPersistence().removeByName(name);
	}

	/**
	* Removes all the ice creams from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the ice creams where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching ice creams
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Counts all the ice creams where flavor = &#63;.
	*
	* @param flavor the flavor to search with
	* @return the number of matching ice creams
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFlavor(java.lang.String flavor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFlavor(flavor);
	}

	/**
	* Counts all the ice creams where name = &#63;.
	*
	* @param name the name to search with
	* @return the number of matching ice creams
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Counts all the ice creams.
	*
	* @return the number of ice creams
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static IceCreamPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (IceCreamPersistence)PortletBeanLocatorUtil.locate(com.ssavr.solr.service.ClpSerializer.getServletContextName(),
					IceCreamPersistence.class.getName());

			ReferenceRegistry.registerReference(IceCreamUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(IceCreamPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(IceCreamUtil.class, "_persistence");
	}

	private static IceCreamPersistence _persistence;
}