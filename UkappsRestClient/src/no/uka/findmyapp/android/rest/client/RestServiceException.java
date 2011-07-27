package no.uka.findmyapp.android.rest.client;

public class RestServiceException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2954387708926813944L;

	public RestServiceException(String exceptionMessage) {
		super(exceptionMessage); 
	}
}
