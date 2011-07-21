package no.uka.findmyapp.android.rest.client;

/**
 * @author jostein.guldal
 * 
 * 
 */

public enum UkappsServices {
	/**
	* First thing
	*/
	UKAEVENTS("getUkaProgramForDate"),
	/**
	* S thing
	*/
	TEMPERATURE_SAMPLE("");
	
	String mapperName;
	
	UkappsServices(String mapperName) {
		this.mapperName = mapperName;
	}
	
	
	public String getMapperName() {
		return mapperName;
	}
}
