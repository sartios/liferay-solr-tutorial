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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.documentlibrary.service.persistence.DLFileEntryPersistence;

import com.ssavr.solr.NoSuchIceCreamDocumentsException;
import com.ssavr.solr.model.IceCreamDocuments;
import com.ssavr.solr.model.impl.IceCreamDocumentsImpl;
import com.ssavr.solr.model.impl.IceCreamDocumentsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ice cream documents service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SAVRAMIS
 * @see IceCreamDocumentsPersistence
 * @see IceCreamDocumentsUtil
 * @generated
 */
public class IceCreamDocumentsPersistenceImpl extends BasePersistenceImpl<IceCreamDocuments>
	implements IceCreamDocumentsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link IceCreamDocumentsUtil} to access the ice cream documents persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = IceCreamDocumentsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(IceCreamDocumentsModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamDocumentsModelImpl.FINDER_CACHE_ENABLED,
			IceCreamDocumentsImpl.class, FINDER_CLASS_NAME_LIST, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(IceCreamDocumentsModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamDocumentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ICECREAMID = new FinderPath(IceCreamDocumentsModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamDocumentsModelImpl.FINDER_CACHE_ENABLED,
			IceCreamDocumentsImpl.class, FINDER_CLASS_NAME_LIST,
			"findByIceCreamId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ICECREAMID = new FinderPath(IceCreamDocumentsModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamDocumentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByIceCreamId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(IceCreamDocumentsModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamDocumentsModelImpl.FINDER_CACHE_ENABLED,
			IceCreamDocumentsImpl.class, FINDER_CLASS_NAME_LIST, "findAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IceCreamDocumentsModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamDocumentsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the ice cream documents in the entity cache if it is enabled.
	 *
	 * @param iceCreamDocuments the ice cream documents to cache
	 */
	public void cacheResult(IceCreamDocuments iceCreamDocuments) {
		EntityCacheUtil.putResult(IceCreamDocumentsModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamDocumentsImpl.class, iceCreamDocuments.getPrimaryKey(),
			iceCreamDocuments);

		iceCreamDocuments.resetOriginalValues();
	}

	/**
	 * Caches the ice cream documentses in the entity cache if it is enabled.
	 *
	 * @param iceCreamDocumentses the ice cream documentses to cache
	 */
	public void cacheResult(List<IceCreamDocuments> iceCreamDocumentses) {
		for (IceCreamDocuments iceCreamDocuments : iceCreamDocumentses) {
			if (EntityCacheUtil.getResult(
						IceCreamDocumentsModelImpl.ENTITY_CACHE_ENABLED,
						IceCreamDocumentsImpl.class,
						iceCreamDocuments.getPrimaryKey(), this) == null) {
				cacheResult(iceCreamDocuments);
			}
		}
	}

	/**
	 * Clears the cache for all ice cream documentses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(IceCreamDocumentsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(IceCreamDocumentsImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the ice cream documents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(IceCreamDocuments iceCreamDocuments) {
		EntityCacheUtil.removeResult(IceCreamDocumentsModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamDocumentsImpl.class, iceCreamDocuments.getPrimaryKey());
	}

	/**
	 * Creates a new ice cream documents with the primary key. Does not add the ice cream documents to the database.
	 *
	 * @param iceCreamDocumentsId the primary key for the new ice cream documents
	 * @return the new ice cream documents
	 */
	public IceCreamDocuments create(long iceCreamDocumentsId) {
		IceCreamDocuments iceCreamDocuments = new IceCreamDocumentsImpl();

		iceCreamDocuments.setNew(true);
		iceCreamDocuments.setPrimaryKey(iceCreamDocumentsId);

		String uuid = PortalUUIDUtil.generate();

		iceCreamDocuments.setUuid(uuid);

		return iceCreamDocuments;
	}

	/**
	 * Removes the ice cream documents with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ice cream documents to remove
	 * @return the ice cream documents that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a ice cream documents with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IceCreamDocuments remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the ice cream documents with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param iceCreamDocumentsId the primary key of the ice cream documents to remove
	 * @return the ice cream documents that was removed
	 * @throws com.ssavr.solr.NoSuchIceCreamDocumentsException if a ice cream documents with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public IceCreamDocuments remove(long iceCreamDocumentsId)
		throws NoSuchIceCreamDocumentsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			IceCreamDocuments iceCreamDocuments = (IceCreamDocuments)session.get(IceCreamDocumentsImpl.class,
					Long.valueOf(iceCreamDocumentsId));

			if (iceCreamDocuments == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
						iceCreamDocumentsId);
				}

				throw new NoSuchIceCreamDocumentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					iceCreamDocumentsId);
			}

			return iceCreamDocumentsPersistence.remove(iceCreamDocuments);
		}
		catch (NoSuchIceCreamDocumentsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Removes the ice cream documents from the database. Also notifies the appropriate model listeners.
	 *
	 * @param iceCreamDocuments the ice cream documents to remove
	 * @return the ice cream documents that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IceCreamDocuments remove(IceCreamDocuments iceCreamDocuments)
		throws SystemException {
		return super.remove(iceCreamDocuments);
	}

	@Override
	protected IceCreamDocuments removeImpl(IceCreamDocuments iceCreamDocuments)
		throws SystemException {
		iceCreamDocuments = toUnwrappedModel(iceCreamDocuments);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, iceCreamDocuments);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(IceCreamDocumentsModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamDocumentsImpl.class, iceCreamDocuments.getPrimaryKey());

		return iceCreamDocuments;
	}

	@Override
	public IceCreamDocuments updateImpl(
		com.ssavr.solr.model.IceCreamDocuments iceCreamDocuments, boolean merge)
		throws SystemException {
		iceCreamDocuments = toUnwrappedModel(iceCreamDocuments);

		if (Validator.isNull(iceCreamDocuments.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			iceCreamDocuments.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, iceCreamDocuments, merge);

			iceCreamDocuments.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(IceCreamDocumentsModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamDocumentsImpl.class, iceCreamDocuments.getPrimaryKey(),
			iceCreamDocuments);

		return iceCreamDocuments;
	}

	protected IceCreamDocuments toUnwrappedModel(
		IceCreamDocuments iceCreamDocuments) {
		if (iceCreamDocuments instanceof IceCreamDocumentsImpl) {
			return iceCreamDocuments;
		}

		IceCreamDocumentsImpl iceCreamDocumentsImpl = new IceCreamDocumentsImpl();

		iceCreamDocumentsImpl.setNew(iceCreamDocuments.isNew());
		iceCreamDocumentsImpl.setPrimaryKey(iceCreamDocuments.getPrimaryKey());

		iceCreamDocumentsImpl.setUuid(iceCreamDocuments.getUuid());
		iceCreamDocumentsImpl.setIceCreamDocumentsId(iceCreamDocuments.getIceCreamDocumentsId());
		iceCreamDocumentsImpl.setCompanyId(iceCreamDocuments.getCompanyId());
		iceCreamDocumentsImpl.setUserId(iceCreamDocuments.getUserId());
		iceCreamDocumentsImpl.setCreateDate(iceCreamDocuments.getCreateDate());
		iceCreamDocumentsImpl.setModifiedDate(iceCreamDocuments.getModifiedDate());
		iceCreamDocumentsImpl.setDocumentId(iceCreamDocuments.getDocumentId());
		iceCreamDocumentsImpl.setIceCreamId(iceCreamDocuments.getIceCreamId());

		return iceCreamDocumentsImpl;
	}

	/**
	 * Finds the ice cream documents with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ice cream documents to find
	 * @return the ice cream documents
	 * @throws com.liferay.portal.NoSuchModelException if a ice cream documents with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IceCreamDocuments findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the ice cream documents with the primary key or throws a {@link com.ssavr.solr.NoSuchIceCreamDocumentsException} if it could not be found.
	 *
	 * @param iceCreamDocumentsId the primary key of the ice cream documents to find
	 * @return the ice cream documents
	 * @throws com.ssavr.solr.NoSuchIceCreamDocumentsException if a ice cream documents with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public IceCreamDocuments findByPrimaryKey(long iceCreamDocumentsId)
		throws NoSuchIceCreamDocumentsException, SystemException {
		IceCreamDocuments iceCreamDocuments = fetchByPrimaryKey(iceCreamDocumentsId);

		if (iceCreamDocuments == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					iceCreamDocumentsId);
			}

			throw new NoSuchIceCreamDocumentsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				iceCreamDocumentsId);
		}

		return iceCreamDocuments;
	}

	/**
	 * Finds the ice cream documents with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ice cream documents to find
	 * @return the ice cream documents, or <code>null</code> if a ice cream documents with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IceCreamDocuments fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the ice cream documents with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param iceCreamDocumentsId the primary key of the ice cream documents to find
	 * @return the ice cream documents, or <code>null</code> if a ice cream documents with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public IceCreamDocuments fetchByPrimaryKey(long iceCreamDocumentsId)
		throws SystemException {
		IceCreamDocuments iceCreamDocuments = (IceCreamDocuments)EntityCacheUtil.getResult(IceCreamDocumentsModelImpl.ENTITY_CACHE_ENABLED,
				IceCreamDocumentsImpl.class, iceCreamDocumentsId, this);

		if (iceCreamDocuments == _nullIceCreamDocuments) {
			return null;
		}

		if (iceCreamDocuments == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				iceCreamDocuments = (IceCreamDocuments)session.get(IceCreamDocumentsImpl.class,
						Long.valueOf(iceCreamDocumentsId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (iceCreamDocuments != null) {
					cacheResult(iceCreamDocuments);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(IceCreamDocumentsModelImpl.ENTITY_CACHE_ENABLED,
						IceCreamDocumentsImpl.class, iceCreamDocumentsId,
						_nullIceCreamDocuments);
				}

				closeSession(session);
			}
		}

		return iceCreamDocuments;
	}

	/**
	 * Finds all the ice cream documentses where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the matching ice cream documentses
	 * @throws SystemException if a system exception occurred
	 */
	public List<IceCreamDocuments> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<IceCreamDocuments> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
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
	public List<IceCreamDocuments> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				uuid,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<IceCreamDocuments> list = (List<IceCreamDocuments>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_ICECREAMDOCUMENTS_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<IceCreamDocuments>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UUID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public IceCreamDocuments findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchIceCreamDocumentsException, SystemException {
		List<IceCreamDocuments> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchIceCreamDocumentsException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public IceCreamDocuments findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchIceCreamDocumentsException, SystemException {
		int count = countByUuid(uuid);

		List<IceCreamDocuments> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchIceCreamDocumentsException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public IceCreamDocuments[] findByUuid_PrevAndNext(
		long iceCreamDocumentsId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchIceCreamDocumentsException, SystemException {
		IceCreamDocuments iceCreamDocuments = findByPrimaryKey(iceCreamDocumentsId);

		Session session = null;

		try {
			session = openSession();

			IceCreamDocuments[] array = new IceCreamDocumentsImpl[3];

			array[0] = getByUuid_PrevAndNext(session, iceCreamDocuments, uuid,
					orderByComparator, true);

			array[1] = iceCreamDocuments;

			array[2] = getByUuid_PrevAndNext(session, iceCreamDocuments, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IceCreamDocuments getByUuid_PrevAndNext(Session session,
		IceCreamDocuments iceCreamDocuments, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ICECREAMDOCUMENTS_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(iceCreamDocuments);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IceCreamDocuments> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the ice cream documentses where iceCreamId = &#63;.
	 *
	 * @param iceCreamId the ice cream ID to search with
	 * @return the matching ice cream documentses
	 * @throws SystemException if a system exception occurred
	 */
	public List<IceCreamDocuments> findByIceCreamId(long iceCreamId)
		throws SystemException {
		return findByIceCreamId(iceCreamId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<IceCreamDocuments> findByIceCreamId(long iceCreamId, int start,
		int end) throws SystemException {
		return findByIceCreamId(iceCreamId, start, end, null);
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
	public List<IceCreamDocuments> findByIceCreamId(long iceCreamId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				iceCreamId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<IceCreamDocuments> list = (List<IceCreamDocuments>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ICECREAMID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_ICECREAMDOCUMENTS_WHERE);

			query.append(_FINDER_COLUMN_ICECREAMID_ICECREAMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(iceCreamId);

				list = (List<IceCreamDocuments>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_ICECREAMID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ICECREAMID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public IceCreamDocuments findByIceCreamId_First(long iceCreamId,
		OrderByComparator orderByComparator)
		throws NoSuchIceCreamDocumentsException, SystemException {
		List<IceCreamDocuments> list = findByIceCreamId(iceCreamId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("iceCreamId=");
			msg.append(iceCreamId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchIceCreamDocumentsException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public IceCreamDocuments findByIceCreamId_Last(long iceCreamId,
		OrderByComparator orderByComparator)
		throws NoSuchIceCreamDocumentsException, SystemException {
		int count = countByIceCreamId(iceCreamId);

		List<IceCreamDocuments> list = findByIceCreamId(iceCreamId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("iceCreamId=");
			msg.append(iceCreamId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchIceCreamDocumentsException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public IceCreamDocuments[] findByIceCreamId_PrevAndNext(
		long iceCreamDocumentsId, long iceCreamId,
		OrderByComparator orderByComparator)
		throws NoSuchIceCreamDocumentsException, SystemException {
		IceCreamDocuments iceCreamDocuments = findByPrimaryKey(iceCreamDocumentsId);

		Session session = null;

		try {
			session = openSession();

			IceCreamDocuments[] array = new IceCreamDocumentsImpl[3];

			array[0] = getByIceCreamId_PrevAndNext(session, iceCreamDocuments,
					iceCreamId, orderByComparator, true);

			array[1] = iceCreamDocuments;

			array[2] = getByIceCreamId_PrevAndNext(session, iceCreamDocuments,
					iceCreamId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected IceCreamDocuments getByIceCreamId_PrevAndNext(Session session,
		IceCreamDocuments iceCreamDocuments, long iceCreamId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ICECREAMDOCUMENTS_WHERE);

		query.append(_FINDER_COLUMN_ICECREAMID_ICECREAMID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(iceCreamId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(iceCreamDocuments);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IceCreamDocuments> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the ice cream documentses.
	 *
	 * @return the ice cream documentses
	 * @throws SystemException if a system exception occurred
	 */
	public List<IceCreamDocuments> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<IceCreamDocuments> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<IceCreamDocuments> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<IceCreamDocuments> list = (List<IceCreamDocuments>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ICECREAMDOCUMENTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ICECREAMDOCUMENTS;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<IceCreamDocuments>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<IceCreamDocuments>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the ice cream documentses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (IceCreamDocuments iceCreamDocuments : findByUuid(uuid)) {
			iceCreamDocumentsPersistence.remove(iceCreamDocuments);
		}
	}

	/**
	 * Removes all the ice cream documentses where iceCreamId = &#63; from the database.
	 *
	 * @param iceCreamId the ice cream ID to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByIceCreamId(long iceCreamId) throws SystemException {
		for (IceCreamDocuments iceCreamDocuments : findByIceCreamId(iceCreamId)) {
			iceCreamDocumentsPersistence.remove(iceCreamDocuments);
		}
	}

	/**
	 * Removes all the ice cream documentses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (IceCreamDocuments iceCreamDocuments : findAll()) {
			iceCreamDocumentsPersistence.remove(iceCreamDocuments);
		}
	}

	/**
	 * Counts all the ice cream documentses where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the number of matching ice cream documentses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ICECREAMDOCUMENTS_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the ice cream documentses where iceCreamId = &#63;.
	 *
	 * @param iceCreamId the ice cream ID to search with
	 * @return the number of matching ice cream documentses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByIceCreamId(long iceCreamId) throws SystemException {
		Object[] finderArgs = new Object[] { iceCreamId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ICECREAMID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ICECREAMDOCUMENTS_WHERE);

			query.append(_FINDER_COLUMN_ICECREAMID_ICECREAMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(iceCreamId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ICECREAMID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the ice cream documentses.
	 *
	 * @return the number of ice cream documentses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ICECREAMDOCUMENTS);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the ice cream documents persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ssavr.solr.model.IceCreamDocuments")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<IceCreamDocuments>> listenersList = new ArrayList<ModelListener<IceCreamDocuments>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<IceCreamDocuments>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(IceCreamDocumentsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = IceCreamPersistence.class)
	protected IceCreamPersistence iceCreamPersistence;
	@BeanReference(type = IceCreamDocumentsPersistence.class)
	protected IceCreamDocumentsPersistence iceCreamDocumentsPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = DLFileEntryPersistence.class)
	protected DLFileEntryPersistence dlFileEntryPersistence;
	private static final String _SQL_SELECT_ICECREAMDOCUMENTS = "SELECT iceCreamDocuments FROM IceCreamDocuments iceCreamDocuments";
	private static final String _SQL_SELECT_ICECREAMDOCUMENTS_WHERE = "SELECT iceCreamDocuments FROM IceCreamDocuments iceCreamDocuments WHERE ";
	private static final String _SQL_COUNT_ICECREAMDOCUMENTS = "SELECT COUNT(iceCreamDocuments) FROM IceCreamDocuments iceCreamDocuments";
	private static final String _SQL_COUNT_ICECREAMDOCUMENTS_WHERE = "SELECT COUNT(iceCreamDocuments) FROM IceCreamDocuments iceCreamDocuments WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "iceCreamDocuments.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "iceCreamDocuments.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(iceCreamDocuments.uuid IS NULL OR iceCreamDocuments.uuid = ?)";
	private static final String _FINDER_COLUMN_ICECREAMID_ICECREAMID_2 = "iceCreamDocuments.iceCreamId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "iceCreamDocuments.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No IceCreamDocuments exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No IceCreamDocuments exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(IceCreamDocumentsPersistenceImpl.class);
	private static IceCreamDocuments _nullIceCreamDocuments = new IceCreamDocumentsImpl() {
			public Object clone() {
				return this;
			}

			public CacheModel<IceCreamDocuments> toCacheModel() {
				return _nullIceCreamDocumentsCacheModel;
			}
		};

	private static CacheModel<IceCreamDocuments> _nullIceCreamDocumentsCacheModel =
		new CacheModel<IceCreamDocuments>() {
			public IceCreamDocuments toEntityModel() {
				return _nullIceCreamDocuments;
			}
		};
}