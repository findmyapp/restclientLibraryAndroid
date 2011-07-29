/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.client;

// TODO: Auto-generated Javadoc
/**
 * The Class RestServiceException.
 */
public class RestServiceException extends Exception
{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2954387708926813944L;

	/**
	 * Instantiates a new rest service exception.
	 *
	 * @param exceptionMessage the exception message
	 */
	public RestServiceException(RestHelperException exceptionMessage) {
		super(exceptionMessage.getExceptionMessage()); 
	}
	
	/**
	 * The Enum RestHelperException.
	 */
	public enum RestHelperException {
		
		/** The N o_ credentials. */
		NO_CREDENTIALS("Set API security credentials before calling REST services"), 
		
		/** The N o_ connection. */
		NO_CONNECTION("No internet connection!");
		
		/** The exception. */
		String exception; 
		
		/**
		 * Instantiates a new rest helper exception.
		 *
		 * @param exceptionType the exception type
		 */
		RestHelperException(String exceptionType) { exception = exceptionType; }

		/**
		 * Gets the exception message.
		 *
		 * @return the exception message
		 */
		public String getExceptionMessage() {
			return exception;
		}
	}; 
}
