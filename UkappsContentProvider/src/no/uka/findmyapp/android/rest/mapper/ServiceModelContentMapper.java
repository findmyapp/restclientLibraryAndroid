/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.List;

import no.uka.findmyapp.android.rest.contracts.ServiceInfo.ServiceInfoContract;
import no.uka.findmyapp.android.rest.datamodels.core.ServiceModel;
import android.content.ContentValues;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceModelContentMapper.
 */
public class ServiceModelContentMapper implements IContentMapper {
	
	/* (non-Javadoc)
	 * @see no.uka.findmyapp.android.rest.mapper.IContentMapper#mapValues(java.io.Serializable)
	 */
	@Override
	public ContentValues mapValues(Serializable object) {
		ServiceModel castedObject = (ServiceModel) object;
		ContentValues contentValues = new ContentValues();
		contentValues.put(ServiceInfoContract.URI, castedObject.getUri().toString());
		contentValues.put(ServiceInfoContract.HTTPTYPE, castedObject.getHttpType().toString());
		contentValues.put(ServiceInfoContract.DATAFORMAT, castedObject.getDataformat().getValue());
		contentValues.put(ServiceInfoContract.RETURNTYPE, castedObject.getReturnType());
		contentValues.put(ServiceInfoContract.CONTENTPROVIDER_URI, castedObject.getContentProviderUri().toString());
		contentValues.put(ServiceInfoContract.BROADCAST_NOTIFICATION, castedObject.getBroadcastNotification());

		return contentValues;
	}

	/* (non-Javadoc)
	 * @see no.uka.findmyapp.android.rest.mapper.IContentMapper#mapValuesList(java.io.Serializable)
	 */
	@Override
	public List<ContentValues> mapValuesList(Serializable object) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see no.uka.findmyapp.android.rest.mapper.IContentMapper#isList()
	 */
	@Override
	public boolean isList() {
		// TODO Auto-generated method stub
		return false;
	}
}
