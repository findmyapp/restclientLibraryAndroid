package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;

import no.uka.findmyapp.android.rest.contracts.Sensors;
import no.uka.findmyapp.android.rest.datamodels.Humidity;
import android.content.ContentValues;

public class HumidityContentMapper implements IContentMapper {

	public ContentValues mapValues(Serializable object) {
		Humidity sample = (Humidity) object;
		ContentValues contentValues = new ContentValues();
		contentValues.put(Sensors.HumidityTable.LOCATION_ID, sample.getLocationId());
		contentValues.put(Sensors.HumidityTable.VALUE, sample.getValue());
	  //contentValues.put(Sensors.HumidityTable.DATE, sampleO.getDate()); 

		return contentValues;
	}
}
