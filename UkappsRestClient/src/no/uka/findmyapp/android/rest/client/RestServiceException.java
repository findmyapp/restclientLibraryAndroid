package no.uka.findmyapp.android.rest.client;

public class RestServiceException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2954387708926813944L;

	public RestServiceException(RestHelperException exceptionMessage) {
		super(exceptionMessage.getExceptionMessage()); 
	}
	
	public enum RestHelperException {
		NO_CREDENTIALS("Set API security credentials before calling REST services"), 
		NO_CONNECTION("No internet connection!");
		
		String exception; 
		
		RestHelperException(String exceptionType) { exception = exceptionType; }

		public String getExceptionMessage() {
			return exception;
		}
	}; 
}
