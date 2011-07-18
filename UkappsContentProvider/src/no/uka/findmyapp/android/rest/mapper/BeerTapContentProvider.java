package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.List;

import no.uka.findmyapp.android.rest.contracts.Sensors;
import no.uka.findmyapp.android.rest.datamodels.models.BeerTap;
import android.content.ContentValues;

public class BeerTapContentProvider implements IContentMapper {
	public ContentValues mapValues(Serializable object) {
		BeerTap beertapSample = (BeerTap) object;
		ContentValues contentValues = new ContentValues();
		contentValues.put(Sensors.BeerTapTable.LOCATION_ID, beertapSample.getLocationId());
		contentValues.put(Sensors.BeerTapTable.VALUE, beertapSample.getValue());
		contentValues.put(Sensors.BeerTapTable.BEER_TOWER_NUM, beertapSample.getBeerTowerNum());
	    contentValues.put(Sensors.BeerTapTable.DATE, beertapSample.getDate()); 
	    
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
