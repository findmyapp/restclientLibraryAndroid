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
 * The Class Humidity.
 */
public final class Humidity implements BaseColumns {

	/**
	 * The Class HumidityTable.
	 */
	public static class HumidityTable implements BaseColumns {
		/** The Constant TABLE_NAME. */
		public static final String TABLE_NAME = "humidity_sample";

		/** The Constant CREATE_TABLE_QUERY. */
		public static final String CREATE_TABLE_QUERY = "CREATE TABLE "
				+ TABLE_NAME + " (" + HumidityTable.ID
				+ " INTEGER PRIMARY KEY, " + HumidityTable.LOCATION_ID
				+ " INTEGER, " + HumidityTable.VALUE + " FLOAT, "
				+ HumidityTable.DATE + " TIMESTAMP " + ");";

		/** The Constant DROP_TABLE_QUERY. */
		public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "
				+ TABLE_NAME + ";";

		/*
		 * URI section
		 */
		/** The Constant PATH. */
		private static final String PATH = "/humidity_samples";

		/** The Constant PATH_ID. */
		private static final String PATH_ID = "/humidity_samples/";

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
		 * MIME-type definition
		 */
		/** The Constant CONTENT_TYPE. */
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.no.uka.sensors.humidity";

		/** The Constant CONTENT_ITEM. */
		public static final String CONTENT_ITEM = "vnd.android.cursor.item/vnd.no.uka.sensors.humidity";

		/*
		 * Column definitions
		 */
		/** The Constant ID. */
		public static final String ID = "_id";

		/** The Constant LOCATION_ID. */
		public static final String LOCATION_ID = "location_id";

		/** The Constant VALUE. */
		public static final String VALUE = "value";

		/** The Constant DATE. */
		public static final String DATE = "date";

		// This class cannot be instantiated
		/**
		 * Instantiates a new humidity table.
		 */
		private HumidityTable() {
		}
	}

	/** The Constant AUTHORITY. */
	public static final String AUTHORITY = "no.uka.findmyapp.android.rest.providers.sensors.humidity";

	/** The Constant SCHEME. */
	public static final String SCHEME = "content://";

	// This class cannot be instantiated
	/**
	 * Instantiates a new humidity.
	 */
	private Humidity() {
	}

}