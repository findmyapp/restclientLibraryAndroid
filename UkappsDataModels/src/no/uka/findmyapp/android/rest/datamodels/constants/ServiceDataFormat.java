/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.constants;

// TODO: Auto-generated Javadoc
/**
 * The Enum ServiceDataFormat.
 */
public enum ServiceDataFormat {

	/** The JSON. */
	JSON("application/json");

	/** The value. */
	String value;

	/**
	 * Instantiates a new service data format.
	 * 
	 * @param value
	 *            the value
	 */
	private ServiceDataFormat(String value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
