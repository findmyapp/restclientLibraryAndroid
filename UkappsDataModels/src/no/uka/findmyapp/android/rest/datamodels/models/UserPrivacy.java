package no.uka.findmyapp.android.rest.datamodels.models;

import no.uka.findmyapp.android.rest.datamodels.enums.PrivacySetting;

public class UserPrivacy {
	private int userPrivacyId;
	private PrivacySetting positionPrivacySetting;
	private PrivacySetting eventsPrivacySetting;
	private PrivacySetting moneyPrivacySetting;
	private PrivacySetting mediaPrivacySetting;

	public int getUserPrivacyId() {
		return userPrivacyId;
	}
	public void setId(int userPrivacyId) {
		this.userPrivacyId = userPrivacyId;
	}
	public PrivacySetting getPositionPrivacySetting() {
		return positionPrivacySetting;
	}
	public void setPositionPrivacySetting(PrivacySetting positionPrivacySetting) {
		this.positionPrivacySetting = positionPrivacySetting;
	}
	public PrivacySetting getEventsPrivacySetting() {
		return eventsPrivacySetting;
	}
	public void setEventsPrivacySetting(PrivacySetting eventsPrivacySetting) {
		this.eventsPrivacySetting = eventsPrivacySetting;
	}
	public PrivacySetting getMoneyPrivacySetting() {
		return moneyPrivacySetting;
	}
	public void setMoneyPrivacySetting(PrivacySetting moneyPrivacySetting) {
		this.moneyPrivacySetting = moneyPrivacySetting;
	}
	public PrivacySetting getMediaPrivacySetting() {
		return mediaPrivacySetting;
	}
	public void setMediaPrivacySetting(PrivacySetting mediaPrivacySetting) {
		this.mediaPrivacySetting = mediaPrivacySetting;
	}
}