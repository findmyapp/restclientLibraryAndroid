/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.models;

import java.io.Serializable;

public class Location implements Serializable{

	private static final long serialVersionUID = -2475513849744509031L;

	private int locationId;
	private String locationStringId;
	private int locationName;
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getLocationStringId() {
		return locationStringId;
	}
	public void setLocationStringId(String locationStringId) {
		this.locationStringId = locationStringId;
	}
	public int getLocationName() {
		return locationName;
	}
	public void setLocationName(int locationName) {
		this.locationName = locationName;
	} 
}