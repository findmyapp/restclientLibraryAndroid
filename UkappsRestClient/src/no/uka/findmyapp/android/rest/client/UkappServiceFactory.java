package no.uka.findmyapp.android.rest.client;

import java.net.URI;
import java.net.URISyntaxException;

import no.uka.findmyapp.android.rest.contracts.UkaEvents.UkaEventContract;
<<<<<<< HEAD
import no.uka.findmyapp.android.rest.datamodels.constants.ServiceDataFormat;
import no.uka.findmyapp.android.rest.datamodels.core.ServiceModel;
import no.uka.findmyapp.android.rest.datamodels.enums.HttpType;
import no.uka.findmyapp.android.rest.datamodels.models.UkaProgram;
=======
import no.uka.findmyapp.android.rest.datamodels.UkaProgram;
>>>>>>> 82b11cff84cde59f65147417e9ed4f10d2496333

public class UkappServiceFactory {
	
	public static ServiceModel createServiceModel(UkappsServices service) throws URISyntaxException, IllegalAccessException, InstantiationException {
		// TODO FIX EVERYTHING
		// TODO parse xml file with predefined services, and use naming reflection to init correct serviceModel.
		
		switch (service) {
		case UKAEVENTS:
			return new ServiceModel(
				new URI("http://findmyapp.net/findmyapp/program/uka11/events"),
				HttpType.GET, 
				ServiceDataFormat.JSON, 
				UkaProgram.class,
				null,
				UkaEventContract.EVENT_CONTENT_URI,
				IntentMessages.BROADCAST_INTENT_TOKEN);
		default:
			break;
		}
		
		return null;
	}
}
