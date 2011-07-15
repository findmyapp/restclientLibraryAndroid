package no.uka.findmyapp.android.rest.mapper;

import java.io.Serializable;
import java.util.List;

import no.uka.findmyapp.android.rest.contracts.UkaEvents.UkaEventContract;
import no.uka.findmyapp.android.rest.datamodels.UkaEvent;
import android.content.ContentValues;

public class UkaEventContentMapper implements IContentMapper {

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
		contentValues.put(UkaEventContract.HIDDEN_FROM_LISTING, event.isHidden_from_listings());
		contentValues.put(UkaEventContract.SLUG, event.getSlug());
		contentValues.put(UkaEventContract.AGE_LIMIT, event.getAgeLimit());
		contentValues.put(UkaEventContract.DETAIL_PHOTO_ID, event.getDetailPhotoId()); 
		/*
		contentValues.put(UkaEventContract.SHOWING_TIME, event.getShowingTime().toLocaleString());
		contentValues.put(UkaEventContract.PUBLISH_TIME, event.getPublishTime().toLocaleString());
		contentValues.put(UkaEventContract.NETSALE_FROM, event.getNetsaleFrom().toLocaleString());
		contentValues.put(UkaEventContract.NETSALE_TO, event.getNetsaleTo().toLocaleString());
		*/
		contentValues.put(UkaEventContract.FREE, event.isFree());
		contentValues.put(UkaEventContract.CANCELED, event.isCanceled());
		return contentValues;
	}

	@Override
	public boolean isList() {
		return false;
	}

	@Override
	public List<ContentValues> mapValuesList(Serializable object) {
		// TODO Auto-generated method stub
		return null;
	}
}
