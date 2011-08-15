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
import no.uka.findmyapp.android.rest.datamodels.models.Location;
import no.uka.findmyapp.android.rest.datamodels.models.Temperature;
import no.uka.findmyapp.android.rest.datamodels.models.UkaEvent;

import android.content.ContentValues;
import android.util.Log;

// TODO: Auto-generated Javadoc
/**
 * The Class UserContentMapper.
 */
public class UserContentMapper {
	
	/** The Constant debug. */
	private static final String debug = "UserContentMapper";

	/*
	 * (non-Javadoc)
	 * 
	 * @see no.uka.findmyapp.android.rest.mapper.IContentMapper#isList()
	 */

	/**
	 * Checks if is list.
	 *
	 * @return true, if is list
	 */
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

	//TODO Implement mapping
	
	/**
	 * Map values.
	 *
	 * @param object the object
	 * @return the content values
	 */
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

	/**
	 * Map values list.
	 *
	 * @param object the object
	 * @return the list
	 */
	public List<ContentValues> mapValuesList(Serializable object) {
//TODO
		return null;
	}
}

