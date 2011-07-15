package no.uka.findmyapp.android.rest.contracts;

//TODO check table definition datavalues

import no.uka.findmyapp.android.rest.contracts.UkaEvents.UkaEventContract;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Defines a contract between the Sensor content provider and its clients.
 * Clients should only use information given by this "contract" to fetch
 * data from the SensorProvider.
 */
public final class Sensors implements BaseColumns{
	
	// This class cannot be instantiated
	private Sensors() {}
	
    /*
     * URI definitions
     */

    /**
     * The scheme part for this provider's URI
     */
	public static final String AUTHORITY = "no.uka.findmyapp.SensorProvider"; 
	
    /**
     * The scheme part for this provider's URI
     */
	public static final String SCHEME = "content://";

    /**
     * The default sort order for this table
     */
    public static final String DEFAULT_SORT_ORDER = "modified DESC";

    /** 
     * Temperature table contract 
     */
	public static class TemperatureTable implements BaseColumns {
		// This class cannot be instantiated
		private TemperatureTable() {}
		
		/**
		 *  Table name
		 */
		public static final String TABLE_NAME = "sensor_temperature"; 
		
		/**
		 * Create table query
		 */
		public static final String CREATE_TABLE_QUERY = 
			  "CREATE TABLE " + TemperatureTable.TABLE_NAME + " ("	
			  + TemperatureTable.ID + " INTEGER PRIMARY KEY, "
			  + TemperatureTable.LOCATION_ID + " INTEGER, "
			  + TemperatureTable.VALUE + " FLOAT, "
			  + TemperatureTable.DATE + " DATETIME "
			  + ");"; 
		
		/**
		 * Drop table query
		 */
		public static final String DROP_TABLE_QUERY =
			"DROP TABLE IF EXISTS" + TABLE_NAME + ";";
		
		/*
		 * URI Definitions
		 */
        /**
         * Path parts for the URIs
         */
        /**
         * Path part for the temperature samples URI
         */
        private static final String PATH_TEMPERATURE_SAMPLES = "/temperature_samples";

        /**
         * Path part for the temperature ID URI
         */
        private static final String PATH_TEMPERATURE_SAMPLES_ID = "/temperature_samples/";

        /**
         * 0-relative position of a temperature ID segment in the path part of a temperature ID URI
         */
        public static final int TEMPERATURE_SAMPLES_ID_PATH_POSITION = 1;

        /**
         * The content:// style URL for this table
         */
        public static final Uri TEMPERATURE_CONTENT_URI = Uri.parse(SCHEME + AUTHORITY + PATH_TEMPERATURE_SAMPLES);

        /**
         * The content URI base for a single temperature sample. Callers must
         * append a numeric tempearture sample id to this Uri to retrieve a 
         * temperature sample.
         */
        public static final Uri TEMPERATURE_CONTENT_ID_URI_BASE = Uri.parse(SCHEME + AUTHORITY + PATH_TEMPERATURE_SAMPLES_ID);

        /**
         * The content URI match pattern for a single temperature sample, specified by its ID. Use this to match
         * incoming URIs or to construct an Intent.
         */
        public static final Uri TEMPERATURE_CONTENT_ID_URI_PATTERN = Uri.parse(SCHEME + AUTHORITY + PATH_TEMPERATURE_SAMPLES + "/#");

		/*
		 * MIME-type definition 
		 */
	    /**
	     * The MIME type of {@link #CONTENT_URI_TEMPERATURE} providing a directory of temperature samples.
	     */
	    public static final String CONTENT_TYPE_TEMPERATURE = "vnd.android.cursor.dir/vnd.no.uka.sensors.temperature";
	    
	    /**
	     * The MIME type of a {@link #CONTENT_URI_TEMPERATURE} sub-directory of a single
	     * temperature sample.
	     */
	    public static final String CONTENT_ITEM_TEMPERATURE = "vnd.android.cursor.item/vnd.no.uka.sensors.temperature";
		
        /*
         * Column definitions
         */
        /**
         * Column name for the id of the sample
         * <P>Type: TEXT</P>
         */
		public static final String ID = "_id";
		
		/**
		 * Column name for the location id
		 * <P>Type: INTEGER</P>
		 */
		public static final String LOCATION_ID = "location_id"; 
		
		/**
		 * Column name for the sample value
		 * <P>Type: FLOAT</P>
		 */
		public static final String VALUE = "value";
		
        /**
         * Column name for the sampling time
         * <P>Type: DATETIME</P>
         */
		public static final String DATE = "date";
	}
	
    /** 
     * Humidity table contract 
     */
	public static class HumidityTable implements BaseColumns {
		// This class cannot be instantiated
		private HumidityTable() {}
		
		/**
		 *  Table name
		 */
		public static final String TABLE_NAME = "sensor_humidity"; 
		
		/**
		 * Create table query
		 */
		public static final String CREATE_TABLE_QUERY = 
			  "CREATE TABLE " + HumidityTable.TABLE_NAME + " ("	
			  + HumidityTable.ID + " INTEGER PRIMARY KEY, "
			  + HumidityTable.LOCATION_ID + " INTEGER, "
			  + HumidityTable.VALUE + " FLOAT, "
			  + HumidityTable.DATE + " DATETIME "
			  + ");"; 
		
		/**
		 * Drop table query
		 */
		public static final String DROP_TABLE_QUERY =
			"DROP TABLE IF EXISTS" + TABLE_NAME + ";";
		
		/*
		 * URI Definitions
		 */
        /**
         * Path parts for the URIs
         */
        /**
         * Path part for the humidity samples URI
         */
        private static final String PATH_HUMIDITY_SAMPLES = "/humidity_samples";

        /**
         * Path part for the humidity ID URI
         */
        private static final String PATH_HUMIDITY_SAMPLES_ID = "/humidity_samples/";

        /**
         * 0-relative position of a humidity ID segment in the path part of a humidity ID URI
         */
        public static final int HUMIDITY_SAMPLES_ID_PATH_POSITION = 1;

        /**
         * The content:// style URL for this table
         */
        public static final Uri HUMIDITY_CONTENT_URI = Uri.parse(SCHEME + AUTHORITY + PATH_HUMIDITY_SAMPLES);

        /**
         * The content URI base for a single humidity sample. Callers must
         * append a numeric humidity sample id to this Uri to retrieve a 
         * humidity sample.
         */
        public static final Uri HUMIDITY_CONTENT_ID_URI_BASE = Uri.parse(SCHEME + AUTHORITY + PATH_HUMIDITY_SAMPLES_ID);

        /**
         * The content URI match pattern for a single humidity sample, specified by its ID. Use this to match
         * incoming URIs or to construct an Intent.
         */
        public static final Uri HUMIDITY_CONTENT_ID_URI_PATTERN = Uri.parse(SCHEME + AUTHORITY + PATH_HUMIDITY_SAMPLES + "/#");
		
		/*
		 * MIME-type definition
		 */
	    /**
	     * The MIME type of {@link #CONTENT_URI_HUMIDITY} providing a directory of humidity samples.
	     */
	    public static final String CONTENT_TYPE_HUMIDITY = "vnd.android.cursor.dir/vnd.no.uka.sensors.humidity";
	    
	    /**
	     * The MIME type of a {@link #CONTENT_URI_HUMIDITY} sub-directory of a single
	     * humidity sample.
	     */
	    public static final String CONTENT_ITEM_HUMIDITY = "vnd.android.cursor.item/vnd.no.uka.sensors.humidity";
		
        /*
         * Column definitions
         */
        /**
         * Column name for the id of the sample
         * <P>Type: TEXT</P>
         */
		public static final String ID = "_id";
		
		/**
		 * Column name for the location id
		 * <P>Type: INTEGER</P>
		 */
		public static final String LOCATION_ID = "location_id"; 
		
		/**
		 * Column name for the sample value
		 * <P>Type: FLOAT</P>
		 */
		public static final String VALUE = "value";
		
        /**
         * Column name for the sampling time
         * <P>Type: DATETIME</P>
         */
		public static final String DATE = "date";
	}
	
    /** 
     * Noise table contract 
     */
	public static class NoiseTable implements BaseColumns {
		// This class cannot be instantiated
		private NoiseTable() {}
		
		/**
		 *  Table name
		 */
		public static final String TABLE_NAME = "sensor_noise";
		
		/**
		 * Create table query
		 */
		public static final String CREATE_TABLE_QUERY = 
			  "CREATE TABLE " + NoiseTable.TABLE_NAME + " ("	
			  + NoiseTable.ID + " INTEGER PRIMARY KEY, "
			  + NoiseTable.LOCATION_ID + " INTEGER, "
			  + NoiseTable.AVERAGE + " FLOAT, "
			  + NoiseTable.MIN + " FLOAT, "
			  + NoiseTable.MAX + " FLOAT, "
			  + NoiseTable.STANDARD_DEVIATION + " FLOAT, "
			  + NoiseTable.SAMPLES + " TEXT, "
			  + NoiseTable.DATE + " DATETIME "
			  + ");"; 
		
		/**
		 * Drop table query
		 */
		public static final String DROP_TABLE_QUERY =
			"DROP TABLE IF EXISTS" + TABLE_NAME + ";";
		
		/*
		 * URI Definitions
		 */
        /**
         * Path parts for the URIs
         */
        /**
         * Path part for the noise samples URI
         */
        private static final String PATH_NOISE_SAMPLES = "/noise_samples";

        /**
         * Path part for the noise ID URI
         */
        private static final String PATH_NOISE_SAMPLES_ID = "/noise_samples/";

        /**
         * 0-relative position of a noise ID segment in the path part of a noise ID URI
         */
        public static final int NOISE_SAMPLES_ID_PATH_POSITION = 1;

        /**
         * The content:// style URL for this table
         */
        public static final Uri NOISE_CONTENT_URI = Uri.parse(SCHEME + AUTHORITY + PATH_NOISE_SAMPLES);

        /**
         * The content URI base for a single noise sample. Callers must
         * append a numeric noise sample id to this Uri to retrieve a 
         * noise sample.
         */
        public static final Uri NOISE_CONTENT_ID_URI_BASE = Uri.parse(SCHEME + AUTHORITY + PATH_NOISE_SAMPLES_ID);

        /**
         * The content URI match pattern for a single noise sample, specified by its ID. Use this to match
         * incoming URIs or to construct an Intent.
         */
        public static final Uri NOISE_CONTENT_ID_URI_PATTERN = Uri.parse(SCHEME + AUTHORITY + PATH_NOISE_SAMPLES + "/#");
		
		/*
		 * MIME-type definitions
		 */
	    /**
	     * The MIME type of {@link #CONTENT_URI_NOISE} providing a directory of noise samples.
	     */
	    public static final String CONTENT_TYPE_NOISE = "vnd.android.cursor.dir/vnd.no.uka.sensors.noise";
	    
	    /**
	     * The MIME type of a {@link #CONTENT_URI_NOISE} sub-directory of a single
	     * noise sample.
	     */
	    public static final String CONTENT_ITEM_NOISE = "vnd.android.cursor.item/vnd.no.uka.sensors.noise";
	    
        /*
         * Column definitions
         */

        /**
         * Column name for the id of the sample
         * <P>Type: TEXT</P>
         */
		public static final String ID = "_id";
		
		/**
		 * Column name for the location id
		 * <P>Type: INTEGER</P>
		 */
		public static final String LOCATION_ID = "location_id"; 
		
		/**
		 * Column name for the average noise sample
		 * <P>Type: FLOAT</P>
		 */
		public static final String AVERAGE = "average";
		
		/**
		 * Column name for the maximum noise sample
		 * <P>Type: FLOAT</P>
		 */
		public static final String MAX = "max";
		
		/**
		 * Column name for the minimum noise sample
		 * <P>Type: FLOAT</P>
		 */
		public static final String MIN = "min";
		
		/**
		 * Column name for the standard deviation
		 * <P>Type: FLOAT</P>
		 */
		public static final String STANDARD_DEVIATION = "standard_deviation";
		
		/**
		 * Column name for the sample value array
		 * <P>Type: String</P>
		 */
		public static final String SAMPLES = "samples";
		
        /**
         * Column name for the sampling time
         * <P>Type: DATETIME</P>
         */
		public static final String DATE = "date";
	}
	
    /** 
     * Beertap table contract 
     */
	public static class BeerTapTable implements BaseColumns {
		// This class cannot be instantiated
		private BeerTapTable() {}
		
		/**
		 *  Table name
		 */
		public static final String TABLE_NAME = "sensor_beertap";
		
		/**
		 * Create table query
		 */
		public static final String CREATE_TABLE_QUERY = 
			  "CREATE TABLE " + BeerTapTable.TABLE_NAME + " ("	
			  + BeerTapTable.ID + " INTEGER PRIMARY KEY, "
			  + BeerTapTable.LOCATION_ID + " INTEGER, "
			  + BeerTapTable.DATE + " DATETIME, "
			  + BeerTapTable.TAPNR + " INTEGER, "
			  + BeerTapTable.VALUE + " FLOAT "
			  + ");"; 
		
		/**
		 * Drop table query
		 */
		public static final String DROP_TABLE_QUERY =
			"DROP TABLE IF EXISTS" + TABLE_NAME + ";";
		
		/*
		 * URI Definitions
		 */
        /**
         * Path parts for the URIs
         */
        /**
         * Path part for the beertap samples URI
         */
        private static final String PATH_BEERTAP_SAMPLES = "/beertap_samples";

        /**
         * Path part for the beertap ID URI
         */
        private static final String PATH_BEERTAP_SAMPLES_ID = "/beertap_samples/";

        /**
         * 0-relative position of a beertap ID segment in the path part of a beertap ID URI
         */
        public static final int BEERTAP_SAMPLES_ID_PATH_POSITION = 1;

        /**
         * The content:// style URL for this table
         */
        public static final Uri BEERTAP_CONTENT_URI = Uri.parse(SCHEME + AUTHORITY + PATH_BEERTAP_SAMPLES);

        /**
         * The content URI base for a single beertap sample. Callers must
         * append a numeric beertap sample id to this Uri to retrieve a 
         * beertap sample.
         */
        public static final Uri BEERTAP_CONTENT_ID_URI_BASE = Uri.parse(SCHEME + AUTHORITY + PATH_BEERTAP_SAMPLES_ID);

        /**
         * The content URI match pattern for a single beertap sample, specified by its ID. Use this to match
         * incoming URIs or to construct an Intent.
         */
        public static final Uri BEERTAP_CONTENT_ID_URI_PATTERN = Uri.parse(SCHEME + AUTHORITY + PATH_BEERTAP_SAMPLES + "/#");
		
		/*
		 * MIME-type definitions
		 */
	    /**
	     * The MIME type of {@link #CONTENT_URI_BEERTAP} providing a directory of beertap samples.
	     */
	    public static final String CONTENT_TYPE_BEERTAP = "vnd.android.cursor.dir/vnd.no.uka.sensors.beertap";
	    
	    /**
	     * The MIME type of a {@link #CONTENT_URI_BEERTAP} sub-directory of a single
	     * beertap sample.
	     */
	    public static final String CONTENT_ITEM_BEERTAP = "vnd.android.cursor.item/vnd.no.uka.sensors.beertap";
		
        /*
         * Column definitions
         */

        /**
         * Column name for the id of the sample
         * <P>Type: TEXT</P>
         */
		public static final String ID = "_id";
		
        /**
         * Column name for the sampling time
         * <P>Type: DATETIME</P>
         */
		public static final String DATE = "date";
		
		/**
		 * Column name for the location id
		 * <P>Type: INTEGER</P>
		 */
		public static final String LOCATION_ID = "location_id"; 
		
		/**
		 * Column name for the ...
		 * <P>Type: INTEGER</P>
		 */
		public static final String TAPNR = "tapnr";
		
		/**
		 * Column name for the sample value
		 * <P>Type: FLOAT</P>
		 */
		public static final String VALUE = "value";
	}
}
