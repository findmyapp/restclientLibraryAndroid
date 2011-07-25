/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.models;

// TODO: Auto-generated Javadoc
/**
 * The Class Location.
 */
public class Location {

	/** The location name. */
	private String locationName;

	/** The location id. */
	private int locationId;

	/**
	 * Instantiates a new location.
	 */
	public Location() {
	}

	/**
	 * Instantiates a new location.
	 * 
	 * @param locationId
	 *            the location id
	 */
	public Location(int locationId) {
		this.locationId = locationId;
	}

	/**
	 * Instantiates a new location.
	 * 
	 * @param locationName
	 *            the location name
	 * @param locationId
	 *            the location id
	 */
	public Location(String locationName, int locationId) {
		this.locationName = locationName;
		this.locationId = locationId;
	}

	/**
	 * Gets the location id.
	 * 
	 * @return the location id
	 */
	public int getLocationId() {
		return locationId;
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
	 * Sets the location id.
	 * 
	 * @param locationId
	 *            the new location id
	 */
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	/**
	 * Sets the location name.
	 * 
	 * @param locationName
	 *            the new location name
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}
