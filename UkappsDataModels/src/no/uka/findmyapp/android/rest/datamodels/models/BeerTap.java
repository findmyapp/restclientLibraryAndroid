package no.uka.findmyapp.android.rest.datamodels.models;

import java.io.Serializable;
import java.sql.Date;

public class BeerTap implements Serializable {
	private int id;
	private int locationId;
	private float value;
	private int beerTowerNum; 
	private Date date;
	
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Temperature [id=" + id + ", locationId=" + locationId
				+ ", value=" + value + ", beerTowerNum=" + beerTowerNum + ", date=" + date.toString() + "]";
	}
}
