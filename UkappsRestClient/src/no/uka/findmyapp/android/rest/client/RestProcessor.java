package no.uka.findmyapp.android.rest.client;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

import no.uka.findmyapp.android.rest.client.model.ServiceModel;
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
		
		this.restMethod = new RestMethod();
		this.gson = new GsonBuilder().create();
		this.context = context; 
	}
	
	public void callRest(ServiceModel serviceModel) {
		Log.v(debug, "Inside callRest");
		switch(serviceModel.getHttpType()) {
			case GET :
				Serializable returnedObject = this.executeAndParse(serviceModel);
				Log.v(debug, "callRest: executeAndParse, object name " + returnedObject.getClass().getName());

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
			Log.v(debug, "executeAndParse: ServiceModel " + serviceModel.toString());
			response = restMethod.get(serviceModel.getDataformat());
			Log.v(debug, "executeAndParse: Response " + response);
			
			Class theClass = Class.forName(serviceModel.getReturnType());
			Type t1 = (Type) new TypeToken<Object>(){}.get(theClass).getType();
			
			Serializable s = (Serializable)gson.fromJson(response, t1);
			Log.v(debug, "executeAndParse: Serializable " + s.toString());
			
			return s;
		} catch (Exception e) {
			// TODO Fix return
			Log.v(debug, "executeAndParse: Exception " + e.getMessage());
			e.printStackTrace();
			
			return e; 
		}
	}
	
	private void sendToContentProvider(Uri uri, Serializable object) {
		Log.v(debug, "sendToContentProvider: serializable object " + object.getClass().getName());

		ContentResolver cr = context.getContentResolver();
		if(ContentHelper.isList(object)) {
			List<ContentValues> list = ContentHelper.getContentValuesList(object);
			
			Log.v(debug, "parsing contentvalue array");
			ContentValues[] cva = new ContentValues[list.size()];
			for(ContentValues cv : list) {
				cva[list.indexOf(cv)] = cv; 
			}
			Log.v(debug, cva.toString());
			cr.bulkInsert(uri, cva);
		} else {
			ContentValues cv = new ContentValues(ContentHelper.getContentValues(object)); 
			cr.insert(uri, cv);
		}
	}
	
	private void sendIntentBroadcast(String intentString, Serializable obj) {
		Log.v(debug, "sendIntentBroadcast: sending broadcast, object name " + obj.getClass().getName());
		
		Intent broadcastedIntent = new Intent(); 
		broadcastedIntent.putExtra(IntentMessages.BROADCAST_RETURN_VALUE_NAME, obj);
		broadcastedIntent.setAction(intentString);
		Log.v(debug, "sendIntentBroadcast: broadcast action " + intentString);
		Log.v(debug, "sendIntentBroadcast: broadcast sent, extradata identifier: " + IntentMessages.BROADCAST_RETURN_VALUE_NAME);
		
		context.sendBroadcast(broadcastedIntent);
	}
}
