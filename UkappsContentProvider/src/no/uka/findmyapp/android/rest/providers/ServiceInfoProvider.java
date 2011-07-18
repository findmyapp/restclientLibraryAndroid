package no.uka.findmyapp.android.rest.providers;

import java.util.HashMap;

import no.uka.findmyapp.android.rest.contracts.ServiceInfo;
import no.uka.findmyapp.android.rest.contracts.ServiceInfo.ServiceInfoContract;
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

public class ServiceInfoProvider extends ContentProvider {
	   /**
	    * Debug tag
	    */
		private static final String debug = "ServiceInfoProvider";
	
	   /**
	    * The local serviceModel database name
	    */
	   private static final String DATABASE_NAME = "serviceinfo.db";

	   /**
	    * The database version
	    */
	   private static final int DATABASE_VERSION = 1;

	   /**
	    * A projection map used to select columns from the database
	    */
	   private static HashMap<String, String> serviceInfoProjectionMap;

	   /*
	    * Constants used by the Uri matcher to choose an action based on the pattern
	    * of the incoming URI
	    */
	   private static final int SERVICEMODEL = 1;
	   private static final int SERVICEMODEL_ID = 2;

	   /**
	    * A UriMatcher instance
	    */
	   private static final UriMatcher uriMatcher;

	   /**
	    * A database helper is required to create, 
	    * update and drop the serviceinfo table.
	    */
	   private ServiceInfoDatabaseHelper dbHelper;

	   /**
	    * Instantiates the needed statics. 
	    */
	   static {
	       /*
	        * Initializes the URI matcher
	        */
	       uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

	       // Setup the right patterns to the serviceinfo "dir"
	       uriMatcher.addURI(ServiceInfo.AUTHORITY, ServiceInfoContract.SERVICEINFO_PATH, SERVICEMODEL);
	      
	       /*
	        * Setup pattern to a spesific serviceinfo by using the spesific 
	        * of the serviceinfo
	        */
	       uriMatcher.addURI(ServiceInfo.AUTHORITY, ServiceInfoContract.SERVICEINFO_PATH + "#", SERVICEMODEL_ID);

	       /*
	        * Initializes a projection map that returns all columns
	        */
	       serviceInfoProjectionMap = new HashMap<String, String>();
	       serviceInfoProjectionMap.put(ServiceInfoContract.ID, ServiceInfoContract.ID);
	       serviceInfoProjectionMap.put(ServiceInfoContract.URI, ServiceInfoContract.URI);
	       serviceInfoProjectionMap.put(ServiceInfoContract.HTTPTYPE, ServiceInfoContract.HTTPTYPE);	       
	       serviceInfoProjectionMap.put(ServiceInfoContract.DATAFORMAT, ServiceInfoContract.DATAFORMAT);	       
	       serviceInfoProjectionMap.put(ServiceInfoContract.RETURNTYPE, ServiceInfoContract.RETURNTYPE);
	       serviceInfoProjectionMap.put(ServiceInfoContract.CONTENTPROVIDER_URI, ServiceInfoContract.CONTENTPROVIDER_URI);	       
	       serviceInfoProjectionMap.put(ServiceInfoContract.BROADCAST_NOTIFICATION, ServiceInfoContract.BROADCAST_NOTIFICATION);;
	   }

	   /**
	    * A custom database helper for the serviceinfo database.
	    * The helper helps creating, updating and 
	    * deleting tables
	    */
	  private static class ServiceInfoDatabaseHelper extends SQLiteOpenHelper {
		  private static final String debug = "ServiceInfoDatabaseHelper";

	      public ServiceInfoDatabaseHelper(Context context) {
	          super(context, DATABASE_NAME, null, DATABASE_VERSION);
			  Log.v(debug, "Inside constructor");
	      }

	      /**
	       * Creates the database table when the 
	       * object is created.
	       */
	      @Override
	      public void onCreate(SQLiteDatabase db) {
			  Log.v(debug, "Inside onCreate");
	          db.execSQL(ServiceInfoContract.CREATE_TABLE_QUERY); 
	      }

	      //TODO Implement implement UKA-program caching
	      /**
	       * The database drops all the data while upgrading. 
	       * The method is not implemented with the possibility
	       * to store data between different program sessions.
	       */
	      @Override
	      public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			  Log.v(debug, "Inside onUpgrade");

	          Log.w("EventProvider", "Upgrading database, version:" + oldVersion + " to "
	                  + newVersion + ", the data is dropped");

	          // Drops the table
	          db.execSQL(ServiceInfoContract.DROP_TABLE_QUERY);

	          // Recreates the database
	          onCreate(db);
	      }
	  }

	  @Override
	  public boolean onCreate() {
		  Log.v(debug, "Inside onCreate");
	      dbHelper = new ServiceInfoDatabaseHelper(getContext());

	      // Returns true by default, throws exceptions if something fails
	      return true;
	  }

	  @Override
	  public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		  Log.v(debug, "Inside query");
	      SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
	      qb.setTables(ServiceInfoContract.TABLE_NAME);

	      switch (uriMatcher.match(uri)) {
	          case SERVICEMODEL:
	              qb.setProjectionMap(serviceInfoProjectionMap);
	              break;
	          case SERVICEMODEL_ID:
	              qb.setProjectionMap(serviceInfoProjectionMap);
	              qb.appendWhere(ServiceInfoContract.ID + "=" + uri.getPathSegments().get(ServiceInfoContract.SERVICEINFO_ID_PATH_POSITION));
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

	  @Override
	  public String getType(Uri uri) {
		  Log.v(debug, "Inside getType");
	      switch (uriMatcher.match(uri)) {
	          case SERVICEMODEL:
	              return ServiceInfoContract.CONTENT_TYPE_SERVICEINFO;
	          case SERVICEMODEL_ID:
	              return ServiceInfoContract.CONTENT_ITEM_SERVICEINFO;
	          default:
	              throw new IllegalArgumentException("Unknown URI " + uri);
	      }
	   }

	   @Override
	   public Uri insert(Uri uri, ContentValues initialValues) {
		Log.v(debug, "Inside insert");
	       if (uriMatcher.match(uri) != SERVICEMODEL) {
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
			long rowId = db.insert(ServiceInfoContract.TABLE_NAME, ServiceInfoContract.SLUG, values);
			if(rowId > 0) {
				Uri contentUri = ContentUris.withAppendedId(ServiceInfoContract.SERVICEINFO_CONTENT_URI, rowId);
				getContext().getContentResolver().notifyChange(uri, null);
				return contentUri;
			}
			
			throw new IllegalArgumentException("InsertUnknown URI: " + uri);
	   }

	   @Override
	   public int delete(Uri uri, String where, String[] whereArgs) {
			  Log.v(debug, "Inside delete");
	       SQLiteDatabase db = dbHelper.getWritableDatabase();
	       String finalWhere;

	       int count;

	       switch (uriMatcher.match(uri)) {
	           case SERVICEMODEL:
	               count = db.delete(ServiceInfoContract.TABLE_NAME, where, whereArgs);
	               break;
	           case SERVICEMODEL_ID:
	               finalWhere = ServiceInfoContract.ID + " = " +  uri.getPathSegments().get(ServiceInfoContract.SERVICEINFO_ID_PATH_POSITION);

	               if (where != null) {
	                   finalWhere = finalWhere + " AND " + where;
	               }
	               
	               count = db.delete( ServiceInfoContract.TABLE_NAME, finalWhere, whereArgs);
	               break;
	           default:
	               throw new IllegalArgumentException("Unknown URI " + uri);
	       }

	       getContext().getContentResolver().notifyChange(uri, null);

	       return count;
	   }

	   @Override
	   public int update(Uri uri, ContentValues values, String where, String[] whereArgs) {
			  Log.v(debug, "inside update");
	       SQLiteDatabase db = dbHelper.getWritableDatabase();
	       int count;
	       String finalWhere;

	       switch (uriMatcher.match(uri)) {
	           case SERVICEMODEL:
	               count = db.update(ServiceInfoContract.TABLE_NAME, values, where, whereArgs);
	               break;
	           case SERVICEMODEL_ID:
	               String id = uri.getPathSegments().get(ServiceInfoContract.SERVICEINFO_ID_PATH_POSITION);
	               finalWhere = ServiceInfoContract.ID + " = " + id;

	               if (where !=null) {
	                   finalWhere = finalWhere + " AND " + where;
	               }

	               count = db.update(ServiceInfoContract.TABLE_NAME, values, finalWhere, whereArgs);
	               break;
	           default:
	               throw new IllegalArgumentException("Unknown URI " + uri);
	       }
	       
	       getContext().getContentResolver().notifyChange(uri, null);

	       return count;
	   }
}
