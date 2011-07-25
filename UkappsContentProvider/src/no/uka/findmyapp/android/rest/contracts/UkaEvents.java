/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.contracts;

import android.net.Uri;
import android.provider.BaseColumns;

// TODO: Auto-generated Javadoc
/**
 * Defines a contract between the event content provider and its clients.
 * Clients should only use information given by this "contract" to fetch
 * data from the EventsProvider.
 */
public final class UkaEvents implements BaseColumns{
	
	/**
	 * Instantiates a new uka events.
	 */
	private UkaEvents() {}

    /** Defines the authority part of the URI. */
	public static final String AUTHORITY = "no.uka.findmyapp.android.rest.providers"; 
	
    /** The scheme prefix. */
	public static final String SCHEME = "content://";

    /**
     * Event table contract.
     */
	public static class UkaEventContract implements BaseColumns {
		
		// This class cannot be instantiated
		/**
		 * Instantiates a new uka event contract.
		 */
		private UkaEventContract() {}
		
	    /** The event table. */
	    public static final String TABLE_NAME = "uka_events";
	    
	    /** The event table primary key */
	    public static final String PRIMARY_KEY = "_id";
	    
	    //TODO FIX FAVOURITE FIELD
		/** Create uka event table query. */
		public static final String CREATE_TABLE_QUERY =
			"CREATE TABLE " + TABLE_NAME + " ("	
			+ PRIMARY_KEY + " INTEGER PRIMARY KEY, "
			+ UkaEventContract.ID + " INTEGER, "
			+ UkaEventContract.BILLING_ID + " INTEGER, "
			+ UkaEventContract.ENTRANCE_ID + " INTEGER, "
			+ UkaEventContract.TITLE + " varchar(255), "
			+ UkaEventContract.LEAD + " varchar(255), " 
			+ UkaEventContract.TEXT + " varchar(255), "
			+ UkaEventContract.PLACE + " varchar(30), "
			+ UkaEventContract.FAVOURITE + " BOOLEAN, "
			+ UkaEventContract.EVENT_TYPE + " varchar(30), "
			+ UkaEventContract.IMAGE + " varchar(100), "
			+ UkaEventContract.THUMBNAIL + " varchar(100), "
			+ UkaEventContract.AGE_LIMIT + " INTEGER, "
			+ UkaEventContract.SHOWING_TIME + " TIMESTAMP, "
			+ UkaEventContract.LOWEST_PRICE + " INTEGER, "
			+ UkaEventContract.FREE + " BOOLEAN, "
			+ UkaEventContract.CANCELED + " BOOLEAN"  
			+ ");";
			  
		 /** Drop uka events table. */
		public static final String DROP_TABLE_QUERY = 
			"DROP TABLE IF EXISTS " + TABLE_NAME + ";";
		
        /** Path part for the event URI. */
        public static final String EVENTS_PATH = "/ukaprogram/ukaevents";

        /** Path part for the event ID URI. */
        public static final String EVENTS_ID_PATH = "/ukaevent_samples/";

        /** 0-relative position of a event ID segment in the path part of a event ID URI. */
        public static final int EVENTS_ID_PATH_POSITION = 1;

        /** The content:// style URL for this table. */
        public static final Uri EVENT_CONTENT_URI = Uri.parse(SCHEME + AUTHORITY + EVENTS_PATH);

        /**
         * The content URI base for a single event. Callers must
         * append a numeric event id to this Uri to retrieve a 
         * event.
         */
        public static final Uri EVENT_CONTENT_ID_URI_BASE = Uri.parse(SCHEME + AUTHORITY + EVENTS_ID_PATH);

        /**
         * The content URI match pattern for a single event, specified by its ID. Use this to match
         * incoming URIs or to construct an Intent.
         */
        public static final Uri EVENT_CONTENT_ID_URI_PATTERN = Uri.parse(SCHEME + AUTHORITY + EVENTS_PATH + "/#");

		/*
		 * MIME-type definition 
		 */
	    /**
	     * The MIME type of {@link #CONTENT_URI_EVENT} providing a directory of event.
	     */
	    public static final String CONTENT_TYPE_EVENT = "vnd.android.cursor.dir/vnd.no.uka.event";
	    
	    /**
	     * The MIME type of a {@link #CONTENT_URI_EVENT} sub-directory of a single
	     * event sample.
	     */
	    public static final String CONTENT_ITEM_EVENT = "vnd.android.cursor.item/vnd.no.uka.event";
		
		 /*
         * Database columns 
         */
        /** Column name for the id <P>Type: INTEGER</P>. */
		public static final String ID = "event_id";
		
        /** Column name for the billing id <P>Type: INTEGER</P>. */
		public static final String BILLING_ID = "billing_id";
		
        /** Column name for the entrance id <P>Type: INTEGER</P>. */
		public static final String ENTRANCE_ID = "entrance_id";
		
        /** Column name for the event title <P>Type: VARCHAR(255)</P>. */
		public static final String TITLE = "title";
		
		/**
		 * Column name for the events lead
		 * text/discription.
		 * <P>Type: VARCHAR(255)</P>
		 */
		public static final String LEAD = "lead"; 
		
		/** Column name for the event description <P>Type: VARCHAR(255)</P>. */
		public static final String TEXT = "text";
		
        /** Column name for the event place <P>Type: VARCHAR(30)</P>. */
		public static final String PLACE = "place";
		
        /** Column name for the event type/ category field <P>Type: VARCHAR(30)</P>. */
		public static final String EVENT_TYPE = "event_type";
		
        /** Column name for the image url <P>Type: VARCHAR(100)</P>. */
		public static final String IMAGE = "image";
	
        /** Column name for the image thumbnail url <P>Type: VARCHAR(100)</P>. */
		public static final String THUMBNAIL = "thumbnail";
		
        /** Column name for the age limit <P>Type: SMALLINT</P>. */
		public static final String AGE_LIMIT = "age_limit";
		
        /** Column name for the favourite flag <P>Type: SMALLINT</P>. */
		public static final String FAVOURITE = "favourite";

		/** Column name for the showing time timestamp <P>Type: TIMESTAMP</P>. */
        public static final String SHOWING_TIME = "showing_time";
        
        /** Column name for the free flag <P>Type: BOOLEAN</P>. */
		public static final String FREE = "free";

		/** Column name for the price column <P>Type: INT</P>. */
		public static final String LOWEST_PRICE = "lowest_price";
		
		 /** Column name for the canceled flag <P>Type: BOOLEAN</P>. */
		public static final String CANCELED = "canceled";
	}
}
