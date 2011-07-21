package no.uka.findmyapp.android.rest.contracts;

import android.net.Uri;
import android.provider.BaseColumns;

public final class Location implements BaseColumns {
	private Location() {
	}

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
	public static class LocationContract implements BaseColumns {

		// This class cannot be instantiated
		private LocationContract() {
		}

		/**
		 * The event table
		 */
		public static final String TABLE_NAME = "location";
		/**
		 * Create uka event table query
		 */
		public static final String CREATE_TABLE_QUERY = "CREATE TABLE "
				+ LocationContract.TABLE_NAME + " (" + LocationContract.ID
				+ " INTEGER PRIMARY KEY, " + LocationContract.LOCATIONNAME
				+ " varchar(255), " + LocationContract.LOCATIONID
				+ " INTEGER, " + ");";

		/**
		 * Drop uka events table
		 */
		public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "
				+ TABLE_NAME + ";";

		/**
		 * The default sort order for this table
		 */
		public static final String DEFAULT_SORT_ORDER = "modified DESC";

		/**
		 * Path part for the event URI
		 */
		public static final String LOCATION_PATH = "/location";

		/**
		 * 0-relative position of a event ID segment in the path part of a event
		 * ID URI
		 */
		public static final int LOCATION_ID_PATH_POSITION = 1;

		/**
		 * The content:// style URL for this table
		 */
		public static final Uri LOCATION_CONTENT_URI = Uri.parse(SCHEME
				+ AUTHORITY + LOCATION_PATH);

		/**
		 * The content URI match pattern for a single event, specified by its
		 * ID. Use this to match incoming URIs or to construct an Intent.
		 */
		public static final Uri LOCATION_CONTENT_ID_URI_PATTERN = Uri
				.parse(SCHEME + AUTHORITY + LOCATION_PATH + "/#");

		/*
		 * MIME-type definition
		 */
		/**
		 * The MIME type of {@link #CONTENT_URI_LOCATION} providing a directory
		 * of event.
		 */
		public static final String CONTENT_TYPE_LOCATION = "vnd.android.cursor.dir/vnd.no.uka.location";

		/**
		 * The MIME type of a {@link #CONTENT_URI_LOCATION} sub-directory of a
		 * single event sample.
		 */
		public static final String CONTENT_ITEM_LOCATION = "vnd.android.cursor.item/vnd.no.uka.location";

		/*
		 * Database columns
		 */

		/**
		 * Column name for the id of the sample
		 * <P>
		 * Type: TEXT
		 * </P>
		 */
		public static final String ID = "_id";

		public static final String LOCATIONNAME = "locationname";
		public static final String LOCATIONID = "locationid";

		/**
		 * Column name for the slug
		 * <P>
		 * Type: VARCHAR(50)
		 * </P>
		 */
		public static final String SLUG = "slug";
	}

}
