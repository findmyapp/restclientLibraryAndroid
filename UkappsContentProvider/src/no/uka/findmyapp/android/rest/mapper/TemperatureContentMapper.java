package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.List;

import no.uka.findmyapp.android.rest.contracts.Sensors;
import no.uka.findmyapp.android.rest.datamodels.models.Temperature;
import android.content.ContentValues;

public class TemperatureContentMapper implements IContentMapper {

	public ContentValues mapValues(Serializable object) {
		Temperature tempSample = (Temperature) object;
		ContentValues contentValues = new ContentValues();
		contentValues.put(Sensors.TemperatureTable.LOCATION_ID, tempSample.getLocationId());
		contentValues.put(Sensors.TemperatureTable.VALUE, tempSample.getValue());
	  //contentValues.put(Sensors.TemperatureTable.DATE, tempSample.getDate()); 

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
