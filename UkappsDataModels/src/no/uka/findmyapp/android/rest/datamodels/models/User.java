package no.uka.findmyapp.android.rest.datamodels.models;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = -4059392658702552216L;
	
	private int facebookUserId; 
	private int localUserId; 
	private long userRegistered; 
	private long lastLogon;
	private Location lastKnownPosition;
	private UserPrivacy userPrivacy;
	
	public User() {}
	
	public User(int facebookId) {
		this.facebookUserId = facebookId; 
	}
	
	public User(int facebookId, int localId, long registerlong, long lastLogon, UserPrivacy userPrivacy ) {
		this.facebookUserId = facebookId; 
		this.localUserId = localId; 
		this.userRegistered = registerlong; 
		this.lastLogon = lastLogon; 
		this.userPrivacy = userPrivacy;
	}

	public int getFacebookUserId() {
		return facebookUserId;
	}

	public void setFacebookUserId(int facebookUserId) {
		this.facebookUserId = facebookUserId;
	}

	public int getLocalUserId() {
		return localUserId;
	}

	public void setLocalUserId(int localUserId) {
		this.localUserId = localUserId;
	}

	public long getUserRegistered() {
		return userRegistered;
	}

	public void setUserRegistered(long userRegistered) {
		this.userRegistered = userRegistered;
	}

	public long getLastLogon() {
		return lastLogon;
	}

	public void setLastLogon(long lastLogon) {
		this.lastLogon = lastLogon;
	}

	public Location getLastKnownPosition() {
		return lastKnownPosition;
	}

	public void setLastKnownPosition(Location lastKnownPosition) {
		this.lastKnownPosition = lastKnownPosition;
	}

	public UserPrivacy getUserPrivacy() {
		return userPrivacy;
	}

	public void setUserPrivacy(UserPrivacy userPrivacy) {
		this.userPrivacy = userPrivacy;
	}
}
