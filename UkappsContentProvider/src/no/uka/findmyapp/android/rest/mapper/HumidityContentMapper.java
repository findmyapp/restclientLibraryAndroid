/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.List;

import no.uka.findmyapp.android.rest.contracts.Sensors;
import no.uka.findmyapp.android.rest.datamodels.models.Humidity;
import android.content.ContentValues;

// TODO: Auto-generated Javadoc
/**
 * The Class HumidityContentMapper.
 */
public class HumidityContentMapper implements IContentMapper {

	/* (non-Javadoc)
	 * @see no.uka.findmyapp.android.rest.mapper.IContentMapper#mapValues(java.io.Serializable)
	 */
	@Override
	public ContentValues mapValues(Serializable object) {
		Humidity sample = (Humidity) object;
		ContentValues contentValues = new ContentValues();
		contentValues.put(Sensors.HumidityTable.LOCATION_ID, sample.getLocationId());
		contentValues.put(Sensors.HumidityTable.VALUE, sample.getValue());
	    contentValues.put(Sensors.HumidityTable.DATE, sample.getDate());

		return contentValues;
	}

	/* (non-Javadoc)
	 * @see no.uka.findmyapp.android.rest.mapper.IContentMapper#mapValuesList(java.io.Serializable)
	 */
	@Override
	public List<ContentValues> mapValuesList(Serializable object) {
		return null;
	}

	/* (non-Javadoc)
	 * @see no.uka.findmyapp.android.rest.mapper.IContentMapper#isList()
	 */
	@Override
	public boolean isList() {
		return false;
	}
}
