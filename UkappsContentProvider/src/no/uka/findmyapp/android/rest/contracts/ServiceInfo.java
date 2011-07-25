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
 * The Class ServiceInfo.
 */
public final class ServiceInfo implements BaseColumns {

	/**
	 * The Class ServiceInfoContract.
	 */
	public static class ServiceInfoContract implements BaseColumns {

		/** The Constant TABLE_NAME. */
		public static final String TABLE_NAME = "serviceinfo";

		/** The Constant CREATE_TABLE_QUERY. */
		public static final String CREATE_TABLE_QUERY = "CREATE TABLE "
				+ ServiceInfoContract.TABLE_NAME + " ("
				+ ServiceInfoContract.ID + " INTEGER PRIMARY KEY, "
				+ ServiceInfoContract.URI + " varchar(255), "
				+ ServiceInfoContract.HTTPTYPE + " varchar(255), "
				+ ServiceInfoContract.DATAFORMAT + " varchar(255), "
				+ ServiceInfoContract.RETURNTYPE + " varchar(255), "
				+ ServiceInfoContract.CONTENTPROVIDER_URI + " varchar(255), "
				+ ServiceInfoContract.BROADCAST_NOTIFICATION + " varchar(255)"
				+ ServiceInfoContract.SLUG + " varchar(50), " + ");";

		/** The Constant DROP_TABLE_QUERY. */
		public static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "
				+ TABLE_NAME + ";";

		/** The Constant DEFAULT_SORT_ORDER. */
		public static final String DEFAULT_SORT_ORDER = "modified DESC";

		/** The Constant SERVICEINFO_PATH. */
		public static final String SERVICEINFO_PATH = "/serviceinfo";

		/** The Constant SERVICEINFO_ID_PATH_POSITION. */
		public static final int SERVICEINFO_ID_PATH_POSITION = 1;

		/** The Constant SERVICEINFO_CONTENT_URI. */
		public static final Uri SERVICEINFO_CONTENT_URI = Uri.parse(SCHEME
				+ AUTHORITY + SERVICEINFO_PATH);

		/** The Constant SERVICEINFO_CONTENT_ID_URI_PATTERN. */
		public static final Uri SERVICEINFO_CONTENT_ID_URI_PATTERN = Uri
				.parse(SCHEME + AUTHORITY + SERVICEINFO_PATH + "/#");

		/*
		 * MIME-type definition
		 */
		/** The Constant CONTENT_TYPE_SERVICEINFO. */
		public static final String CONTENT_TYPE_SERVICEINFO = "vnd.android.cursor.dir/vnd.no.uka.serviceinfo";

		/** The Constant CONTENT_ITEM_SERVICEINFO. */
		public static final String CONTENT_ITEM_SERVICEINFO = "vnd.android.cursor.item/vnd.no.uka.serviceinfo";

		/*
		 * Database columns
		 */
		/** The Constant ID. */
		public static final String ID = "_id";

		/** The Constant URI. */
		public static final String URI = "uri";

		/** The Constant HTTPTYPE. */
		public static final String HTTPTYPE = "httptype";

		/** The Constant DATAFORMAT. */
		public static final String DATAFORMAT = "dataformat";

		/** The Constant RETURNTYPE. */
		public static final String RETURNTYPE = "returnType";

		/** The Constant CONTENTPROVIDER_URI. */
		public static final String CONTENTPROVIDER_URI = "contentProviderUri";

		/** The Constant BROADCAST_NOTIFICATION. */
		public static final String BROADCAST_NOTIFICATION = "broadcastNotification";

		/** The Constant SLUG. */
		public static final String SLUG = "slug";

		// This class cannot be instantiated
		/**
		 * Instantiates a new service info contract.
		 */
		private ServiceInfoContract() {
		}
	}

	/** The Constant AUTHORITY. */
	public static final String AUTHORITY = "no.uka.findmyapp.android.rest.providers";

	/** The Constant SCHEME. */
	public static final String SCHEME = "content://";

	/**
	 * Instantiates a new service info.
	 */
	private ServiceInfo() {
	}

}
