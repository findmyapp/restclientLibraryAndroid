package no.uka.findmyapp.android.rest.datamodels;

import java.io.Serializable;
import java.sql.Date;

public class Noise implements Serializable {
	private int id;
	private int locationId;
	private float average; 
	private float max; 
	private float min; 
	private float standardDeviation;
	private String samples; 
	private Date date;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public float getAverage() {
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}

	public float getMax() {
		return max;
	}

	public void setMax(float max) {
		this.max = max;
	}

	public float getMin() {
		return min;
	}

	public void setMin(float min) {
		this.min = min;
	}

	public float getStandardDeviation() {
		return standardDeviation;
	}

	public void setStandardDeviation(float standardDeviation) {
		this.standardDeviation = standardDeviation;
	}

	public String getSamples() {
		return samples;
	}

	public void setSamples(String samples) {
		this.samples = samples;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Temperature [id=" + id + ", locationId=" + locationId
				+ ", average=" + average + ", max=" + max + ", min=" + min
				+ ", standardDeviation=" + standardDeviation + ", samples=" + samples 
				+ ", date=" + date.toString() + "]";
	}
}
