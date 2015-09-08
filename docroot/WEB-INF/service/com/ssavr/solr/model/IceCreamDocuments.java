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

package com.ssavr.solr.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the IceCreamDocuments service. Represents a row in the &quot;solr_IceCreamDocuments&quot; database table, with each column mapped to a property of this class.
 *
 * @author SAVRAMIS
 * @see IceCreamDocumentsModel
 * @see com.ssavr.solr.model.impl.IceCreamDocumentsImpl
 * @see com.ssavr.solr.model.impl.IceCreamDocumentsModelImpl
 * @generated
 */
public interface IceCreamDocuments extends IceCreamDocumentsModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.ssavr.solr.model.impl.IceCreamDocumentsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getTitle();
}