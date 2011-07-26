/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.models;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class UkaEvent.
 */
public class UkaEvent implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6227101675595553954L;

	/** The id. */
	private int id;

	/** The billingid. */
	private int billingid;

	/** The entrance id. */
	private int entranceId;

	/** The title. */
	private String title;

	/** The lead. */
	private String lead;

	/** The text. */
	private String text;

	/** The place. */
	private String place;

	/** The event type. */
	private String eventType;

	/** The image. */
	private String image;

	/** The thumbnail. */
	private String thumbnail;

	/** The age limit. */
	private int ageLimit;

	/** The showing time. */
	private long showingTime;

	/** The free. */
	private boolean free;

	/** The canceled. */
	private boolean canceled;

	/** The price. */
	private int price;

	/** The favourite. */
	private boolean favourite;
	
	private String spotifyString; 
	
	private String placeString; 
	
	private long updatedDate; 

	/**
	 * Gets the age limit.
	 * 
	 * @return the age limit
	 */
	public int getAgeLimit() {
		return ageLimit;
	}

	/**
	 * Gets the billingid.
	 * 
	 * @return the billingid
	 */
	public int getBillingid() {
		return billingid;
	}

	/**
	 * Gets the entrance id.
	 * 
	 * @return the entrance id
	 */
	public int getEntranceId() {
		return entranceId;
	}

	/**
	 * Gets the event type.
	 * 
	 * @return the event type
	 */
	public String getEventType() {
		return eventType;
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
	 * Gets the image.
	 * 
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Gets the lead.
	 * 
	 * @return the lead
	 */
	public String getLead() {
		return lead;
	}

	/**
	 * Gets the place.
	 * 
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Gets the showing time.
	 * 
	 * @return the showing time
	 */
	public long getShowingTime() {
		return showingTime;
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
	 * Gets the thumbnail.
	 * 
	 * @return the thumbnail
	 */
	public String getThumbnail() {
		return thumbnail;
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Checks if is canceled.
	 * 
	 * @return true, if is canceled
	 */
	public boolean isCanceled() {
		return canceled;
	}

	/**
	 * Checks if is favourite.
	 * 
	 * @return true, if is favourite
	 */
	public boolean isFavourite() {
		return favourite;
	}

	/**
	 * Checks if is free.
	 * 
	 * @return true, if is free
	 */
	public boolean isFree() {
		return free;
	}

	/**
	 * Sets the age limit.
	 * 
	 * @param ageLimit
	 *            the new age limit
	 */
	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}

	/**
	 * Sets the billingid.
	 * 
	 * @param billingid
	 *            the new billingid
	 */
	public void setBillingid(int billingid) {
		this.billingid = billingid;
	}

	/**
	 * Sets the canceled.
	 * 
	 * @param canceled
	 *            the new canceled
	 */
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	/**
	 * Sets the entrance id.
	 * 
	 * @param entranceId
	 *            the new entrance id
	 */
	public void setEntranceId(int entranceId) {
		this.entranceId = entranceId;
	}

	/**
	 * Sets the event type.
	 * 
	 * @param eventType
	 *            the new event type
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * Sets the favourite.
	 * 
	 * @param favourite
	 *            the new favourite
	 */
	public void setFavourite(boolean favourite) {
		this.favourite = favourite;
	}

	/**
	 * Sets the free.
	 * 
	 * @param free
	 *            the new free
	 */
	public void setFree(boolean free) {
		this.free = free;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the image.
	 * 
	 * @param image
	 *            the new image
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * Sets the lead.
	 * 
	 * @param lead
	 *            the new lead
	 */
	public void setLead(String lead) {
		this.lead = lead;
	}

	/**
	 * Sets the place.
	 * 
	 * @param place
	 *            the new place
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * Sets the price.
	 * 
	 * @param price
	 *            the new price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Sets the showing time.
	 * 
	 * @param date
	 *            the new showing time
	 */
	public void setShowingTime(long date) {
		this.showingTime = date;
	}

	/**
	 * Sets the text.
	 * 
	 * @param text
	 *            the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Sets the thumbnail.
	 * 
	 * @param thumbnail
	 *            the new thumbnail
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	/**
	 * Sets the title.
	 * 
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public String getSpotifyString() {
		return spotifyString;
	}

	public void setSpotifyString(String spotifyString) {
		this.spotifyString = spotifyString;
	}

	public String getPlaceString() {
		return placeString;
	}

	public void setPlaceString(String placeString) {
		this.placeString = placeString;
	}

	public long getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(long dateUpdated) {
		this.updatedDate = updatedDate;
	}
}
