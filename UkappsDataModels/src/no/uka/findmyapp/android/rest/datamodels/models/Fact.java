package no.uka.findmyapp.android.rest.datamodels.models;

public class Fact {

	private int factId;
	private int locationId;
	private String text;
	
	public Fact() {
	}

	public Fact(int locationId, String text) {
		this.locationId = locationId;
		this.text = text;
	}

	public int getFactId() {
		return factId;
	}

	public void setFactId(int factId) {
		this.factId = factId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
}