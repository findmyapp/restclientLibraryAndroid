/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.client;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import no.uka.findmyapp.android.rest.contracts.UkaEvents.UkaEventContract;
import no.uka.findmyapp.android.rest.datamodels.core.ServiceModel;
import no.uka.findmyapp.android.rest.datamodels.enums.HttpType;
import no.uka.findmyapp.android.rest.helpers.ContentHelper;

import org.json.JSONArray;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

// TODO: Auto-generated Javadoc
/**
 * The Class RestProcessor.
 */
public class RestProcessor {
	
	/** The Constant debug. */
	private static final String debug = "RestProcessor"; 
	
	/** The rest method. */
	private RestMethod restMethod;
	
	/** The gson. */
	private Gson gson;
	
	/** The context. */
	private Context context; 
	
	/**
	 * Instantiates a new rest processor.
	 *
	 * @param context the context
	 */
	public RestProcessor(Context context) {
		Log.v(debug, "Inside RestProcessor creator");
		
		this.restMethod = new RestMethod();
		this.gson = new GsonBuilder().create();
		this.context = context; 
	}
	
	/**
	 * Call rest.
	 *
	 * @param serviceModel the service model
	 */
	public void callRest(ServiceModel serviceModel) {
		Log.v(debug, "Inside callRest");
		switch(serviceModel.getHttpType()) {
			case GET :
				Serializable returnedObject = this.executeAndParse(serviceModel);
				Log.v(debug, "callRest: executeAndParse, object name " + returnedObject.getClass().getName());
				if(serviceModel.getContentProviderUri() != null) {
					Log.v(debug, "callRest using content provider " + serviceModel.getContentProviderUri().toString());
					this.sendToContentProvider(Uri.parse(serviceModel.getContentProviderUri().toString()), returnedObject, serviceModel.getReturnType());
				}
				if(serviceModel.getBroadcastNotification() != null) {
					Log.v(debug, "callRest broadcasting notification " + serviceModel.getBroadcastNotification());
					this.sendIntentBroadcast(serviceModel.getBroadcastNotification(), returnedObject);
				}
			break;
			case POST :
				Serializable postReturnedObject = this.executeAndParse(serviceModel);
				Log.v(debug, "callRest: executeAndParse, object name " + postReturnedObject.getClass().getName());
				if(serviceModel.getContentProviderUri() != null) {
					Log.v(debug, "callRest using content provider " + serviceModel.getContentProviderUri().toString());
					this.sendToContentProvider(Uri.parse(serviceModel.getContentProviderUri().toString()), postReturnedObject, serviceModel.getReturnType());
				}
				if(serviceModel.getBroadcastNotification() != null) {
					Log.v(debug, "callRest broadcasting notification " + serviceModel.getBroadcastNotification());
					this.sendIntentBroadcast(serviceModel.getBroadcastNotification(), postReturnedObject);
				}
			break;
		}
	}
	
	/**
	 * Execute and parse.
	 *
	 * @param serviceModel the service model
	 * @return the serializable
	 */
	private Serializable executeAndParse(ServiceModel serviceModel) {
		restMethod.setUri(serviceModel.getUri());
		String response = "";
		try {
			Log.v(debug, "executeAndParse: ServiceModel " + serviceModel.toString());
			response = execute(serviceModel);
			Log.v(debug, "executeAndParse: Response " + response);
			Serializable s = null;
			
			if(serviceModel.getReturnType() != null) {
				String returnType = serviceModel.getReturnType();
				if(returnType.indexOf(".") == -1) {
					//TODO Constant?
					returnType = "no.uka.findmyapp.android.rest.datamodels.models." + returnType;
				}
				//no.uka.findmyapp.android.rest.datamodels.models
				Class theClass = Class.forName(returnType);
				new TypeToken<Object>(){};
				Type t1 = TypeToken.get(theClass).getType();;
				if(response.substring(0,1).equals("[")) {
					Log.v(debug, "executeAndParse: Is list");
					JSONArray array = new JSONArray(response);
					List<Serializable> list = new ArrayList<Serializable>();
					for (int i = 0; i < array.length(); i++) {
						list.add((Serializable)gson.fromJson(array.get(i).toString(), t1));
					}
					s = (Serializable) list;
					Log.v(debug, "executeAndParse: Serializable " + s.toString());
				} else {
					Log.v(debug, "executeAndParse: Is not list");
					s = (Serializable)gson.fromJson(response, t1);
					Log.v(debug, "executeAndParse: Serializable " + s.toString());
				}
			}
			
			return s;
		} catch (Exception e) {
			// TODO Fix return
			Log.v(debug, "executeAndParse: Exception " + e.getMessage());
			e.printStackTrace();
			
			return e; 
		}
	}
	
	private String execute(ServiceModel serviceModel) throws Exception {
		if(serviceModel.getHttpType() == HttpType.GET) {
			return restMethod.get(serviceModel.getDataformat());
		}
		else if (serviceModel.getHttpType() == HttpType.POST) {
			Gson gson = new Gson();
			return restMethod.post(gson.toJson(serviceModel.getData()));
		}
		throw new Exception("Unknown HTTP-type"); 
	}
	
	/**
	 * Send to content provider.
	 *
	 * @param uri the uri
	 * @param object the object
	 * @param returnType the return type
	 */
	private void sendToContentProvider(Uri uri, Serializable object, String returnType) {
		Log.v(debug, "sendToContentProvider: serializable object " + object.getClass().getName());

		ContentResolver cr = context.getContentResolver();
		
		if(object instanceof List) {
			List<ContentValues> list = ContentHelper.getContentValuesList(object, returnType);
			Log.v(debug, "parsing contentvalue array");
			ContentValues[] cva = new ContentValues[list.size()];
			for(ContentValues cv : list) {
				cva[list.indexOf(cv)] = cv; 
			}
			Log.v(debug, cva.toString());
			cr.bulkInsert( UkaEventContract.EVENT_CONTENT_URI, cva);
		} else {
			ContentValues cv = new ContentValues(ContentHelper.getContentValues(object)); 
			cr.insert(uri, cv);
			
		}
	}
	
	/**
	 * Send intent broadcast.
	 *
	 * @param intentString the intent string
	 * @param obj the obj
	 */
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
