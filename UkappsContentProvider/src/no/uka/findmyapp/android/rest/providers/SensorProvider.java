/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.providers;

import java.util.HashMap;

import no.uka.findmyapp.android.rest.contracts.Sensors;
import no.uka.findmyapp.android.rest.contracts.Sensors.BeerTapTable;
import no.uka.findmyapp.android.rest.contracts.Sensors.HumidityTable;
import no.uka.findmyapp.android.rest.contracts.Sensors.NoiseTable;
import no.uka.findmyapp.android.rest.contracts.Sensors.TemperatureTable;
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
 * A sensor content provider which provides access to sensor sample value
 * database. This sensor database contains temperature, noise, humdity and
 * beertap samples.
 */
public class SensorProvider extends ContentProvider {

	// TODO needs refactoring; remove switches, send in table-
	// classes/objects instead of constants?
	
	
	// Debug tag
	/** The Constant debug. */
	private static final String debug = "SensorProvider";
	
	/** The local event database name. */
	private static final String DATABASE_NAME = "sensors.db";

	/** The database version. */
	private static final int DATABASE_VERSION = 1;

	/** The db helper. */
	private DatabaseHelper dbHelper;

	/*
	 * URI patterns constants
	 */
	/** The Constant TEMPERATURE. */
	private static final int TEMPERATURE = 1;
	
	/** The Constant TEMPERATURE_ID. */
	private static final int TEMPERATURE_ID = 2;
	
	/** The Constant HUMIDITY. */
	private static final int HUMIDITY = 3;
	
	/** The Constant HUMIDITY_ID. */
	private static final int HUMIDITY_ID = 4;
	
	/** The Constant NOISE. */
	private static final int NOISE = 5;
	
	/** The Constant NOISE_ID. */
	private static final int NOISE_ID = 6;
	
	/** The Constant BEERTAP. */
	private static final int BEERTAP = 7;
	
	/** The Constant BEERTAP_ID. */
	private static final int BEERTAP_ID = 8;

	/*
	 * UriMatcher
	 */
	/** The Constant uriMatcher. */
	private static final UriMatcher uriMatcher;

	/** The Constant temperatureProjectionMap. */
	private static final HashMap<String, String> temperatureProjectionMap;
	
	/** The Constant humidityProjectionMap. */
	private static final HashMap<String, String> humidityProjectionMap;
	
	/** The Constant noiseProjectionMap. */
	private static final HashMap<String, String> noiseProjectionMap;
	
	/** The Constant beerTapProjectionMap. */
	private static final HashMap<String, String> beerTapProjectionMap;

	static {
		// initialize the UriMatcher
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

		/**
		 * Initializing the URI mapping for the sensor data.
		 */
		uriMatcher.addURI(Sensors.AUTHORITY, "temperature_samples/", TEMPERATURE);
		uriMatcher.addURI(Sensors.AUTHORITY, "temperature_samples/#", TEMPERATURE_ID);
		uriMatcher.addURI(Sensors.AUTHORITY, "humidity_samples/", HUMIDITY);
		uriMatcher.addURI(Sensors.AUTHORITY, "humidity_samples/#", HUMIDITY_ID);
		uriMatcher.addURI(Sensors.AUTHORITY, "noise_samples/", NOISE);
		uriMatcher.addURI(Sensors.AUTHORITY, "noise_samples/#", NOISE_ID);
		uriMatcher.addURI(Sensors.AUTHORITY, "beertap_samples/", BEERTAP);
		uriMatcher.addURI(Sensors.AUTHORITY, "beertap_samples/#", BEERTAP_ID);

		/**
		 * Initializing the projection map for the temperature samples.
		 */
		temperatureProjectionMap = new HashMap<String, String>();
		
		temperatureProjectionMap.put(TemperatureTable.ID, TemperatureTable.ID);
		temperatureProjectionMap.put(TemperatureTable.LOCATION_ID, TemperatureTable.LOCATION_ID);
		temperatureProjectionMap.put(TemperatureTable.VALUE, TemperatureTable.VALUE);
		temperatureProjectionMap.put(TemperatureTable.DATE, TemperatureTable.DATE);

		/**
		 * Initializing the projection map for the humidity samples.
		 */
		humidityProjectionMap = new HashMap<String, String>();
		
		humidityProjectionMap.put(HumidityTable.ID, HumidityTable.ID);
		humidityProjectionMap.put(HumidityTable.LOCATION_ID, HumidityTable.LOCATION_ID);
		humidityProjectionMap.put(HumidityTable.VALUE, HumidityTable.VALUE);
		humidityProjectionMap.put(HumidityTable.DATE, HumidityTable.DATE);

		/**
		 * Initializing the projection map for the noise samples.
		 */
		noiseProjectionMap = new HashMap<String, String>();

		noiseProjectionMap.put(NoiseTable.ID, NoiseTable.ID);
		noiseProjectionMap.put(NoiseTable.LOCATION_ID, NoiseTable.LOCATION_ID);
		noiseProjectionMap.put(NoiseTable.AVERAGE, NoiseTable.AVERAGE);
		noiseProjectionMap.put(NoiseTable.MIN, NoiseTable.MIN);
		noiseProjectionMap.put(NoiseTable.MAX, NoiseTable.MAX);
		noiseProjectionMap.put(NoiseTable.STANDARD_DEVIATION, NoiseTable.STANDARD_DEVIATION);
		noiseProjectionMap.put(NoiseTable.SAMPLES, NoiseTable.SAMPLES);
		noiseProjectionMap.put(NoiseTable.DATE, NoiseTable.DATE);

		/**
		 * Initializing the projection map for the beertap samples.
		 */
		beerTapProjectionMap = new HashMap<String, String>();

		beerTapProjectionMap.put(BeerTapTable.ID, BeerTapTable.ID);
		beerTapProjectionMap.put(BeerTapTable.LOCATION_ID, BeerTapTable.LOCATION_ID);
		beerTapProjectionMap.put(BeerTapTable.VALUE, BeerTapTable.VALUE);
		beerTapProjectionMap.put(BeerTapTable.DATE, BeerTapTable.DATE);
	}
	
	/* (non-Javadoc)
	 * @see android.content.ContentProvider#onCreate()
	 */
	@Override
	public boolean onCreate() {
		Log.d(debug, this + " CREATED");
		dbHelper = new DatabaseHelper(getContext());
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		Log.v(debug, "Created " + db);
		
		boolean b = (dbHelper == null) ? false : true;
		Log.v(debug, "Created " + b);
		
		return b;
	}
	
	/* (non-Javadoc)
	 * @see android.content.ContentProvider#getType(android.net.Uri)
	 */
	@Override
	public String getType(Uri uri) {
		Log.d(debug, "getType()URI: " + uri);
		switch (uriMatcher.match(uri)) {
		case TEMPERATURE:
			return TemperatureTable.CONTENT_TYPE;
		case TEMPERATURE_ID:
			return TemperatureTable.CONTENT_ITEM;
		case HUMIDITY:
			return HumidityTable.CONTENT_TYPE;
		case HUMIDITY_ID:
			return HumidityTable.CONTENT_ITEM;
		case NOISE:
			return NoiseTable.CONTENT_TYPE;
		case NOISE_ID:
			return NoiseTable.CONTENT_ITEM;
		case BEERTAP:
			return BeerTapTable.CONTENT_TYPE;
		case BEERTAP_ID:
			return BeerTapTable.CONTENT_ITEM;
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
	}
	
	/* (non-Javadoc)
	 * @see android.content.ContentProvider#delete(android.net.Uri, java.lang.String, java.lang.String[])
	 */
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int count = 0;
		switch (uriMatcher.match(uri)) {
		case TEMPERATURE_ID:
			selection = this.setWhereArgumentsForSpesificSampleItem(uri, selection, 
					TemperatureTable.ID_PATH_POSITION, TemperatureTable.ID);
		case TEMPERATURE:
			count = this.deleteFromTable(TemperatureTable.TABLE_NAME, TemperatureTable.CREATE_TABLE_QUERY, 
					TemperatureTable.DROP_TABLE_QUERY, selection, selectionArgs);
			break;
			
		case HUMIDITY_ID:
	        selection = this.setWhereArgumentsForSpesificSampleItem(uri, selection,
	        		HumidityTable.ID_PATH_POSITION, HumidityTable.ID);	
		case HUMIDITY:
			count = this.deleteFromTable(HumidityTable.TABLE_NAME, HumidityTable.CREATE_TABLE_QUERY, 
					HumidityTable.DROP_TABLE_QUERY, selection, selectionArgs);
			break;
			
		case NOISE_ID:
			selection = this.setWhereArgumentsForSpesificSampleItem(uri, selection,
	        		NoiseTable.ID_PATH_POSITION, NoiseTable.ID);	
		case NOISE:
			count = this.deleteFromTable(NoiseTable.TABLE_NAME, NoiseTable.CREATE_TABLE_QUERY, 
					NoiseTable.DROP_TABLE_QUERY, selection, selectionArgs);
			break;
			
		case BEERTAP_ID:
			selection = this.setWhereArgumentsForSpesificSampleItem(uri, selection,
	        		BeerTapTable.ID_PATH_POSITION, BeerTapTable.ID);	
		case BEERTAP:
			count = this.deleteFromTable(BeerTapTable.TABLE_NAME, BeerTapTable.CREATE_TABLE_QUERY, 
					BeerTapTable.DROP_TABLE_QUERY, selection, selectionArgs);
					
			break;
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
		
		return count;
	}

	/* (non-Javadoc)
	 * @see android.content.ContentProvider#insert(android.net.Uri, android.content.ContentValues)
	 */
	@Override
	public Uri insert(Uri uri, ContentValues initValues) {
		Log.v(debug, "insert: uri " + uri.toString()); 
		Uri retUri; 
		switch (uriMatcher.match(uri)) {
			case TEMPERATURE:
				retUri = insertRowInTable(uri, initValues, TemperatureTable.CREATE_TABLE_QUERY,
							 TemperatureTable.DROP_TABLE_QUERY, TemperatureTable.TABLE_NAME, 
							 TemperatureTable.LOCATION_ID, TemperatureTable.CONTENT_URI); 
				break;
			case HUMIDITY:
				retUri = insertRowInTable(uri, initValues, HumidityTable.CREATE_TABLE_QUERY,
							 HumidityTable.DROP_TABLE_QUERY, HumidityTable.TABLE_NAME, 
							 HumidityTable.LOCATION_ID, HumidityTable.CONTENT_URI); 
				break;
			case NOISE:
				retUri = insertRowInTable(uri, initValues, TemperatureTable.CREATE_TABLE_QUERY,
							 TemperatureTable.DROP_TABLE_QUERY, TemperatureTable.TABLE_NAME, 
							 TemperatureTable.LOCATION_ID, TemperatureTable.CONTENT_URI); 
				break;
			case BEERTAP:
				retUri = insertRowInTable(uri, initValues, TemperatureTable.CREATE_TABLE_QUERY,
							 TemperatureTable.DROP_TABLE_QUERY, TemperatureTable.TABLE_NAME, 
							 TemperatureTable.LOCATION_ID, TemperatureTable.CONTENT_URI); 
				break;
				
			default:
				throw new IllegalArgumentException("Unknown URI " + uri);
		}

		return retUri; 
	}

	/**
	 * Insert row in table.
	 *
	 * @param uri the uri
	 * @param initValues the init values
	 * @param createTableQuery the create table query
	 * @param dropTableQuery the drop table query
	 * @param tableName the table name
	 * @param nullColumn the null column
	 * @param contentProviderUri the content provider uri
	 * @return the uri
	 */
	private Uri insertRowInTable(Uri uri, ContentValues initValues, String createTableQuery, 
			String dropTableQuery, String tableName, String nullColumn, 
			Uri contentProviderUri) {
		Log.v(debug, "insertRowInTable(): URI - INSERT " + uri);

		ContentValues values;
		if (initValues != null) {
			values = new ContentValues(initValues);
		} else {
			values = new ContentValues();
		}
		
		DatabaseHelper dbh = new DatabaseHelper(getContext(), createTableQuery, dropTableQuery);
		SQLiteDatabase db = dbh.getWritableDatabase();
		Log.v(debug, "DB: " + db.toString());

		/*
		 * The second insert() parameter is a nullColumnHack, a somewhat crappy
		 * solution that is used to avoid queries like "INSERT INTO tablename;"
		 * isn't declared illegal. Instead it automatically creates a statement
		 * like "INSERT INTO tableName (nullColumn) VALUES (NULL)" in
		 * this case.
		 */
		long rowId = db.insert(tableName,
				nullColumn, values);
		if (rowId > 0) {
			Uri temperatureUri = ContentUris.withAppendedId(
				contentProviderUri, rowId);
				
			getContext().getContentResolver().notifyChange(uri, null);

			return temperatureUri;
		}
		throw new IllegalArgumentException("InsertUnknown URI: " + uri);
	}

	/* (non-Javadoc)
	 * @see android.content.ContentProvider#query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String)
	 */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		
		switch (uriMatcher.match(uri)) {
		case TEMPERATURE_ID:
	        selection = this.setWhereArgumentsForSpesificSampleItem(uri, selection,
	        		TemperatureTable.ID_PATH_POSITION, TemperatureTable.ID);			
		case TEMPERATURE:
			qb.setTables(TemperatureTable.TABLE_NAME);
			qb.setProjectionMap(temperatureProjectionMap);
			break;

		case HUMIDITY_ID:
	        selection = this.setWhereArgumentsForSpesificSampleItem(uri, selection,
	        		HumidityTable.ID_PATH_POSITION, HumidityTable.ID);	
		case HUMIDITY:
			qb.setTables(HumidityTable.TABLE_NAME);
			qb.setProjectionMap(humidityProjectionMap);
			break;
			
		case NOISE_ID:
	        selection = this.setWhereArgumentsForSpesificSampleItem(uri, selection,
	        		NoiseTable.ID_PATH_POSITION, NoiseTable.ID);	
		case NOISE:
			qb.setTables(NoiseTable.TABLE_NAME);
			qb.setProjectionMap(noiseProjectionMap);
			break;

		case BEERTAP_ID:
	        selection = this.setWhereArgumentsForSpesificSampleItem(uri, selection,
	        		BeerTapTable.ID_PATH_POSITION, BeerTapTable.ID);	
		case BEERTAP:
			qb.setTables(BeerTapTable.TABLE_NAME);
			qb.setProjectionMap(beerTapProjectionMap);
			break;
			
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}

		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Log.v(debug, "DB: " + db.toString());
		Log.v(debug, "URI: " + uri);
		Cursor c = qb.query(db, projection, selection, selectionArgs, null,
				null, sortOrder);

		c.setNotificationUri(getContext().getContentResolver(), uri);
		return c;
	}

	/* (non-Javadoc)
	 * @see android.content.ContentProvider#update(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[])
	 */
	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		int count = 0;
		switch (uriMatcher.match(uri)) {
		case TEMPERATURE_ID:
			selection = this.setWhereArgumentsForSpesificSampleItem(uri, selection, 
					TemperatureTable.ID_PATH_POSITION, TemperatureTable.ID);
		case TEMPERATURE:
			count = this.updateTable(TemperatureTable.TABLE_NAME, TemperatureTable.CREATE_TABLE_QUERY, 
					TemperatureTable.DROP_TABLE_QUERY, values, selection, selectionArgs);
			break;

		case HUMIDITY_ID:
			selection = this.setWhereArgumentsForSpesificSampleItem(uri, selection, 
					HumidityTable.ID_PATH_POSITION, HumidityTable.ID);
		case HUMIDITY:
			count = this.updateTable(HumidityTable.TABLE_NAME, HumidityTable.CREATE_TABLE_QUERY, 
					HumidityTable.DROP_TABLE_QUERY, values, selection, selectionArgs);
			break;

		case NOISE_ID:
			selection = this.setWhereArgumentsForSpesificSampleItem(uri, selection, 
					NoiseTable.ID_PATH_POSITION, NoiseTable.ID);
		case NOISE:
			count = this.updateTable(NoiseTable.TABLE_NAME, NoiseTable.CREATE_TABLE_QUERY, 
					NoiseTable.DROP_TABLE_QUERY, values, selection, selectionArgs);
			break;

		case BEERTAP_ID:
			selection = this.setWhereArgumentsForSpesificSampleItem(uri, selection, 
					BeerTapTable.ID_PATH_POSITION, BeerTapTable.ID);
		case BEERTAP:
			count = this.updateTable(BeerTapTable.TABLE_NAME, BeerTapTable.CREATE_TABLE_QUERY, 
					BeerTapTable.DROP_TABLE_QUERY, values, selection, selectionArgs);
			break;
			
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}

		getContext().getContentResolver().notifyChange(uri, null);

		return count;
	}

	/**
	 * Sets the where arguments for spesific sample item.
	 *
	 * @param uri the uri
	 * @param selection the selection
	 * @param idPathPositionInUri the id path position in uri
	 * @param tableIdColumnName the table id column name
	 * @return the string
	 */
	private String setWhereArgumentsForSpesificSampleItem(Uri uri, String selection, int idPathPositionInUri, String tableIdColumnName) {
		String itemId = uri.getPathSegments().get(idPathPositionInUri);
		String finalSelection = tableIdColumnName + " = " + itemId; 
		
		if(selection != null) {
			finalSelection = finalSelection + " AND " + selection; 
		}
		
		return finalSelection; 
	}

	/**
	 * Update table.
	 *
	 * @param tableName the table name
	 * @param createTableQuery the create table query
	 * @param dropTableQuery the drop table query
	 * @param values the values
	 * @param selection the selection
	 * @param selectionArgs the selection args
	 * @return the int
	 */
	private int updateTable(String tableName, String createTableQuery, String dropTableQuery, 
			ContentValues values, String selection, String[] selectionArgs) {
		int count;
		DatabaseHelper dbh = new DatabaseHelper(getContext(), createTableQuery, dropTableQuery); 
		SQLiteDatabase db = dbh.getWritableDatabase();
		count = db.update(tableName, values, selection, selectionArgs);
		
		return count;
	}
	
	/**
	 * Delete from table.
	 *
	 * @param tableName the table name
	 * @param createTableQuery the create table query
	 * @param dropTableQuery the drop table query
	 * @param selection the selection
	 * @param selectionArgs the selection args
	 * @return the int
	 */
	private int deleteFromTable(String tableName, String createTableQuery, String dropTableQuery, 
			String selection, String[] selectionArgs) {
		int count;
		DatabaseHelper dbh = new DatabaseHelper(getContext(), createTableQuery, dropTableQuery); 
		SQLiteDatabase db = dbh.getWritableDatabase();
		count = db.delete(tableName, selection, selectionArgs);
		
		return count;
	}

	/**
	 * The Class DatabaseHelper.
	 */
	public class DatabaseHelper extends SQLiteOpenHelper {
		
		/** The create table query. */
		private String createTableQuery;
		
		/** The drop table query. */
		private String dropTableQuery;
		
		/**
		 * Instantiates a new database helper.
		 *
		 * @param context the context
		 */
		public DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		
		/**
		 * Instantiates a new database helper.
		 *
		 * @param context the context
		 * @param createTableQuery the create table query
		 * @param dropTableQuery the drop table query
		 */
		public DatabaseHelper(Context context, String createTableQuery,
				String dropTableQuery) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			this.createTableQuery = createTableQuery;
			this.dropTableQuery = dropTableQuery;
		}

		/**
		 * Creates the database table when the object is created.
		 *
		 * @param db the db
		 */
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(this.createTableQuery);
		}

		/* (non-Javadoc)
		 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
		 */
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w(debug, "Upgrading database, version:" + oldVersion
					+ " to " + newVersion + ", the data is dropped");

			// Drops the table
			db.execSQL("DROP TABLE IF EXISTS notes");

			// Recreates the database
			onCreate(db);
		}
	}
}