package no.uka.findmyapp.android.rest.client;

import java.io.Serializable;

import no.uka.findmyapp.android.rest.client.model.ServiceModel;
import no.uka.findmyapp.android.rest.contracts.UkaEvents.UkaEventContract;
import no.uka.findmyapp.android.rest.datamodels.UkaEvent;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 */
public class RestProcessor {
	private RestMethod restMethod;
	private Gson gson;
	private Context context; 
	
	public RestProcessor(Context context) {
		this.context = context; 
		this.restMethod = new RestMethod();
		GsonBuilder builder = new GsonBuilder();
		this.gson = builder.create();
	}
	
	public void callRest(ServiceModel serviceModel) {
		switch(serviceModel.getHttpType()) {
			case GET :
				if(serviceModel.getBroadcastNotification() != null) 
					this.sendIntentBroadcast(serviceModel.getBroadcastNotification(), this.executeAndParse(serviceModel));
				else 
					this.sendToContentProvider(serviceModel.getContentProviderUri(), (UkaEvent) this.executeAndParse(serviceModel));
			break;
			case POST :
				//TODO
			break;
			case DELETE :
				//TODO
			break;
			case PUT :
				//TODO
			break;
		}
	}
	
	private Serializable executeAndParse(ServiceModel serviceModel) {
		restMethod.setUri(serviceModel.getUri());
		String response = "";
		try {
			response = restMethod.get(serviceModel.getDataformat());
			
			return (Serializable)gson.fromJson(response, serviceModel.getReturnType());
		} catch (Exception e) {
			// TODO Fix return
			e.printStackTrace();
			
			return e; 
		}
	}
	
	private void sendToContentProvider(Uri uri, UkaEvent ukaEvent) {
		ContentValues cv = new ContentValues();
		cv.put(UkaEventContract.EVENT_ID, ukaEvent.getEntranceId());
		cv.put(UkaEventContract.BILLING_ID, ukaEvent.getBillingid());
		cv.put(UkaEventContract.ENTRANCE_ID, ukaEvent.getEntranceId());
		cv.put(UkaEventContract.TITLE, ukaEvent.getTitle()); 
		cv.put(UkaEventContract.LEAD, ukaEvent.getLead());
		cv.put(UkaEventContract.TEXT, ukaEvent.getText());
		cv.put(UkaEventContract.PLACE, ukaEvent.getPlace());
		cv.put(UkaEventContract.IMAGE, ukaEvent.getImage());
		cv.put(UkaEventContract.THUMBNAIL, ukaEvent.getThumbnail());
		cv.put(UkaEventContract.HIDDEN_FROM_LISTING, ukaEvent.isHidden_from_listings());
		cv.put(UkaEventContract.SLUG, ukaEvent.getSlug());
		cv.put(UkaEventContract.AGE_LIMIT, ukaEvent.getAgeLimit());
		cv.put(UkaEventContract.DETAIL_PHOTO_ID, ukaEvent.getDetailPhotoId()); 
		cv.put(UkaEventContract.SHOWING_TIME, ukaEvent.getShowingTime().toLocaleString());
		cv.put(UkaEventContract.PUBLISH_TIME, ukaEvent.getPublishTime().toLocaleString());
		cv.put(UkaEventContract.NETSALE_FROM, ukaEvent.getNetsaleFrom().toLocaleString());
		cv.put(UkaEventContract.NETSALE_TO, ukaEvent.getNetsaleTo().toLocaleString());
		cv.put(UkaEventContract.FREE, ukaEvent.isFree());
		cv.put(UkaEventContract.CANCELED, ukaEvent.isCanceled());
		
		ContentResolver cr = context.getContentResolver(); 
		cr.insert(uri, cv);
	}
	
	private void sendIntentBroadcast(String intentString, Serializable obj) {
		Log.v("RestProcessor", "sending broadcast");
		Intent broadcastedIntent = new Intent(); 
		broadcastedIntent.putExtra("return", (Serializable) obj);
		broadcastedIntent.setAction(intentString);
		
		context.sendBroadcast(broadcastedIntent);
	}
}
