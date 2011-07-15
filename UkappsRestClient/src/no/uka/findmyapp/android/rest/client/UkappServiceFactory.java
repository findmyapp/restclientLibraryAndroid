package no.uka.findmyapp.android.rest.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import no.uka.findmyapp.android.rest.client.model.ServiceModel;
import no.uka.findmyapp.android.rest.contracts.UkaEvents.UkaEventContract;
import no.uka.findmyapp.android.rest.datamodels.Temperature;
import no.uka.findmyapp.android.rest.datamodels.UkaEvent;

import com.google.gson.reflect.TypeToken;

public class UkappServiceFactory {
	
	public static ServiceModel createServiceModel(UkappsServices service) throws URISyntaxException {
		// TODO FIX EVERYTHING
		// TODO parse xml file with predefined services, and use naming reflection to init correct serviceModel.
		
		switch (service) {
		case UKAEVENTS:
			return new ServiceModel(
				new URI("http://findmyapp.net/findmyapp/program/uka11/events"),
				HttpType.GET, 
				ServiceDataFormat.JSON, 
				new TypeToken<List<UkaEvent>>(){}.getClass(), 
				new URI(UkaEventContract.EVENT_CONTENT_URI.toString()) ,
				BroadcastTokens.BROADCAST_INTENT_TOKEN
				);

		case TEMPERATURE_SAMPLE:
			return new ServiceModel(
				new URI("http://findmyapp.net/findmyapp/locations/1/temperature/latest"),
				HttpType.GET, 
				ServiceDataFormat.JSON, 
				new TypeToken<List<UkaEvent>>(){}.getClass(), 
				new URI(UkaEventContract.EVENT_CONTENT_URI.toString()) ,
				BroadcastTokens.BROADCAST_INTENT_TOKEN
				);
		default:
			break;
		}
		
		return null;
	}
}
