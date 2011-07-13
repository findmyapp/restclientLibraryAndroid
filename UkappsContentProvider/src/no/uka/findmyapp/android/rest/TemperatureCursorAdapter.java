package no.uka.findmyapp.android.rest;
//package no.uka.findmyapp.android.rest.library.data;
//
//import no.uka.findmyapp.android.rest.R;
//import no.uka.findmyapp.android.rest.library.data.model.TemperatureMetaData;
//import android.content.Context;
//import android.database.Cursor;
//import android.provider.Contacts.People;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Filterable;
//import android.widget.SimpleCursorAdapter;
//import android.widget.TextView;
//
//public class TemperatureCursorAdapter extends SimpleCursorAdapter implements Filterable {
//
//	    private Context context;
//
//	    private int layout;
//
//	    public TemperatureCursorAdapter (Context context, int layout, Cursor c, String[] from, int[] to) {
//	        super(context, layout, c, from, to);
//	        this.context = context;
//	        this.layout = layout;
//	    }
//
//	    @Override
//	    public View newView(Context context, Cursor cursor, ViewGroup parent) {
//
//	        Cursor c = getCursor();
//
//	        final LayoutInflater inflater = LayoutInflater.from(context);
//	        View v = inflater.inflate(layout, parent, false);
//
//	        int locationCol = c.getColumnIndex(no.uka.findmyapp.android.rest.library.data.providers.TemperatureProvider.location_id);
//	        Float value = c.getFloat(no.uka.findmyapp.android.rest.library.data.providers.TemperatureProvider.location_id);
//	        
//
//	        /**
//	         * Next set the temperature.
//	         */
//	        TextView location_temperature = (TextView) v.findViewById(R.id.location_temperature);
//	        if (location_temperature != null) {
//	            location_temperature.setText("location: " + locationCol + "  temperature: " + value);
//	        }
//
//	        return v;
//	    }
//
//	    @Override
//	    public void bindView(View v, Context context, Cursor c) {
//
//	        int locationCol = c.getColumnIndex(no.uka.findmyapp.android.rest.library.data.providers.TemperatureProvider.location_id);
//
//	        Float value = c.getFloat(no.uka.findmyapp.android.rest.library.data.providers.TemperatureProvider.location_id);
//
//	        /**
//	         * Next set the name of the entry.
//	         */
//	        TextView location_temperature = (TextView) v.findViewById(R.id.location_temperature);
//	        if (location_temperature != null) {
//	            location_temperature.setText(name);
//	        }
//	    }
//
//	    @Override
//	    public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
//	        if (getFilterQueryProvider() != null) { return getFilterQueryProvider().runQuery(constraint); }
//
//	        StringBuilder buffer = null;
//	        String[] args = null;
//	        if (constraint != null) {
//	            buffer = new StringBuilder();
//	            buffer.append("UPPER(");
//	            buffer.append(no.uka.findmyapp.android.rest.library.data.providers.TemperatureProvider.location_id);
//	            buffer.append(") GLOB ?");
//	            args = new String[] { constraint.toString().toUpperCase() + "*" };
//	        }
//
//	        return context.getContentResolver().query(no.uka.findmyapp.android.rest.library.data.providers.TemperatureProvider.location_id, null,
//	                buffer == null ? null : buffer.toString(), args, no.uka.findmyapp.android.rest.library.data.providers.TemperatureProvider.location_id + " ASC");
//	    }
//	}
