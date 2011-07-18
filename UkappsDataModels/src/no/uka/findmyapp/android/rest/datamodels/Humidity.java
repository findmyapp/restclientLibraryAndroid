package no.uka.findmyapp.android.rest.datamodels;

import java.io.Serializable;

public class Humidity implements Serializable {
	private static final long serialVersionUID = 3094510102510621293L;

	private int id;
	private int locationId;
	private float value;
	private long date;

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

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Humidity [id=" + id + ", locationId=" + locationId
				+ ", value=" + value + ", date=" + date + "]";
	}
}
