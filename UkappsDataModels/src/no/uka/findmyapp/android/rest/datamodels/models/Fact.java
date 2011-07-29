/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.models;

// TODO: Auto-generated Javadoc
/**
 * The Class Fact.
 */
public class Fact {

	/** The fact id. */
	private int factId;
	
	/** The location id. */
	private int locationId;
	
	/** The text. */
	private String text;
	
	/**
	 * Instantiates a new fact.
	 */
	public Fact() {
	}

	/**
	 * Instantiates a new fact.
	 *
	 * @param locationId the location id
	 * @param text the text
	 */
	public Fact(int locationId, String text) {
		this.locationId = locationId;
		this.text = text;
	}

	/**
	 * Gets the fact id.
	 *
	 * @return the fact id
	 */
	public int getFactId() {
		return factId;
	}

	/**
	 * Sets the fact id.
	 *
	 * @param factId the new fact id
	 */
	public void setFactId(int factId) {
		this.factId = factId;
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
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
}