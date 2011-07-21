package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.List;

import no.uka.findmyapp.android.rest.contracts.ServiceInfo.ServiceInfoContract;
import no.uka.findmyapp.android.rest.datamodels.core.ServiceModel;
import android.content.ContentValues;

public class ServiceModelContentMapper implements IContentMapper {
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

	@Override
	public List<ContentValues> mapValuesList(Serializable object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isList() {
		// TODO Auto-generated method stub
		return false;
	}
}
