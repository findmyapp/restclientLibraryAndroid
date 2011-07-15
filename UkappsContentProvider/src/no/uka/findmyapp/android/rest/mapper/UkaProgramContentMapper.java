package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import no.uka.findmyapp.android.rest.contracts.UkaEvents.UkaEventContract;
import no.uka.findmyapp.android.rest.datamodels.UkaEvent;
import no.uka.findmyapp.android.rest.datamodels.UkaProgram;
import android.content.ContentValues;

public class UkaProgramContentMapper implements IContentMapper  {
	@Override
	public List<ContentValues> mapValuesList(Serializable object) {

		UkaProgram up = (UkaProgram) object;
	
		List<ContentValues> events = new ArrayList<ContentValues>();
		
		for(UkaEvent event : up.getEvents()) {
			UkaEventContentMapper u = new UkaEventContentMapper();
			ContentValues ue = u.mapValues(event);
			events.add(ue);
		}
	
		return events;
	}

	@Override
	public boolean isList() {
		return true;
	}

	@Override
	public ContentValues mapValues(Serializable object) {
		// TODO Auto-generated method stub
		return null;
	}

}
