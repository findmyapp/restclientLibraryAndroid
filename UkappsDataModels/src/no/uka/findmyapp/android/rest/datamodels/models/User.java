/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.models;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
public class User implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4059392658702552216L;
	
	/** The facebook user id. */
	private int facebookUserId; 
	
	/** The local user id. */
	private int localUserId; 
	
	/** The user registered. */
	private long userRegistered; 
	
	/** The last logon. */
	private long lastLogon;
	
	/** The last known position. */
	private Location lastKnownPosition;
	
	/** The user privacy. */
	private UserPrivacy userPrivacy;
	
	/**
	 * Instantiates a new user.
	 */
	public User() {}
	
	/**
	 * Instantiates a new user.
	 *
	 * @param facebookId the facebook id
	 */
	public User(int facebookId) {
		this.facebookUserId = facebookId; 
	}
	
	/**
	 * Instantiates a new user.
	 *
	 * @param facebookId the facebook id
	 * @param localId the local id
	 * @param registerlong the registerlong
	 * @param lastLogon the last logon
	 * @param userPrivacy the user privacy
	 */
	public User(int facebookId, int localId, long registerlong, long lastLogon, UserPrivacy userPrivacy ) {
		this.facebookUserId = facebookId; 
		this.localUserId = localId; 
		this.userRegistered = registerlong; 
		this.lastLogon = lastLogon; 
		this.userPrivacy = userPrivacy;
	}

	/**
	 * Gets the facebook user id.
	 *
	 * @return the facebook user id
	 */
	public int getFacebookUserId() {
		return facebookUserId;
	}

	/**
	 * Sets the facebook user id.
	 *
	 * @param facebookUserId the new facebook user id
	 */
	public void setFacebookUserId(int facebookUserId) {
		this.facebookUserId = facebookUserId;
	}

	/**
	 * Gets the local user id.
	 *
	 * @return the local user id
	 */
	public int getLocalUserId() {
		return localUserId;
	}

	/**
	 * Sets the local user id.
	 *
	 * @param localUserId the new local user id
	 */
	public void setLocalUserId(int localUserId) {
		this.localUserId = localUserId;
	}

	/**
	 * Gets the user registered.
	 *
	 * @return the user registered
	 */
	public long getUserRegistered() {
		return userRegistered;
	}

	/**
	 * Sets the user registered.
	 *
	 * @param userRegistered the new user registered
	 */
	public void setUserRegistered(long userRegistered) {
		this.userRegistered = userRegistered;
	}

	/**
	 * Gets the last logon.
	 *
	 * @return the last logon
	 */
	public long getLastLogon() {
		return lastLogon;
	}

	/**
	 * Sets the last logon.
	 *
	 * @param lastLogon the new last logon
	 */
	public void setLastLogon(long lastLogon) {
		this.lastLogon = lastLogon;
	}

	/**
	 * Gets the last known position.
	 *
	 * @return the last known position
	 */
	public Location getLastKnownPosition() {
		return lastKnownPosition;
	}

	/**
	 * Sets the last known position.
	 *
	 * @param lastKnownPosition the new last known position
	 */
	public void setLastKnownPosition(Location lastKnownPosition) {
		this.lastKnownPosition = lastKnownPosition;
	}

	/**
	 * Gets the user privacy.
	 *
	 * @return the user privacy
	 */
	public UserPrivacy getUserPrivacy() {
		return userPrivacy;
	}

	/**
	 * Sets the user privacy.
	 *
	 * @param userPrivacy the new user privacy
	 */
	public void setUserPrivacy(UserPrivacy userPrivacy) {
		this.userPrivacy = userPrivacy;
	}
}
