/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.List;

import no.uka.findmyapp.android.rest.contracts.Sensors;
import no.uka.findmyapp.android.rest.datamodels.models.Temperature;
import android.content.ContentValues;

// TODO: Auto-generated Javadoc
/**
 * The Class TemperatureContentMapper.
 */
public class TemperatureContentMapper implements IContentMapper {
	
	/* (non-Javadoc)
	 * @see no.uka.findmyapp.android.rest.mapper.IContentMapper#mapValues(java.io.Serializable)
	 */
	@Override
	public ContentValues mapValues(Serializable object) {
		Temperature tempSample = (Temperature) object;
		ContentValues contentValues = new ContentValues();
		contentValues.put(Sensors.TemperatureTable.LOCATION_ID, tempSample.getLocationId());
		contentValues.put(Sensors.TemperatureTable.VALUE, tempSample.getValue());
	    contentValues.put(Sensors.TemperatureTable.DATE, tempSample.getDate()); 

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
