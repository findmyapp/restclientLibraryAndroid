package no.uka.findmyapp.android.rest.helpers;

import no.uka.findmyapp.android.rest.providers.TemperatureProvider;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TemperatureDbHelper extends SQLiteOpenHelper{

	private static SQLiteDatabase db;
	private Context appContext;
	SQLiteDatabase dbReadable;

	SQLiteDatabase dbWriteable;


	private static final String CREATE_TABLE_QUERY = "CREATE TABLE " + TemperatureProvider.TemperatureTable.TABLE_NAME + " (" 
													+ TemperatureProvider.TemperatureTable.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
													+ TemperatureProvider.TemperatureTable.LOCATION_ID + " INTEGER, " 
													+ TemperatureProvider.TemperatureTable.VALUE + " DECIMAL,"
													+ TemperatureProvider.TemperatureTable.DATE + " DATETIME);";
	
	private static final String DROP_TABLE_QUERY = "DROP TABLE " + TemperatureProvider.TemperatureTable.TABLE_NAME + ";";

	
	public TemperatureDbHelper(Context context) {
		super(context, TemperatureProvider.DATABASE_NAME, null, TemperatureProvider.DATABASE_VERSION);
		appContext = context;

		//dbReadable = this.getReadableDatabase();
		//dbWriteable = this.getWritableDatabase();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.v("AAAAAAAAAAAAAAA", "CREATING TABLE " + db);
		Log.v("INFO", "CREATING TABLE " + db);
		Log.v("INFO", CREATE_TABLE_QUERY);
		db.execSQL(CREATE_TABLE_QUERY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(TemperatureDbHelper.class.getName(), "Database upgrade from version " + oldVersion + " to " + newVersion); 
		db.execSQL(DROP_TABLE_QUERY);
		onCreate(db);
	}	
	
	public void closeDb() {
	    if (dbReadable != null) { dbReadable.close();}
	    if (dbWriteable != null) { dbWriteable.close();}
	}

	
}