package no.uka.findmyapp.android.rest.datamodels.models;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class UkaEvent.
 *
 * @author jostein.guldal
 */
public class UkaEvent implements Serializable {
	
	/** The id. */
	private int id;
	
    /** The event id. */
	private int eventId;
	
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
	
    /** The hidden_from_listings. */
	private boolean hidden_from_listings;
	
    /** The slug. */
	private String slug;
	
    /** The age limit. */
	private int ageLimit;
	
    /** The detail photo id. */
	private int detailPhotoId;
	
	
    /** The showing time. */
    private long showingTime;
    
    /** The publish time. */
    private long publishTime;
    

    /** The netsale from. */
    private long netsaleFrom;
    
    /** The netsale to. */
    private long netsaleTo;
    
    /** The free. */
	private boolean free;
	
	 /** The canceled. */
	private boolean canceled;
	
	/** The price */
	private int price; 

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
	 * Gets the event id.
	 *
	 * @return the event id
	 */
	public int getEventId() {
		return eventId;
	}

	/**
	 * Sets the event id.
	 *
	 * @param eventId the new event id
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
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
	 * Checks if is hidden_from_listings.
	 *
	 * @return true, if is hidden_from_listings
	 */
	public boolean isHidden_from_listings() {
		return hidden_from_listings;
	}

	/**
	 * Sets the hidden_from_listings.
	 *
	 * @param hidden_from_listings the new hidden_from_listings
	 */
	public void setHidden_from_listings(boolean hidden_from_listings) {
		this.hidden_from_listings = hidden_from_listings;
	}

	/**
	 * Gets the slug.
	 *
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}

	/**
	 * Sets the slug.
	 *
	 * @param slug the new slug
	 */
	public void setSlug(String slug) {
		this.slug = slug;
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
	 * Gets the detail photo id.
	 *
	 * @return the detail photo id
	 */
	public int getDetailPhotoId() {
		return detailPhotoId;
	}

	/**
	 * Sets the detail photo id.
	 *
	 * @param detailPhotoId the new detail photo id
	 */
	public void setDetailPhotoId(int detailPhotoId) {
		this.detailPhotoId = detailPhotoId;
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
	 * Gets the publish time.
	 *
	 * @return the publish time
	 */
	public long getPublishTime() {
		return publishTime;
	}
	
	/**
	 * Sets the publish time.
	 *
	 * @param publishTime the new publish time
	 */
	public void setPublishTime(long publishTime) {
		this.publishTime = publishTime;
	}

	/**
	 * Gets the netsale from.
	 *
	 * @return the netsale from
	 */
	public long getNetsaleFrom() {
		return netsaleFrom;
	}

	/**
	 * Sets the netsale from.
	 *
	 * @param netsaleFrom the new netsale from
	 */
	public void setNetsaleFrom(long netsaleFrom) {
		this.netsaleFrom = netsaleFrom;
	}

	/**
	 * Gets the netsale to.
	 *
	 * @return the netsale to
	 */
	public long getNetsaleTo() {
		return netsaleTo;
	}

	/**
	 * Sets the netsale to.
	 *
	 * @param netsaleTo the new netsale to
	 */
	public void setNetsaleTo(long netsaleTo) {
		this.netsaleTo = netsaleTo;
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
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStartTime(){
		Timestamp time = new Timestamp(this.showingTime);
		return (time.getHours() +":"+ time.getMinutes());
	}
	
	public int getDayNumber(){
		Timestamp time = new Timestamp(this.showingTime);
		return (time.getDate());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UkaEvent [id=" + id + ", eventId=" + eventId + ", billingid="
				+ billingid + ", entranceId=" + entranceId + ", title=" + title
				+ ", lead=" + lead + ", text=" + text + ", place=" + place
				+ ", eventType=" + eventType + ", image=" + image
				+ ", thumbnail=" + thumbnail + ", hidden_from_listings="
				+ hidden_from_listings + ", slug=" + slug + ", ageLimit="
				+ ageLimit + ", detailPhotoId=" + detailPhotoId
				+ ", free=" + free + ", canceled=" + canceled + "]";
	}

}
