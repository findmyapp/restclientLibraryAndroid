package no.uka.findmyapp.android.demo;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

import no.uka.findmyapp.android.rest.R;
import no.uka.findmyapp.android.rest.client.HttpType;
import no.uka.findmyapp.android.rest.client.RestServiceHelper;
import no.uka.findmyapp.android.rest.client.ServiceDataFormat;
import no.uka.findmyapp.android.rest.client.model.ServiceModel;
import no.uka.findmyapp.android.rest.datamodels.Temperature;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UkappsRestClientDemoActivity extends Activity {
	private static RestServiceHelper serviceHelper = RestServiceHelper.getInstance(); 
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ServiceModel serviceModel;
		try {
			serviceModel = new ServiceModel(
					new URI("http://10.0.2.2:8080/findmyapp/locations/1/temperature/latest"),
					HttpType.GET, 
					ServiceDataFormat.JSON, new TypeToken<Temperature>(){}.getType(),  BroadcastTokens.BROADCAST_INTENT_TOKEN);
			

	        ReciveIntent intentReceiver = new ReciveIntent();
			IntentFilter intentFilter = new IntentFilter(BroadcastTokens.BROADCAST_INTENT_TOKEN);

			registerReceiver(intentReceiver, intentFilter); 
			serviceHelper.startServiceTest(this, serviceModel); 
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    public class ReciveIntent extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {

			Log.w("BroadcastIntentDebug", "---------");
			//TextView tv = (TextView) findViewById(R.id.debugResult);
			Gson gson = new Gson(); 
			if (intent.getAction().equals(BroadcastTokens.BROADCAST_INTENT_TOKEN)) {
				Serializable obj = intent.getSerializableExtra("return");
				//gson.toJson(obj);
				Temperature t = (Temperature) obj;
				//tv.setText(t.toString()); 
				Log.w("BroadcastIntentDebug", t.toString());
			}
		}
	}
}

