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
 * The Class Noise.
 */
public final class Noise implements BaseColumns {

	/**
	 * The Class NoiseTable.
	 */
	public static class NoiseTable implements BaseColumns {
		/** The Constant TABLE_NAME. */
		public static final String TABLE_NAME = "noise_sample";

		/** The Constant CREATE_TABLE_QUERY. */
		public static final String CREATE_TABLE_QUERY = "CREATE TABLE "
				+ TABLE_NAME + " (" + NoiseTable.ID + " INTEGER PRIMARY KEY, "
				+ NoiseTable.LOCATION_ID + " INTEGER, " + NoiseTable.AVERAGE
				+ " FLOAT, " + NoiseTable.MIN + " FLOAT, " + NoiseTable.MAX
				+ " FLOAT, " + NoiseTable.STANDARD_DEVIATION + " FLOAT, "
				+ NoiseTable.SAMPLES + " TEXT, " + NoiseTable.DATE
				+ " TIMESTAMP " + ");";

		/** The Constant DROP_TABLE_QUERY. */
		public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "
				+ TABLE_NAME + ";";

		/*
		 * URI Definitions
		 */
		/** The Constant PATH. */
		/**
		 * Path part for the noise samples URI
		 */
		private static final String PATH = "/noise_samples";

		/** The Constant PATH_ID. */
		private static final String PATH_ID = "/noise_samples/";

		/** The Constant ID_PATH_POSITION. */
		public static final int ID_PATH_POSITION = 1;

		/** The Constant CONTENT_URI. */
		public static final Uri CONTENT_URI = Uri.parse(SCHEME + AUTHORITY
				+ PATH);

		/** The Constant ID_URI_BASE. */
		public static final Uri ID_URI_BASE = Uri.parse(SCHEME + AUTHORITY
				+ PATH_ID);

		/** The Constant CONTENT_ID_URI_PATTERN. */
		public static final Uri CONTENT_ID_URI_PATTERN = Uri.parse(SCHEME
				+ AUTHORITY + PATH + "/#");

		/*
		 * MIME-type definitions
		 */
		/** The Constant CONTENT_TYPE. */
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.no.uka.sensors.noise";

		/** The Constant CONTENT_ITEM. */
		public static final String CONTENT_ITEM = "vnd.android.cursor.item/vnd.no.uka.sensors.noise";

		/** The Constant ID. */
		public static final String ID = "_id";

		/*
		 * Column definitions
		 */

		/** The Constant LOCATION_ID. */
		public static final String LOCATION_ID = "location_id";

		/** The Constant AVERAGE. */
		public static final String AVERAGE = "average";

		/** The Constant MAX. */
		public static final String MAX = "max";

		/** The Constant MIN. */
		public static final String MIN = "min";

		/** The Constant STANDARD_DEVIATION. */
		public static final String STANDARD_DEVIATION = "standard_deviation";

		/** The Constant SAMPLES. */
		public static final String SAMPLES = "samples";

		/** The Constant DATE. */
		public static final String DATE = "date";

		// This class cannot be instantiated
		/**
		 * Instantiates a new noise table.
		 */
		private NoiseTable() {
		}
	}

	/** The Constant AUTHORITY. */
	public static final String AUTHORITY = "no.uka.findmyapp.android.rest.providers.sensors.noise";

	/** The Constant SCHEME. */
	public static final String SCHEME = "content://";

	// This class cannot be instantiated
	/**
	 * Instantiates a new noise.
	 */
	private Noise() {
	}
}