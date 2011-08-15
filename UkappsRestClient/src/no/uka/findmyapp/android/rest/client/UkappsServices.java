/**
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.client;

// TODO: Auto-generated Javadoc
/**
 * The Enum UkappsServices.
 */

public enum UkappsServices {
	/* GET ENUMS */
	// lcoation enums
	/** The GE t_ al l_ locations. */
	GET_ALL_LOCATIONS,
	
	/** The GE t_ al l_ locatio n_ facts. */
	GET_ALL_LOCATION_FACTS,
	
	/** The GE t_ rando m_ locatio n_ fact. */
	GET_RANDOM_LOCATION_FACT,

	// user privacy settings
	/** The GE t_ privacy. */
	GET_PRIVACY,

	// sensor enums
	/** The GE t_ temperatur e_ dat a_ fro m_ location. */
	GET_TEMPERATURE_DATA_FROM_LOCATION,
	
	/** The GE t_ humidit y_ dat a_ fro m_ location. */
	GET_HUMIDITY_DATA_FROM_LOCATION,
	
	/** The GE t_ nois e_ dat a_ fro m_ location. */
	GET_NOISE_DATA_FROM_LOCATION,
	
	/** The GE t_ beerta p_ dat a_ fro m_ location. */
	GET_BEERTAP_DATA_FROM_LOCATION,

	// program enums
	/** The GE t_ uk a_ progra m_ fo r_ date. */
	GET_UKA_PROGRAM_FOR_DATE,
	
	/** The GE t_ uk a_ progra m_ places. */
	GET_UKA_PROGRAM_PLACES,

	// user count
	/** The GE t_ use r_ coun t_ a t_ location. */
	GET_USER_COUNT_AT_LOCATION,
	
	/** The GE t_ use r_ coun t_ a t_ al l_ locations. */
	GET_USER_COUNT_AT_ALL_LOCATIONS,

	// uka events
	/** The GE t_ al l_ ukaevents. */
	GET_ALL_UKAEVENTS,	
	
	/** The GE t_ friend s_ attendin g_ event. */
	GET_FRIENDS_ATTENDING_EVENT,
	
	/* SET ENUMS */
	/** The SE t_ temperatur e_ data. */
	SET_TEMPERATURE_DATA; 
}