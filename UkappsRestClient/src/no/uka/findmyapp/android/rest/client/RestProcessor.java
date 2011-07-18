package no.uka.findmyapp.android.rest.client;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

import no.uka.findmyapp.android.rest.datamodels.core.ServiceModel;
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

// TODO: Auto-generated Javadoc
/**
 * The Class RestProcessor.
 */
public class RestProcessor {
	
	/** The Constant debug. */
	private static final String TAG = "RestProcessor"; 
	
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
		Log.v(TAG, "Inside RestProcessor creator");
		this.context = context; 
		this.restMethod = new RestMethod();
		this.gson = new GsonBuilder().create();
	}
	
	/**
	 * Call rest.
	 *
	 * @param serviceModel the service model
	 */
	public void callRest(ServiceModel serviceModel) {
		
		
		switch(serviceModel.getHttpType()) {
			case GET :
				Log.v(TAG, "callRest: trying executeAndParese " + serviceModel);
				Object o = this.executeAndParse(serviceModel);
				
				Log.v(TAG, "callRest: executeAndParse done, object name " + o.getClass().getName());
				Serializable returnedObject = this.executeAndParse(serviceModel);
				if(serviceModel.getBroadcastNotification() != null) 
					this.sendIntentBroadcast(
							serviceModel.getBroadcastNotification(), returnedObject);
				
				if(serviceModel.getContentProviderUri() != null)
					this.sendToContentProvider(
							Uri.parse(serviceModel.getContentProviderUri().toString()), returnedObject);
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
			Log.v(TAG, "executeAndParse: ServiceModel " + serviceModel.toString());
			response = restMethod.get(serviceModel.getDataformat());
			Log.v(TAG, "executeAndParse: Response " + response);
			Serializable s = (Serializable)gson.fromJson(
					response, (Type) TypeToken.get(Class.forName(serviceModel.getReturnType())).getType());
			
			Log.v(TAG, "executeAndParse: Serializable " + s.toString());
			return s;
		} catch (Exception e) {
			// TODO Fix return
			Log.v(TAG, "executeAndParse: Exception " + e.getMessage());
			e.printStackTrace();
			return e; 
		}
	}
	
	/**
	 * Send to content provider.
	 *
	 * @param uri the uri
	 * @param object the object
	 */
	private void sendToContentProvider(Uri uri, Serializable object) {
		Log.v(TAG, "sendToContentProvider: serializable object " + object.getClass().getName());
		ContentResolver cr = context.getContentResolver();
		if(ContentHelper.isList(object)) {
			List<ContentValues> list = ContentHelper.getContentValuesList(object);
			cr.bulkInsert(uri, (ContentValues[])list.toArray());
			/*
			for(ContentValues values : list) {
				cr.insert(uri, values);
			}*/
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
		Log.v(TAG, "sendIntentBroadcast: sending broadcast");
		Log.v(TAG, "sendIntentBroadcast: object name " + obj.getClass().getName());
		Intent broadcastedIntent = new Intent(); 
		broadcastedIntent.putExtra("return", obj);
		broadcastedIntent.setAction(intentString);
		context.sendBroadcast(broadcastedIntent);
	}
}
