package no.uka.findmyapp.android.rest.client;

import java.net.URISyntaxException;

import no.uka.findmyapp.android.rest.datamodels.core.ServiceModel;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * The rest service helper class, a singleton 
 * which exposes a simple asynchronous
 * API to be used by the user interface.
 * 
 * Responsibility
 * 	Prepare and send the Service request:
 * 		- Check if the method is already running
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
	private static final String debug = "RestServiceHelper";
	
	/**
	 * The singleton RestServiceHelper instance
	 */
	private static RestServiceHelper INSTANCE; 
	
	private RestServiceHelper() {
	}
	
	public static RestServiceHelper getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new RestServiceHelper();
			return INSTANCE; 
		}
		return INSTANCE;
	}

	public void callStartService(Context context, ServiceModel serviceModel) {
		Log.v(debug, "Inside callStarteService, using ServiceModel");
		
		Intent selectIntent = new Intent(context, RestIntentService.class);
		Log.v(debug, "callStarteService: selectIntent created");
		
		selectIntent.putExtra(IntentMessages.SERVICE_MODEL_PACKAGE, serviceModel);
		Log.v(debug, "callStarteService: serivce model added to intent");
        
		context.startService(selectIntent);
		Log.v(debug, "callStarteService: context.startSerivce() called");
	}
	
	public void callStartService(Context context, UkappsServices service) 
			throws URISyntaxException, IllegalAccessException, InstantiationException {
		Log.v(debug, "Innside callStartService, using UkappsSerivce");
		ServiceModel sm = UkappServiceFactory.createServiceModel(service);
		Log.v(debug, sm.toString());
		Log.v(debug, "callStartService: preparing ServiceModel: " + sm.toString());
		
		this.callStartService(context, sm);
		Log.v(debug, "callStarteService: called callStartService with ServiceModel");
	}
}
