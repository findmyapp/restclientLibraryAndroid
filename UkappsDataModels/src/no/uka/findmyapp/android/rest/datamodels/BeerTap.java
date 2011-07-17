package no.uka.findmyapp.android.rest.datamodels;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import android.text.format.Time;

public class BeerTap implements Serializable {
	private static final long serialVersionUID = 7627495501757920463L;

	private int id;
	private int locationId;
	private float value;
	private int beerTowerNum; 
	private long date;
	
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

	public int getBeerTowerNum() {
		return beerTowerNum;
	}

	public void setBeerTowerNum(int beerTowerNum) {
		this.beerTowerNum = beerTowerNum;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Temperature [id=" + id + ", locationId=" + locationId
				+ ", value=" + value + ", beerTowerNum=" + beerTowerNum + ", date=" + date + "]";
	}
}
