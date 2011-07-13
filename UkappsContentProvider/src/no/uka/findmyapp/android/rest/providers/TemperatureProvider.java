package no.uka.findmyapp.android.rest.providers;

import java.util.HashMap;

import no.uka.findmyapp.android.rest.helpers.TemperatureDbHelper;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.BaseColumns;
import android.util.Log;

public class TemperatureProvider extends ContentProvider{
	private TemperatureDbHelper dbHelper; 
	private static final int TEMPERATURE = 1; 

	// Temperature metadata
	public static final String AUTHORITY = "no.uka.findmyapp.android.rest.library.data.providers.TemperatureProvider"; 
	public static final Uri CONTENT_PROVIDER_URI = Uri.parse("content://" + AUTHORITY + "/temperature");
	public static final String DATABASE_NAME = "temperature.db";
	public static final int DATABASE_VERSION = 1; 
	//TODO implement article MIME
	//content type for one item: vnd.android.cursor.item/vnd.your-domain.your-item-name
	public static final String CONTENT_TYPE_TEMPERATURE_ITEM = "vnd.android.cursor.dir/vnd.uka.temperature"; 
	// End of metadata
	
	private static final UriMatcher uriMatcher; 
	
	private static final HashMap<String, String> temperatureProjectionMap; 
	static {
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(TemperatureProvider.AUTHORITY, TemperatureProvider.TemperatureTable.TABLE_NAME, TEMPERATURE);
		
		temperatureProjectionMap = new HashMap<String, String>(); 
		temperatureProjectionMap.put(
			TemperatureProvider.TemperatureTable.ID, TemperatureProvider.TemperatureTable.ID
		);
		temperatureProjectionMap.put(
			TemperatureProvider.TemperatureTable.LOCATION_ID, TemperatureProvider.TemperatureTable.LOCATION_ID
		);
		temperatureProjectionMap.put(
			TemperatureProvider.TemperatureTable.VALUE, TemperatureProvider.TemperatureTable.VALUE
		);
		temperatureProjectionMap.put(
			TemperatureProvider.TemperatureTable.DATE, TemperatureProvider.TemperatureTable.DATE
		);
		
	}
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		SQLiteDatabase db = dbHelper.getWritableDatabase(); 
		
		int count = 0; 
		switch (uriMatcher.match(uri)) {
		case TEMPERATURE:
			count = db.delete(TemperatureProvider.TemperatureTable.TABLE_NAME, selection, selectionArgs);
			break;

		default:
			throw new IllegalArgumentException("Unknown URI " + uri); 
		}
		
		getContext().getContentResolver().notifyChange(uri, null);
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		Log.v("DEBUG", "URI " + uri);
		switch (uriMatcher.match(uri)) {
		case TEMPERATURE:
			Log.v("DEBUG", "INSIDE");
			return TemperatureProvider.CONTENT_TYPE_TEMPERATURE_ITEM;
		default:
			Log.v("DEBUG", "DEFAULT");
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
	}

	@Override
	public Uri insert(Uri uri, ContentValues initValues) {
		Log.v("DEBUG", "URI - INSERT " + uri);
		if(uriMatcher.match(uri) != TEMPERATURE) {
			throw new IllegalArgumentException("Unknown URI " + uri);
		}
		Log.v("DEBUG", "URI - INSERT AFTER" + uri);
		
		ContentValues values; 
		if(initValues != null) {
			values = new ContentValues(initValues); 
		}
		else {
			values = new ContentValues(); 
		}
		
		SQLiteDatabase db = dbHelper.getWritableDatabase(); 
        Log.v("INFO", "DB: " +db.toString());
		
		
		/* The second insert() parameter is a nullColumnHack, 
		 * a somewhat crappy solution that is used to avoid 
		 * queries like "INSERT INTO tablename;" isn't 
		 * declared illegal. Instead it automatically creates
		 * a statement like "INSERT INTO temperature_table
		 * (location_id) VALUES (NULL)" in this case.
		 */
		long rowId = db.insert(TemperatureProvider.TemperatureTable.TABLE_NAME, TemperatureProvider.TemperatureTable.LOCATION_ID, values);
		if(rowId > 0) {
			Uri temperatureUri = ContentUris.withAppendedId(TemperatureProvider.CONTENT_PROVIDER_URI, rowId);
			getContext().getContentResolver().notifyChange(uri, null);
			return temperatureUri;
		}
		throw new IllegalArgumentException("InsertUnknown URI: " + uri);
	}

	@Override
	public boolean onCreate() {
		Log.v("TP", "CREATED");
		dbHelper = new TemperatureDbHelper(getContext());
		SQLiteDatabase db = dbHelper.getWritableDatabase();

		Log.v("TP", "CREATED" + db);
		boolean b = (dbHelper == null) ? false : true;

		Log.v("TP", "CREATED" + b);
		return b;
	}
	
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        switch (uriMatcher.match(uri)) {
            case TEMPERATURE:
                qb.setTables(TemperatureProvider.TemperatureTable.TABLE_NAME);
                qb.setProjectionMap(temperatureProjectionMap);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Log.v("INFO", "DB: " +db.toString());
        Log.v("INFO", "URI: " +uri);
        Cursor c = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);

        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Override
    public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int count;
        switch (uriMatcher.match(uri)) {
            case TEMPERATURE:
                count = db.update(TemperatureProvider.TemperatureTable.TABLE_NAME, values, where, whereArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
    	
	public class TemperatureTable implements BaseColumns {
		private TemperatureTable() {}
		
		// Table name
		public static final String TABLE_NAME = "sensor_temperature"; 
		
		// Databasefields
		public static final String ID = "_id";
		public static final String LOCATION_ID = "location_id"; 
		public static final String VALUE = "value";
		public static final String DATE = "date";
	}
	
	public class HumidityTable implements BaseColumns {
		private HumidityTable() {}
		
		// Table name 
		public static final String TABLE_NAME = "sensor_humidity"; 
		
		// Databasefields
		public static final String ID = "_id";
		public static final String LOCATION_ID = "location_id"; 
		public static final String VALUE = "value";
		public static final String DATE = "date";
	}
	
	public class BeerTapTable implements BaseColumns {
		private BeerTapTable() {}
		
		// Table name
		public static final String TABLE_NAME = "sensor_beertap";
		
		// Databasefields
		public static final String ID = "_id";
		public static final String DATE = "date";
		public static final String LOCATION_ID = "location_id"; 
		public static final String TAPNR = "tapnr";
		public static final String VALUE = "value";
	}
	
	public class NoiseTable implements BaseColumns {
		private NoiseTable() {}
		
		// Table name
		public static final String TABLE_NAME = "sensor_noise";
		
		// Databasefields
		public static final String ID = "_id";
		public static final String LOCATION_ID = "location_id"; 
		public static final String AVERAGE = "average";
		public static final String MAX = "max";
		public static final String MIN = "min";
		public static final String STANDARD_DEVIATION = "standard_deviation";
		public static final String SAMPLES = "samples";
		public static final String DATE = "date";
	}
}