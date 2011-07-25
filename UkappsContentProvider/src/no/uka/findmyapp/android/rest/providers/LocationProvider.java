/* 
 * Copyright (c) 2011 Accenture
 * Licensed under the MIT open source license
 * http://www.opensource.org/licenses/mit-license.php
 */
package no.uka.findmyapp.android.rest.providers;

import java.util.HashMap;

import no.uka.findmyapp.android.rest.contracts.Location;
import no.uka.findmyapp.android.rest.contracts.Location.LocationContract;
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
 * The Class LocationProvider.
 */
public class LocationProvider extends ContentProvider {
	   
   	/** Debug tag. */
		private static final String debug = "LocationProvider";
	
	   /** The local serviceModel database name. */
	   private static final String DATABASE_NAME = "location.db";

	   /** The database version. */
	   private static final int DATABASE_VERSION = 1;

	   /** A projection map used to select columns from the database. */
	   private static HashMap<String, String> locationProjectionMap;

	   /*
	    * Constants used by the Uri matcher to choose an action based on the pattern
	    * of the incoming URI
	    */
	   /** The Constant LOCATION. */
   	private static final int LOCATION = 1;
	   
   	/** The Constant LOCATION_ID. */
   	private static final int LOCATION_ID = 2;

	   /** A UriMatcher instance. */
	   private static final UriMatcher uriMatcher;

	   /**
	    * A database helper is required to create, 
	    * update and drop the location table.
	    */
	   private LocationDatabaseHelper dbHelper;

	   /**
	    * Instantiates the needed statics. 
	    */
	   static {
	       /*
	        * Initializes the URI matcher
	        */
	       uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

	       // Setup the right patterns to the location "dir"
	       uriMatcher.addURI(Location.AUTHORITY, LocationContract.LOCATION_PATH, LOCATION);
	      
	       /*
	        * Setup pattern to a spesific location by using the spesific 
	        * of the location
	        */
	       uriMatcher.addURI(Location.AUTHORITY, LocationContract.LOCATION_PATH + "#", LOCATION_ID);

	       /*
	        * Initializes a projection map that returns all columns
	        */
	       locationProjectionMap = new HashMap<String, String>();
	       locationProjectionMap.put(LocationContract.ID, LocationContract.ID);
		   locationProjectionMap.put(LocationContract.LOCATIONNAME, LocationContract.LOCATIONNAME);
locationProjectionMap.put(LocationContract.LOCATIONID, LocationContract.LOCATIONID);
	   }

	   /**
	    * A custom database helper for the location database.
	    * The helper helps creating, updating and 
	    * deleting tables
	    */
	  private static class LocationDatabaseHelper extends SQLiteOpenHelper {
		  
  		/** The Constant debug. */
  		private static final String debug = "LocationDatabaseHelper";

	      /**
      	 * Instantiates a new location database helper.
      	 *
      	 * @param context the context
      	 */
      	public LocationDatabaseHelper(Context context) {
	          super(context, DATABASE_NAME, null, DATABASE_VERSION);
			  Log.v(debug, "Inside constructor");
	      }

	      /**
      	 * Creates the database table when the
      	 * object is created.
      	 *
      	 * @param db the db
      	 */
	      @Override
	      public void onCreate(SQLiteDatabase db) {
			  Log.v(debug, "Inside onCreate");
	          db.execSQL(LocationContract.CREATE_TABLE_QUERY); 
	      }

	      //TODO Implement implement UKA-program caching
	      /**
      	 * The database drops all the data while upgrading.
      	 * The method is not implemented with the possibility
      	 * to store data between different program sessions.
      	 *
      	 * @param db the db
      	 * @param oldVersion the old version
      	 * @param newVersion the new version
      	 */
	      @Override
	      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			  Log.v(debug, "Inside onUpgrade");

	          Log.w(debug, "Upgrading database, version:" + oldVersion + " to "
	                  + newVersion + ", the data is dropped");

	          // Drops the table
	          db.execSQL(LocationContract.DROP_TABLE_QUERY);

	          // Recreates the database
	          onCreate(db);
	      }
	  }

	  /* (non-Javadoc)
  	 * @see android.content.ContentProvider#onCreate()
  	 */
  	@Override
	  public boolean onCreate() {
		  Log.v(debug, "Inside onCreate");
	      dbHelper = new LocationDatabaseHelper(getContext());

	      // Returns true by default, throws exceptions if something fails
	      return true;
	  }

	  /* (non-Javadoc)
  	 * @see android.content.ContentProvider#query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String)
  	 */
  	@Override
	  public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		  Log.v(debug, "Inside query");
	      SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
	      qb.setTables(LocationContract.TABLE_NAME);

	      switch (uriMatcher.match(uri)) {
	          case LOCATION:
	              qb.setProjectionMap(locationProjectionMap);
	              break;
	          case LOCATION_ID:
	              qb.setProjectionMap(locationProjectionMap);
	              qb.appendWhere(LocationContract.ID + "=" + uri.getPathSegments().get(LocationContract.LOCATION_ID_PATH_POSITION));
	              break;
	          default:
	              throw new IllegalArgumentException("Unknown URI " + uri);
	      }
	      
	      SQLiteDatabase db = dbHelper.getReadableDatabase();
	      Log.v(debug, "query: querystatment " + qb.toString());
	      Cursor cursor = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);

	      // Tells the Cursor what URI to watch, so it knows when its source data changes
	      cursor.setNotificationUri(getContext().getContentResolver(), uri);
	      
	      return cursor;
	  }

	  /* (non-Javadoc)
  	 * @see android.content.ContentProvider#getType(android.net.Uri)
  	 */
  	@Override
	  public String getType(Uri uri) {
		  Log.v(debug, "Inside getType");
	      switch (uriMatcher.match(uri)) {
	          case LOCATION:
	              return LocationContract.CONTENT_TYPE_LOCATION;
	          case LOCATION_ID:
	              return LocationContract.CONTENT_ITEM_LOCATION;
	          default:
	              throw new IllegalArgumentException("Unknown URI " + uri);
	      }
	   }

	   /* (non-Javadoc)
   	 * @see android.content.ContentProvider#insert(android.net.Uri, android.content.ContentValues)
   	 */
   	@Override
	   public Uri insert(Uri uri, ContentValues initialValues) {
		Log.v(debug, "Inside insert");
	       if (uriMatcher.match(uri) != LOCATION) {
	           throw new IllegalArgumentException("Unknown URI " + uri);
	       }
	       
	       ContentValues values;
	       if (initialValues != null) {
	           values = new ContentValues(initialValues);
	       } 
	       else {
	           values = new ContentValues();
	       }
	       
			SQLiteDatabase db = dbHelper.getWritableDatabase(); 
	        Log.v(debug, "insert: selected database " + db.toString());
			
	        Log.v(debug, "insert: insertvalues " + values.toString());
			
			/* The second insert() parameter is a nullColumnHack, 
			 * a somewhat crappy solution which is used to avoid 
			 * queries like "INSERT INTO tablename;" isn't 
			 * declared illegal. Instead it automatically creates
			 * a statement like "INSERT INTO temperature_table
			 * (location_id) VALUES (NULL)" in this case.
			 */
			long rowId = db.insert(LocationContract.TABLE_NAME, LocationContract.SLUG, values);
			if(rowId > 0) {
				Uri contentUri = ContentUris.withAppendedId(LocationContract.LOCATION_CONTENT_URI, rowId);
				getContext().getContentResolver().notifyChange(uri, null);
				return contentUri;
			}
			
			throw new IllegalArgumentException("InsertUnknown URI: " + uri);
	   }

	   /* (non-Javadoc)
   	 * @see android.content.ContentProvider#delete(android.net.Uri, java.lang.String, java.lang.String[])
   	 */
   	@Override
	   public int delete(Uri uri, String where, String[] whereArgs) {
			  Log.v(debug, "Inside delete");
	       SQLiteDatabase db = dbHelper.getWritableDatabase();
	       String finalWhere;

	       int count;

	       switch (uriMatcher.match(uri)) {
	           case LOCATION:
	               count = db.delete(LocationContract.TABLE_NAME, where, whereArgs);
	               break;
	           case LOCATION_ID:
	               finalWhere = LocationContract.ID + " = " +  uri.getPathSegments().get(LocationContract.LOCATION_ID_PATH_POSITION);

	               if (where != null) {
	                   finalWhere = finalWhere + " AND " + where;
	               }
	               
	               count = db.delete( LocationContract.TABLE_NAME, finalWhere, whereArgs);
	               break;
	           default:
	               throw new IllegalArgumentException("Unknown URI " + uri);
	       }

	       getContext().getContentResolver().notifyChange(uri, null);

	       return count;
	   }

	   /* (non-Javadoc)
   	 * @see android.content.ContentProvider#update(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[])
   	 */
   	@Override
	   public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
			  Log.v(debug, "inside update");
	       SQLiteDatabase db = dbHelper.getWritableDatabase();
	       int count;
	       String finalWhere;

	       switch (uriMatcher.match(uri)) {
	           case LOCATION:
	               count = db.update(LocationContract.TABLE_NAME, values, where, whereArgs);
	               break;
	           case LOCATION_ID:
	               String id = uri.getPathSegments().get(LocationContract.LOCATION_ID_PATH_POSITION);
	               finalWhere = LocationContract.ID + " = " + id;

	               if (where !=null) {
	                   finalWhere = finalWhere + " AND " + where;
	               }

	               count = db.update(LocationContract.TABLE_NAME, values, finalWhere, whereArgs);
	               break;
	           default:
	               throw new IllegalArgumentException("Unknown URI " + uri);
	       }
	       
	       getContext().getContentResolver().notifyChange(uri, null);

	       return count;
	   }
}

