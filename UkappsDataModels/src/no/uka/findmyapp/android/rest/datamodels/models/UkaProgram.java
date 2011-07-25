/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class UkaProgram.
 */
public class UkaProgram implements Serializable {

	/** The events. */
	private List<UkaEvent> events;

	/** The event size. */
	private int eventSize;

	/**
	 * Instantiates a new uka program.
	 */
	public UkaProgram() {
		events = new ArrayList<UkaEvent>();
	}

	/**
	 * Instantiates a new uka program.
	 * 
	 * @param eventList
	 *            the event list
	 */
	public UkaProgram(List<UkaEvent> eventList) {
		this.events = eventList;
	}

	/**
	 * Gets the events.
	 * 
	 * @return the events
	 */
	public List<UkaEvent> getEvents() {
		return events;
	}

	/**
	 * Gets the event size.
	 * 
	 * @return the event size
	 */
	public int getEventSize() {
		return eventSize;
	}

	/**
	 * Sets the events.
	 * 
	 * @param events
	 *            the new events
	 */
	public void setEvents(List<UkaEvent> events) {
		this.events = events;
	}

	/**
	 * Sets the event size.
	 * 
	 * @param eventSize
	 *            the new event size
	 */
	public void setEventSize(int eventSize) {
		this.eventSize = eventSize;
	}

}
