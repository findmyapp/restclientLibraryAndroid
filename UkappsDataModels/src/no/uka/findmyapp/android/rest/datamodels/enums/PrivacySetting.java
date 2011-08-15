/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum PrivacySetting.
 */
public enum PrivacySetting {
//	With which group I will share my information:
	/** The ANYONE. */
ANYONE,
	
	/** The FRIENDS. */
	FRIENDS,
	
	/** The ONL y_ me. */
	ONLY_ME;

	/**
	 * Gets the setting.
	 *
	 * @param a the a
	 * @return the setting
	 */
	public static PrivacySetting getSetting(int a){
		switch(a){
			case 1:
				return ANYONE;
			case 2:
				return FRIENDS;
			default:
				return ONLY_ME;
				// If you input a bad integer then you will get the strongest privacy back
				// Should we cast exception or null instead?
		}
	}
	
	/**
	 * To int.
	 *
	 * @param p the p
	 * @return the int
	 */
	public static int toInt( PrivacySetting p){
		switch(p){
		case ANYONE:
			return 1;
		case FRIENDS:
			return 2;
		default:
			return 3; 
			
		}
	}
}