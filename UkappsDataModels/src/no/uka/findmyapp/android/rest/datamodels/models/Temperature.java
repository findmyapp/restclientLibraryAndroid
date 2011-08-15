/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.models;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Temperature.
 */
public class Temperature implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6416966156170424575L;
	
	/** The id. */
	private int id;
	
	/** The location. */
	private int location;
	
	/** The value. */
	private float value;
	
	/** The date. */
	private long date;
	
	/** The time. */
	private long time;
	
	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public int getLocation() {
		return location;
	}
	
	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(int location) {
		this.location = location;
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
	
	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public long getDate() {
		return date;
	}
	
	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(long date) {
		this.date = date;
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
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Sets the time.
	 *
	 * @param time the new time
	 */
	public void setTime(long time) {
		this.time = time;
	}
	
	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public long getTime() {
		return time;
	}
}