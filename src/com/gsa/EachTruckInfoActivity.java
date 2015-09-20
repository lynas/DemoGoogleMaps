package com.gsa;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EachTruckInfoActivity extends BaseActivity {
	Context context;
	
	Button showInMap;
	Button bLastFiveLocation;
	TextView textViewLastUpdateDetailsInfo;
	TextView textViewLocationDetailsInfo;
	TextView textViewLatitudeLongitudeDetails;
	TextView textViewSpeedCourseDetails;
	TextView textViewStatusDetails;
	
	private String truckNameInfo;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.truck_info_page);
		context = EachTruckInfoActivity.this.getApplicationContext();
		
		
		String truckMovingStatus = getIntent().getExtras().getString("TruckStatus");
		truckNameInfo = getIntent().getExtras().getString("TruckName");
		String[] parts = truckMovingStatus.split("-");
		this.setTitle(truckNameInfo);
		
		
		
		showInMap = (Button) findViewById(R.id.buttonShowInMap);
		bLastFiveLocation  = (Button) findViewById(R.id.ButtonLastFiveLocation);
		textViewLastUpdateDetailsInfo = (TextView) findViewById(R.id.textViewLastUpdateDetailsInfo);
		textViewLocationDetailsInfo = (TextView) findViewById(R.id.textViewLocationDetailsInfo);
		textViewLatitudeLongitudeDetails = (TextView) findViewById(R.id.textViewLatitudeLongitudeDetails);
		textViewSpeedCourseDetails = (TextView) findViewById(R.id.textViewSpeedCourseDetails);
		textViewStatusDetails = (TextView) findViewById(R.id.textViewStatusDetails);
		
		
		
		if(parts[0].toLowerCase().trim().equals("stopped")){
			textViewStatusDetails.setTextColor(Color.parseColor("#FF0000"));
		}
		
		
		

		textViewStatusDetails.setText(parts[0]);
		
		
		
		
		showInMap.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, TYTLandingPageActivity.class);
				intent.putExtra("TruckName", ""+truckNameInfo);
				//intent.putExtra("TruckStatus", ""+tv2.getText().toString());
				startActivity(intent);
				
			}
		});
		
		bLastFiveLocation.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, LastFiveLocationActivity.class);
				startActivity(intent);
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		menu.add("Option");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml
		int id = item.getItemId();
		if (id == 0) {
			final CharSequence[] items = { "Log Out","My Location" };

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Option");
			builder.setItems(items, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int item) {
					if(item==0){
						Intent intent = new Intent(getApplicationContext(), MainActivity.class);
						intent.putExtra("EXIT", "logout");
						startActivity(intent);
					}else if(item==1){
						Intent intent = new Intent(getApplicationContext(), MyLocation.class);
						//intent.putExtra("EXIT", "logout");
						startActivity(intent);
					}
				}
			});
			AlertDialog alert = builder.create();
			alert.show();

		}
		return super.onOptionsItemSelected(item);
	}
	
	
}
