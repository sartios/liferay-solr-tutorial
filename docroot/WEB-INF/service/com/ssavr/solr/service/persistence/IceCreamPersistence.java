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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.BasePersistence;

import com.ssavr.solr.model.IceCream;

/**
 * The persistence interface for the ice cream service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SAVRAMIS
 * @see IceCreamPersistenceImpl
 * @see IceCreamUtil
 * @generated
 */
public interface IceCreamPersistence extends BasePersistence<IceCream> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IceCreamUtil} to access the ice cream persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ice cream in the entity cache if it is enabled.
	*
	* @param iceCream the ice cream to cache
	*/
	public void cacheResult(com.ssavr.solr.model.IceCream iceCream);

	/**
	* Caches the ice creams in the entity cache if it is enabled.
	*
	* @param iceCreams the ice creams to cache
	*/
	public void cacheResult(
		java.util.List<com.ssavr.solr.model.IceCream> iceCreams);

	/**
	* Creates a new ice cream with the primary key. Does not add the ice cream to the database.
	*
	* @param iceCreamId the primary key for the new ice cream
	* @return the new ice cream
	*/
	public com.ssavr.solr.model.IceCream create(long iceCreamId);

	/**
	* Removes the ice cream with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param iceCreamId the primary key of the ice cream to remove
	* @return the ice cream that was removed
	* @throws com.ssavr.solr.NoSuchIceCreamException if a ice cream with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ssavr.solr.model.IceCream remove(long iceCreamId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException;

	public com.ssavr.solr.model.IceCream updateImpl(
		com.ssavr.solr.model.IceCream iceCream, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the ice cream with the primary key or throws a {@link com.ssavr.solr.NoSuchIceCreamException} if it could not be found.
	*
	* @param iceCreamId the primary key of the ice cream to find
	* @return the ice cream
	* @throws com.ssavr.solr.NoSuchIceCreamException if a ice cream with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ssavr.solr.model.IceCream findByPrimaryKey(long iceCreamId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException;

	/**
	* Finds the ice cream with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param iceCreamId the primary key of the ice cream to find
	* @return the ice cream, or <code>null</code> if a ice cream with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ssavr.solr.model.IceCream fetchByPrimaryKey(long iceCreamId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the ice creams where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching ice creams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ssavr.solr.model.IceCream> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ssavr.solr.model.IceCream> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ssavr.solr.model.IceCream> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ssavr.solr.model.IceCream findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException;

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
	public com.ssavr.solr.model.IceCream findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException;

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
	public com.ssavr.solr.model.IceCream[] findByUuid_PrevAndNext(
		long iceCreamId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException;

	/**
	* Finds all the ice creams where flavor = &#63;.
	*
	* @param flavor the flavor to search with
	* @return the matching ice creams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ssavr.solr.model.IceCream> findByFlavor(
		java.lang.String flavor)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ssavr.solr.model.IceCream> findByFlavor(
		java.lang.String flavor, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ssavr.solr.model.IceCream> findByFlavor(
		java.lang.String flavor, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ssavr.solr.model.IceCream findByFlavor_First(
		java.lang.String flavor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException;

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
	public com.ssavr.solr.model.IceCream findByFlavor_Last(
		java.lang.String flavor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException;

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
	public com.ssavr.solr.model.IceCream[] findByFlavor_PrevAndNext(
		long iceCreamId, java.lang.String flavor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException;

	/**
	* Finds the ice cream where name = &#63; or throws a {@link com.ssavr.solr.NoSuchIceCreamException} if it could not be found.
	*
	* @param name the name to search with
	* @return the matching ice cream
	* @throws com.ssavr.solr.NoSuchIceCreamException if a matching ice cream could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ssavr.solr.model.IceCream findByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException;

	/**
	* Finds the ice cream where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name to search with
	* @return the matching ice cream, or <code>null</code> if a matching ice cream could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ssavr.solr.model.IceCream fetchByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the ice cream where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name to search with
	* @return the matching ice cream, or <code>null</code> if a matching ice cream could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ssavr.solr.model.IceCream fetchByName(java.lang.String name,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the ice creams.
	*
	* @return the ice creams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ssavr.solr.model.IceCream> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ssavr.solr.model.IceCream> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ssavr.solr.model.IceCream> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ice creams where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ice creams where flavor = &#63; from the database.
	*
	* @param flavor the flavor to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFlavor(java.lang.String flavor)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the ice cream where name = &#63; from the database.
	*
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamException;

	/**
	* Removes all the ice creams from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the ice creams where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching ice creams
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the ice creams where flavor = &#63;.
	*
	* @param flavor the flavor to search with
	* @return the number of matching ice creams
	* @throws SystemException if a system exception occurred
	*/
	public int countByFlavor(java.lang.String flavor)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the ice creams where name = &#63;.
	*
	* @param name the name to search with
	* @return the number of matching ice creams
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the ice creams.
	*
	* @return the number of ice creams
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public IceCream remove(IceCream iceCream) throws SystemException;
}