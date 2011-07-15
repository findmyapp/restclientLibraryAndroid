package no.uka.findmyapp.android.rest.providers;

import java.util.HashMap;

import no.uka.findmyapp.android.rest.contracts.Sensors;
import no.uka.findmyapp.android.rest.contracts.Sensors.BeerTapTable;
import no.uka.findmyapp.android.rest.contracts.Sensors.HumidityTable;
import no.uka.findmyapp.android.rest.contracts.Sensors.NoiseTable;
import no.uka.findmyapp.android.rest.contracts.Sensors.TemperatureTable;
import no.uka.findmyapp.android.rest.contracts.UkaEvents.UkaEventContract;
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

/**
 * A sensor content provider which provides access to sensor sample value
 * database. This sensor database contains temperature, noise, humdity and
 * beertap samples.
 */
public class SensorProvider extends ContentProvider {

	/**
	 * The local event database name
	 */
	private static final String DATABASE_NAME = "sensors.db";

	/**
	 * The database version
	 */
	private static final int DATABASE_VERSION = 2;

	// Debug tag
	private static final String DEBUG_TAG = "SensorProvider";

	private DatabaseHelper dbHelper;

	/*
	 * URI patterns constants
	 */
	private static final int TEMPERATURE = 1;
	private static final int TEMPERATURE_ID = 2;
	private static final int HUMIDITY = 3;
	private static final int HUMIDITY_ID = 4;
	private static final int NOISE = 5;
	private static final int NOISE_ID = 6;
	private static final int BEERTAP = 7;
	private static final int BEERTAP_ID = 8;

	/*
	 * UriMatcher
	 */
	private static final UriMatcher uriMatcher;

	private static final HashMap<String, String> temperatureProjectionMap;
	private static final HashMap<String, String> humidityProjectionMap;
	private static final HashMap<String, String> noiseProjectionMap;
	private static final HashMap<String, String> beerTapProjectionMap;

	static {
		// initialize the UriMatcher
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

		/**
		 * Initializing the URI mapping for the sensor data.
		 */
		uriMatcher.addURI(Sensors.AUTHORITY, "temperature_samples/",
				TEMPERATURE);
		uriMatcher.addURI(Sensors.AUTHORITY, "temperature_samples/#",
				TEMPERATURE_ID);
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

		temperatureProjectionMap.put(Sensors.TemperatureTable.ID,
				Sensors.TemperatureTable.ID);
		temperatureProjectionMap.put(Sensors.TemperatureTable.LOCATION_ID,
				Sensors.TemperatureTable.LOCATION_ID);
		temperatureProjectionMap.put(Sensors.TemperatureTable.VALUE,
				Sensors.TemperatureTable.VALUE);
		temperatureProjectionMap.put(Sensors.TemperatureTable.DATE,
				Sensors.TemperatureTable.DATE);

		/**
		 * Initializing the projection map for the humidity samples.
		 */
		humidityProjectionMap = new HashMap<String, String>();

		humidityProjectionMap.put(Sensors.HumidityTable.ID,
				Sensors.HumidityTable.ID);
		humidityProjectionMap.put(Sensors.HumidityTable.LOCATION_ID,
				Sensors.HumidityTable.LOCATION_ID);
		humidityProjectionMap.put(Sensors.HumidityTable.VALUE,
				Sensors.HumidityTable.VALUE);
		humidityProjectionMap.put(Sensors.HumidityTable.DATE,
				Sensors.HumidityTable.DATE);

		/**
		 * Initializing the projection map for the noise samples.
		 */
		noiseProjectionMap = new HashMap<String, String>();

		noiseProjectionMap.put(Sensors.NoiseTable.ID, Sensors.NoiseTable.ID);
		noiseProjectionMap.put(Sensors.NoiseTable.LOCATION_ID,
				Sensors.NoiseTable.LOCATION_ID);
		noiseProjectionMap.put(Sensors.NoiseTable.AVERAGE,
				Sensors.NoiseTable.AVERAGE);
		noiseProjectionMap.put(Sensors.NoiseTable.MIN, Sensors.NoiseTable.MIN);
		noiseProjectionMap.put(Sensors.NoiseTable.MAX, Sensors.NoiseTable.MAX);
		noiseProjectionMap.put(Sensors.NoiseTable.STANDARD_DEVIATION,
				Sensors.NoiseTable.STANDARD_DEVIATION);
		noiseProjectionMap.put(Sensors.NoiseTable.SAMPLES,
				Sensors.NoiseTable.SAMPLES);
		noiseProjectionMap
				.put(Sensors.NoiseTable.DATE, Sensors.NoiseTable.DATE);

		/**
		 * Initializing the projection map for the beertap samples.
		 */
		beerTapProjectionMap = new HashMap<String, String>();

		beerTapProjectionMap.put(Sensors.BeerTapTable.ID,
				Sensors.BeerTapTable.ID);
		beerTapProjectionMap.put(Sensors.BeerTapTable.LOCATION_ID,
				Sensors.BeerTapTable.LOCATION_ID);
		beerTapProjectionMap.put(Sensors.BeerTapTable.VALUE,
				Sensors.BeerTapTable.VALUE);
		beerTapProjectionMap.put(Sensors.BeerTapTable.DATE,
				Sensors.BeerTapTable.DATE);
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();

		int count = 0;
		switch (uriMatcher.match(uri)) {
		case TEMPERATURE:
			count = db.delete(Sensors.TemperatureTable.TABLE_NAME, selection, selectionArgs);
			break;
		case TEMPERATURE_ID:
			break;
		case HUMIDITY:
			count = db.delete(Sensors.HumidityTable.TABLE_NAME, selection, selectionArgs);
			break;
		case HUMIDITY_ID:
			break;
		case NOISE:
			count = db.delete(Sensors.NoiseTable.TABLE_NAME, selection, selectionArgs);
			break;
		case NOISE_ID:
			break;
		case BEERTAP:
			count = db.delete(Sensors.BeerTapTable.TABLE_NAME, selection, selectionArgs);
			break;
		case BEERTAP_ID:
			break;
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
		
		return count;
	}

	@Override
	public String getType(Uri uri) {
		Log.d(DEBUG_TAG, "getType()URI: " + uri);
		switch (uriMatcher.match(uri)) {
		case TEMPERATURE:
			return Sensors.TemperatureTable.CONTENT_TYPE_TEMPERATURE;
		case TEMPERATURE_ID:
			return Sensors.TemperatureTable.CONTENT_ITEM_TEMPERATURE;
		case HUMIDITY:
			return Sensors.HumidityTable.CONTENT_TYPE_HUMIDITY;
		case HUMIDITY_ID:
			return Sensors.HumidityTable.CONTENT_ITEM_HUMIDITY;
		case NOISE:
			return Sensors.NoiseTable.CONTENT_TYPE_NOISE;
		case NOISE_ID:
			return Sensors.NoiseTable.CONTENT_ITEM_NOISE;
		case BEERTAP:
			return Sensors.BeerTapTable.CONTENT_TYPE_BEERTAP;
		case BEERTAP_ID:
			return Sensors.BeerTapTable.CONTENT_ITEM_BEERTAP;
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
	}

	@Override
	public Uri insert(Uri uri, ContentValues initValues) {
		Log.v(DEBUG_TAG, "insert(): URI - INSERT " + uri);
		if (uriMatcher.match(uri) != TEMPERATURE) {
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
		Log.v("DEBUG", "URI - INSERT AFTER" + uri);

		ContentValues values;
		if (initValues != null) {
			values = new ContentValues(initValues);
		} else {
			values = new ContentValues();
		}
		
		DatabaseHelper dbh = new DatabaseHelper(getContext());//, createTableQuery, dropTableQuery)
		SQLiteDatabase db = dbh.getWritableDatabase();
		Log.v("INFO", "DB: " + db.toString());

		/*
		 * The second insert() parameter is a nullColumnHack, a somewhat crappy
		 * solution that is used to avoid queries like "INSERT INTO tablename;"
		 * isn't declared illegal. Instead it automatically creates a statement
		 * like "INSERT INTO temperature_table (location_id) VALUES (NULL)" in
		 * this case.
		 */
		long rowId = db.insert(Sensors.TemperatureTable.TABLE_NAME,
				Sensors.TemperatureTable.LOCATION_ID, values);
		if (rowId > 0) {
			Uri temperatureUri = ContentUris.withAppendedId(
					TemperatureTable.TEMPERATURE_CONTENT_URI, rowId);
			getContext().getContentResolver().notifyChange(uri, null);
			return temperatureUri;
		}
		throw new IllegalArgumentException("InsertUnknown URI: " + uri);
	}

	@Override
	public boolean onCreate() {
		Log.d(DEBUG_TAG, this + " CREATED");
		dbHelper = new DatabaseHelper(getContext());
		SQLiteDatabase db = dbHelper.getWritableDatabase();

		Log.v(DEBUG_TAG, "CREATED" + db);
		boolean b = (dbHelper == null) ? false : true;

		Log.v(DEBUG_TAG, "CREATED" + b);
		return b;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

		switch (uriMatcher.match(uri)) {
		case TEMPERATURE:
			qb.setTables(Sensors.TemperatureTable.TABLE_NAME);
			qb.setProjectionMap(temperatureProjectionMap);
			break;
		case TEMPERATURE_ID:
			break;
		case HUMIDITY:
			qb.setTables(Sensors.HumidityTable.TABLE_NAME);
			qb.setProjectionMap(humidityProjectionMap);
			break;
		case HUMIDITY_ID:
			break;
		case NOISE:
			qb.setTables(Sensors.NoiseTable.TABLE_NAME);
			qb.setProjectionMap(noiseProjectionMap);
			break;
		case NOISE_ID:
			break;
		case BEERTAP:
			qb.setTables(Sensors.BeerTapTable.TABLE_NAME);
			qb.setProjectionMap(beerTapProjectionMap);
			break;
		case BEERTAP_ID:
			break;
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}

		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Log.v("INFO", "DB: " + db.toString());
		Log.v("INFO", "URI: " + uri);
		Cursor c = qb.query(db, projection, selection, selectionArgs, null,
				null, sortOrder);

		c.setNotificationUri(getContext().getContentResolver(), uri);
		return c;
	}

	@Override
	public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
		int count = 0;
		switch (uriMatcher.match(uri)) {
		case TEMPERATURE:
			count = updateTable(TemperatureTable.TABLE_NAME, TemperatureTable.CREATE_TABLE_QUERY, 
					TemperatureTable.DROP_TABLE_QUERY, values, where, whereArgs);
			break;
		case TEMPERATURE_ID:
			where = setWhereArgumentsForSpesificItem(uri, where, 
					TemperatureTable.TEMPERATURE_SAMPLES_ID_PATH_POSITION, TemperatureTable.ID);
			count = updateTable(TemperatureTable.ID, TemperatureTable.CREATE_TABLE_QUERY, 
					TemperatureTable.DROP_TABLE_QUERY, values, where, whereArgs);
			break;
		case HUMIDITY:
			count = updateTable(HumidityTable.TABLE_NAME, HumidityTable.CREATE_TABLE_QUERY, 
					HumidityTable.DROP_TABLE_QUERY, values, where, whereArgs);
			break;
		case HUMIDITY_ID:
			where = setWhereArgumentsForSpesificItem(uri, where, 
					HumidityTable.HUMIDITY_SAMPLES_ID_PATH_POSITION, HumidityTable.ID);
			count = updateTable(HumidityTable.ID, HumidityTable.CREATE_TABLE_QUERY, 
					HumidityTable.DROP_TABLE_QUERY, values, where, whereArgs);
			break;
		case NOISE:
			count = updateTable(NoiseTable.TABLE_NAME, NoiseTable.CREATE_TABLE_QUERY, 
					NoiseTable.DROP_TABLE_QUERY, values, where, whereArgs);
			break;
		case NOISE_ID:
			where = setWhereArgumentsForSpesificItem(uri, where, 
					NoiseTable.NOISE_SAMPLES_ID_PATH_POSITION, NoiseTable.ID);
			count = updateTable(NoiseTable.ID, NoiseTable.CREATE_TABLE_QUERY, 
					NoiseTable.DROP_TABLE_QUERY, values, where, whereArgs);
			break;
		case BEERTAP:
			count = updateTable(BeerTapTable.TABLE_NAME, BeerTapTable.CREATE_TABLE_QUERY, 
					BeerTapTable.DROP_TABLE_QUERY, values, where, whereArgs);
			break;
		case BEERTAP_ID:
			where = setWhereArgumentsForSpesificItem(uri, where, 
					BeerTapTable.BEERTAP_SAMPLES_ID_PATH_POSITION, BeerTapTable.ID);
			count = updateTable(BeerTapTable.ID, BeerTapTable.CREATE_TABLE_QUERY, 
					BeerTapTable.DROP_TABLE_QUERY, values, where, whereArgs);
			break;
		default:
			throw new IllegalArgumentException("Unknown URI " + uri);
		}

		getContext().getContentResolver().notifyChange(uri, null);

		return count;
	}

	private String setWhereArgumentsForSpesificItem(Uri uri, String where, int samplePathPosition, String sampleDatabaseRowId) {
		String sampleId = uri.getPathSegments().get(samplePathPosition);
		String finalWhere = sampleDatabaseRowId + " = " + sampleId; 
		
		if(where != null) {
			finalWhere = finalWhere + " AND " + where; 
		}
		
		return finalWhere; 
	}

	private int updateTable(String tableName, String createTableQuery, String dropTableQuery, 
			ContentValues values, String where, String[] whereArgs) {
		int count;
		DatabaseHelper dbh = new DatabaseHelper(getContext(), createTableQuery, dropTableQuery); 
		SQLiteDatabase db = dbh.getWritableDatabase();
		count = db.update(tableName, values, where, whereArgs);
		
		return count;
	}

	public class DatabaseHelper extends SQLiteOpenHelper {
		private String createTableQuery;
		private String dropTableQuery;
		
		public DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		
		public DatabaseHelper(Context context, String createTableQuery,
				String dropTableQuery) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			this.createTableQuery = createTableQuery;
			this.dropTableQuery = dropTableQuery;
		}

		/**
		 * Creates the database table when the object is created.
		 */
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(this.createTableQuery);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w(DEBUG_TAG, "Upgrading database, version:" + oldVersion
					+ " to " + newVersion + ", the data is dropped");

			// Drops the table
			db.execSQL("DROP TABLE IF EXISTS notes");

			// Recreates the database
			onCreate(db);
		}
	}
}