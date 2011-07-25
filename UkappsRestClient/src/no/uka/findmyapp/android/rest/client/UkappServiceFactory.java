/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import no.uka.findmyapp.android.rest.datamodels.core.ServiceModel;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating UkappService objects.
 */
public class UkappServiceFactory {
	
	/** The service models. */
	public static Map<String, ServiceModel> serviceModels;
	
	/**
	 * Creates a new UkappService object.
	 *
	 * @param service the service
	 * @param params the params
	 * @return the service model
	 * @throws URISyntaxException the uRI syntax exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws InstantiationException the instantiation exception
	 */
	public static ServiceModel createServiceModel(UkappsServices service, String[] params) throws URISyntaxException, IllegalAccessException, InstantiationException {
		ServiceModel sm = serviceModels.get(service.getMapperName());
		
		String tempUri = sm.getUri().toString().replace("?", "%s");
		sm.setUri(new URI(String.format(tempUri, params)));

		/*
		String tempProviderUri = sm.getContentProviderUri().toString().replace("?", "%s");
		sm.setContentProviderUri(new URI(String.format(tempProviderUri, R.string.app_name)));
		*/
		return sm;
	}
	
}
