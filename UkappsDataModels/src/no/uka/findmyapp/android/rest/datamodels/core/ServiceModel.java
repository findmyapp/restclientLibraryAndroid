package no.uka.findmyapp.android.rest.datamodels.core;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

import no.uka.findmyapp.android.rest.datamodels.constants.ServiceDataFormat;
import no.uka.findmyapp.android.rest.datamodels.enums.HttpType;
import android.net.Uri;

// TODO: Auto-generated Javadoc
/**
 * The Class ServiceModel.
 */
/**
 * @author jostein.guldal
 *
 */
public class ServiceModel implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8851427905103524899L;
	
	/** The uri. */
	private URI uri;
	
	/** The http type. */
	private HttpType httpType;
	
	/** The dataformat. */
	private ServiceDataFormat dataformat; 
	
	/** The return type. */
	private String returnType;
	
	/** The data. */
	private Serializable data; 
	
	/** The content provider uri. */
	private URI contentProviderUri; 
	
	/** The broadcast notification. */
	private String broadcastNotification; 
	
	private String localIdentifier;
	
	/**
	 * Instantiates a new service model.
	 */
	public ServiceModel() { }
	
	/**
	 * Instantiates a new service model.
	 *
	 * @param uri the URI of the REST service
	 * @param httpType the http type to be used
	 * @param dataformat the dataformat 
	 * @param returnType the return type expected
	 * @param data the data
	 * @param contentProviderUri the content provider uri
	 * @param broadcastNotification the broadcast notification
	 * @throws URISyntaxException the uRI syntax exception
	 */
	public ServiceModel(URI uri, HttpType httpType,
			ServiceDataFormat dataformat, Class returnType, Serializable data,
			Uri contentProviderUri, String broadcastNotification) throws URISyntaxException {
		super();
		this.uri = uri;
		this.httpType = httpType;
		this.dataformat = dataformat;
		this.returnType = returnType.getName();
		this.data = data;
		this.contentProviderUri = new URI(contentProviderUri.toString());
		this.broadcastNotification = broadcastNotification;
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
	 * Sets the uri.
	 *
	 * @param uri the new uri
	 */
	public void setUri(URI uri) {
		this.uri = uri;
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
	 * Sets the http type.
	 *
	 * @param httpType the new http type
	 */
	public void setHttpType(HttpType httpType) {
		this.httpType = httpType;
	}
	
	/**
	 * Gets the dataformat.
	 *
	 * @return the dataformat
	 */
	public ServiceDataFormat getDataformat() {
		return dataformat;
	}

	/**
	 * Sets the dataformat.
	 *
	 * @param dataformat the new dataformat
	 */
	public void setDataformat(ServiceDataFormat dataformat) {
		this.dataformat = dataformat;
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
	 * Sets the return type.
	 *
	 * @param returnType the new return type
	 */
	public void setReturnType(String returnType) {
		this.returnType = returnType;
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
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(Serializable data) {
		this.data = data;
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
	 * Sets the content provider uri.
	 *
	 * @param contentProvider the new content provider uri
	 */
	public void setContentProviderUri(URI contentProvider) {
		this.contentProviderUri = contentProvider;
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
	 * Sets the broadcast notification.
	 *
	 * @param broadcastNotification the new broadcast notification
	 */
	public void setBroadcastNotification(String broadcastNotification) {
		this.broadcastNotification = broadcastNotification;
	}

	public String getLocalIdentifier() {
		return localIdentifier;
	}

	public void setLocalIdentifier(String localIdentifier) {
		this.localIdentifier = localIdentifier;
	}

	@Override
	public String toString() {
		return "ServiceModel [uri=" + uri + ", httpType=" + httpType
				+ ", dataformat=" + dataformat + ", returnType=" + returnType
				+ ", data=" + data + ", contentProviderUri="
				+ contentProviderUri + ", broadcastNotification="
				+ broadcastNotification + ", localIdentifier="
				+ localIdentifier + "]";
	}


}
