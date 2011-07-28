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

public class UserContentMapper {
	private static final String debug = "UserContentMapper";

	/*
	 * (non-Javadoc)
	 * 
	 * @see no.uka.findmyapp.android.rest.mapper.IContentMapper#isList()
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

	public List<ContentValues> mapValuesList(Serializable object) {
//TODO
		return null;
	}
}

