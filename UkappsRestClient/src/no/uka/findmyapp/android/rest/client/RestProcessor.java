package no.uka.findmyapp.android.rest.client;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

<<<<<<< HEAD
import no.uka.findmyapp.android.rest.datamodels.core.ServiceModel;
=======
import no.uka.findmyapp.android.rest.client.model.ServiceModel;
>>>>>>> 82b11cff84cde59f65147417e9ed4f10d2496333
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
<<<<<<< HEAD
		Log.v(TAG, "Inside RestProcessor creator");
		this.context = context; 
		this.restMethod = new RestMethod();
		this.gson = new GsonBuilder().create();
=======
		Log.v(debug, "Inside RestProcessor creator");
		
		this.restMethod = new RestMethod();
		this.gson = new GsonBuilder().create();
		this.context = context; 
>>>>>>> 82b11cff84cde59f65147417e9ed4f10d2496333
	}
	
	/**
	 * Call rest.
	 *
	 * @param serviceModel the service model
	 */
	public void callRest(ServiceModel serviceModel) {
<<<<<<< HEAD
		
		
		switch(serviceModel.getHttpType()) {
			case GET :
				Log.v(TAG, "callRest: trying executeAndParese " + serviceModel);
				Object o = this.executeAndParse(serviceModel);
				
				Log.v(TAG, "callRest: executeAndParse done, object name " + o.getClass().getName());
=======
		Log.v(debug, "Inside callRest");
		switch(serviceModel.getHttpType()) {
			case GET :
>>>>>>> 82b11cff84cde59f65147417e9ed4f10d2496333
				Serializable returnedObject = this.executeAndParse(serviceModel);
				Log.v(debug, "callRest: executeAndParse, object name " + returnedObject.getClass().getName());

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
	
<<<<<<< HEAD
	/**
	 * Execute and parse.
	 *
	 * @param serviceModel the service model
	 * @return the serializable
	 */
=======
>>>>>>> 82b11cff84cde59f65147417e9ed4f10d2496333
	private Serializable executeAndParse(ServiceModel serviceModel) {
		restMethod.setUri(serviceModel.getUri());
		String response = "";
		try {
			Log.v(TAG, "executeAndParse: ServiceModel " + serviceModel.toString());
			response = restMethod.get(serviceModel.getDataformat());
<<<<<<< HEAD
			Log.v(TAG, "executeAndParse: Response " + response);
			Serializable s = (Serializable)gson.fromJson(
					response, (Type) TypeToken.get(Class.forName(serviceModel.getReturnType())).getType());
			
			Log.v(TAG, "executeAndParse: Serializable " + s.toString());
=======
			Log.v(debug, "executeAndParse: Response " + response);
			
			Class theClass = Class.forName(serviceModel.getReturnType());
			Type t1 = (Type) new TypeToken<Object>(){}.get(theClass).getType();
			
			Serializable s = (Serializable)gson.fromJson(response, t1);
			Log.v(debug, "executeAndParse: Serializable " + s.toString());
			
>>>>>>> 82b11cff84cde59f65147417e9ed4f10d2496333
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
<<<<<<< HEAD
		Log.v(TAG, "sendToContentProvider: serializable object " + object.getClass().getName());
=======
		Log.v(debug, "sendToContentProvider: serializable object " + object.getClass().getName());

>>>>>>> 82b11cff84cde59f65147417e9ed4f10d2496333
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
<<<<<<< HEAD
		Log.v(TAG, "sendIntentBroadcast: sending broadcast");
		Log.v(TAG, "sendIntentBroadcast: object name " + obj.getClass().getName());
=======
		Log.v(debug, "sendIntentBroadcast: sending broadcast, object name " + obj.getClass().getName());
		
>>>>>>> 82b11cff84cde59f65147417e9ed4f10d2496333
		Intent broadcastedIntent = new Intent(); 
		broadcastedIntent.putExtra(IntentMessages.BROADCAST_RETURN_VALUE_NAME, obj);
		broadcastedIntent.setAction(intentString);
<<<<<<< HEAD
=======
		Log.v(debug, "sendIntentBroadcast: broadcast sent, extradata identifier: " + IntentMessages.BROADCAST_RETURN_VALUE_NAME);
		
>>>>>>> 82b11cff84cde59f65147417e9ed4f10d2496333
		context.sendBroadcast(broadcastedIntent);
	}
}
