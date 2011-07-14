package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;

import no.uka.findmyapp.android.rest.contracts.Sensors;
import no.uka.findmyapp.android.rest.datamodels.Noise;
import android.content.ContentValues;

public class NoiseContentMapper implements IContentMapper {
	public ContentValues mapValues(Serializable object) {
		Noise noiseSample = (Noise) object;
		ContentValues contentValues = new ContentValues();
		contentValues.put(Sensors.NoiseTable.LOCATION_ID, noiseSample.getLocationId());
		contentValues.put(Sensors.NoiseTable.AVERAGE, noiseSample.getAverage());
		contentValues.put(Sensors.NoiseTable.MIN, noiseSample.getMin());
		contentValues.put(Sensors.NoiseTable.MAX, noiseSample.getMax());
		contentValues.put(Sensors.NoiseTable.SAMPLES, noiseSample.getSamples());
		contentValues.put(Sensors.NoiseTable.STANDARD_DEVIATION, noiseSample.getStandardDeviation());
	    contentValues.put(Sensors.NoiseTable.DATE, noiseSample.getDate().toLocaleString()); 

		return contentValues;
	}
}
