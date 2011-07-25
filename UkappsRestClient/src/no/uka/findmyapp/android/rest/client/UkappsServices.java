/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.client;

// TODO: Auto-generated Javadoc
/**
 * The Enum UkappsServices.
 *
 * @author jostein.guldal
 */

public enum UkappsServices {
	
	/** First thing. */
	UKAEVENTS("getUkaProgramForDate"),
	
	/** S thing. */
	TEMPERATURE_SAMPLE("");
	
	/** The mapper name. */
	String mapperName;
	
	/**
	 * Instantiates a new ukapps services.
	 *
	 * @param mapperName the mapper name
	 */
	UkappsServices(String mapperName) {
		this.mapperName = mapperName;
	}
	
	
	/**
	 * Gets the mapper name.
	 *
	 * @return the mapper name
	 */
	public String getMapperName() {
		return mapperName;
	}
}
