package no.uka.findmyapp.android.rest.datamodels;

import java.io.Serializable;
import java.sql.Date;

import android.os.Parcel;
import android.os.Parcelable;


public class Temperature implements Serializable {
	private int id;
	private int locationId;
	private float value;
	//private Date date;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getLocationId() {
		return locationId;
	}
	
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	public float getValue() {
		return value;
	}
	
	public void setValue(float value) {
		this.value = value;
	}
	/*
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	*/
	@Override
	public String toString() {
		return "Temperature [id=" + id + ", locationId=" + locationId
				+ ", value=" + value + "]";
	}
}