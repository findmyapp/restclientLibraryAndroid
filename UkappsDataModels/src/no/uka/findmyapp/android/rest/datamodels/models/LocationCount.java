/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.models;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class LocationCount.
 */
public class LocationCount implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3284689247103582175L;
	
	/** The location name. */
	private String locationName;
	
	/** The user count. */
	private int userCount;

	/**
	 * Instantiates a new location count.
	 */
	public LocationCount() {}

	/**
	 * Instantiates a new location count.
	 *
	 * @param locationName the location name
	 * @param userCount the user count
	 */
	public LocationCount(String locationName, int userCount) {
	this.locationName = locationName;
	this.userCount = userCount;
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

	/**
	 * Gets the user count.
	 *
	 * @return the user count
	 */
	public int getUserCount() {
	return userCount;
	}

	/**
	 * Sets the user count.
	 *
	 * @param userCount the new user count
	 */
	public void setUserCount(int userCount) {
	this.userCount = userCount;
	}

}