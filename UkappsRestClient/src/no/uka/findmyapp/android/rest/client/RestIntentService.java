package no.uka.findmyapp.android.rest.client;

import java.util.Date;

import no.uka.findmyapp.android.rest.datamodels.core.ServiceModel;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

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
<<<<<<< HEAD
    public static final String TAG = "RestIntentService";
    private RestProcessor _restProcessor;
=======
    public static final String debug = "RestIntentService";
    
    private RestProcessor restProcessor;
>>>>>>> 82b11cff84cde59f65147417e9ed4f10d2496333

    public RestIntentService() {
        super("RestIntentService");
        this.restProcessor = new RestProcessor(this);
    }

	/* (non-Javadoc)
	 * @see android.app.IntentService#onHandleIntent(android.content.Intent)
	 */
	@Override
	protected void onHandleIntent(Intent intent) {
        Log.v(TAG, "" + new Date() + ", In onHandleIntent for thread id = " + Thread.currentThread().getId());

        Bundle bundle = intent.getExtras();
<<<<<<< HEAD
        ServiceModel serviceModel = (ServiceModel) bundle.get("ServiceModel");

		Log.v(TAG, "onHandleIntent: STARTING URI: " + serviceModel);
		_restProcessor.callRest(serviceModel);
=======
        ServiceModel serviceModel = (ServiceModel) bundle.get(IntentMessages.SERVICE_MODEL_PACKAGE);
		
		Log.v(debug, "onHandleIntent: Sending " + serviceModel + " to the rest processor");
		this.restProcessor.callRest(serviceModel);
>>>>>>> 82b11cff84cde59f65147417e9ed4f10d2496333
		
		Log.v(TAG, "onHandleIntent: DONE HandleIntent");
        Log.v(TAG, "" + new Date() + ", This thread is waked up.");
	}
	
	/* (non-Javadoc)
	 * @see android.app.IntentService#onCreate()
	 */
	@Override
    public void onCreate() {
    	super.onCreate();
    	Log.v(TAG,"onCreate: service started");
    }
	
    /* (non-Javadoc)
     * @see android.app.IntentService#onStartCommand(android.content.Intent, int, int)
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
    	super.onStartCommand(intent, flags, startId);
        Log.i(TAG, "Received start id " + startId + ": " + intent);
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
    }
}
