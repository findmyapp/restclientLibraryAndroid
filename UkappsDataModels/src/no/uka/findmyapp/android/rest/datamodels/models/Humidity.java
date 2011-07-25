/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.models;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Humidity.
 */
public class Humidity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3094510102510621293L;

	/** The id. */
	private int id;

	/** The location id. */
	private int locationId;

	/** The value. */
	private float value;

	/** The date. */
	private long date;

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public long getDate() {
		return date;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
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
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public float getValue() {
		return value;
	}

	/**
	 * Sets the date.
	 * 
	 * @param date
	 *            the new date
	 */
	public void setDate(long date) {
		this.date = date;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
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
	 * Sets the value.
	 * 
	 * @param value
	 *            the new value
	 */
	public void setValue(float value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Humidity [id=" + id + ", locationId=" + locationId + ", value="
				+ value + ", date=" + date + "]";
	}
}
