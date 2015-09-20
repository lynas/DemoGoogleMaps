package com.gsa;

import java.util.ArrayList;

import com.google.android.gms.maps.CameraUpdateFactory;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListOfMyTruckActivity extends ActionBarActivity {
	Context context;
	private ListView lvMyTruckList;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listofmytruck_activity);
		context = ListOfMyTruckActivity.this.getApplicationContext();
		lvMyTruckList = (ListView) findViewById(R.id.listViewTruckList);
		lvMyTruckList.setAdapter(new MyAdapter(this));
		

		lvMyTruckList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				TextView tv = (TextView) arg1.findViewById(R.id.textViewTruckNameEach);
				TextView tv2 = (TextView) arg1.findViewById(R.id.textViewTruckInfoInEach);
				Intent intent = new Intent(context, EachTruckInfoActivity.class);
				intent.putExtra("TruckName", ""+tv.getText().toString());
				intent.putExtra("TruckStatus", ""+tv2.getText().toString());
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
			final CharSequence[] items = { "Log Out" };

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Option");
			builder.setItems(items, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int item) {
					if(item==0){
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

class MyAdapter extends BaseAdapter{
	ArrayList<SingleRow> list;
	Context context;
	int colorRed = Color.parseColor("#FE2E2E");
	int colorGreen = Color.parseColor("#01DF3A");
	int colorYellow = Color.parseColor("#F7FE2E");
	
	public MyAdapter(Context context){
		this.context = context;
		this.list = new ArrayList<SingleRow>();
		String[] a = {
				"z2062-for VK",
				"zDF-0630",
				"zDF-1301",
				"Demo-TT-S-2875",
				"z2B62-foX VK",
				"zDF-1355",
				"z2095-for VK",
				"z8862-for VK",
				"TT-S-2875",
				"z95-for VK"};
		String[] b = {"100.0 mph, NE (66 deg)",
				"30.0 mph, NE (66 deg)",
				"83.0 mph, WE (42 deg)",
				"Stopped - Reached Destination",
				"55.0 mph, SE (57 deg)",
				"95.0 mph, NE (71 deg)",
				"83.0 mph, WE (42 deg)",
				"Stopped - Taking Gas",
				"45.0 mph, NE (27 deg)",
				"55.0 mph, SE (57 deg)"};
		int idTruck = R.drawable.truck3;
		int[] c = {colorGreen,
				colorYellow,
				colorGreen,
				colorRed,
				colorGreen,
				colorYellow,
				colorGreen,
				colorRed,
				colorGreen,
				colorGreen};
		list.clear();
		for (int i = 0; i < 10; i++) {
			list.add(new SingleRow(a[i], b[i], c[i]));
		}
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View row = inflater.inflate(R.layout.listrow_details, arg2, false);
		TextView truckTitile = (TextView) row.findViewById(R.id.textViewTruckNameEach);
		TextView truckInfo = (TextView) row.findViewById(R.id.textViewTruckInfoInEach);
		TextView image = (TextView) row.findViewById(R.id.textViewIndicatorColor);
		//textViewIndicatorColor
		
		truckTitile.setText(list.get(arg0).getTruckName());
		truckInfo.setText(list.get(arg0).getTruckSmallDescription());
		image.setBackgroundColor(list.get(arg0).getTruckImageId());
		
		return row;
	}
	
}





class SingleRow{
	String truckName;
	String truckSmallDescription;
	int truckImageId;
	public SingleRow(String truckName, String truckSmallDescription,
			int truckImageId) {
		super();
		this.truckName = truckName;
		this.truckSmallDescription = truckSmallDescription;
		this.truckImageId = truckImageId;
	}
	public String getTruckName() {
		return truckName;
	}
	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}
	public String getTruckSmallDescription() {
		return truckSmallDescription;
	}
	public void setTruckSmallDescription(String truckSmallDescription) {
		this.truckSmallDescription = truckSmallDescription;
	}
	public int getTruckImageId() {
		return truckImageId;
	}
	public void setTruckImageId(int truckImageId) {
		this.truckImageId = truckImageId;
	}
	
	
	
	
	
}

























