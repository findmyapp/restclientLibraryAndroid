package no.uka.findmyapp.android.rest.client;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URISyntaxException;

import org.apache.http.entity.SerializableEntity;

import no.uka.findmyapp.android.rest.client.model.ServiceModel;
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

	public void startServiceTest(Context context, ServiceModel serviceModel) {
		Log.v("DEBUG", "HERE3");
		Intent selectIntent = new Intent(context, RestIntentService.class);
		Log.v("DEBUG", "HERE4");
		selectIntent.putExtra("ServiceModel", serviceModel);
		Log.v("DEBUG", "HERE5");
        context.startService(selectIntent);
		Log.v("DEBUG", "HERE6");
	}
	
	public void startServiceTest(Context context, UkappsServices service) throws URISyntaxException {
		Log.v("DEBUG", "HERE2");
		ServiceModel sm = UkappServiceFactory.createServiceModel(service);
		Log.v("DEBUG startServiceTest", sm.toString());
		this.startServiceTest(context, sm);
	}
	
}
