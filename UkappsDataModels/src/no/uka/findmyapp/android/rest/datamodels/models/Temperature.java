package no.uka.findmyapp.android.rest.datamodels.models;

import java.io.Serializable;
import java.sql.Date;

import android.os.Parcel;
import android.os.Parcelable;


// TODO: Auto-generated Javadoc
/**
 * The Class Temperature.
 */
public class Temperature implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5282226888346740736L;
	
	/** The id. */
	private int id;
	
	/** The location id. */
	private int locationId;
	
	/** The value. */
	private float value;
	
	private long date;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
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
	 * Sets the location id.
	 *
	 * @param locationId the new location id
	 */
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public float getValue() {
		return value;
	}
	
	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
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
		return "Temperature [id=" + id + ", locationId=" + locationId
				+ ", value=" + value + ", date=" + date + "]";
	}
	
	
}