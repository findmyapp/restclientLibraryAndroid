/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.client;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.uka.findmyapp.android.rest.datamodels.constants.ServiceDataFormat;
import no.uka.findmyapp.android.rest.datamodels.core.ServiceModel;
import no.uka.findmyapp.android.rest.datamodels.enums.HttpType;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

// TODO: Auto-generated Javadoc
/**
 * The rest service helper class, a singleton which exposes a simple
 * asynchronous API to be used by the user interface.
 * 
 * Responsibility Prepare and send the Service request: - Check if the method is
 * already running - Create the requested Intent - Add the operation type and a
 * unique request id - Add the method specific parameters - Add the binder
 * callback - Call {@link RestService#startService()} - Return the request id
 * Handle the callback from the service - Dispatch callbacks to the user
 * interface listeners
 */
public class RestServiceHelper {
	
	/** The Constant debug. */
	private static final String debug = "RestServiceHelper";
	
	private static final String SERVICE_MODEL_PROVIDER_SERVICE_URI 
		= "http://findmyapp.net/findmyapp/serviceinfo/all";

	/** The singleton RestServiceHelper instance. */
	private static RestServiceHelper INSTANCE;
	
	/** The intent receiver. */
	private static ServiceModelReceiver sIntentReceiver;
	
	/** The updated service models. */
	private static boolean sUpdatedServiceModels = false;
	
	/** The updating service models. */
	private static boolean sUpdatingServiceModels = false;
	
	/** The buffer. */
	private static List<RequestBuffer> sBuffer;
	
	/**
	 * Instantiates a new rest service helper.
	 */
	private RestServiceHelper() {
		sBuffer = new ArrayList<RequestBuffer>();
	}

	/**
	 * Gets the single instance of RestServiceHelper.
	 *
	 * @return single instance of RestServiceHelper
	 */
	public static RestServiceHelper getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RestServiceHelper();
			return INSTANCE;
		}
		return INSTANCE;
	}

	/**
	 * Call start service.
	 *
	 * @param context the context
	 * @param serviceModel the service model
	 */
	public void callStartService(Context context, ServiceModel serviceModel) {
		Log.v(debug, "Inside callStarteService, using ServiceModel");
		Intent selectIntent = new Intent(context, RestIntentService.class);
		
		Log.v(debug, "callStartService: servicemodel " + serviceModel.toString());
		selectIntent.putExtra(IntentMessages.SERVICE_MODEL_PACKAGE, serviceModel);
		
		Log.v(debug, "callStartService: intent package: " + selectIntent.getExtras().toString()); 
		context.startService(selectIntent);

		Log.v(debug, "callStartService: context.startSerivce() called");
	}

	/**
	 * Call start service.
	 *
	 * @param context the context
	 * @param service the service
	 * @param params the params
	 * @throws URISyntaxException the uRI syntax exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws InstantiationException the instantiation exception
	 */
	public void callStartService(Context context, UkappsServices service, 
			URI contentProviderURI, String[] params) throws URISyntaxException, 
			IllegalAccessException, InstantiationException {
		if(!sUpdatedServiceModels && !sUpdatingServiceModels) {
			Log.v(debug, "callStartService: init updatedServiceModels");
			sUpdatingServiceModels = true;
			sBuffer.add(new RequestBuffer(context, service, contentProviderURI,  params));
		
			getUpdatedServiceModelInfo(context);
		} 
		else if(sUpdatedServiceModels) {
			ServiceModel sm = UkappServiceFactory.createServiceModel(service, contentProviderURI, params);
			Log.v(debug, "Internal: callStartService: preparing ServiceModel: " + sm.toString());
			
			this.callStartService(context, sm);
		}
	}

	/**
	 * Gets the updated service model info.
	 *
	 * @param context the context
	 * @return the updated service model info
	 */
	private void getUpdatedServiceModelInfo(Context context) {
		Log.v(debug, "updatingServiceModel");
		try {
			ServiceModel sm = new ServiceModel(
				new URI(SERVICE_MODEL_PROVIDER_SERVICE_URI),
				HttpType.GET, 
				ServiceDataFormat.JSON, ServiceModel.class,
				null, 
				null, 
				IntentMessages.BROADCAST_INTENT_TOKEN_SERVICEMODEL, 
				null);
			
			if(sIntentReceiver == null) {
				Log.v(debug, "getUpdatedServiceModelInfo: intent receiver=null servicemodel " + sm.toString());
				this.registerBroadCastListener(context);
				this.callStartService(context, sm);
			}
		} 
		//TODO Add error handling
		catch (URISyntaxException e) {
			e.printStackTrace();
			Log.v(debug, e.getLocalizedMessage());
		}
	}

	/**
	 * Register broad cast listener.
	 *
	 * @param context the context
	 */
	private void registerBroadCastListener(Context context) {
		Log.v(debug, "Internal: registering broadcastlistener for servicemodel");
		sIntentReceiver = new ServiceModelReceiver();
		IntentFilter intentFilter = 
			new IntentFilter(IntentMessages.BROADCAST_INTENT_TOKEN_SERVICEMODEL);
		context.registerReceiver(sIntentReceiver, intentFilter);
	}

	/**
	 * Unregister broad cast listener.
	 *
	 * @param context the context
	 */
	private void unregisterBroadCastListener(Context context) {
		Log.v(debug, "Internal: unregistering broadcastlistener for servicemodel");
		context.unregisterReceiver(sIntentReceiver); 
	}

	// AUTOGENERATED
	/**
	 * The Class ServiceModelReceiver.
	 */
	public class ServiceModelReceiver extends BroadcastReceiver {
		
		/* (non-Javadoc)
		 * @see android.content.BroadcastReceiver#onReceive(android.content.Context, android.content.Intent)
		 */
		@Override
		public void onReceive(Context context, Intent intent) {
			Log.v(debug, "ServiceModelReceiver: received broadcast");
			if (intentMessageIdentifiedByBoadcasatToken(intent)) {
				unregisterBroadCastListener(context);
				sUpdatedServiceModels = true;
				
				Serializable obj = intent.getSerializableExtra(IntentMessages.BROADCAST_RETURN_VALUE_NAME);
				List<ServiceModel> serviceModels = (List<ServiceModel>) obj;
				
				UkappServiceFactory.serviceModels = hashMapServiceModel(serviceModels);
				
				callBufferedRequests();
			}
			
		}

		//TODO Add exception handling
		private void callBufferedRequests( ) {
			for(RequestBuffer b : sBuffer) {
				try {
					callStartService(b.getContext(), b.getUkappsServices(), 
							b.getContentProvider(), b.getParams());
				} catch (URISyntaxException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				}
			}
		}

		private boolean intentMessageIdentifiedByBoadcasatToken(Intent intent) {
			return intent.getAction().equals(
					IntentMessages.BROADCAST_INTENT_TOKEN_SERVICEMODEL);
		}

		private Map<String, ServiceModel> hashMapServiceModel(
				List<ServiceModel> serviceModels ) {
			Map<String, ServiceModel> serviceModelsMap = new HashMap<String, ServiceModel>();
			for(ServiceModel sm : serviceModels) {
				serviceModelsMap.put(sm.getLocalIdentifier(), sm);
				Log.v(debug, "hashMapServiceModel serviceModel mapped: " + sm.toString());
			}
			return serviceModelsMap;
		}
	}
	
	/**
	 * The Class RequestBuffer.
	 */
	class RequestBuffer {
		
		/** The context. */
		private Context context;
		
		/** The ukapps services. */
		private UkappsServices ukappsServices;
		
		private URI contentProvider;
		
		/** The params. */
		private String[] params;
		
		
		/**
		 * Instantiates a new request buffer.
		 *
		 * @param context the context
		 * @param ukappsServices the ukapps services
		 * @param params the params
		 */
		public RequestBuffer(Context context, UkappsServices ukappsServices, 
				URI contentUri, String[] params) {
			super();
			this.context = context;
			this.params = params;
			this.ukappsServices = ukappsServices;
			this.contentProvider = contentUri; 
		}
		
		/**
		 * Gets the context.
		 *
		 * @return the context
		 */
		public Context getContext() {
			return context;
		}
		
		/**
		 * Sets the context.
		 *
		 * @param context the new context
		 */
		public void setContext(Context context) {
			this.context = context;
		}
		
		/**
		 * Gets the ukapps services.
		 *
		 * @return the ukapps services
		 */
		public UkappsServices getUkappsServices() {
			return ukappsServices;
		}
		
		/**
		 * Sets the ukapps services.
		 *
		 * @param ukappsServices the new ukapps services
		 */
		public void setUkappsServices(UkappsServices ukappsServices) {
			this.ukappsServices = ukappsServices;
		}
		
		/**
		 * Gets the params.
		 *
		 * @return the params
		 */
		public String[] getParams() {
			return params;
		}
		
		/**
		 * Sets the params.
		 *
		 * @param params the new params
		 */
		public void setParams(String[] params) {
			this.params = params;
		}

		public URI getContentProvider() {
			return contentProvider;
		}

		public void setContentProvider(URI contentProvider) {
			this.contentProvider = contentProvider;
		}
	}
}
