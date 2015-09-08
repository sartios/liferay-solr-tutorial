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

import com.ssavr.solr.model.IceCreamDocuments;

/**
 * The persistence interface for the ice cream documents service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SAVRAMIS
 * @see IceCreamDocumentsPersistenceImpl
 * @see IceCreamDocumentsUtil
 * @generated
 */
public interface IceCreamDocumentsPersistence extends BasePersistence<IceCreamDocuments> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IceCreamDocumentsUtil} to access the ice cream documents persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ice cream documents in the entity cache if it is enabled.
	*
	* @param iceCreamDocuments the ice cream documents to cache
	*/
	public void cacheResult(
		com.ssavr.solr.model.IceCreamDocuments iceCreamDocuments);

	/**
	* Caches the ice cream documentses in the entity cache if it is enabled.
	*
	* @param iceCreamDocumentses the ice cream documentses to cache
	*/
	public void cacheResult(
		java.util.List<com.ssavr.solr.model.IceCreamDocuments> iceCreamDocumentses);

	/**
	* Creates a new ice cream documents with the primary key. Does not add the ice cream documents to the database.
	*
	* @param iceCreamDocumentsId the primary key for the new ice cream documents
	* @return the new ice cream documents
	*/
	public com.ssavr.solr.model.IceCreamDocuments create(
		long iceCreamDocumentsId);

	/**
	* Removes the ice cream documents with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param iceCreamDocumentsId the primary key of the ice cream documents to remove
	* @return the ice cream documents that was removed
	* @throws com.ssavr.solr.NoSuchIceCreamDocumentsException if a ice cream documents with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ssavr.solr.model.IceCreamDocuments remove(
		long iceCreamDocumentsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamDocumentsException;

	public com.ssavr.solr.model.IceCreamDocuments updateImpl(
		com.ssavr.solr.model.IceCreamDocuments iceCreamDocuments, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the ice cream documents with the primary key or throws a {@link com.ssavr.solr.NoSuchIceCreamDocumentsException} if it could not be found.
	*
	* @param iceCreamDocumentsId the primary key of the ice cream documents to find
	* @return the ice cream documents
	* @throws com.ssavr.solr.NoSuchIceCreamDocumentsException if a ice cream documents with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ssavr.solr.model.IceCreamDocuments findByPrimaryKey(
		long iceCreamDocumentsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamDocumentsException;

	/**
	* Finds the ice cream documents with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param iceCreamDocumentsId the primary key of the ice cream documents to find
	* @return the ice cream documents, or <code>null</code> if a ice cream documents with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ssavr.solr.model.IceCreamDocuments fetchByPrimaryKey(
		long iceCreamDocumentsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the ice cream documentses where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the matching ice cream documentses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ssavr.solr.model.IceCreamDocuments> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ssavr.solr.model.IceCreamDocuments> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ssavr.solr.model.IceCreamDocuments> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ssavr.solr.model.IceCreamDocuments findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamDocumentsException;

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
	public com.ssavr.solr.model.IceCreamDocuments findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamDocumentsException;

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
	public com.ssavr.solr.model.IceCreamDocuments[] findByUuid_PrevAndNext(
		long iceCreamDocumentsId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamDocumentsException;

	/**
	* Finds all the ice cream documentses where iceCreamId = &#63;.
	*
	* @param iceCreamId the ice cream ID to search with
	* @return the matching ice cream documentses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ssavr.solr.model.IceCreamDocuments> findByIceCreamId(
		long iceCreamId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ssavr.solr.model.IceCreamDocuments> findByIceCreamId(
		long iceCreamId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ssavr.solr.model.IceCreamDocuments> findByIceCreamId(
		long iceCreamId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ssavr.solr.model.IceCreamDocuments findByIceCreamId_First(
		long iceCreamId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamDocumentsException;

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
	public com.ssavr.solr.model.IceCreamDocuments findByIceCreamId_Last(
		long iceCreamId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamDocumentsException;

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
	public com.ssavr.solr.model.IceCreamDocuments[] findByIceCreamId_PrevAndNext(
		long iceCreamDocumentsId, long iceCreamId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.ssavr.solr.NoSuchIceCreamDocumentsException;

	/**
	* Finds all the ice cream documentses.
	*
	* @return the ice cream documentses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ssavr.solr.model.IceCreamDocuments> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ssavr.solr.model.IceCreamDocuments> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ssavr.solr.model.IceCreamDocuments> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ice cream documentses where uuid = &#63; from the database.
	*
	* @param uuid the uuid to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ice cream documentses where iceCreamId = &#63; from the database.
	*
	* @param iceCreamId the ice cream ID to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIceCreamId(long iceCreamId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ice cream documentses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the ice cream documentses where uuid = &#63;.
	*
	* @param uuid the uuid to search with
	* @return the number of matching ice cream documentses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the ice cream documentses where iceCreamId = &#63;.
	*
	* @param iceCreamId the ice cream ID to search with
	* @return the number of matching ice cream documentses
	* @throws SystemException if a system exception occurred
	*/
	public int countByIceCreamId(long iceCreamId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the ice cream documentses.
	*
	* @return the number of ice cream documentses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public IceCreamDocuments remove(IceCreamDocuments iceCreamDocuments)
		throws SystemException;
}