package no.uka.findmyapp.android.rest.datamodels.models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UkaProgram  implements Serializable {
	private List<UkaEvent> events;
	private int eventSize;
	
	
	public UkaProgram() {
		events = new ArrayList<UkaEvent>();
	}
	public UkaProgram(List<UkaEvent> eventList) {
		this.events = eventList;
	}
	public int getEventSize() {
		return eventSize;
	}
	public void setEventSize(int eventSize) {
		this.eventSize = eventSize;
	}
	
	public List<UkaEvent> getEvents() {
		return events;
	}
	public void setEvents(List<UkaEvent> events) {
		this.events = events;
	}
	
}
