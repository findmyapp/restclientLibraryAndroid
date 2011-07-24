package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import no.uka.findmyapp.android.rest.contracts.UkaEvents.UkaEventContract;
import no.uka.findmyapp.android.rest.datamodels.models.UkaEvent;
import android.content.ContentValues;
import android.util.Log;

public class UkaEventContentMapper implements IContentMapper {
	private static final String debug = "UkaEventContentMapper";
//TODO fix age to favourite
	@Override
	public ContentValues mapValues(Serializable temp) {
		UkaEvent event = (UkaEvent) temp;
		ContentValues contentValues = new ContentValues();
		contentValues.put(UkaEventContract.EVENT_ID, event.getEventId());
		contentValues.put(UkaEventContract.BILLING_ID, event.getBillingid());
		contentValues.put(UkaEventContract.ENTRANCE_ID, event.getEntranceId());
		contentValues.put(UkaEventContract.TITLE, event.getTitle()); 
		contentValues.put(UkaEventContract.LEAD, event.getLead());
		contentValues.put(UkaEventContract.TEXT, event.getText());
		contentValues.put(UkaEventContract.PLACE, event.getPlace());
		contentValues.put(UkaEventContract.IMAGE, event.getImage());
		contentValues.put(UkaEventContract.THUMBNAIL, event.getThumbnail());
		contentValues.put(UkaEventContract.AGE_LIMIT, event.getAgeLimit());
		contentValues.put(UkaEventContract.EVENT_TYPE, event.getEventType());
		contentValues.put(UkaEventContract.SHOWING_TIME, event.getShowingTime());
		contentValues.put(UkaEventContract.FREE, event.isFree());
		contentValues.put(UkaEventContract.CANCELED, event.isCanceled());
		contentValues.put(UkaEventContract.FAVOURITE, event.isFavourite());
		contentValues.put(UkaEventContract.LOWEST_PRICE, event.getPrice());
		
		return contentValues;
	}

	@Override
	public List<ContentValues> mapValuesList(Serializable object) {
		List<ContentValues> list = new ArrayList<ContentValues>();
		List<UkaEvent> ukaEventList = (List<UkaEvent>) object;
		
		for(UkaEvent event : ukaEventList) {
			Log.v(debug, "EventType " + event.getEventType());
			list.add(mapValues(event));
		}
		return list;
	}
	
	@Override
	public boolean isList() {
		return false;
	}
}
