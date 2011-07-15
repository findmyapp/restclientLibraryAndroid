package no.uka.findmyapp.android.rest.client;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Collection;
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
				Object o = this.executeAndParse(serviceModel);
				
				Log.v("PROCESSOR", o.getClass().getName());
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
	
	private Serializable executeAndParse(ServiceModel serviceModel) {
		restMethod.setUri(serviceModel.getUri());
		String response = "";
		try {
			Log.v("PROCESSOR", "EXECUTE: SM : " + serviceModel.toString());
			response = restMethod.get(serviceModel.getDataformat());
			Log.v("PROCESSOR", "EXECUTE: R : " + response);
			Class theClass = Class.forName(serviceModel.getReturnType());
			Type t1 = (Type) new TypeToken<Object>(){}.get(theClass).getType();
			
			Serializable s = (Serializable)gson.fromJson(response, t1);
			Log.v("PROCESSOR", "EXECUTE: R : " + s.toString());
			return s;
		} catch (Exception e) {
			// TODO Fix return
			e.printStackTrace();
			return e; 
		}
	}
	
	private void sendToContentProvider(Uri uri, Serializable object) {
		Log.v("DEBUG _ REST", object.getClass().getName());
		ContentResolver cr = context.getContentResolver();
		if(ContentHelper.isList(object)) {
			List<ContentValues> list = ContentHelper.getContentValuesList(object);
			for(ContentValues values : list) {
				cr.insert(uri, values);
			}
		} else {
			ContentValues cv = new ContentValues(ContentHelper.getContentValues(object)); 
			cr.insert(uri, cv);
		}
		
		
	}
	
	private void sendIntentBroadcast(String intentString, Serializable obj) {
		Log.v("RestProcessor", "sending broadcast");
		Log.v("DEBUG _ REST", obj.getClass().getName());
		Intent broadcastedIntent = new Intent(); 
		broadcastedIntent.putExtra("return", obj);
		broadcastedIntent.setAction(intentString);
		
		context.sendBroadcast(broadcastedIntent);
	}
}
