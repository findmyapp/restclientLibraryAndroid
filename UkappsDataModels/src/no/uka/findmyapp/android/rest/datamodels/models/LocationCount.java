package no.uka.findmyapp.android.rest.datamodels.models;

import java.io.Serializable;

public class LocationCount implements Serializable{

	private static final long serialVersionUID = 3284689247103582175L;
	
	private String locationName;
	private int userCount;

	public LocationCount() {}

	public LocationCount(String locationName, int userCount) {
	this.locationName = locationName;
	this.userCount = userCount;
	}

	public String getLocationName() {
	return locationName;
	}

	public void setLocationName(String locationName) {
	this.locationName = locationName;
	}

	public int getUserCount() {
	return userCount;
	}

	public void setUserCount(int userCount) {
	this.userCount = userCount;
	}

}