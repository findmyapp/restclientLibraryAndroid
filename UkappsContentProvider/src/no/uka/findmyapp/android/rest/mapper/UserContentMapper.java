package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.List;

import android.content.ContentValues;

public class UserContentMapper {

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
	/*
	public ContentValues mapValues(Serializable object) {
		Temperature tempSample = (Temperature) object;
		ContentValues contentValues = new ContentValues();
		contentValues.put(TemperatureTable.LOCATION_ID, tempSample.getLocation());
		contentValues.put(TemperatureTable.VALUE, tempSample.getValue());
		contentValues.put(TemperatureTable.DATE, tempSample.getDate());

		return contentValues;
	}
*/
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * no.uka.findmyapp.android.rest.mapper.IContentMapper#mapValuesList(java
	 * .io.Serializable)
	 */

	public List<ContentValues> mapValuesList(Serializable object) {
		return null;
	}
}

