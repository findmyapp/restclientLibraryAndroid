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
 * The Class Location.
 */
public final class Location implements BaseColumns {

	/**
	 * The Class LocationContract.
	 */
	public static class LocationContract implements BaseColumns {

		/** The Constant TABLE_NAME. */
		public static final String TABLE_NAME = "location";

		/** The Constant CREATE_TABLE_QUERY. */
		public static final String CREATE_TABLE_QUERY = "CREATE TABLE "
				+ LocationContract.TABLE_NAME + " (" + LocationContract.ID
				+ " INTEGER PRIMARY KEY, " + LocationContract.LOCATIONNAME
				+ " varchar(255), " + LocationContract.LOCATIONID
				+ " INTEGER);";

		/** The Constant DROP_TABLE_QUERY. */
		public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "
				+ TABLE_NAME + ";";

		/** The Constant DEFAULT_SORT_ORDER. */
		public static final String DEFAULT_SORT_ORDER = "modified DESC";

		/** The Constant LOCATION_PATH. */
		public static final String LOCATION_PATH = "/location";

		/** The Constant LOCATION_ID_PATH_POSITION. */
		public static final int LOCATION_ID_PATH_POSITION = 1;

		/** The Constant LOCATION_CONTENT_URI. */
		public static final Uri LOCATION_CONTENT_URI = Uri.parse(SCHEME
				+ AUTHORITY + LOCATION_PATH);

		/** The Constant LOCATION_CONTENT_ID_URI_PATTERN. */
		public static final Uri LOCATION_CONTENT_ID_URI_PATTERN = Uri
				.parse(SCHEME + AUTHORITY + LOCATION_PATH + "/#");

		/*
		 * MIME-type definition
		 */
		/** The Constant CONTENT_TYPE_LOCATION. */
		public static final String CONTENT_TYPE_LOCATION = "vnd.android.cursor.dir/vnd.no.uka.location";

		/** The Constant CONTENT_ITEM_LOCATION. */
		public static final String CONTENT_ITEM_LOCATION = "vnd.android.cursor.item/vnd.no.uka.location";

		/** The Constant ID. */
		public static final String ID = "_id";

		/*
		 * Database columns
		 */

		/** The Constant LOCATIONNAME. */
		public static final String LOCATIONNAME = "location_name";

		/** The Constant LOCATIONID. */
		public static final String LOCATIONID = "location_id";

		/** The Constant SLUG. */
		public static final String SLUG = "slug";

		// This class cannot be instantiated
		/**
		 * Instantiates a new location contract.
		 */
		private LocationContract() {
		}
	}

	/** The Constant AUTHORITY. */
	public static final String AUTHORITY = "no.uka.findmyapp.android.rest.providers.location";

	/** The Constant SCHEME. */
	public static final String SCHEME = "content://";

	/**
	 * Instantiates a new location.
	 */
	private Location() {
	}

}
