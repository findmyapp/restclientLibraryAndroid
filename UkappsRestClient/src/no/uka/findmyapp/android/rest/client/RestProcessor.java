/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.client;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import no.uka.findmyapp.android.rest.client.RestMethod.HTTPStatusException;
import no.uka.findmyapp.android.rest.datamodels.core.Credentials;
import no.uka.findmyapp.android.rest.datamodels.core.ServiceModel;
import no.uka.findmyapp.android.rest.datamodels.enums.HttpType;
import no.uka.findmyapp.android.rest.helpers.ContentHelper;

import org.apache.http.HttpException;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
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
	
	/** The Constant sModelPackage. */
	private static final String sModelPackage = 
		"no.uka.findmyapp.android.rest.datamodels.models.";
	
	/** The m rest method. */
	private RestMethod mRestMethod;
	
	/** The m gson. */
	private Gson mGson;
	
	/** The m context. */
	private Context mContext; 
	
	/** The m credentials. */
	private Credentials mCredentials;
	
	/**
	 * Instantiates a new rest processor.
	 *
	 * @param context the context
	 * @param credentials the credentials
	 */
	public RestProcessor(Context context, Credentials credentials) {
		Log.v(debug, "Inside RestProcessor creator");
		Log.v(debug, "credentials " + credentials.toString());
		
		mRestMethod = new RestMethod(credentials);
		mGson = new GsonBuilder().create();
		mContext = context; 
	}
	
	/**
	 * Call rest.
	 *
	 * @param serviceModel the service model
	 * @param userToken the user token
	 */
	public void callRest(ServiceModel serviceModel, String userToken) {
		Log.v(debug, "Inside callRest");
		try {
			switch(serviceModel.getHttpType()) {
				case GET :
					Serializable returnedObject
						= executeAndParse(serviceModel, userToken);
					saveAndReturnData(serviceModel, returnedObject);
				break;
				case POST :
					Serializable postReturnedObject 
						= executeAndParse(serviceModel, userToken);
					saveAndReturnData(serviceModel, postReturnedObject);
				break;
			}
		}
		catch (HTTPStatusException e) {
			sendIntentBroadcast(IntentMessages.BROADCAST_HTTP_STATUS_EXCEPTION, e);
		}
	}

	/**
	 * Save and return data.
	 *
	 * @param serviceModel the service model
	 * @param returnedObject the returned object
	 */
	private void saveAndReturnData(ServiceModel serviceModel,
			Serializable returnedObject) {
		if(serviceModel.getContentProviderUri() != null) {
			try {
				if(isInstanceOfJavaNativeType(Class.forName(serviceModel.getReturnType())) == false) {
					prepareAndSendToContentProvider(serviceModel, returnedObject);
				}
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		if(serviceModel.getBroadcastNotification() != null) {
			sendIntentBroadcast(serviceModel.getBroadcastNotification(), 
					returnedObject);
		}
	}

	/**
	 * Prepare and send to content provider.
	 *
	 * @param serviceModel the service model
	 * @param returnedObject the returned object
	 */
	private void prepareAndSendToContentProvider(ServiceModel serviceModel,
			Serializable returnedObject) {
		sendToContentProvider(Uri.parse(
			serviceModel.getContentProviderUri().toString()),
			returnedObject, serviceModel.getReturnType());
	}
	
	/**
	 * Execute and parse.
	 *
	 * @param serviceModel the service model
	 * @param userToken the user token
	 * @return the serializable
	 * @throws HTTPStatusException the hTTP status exception
	 */
	private Serializable executeAndParse(ServiceModel serviceModel, String userToken) 
			throws HTTPStatusException {
		mRestMethod.setUri(createURI(serviceModel, userToken));
		String response = httpRequest(serviceModel);
			
		Serializable s = null;
		
		if(serviceModel.getReturnType() != null) {
			String returnType = serviceModel.getReturnType();
			if(returnType.indexOf(".") == -1) {
				returnType = sModelPackage + returnType;
			}
			//no.uka.findmyapp.android.rest.datamodels.models
			Class theClass;
			try {
				theClass = Class.forName(returnType);
			} catch (ClassNotFoundException e) {
				Log.e(debug, e.getMessage() 
						+ " Returning data in String format!");
				return response; 
			}
			new TypeToken<Object>(){};
			Type t1 = TypeToken.get(theClass).getType();;
			try {
				s = parseFromJson(response, t1);
			} catch (JSONException e) {
				Log.e(debug, e.getMessage() 
						+ " Returning data in String format!");
				return response; 
			}
		}
		else {
			return response; 
		}
		
		return s;
	}
	
	/**
	 * Creates the uri.
	 *
	 * @param serviceModel the service model
	 * @param userToken the user token
	 * @return the uRI
	 */
	private URI createURI(ServiceModel serviceModel, String userToken) {
		String tempUri; 
		if(serviceModel.getParameters() != null) {
			tempUri = serviceModel.getUri().toString().replace("??", "%s");
			tempUri = String.format(tempUri, serviceModel.getParameters());
		}
		else {
			tempUri = serviceModel.getUri().toString();
		}
		//tempUri = tempUri + "?token=" + URLEncoder.encode(userToken);
		Log.v(debug, "URI with params " + tempUri);
		
		URI returURI;
		try {
			returURI = new URI(tempUri);
		}
		catch (URISyntaxException e) {
			Log.e(debug, e.getMessage());
			return null; 
		}
		return returURI; 
	}

	/**
	 * Http request.
	 *
	 * @param serviceModel the service model
	 * @return the string
	 * @throws HTTPStatusException the hTTP status exception
	 */
	private String httpRequest(ServiceModel serviceModel)
			throws HTTPStatusException {
		String response = "";
			Log.v(debug, "executeAndParse: ServiceModel " + serviceModel.toString());
			try {
				response = execute(serviceModel);
			} catch (HTTPStatusException e) {
				Log.v(debug, "executeAndParse: Exception " + e.getMessage());
				throw e; 
			}
		return response;
	}

	/**
	 * Parses the from json.
	 *
	 * @param response the response
	 * @param t1 the t1
	 * @return the serializable
	 * @throws JSONException the jSON exception
	 */
	private Serializable parseFromJson(String response, Type t1)
			throws JSONException {
		Serializable s;
		if(response.substring(0,1).equals("[")) {
			s = parseListFromJson(response, t1);
		} else {
			Log.v(debug, "executeAndParse: Is not list");
			s = (Serializable)mGson.fromJson(response, t1);
			Log.v(debug, "executeAndParse: Serializable " 
					+ s.toString());
		}
		return s;
	}

	/**
	 * Parses the list from json.
	 *
	 * @param response the response
	 * @param t1 the t1
	 * @return the serializable
	 * @throws JSONException the jSON exception
	 */
	private Serializable parseListFromJson(String response, Type t1)
			throws JSONException {
		Serializable s;
		Log.v(debug, "executeAndParse: Is list");
		JSONArray array = new JSONArray(response);
		List<Serializable> list = new ArrayList<Serializable>();
		for (int i = 0; i < array.length(); i++) {
			list.add((Serializable)mGson.fromJson(array.get(i).toString(), t1));
		}
		s = (Serializable) list;
		Log.v(debug, "executeAndParse: Serializable " + s.toString());
		return s;
	}
	
	/**
	 * Execute.
	 *
	 * @param serviceModel the service model
	 * @return the string
	 * @throws HTTPStatusException the hTTP status exception
	 */
	private String execute(ServiceModel serviceModel) throws HTTPStatusException {
		if(serviceModel.getHttpType() == HttpType.GET) {
			return mRestMethod.get();
		}
		else if (serviceModel.getHttpType() == HttpType.POST) {
			Gson gson = new Gson();
			return mRestMethod.post(gson.toJson(serviceModel.getData()));
		}
		return null; 
	}
	
	/**
	 * Send to content provider.
	 *
	 * @param contentProviderUri the content provider uri
	 * @param object the object
	 * @param returnType the return type
	 */
	private void sendToContentProvider(Uri contentProviderUri, 
			Serializable object, String returnType) {
		
		Log.v(debug, "sendToContentProvider: serializable object " + object.getClass().getName());
		Log.v(debug, "sendToContentProvider: returnType " + returnType);

		ContentResolver cr = mContext.getContentResolver();
	
		Log.v(debug, "object " + object.toString());
		if(object instanceof List) {
			Class theClass = null;
			try {
				theClass = Class.forName(returnType);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			List<ContentValues> list = 
					ContentHelper.getContentValuesList(object, theClass);
			
			// parsing contentvalue list to contentvalues array
			Log.v(debug, "sizeof arraylist " + list.size());
			
			ContentValues[] cva = new ContentValues[list.size()];
			for(ContentValues cv : list) {
				cva[list.indexOf(cv)] = cv; 
			}
			
			// bulk inserts the contentvalue array 
			try {
				cr.bulkInsert(contentProviderUri, cva);
			}
			catch (SQLException e) {
				Log.e(debug, e.getMessage()); 
				throw e; 
			}
		} else {
			ContentValues cv = new ContentValues(ContentHelper.getContentValues(object)); 
			cr.insert(contentProviderUri, cv);
		}
	}
	
	/**
	 * Checks if is instance of java native type.
	 *
	 * @param object the object
	 * @return true, if is instance of java native type
	 */
	private boolean isInstanceOfJavaNativeType(Serializable object) {
		Log.v(debug, "Type of " + object.toString());
		if(object instanceof String || object instanceof Integer) {
			return true; 
		}
		Log.v(debug, "isInstanceOfJavaNativeType: false");
		return false; 
	}
	
	/**
	 * Send intent broadcast.
	 *
	 * @param intentString the intent string
	 * @param obj the obj
	 */
	private void sendIntentBroadcast(String intentString, Serializable obj) {
		Log.v(debug, 
				"sendIntentBroadcast: sending broadcast identifier " 
				+ intentString);
		Log.v(debug, 
				"sendIntentBroadcast: broadcast sent, extradata identifier: " 
				+ IntentMessages.BROADCAST_RETURN_PAYLOAD_ID);
		Log.v(debug, 
				"sendIntentBroadcast: Putting extra " + obj.toString());
	
		Intent broadcastedIntent = new Intent(); 
		broadcastedIntent.putExtra(IntentMessages.BROADCAST_RETURN_PAYLOAD_ID, obj);
		broadcastedIntent.setAction(intentString);

		mContext.sendBroadcast(broadcastedIntent);
	}
}
