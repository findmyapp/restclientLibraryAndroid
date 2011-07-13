package no.uka.findmyapp.android.rest.client;

import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import no.uka.findmyapp.android.rest.client.model.ServiceModel;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

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
					this.sendToContentProvider(serviceModel.getContentProviderUri(), this.executeAndParse(serviceModel));
				
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
	
	//TODO implement method
	private void sendToContentProvider(Uri uri, Object obj) {
		
	}
	
	private void sendIntentBroadcast(String intentString, Serializable obj) {
		Log.v("RestProcessor", "sending broadcast");
		Intent broadcastedIntent = new Intent(); 
		broadcastedIntent.putExtra("return", (Serializable) obj);
		broadcastedIntent.setAction(intentString);
		
		context.sendBroadcast(broadcastedIntent);
	}
}
