package no.uka.findmyapp.android.rest.client;

import java.net.URISyntaxException;

import no.uka.findmyapp.android.rest.datamodels.core.ServiceModel;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

// TODO: Auto-generated Javadoc
/**
 * The rest service helper class, a singleton 
 * which exposes a simple asynchronous
 * API to be used by the user interface.
 * 
 * Responsibility
 * 	Prepare and send the Service request:
 * 		- Create the requested Intent
 * 		- Add the operation type and a unique request id
 * 		- Add the method specific parameters
 * 		- Add the binder callback
 * 		- Call {@link RestService#startService()}
 * 		- Return the request id
 *  Handle the callback from the service
 *  	- Dispatch callbacks to the user interface listeners
 */
public class RestServiceHelper {
	
	/** The Constant TAG for logging. */
	private static final String TAG = "RestServiceHelper";
	
	/** The singleton RestServiceHelper instance. */
	private static RestServiceHelper INSTANCE; 
	
	/**
	 * Instantiates a new rest service helper.
	 */
	private RestServiceHelper() {
	}
	
	/**
	 * Gets the single instance of RestServiceHelper.
	 *
	 * @return single instance of RestServiceHelper
	 */
	public static RestServiceHelper getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new RestServiceHelper();
			return INSTANCE; 
		}
		return INSTANCE;
	}

	/**
	 * Start service test.
	 *
	 * @param context the context
	 * @param serviceModel the service model
	 */
	public void startService(Context context, ServiceModel serviceModel) {
		Log.v(TAG, "Prepare startService - Starting");
		Intent selectIntent = new Intent(context, RestIntentService.class);
		selectIntent.putExtra("ServiceModel", serviceModel);
        context.startService(selectIntent);
	}
	
	/**
	 * Start service test.
	 *
	 * @param context the context
	 * @param service the service
	 * @throws URISyntaxException the uRI syntax exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws InstantiationException the instantiation exception
	 */
	public void startService(Context context, UkappsServices service) throws URISyntaxException, IllegalAccessException, InstantiationException {
		Log.v(TAG, "Prepare startService");
		ServiceModel sm = UkappServiceFactory.createServiceModel(service);
		this.startService(context, sm);
	}
}
