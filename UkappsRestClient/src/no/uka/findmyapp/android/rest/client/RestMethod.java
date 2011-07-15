package no.uka.findmyapp.android.rest.client;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;

public class RestMethod {
	
	/** 
	 * Default HTTP status response codes
	 */
	private final int HTTP_STATUS_OK = 200;
	private final int HTTP_STATUS_NOT_MODIFIED = 304;
	private final int HTTP_STATUS_BAD_REQUEST = 400; 
	private final int HTTP_STATUS_UNAUTHORIZED = 401; 
	private final int HTTP_STATUS_FORBIDDEN = 403; 
	private final int HTTP_STATUS_NOT_FOUND = 404; 
	private final int HTTP_STATUS_TIMEOUT = 408;
	private final int HTTP_STATUS_INTERNAL_SERVER_ERROR = 500; 
	private final int UNHANDLED_STATUS_CODE = 666; 
	
	/** 
	 * Default user-agent set to Mozilla Firefox Windows version
	 * {@link #setRequestHeaders(String, HttpGet)}
	 */
	private String useragent = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0"; 
	
	/**
	 * Shared buffer used by {@link #getUrlContent(String)} when reading results
	 * from an API request.
	 */
	private static byte[] streamBuffer = new byte[512];
	
	/**
	 * URL to the REST service server {@link #RestClient(String)}, 
	 * {@link #RestClient(String)} 
	 * {@link #RestClient(String, String)}
	 */
	private URI uri; 
	
	/**
	 * Instance HTTP client
	 */
	private HttpClient client; 
	
	public RestMethod() {
		
	}
	
	/** 
	 * @param url Base URL to the service
	 */
	public RestMethod(URI uri) {
		this.uri = uri; 
	}

	public String getUseragent() {
		return useragent;
	}

	public URI getUri() {
		return this.uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

	public void setUseragent(String useragent) {
		this.useragent = useragent;
	}

	public String get(ServiceDataFormat serviceDataFormat) throws Exception {
		HttpGet request = new HttpGet(this.uri);
		
		return this.execute(setRequestHeaders(serviceDataFormat.getValue(), request));
	}
	
	private HttpRequestBase setRequestHeaders(String expectedDataFormat, HttpRequestBase request) {
		request.setHeader("Accept", expectedDataFormat);
		request.setHeader("Content-type", expectedDataFormat);
		request.setHeader("User-Agent", this.useragent);
		
		return request; 
	}
	
	private String execute(HttpRequestBase request) throws Exception {
		try {
			this.client = new DefaultHttpClient();
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
	 * Throws a HTTPStatusExcetion decided by a response/status code
	 * 
	 * @param statusCode
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
	 * 
	 */
	public static class HTTPStatusException extends Exception {
		private int statusCode; 
		
		public HTTPStatusException(int statusCode, String errorMessage) {
			super(errorMessage);
			this.statusCode = statusCode; 
		}
		/**
		 * @return HTTP status code
		 */
		public int getHttpStatusCode() {
			return this.statusCode; 
		}
	}
}
