package com.gsa;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.gsa.util.L;

public class MapRefreshSettingsActivity extends BaseActivity {
	ListView listViewMapSetting;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_refresh_settings_layout);

		listViewMapSetting = (ListView) findViewById(R.id.listViewMapRefreshList);
		listViewMapSetting.setAdapter(new MapSettingApapter(MapRefreshSettingsActivity.this));

		listViewMapSetting.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int arg2,
					long arg3) {

				TextView tv = (TextView) view
						.findViewById(R.id.textViewMapRefreshName);
				/*L.t(IconSettingsActivity.this, tv.getText().toString()
						+ " Has been Selected");*/

				new AlertDialog.Builder(MapRefreshSettingsActivity.this)
						.setTitle("Info").setMessage(tv.getText().toString()+ " Has been Selected")
						.setNeutralButton("OK", null)
						.setIcon(R.drawable.info).show();
				TextView tv2 = (TextView) view
						.findViewById(R.id.textViewMapRefreshStatus);
				tv2.setText("Active");
				
				
				/*
				 * new AlertDialog.Builder(this) .setTitle("Delete entry")
				 * .setMessage("Are you sure you want to delete this entry?")
				 * .setPositiveButton(android.R.string.yes, new
				 * DialogInterface.OnClickListener() { public void
				 * onClick(DialogInterface dialog, int which) { // continue with
				 * delete } }) .setNegativeButton(android.R.string.no, new
				 * DialogInterface.OnClickListener() { public void
				 * onClick(DialogInterface dialog, int which) { // do nothing }
				 * }) .setIcon(android.R.drawable.ic_dialog_alert) .show();
				 */

				/*
				 * TextView tv = (TextView)
				 * arg1.findViewById(R.id.textViewTruckNameEach); TextView tv2 =
				 * (TextView) arg1.findViewById(R.id.textViewTruckInfoInEach);
				 * Intent intent = new Intent(context,
				 * EachTruckInfoActivity.class); intent.putExtra("TruckName",
				 * ""+tv.getText().toString()); intent.putExtra("TruckStatus",
				 * ""+tv2.getText().toString()); startActivity(intent);
				 */

			}
		});

	}

}

class MapSettingApapter extends BaseAdapter {
	List<SingleMapSettingRow> list;
	Context context;

	public MapSettingApapter(Context context) {
		this.context = context;
		this.list = new ArrayList<SingleMapSettingRow>();
		String[] name = { 
				"Refresh Map Manually", 
				"Refresh Map Automatically Every 15 seconds", 
				"Refresh Map Automatically Every 30 seconds", 
				"Refresh Map Automatically Every 60 seconds", 
				};
		for (int i = 0; i < 4; i++) {
			list.add(new SingleMapSettingRow(name[i]));
		}
	}

	@Override
	public int getCount() {

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
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.map_refresh_settings_item_each, arg2,
				false);
		ImageView image = (ImageView) row
				.findViewById(R.id.imageViewMapRefreshImage);
		TextView name = (TextView) row
				.findViewById(R.id.textViewMapRefreshName);

		image.setImageResource(R.drawable.map);
		name.setText(list.get(arg0).getIconName());
		return row;
	}

}

class SingleMapSettingRow {
	String iconName;

	public SingleMapSettingRow() {
	}

	public SingleMapSettingRow(String iconName) {
		super();
		this.iconName = iconName;
	}

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	

}
