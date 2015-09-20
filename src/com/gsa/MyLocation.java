package com.gsa;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.gsa.util.MyService;

public class MyLocation extends ActionBarActivity {

	Context context;
	TextView tvMyLat;
	TextView tvMyLng;
	TextView tvInfoPosition;
	
	ArrayList<LatLng> vertices = new ArrayList<LatLng>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_location);

		context = MyLocation.this.getApplicationContext();

		tvMyLat = (TextView) findViewById(R.id.textViewMyLat);
		tvMyLng = (TextView) findViewById(R.id.textViewMyLng);
		tvInfoPosition = (TextView) findViewById(R.id.textViewInfoPosition);

		
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		LocationListener locationListener = new MyLocationListener();

		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,
				0, locationListener);

		vertices.add(new LatLng(23.761758, 90.370882));
		vertices.add(new LatLng(23.761885, 90.371097));
		vertices.add(new LatLng(23.761468, 90.370960));
		vertices.add(new LatLng(23.761657, 90.371295));
		vertices.add(new LatLng(23.761362, 90.370703));

		

	}

	private class MyLocationListener implements LocationListener {

		LatLng myPosition;

		@Override
		public void onLocationChanged(Location location) {
			tvMyLat.setText("" + location.getLatitude());
			tvMyLng.setText("" + location.getLongitude());
			myPosition = new LatLng(location.getLatitude(),
					location.getLongitude());
			if (isPointInPolygon(myPosition, vertices)) {
				tvInfoPosition.setText("You Are in there");
			} else {
				tvInfoPosition.setText("Not there yet");
			}
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub

		}

		private boolean isPointInPolygon(LatLng tap, ArrayList<LatLng> vertices) {
			int intersectCount = 0;
			for (int j = 0; j < vertices.size() - 1; j++) {
				if (rayCastIntersect(tap, vertices.get(j), vertices.get(j + 1))) {
					intersectCount++;
				}
			}

			return ((intersectCount % 2) == 1); // odd = inside, even = outside;
		}

		private boolean rayCastIntersect(LatLng tap, LatLng vertA, LatLng vertB) {

			double aY = vertA.latitude;
			double bY = vertB.latitude;
			double aX = vertA.longitude;
			double bX = vertB.longitude;
			double pY = tap.latitude;
			double pX = tap.longitude;

			if ((aY > pY && bY > pY) || (aY < pY && bY < pY)
					|| (aX < pX && bX < pX)) {
				return false; // a and b can't both be above or below pt.y, and
								// a or
								// b must be east of pt.x
			}

			double m = (aY - bY) / (aX - bX); // Rise over run
			double bee = (-aX) * m + aY; // y = mx + b
			double x = (pY - bee) / m; // algebra is neat!

			return x > pX;
		}

	}

}
