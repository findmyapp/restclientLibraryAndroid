package no.uka.findmyapp.android.rest.client;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import no.uka.findmyapp.android.rest.client.model.ServiceModel;
import no.uka.findmyapp.android.rest.datamodels.Temperature;
import no.uka.findmyapp.android.rest.datamodels.UkaEvent;
import no.uka.findmyapp.android.rest.datamodels.UkaProgram;
import no.uka.findmyapp.android.rest.helpers.ContentHelper;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * 
 */
public class RestProcessor {
	private static final String debug = "RestProcessor"; 
	
	private RestMethod restMethod;
	private Gson gson;
	private Context context; 
	
	public RestProcessor(Context context) {
		Log.v(debug, "Inside RestProcessor creator");
		this.context = context; 
		this.restMethod = new RestMethod();
		GsonBuilder builder = new GsonBuilder();
		this.gson = builder.create();
	}
	
	public void callRest(ServiceModel serviceModel) {
		
		switch(serviceModel.getHttpType()) {
			case GET :
				Log.v(debug, "callRest: trying executeAndParese " + serviceModel);
				Object o = this.executeAndParse(serviceModel);
				
				Log.v(debug, "callRest: executeAndParse done, object name " + o.getClass().getName());
				Serializable returnedObject = this.executeAndParse(serviceModel);
				if(serviceModel.getBroadcastNotification() != null) 
					this.sendIntentBroadcast(serviceModel.getBroadcastNotification(), returnedObject);
				if(serviceModel.getContentProviderUri() != null)
					this.sendToContentProvider(Uri.parse(serviceModel.getContentProviderUri().toString()), returnedObject);
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
	
	private UkaEvent executeAndParse(ServiceModel serviceModel) {
		Log.v(debug, "Inside executeAndParse");
		UkaEvent e = new UkaEvent(); 
		
		e.setId(11);
	/*	e.setShowingTime(new Date("2011-10-03 13:37")); 
		e.setPublishTime(new Date("2011-10-03 13:37")); 
		e.setPublishTime(new Date("2011-10-03 13:37"));
		e.setPublishTime(new Date("2011-10-03 13:37"));
		*/
		e.setPlace("Samfundet"); 
		e.setEventId(10); 
		e.setFree(false); 
		e.setCanceled(false);
		e.setEntranceId(10); 
		e.setTitle("Konsert 1"); 
		e.setLead("Lead 1");
		e.setText("Dette er et arrangement!"); 
		e.setEventType("Konsert");
		e.setImage("bilde1.jpg"); 
		e.setThumbnail("thumb1.jpg");
		e.setAgeLimit(23); 
		e.setDetailPhotoId(0);
		Log.v(debug, "executeAndParse: returning " + e.toString());
		return e; 
	}
	
	/*
	private Serializable executeAndParse(ServiceModel serviceModel) {
		restMethod.setUri(serviceModel.getUri());
		String response = "";
		try {
			Log.v(debug, "executeAndParse: ServiceModel " + serviceModel.toString());
			response = restMethod.get(serviceModel.getDataformat());
			
			Log.v(debug, "executeAndParse: Response " + response);
			UkaEvent event = (UkaEvent) gson.fromJson(response, UkaEvent.class);
			Log.v(debug, "executeAndParse: Serializable " + event.toString());
			return event;
		} catch (Exception e) {
			Log.v(debug, "executeAndParse: Exception " + e.getMessage());
			return e; 
		}
	}
	*/
	
	private void sendToContentProvider(Uri uri, Serializable object) {
		Log.v(debug, "sendToContentProvider: serializable object " + object.getClass().getName());
		ContentResolver cr = context.getContentResolver(); 
		ContentValues cv = new ContentValues(ContentHelper.getContentValues(object)); 
		cr.insert(uri, cv);
	}
	
	private void sendIntentBroadcast(String intentString, Serializable obj) {
		Log.v(debug, "sendIntentBroadcast: sending broadcast");
		Log.v(debug, "sendIntentBroadcast: object name " + obj.getClass().getName());
		Intent broadcastedIntent = new Intent(); 
		broadcastedIntent.putExtra("return", obj);
		broadcastedIntent.setAction(intentString);
		
		context.sendBroadcast(broadcastedIntent);
	}
}
