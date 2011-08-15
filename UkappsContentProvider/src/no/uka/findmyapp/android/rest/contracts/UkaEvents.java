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
 * The Class UkaEvents.
 */
public final class UkaEvents implements BaseColumns {

	/**
	 * The Class UkaEventContract.
	 */
	public static class UkaEventContract implements BaseColumns {

		/** The Constant TABLE_NAME. */
		public static final String TABLE_NAME = "uka_events";

		/** The Constant PRIMARY_KEY. */
		public static final String PRIMARY_KEY = "_id";

		// TODO FIX FAVOURITE FIELD
		/** The Constant CREATE_TABLE_QUERY. */
		public static final String CREATE_TABLE_QUERY = "CREATE TABLE "
				+ TABLE_NAME + " (" + PRIMARY_KEY + " INTEGER PRIMARY KEY, "
				+ UkaEventContract.ID + " INTEGER, "
				+ UkaEventContract.BILLING_ID + " INTEGER, "
				+ UkaEventContract.ENTRANCE_ID + " INTEGER, "
				+ UkaEventContract.TITLE + " VARCHAR(255), "
				+ UkaEventContract.LEAD + " VARCHAR(255), "
				+ UkaEventContract.TEXT + " VARCHAR(255), "
				+ UkaEventContract.PLACE + " VARCHAR(30), "
				+ UkaEventContract.FAVOURITE + " BOOLEAN, "
				+ UkaEventContract.EVENT_TYPE + " VARCHAR(30), "
				+ UkaEventContract.IMAGE + " VARCHAR(100), "
				+ UkaEventContract.THUMBNAIL + " VARCHAR(100), "
				+ UkaEventContract.AGE_LIMIT + " INTEGER, "
				+ UkaEventContract.SHOWING_TIME + " TIMESTAMP, "
				+ UkaEventContract.LOWEST_PRICE + " INTEGER, "
				+ UkaEventContract.FREE + " BOOLEAN, "
				+ UkaEventContract.SPOTIFY_STRING + " VARCHAR(50), "
				+ UkaEventContract.UPDATED_DATE + " TIMESTAMP, "
				+ UkaEventContract.PLACE_STRING + " VARCHAR(50), "
				+ UkaEventContract.CANCELED + " BOOLEAN" + ");";

		/** The Constant DROP_TABLE_QUERY. */
		public static final String DROP_TABLE_QUERY = 
			"DROP TABLE IF EXISTS " + TABLE_NAME + ";";

		/** The Constant EVENTS_PATH. */
		public static final String EVENTS_PATH = "/ukaevents";

		/** The Constant EVENTS_ID_PATH. */
		public static final String EVENTS_ID_PATH = "/ukaevent_samples/";

		/** The Constant EVENTS_ID_PATH_POSITION. */
		public static final int EVENTS_ID_PATH_POSITION = 1;

		/** The Constant EVENT_CONTENT_URI. */
		public static final Uri EVENT_CONTENT_URI = Uri.parse(SCHEME
				+ AUTHORITY + EVENTS_PATH);

		/** The Constant EVENT_CONTENT_ID_URI_BASE. */
		public static final Uri EVENT_CONTENT_ID_URI_BASE = Uri.parse(SCHEME
				+ AUTHORITY + EVENTS_ID_PATH);

		/** The Constant EVENT_CONTENT_ID_URI_PATTERN. */
		public static final Uri EVENT_CONTENT_ID_URI_PATTERN = Uri.parse(SCHEME
				+ AUTHORITY + EVENTS_PATH + "/#");

		/*
		 * MIME-type definition
		 */
		/** The Constant CONTENT_TYPE_EVENT. */
		public static final String CONTENT_TYPE_EVENT = "vnd.android.cursor.dir/vnd.no.uka.event";

		/** The Constant CONTENT_ITEM_EVENT. */
		public static final String CONTENT_ITEM_EVENT = "vnd.android.cursor.item/vnd.no.uka.event";

		/*
		 * Database columns
		 */
		/** The Constant ID. */
		public static final String ID = "event_id";

		/** The Constant BILLING_ID. */
		public static final String BILLING_ID = "billing_id";

		/** The Constant ENTRANCE_ID. */
		public static final String ENTRANCE_ID = "entrance_id";

		/** The Constant TITLE. */
		public static final String TITLE = "title";

		/** The Constant LEAD. */
		public static final String LEAD = "lead";

		/** The Constant TEXT. */
		public static final String TEXT = "text";

		/** The Constant PLACE. */
		public static final String PLACE = "place";

		/** The Constant EVENT_TYPE. */
		public static final String EVENT_TYPE = "event_type";

		/** The Constant IMAGE. */
		public static final String IMAGE = "image";

		/** The Constant THUMBNAIL. */
		public static final String THUMBNAIL = "thumbnail";

		/** The Constant AGE_LIMIT. */
		public static final String AGE_LIMIT = "age_limit";

		/** The Constant FAVOURITE. */
		public static final String FAVOURITE = "favourite";

		/** The Constant SHOWING_TIME. */
		public static final String SHOWING_TIME = "showing_time";

		/** The Constant FREE. */
		public static final String FREE = "free";

		/** The Constant LOWEST_PRICE. */
		public static final String LOWEST_PRICE = "lowest_price";

		/** The Constant SPOTIFY_STRING. */
		public static final String SPOTIFY_STRING = "spotify_string";
		
		/** The Constant UPDATED_DATE. */
		public static final String UPDATED_DATE = "update_date";
		
		/** The Constant CANCELED. */
		public static final String CANCELED = "canceled";
		
		/** The Constant PLACE_STRING. */
		public static final String PLACE_STRING = "places_string";

		// This class cannot be instantiated
		/**
		 * Instantiates a new uka event contract.
		 */
		private UkaEventContract() {
		}
	}

	/** The Constant AUTHORITY. */
	public static final String AUTHORITY = "no.uka.findmyapp.android.rest.providers.program";

	/** The Constant SCHEME. */
	public static final String SCHEME = "content://";

	/**
	 * Instantiates a new uka events.
	 */
	private UkaEvents() {
	}
}
