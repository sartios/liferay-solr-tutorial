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

import com.ssavr.solr.NoSuchIceCreamException;
import com.ssavr.solr.model.IceCream;
import com.ssavr.solr.model.impl.IceCreamImpl;
import com.ssavr.solr.model.impl.IceCreamModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ice cream service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author SAVRAMIS
 * @see IceCreamPersistence
 * @see IceCreamUtil
 * @generated
 */
public class IceCreamPersistenceImpl extends BasePersistenceImpl<IceCream>
	implements IceCreamPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link IceCreamUtil} to access the ice cream persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = IceCreamImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(IceCreamModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamModelImpl.FINDER_CACHE_ENABLED, IceCreamImpl.class,
			FINDER_CLASS_NAME_LIST, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(IceCreamModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_FLAVOR = new FinderPath(IceCreamModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamModelImpl.FINDER_CACHE_ENABLED, IceCreamImpl.class,
			FINDER_CLASS_NAME_LIST, "findByFlavor",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_FLAVOR = new FinderPath(IceCreamModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByFlavor",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(IceCreamModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamModelImpl.FINDER_CACHE_ENABLED, IceCreamImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(IceCreamModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countByName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(IceCreamModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamModelImpl.FINDER_CACHE_ENABLED, IceCreamImpl.class,
			FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IceCreamModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST, "countAll", new String[0]);

	/**
	 * Caches the ice cream in the entity cache if it is enabled.
	 *
	 * @param iceCream the ice cream to cache
	 */
	public void cacheResult(IceCream iceCream) {
		EntityCacheUtil.putResult(IceCreamModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamImpl.class, iceCream.getPrimaryKey(), iceCream);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { iceCream.getName() }, iceCream);

		iceCream.resetOriginalValues();
	}

	/**
	 * Caches the ice creams in the entity cache if it is enabled.
	 *
	 * @param iceCreams the ice creams to cache
	 */
	public void cacheResult(List<IceCream> iceCreams) {
		for (IceCream iceCream : iceCreams) {
			if (EntityCacheUtil.getResult(
						IceCreamModelImpl.ENTITY_CACHE_ENABLED,
						IceCreamImpl.class, iceCream.getPrimaryKey(), this) == null) {
				cacheResult(iceCream);
			}
		}
	}

	/**
	 * Clears the cache for all ice creams.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(IceCreamImpl.class.getName());
		}

		EntityCacheUtil.clearCache(IceCreamImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the ice cream.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(IceCream iceCream) {
		EntityCacheUtil.removeResult(IceCreamModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamImpl.class, iceCream.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { iceCream.getName() });
	}

	/**
	 * Creates a new ice cream with the primary key. Does not add the ice cream to the database.
	 *
	 * @param iceCreamId the primary key for the new ice cream
	 * @return the new ice cream
	 */
	public IceCream create(long iceCreamId) {
		IceCream iceCream = new IceCreamImpl();

		iceCream.setNew(true);
		iceCream.setPrimaryKey(iceCreamId);

		String uuid = PortalUUIDUtil.generate();

		iceCream.setUuid(uuid);

		return iceCream;
	}

	/**
	 * Removes the ice cream with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ice cream to remove
	 * @return the ice cream that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a ice cream with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IceCream remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the ice cream with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param iceCreamId the primary key of the ice cream to remove
	 * @return the ice cream that was removed
	 * @throws com.ssavr.solr.NoSuchIceCreamException if a ice cream with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public IceCream remove(long iceCreamId)
		throws NoSuchIceCreamException, SystemException {
		Session session = null;

		try {
			session = openSession();

			IceCream iceCream = (IceCream)session.get(IceCreamImpl.class,
					Long.valueOf(iceCreamId));

			if (iceCream == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + iceCreamId);
				}

				throw new NoSuchIceCreamException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					iceCreamId);
			}

			return iceCreamPersistence.remove(iceCream);
		}
		catch (NoSuchIceCreamException nsee) {
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
	 * Removes the ice cream from the database. Also notifies the appropriate model listeners.
	 *
	 * @param iceCream the ice cream to remove
	 * @return the ice cream that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IceCream remove(IceCream iceCream) throws SystemException {
		return super.remove(iceCream);
	}

	@Override
	protected IceCream removeImpl(IceCream iceCream) throws SystemException {
		iceCream = toUnwrappedModel(iceCream);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, iceCream);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		IceCreamModelImpl iceCreamModelImpl = (IceCreamModelImpl)iceCream;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { iceCreamModelImpl.getName() });

		EntityCacheUtil.removeResult(IceCreamModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamImpl.class, iceCream.getPrimaryKey());

		return iceCream;
	}

	@Override
	public IceCream updateImpl(com.ssavr.solr.model.IceCream iceCream,
		boolean merge) throws SystemException {
		iceCream = toUnwrappedModel(iceCream);

		boolean isNew = iceCream.isNew();

		IceCreamModelImpl iceCreamModelImpl = (IceCreamModelImpl)iceCream;

		if (Validator.isNull(iceCream.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			iceCream.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, iceCream, merge);

			iceCream.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(IceCreamModelImpl.ENTITY_CACHE_ENABLED,
			IceCreamImpl.class, iceCream.getPrimaryKey(), iceCream);

		if (!isNew &&
				(!Validator.equals(iceCream.getName(),
					iceCreamModelImpl.getOriginalName()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
				new Object[] { iceCreamModelImpl.getOriginalName() });
		}

		if (isNew ||
				(!Validator.equals(iceCream.getName(),
					iceCreamModelImpl.getOriginalName()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
				new Object[] { iceCream.getName() }, iceCream);
		}

		return iceCream;
	}

	protected IceCream toUnwrappedModel(IceCream iceCream) {
		if (iceCream instanceof IceCreamImpl) {
			return iceCream;
		}

		IceCreamImpl iceCreamImpl = new IceCreamImpl();

		iceCreamImpl.setNew(iceCream.isNew());
		iceCreamImpl.setPrimaryKey(iceCream.getPrimaryKey());

		iceCreamImpl.setUuid(iceCream.getUuid());
		iceCreamImpl.setIceCreamId(iceCream.getIceCreamId());
		iceCreamImpl.setCompanyId(iceCream.getCompanyId());
		iceCreamImpl.setUserId(iceCream.getUserId());
		iceCreamImpl.setCreateDate(iceCream.getCreateDate());
		iceCreamImpl.setModifiedDate(iceCream.getModifiedDate());
		iceCreamImpl.setFlavor(iceCream.getFlavor());
		iceCreamImpl.setName(iceCream.getName());

		return iceCreamImpl;
	}

	/**
	 * Finds the ice cream with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ice cream to find
	 * @return the ice cream
	 * @throws com.liferay.portal.NoSuchModelException if a ice cream with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IceCream findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the ice cream with the primary key or throws a {@link com.ssavr.solr.NoSuchIceCreamException} if it could not be found.
	 *
	 * @param iceCreamId the primary key of the ice cream to find
	 * @return the ice cream
	 * @throws com.ssavr.solr.NoSuchIceCreamException if a ice cream with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public IceCream findByPrimaryKey(long iceCreamId)
		throws NoSuchIceCreamException, SystemException {
		IceCream iceCream = fetchByPrimaryKey(iceCreamId);

		if (iceCream == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + iceCreamId);
			}

			throw new NoSuchIceCreamException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				iceCreamId);
		}

		return iceCream;
	}

	/**
	 * Finds the ice cream with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ice cream to find
	 * @return the ice cream, or <code>null</code> if a ice cream with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public IceCream fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the ice cream with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param iceCreamId the primary key of the ice cream to find
	 * @return the ice cream, or <code>null</code> if a ice cream with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public IceCream fetchByPrimaryKey(long iceCreamId)
		throws SystemException {
		IceCream iceCream = (IceCream)EntityCacheUtil.getResult(IceCreamModelImpl.ENTITY_CACHE_ENABLED,
				IceCreamImpl.class, iceCreamId, this);

		if (iceCream == _nullIceCream) {
			return null;
		}

		if (iceCream == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				iceCream = (IceCream)session.get(IceCreamImpl.class,
						Long.valueOf(iceCreamId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (iceCream != null) {
					cacheResult(iceCream);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(IceCreamModelImpl.ENTITY_CACHE_ENABLED,
						IceCreamImpl.class, iceCreamId, _nullIceCream);
				}

				closeSession(session);
			}
		}

		return iceCream;
	}

	/**
	 * Finds all the ice creams where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the matching ice creams
	 * @throws SystemException if a system exception occurred
	 */
	public List<IceCream> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<IceCream> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
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
	public List<IceCream> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				uuid,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<IceCream> list = (List<IceCream>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ICECREAM_WHERE);

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

			else {
				query.append(IceCreamModelImpl.ORDER_BY_JPQL);
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

				list = (List<IceCream>)QueryUtil.list(q, getDialect(), start,
						end);
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
	public IceCream findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchIceCreamException, SystemException {
		List<IceCream> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchIceCreamException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public IceCream findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchIceCreamException, SystemException {
		int count = countByUuid(uuid);

		List<IceCream> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchIceCreamException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public IceCream[] findByUuid_PrevAndNext(long iceCreamId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchIceCreamException, SystemException {
		IceCream iceCream = findByPrimaryKey(iceCreamId);

		Session session = null;

		try {
			session = openSession();

			IceCream[] array = new IceCreamImpl[3];

			array[0] = getByUuid_PrevAndNext(session, iceCream, uuid,
					orderByComparator, true);

			array[1] = iceCream;

			array[2] = getByUuid_PrevAndNext(session, iceCream, uuid,
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

	protected IceCream getByUuid_PrevAndNext(Session session,
		IceCream iceCream, String uuid, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ICECREAM_WHERE);

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

		else {
			query.append(IceCreamModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByValues(iceCream);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IceCream> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the ice creams where flavor = &#63;.
	 *
	 * @param flavor the flavor to search with
	 * @return the matching ice creams
	 * @throws SystemException if a system exception occurred
	 */
	public List<IceCream> findByFlavor(String flavor) throws SystemException {
		return findByFlavor(flavor, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<IceCream> findByFlavor(String flavor, int start, int end)
		throws SystemException {
		return findByFlavor(flavor, start, end, null);
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
	public List<IceCream> findByFlavor(String flavor, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				flavor,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<IceCream> list = (List<IceCream>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FLAVOR,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ICECREAM_WHERE);

			if (flavor == null) {
				query.append(_FINDER_COLUMN_FLAVOR_FLAVOR_1);
			}
			else {
				if (flavor.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_FLAVOR_FLAVOR_3);
				}
				else {
					query.append(_FINDER_COLUMN_FLAVOR_FLAVOR_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(IceCreamModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (flavor != null) {
					qPos.add(flavor);
				}

				list = (List<IceCream>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_FLAVOR,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FLAVOR,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public IceCream findByFlavor_First(String flavor,
		OrderByComparator orderByComparator)
		throws NoSuchIceCreamException, SystemException {
		List<IceCream> list = findByFlavor(flavor, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("flavor=");
			msg.append(flavor);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchIceCreamException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public IceCream findByFlavor_Last(String flavor,
		OrderByComparator orderByComparator)
		throws NoSuchIceCreamException, SystemException {
		int count = countByFlavor(flavor);

		List<IceCream> list = findByFlavor(flavor, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("flavor=");
			msg.append(flavor);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchIceCreamException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public IceCream[] findByFlavor_PrevAndNext(long iceCreamId, String flavor,
		OrderByComparator orderByComparator)
		throws NoSuchIceCreamException, SystemException {
		IceCream iceCream = findByPrimaryKey(iceCreamId);

		Session session = null;

		try {
			session = openSession();

			IceCream[] array = new IceCreamImpl[3];

			array[0] = getByFlavor_PrevAndNext(session, iceCream, flavor,
					orderByComparator, true);

			array[1] = iceCream;

			array[2] = getByFlavor_PrevAndNext(session, iceCream, flavor,
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

	protected IceCream getByFlavor_PrevAndNext(Session session,
		IceCream iceCream, String flavor, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ICECREAM_WHERE);

		if (flavor == null) {
			query.append(_FINDER_COLUMN_FLAVOR_FLAVOR_1);
		}
		else {
			if (flavor.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FLAVOR_FLAVOR_3);
			}
			else {
				query.append(_FINDER_COLUMN_FLAVOR_FLAVOR_2);
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

		else {
			query.append(IceCreamModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (flavor != null) {
			qPos.add(flavor);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(iceCream);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<IceCream> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the ice cream where name = &#63; or throws a {@link com.ssavr.solr.NoSuchIceCreamException} if it could not be found.
	 *
	 * @param name the name to search with
	 * @return the matching ice cream
	 * @throws com.ssavr.solr.NoSuchIceCreamException if a matching ice cream could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public IceCream findByName(String name)
		throws NoSuchIceCreamException, SystemException {
		IceCream iceCream = fetchByName(name);

		if (iceCream == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchIceCreamException(msg.toString());
		}

		return iceCream;
	}

	/**
	 * Finds the ice cream where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name to search with
	 * @return the matching ice cream, or <code>null</code> if a matching ice cream could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public IceCream fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Finds the ice cream where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name to search with
	 * @return the matching ice cream, or <code>null</code> if a matching ice cream could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public IceCream fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ICECREAM_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			query.append(IceCreamModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
				}

				List<IceCream> list = q.list();

				result = list;

				IceCream iceCream = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					iceCream = list.get(0);

					cacheResult(iceCream);

					if ((iceCream.getName() == null) ||
							!iceCream.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, iceCream);
					}
				}

				return iceCream;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (IceCream)result;
			}
		}
	}

	/**
	 * Finds all the ice creams.
	 *
	 * @return the ice creams
	 * @throws SystemException if a system exception occurred
	 */
	public List<IceCream> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<IceCream> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<IceCream> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<IceCream> list = (List<IceCream>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ICECREAM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ICECREAM.concat(IceCreamModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<IceCream>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<IceCream>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the ice creams where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (IceCream iceCream : findByUuid(uuid)) {
			iceCreamPersistence.remove(iceCream);
		}
	}

	/**
	 * Removes all the ice creams where flavor = &#63; from the database.
	 *
	 * @param flavor the flavor to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByFlavor(String flavor) throws SystemException {
		for (IceCream iceCream : findByFlavor(flavor)) {
			iceCreamPersistence.remove(iceCream);
		}
	}

	/**
	 * Removes the ice cream where name = &#63; from the database.
	 *
	 * @param name the name to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByName(String name)
		throws NoSuchIceCreamException, SystemException {
		IceCream iceCream = findByName(name);

		iceCreamPersistence.remove(iceCream);
	}

	/**
	 * Removes all the ice creams from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (IceCream iceCream : findAll()) {
			iceCreamPersistence.remove(iceCream);
		}
	}

	/**
	 * Counts all the ice creams where uuid = &#63;.
	 *
	 * @param uuid the uuid to search with
	 * @return the number of matching ice creams
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ICECREAM_WHERE);

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
	 * Counts all the ice creams where flavor = &#63;.
	 *
	 * @param flavor the flavor to search with
	 * @return the number of matching ice creams
	 * @throws SystemException if a system exception occurred
	 */
	public int countByFlavor(String flavor) throws SystemException {
		Object[] finderArgs = new Object[] { flavor };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FLAVOR,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ICECREAM_WHERE);

			if (flavor == null) {
				query.append(_FINDER_COLUMN_FLAVOR_FLAVOR_1);
			}
			else {
				if (flavor.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_FLAVOR_FLAVOR_3);
				}
				else {
					query.append(_FINDER_COLUMN_FLAVOR_FLAVOR_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (flavor != null) {
					qPos.add(flavor);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FLAVOR,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the ice creams where name = &#63;.
	 *
	 * @param name the name to search with
	 * @return the number of matching ice creams
	 * @throws SystemException if a system exception occurred
	 */
	public int countByName(String name) throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ICECREAM_WHERE);

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else {
				if (name.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_NAME_NAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_NAME_NAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (name != null) {
					qPos.add(name);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the ice creams.
	 *
	 * @return the number of ice creams
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

				Query q = session.createQuery(_SQL_COUNT_ICECREAM);

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
	 * Initializes the ice cream persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ssavr.solr.model.IceCream")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<IceCream>> listenersList = new ArrayList<ModelListener<IceCream>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<IceCream>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(IceCreamImpl.class.getName());
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
	private static final String _SQL_SELECT_ICECREAM = "SELECT iceCream FROM IceCream iceCream";
	private static final String _SQL_SELECT_ICECREAM_WHERE = "SELECT iceCream FROM IceCream iceCream WHERE ";
	private static final String _SQL_COUNT_ICECREAM = "SELECT COUNT(iceCream) FROM IceCream iceCream";
	private static final String _SQL_COUNT_ICECREAM_WHERE = "SELECT COUNT(iceCream) FROM IceCream iceCream WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "iceCream.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "iceCream.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(iceCream.uuid IS NULL OR iceCream.uuid = ?)";
	private static final String _FINDER_COLUMN_FLAVOR_FLAVOR_1 = "iceCream.flavor IS NULL";
	private static final String _FINDER_COLUMN_FLAVOR_FLAVOR_2 = "iceCream.flavor = ?";
	private static final String _FINDER_COLUMN_FLAVOR_FLAVOR_3 = "(iceCream.flavor IS NULL OR iceCream.flavor = ?)";
	private static final String _FINDER_COLUMN_NAME_NAME_1 = "iceCream.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "iceCream.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(iceCream.name IS NULL OR iceCream.name = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "iceCream.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No IceCream exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No IceCream exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(IceCreamPersistenceImpl.class);
	private static IceCream _nullIceCream = new IceCreamImpl() {
			public Object clone() {
				return this;
			}

			public CacheModel<IceCream> toCacheModel() {
				return _nullIceCreamCacheModel;
			}
		};

	private static CacheModel<IceCream> _nullIceCreamCacheModel = new CacheModel<IceCream>() {
			public IceCream toEntityModel() {
				return _nullIceCream;
			}
		};
}