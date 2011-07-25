/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.models;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class BeerTap.
 */
public class BeerTap implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7627495501757920463L;

	/** The id. */
	private int id;
	
	/** The location id. */
	private int locationId;
	
	/** The value. */
	private float value;
	
	/** The beer tower num. */
	private int beerTowerNum; 
	
	/** The date. */
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

	/**
	 * Gets the beer tower num.
	 *
	 * @return the beer tower num
	 */
	public int getBeerTowerNum() {
		return beerTowerNum;
	}

	/**
	 * Sets the beer tower num.
	 *
	 * @param beerTowerNum the new beer tower num
	 */
	public void setBeerTowerNum(int beerTowerNum) {
		this.beerTowerNum = beerTowerNum;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Temperature [id=" + id + ", locationId=" + locationId
				+ ", value=" + value + ", beerTowerNum=" + beerTowerNum + ", date=" + date + "]";
	}
}
