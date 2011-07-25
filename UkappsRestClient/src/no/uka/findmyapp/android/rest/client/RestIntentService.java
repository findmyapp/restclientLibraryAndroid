/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.client;

import java.util.Date;

import no.uka.findmyapp.android.rest.datamodels.core.ServiceModel;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

// TODO: Auto-generated Javadoc
/**
 * The RestService is able to recieve Intents sent
 * from the {@link RestServiceHelper} and starts
 * the corresponding {@link RestMethod}
 * 
 * Responsibility: 
 * 	- Ensure that the restmethods are called
 *	- Handle the {@link RestProcessor} callback, and 
 *	  invoke {@link RestServiceHelper} binder callback.
 *	- Implement queue of request tasks.
 */

public class RestIntentService extends IntentService {
    
    /** The Constant debug. */
    public static final String debug = "RestIntentService";
    
    /** The rest processor. */
    private RestProcessor restProcessor;

    /**
     * Instantiates a new rest intent service.
     */
    public RestIntentService() {
        super("RestIntentService");
        this.restProcessor = new RestProcessor(this);
    }

	/* (non-Javadoc)
	 * @see android.app.IntentService#onHandleIntent(android.content.Intent)
	 */
	@Override
	protected void onHandleIntent(Intent intent) {
    	Log.v(debug,"Inside onHandleIntent");
        Log.v(debug, "" + new Date() + ", In onHandleIntent for thread id = " + Thread.currentThread().getId());

        Bundle bundle = intent.getExtras();
        Log.v(debug, "onHandleIntent bundle recived");
        ServiceModel serviceModel = (ServiceModel) bundle.get(IntentMessages.SERVICE_MODEL_PACKAGE);
		
		Log.v(debug, "onHandleIntent: Sending " + serviceModel + " to the rest processor");
		this.restProcessor.callRest(serviceModel);
		
		Log.v(debug, "onHandleIntent: DONE HandleIntent");
        Log.v(debug, "" + new Date() + ", This thread is waked up.");
	}
	
	/* (non-Javadoc)
	 * @see android.app.IntentService#onCreate()
	 */
	@Override
    public void onCreate() {
    	super.onCreate();
    	Log.v(debug,"onCreate: service started");
    }
	
    /* (non-Javadoc)
     * @see android.app.IntentService#onStartCommand(android.content.Intent, int, int)
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
    	super.onStartCommand(intent, flags, startId);
        Log.i("LocalService", "Received start id " + startId + ": " + intent);
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.
        //TODO THINK THIS WORKS....
        return START_STICKY;
    }

    /* (non-Javadoc)
     * @see android.app.IntentService#onDestroy()
     */
    @Override
    public void onDestroy() {
    	super.onDestroy();
    	//TODO
        // Tell the user we stopped.
        //Toast.makeText(this, R.string.rest_service_stopped, Toast.LENGTH_SHORT).show();
    }
}
