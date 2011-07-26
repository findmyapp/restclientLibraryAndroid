/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.models;

import java.io.Serializable;

public class Location implements Serializable{

	private static final long serialVersionUID = -2475513849744509031L;

	private String locationName;
	private int locationId;
	
	public Location() {}
	
	public Location(int locationId) {
		this.locationId = locationId;
	}

	public Location(String locationName, int locationId) {
		this.locationName = locationName;
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
}