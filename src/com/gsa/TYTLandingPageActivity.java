package com.gsa;

import java.util.Date;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class TYTLandingPageActivity extends BaseActivity {

	GoogleMap map;
	private final LatLng positionAll = new LatLng(23.7612053, 90.3702735);

	private final LatLng truck1CurrentPosition = new LatLng(23.760125,
			90.372695);
	private final LatLng truck2CurrentPosition = new LatLng(23.758230,
			90.374175);
	private final LatLng truck3CurrentPosition = new LatLng(23.758273,
			90.390044);
	private final LatLng truck4CurrentPosition = new LatLng(23.749860,
			90.393198);
	private final LatLng truck5CurrentPosition = new LatLng(23.748653,
			90.403701);
	private final LatLng truck6CurrentPosition = new LatLng(23.767706,
			90.423045);


	Context context;
	CameraUpdate update;
	
	Date d;
	CharSequence s;
	private String truckNameInfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tyt_landing_page);
		context = TYTLandingPageActivity.this.getApplicationContext();
		d = new Date();
		s = DateFormat.format("EEEE, MMMM d, yyyy ", d.getTime());
		truckNameInfo = getIntent().getExtras().getString("TruckName");


		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();

		//update = CameraUpdateFactory.newLatLngZoom(position1, 9);
		//map.animateCamera(update);

		map.addMarker(new MarkerOptions().position(truck1CurrentPosition)
				.title("z2062-for VK").snippet("100.0 mph, NE (66 deg)")
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.truck3)));
		map.addMarker(new MarkerOptions().position(truck2CurrentPosition)
				.title("TT-S-2875").snippet("30.0 mph, NE (66 deg)")
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.plane)));
		map.addMarker(new MarkerOptions().position(truck3CurrentPosition)
				.title("Demo-TT-S-2875").snippet("83.0 mph, WE (42 deg)")
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.hel)));
		map.addMarker(new MarkerOptions().position(truck4CurrentPosition)
				.title("zDF-0630").snippet("Stopped")
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.car)));
		map.addMarker(new MarkerOptions().position(truck5CurrentPosition)
				.title("zDF-1301").snippet("55.0 mph, SE (57 deg)")
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.truck3)));
		map.addMarker(new MarkerOptions().position(truck6CurrentPosition)
				.title("z2095-for VK").snippet("55.0 mph, SE (57 deg)")
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.truck3)));
		
		
		if(truckNameInfo.trim().equals("z2062-for VK")){
			update = CameraUpdateFactory.newLatLngZoom(truck1CurrentPosition, 16);
			map.animateCamera(update);
			
		}else if(truckNameInfo.trim().equals("zDF-0630")){
			update = CameraUpdateFactory.newLatLngZoom(truck6CurrentPosition, 16);
			map.animateCamera(update);
			
		}else{
			update = CameraUpdateFactory.newLatLngZoom(truck4CurrentPosition, 15);
			map.animateCamera(update);
			
		}

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
			final CharSequence[] items = { "Last 5 Location", "Log Out" };

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Option");
			builder.setItems(items, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int item) {
					if(item==0){
						update = CameraUpdateFactory.newLatLngZoom(positionAll, 9);
						map.animateCamera(update);
					}else{
						Intent intent = new Intent(getApplicationContext(), MainActivity.class);
						intent.putExtra("EXIT", "logout");
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

/*
 * float HUE_AZURE float HUE_BLUE float HUE_CYAN float HUE_GREEN float
 * HUE_MAGENTA float HUE_ORANGE float HUE_RED float HUE_ROSE float HUE_VIOLET
 * float HUE_YELLOW
 */
