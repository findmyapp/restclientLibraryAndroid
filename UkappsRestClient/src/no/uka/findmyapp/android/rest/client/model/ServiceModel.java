package no.uka.findmyapp.android.rest.client.model;

import java.io.Serializable;
import java.net.URI;

import no.uka.findmyapp.android.rest.client.HttpType;
import no.uka.findmyapp.android.rest.client.ServiceDataFormat;

public class ServiceModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8851427905103524899L;
	private URI uri;
	private HttpType httpType;
	private ServiceDataFormat dataformat; 
	private Class returnType;
	private Serializable data; 
	private URI contentProviderUri; 
	private String broadcastNotification; 
	
	public ServiceModel() { }
	
	public ServiceModel(URI uri, HttpType httpType,
			ServiceDataFormat dataformat, Class returnType, Serializable data,
			URI contentProviderUri, String broadcastNotification) {
		super();
		this.uri = uri;
		this.httpType = httpType;
		this.dataformat = dataformat;
		this.returnType = returnType;
		this.data = data;
		this.contentProviderUri = contentProviderUri;
		this.broadcastNotification = broadcastNotification;
	}

	public ServiceModel(URI uri, HttpType httpType,
			ServiceDataFormat dataformat, Class returnType, Serializable data,
			URI contentProviderUri) {
		this(uri, httpType, dataformat, returnType, data, contentProviderUri, null);
	}

	public ServiceModel(URI uri, HttpType httpType,
			ServiceDataFormat dataformat, Class returnType, Serializable data,
			String broadcastNotification) {
		this(uri, httpType, dataformat, returnType, data, null, broadcastNotification);
	}

	public ServiceModel(URI uri, HttpType httpType,
			ServiceDataFormat dataformat, Class returnType, Serializable data) {
		this(uri, httpType, dataformat, returnType, data, null, null);
	}

	public ServiceModel(URI uri, HttpType httpType,
			ServiceDataFormat dataformat, Class returnType) {
		this(uri, httpType, dataformat, returnType, null, null, null);
	}

	public ServiceModel(URI uri, HttpType httpType,
			ServiceDataFormat dataformat, Class returnType, String broadcastNotification) {
		this(uri, httpType, dataformat, returnType, null, null, broadcastNotification);
	}

	public ServiceModel(URI uri, HttpType httpType,
			ServiceDataFormat dataformat, Class returnType, URI contentProviderUri, String broadcastNotification) {
		this(uri, httpType, dataformat, returnType, null, contentProviderUri, broadcastNotification);
	}
	
	public URI getUri() {
		return uri;
	}
	public void setUri(URI uri) {
		this.uri = uri;
	}
	public HttpType getHttpType() {
		return httpType;
	}
	public void setHttpType(HttpType httpType) {
		this.httpType = httpType;
	}
	
	public ServiceDataFormat getDataformat() {
		return dataformat;
	}

	public void setDataformat(ServiceDataFormat dataformat) {
		this.dataformat = dataformat;
	}

	public Class getReturnType() {
		return returnType;
	}
	public void setReturnType(Class returnType) {
		this.returnType = returnType;
	}
	
	public Serializable getData() {
		return data;
	}

	public void setData(Serializable data) {
		this.data = data;
	}

	public URI getContentProviderUri() {
		return contentProviderUri;
	}

	public void setContentProviderUri(URI contentProvider) {
		this.contentProviderUri = contentProvider;
	}

	public String getBroadcastNotification() {
		return broadcastNotification;
	}

	public void setBroadcastNotification(String broadcastNotification) {
		this.broadcastNotification = broadcastNotification;
	}

	@Override
	public String toString() {
		return "ServiceModel [uri=" + uri + ", httpType=" + httpType
				+ ", returnType=" + returnType + "]";
	}
}
