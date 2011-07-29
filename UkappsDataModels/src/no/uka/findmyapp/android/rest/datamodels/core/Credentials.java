/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.core;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Credentials.
 */
public class Credentials implements Serializable 
{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6149780627519173874L;
	
	/** The m key. */
	private String mKey; 
	
	/** The m secret. */
	private String mSecret;
	
	/**
	 * Instantiates a new credentials.
	 *
	 * @param key the key
	 * @param secret the secret
	 */
	public Credentials(String key, String secret) {
		mKey = key; 
		mSecret = secret; 
	}
	
	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey() {
		return mKey;
	}
	
	/**
	 * Sets the key.
	 *
	 * @param key the new key
	 */
	public void setKey(String key) {
		this.mKey = key;
	}
	
	/**
	 * Gets the secret.
	 *
	 * @return the secret
	 */
	public String getSecret() {
		return mSecret;
	}
	
	/**
	 * Sets the secret.
	 *
	 * @param secret the new secret
	 */
	public void setSecret(String secret) {
		this.mSecret = secret;
	} 
	
	/**
	 * Checks if is credentials set.
	 *
	 * @return true, if is credentials set
	 */
	public boolean isCredentialsSet() {
		return (mKey != null && mSecret != null) ? true : false;
	}

	@Override
	public String toString() {
		return "Credentials [mKey=" + mKey + ", mSecret=" + mSecret + "]";
	}
}
