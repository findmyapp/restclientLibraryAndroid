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
 *
 * @author jostein.guldal
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
    
    /** The free flag. */
	private boolean free;
	
	 /** The canceled flag. */
	private boolean canceled;
	
	/** The price. */
	private int price; 
	
	/** The favourite flag. */
	private boolean favourite; 

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
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
	 * Gets the billingid.
	 *
	 * @return the billingid
	 */
	public int getBillingid() {
		return billingid;
	}

	/**
	 * Sets the billingid.
	 *
	 * @param billingid the new billingid
	 */
	public void setBillingid(int billingid) {
		this.billingid = billingid;
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
	 * Sets the entrance id.
	 *
	 * @param entranceId the new entrance id
	 */
	public void setEntranceId(int entranceId) {
		this.entranceId = entranceId;
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
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * Sets the lead.
	 *
	 * @param lead the new lead
	 */
	public void setLead(String lead) {
		this.lead = lead;
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

	/**
	 * Gets the place.
	 *
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * Sets the place.
	 *
	 * @param place the new place
	 */
	public void setPlace(String place) {
		this.place = place;
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
	 * Sets the event type.
	 *
	 * @param eventType the new event type
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
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
	 * Sets the image.
	 *
	 * @param image the new image
	 */
	public void setImage(String image) {
		this.image = image;
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
	 * Sets the thumbnail.
	 *
	 * @param thumbnail the new thumbnail
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	/**
	 * Gets the age limit.
	 *
	 * @return the age limit
	 */
	public int getAgeLimit() {
		return ageLimit;
	}

	/**
	 * Sets the age limit.
	 *
	 * @param ageLimit the new age limit
	 */
	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
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
	 * Sets the showing time.
	 * 
	 * @param date the new showing time
	 */
	public void setShowingTime(long date) {
		this.showingTime = date;
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
	 * Sets the free.
	 *
	 * @param free the new free
	 */
	public void setFree(boolean free) {
		this.free = free;
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
	 * Sets the canceled.
	 *
	 * @param canceled the new canceled
	 */
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
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
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(int price) {
		this.price = price;
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
	 * Sets the favourite.
	 *
	 * @param favourite the new favourite
	 */
	public void setFavourite(boolean favourite) {
		this.favourite = favourite;
	}
}
