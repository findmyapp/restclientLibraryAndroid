package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import no.uka.findmyapp.android.rest.datamodels.models.UkaEvent;
import no.uka.findmyapp.android.rest.datamodels.models.UkaProgram;
import android.content.ContentValues;
import android.util.Log;

public class UkaProgramContentMapper implements IContentMapper  {
	@Override
	public List<ContentValues> mapValuesList(Serializable object) {

		UkaProgram up = (UkaProgram) object;
	
		List<ContentValues> events = new ArrayList<ContentValues>();
		
		for(UkaEvent event : up.getEvents()) {
			Log.v("event", event.toString());
			UkaEventContentMapper u = new UkaEventContentMapper();
			ContentValues ue = u.mapValues(event);
			events.add(ue);
		}
	
		return events;
	}

	@Override
	public boolean isList() {
		return false;
	}

	@Override
	public ContentValues mapValues(Serializable object) {
		// TODO Auto-generated method stub
		return null;
	}

}
