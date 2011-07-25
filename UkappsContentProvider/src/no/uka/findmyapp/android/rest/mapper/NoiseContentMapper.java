/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.List;

import no.uka.findmyapp.android.rest.contracts.Noise.NoiseTable;
import no.uka.findmyapp.android.rest.datamodels.models.Noise;
import android.content.ContentValues;

// TODO: Auto-generated Javadoc
/**
 * The Class NoiseContentMapper.
 */
public class NoiseContentMapper implements IContentMapper {

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
		Noise noiseSample = (Noise) object;
		ContentValues contentValues = new ContentValues();
		contentValues.put(NoiseTable.LOCATION_ID, noiseSample.getLocationId());
		contentValues.put(NoiseTable.AVERAGE, noiseSample.getAverage());
		contentValues.put(NoiseTable.MIN, noiseSample.getMin());
		contentValues.put(NoiseTable.MAX, noiseSample.getMax());
		contentValues.put(NoiseTable.SAMPLES, noiseSample.getSamples());
		contentValues.put(NoiseTable.STANDARD_DEVIATION,
				noiseSample.getStandardDeviation());
		contentValues.put(NoiseTable.DATE, noiseSample.getDate());

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
		return null;
	}
}
