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

package com.ssavr.solr.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

/**
 * The extended model implementation for the IceCreamDocuments service.
 * Represents a row in the &quot;solr_IceCreamDocuments&quot; database table,
 * with each column mapped to a property of this class.
 * 
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link com.ssavr.solr.model.IceCreamDocuments} interface.
 * </p>
 * 
 * @author SAVRAMIS
 */
public class IceCreamDocumentsImpl extends IceCreamDocumentsBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this class directly. All methods that expect a ice cream
	 * documents model instance should use the {@link
	 * com.ssavr.solr.model.IceCreamDocuments} interface instead.
	 */
	public IceCreamDocumentsImpl() {
	}

	public String getTitle() {
		String title = "";
		try {
			DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil
					.getDLFileEntry(getDocumentId());
			title = dlFileEntry.getTitle();
		} catch (PortalException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
		} catch (SystemException e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e.getMessage());
			}
		}
		return title;
	}

	private static Log _log = LogFactoryUtil
			.getLog(IceCreamDocumentsImpl.class);
}