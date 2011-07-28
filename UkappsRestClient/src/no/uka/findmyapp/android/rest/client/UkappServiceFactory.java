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
import no.uka.findmyapp.android.rest.datamodels.enums.HttpType;
import no.uka.findmyapp.android.rest.datamodels.models.Fact;
import no.uka.findmyapp.android.rest.datamodels.models.Humidity;
import no.uka.findmyapp.android.rest.datamodels.models.Location;
import no.uka.findmyapp.android.rest.datamodels.models.LocationCount;
import no.uka.findmyapp.android.rest.datamodels.models.Noise;
import no.uka.findmyapp.android.rest.datamodels.models.Temperature;
import no.uka.findmyapp.android.rest.datamodels.models.UkaEvent;
import no.uka.findmyapp.android.rest.datamodels.models.User;
import android.util.Log;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating UkappService objects.
 */
public class UkappServiceFactory {
	
	private static final String debug = "createServiceModel";
	
	/** The servicemodels. */
	public static Map<String, ServiceModel> serviceModels;
	
	/**
	 * Creates a new UkappService object.
	 *
	 * @param service the service
	 * @param params the params
	 * @return the servicemodel
	 * @throws URISyntaxException the uRI syntax exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws InstantiationException the instantiation exception
	 */
	public static ServiceModel createServiceModel(UkappsServices service) {
		ServiceModel model; 
		try {
			switch (service) {
				case GET_TEMPERATURE_DATA: 
					model = new ServiceModel(
				 		new URI("http://findmyapp.net/findmyapp/locations/?/temperature/latest"),
				 		HttpType.GET,
						Temperature.class,
						null,
						null,
						"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN"); 
					return model; 
				case GET_NOISE_DATA: 
					model = new ServiceModel(
						new URI("http://findmyapp.net/findmyapp/locations/?/noise/latest"),
						HttpType.GET,
						Noise.class,
						null,
						null,
						"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN"); 
					return model; 
				case GET_HUMIDITY_DATA: 
					model = new ServiceModel(
						new URI("http://findmyapp.net/findmyapp/locations/?/humidity/latest"),
						HttpType.GET,
						Humidity.class,
						null,
						null,
						"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN"); 
					return model; 
				case SET_TEMPERATURE_DATA: 
					model = new ServiceModel(
						new URI("http://findmyapp.net/findmyapp/locations/?/temperature"),
						HttpType.POST,
						Temperature.class,
						null,
						null,
						"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN"); 
					return model; 
	//			case GET_APPSTORE_LIST_FOR_PLATFORM: 
	//				model = new ServiceModel(
	//					new URI("http://findmyapp.net/findmyapp/appstore/?"),
	//					HttpType.GET,
	//					AppStoreList.class,
	//					null,
	//					null,
	//					"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN",
	//					"getAppStoreListForPlatform"); 
	//				return model; 
				case GET_ALL_LOCATIONS: 
					model = new ServiceModel(
						new URI("http://findmyapp.net/findmyapp/locations"),
						HttpType.GET,
						Location.class,
						null,
						null,
						"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN"); 
					return model; 
				case GET_POSITION_BASED_ON_WLAN_SIGNALS: 
					model = new ServiceModel(
						new URI("http://findmyapp.net/findmyapp/locations"),
						HttpType.POST,
						Location.class,
						null,
						null,
						"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN"); 
					return model; 
	//			case GET_USERS_AT_LOCATION: 
	//				model = new ServiceModel(
	//					new URI("http://findmyapp.net/findmyapp/locations/?/users"),
	//					HttpType.GET,
	//					User.class,
	//					null,
	//					null,
	//					"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN",
	//					"getUsersAtLocation"); 
	//				return model; 
				case GET_USER_COUNT_AT_LOCATION: 
					model = new ServiceModel(
						new URI("http://findmyapp.net/findmyapp/locations/?/users/count"),
						HttpType.GET,
						Integer.class,
						null,
						null,
						"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN"); 
					return model; 
				case GET_USER_COUNT_AT_ALL_LOCATIONS: 
					model = new ServiceModel(
						new URI("http://findmyapp.net/findmyapp/locations/all/users/count"),
						HttpType.GET,
						LocationCount.class,
						null,
						null,
						"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN"); 
					return model; 
	//			case REGISTER_SAMPLE: 
	//				model = new ServiceModel(
	//					new URI("http://findmyapp.net/findmyapp/locations/sample"),
	//					HttpType.POST,
	//					Boolean.class,
	//					null,
	//					null,
	//					"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN",
	//					"registerSample"); 
	//				return model; 
				case GET_ALL_FACTS: 
					model = new ServiceModel(
						new URI("http://findmyapp.net/findmyapp/locations/?/facts"),
						HttpType.GET,
						Fact.class,
						null,
						null,
						"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN"); 
					return model; 
				case GET_RANDOM_FACT: 
					model = new ServiceModel(
						new URI("http://findmyapp.net/findmyapp/locations/?/facts/random"),
						HttpType.GET,
						Fact.class,
						null,
						null,
						"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN"); 
					return model; 
				case GET_UKA_PROGRAM_FOR_DATE: 
					model = new ServiceModel(
						new URI("http://findmyapp.net/findmyapp/program/?/events&date=?"),
						HttpType.GET,
						UkaEvent.class,
						null,
						null,
						"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN"); 
					return model; 
				case UKAEVENTS: 
					model = new ServiceModel(
						new URI("http://findmyapp.net/findmyapp/program/?/events"),
						HttpType.GET,
						UkaEvent.class,
						null,
						null,
						"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN"); 
					return model;
	//			case SEARCH_FOR_UKA_PROGRAM_BY_NAME: 
	//				model = new ServiceModel(
	//					new URI("http://findmyapp.net/findmyapp/program/?/events/search"),
	//					HttpType.GET,
	//					UkaProgram.class,
	//					null,
	//					null,
	//					"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN",
	//					"searchForUkaProgramByName"); 
	//				return model; 
				case GET_UKA_PROGRAM_PLACES: 
					model = new ServiceModel(
						new URI("http://findmyapp.net/findmyapp/program/?/places"),
						HttpType.GET,
						String.class,
						null,
						null,
						"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN"); 
					return model; 
				case GET_EVENTS_ON_PLACE: 
					model = new ServiceModel(
						new URI("http://findmyapp.net/findmyapp/program/?/places/?"),
						HttpType.GET,
						UkaEvent.class,
						null,
						null,
						"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN"); 
					return model; 
				case GET_NEXT_UKA_EVENT: 
					model = new ServiceModel(
						new URI("http://findmyapp.net/findmyapp/program/?/places/?/next"),
						HttpType.GET,
						UkaEvent.class,
						null,
						null,
						"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN"); 
					return model; 
	//			case GET_UKA_EVENTS_TODAY: 
	//				model = new ServiceModel(
	//					new URI("http://findmyapp.net/findmyapp/program/?/places/?/today"),
	//					HttpType.GET,
	//					UkaEvent.class,
	//					null,
	//					null,
	//					"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN",
	//					"getUkaEventsToday"); 
	//				return model; 
	//			case GET_UKA_EVENTS_TOMORROW: 
	//				model = new ServiceModel(
	//					new URI("http://findmyapp.net/findmyapp/program/?/places/?/tomorrow"),
	//					HttpType.GET,
	//					UkaEvent.class,
	//					null,
	//					null,
	//					"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN",
	//					"getUkaEventsTomorrow"); 
	//				return model; 
	//			case GET_UKA_PROGRAM_START_END_DATE: 
	//				model = new ServiceModel(
	//					new URI("http://findmyapp.net/findmyapp/program/?"),
	//					HttpType.GET,
	//					UkaProgramConfiguration.class,
	//					null,
	//					null,
	//					"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN",
	//					"getUkaProgramStartEndDate"); 
	//				return model; 
	//			case GET_UKA_PROGRAM_START_END_DATE: 
	//				model = new ServiceModel(
	//					new URI("http://findmyapp.net/findmyapp/program"),
	//					HttpType.GET,
	//					UkaProgramConfiguration.class,
	//					null,
	//					null,
	//					"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN",
	//					"getUkaProgramStartEndDate"); 
	//				return model; 
				case GET_FRIENDS_ATTENDING_EVENT: 
					model = new ServiceModel(
						new URI("http://findmyapp.net/findmyapp/events/?/friends"),
						HttpType.GET,
						User.class,
						null,
						null,
						"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN"); 
					return model; 
	//			case GET_UKA_EVENT_BY_ID: 
	//				model = new ServiceModel(
	//					new URI("http://findmyapp.net/findmyapp/program/?/events/?"),
	//					HttpType.GET,
	//					UkaEvent.class,
	//					null,
	//					null,
	//					"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN",
	//					"getUkaEventById"); 
	//				return model; 
				case GET_PRIVACY: 
					model = new ServiceModel(
						new URI("http://findmyapp.net/findmyapp/users/me/privacy"),
						HttpType.GET,
						String.class,
						null,
						null,
						"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN"); 
					return model; 
	//			case REGISTER_USER_LOCATION: 
	//				model = new ServiceModel(
	//					new URI("http://findmyapp.net/findmyapp/users/me/location/?"),
	//					HttpType.PUT,
	//					Boolean.class,
	//					null,
	//					null,
	//					"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN",
	//					"registerUserLocation"); 
	//				return model; 
				case GET_USER_LOCATION: 
					model = new ServiceModel(
						new URI("http://findmyapp.net/findmyapp/users/?/location"),
						HttpType.GET,
						Location.class,
						null,
						null,
						"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN"); 
					return model; 
	//			case GET_ALL_USER_LOCATIONS: 
	//				model = new ServiceModel(
	//					new URI("http://findmyapp.net/findmyapp/users/all/location"),
	//					HttpType.GET,
	//					UserPosition.class,
	//					null,
	//					null,
	//					"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN",
	//					"getAllUserLocations"); 
	//				return model; 
	//			case GET_LOCATION_OF_FRIENDS: 
	//				model = new ServiceModel(
	//					new URI("http://findmyapp.net/findmyapp/usersme/friends/all/location"),
	//					HttpType.GET,
	//					UserPosition.class,
	//					null,
	//					null,
	//					"no.uka.findmyapp.android.demo.BROADCAST_INTENT_TOKEN",
	//					"getLocationOfFriends"); 
	//				return model; 
			}
		} 
		catch (Exception e) {
			Log.e(debug, e.getMessage());
		}
		
		return null;  
	}
}
