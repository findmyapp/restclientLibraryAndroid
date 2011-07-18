package no.uka.findmyapp.android.rest.contracts;

import no.uka.findmyapp.android.rest.contracts.UkaEvents.UkaEventContract;
import android.net.Uri;
import android.provider.BaseColumns;

public final class ServiceInfo implements BaseColumns{
	private ServiceInfo() {}
    /**
     * Defines the authority part of the URI
     */
	public static final String AUTHORITY = "no.uka.findmyapp.android.rest.providers"; 
	
    /**
     * The scheme prefix
     */
	public static final String SCHEME = "content://";

    /** 
     * Event table contract 
     */
	public static class ServiceInfoContract implements BaseColumns {
		
		// This class cannot be instantiated
		private ServiceInfoContract() {}
	    /**
	     * The event table 
	     */
	    public static final String TABLE_NAME = "serviceinfo";
		  /**
		   * Create uka event table query
		   */
		  public static final String CREATE_TABLE_QUERY =
			  "CREATE TABLE " + ServiceInfoContract.TABLE_NAME + " ("	
			  + ServiceInfoContract.ID + " INTEGER PRIMARY KEY, "
			  + ServiceInfoContract.URI + " varchar(255), "
			  + ServiceInfoContract.HTTPTYPE + " varchar(255), "
			  + ServiceInfoContract.DATAFORMAT + " varchar(255), "
			  + ServiceInfoContract.RETURNTYPE + " varchar(255), "
			  + ServiceInfoContract.CONTENTPROVIDER_URI + " varchar(255), " 
			  + ServiceInfoContract.BROADCAST_NOTIFICATION + " varchar(255)"
			  + ServiceInfoContract.SLUG + " varchar(50), "
			  + ");";
		  
		 /**
		  * Drop uka events table
		  */
		public static final String DROP_TABLE_QUERY = 
			"DROP TABLE IF EXISTS " + TABLE_NAME + ";";
		
	    /**
	     * The default sort order for this table
	     */
	    public static final String DEFAULT_SORT_ORDER = "modified DESC";
		
        /**
         * Path part for the event URI
         */
        public static final String SERVICEINFO_PATH = "/serviceinfo";


        /**
         * 0-relative position of a event ID segment in the path part of a event ID URI
         */
        public static final int SERVICEINFO_ID_PATH_POSITION = 1;

        /**
         * The content:// style URL for this table
         */
        public static final Uri SERVICEINFO_CONTENT_URI = Uri.parse(SCHEME + AUTHORITY + SERVICEINFO_PATH);

        /**
         * The content URI match pattern for a single event, specified by its ID. Use this to match
         * incoming URIs or to construct an Intent.
         */
        public static final Uri SERVICEINFO_CONTENT_ID_URI_PATTERN = Uri.parse(SCHEME + AUTHORITY + SERVICEINFO_PATH + "/#");

		/*
		 * MIME-type definition 
		 */
	    /**
	     * The MIME type of {@link #CONTENT_URI_SERVICEINFO} providing a directory of event.
	     */
	    public static final String CONTENT_TYPE_SERVICEINFO = "vnd.android.cursor.dir/vnd.no.uka.serviceinfo";
	    
	    /**
	     * The MIME type of a {@link #CONTENT_URI_SERVICEINFO} sub-directory of a single
	     * event sample.
	     */
	    public static final String CONTENT_ITEM_SERVICEINFO = "vnd.android.cursor.item/vnd.no.uka.serviceinfo";
		
		 /*
         * Database columns 
         */
        /**
         * Column name for the id
         * <P>Type: INTEGER</P>
         */
		public static final String ID = "_id";
		
        /**
         * Column name for the event id
         * <P>Type: INTEGER</P>
         */
		public static final String URI = "uri";
		
        /**
         * Column name for the billing id
         * <P>Type: INTEGER</P>
         */
		public static final String HTTPTYPE = "httptype";
		
        /**
         * Column name for the entrance id
         * <P>Type: INTEGER</P>
         */
		public static final String DATAFORMAT = "dataformat";
		
        /**
         * Column name for the event title
         * <P>Type: VARCHAR(255)</P>
         */
		public static final String RETURNTYPE = "returnType";
		
		/**
		 * Column name for the events lead
		 * text/discription.
		 * <P>Type: VARCHAR(255)</P>
		 */
		public static final String CONTENTPROVIDER_URI = "contentProviderUri"; 
		
		/**
		 * Column name for the event description
		 * <P>Type: VARCHAR(255)</P>
		 */
		public static final String BROADCAST_NOTIFICATION = "broadcastNotification";

        /**
         * Column name for the slug
         * <P>Type: VARCHAR(50)</P>
         */
		public static final String SLUG = "slug";
	}
	
}
