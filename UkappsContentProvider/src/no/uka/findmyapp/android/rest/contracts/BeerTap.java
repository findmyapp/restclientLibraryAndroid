/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.contracts;

//TODO check table definition datavalues

import android.net.Uri;
import android.provider.BaseColumns;

// TODO: Auto-generated Javadoc
/**
 * The Class BeerTap.
 */
public final class BeerTap implements BaseColumns {

	/**
	 * The Class BeerTapTable.
	 */
	public static class BeerTapTable implements BaseColumns {
		
		/** The Constant TABLE_NAME. */
		public static final String TABLE_NAME = "beertap_sample";

		/** The Constant CREATE_TABLE_QUERY. */
		public static final String CREATE_TABLE_QUERY = "CREATE TABLE "
				+ TABLE_NAME + " (" + BeerTapTable.ID
				+ " INTEGER PRIMARY KEY, " + BeerTapTable.LOCATION_ID
				+ " INTEGER, " + BeerTapTable.DATE + " DATETIME, "
				+ BeerTapTable.BEER_TOWER_NUM + " INTEGER, "
				+ BeerTapTable.VALUE + " FLOAT " + ");";

		/** The Constant DROP_TABLE_QUERY. */
		public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS"
				+ TABLE_NAME + ";";

		/*
		 * URI Definitions
		 */
		/** The Constant PATH. */
		/**
		 * Path part for the beertap samples URI
		 */
		private static final String PATH = "/beertap_samples";

		/** The Constant PATH_ID. */
		private static final String PATH_ID = "/beertap_samples/";

		/** The Constant ID_PATH_POSITION. */
		public static final int ID_PATH_POSITION = 1;

		/** The Constant CONTENT_URI. */
		public static final Uri CONTENT_URI = Uri.parse(SCHEME + AUTHORITY
				+ PATH);

		/** The Constant CONTENT_ID_URI_BASE. */
		public static final Uri CONTENT_ID_URI_BASE = Uri.parse(SCHEME
				+ AUTHORITY + PATH_ID);

		/** The Constant CONTENT_ID_URI_PATTERN. */
		public static final Uri CONTENT_ID_URI_PATTERN = Uri.parse(SCHEME
				+ AUTHORITY + PATH + "/#");

		/*
		 * MIME-type definitions
		 */
		/** The Constant CONTENT_TYPE. */
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.no.uka.sensors.beertap";

		/** The Constant CONTENT_ITEM. */
		public static final String CONTENT_ITEM = "vnd.android.cursor.item/vnd.no.uka.sensors.beertap";

		/** The Constant ID. */
		public static final String ID = "_id";

		/*
		 * Column definitions
		 */

		/** The Constant DATE. */
		public static final String DATE = "date";

		/** The Constant LOCATION_ID. */
		public static final String LOCATION_ID = "location_id";

		/** The Constant BEER_TOWER_NUM. */
		public static final String BEER_TOWER_NUM = "beer_tower_num";

		/** The Constant VALUE. */
		public static final String VALUE = "value";

		// This class cannot be instantiated
		/**
		 * Instantiates a new beer tap table.
		 */
		private BeerTapTable() {
		}
	}

	/** The Constant AUTHORITY. */
	public static final String AUTHORITY = "no.uka.findmyapp.android.rest.providers.sensor";

	/** The Constant SCHEME. */
	public static final String SCHEME = "content://";

	// This class cannot be instantiated
	/**
	 * Instantiates a new beer tap.
	 */
	private BeerTap() {
	}
}