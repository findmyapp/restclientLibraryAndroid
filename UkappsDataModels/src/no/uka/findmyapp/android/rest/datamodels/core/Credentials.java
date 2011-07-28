package no.uka.findmyapp.android.rest.datamodels.core;

import java.io.Serializable;

public class Credentials implements Serializable 
{
	private static final long serialVersionUID = 6149780627519173874L;
	private String mKey; 
	private String mSecret;
	
	public Credentials(String key, String secret) {
		mKey = key; 
		mSecret = secret; 
	}
	
	public String getKey() {
		return mKey;
	}
	public void setKey(String key) {
		this.mKey = key;
	}
	public String getSecret() {
		return mSecret;
	}
	public void setSecret(String secret) {
		this.mSecret = secret;
	} 
	
	public boolean isCredentialsSet() {
		return (mKey != null && mSecret != null) ? true : false;
	}
}
