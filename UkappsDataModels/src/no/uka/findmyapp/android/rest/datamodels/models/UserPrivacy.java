/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.models;

import no.uka.findmyapp.android.rest.datamodels.enums.PrivacySetting;

// TODO: Auto-generated Javadoc
/**
 * The Class UserPrivacy.
 */
public class UserPrivacy {
	
	/** The user privacy id. */
	private int userPrivacyId;
	
	/** The position privacy setting. */
	private PrivacySetting positionPrivacySetting;
	
	/** The events privacy setting. */
	private PrivacySetting eventsPrivacySetting;
	
	/** The money privacy setting. */
	private PrivacySetting moneyPrivacySetting;
	
	/** The media privacy setting. */
	private PrivacySetting mediaPrivacySetting;

	/**
	 * Gets the user privacy id.
	 *
	 * @return the user privacy id
	 */
	public int getUserPrivacyId() {
		return userPrivacyId;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param userPrivacyId the new id
	 */
	public void setId(int userPrivacyId) {
		this.userPrivacyId = userPrivacyId;
	}
	
	/**
	 * Gets the position privacy setting.
	 *
	 * @return the position privacy setting
	 */
	public PrivacySetting getPositionPrivacySetting() {
		return positionPrivacySetting;
	}
	
	/**
	 * Sets the position privacy setting.
	 *
	 * @param positionPrivacySetting the new position privacy setting
	 */
	public void setPositionPrivacySetting(PrivacySetting positionPrivacySetting) {
		this.positionPrivacySetting = positionPrivacySetting;
	}
	
	/**
	 * Gets the events privacy setting.
	 *
	 * @return the events privacy setting
	 */
	public PrivacySetting getEventsPrivacySetting() {
		return eventsPrivacySetting;
	}
	
	/**
	 * Sets the events privacy setting.
	 *
	 * @param eventsPrivacySetting the new events privacy setting
	 */
	public void setEventsPrivacySetting(PrivacySetting eventsPrivacySetting) {
		this.eventsPrivacySetting = eventsPrivacySetting;
	}
	
	/**
	 * Gets the money privacy setting.
	 *
	 * @return the money privacy setting
	 */
	public PrivacySetting getMoneyPrivacySetting() {
		return moneyPrivacySetting;
	}
	
	/**
	 * Sets the money privacy setting.
	 *
	 * @param moneyPrivacySetting the new money privacy setting
	 */
	public void setMoneyPrivacySetting(PrivacySetting moneyPrivacySetting) {
		this.moneyPrivacySetting = moneyPrivacySetting;
	}
	
	/**
	 * Gets the media privacy setting.
	 *
	 * @return the media privacy setting
	 */
	public PrivacySetting getMediaPrivacySetting() {
		return mediaPrivacySetting;
	}
	
	/**
	 * Sets the media privacy setting.
	 *
	 * @param mediaPrivacySetting the new media privacy setting
	 */
	public void setMediaPrivacySetting(PrivacySetting mediaPrivacySetting) {
		this.mediaPrivacySetting = mediaPrivacySetting;
	}
}