package no.uka.findmyapp.android.rest.datamodels;

import android.content.ContentValues;

public abstract class ProviderModel {
	protected ContentValues contentValues; 
	
	abstract protected void setContentValues();
	
	public ContentValues getContentValues() {
		this.setContentValues();
		return this.contentValues; 
	}
}
