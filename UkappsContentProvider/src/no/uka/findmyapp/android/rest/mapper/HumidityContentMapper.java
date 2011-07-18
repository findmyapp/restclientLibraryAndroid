package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.List;

import no.uka.findmyapp.android.rest.contracts.Sensors;
import no.uka.findmyapp.android.rest.datamodels.models.Humidity;
import android.content.ContentValues;

public class HumidityContentMapper implements IContentMapper {

	public ContentValues mapValues(Serializable object) {
		Humidity sample = (Humidity) object;
		ContentValues contentValues = new ContentValues();
		contentValues.put(Sensors.HumidityTable.LOCATION_ID, sample.getLocationId());
		contentValues.put(Sensors.HumidityTable.VALUE, sample.getValue());
	    contentValues.put(Sensors.HumidityTable.DATE, sample.getDate());

		return contentValues;
	}

	@Override
	public List<ContentValues> mapValuesList(Serializable object) {
		return null;
	}

	@Override
	public boolean isList() {
		return false;
	}
}
