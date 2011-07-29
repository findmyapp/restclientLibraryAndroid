/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.models;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Location.
 */
public class Location implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2475513849744509031L;

	/** The location id. */
	private int locationId;
	
	/** The string id. */
	private String stringId;
	
	/** The location name. */
	private String locationName;
	
	/**
	 * Gets the location id.
	 *
	 * @return the location id
	 */
	public int getLocationId() {
		return locationId;
	}
	
	/**
	 * Sets the location id.
	 *
	 * @param locationId the new location id
	 */
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	/**
	 * Gets the location string id.
	 *
	 * @return the location string id
	 */
	public String getLocationStringId() {
		return stringId;
	}
	
	/**
	 * Sets the location string id.
	 *
	 * @param locationStringId the new location string id
	 */
	public void setLocationStringId(String locationStringId) {
		this.stringId = locationStringId;
	}
	
	/**
	 * Gets the location name.
	 *
	 * @return the location name
	 */
	public String getLocationName() {
		return locationName;
	}
	
	/**
	 * Sets the location name.
	 *
	 * @param locationName the new location name
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	} 
}