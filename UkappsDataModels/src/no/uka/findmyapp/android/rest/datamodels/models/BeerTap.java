/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.models;

import java.io.Serializable;

public class BeerTap implements Serializable {
	
	private static final long serialVersionUID = 3502164399399083651L;
	
	private int id;
	private int location;
	private float value;
	private int tapnr;
	private long date;
	private long time;
	
	public int getTapnr(){
		return tapnr;
	}
	public void setTapnr(int tapnr){
		this.tapnr = tapnr;
	}
	
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public long getTime() {
		return time;
	}
}