package com.gsa;

import java.util.ArrayList;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;
import com.gsa.util.L;
import com.gsa.util.MyService;

public class MainActivity extends ActionBarActivity {
	
	Button login;
	EditText etUserName;
	EditText etPassword;
	Context context;
	
	
	Button bStartService;
	Button bStopService;
	Button bShowNotification;
	Button navigationDrawer;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		context = MainActivity.this.getApplicationContext();
		login = (Button) findViewById(R.id.buttonLogin);
		etUserName = (EditText) findViewById(R.id.editTextUserName);
		etPassword = (EditText) findViewById(R.id.editTextPassword);
		/*final String outStat = getIntent().getExtras().getString("EXIT").toString();
		if (outStat.equals("logout")) {
			etUserName.setText("");
			etPassword.setText("");
		}*/
		
		
		
		
		
		
		//L.m(""+isPointInPolygon(p1,vertices));
		
		
		
		
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(etUserName.getText().toString().toLowerCase().equals("admin") && etPassword.getText().toString().toLowerCase().equals("123")){
					Intent intentLandingPage = new Intent(context, ListOfMyTruckActivity.class);
					startActivity(intentLandingPage);
				}else{
					L.t(context, "Wrong username or password");
				}
				
			}
		});
		
		
		
		
		bStartService = (Button) findViewById(R.id.buttonServiceStart);
		bStopService = (Button) findViewById(R.id.buttonServiceStopped);
		bShowNotification = (Button) findViewById(R.id.buttonShowNotification);
		
		
		bStartService.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent i = new Intent(MainActivity.this, MyService.class);
				startService(i);
				L.m("Start clicked");

			}
		});
		bStopService.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(MainActivity.this, MyService.class);
				stopService(i);
				L.m("End clicked");
				
				//L.t(MainActivity.this, "button working");
			}
		});
		
		
		bShowNotification.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				L.m("working");
				NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
				builder.setAutoCancel(true);
				builder.setContentTitle("Title");
				builder.setContentText("text");
				builder.setSmallIcon(R.drawable.ic_launcher);
				
				Notification notification = builder.build();
				NotificationManager manager = (NotificationManager) MainActivity.this.getSystemService(NOTIFICATION_SERVICE);
				manager.notify(8,notification);
			}
		});

		navigationDrawer = (Button) findViewById(R.id.buttonNavigationDrawer);
		
		navigationDrawer.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, TestActivity.class);
				startActivity(intent);
			}
		});
		
		
	}
	@Override
	public void onBackPressed() {
	    finish();
	}
	
	
	

	
	
	
}
