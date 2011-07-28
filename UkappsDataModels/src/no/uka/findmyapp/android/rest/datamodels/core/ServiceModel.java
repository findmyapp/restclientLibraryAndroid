/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.datamodels.core;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

import no.uka.findmyapp.android.rest.datamodels.enums.HttpType;
import android.net.Uri;

/**
 * The Class ServiceModel.
 *
 * @author jostein.guldal
 */
public class ServiceModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8851427905103524899L;

	/** The uri. */
	private URI uri;

	/** The http type. */
	private HttpType httpType;

	/** The return type. */
	private String returnType;
	
	/** The parameters needed */
	private String[] parameters; 

	/** The data. */
	private Serializable data;

	/** The content provider uri. */
	private URI contentProviderUri;

	/** The broadcast notification. */
	private String broadcastNotification;

	/**
	 * Instantiates a new service model.
	 */
	public ServiceModel() {
	}

	/**
	 * Instantiates a new service model.
	 * 
	 * @param uri
	 *            the uri
	 * @param httpType
	 *            the http type
	 * @param dataformat
	 *            the dataformat
	 * @param returnType
	 *            the return type
	 * @param data
	 *            the data
	 * @param contentProviderUri
	 *            the content provider uri
	 * @param broadcastNotification
	 *            the broadcast notification
	 * @param localIdentifier
	 *            the local identifier
	 * @throws URISyntaxException
	 *             the uRI syntax exception
	 */
	public ServiceModel(URI uri, HttpType httpType, Class returnType, Serializable data,
			Uri contentProviderUri, String broadcastNotification) throws URISyntaxException {
		super();
		this.uri = uri;
		this.httpType = httpType;
		this.returnType = returnType.getName();
		this.data = data;
		if (contentProviderUri != null) {
			this.contentProviderUri = new URI(contentProviderUri.toString());
		}
		this.broadcastNotification = broadcastNotification;
	}

	/**
	 * Gets the broadcast notification.
	 * 
	 * @return the broadcast notification
	 */
	public String getBroadcastNotification() {
		return broadcastNotification;
	}

	/**
	 * Gets the content provider uri.
	 * 
	 * @return the content provider uri
	 */
	public URI getContentProviderUri() {
		return contentProviderUri;
	}

	/**
	 * Gets the data.
	 * 
	 * @return the data
	 */
	public Serializable getData() {
		return data;
	}

	/**
	 * Gets the http type.
	 * 
	 * @return the http type
	 */
	public HttpType getHttpType() {
		return httpType;
	}

	/**
	 * Gets the return type.
	 * 
	 * @return the return type
	 */
	public String getReturnType() {
		return returnType;
	}

	/**
	 * Gets the uri.
	 * 
	 * @return the uri
	 */
	public URI getUri() {
		return uri;
	}

	/**
	 * Sets the broadcast notification.
	 * 
	 * @param broadcastNotification
	 *            the new broadcast notification
	 */
	public void setBroadcastNotification(String broadcastNotification) {
		this.broadcastNotification = broadcastNotification;
	}

	/**
	 * Sets the content provider uri.
	 * 
	 * @param contentProvider
	 *            the new content provider uri
	 */
	public void setContentProviderUri(URI contentProvider) {
		this.contentProviderUri = contentProvider;
	}

	/**
	 * Sets the data.
	 * 
	 * @param data
	 *            the new data
	 */
	public void setData(Serializable data) {
		this.data = data;
	}

	/**
	 * Sets the http type.
	 * 
	 * @param httpType
	 *            the new http type
	 */
	public void setHttpType(HttpType httpType) {
		this.httpType = httpType;
	}

	/**
	 * Sets the return type.
	 * 
	 * @param returnType
	 *            the new return type
	 */
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	/**
	 * Sets the uri.
	 * 
	 * @param uri
	 *            the new uri
	 */
	public void setUri(URI uri) {
		this.uri = uri;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	

	public String[] getParameters( ) {
		return parameters;
	}

	public void setParameters(String[] parameters ) {
		this.parameters = parameters;
	}	
	
	@Override
	public String toString() {
		return "ServiceModel [uri=" + uri + ", httpType=" + httpType
				+ ", returnType=" + returnType
				+ ", data=" + data + ", contentProviderUri="
				+ contentProviderUri + ", broadcastNotification="
				+ broadcastNotification + "]";
	}
}
