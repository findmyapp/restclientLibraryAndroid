/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.models;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Noise.
 */
public class Noise implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7042725896751783303L;

	/** The id. */
	private int id;

	/** The location id. */
	private int locationId;

	/** The average. */
	private float average;

	/** The max. */
	private float max;

	/** The min. */
	private float min;

	/** The standard deviation. */
	private float standardDeviation;

	/** The samples. */
	private String samples;

	/** The date. */
	private long date;

	/**
	 * Gets the average.
	 *
	 * @return the average
	 */
	public float getAverage() {
		return average;
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
	 * Gets the max.
	 *
	 * @return the max
	 */
	public float getMax() {
		return max;
	}

	/**
	 * Gets the min.
	 *
	 * @return the min
	 */
	public float getMin() {
		return min;
	}

	/**
	 * Gets the samples.
	 *
	 * @return the samples
	 */
	public String getSamples() {
		return samples;
	}

	/**
	 * Gets the standard deviation.
	 *
	 * @return the standard deviation
	 */
	public float getStandardDeviation() {
		return standardDeviation;
	}

	/**
	 * Sets the average.
	 *
	 * @param average the new average
	 */
	public void setAverage(float average) {
		this.average = average;
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
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
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
	 * Sets the max.
	 *
	 * @param max the new max
	 */
	public void setMax(float max) {
		this.max = max;
	}

	/**
	 * Sets the min.
	 *
	 * @param min the new min
	 */
	public void setMin(float min) {
		this.min = min;
	}

	/**
	 * Sets the samples.
	 *
	 * @param samples the new samples
	 */
	public void setSamples(String samples) {
		this.samples = samples;
	}

	/**
	 * Sets the standard deviation.
	 *
	 * @param standardDeviation the new standard deviation
	 */
	public void setStandardDeviation(float standardDeviation) {
		this.standardDeviation = standardDeviation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Temperature [id=" + id + ", locationId=" + locationId
				+ ", average=" + average + ", max=" + max + ", min=" + min
				+ ", standardDeviation=" + standardDeviation + ", samples="
				+ samples + ", date=" + date + "]";
	}
}
