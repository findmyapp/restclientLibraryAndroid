/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import no.uka.findmyapp.android.rest.contracts.Humidity.HumidityTable;
import no.uka.findmyapp.android.rest.datamodels.models.Humidity;
import android.content.ContentValues;
import android.util.Log;

// TODO: Auto-generated Javadoc
/**
 * The Class HumidityContentMapper.
 */
public class HumidityContentMapper implements IContentMapper {
	private static final String debug = "HumidityContentMapper";

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
		Humidity sample = (Humidity) object;
		ContentValues contentValues = new ContentValues();
		contentValues.put(HumidityTable.LOCATION_ID, sample.getLocationId());
		contentValues.put(HumidityTable.VALUE, sample.getValue());
		contentValues.put(HumidityTable.DATE, sample.getDate());

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
		List<Humidity> humidityList = (List<Humidity>) object;
		List<ContentValues> list = new ArrayList<ContentValues>();

		for (Humidity hum : humidityList) {
			list.add(mapValues(hum));
		}
		return list;
	}
}
