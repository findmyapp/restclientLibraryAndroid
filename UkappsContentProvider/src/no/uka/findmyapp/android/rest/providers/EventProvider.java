package no.uka.findmyapp.android.rest.providers;

import java.util.HashMap;

import no.uka.findmyapp.android.rest.contracts.Events;
import no.uka.findmyapp.android.rest.contracts.Events.Event;
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

public class EventProvider extends ContentProvider {

	   /**
	    * The local event database name
	    */
	   private static final String DATABASE_NAME = "events.db";

	   /**
	    * The database version
	    */
	   private static final int DATABASE_VERSION = 2;

	   /**
	    * A projection map used to select columns from the database
	    */
	   private static HashMap<String, String> eventProjectionMap;

	   /*
	    * Constants used by the Uri matcher to choose an action based on the pattern
	    * of the incoming URI
	    */
	   private static final int EVENTS = 1;
	   private static final int EVENT_ID = 2;

	   /**
	    * A UriMatcher instance
	    */
	   private static final UriMatcher uriMatcher;

	   /**
	    * A database helper is required to create, 
	    * update and drop the events table.
	    */
	   private EventsDatabaseHelper dbHelper;

	   /**
	    * Instantiates the needed statics. 
	    */
	   static {
	       /*
	        * Initializes the URI matcher
	        */
	       uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

	       // Setup the right patterns to the events "dir"
	       uriMatcher.addURI(Events.AUTHORITY, "events/", EVENTS);
	      
	       /*
	        * Setup pattern to a spesific event by using the spesific 
	        * of the event
	        */
	       uriMatcher.addURI(Events.AUTHORITY, "events/#", EVENT_ID);

	       /*
	        * Initializes a projection map that returns all columns
	        */
	       eventProjectionMap = new HashMap<String, String>();
	       eventProjectionMap.put(Event.ID, Event.ID);
	       eventProjectionMap.put(Event.EVENT_ID, Event.EVENT_ID);
	       eventProjectionMap.put(Event.BILLING_ID, Event.BILLING_ID);	       
	       eventProjectionMap.put(Event.ENTRANCE_ID, Event.ENTRANCE_ID);	       
	       eventProjectionMap.put(Event.TITLE, Event.TITLE);
	       eventProjectionMap.put(Event.LEAD, Event.LEAD);	       
	       eventProjectionMap.put(Event.TEXT, Event.TEXT);
	       eventProjectionMap.put(Event.PLACE, Event.PLACE);	       
	       eventProjectionMap.put(Event.EVENT_TYPE, Event.EVENT_TYPE);
	       eventProjectionMap.put(Event.IMAGE, Event.IMAGE);	       
	       eventProjectionMap.put(Event.THUMBNAIL, Event.THUMBNAIL);
	       eventProjectionMap.put(Event.HIDDEN_FROM_LISTING, Event.HIDDEN_FROM_LISTING);	       
	       eventProjectionMap.put(Event.AGE_LIMIT, Event.AGE_LIMIT);
	       eventProjectionMap.put(Event.DETAIL_PHOTO_ID, Event.DETAIL_PHOTO_ID);
	       eventProjectionMap.put(Event.SHOWING_TIME, Event.SHOWING_TIME);
	       eventProjectionMap.put(Event.PUBLISH_TIME, Event.PUBLISH_TIME);
	       eventProjectionMap.put(Event.NETSALE_FROM, Event.NETSALE_FROM);
	       eventProjectionMap.put(Event.NETSALE_TO, Event.NETSALE_TO);
	       eventProjectionMap.put(Event.FREE, Event.FREE);
	       eventProjectionMap.put(Event.CANCELED, Event.CANCELED);
	   }

	   /**
	    * A custom database helper for the event database.
	    * The helper helps creating, updating and 
	    * deleting tables
	    */
	  private static class EventsDatabaseHelper extends SQLiteOpenHelper {
		  
		  private static final String CREATE_TABLE_QUERY =
			  "CREATE TABLE " + Event.TABLE_NAME + " ("	
			  + Event.ID + " INTEGER PRIMARY KEY, "
			  + Event.EVENT_ID + " INTEGER, "
			  + Event.BILLING_ID + " INTEGER, "
			  + Event.ENTRANCE_ID + " INTEGER, "
			  + Event.TITLE + " varchar(255), "
			  + Event.LEAD + " varchar(255), " 
			  + Event.TEXT + " varchar(255), "
			  + Event.PLACE + " varchar(30)"
			  + Event.EVENT_TYPE + " varchar(30), "
			  + Event.IMAGE + " varchar(100), "
			  + Event.THUMBNAIL + " varchar(100), "
			  + Event.HIDDEN_FROM_LISTING + " boolean, "
			  + Event.SLUG + " varchar(50), "
			  + Event.AGE_LIMIT + " INTEGER, "
			  + Event.DETAIL_PHOTO_ID + " INTEGER, "
			  + Event.SHOWING_TIME + " DATETIME, "
			  + Event.PUBLISH_TIME + " DATETIME, "
			  + Event.NETSALE_FROM + " DATETIME, "
			  + Event.NETSALE_TO + " DATETIME, "
			  + Event.FREE + " BOOLEAN, "
			  + Event.CANCELED + " BOOLEAN"
			  + ");";
		  
		  private static final String DROP_TABLE_QUERY = 
			  "DROP TABLE IF EXISTS " + Event.TABLE_NAME; 
		  
	      public EventsDatabaseHelper(Context context) {
	          super(context, DATABASE_NAME, null, DATABASE_VERSION);
	      }

	      /**
	       * Creates the database table when the 
	       * object is created.
	       */
	      @Override
	      public void onCreate(SQLiteDatabase db) {
	          db.execSQL(CREATE_TABLE_QUERY); 
	      }

	      //TODO Implement implement UKA-program caching
	      /**
	       * The database drops all the data while upgrading. 
	       * The method is not implemented with the possibility
	       * to store data between different program launches. 
	       */
	      @Override
	      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	          Log.w("EventProvider", "Upgrading database, version:" + oldVersion + " to "
	                  + newVersion + ", the data is dropped");

	          // Drops the table
	          db.execSQL("DROP TABLE IF EXISTS notes");

	          // Recreates the database
	          onCreate(db);
	      }
	  }

	  @Override
	  public boolean onCreate() {

	      dbHelper = new EventsDatabaseHelper(getContext());

	      // Returns true by default, throws exceptions if something fails
	      return true;
	  }

	  @Override
	  public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

	      SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
	      qb.setTables(Event.TABLE_NAME);

	      switch (uriMatcher.match(uri)) {
	          case EVENTS:
	              qb.setProjectionMap(eventProjectionMap);
	              break;
	          case EVENT_ID:
	              qb.setProjectionMap(eventProjectionMap);
	              qb.appendWhere(Event.ID + "=" + uri.getPathSegments().get(Event.EVENTS_ID_PATH_POSITION));
	              break;
	          default:
	              throw new IllegalArgumentException("Unknown URI " + uri);
	      }

	      SQLiteDatabase db = dbHelper.getReadableDatabase();

	      Cursor cursor = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);

	      // Tells the Cursor what URI to watch, so it knows when its source data changes
	      cursor.setNotificationUri(getContext().getContentResolver(), uri);
	      
	      return cursor;
	  }

	  @Override
	  public String getType(Uri uri) {
	      switch (uriMatcher.match(uri)) {
	          case EVENTS:
	              return Event.CONTENT_TYPE_EVENT;
	          case EVENT_ID:
	              return Event.CONTENT_ITEM_EVENT;
	          default:
	              throw new IllegalArgumentException("Unknown URI " + uri);
	      }
	   }

	   @Override
	   public Uri insert(Uri uri, ContentValues initialValues) {
	       if (uriMatcher.match(uri) != EVENTS) {
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
	        Log.v("INFO", "DB: " +db.toString());
			
			
			/* The second insert() parameter is a nullColumnHack, 
			 * a somewhat crappy solution which is used to avoid 
			 * queries like "INSERT INTO tablename;" isn't 
			 * declared illegal. Instead it automatically creates
			 * a statement like "INSERT INTO temperature_table
			 * (location_id) VALUES (NULL)" in this case.
			 */
			long rowId = db.insert(Event.TABLE_NAME, Event.SLUG, values);
			if(rowId > 0) {
				Uri eventUri = ContentUris.withAppendedId(Event.EVENT_CONTENT_URI, rowId);
				getContext().getContentResolver().notifyChange(uri, null);
				return eventUri;
			}
			
			throw new IllegalArgumentException("InsertUnknown URI: " + uri);
	   }

	   @Override
	   public int delete(Uri uri, String where, String[] whereArgs) {

	       SQLiteDatabase db = dbHelper.getWritableDatabase();
	       String finalWhere;

	       int count;

	       switch (uriMatcher.match(uri)) {
	           case EVENTS:
	               count = db.delete(Event.TABLE_NAME, where, whereArgs);
	               break;
	           case EVENT_ID:
	               finalWhere = Event.ID + " = " +  uri.getPathSegments().get(Event.EVENTS_ID_PATH_POSITION);

	               if (where != null) {
	                   finalWhere = finalWhere + " AND " + where;
	               }
	               
	               count = db.delete( Event.TABLE_NAME, finalWhere, whereArgs);
	               break;
	           default:
	               throw new IllegalArgumentException("Unknown URI " + uri);
	       }

	       getContext().getContentResolver().notifyChange(uri, null);

	       return count;
	   }

	   @Override
	   public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
	       SQLiteDatabase db = dbHelper.getWritableDatabase();
	       int count;
	       String finalWhere;

	       switch (uriMatcher.match(uri)) {
	           case EVENTS:
	               count = db.update(Event.TABLE_NAME, values, where, whereArgs);
	               break;
	           case EVENT_ID:
	               String eventId = uri.getPathSegments().get(Event.EVENTS_ID_PATH_POSITION);
	               finalWhere = Event.ID + " = " + eventId;

	               if (where !=null) {
	                   finalWhere = finalWhere + " AND " + where;
	               }

	               count = db.update(Event.TABLE_NAME, values, finalWhere, whereArgs);
	               break;
	           default:
	               throw new IllegalArgumentException("Unknown URI " + uri);
	       }
	       
	       getContext().getContentResolver().notifyChange(uri, null);

	       return count;
	   }
}
