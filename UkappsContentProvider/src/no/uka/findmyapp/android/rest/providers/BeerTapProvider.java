/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.providers;

import java.util.HashMap;

import no.uka.findmyapp.android.rest.contracts.BeerTap;
import no.uka.findmyapp.android.rest.contracts.BeerTap.BeerTapTable;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

// TODO: Auto-generated Javadoc
/**
 * The Class BeerTapProvider.
 */
public class BeerTapProvider extends ContentProvider {

	/**
	 * The Class BeerTapDatabaseHelper.
	 */
	private static class BeerTapDatabaseHelper extends SQLiteOpenHelper {

		/** The Constant debug. */
		private static final String debug = "BeerTapDatabaseHelper";

		/**
		 * Instantiates a new beer tap database helper.
		 *
		 * @param context the context
		 */
		public BeerTapDatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			Log.v(debug, "Inside constructor");
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * android.database.sqlite.SQLiteOpenHelper#onCreate(android.database
		 * .sqlite.SQLiteDatabase)
		 */
		@Override
		public void onCreate(SQLiteDatabase db) {
			Log.v(debug, "Inside onCreate");
			db.execSQL(BeerTapTable.CREATE_TABLE_QUERY);
		}

		// TODO Implement implement UKA-program caching
		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database
		 * .sqlite.SQLiteDatabase, int, int)
		 */
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.v(debug, "Inside onUpgrade");

			Log.w(debug, "Upgrading database, version:" + oldVersion + " to "
					+ newVersion + ", the data is dropped");

			// Drops the table
			db.execSQL(BeerTapTable.DROP_TABLE_QUERY);

			// Recreates the database
			onCreate(db);
		}
	}

	/** The Constant debug. */
	private static final String debug = "BeerTapProvider";

	/** The Constant DATABASE_NAME. */
	private static final String DATABASE_NAME = "beerTap.db";

	/** The Constant DATABASE_VERSION. */
	private static final int DATABASE_VERSION = 15;

	/** The beer tap projection map. */
	private static HashMap<String, String> beerTapProjectionMap;

	/*
	 * Constants used by the Uri matcher to choose an action based on the
	 * pattern of the incoming URI
	 */
	/** The Constant BEERTAP. */
	private static final int BEERTAP = 1;

	/** The Constant BEERTAP_ID. */
	private static final int BEERTAP_ID = 2;

	/** The Constant uriMatcher. */
	private static final UriMatcher uriMatcher;

	/** The db helper. */
	private BeerTapDatabaseHelper dbHelper;

	/**
	 * Instantiates the needed statics.
	 */
	static {
		// initialize the UriMatcher
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

		/**
		 * Initializing the URI mapping for the sensor data.
		 */
		uriMatcher.addURI(BeerTap.AUTHORITY, "beerTap_samples/", BEERTAP);
		uriMatcher.addURI(BeerTap.AUTHORITY, "beerTap_samples/#", BEERTAP_ID);

		/**
		 * Initializing the projection map for the beerTap samples.
		 */
		beerTapProjectionMap = new HashMap<String, String>();

		beerTapProjectionMap.put(BeerTapTable.ID, BeerTapTable.ID);
		beerTapProjectionMap.put(BeerTapTable.LOCATION_ID,
				BeerTapTable.LOCATION_ID);
		beerTapProjectionMap.put(BeerTapTable.VALUE, BeerTapTable.VALUE);
		beerTapProjectionMap.put(BeerTapTable.DATE, BeerTapTable.DATE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.content.ContentProvider#delete(android.net.Uri,
	 * java.lang.String, java.lang.String[])
	 */
	@Override
	public int delete(Uri uri, String where, String[] whereArgs) {
		Log.v(debug, "Inside delete");
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String finalWhere;

		int count;
		switch (uriMatcher.match(uri)) {
		case BEERTAP_ID:
			finalWhere = BeerTapTable.ID + "="
					+ uri.getPathSegments().get(BeerTapTable.ID_PATH_POSITION);

			if (where != null) {
				finalWhere = finalWhere + " AND " + where;
			}
		case BEERTAP:
			count = db.delete(BeerTapTable.TABLE_NAME, where, whereArgs);
			break;

		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}

		getContext().getContentResolver().notifyChange(uri, null);

		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.content.ContentProvider#getType(android.net.Uri)
	 */
	@Override
	public String getType(Uri uri) {
		Log.v(debug, "Inside getType");
		switch (uriMatcher.match(uri)) {
		case BEERTAP:
			return BeerTapTable.CONTENT_TYPE;
		case BEERTAP_ID:
			return BeerTapTable.CONTENT_ITEM;
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.content.ContentProvider#insert (android.net.Uri,
	 * android.content.ContentValues)
	 */
	@Override
	public Uri insert(Uri uri, ContentValues initialValues) {
		Log.v(debug, "Inside insert");
		if (uriMatcher.match(uri) != BEERTAP) {
			throw new IllegalArgumentException("Unknown URI " + uri);
		}

		ContentValues values;
		if (initialValues != null) {
			values = new ContentValues(initialValues);
		} else {
			values = new ContentValues();
		}

		SQLiteDatabase db = dbHelper.getWritableDatabase();
		Log.v(debug, "Insert: selected database " + db.toString());
		Log.v(debug, "Insert: insertvalues " + values.toString());

		/*
		 * The second insert() parameter is a nullColumnHack, a somewhat crappy
		 * solution which is used to avoid queries like "INSERT INTO tablename;"
		 * isn't declared illegal. Instead it automatically creates a statement
		 * like "INSERT INTO beerTap_table (location_id) VALUES (NULL)" in this
		 * case.
		 */
		long rowId = db.insert(BeerTapTable.TABLE_NAME,
				BeerTapTable.LOCATION_ID, values);
		if (rowId > 0) {
			Uri beerTapUri = ContentUris.withAppendedId(
					BeerTapTable.CONTENT_URI, rowId);
			getContext().getContentResolver().notifyChange(uri, null);
			return beerTapUri;
		}

		throw new IllegalArgumentException("InsertUnknown URI: " + uri);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.content.ContentProvider#onCreate()
	 */
	@Override
	public boolean onCreate() {
		Log.v(debug, "Inside onCreate");
		dbHelper = new BeerTapDatabaseHelper(getContext());

		// Returns true by default, throws exceptions if something fails
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.content.ContentProvider#query(android.net.Uri,
	 * java.lang.String[], java.lang.String, java.lang.String[],
	 * java.lang.String)
	 */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		Log.v(debug, "Inside query");
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		qb.setTables(BeerTapTable.TABLE_NAME);

		switch (uriMatcher.match(uri)) {
		case BEERTAP:
			qb.setProjectionMap(beerTapProjectionMap);
			break;
		case BEERTAP_ID:
			qb.setProjectionMap(beerTapProjectionMap);
			qb.appendWhere(BeerTapTable.ID + "="
					+ uri.getPathSegments().get(BeerTapTable.ID_PATH_POSITION));
			break;
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}

		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Log.v(debug, "query: querystatment " + qb.toString());
		Cursor cursor = qb.query(db, projection, selection, selectionArgs,
				null, null, sortOrder);

		// Tells the Cursor what URI to watch, so it
		// knows when its source data changes
		cursor.setNotificationUri(getContext().getContentResolver(), uri);

		return cursor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.content.ContentProvider#update(android.net.Uri,
	 * android.content.ContentValues, java.lang.String, java.lang.String[])
	 */
	@Override
	public int update(Uri uri, ContentValues values, String where,
			String[] whereArgs) {
		Log.v(debug, "Inside update");
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		int count;
		String finalWhere;

		Log.v(debug, "update: values " + values.toString() + " where " + where
				+ " whereArgs " + whereArgs[0]);

		switch (uriMatcher.match(uri)) {
		case BEERTAP_ID:
			String eventId = uri.getPathSegments().get(
					BeerTapTable.ID_PATH_POSITION);
			finalWhere = BeerTapTable.ID + "=" + eventId;

			if (where != null) {
				finalWhere = finalWhere + " AND " + where;
			}
		case BEERTAP:
			count = db
					.update(BeerTapTable.TABLE_NAME, values, where, whereArgs);
			break;
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}

		getContext().getContentResolver().notifyChange(uri, null);

		return count;
	}
}
