package no.uka.findmyapp.android.rest.datamodels.models;

/**
 * @author Cecilie Haugstvedt
 * @author Audun Sorheim
 */
public class Location {

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
