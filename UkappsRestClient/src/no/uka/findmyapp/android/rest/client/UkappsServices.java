/**
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.client;

/**
 * The Enum UkappsServices.
 *
 * @author jostein.guldal
 */

public enum UkappsServices {
	/* GET ENUMS */
	// lcoation enums
	GET_ALL_LOCATIONS,
	GET_ALL_LOCATION_FACTS,
	GET_RANDOM_LOCATION_FACT,

	// user privacy settings
	GET_PRIVACY,

	// sensor enums
	GET_TEMPERATURE_DATA_FROM_LOCATION,
	GET_HUMIDITY_DATA_FROM_LOCATION,
	GET_NOISE_DATA_FROM_LOCATION,
	GET_BEERTAP_DATA_FROM_LOCATION,

	// program enums
	GET_UKA_PROGRAM_FOR_DATE,
	GET_UKA_PROGRAM_PLACES,

	// user count
	GET_USER_COUNT_AT_LOCATION,
	GET_USER_COUNT_AT_ALL_LOCATIONS,

	// uka events
	GET_ALL_UKAEVENTS,	
	GET_FRIENDS_ATTENDING_EVENT,
	
	/* SET ENUMS */
	SET_TEMPERATURE_DATA; 
}