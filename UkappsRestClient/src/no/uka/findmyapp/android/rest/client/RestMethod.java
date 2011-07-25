/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.client;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;

import no.uka.findmyapp.android.rest.datamodels.constants.ServiceDataFormat;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;


// TODO: Auto-generated Javadoc
/**
 * The Class RestMethod.
 */
public class RestMethod {
	
	/** Default HTTP status response codes. */
	private final int HTTP_STATUS_OK = 200;
	
	/** The HTT p_ statu s_ no t_ modified. */
	private final int HTTP_STATUS_NOT_MODIFIED = 304;
	
	/** The HTT p_ statu s_ ba d_ request. */
	private final int HTTP_STATUS_BAD_REQUEST = 400; 
	
	/** The HTT p_ statu s_ unauthorized. */
	private final int HTTP_STATUS_UNAUTHORIZED = 401; 
	
	/** The HTT p_ statu s_ forbidden. */
	private final int HTTP_STATUS_FORBIDDEN = 403; 
	
	/** The HTT p_ statu s_ no t_ found. */
	private final int HTTP_STATUS_NOT_FOUND = 404; 
	
	/** The HTT p_ statu s_ timeout. */
	private final int HTTP_STATUS_TIMEOUT = 408;
	
	/** The HTT p_ statu s_ interna l_ serve r_ error. */
	private final int HTTP_STATUS_INTERNAL_SERVER_ERROR = 500; 
	
	/** The UNHANDLE d_ statu s_ code. */
	private final int UNHANDLED_STATUS_CODE = 666; 
	
	/** Default user-agent set to Mozilla Firefox Windows version. {@link #setRequestHeaders(String, HttpGet)} */
	private String useragent = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0"; 
	
	/**
	 * Shared buffer used by {@link #getUrlContent(String)} when reading results
	 * from an API request.
	 */
	private static byte[] streamBuffer = new byte[512];
	
	/** URL to the REST service server {@link #RestClient(String)},. {@link #RestClient(String)} {@link #RestClient(String, String)} */
	private URI uri; 
	
	/** Instance HTTP client. */
	private HttpClient client; 
	
	/** The Constant CONSUMER_KEY. */
	private static final String CONSUMER_KEY = "key";
	
	/** The Constant CONSUMER_SECRET. */
	private static final String CONSUMER_SECRET = "secret";
	
	/** The Constant REQUEST_TOKEN_ENDPOINT_URL. */
	private static final String REQUEST_TOKEN_ENDPOINT_URL = "http://10.0.2.2:8080/findmyapp/oauth/request_token";
	
	/** The Constant ACCESS_TOKEN_ENDPOINT_URL. */
	private static final String ACCESS_TOKEN_ENDPOINT_URL = "http://10.0.2.2:8080/findmyapp/oauth/access_token";
	
	/** The Constant AUTHORIZE_WEBSITE_URL. */
	private static final String AUTHORIZE_WEBSITE_URL = "http://10.0.2.2:8080/findmyapp/oauth/authorize";
	
	/** The provider. */
	private OAuthProvider provider;
	
	/** The consumer. */
	private OAuthConsumer consumer;
	
	/**
	 * Instantiates a new rest method.
	 */
	public RestMethod() {
		provider = new CommonsHttpOAuthProvider(
                REQUEST_TOKEN_ENDPOINT_URL, ACCESS_TOKEN_ENDPOINT_URL,
                AUTHORIZE_WEBSITE_URL);

        consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY,
                                             CONSUMER_SECRET);
	}
	
	/**
	 * Instantiates a new rest method.
	 *
	 * @param uri the uri
	 */
	public RestMethod(URI uri) {
		this();
		this.uri = uri; 
	}

	/**
	 * Gets the useragent.
	 *
	 * @return the useragent
	 */
	public String getUseragent() {
		return useragent;
	}

	/**
	 * Gets the uri.
	 *
	 * @return the uri
	 */
	public URI getUri() {
		return this.uri;
	}

	/**
	 * Sets the uri.
	 *
	 * @param uri the new uri
	 */
	public void setUri(URI uri) {
		this.uri = uri;
	}

	/**
	 * Sets the useragent.
	 *
	 * @param useragent the new useragent
	 */
	public void setUseragent(String useragent) {
		this.useragent = useragent;
	}

	/**
	 * Gets the.
	 *
	 * @param serviceDataFormat the service data format
	 * @return the string
	 * @throws Exception the exception
	 */
	public String get(ServiceDataFormat serviceDataFormat) throws Exception {
		HttpGet request = new HttpGet(this.uri);
		
		return this.execute(setRequestHeaders(serviceDataFormat.getValue(), request));
	}
	
	/**
	 * Sets the request headers.
	 *
	 * @param expectedDataFormat the expected data format
	 * @param request the request
	 * @return the http request base
	 */
	private HttpRequestBase setRequestHeaders(String expectedDataFormat, HttpRequestBase request) {
		request.setHeader("Accept", expectedDataFormat);
		request.setHeader("Content-type", expectedDataFormat);
		//request.setHeader("User-Agent", this.useragent);
		
		return request; 
	}

	/**
	 * Execute.
	 *
	 * @param request the request
	 * @return the string
	 * @throws Exception the exception
	 */
	private String execute(HttpRequestBase request) throws Exception {
		try {
			this.client = new DefaultHttpClient();
			consumer.sign(request);
			HttpResponse response = this.client.execute(request);

			// Check if server response is valid
			StatusLine status = response.getStatusLine();
			if (status.getStatusCode() != HTTP_STATUS_OK) {
				this.throwHttpStatusException(status.getStatusCode());
			}
	
			// Pull content stream from response
			HttpEntity entity = response.getEntity();
			InputStream inputStream = entity.getContent();
	
			ByteArrayOutputStream content = new ByteArrayOutputStream();
	
			// Read response into a buffered stream
			int readBytes = 0;
			while ((readBytes = inputStream.read(streamBuffer)) != -1) {
				content.write(streamBuffer, 0, readBytes);
			}
	
			// Return result from buffered stream
			return new String(content.toByteArray());
		} 
		//TODO Fix errorhandling
		catch (Exception e) {
			throw new Exception(e);
		}
	}

	/**
	 * Throws a HTTPStatusExcetion decided by a response/status code.
	 *
	 * @param statusCode the status code
	 * @throws HTTPStatusException the hTTP status exception
	 */
	private void throwHttpStatusException(int statusCode) throws HTTPStatusException{
		switch (statusCode) {
			case HTTP_STATUS_BAD_REQUEST:
				throw new HTTPStatusException(HTTP_STATUS_BAD_REQUEST, "400 Bad Request (HTTP/1.1 - RFC 2616)");
			case HTTP_STATUS_UNAUTHORIZED:
				throw new HTTPStatusException(HTTP_STATUS_UNAUTHORIZED, "401 Unauthorized (HTTP/1.0 - RFC 1945)");
			case HTTP_STATUS_FORBIDDEN:
				throw new HTTPStatusException(HTTP_STATUS_FORBIDDEN, "401 Unauthorized (HTTP/1.0 - RFC 1945)");
			case HTTP_STATUS_NOT_FOUND:
				throw new HTTPStatusException(HTTP_STATUS_NOT_FOUND, "404 Not Found (HTTP/1.0 - RFC 1945)");
			case HTTP_STATUS_TIMEOUT:
				throw new HTTPStatusException(HTTP_STATUS_TIMEOUT, "408 Request Timeout (HTTP/1.1 - RFC 2616)");
			case HTTP_STATUS_INTERNAL_SERVER_ERROR:
				throw new HTTPStatusException(HTTP_STATUS_INTERNAL_SERVER_ERROR, "500 Server Error (HTTP/1.0 - RFC 1945)");
			default:
				throw new HTTPStatusException(UNHANDLED_STATUS_CODE, "Unhandled status code: " + statusCode);
		}
	}
	
	/**
	 * The Class HTTPStatusException.
	 */
	public static class HTTPStatusException extends Exception {
		
		/** The status code. */
		private int statusCode; 
		
		/**
		 * Instantiates a new hTTP status exception.
		 *
		 * @param statusCode the status code
		 * @param errorMessage the error message
		 */
		public HTTPStatusException(int statusCode, String errorMessage) {
			super(errorMessage);
			this.statusCode = statusCode; 
		}
		
		/**
		 * Gets the http status code.
		 *
		 * @return HTTP status code
		 */
		public int getHttpStatusCode() {
			return this.statusCode; 
		}
	}
}

