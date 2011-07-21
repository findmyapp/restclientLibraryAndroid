package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.List;

import no.uka.findmyapp.android.rest.contracts.Location.LocationContract;
import no.uka.findmyapp.android.rest.datamodels.models.Location;
import android.content.ContentValues;

public class LocationContentMapper implements IContentMapper {
	public ContentValues mapValues(Serializable object) {
		Location temp = (Location) object;
		ContentValues contentValues = new ContentValues();
		contentValues.put(LocationContract.LOCATIONNAME, temp.getLocationName());
		contentValues.put(LocationContract.LOCATIONID, temp.getLocationId());

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

