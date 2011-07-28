/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import no.uka.findmyapp.android.rest.contracts.Temperature.TemperatureTable;
import no.uka.findmyapp.android.rest.datamodels.models.Temperature;
import android.content.ContentValues;
import android.util.Log;

/**
 * The Class TemperatureContentMapper.
 */
public class TemperatureContentMapper implements IContentMapper {
	private static final String debug = "TemperatureContentMapper";


	/*
	 * (non-Javadoc)
	 * 
	 * @see no.uka.findmyapp.android.rest.mapper.IContentMapper#isList()
	 */
	@Override
	public boolean isList() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.uka.findmyapp.android.rest.mapper.IContentMapper#mapValues(java.io
	 * .Serializable)
	 */
	@Override
	public ContentValues mapValues(Serializable object) {
		Temperature tempSample = (Temperature) object;
		ContentValues contentValues = new ContentValues();
		contentValues.put(TemperatureTable.LOCATION_ID, tempSample.getLocation());
		contentValues.put(TemperatureTable.VALUE, tempSample.getValue());
		contentValues.put(TemperatureTable.DATE, tempSample.getDate());

		return contentValues;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.uka.findmyapp.android.rest.mapper.IContentMapper#mapValuesList(java
	 * .io.Serializable)
	 */
	@Override
	public List<ContentValues> mapValuesList(Serializable object) {
		List<Temperature> temperatureList = (List<Temperature>) object;
		List<ContentValues> list = new ArrayList<ContentValues>();

		for (Temperature temp : temperatureList) {
			Log.v(debug, "Temperature " + temp.getValue());
			list.add(mapValues(temp));
		}
		return list;
	}
}
